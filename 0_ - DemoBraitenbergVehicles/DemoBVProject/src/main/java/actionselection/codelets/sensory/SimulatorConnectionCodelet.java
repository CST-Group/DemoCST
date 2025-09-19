package actionselection.codelets.sensory;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.exceptions.CodeletActivationBoundsException;
import co.nstant.in.cbor.CborException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import remoteapi.zmq.*;

public class SimulatorConnectionCodelet extends Codelet {

    
    private Memory StepMO;
    private Memory PositionsMO;
    RemoteAPIObjects._sim sim;
    Long visionLeftSensorHandle;
    Long visionRightSensorHandle;
    Long lightHandle;
    Integer lastStep = -1;
    
    public SimulatorConnectionCodelet(RemoteAPIObjects._sim sim){
        this.sim = sim;
        try {
            this.configSimulator();
        } catch (IOException ex) {
            Logger.getLogger(SimulatorConnectionCodelet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CborException ex) {
            Logger.getLogger(SimulatorConnectionCodelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void configSimulator()  throws java.io.IOException, co.nstant.in.cbor.CborException  {
        visionLeftSensorHandle = sim.getObject("./Vision_sensor_left");
        visionRightSensorHandle = sim.getObject("./Vision_sensor_right");
        lightHandle = sim.getObject("/O_Light");
        sim.setStepping(true);
        sim.startSimulation();
    }

    @Override
    public void accessMemoryObjects() {
        
        StepMO = getInput("StepMO");
        
        PositionsMO = getOutput("PositionsMO");
    }

    @Override
    public void calculateActivation() {
        Integer currentStep = (Integer) StepMO.getI();
        
        try {
            if (currentStep > this.lastStep) {
                setActivation(1);
            } else {
                setActivation(0);
            }
        } catch (CodeletActivationBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void proc()  {
        try {
            this.getData();
        } catch (IOException ex) {
            Logger.getLogger(SimulatorConnectionCodelet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CborException ex) {
            Logger.getLogger(SimulatorConnectionCodelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getData() throws java.io.IOException, co.nstant.in.cbor.CborException {
        List<Double> lightPosition = sim.getObjectPosition(lightHandle, sim.handle_world);
        List<Double> visionLeftSensorPosition = sim.getObjectPosition(visionLeftSensorHandle, sim.handle_world);
        List<Double> visionRightSensorPosition = sim.getObjectPosition(visionRightSensorHandle, sim.handle_world);
        
        List<List<Double>> allPositions = Arrays.asList(lightPosition, visionLeftSensorPosition, visionRightSensorPosition);
        PositionsMO.setI(allPositions);
    }
}
