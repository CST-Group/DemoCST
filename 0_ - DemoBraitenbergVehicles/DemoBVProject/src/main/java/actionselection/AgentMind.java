package actionselection;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.util.viewer.MindViewer;

import actionselection.codelets.sensory.SimulatorConnectionCodelet;
import actionselection.codelets.sensory.LightSensorCodelet;
import actionselection.codelets.cognition.ActionSelectionCodelet;
import actionselection.codelets.motor.WheelActuatorCodelet;
import java.util.ArrayList;
import remoteapi.zmq.RemoteAPIObjects._sim;

public class AgentMind extends Mind {
    public ArrayList<Codelet> codelets = new ArrayList<Codelet>();

    public AgentMind(_sim sim) {
        super();

        // Codelets Groups declarations
        createCodeletGroup("Sensory");
        createCodeletGroup("Cognition");
        createCodeletGroup("Motor");

        // Memory Groups declarations
        createMemoryGroup("SensorInput");
        createMemoryGroup("Motor");
        createMemoryGroup("Global");

        // Memory Objects
        Memory stepMO;
        Memory positionsMO;
        Memory lightIntensityMO;
        Memory wheelsVelocityMO;
        Memory memoryThree;

        // Memories initialization
        stepMO = createMemoryObject("StepMO");
        stepMO.setI(0);
        registerMemory(stepMO, "SensorInput");
        positionsMO = createMemoryObject("positionsMO");
        registerMemory(positionsMO, "SensorInput");
        lightIntensityMO = createMemoryObject("lightIntensityMO");
        registerMemory(lightIntensityMO, "SensorInput");
        wheelsVelocityMO = createMemoryObject("wheelsVelocityMO");
        registerMemory(wheelsVelocityMO, "Motor");
        memoryThree = createMemoryObject("memoryThree");
        registerMemory(memoryThree, "Global");

        // Codelets initializations

        Codelet simulatorConnectionCodelet = new SimulatorConnectionCodelet(sim);
        simulatorConnectionCodelet.addInput(stepMO);
        simulatorConnectionCodelet.addOutput(positionsMO);
        simulatorConnectionCodelet.addBroadcast(memoryThree);
        insertCodelet(simulatorConnectionCodelet);
        registerCodelet(simulatorConnectionCodelet, "Sensory");
        codelets.add(simulatorConnectionCodelet);

        Codelet lightSensorCodelet = new LightSensorCodelet();
        lightSensorCodelet.addInput(positionsMO);
        lightSensorCodelet.addOutput(lightIntensityMO);
        lightSensorCodelet.addBroadcast(memoryThree);
        insertCodelet(lightSensorCodelet);
        registerCodelet(lightSensorCodelet, "Sensory");
        codelets.add(lightSensorCodelet);

        Codelet actionSelectionCodelet = new ActionSelectionCodelet();
        actionSelectionCodelet.addInput(lightIntensityMO);
        actionSelectionCodelet.addOutput(wheelsVelocityMO);
        actionSelectionCodelet.addBroadcast(memoryThree);
        insertCodelet(actionSelectionCodelet);
        registerCodelet(actionSelectionCodelet, "Cognition");
        codelets.add(actionSelectionCodelet);

        Codelet wheelActuatorCodelet = new WheelActuatorCodelet(sim);
        wheelActuatorCodelet.addInput(wheelsVelocityMO);
        wheelActuatorCodelet.addOutput(stepMO);
        wheelActuatorCodelet.addBroadcast(memoryThree);
        insertCodelet(wheelActuatorCodelet);
        registerCodelet(wheelActuatorCodelet, "Motor");
        codelets.add(wheelActuatorCodelet);
        
        
        lightSensorCodelet.setPublishSubscribe(true);
        actionSelectionCodelet.setPublishSubscribe(true);
        wheelActuatorCodelet.setPublishSubscribe(true);
        simulatorConnectionCodelet.setTimeStep(200);
        

        start();
    }
}
