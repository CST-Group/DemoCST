/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codelets.decision;

import br.unicamp.cst.bindings.soar.JSoarCodelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import java.io.File;
import support.Constants;

/**
 *
 * @author karenlima
 */
public class SoarCodelet extends JSoarCodelet {
    
    private Memory inputLinkIdeaMO;
    private Idea inputLinkIdea;
    private Memory outputLinkIdeaMO;
    private Idea outputLinkIdea;
    
    
    public SoarCodelet(String agentName, File productionPath, Boolean startSOARDebugger) {
        initSoarPlugin(agentName, productionPath, startSOARDebugger);
        this.name = "SoarCodelet";
    }

    @Override
    public void accessMemoryObjects() {
        inputLinkIdeaMO=(MemoryObject)this.getInput(Constants.INPUT_LINK_MO);
        inputLinkIdea = (Idea) inputLinkIdeaMO.getI();
        
        outputLinkIdeaMO=(MemoryObject)this.getOutput(Constants.OUTPUT_LINK_MO);
        outputLinkIdea = (Idea) outputLinkIdeaMO.getI();
                
    }

    @Override
    public void calculateActivation() {
    }

    @Override
    public void proc() {
        if (inputLinkIdea.getL().isEmpty()){
            return;
        }
        setInputLinkIdea(inputLinkIdea);
        if (getDebugState() == 0) {
            getJsoar().step();
        }
        
        Idea soarOutputLink = getJsoar().getOutputLinkIdea();
        outputLinkIdea.setValue(soarOutputLink.getValue());
        outputLinkIdea.setL(soarOutputLink.getL());
        outputLinkIdeaMO.setI(outputLinkIdea);
    }
}
