package actionselection.codelets.motor;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import co.nstant.in.cbor.CborException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import remoteapi.zmq.RemoteAPIObjects._sim;

public class WheelActuatorCodelet extends Codelet {

    
    private Memory WheelsVelocityMO;
    private Memory StepMO;
    Long motorLeft;
    Long motorRight;
    _sim sim;
    
    public WheelActuatorCodelet(_sim sim) {
        this.sim = sim;
        try {
            this.getMotor();
        } catch (CborException ex) {
            Logger.getLogger(WheelActuatorCodelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getMotor() throws CborException {
        motorLeft = sim.getObject("/leftMotor");
        motorRight = sim.getObject("/rightMotor");
    }

    @Override
    public void accessMemoryObjects() {
        
        WheelsVelocityMO = getInput("WheelsVelocityMO");
        
        StepMO = getOutput("StepMO");
    }

    @Override
    public void calculateActivation() {

    }

    @Override
    public void proc() {
        List<Double> wheelsVelocity = (List<Double>) WheelsVelocityMO.getI();
        Double vLeft = wheelsVelocity.get(0); 
        Double vRight = wheelsVelocity.get(1); 
        
        try {
            setWheelsVelocity(vLeft, vRight);
            sim.step();
        } catch (CborException ex) {
            Logger.getLogger(WheelActuatorCodelet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer currentStep = (Integer) StepMO.getI();
        StepMO.setI(currentStep+1);
    }
    
    private void setWheelsVelocity(Double vLeft, Double vRight) throws CborException {
        sim.setJointTargetVelocity(motorLeft, vLeft);
        sim.setJointTargetVelocity(motorRight,vRight);
    }
}
