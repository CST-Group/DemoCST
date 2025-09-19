/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import br.unicamp.cst.bindings.soar.JSoarCodelet;
import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.representation.idea.Idea;
import codelets.behaviors.ActionSelection;
import codelets.motor.HandsActionCodelet;
import codelets.motor.LegsActionCodelet;
import codelets.perception.SoarInputLinkGenerator;
import codelets.decision.SoarCodelet;
import codelets.sensors.Vision;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static support.Constants.*;
import support.NativeUtils;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

/**
 *
 * @author karenlima
 */
public class AgentMindJSoar extends Mind {
    
    
    public ArrayList<Codelet> behavioralCodelets = new ArrayList<>();
    
    public JSoarCodelet jSoarCodelet = null;
    public Idea inputLinkIdea;
    public Idea outputLinkIdea;
    
    public AgentMindJSoar(Creature creature, String name) {
        super();
        
        inputLinkIdea = new Idea(INPUT_LINK_IDEA+creature.getName());
        outputLinkIdea = new Idea(OUTPUT_LINK_IDEA+creature.getName());
    
        createCodeletGroup(SENSORY);
        createCodeletGroup(PERCEPTION);
        createCodeletGroup(PLANNING);
        createCodeletGroup(BEHAVIORAL);
        createCodeletGroup(MOTOR);
        createMemoryGroup(SENSORY);
        createMemoryGroup(PERCEPTION);
        createMemoryGroup(PLANNING);
        createMemoryGroup(BEHAVIORAL);
        createMemoryGroup(MOTOR);
        
        // Declare Memory Objects
        Memory visionMO;
        Memory inputLinkMO;
        Memory outputLinkMO;
        Memory legsMO; 
        Memory handsMO;
        
        List<Thing> vision_list = Collections.synchronizedList(new ArrayList<>());
        visionMO=createMemoryObject(VISION_MO,vision_list);
        registerMemory(visionMO,SENSORY);
        
        inputLinkMO=createMemoryObject(INPUT_LINK_MO, inputLinkIdea);
        registerMemory(inputLinkMO,PLANNING);
        
        outputLinkMO=createMemoryObject(OUTPUT_LINK_MO, outputLinkIdea);
        registerMemory(outputLinkMO,BEHAVIORAL);
        
        legsMO=createMemoryContainer(LEGS);
   
        registerMemory(legsMO, MOTOR);
        
        handsMO=createMemoryObject(HANDS, "");
        registerMemory(handsMO,MOTOR);
        
        // Create Vision Codelet
        Codelet visionCodelet = new Vision(creature);
        visionCodelet.addOutput(visionMO);
        insertCodelet(visionCodelet); 
        registerCodelet(visionCodelet,SENSORY);
        
        // Create Perception Codelet
        Codelet perceptionCodelet = new SoarInputLinkGenerator(creature);
        perceptionCodelet.addInput(visionMO);
        perceptionCodelet.addOutput(inputLinkMO);
        insertCodelet(perceptionCodelet); 
        registerCodelet(perceptionCodelet,PERCEPTION);        
        
        // Create Planning Codelet
        try {
            NativeUtils.loadFileFromJar(SOAR_FILE_RULES_PATH);
        } catch (IOException ex) {
            Logger.getLogger(AgentMindJSoar.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSoarCodelet soarCodelet = new SoarCodelet(creature.getName(), new File(SOAR_RULES_PATH), false);
        soarCodelet.addInput(inputLinkMO);
        soarCodelet.addOutput(outputLinkMO);
        insertCodelet(soarCodelet); 
        registerCodelet(soarCodelet,PLANNING);
        jSoarCodelet = soarCodelet;
        
        // Create Action Selection Codelet
        Codelet actionSelection=new ActionSelection(creature, 600, 800);
        actionSelection.addInput(outputLinkMO);
        actionSelection.addOutput(legsMO);
        actionSelection.addOutput(handsMO);
        insertCodelet(actionSelection);
        registerCodelet(actionSelection,BEHAVIORAL);
        
        // Create Motor Codelets
        Codelet legs=new LegsActionCodelet(creature);
        legs.addInput(legsMO);
        insertCodelet(legs);
        registerCodelet(legs,MOTOR);

        Codelet hands=new HandsActionCodelet(creature);
        hands.addInput(handsMO);
        insertCodelet(hands);
        registerCodelet(hands,MOTOR);
        
        // sets a time step for running the codelets to avoid heating too much your machine
        for (Codelet c : this.getCodeRack().getAllCodelets())
            c.setTimeStep(200);
        
        start(); 
    }
}
