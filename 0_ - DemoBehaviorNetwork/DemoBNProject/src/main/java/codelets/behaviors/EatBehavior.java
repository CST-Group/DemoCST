/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codelets.behaviors;

import br.unicamp.cst.behavior.bn.Behavior;
import br.unicamp.cst.behavior.bn.GlobalVariables;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.memory.WorkingStorage;
import br.unicamp.cst.util.viewer.Inspectable;
import support.BehaviorCustomView;

/**
 *
 * @author karenlima
 */
public class EatBehavior extends Behavior implements Inspectable {
    
    private Memory chosenBehaviorsMO;
    BehaviorCustomView behaviorCustomView;
    
    public EatBehavior(WorkingStorage ws,GlobalVariables globalVariables) {
        super(ws, globalVariables); 
        behaviorCustomView = new BehaviorCustomView("Eat Behavior");
    }
    
    @Override
    public void proc() {
        super.proc();
        updateBehaviorCustomView();
    }
    
    private void updateBehaviorCustomView() {
        behaviorCustomView.updateInputFromGoals(this.getInputfromgoals());
        behaviorCustomView.updateInputFromState(this.getInputfromstate());
        behaviorCustomView.updateSpreadBw(this.getSpreadbw());
        behaviorCustomView.updateSpreadFw(this.getSpreadfw());
        behaviorCustomView.updateActivation(this.getActivation());
        behaviorCustomView.updateActivationWhenActive(this.getActivationWhenActive());
        behaviorCustomView.updateExecutable(this.isExecutable());
        behaviorCustomView.updateIsActive(this.isActive());
    }

    @Override
    public void operation() {
        chosenBehaviorsMO.setI("EAT_COMPETENCE");	
    }

    @Override
    public void accessMemoryObjects() {
        chosenBehaviorsMO = (MemoryObject)this.getOutput("CHOSEN_BEHAVIOR");
    }

    @Override
    public void calculateActivation() {

    }

    @Override
    public void inspect() {
        behaviorCustomView.setVisible(true);
    }
    
}
