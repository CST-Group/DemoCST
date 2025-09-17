/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bn.codelets.behaviors;

import br.unicamp.cst.behavior.bn.Behavior;
import br.unicamp.cst.behavior.bn.GlobalVariables;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.memory.WorkingStorage;

/**
 *
 * @author karenlima
 */
public class ForageFoodBehavior extends Behavior {
    
    private Memory chosenBehaviorsMO;
    
    public ForageFoodBehavior(WorkingStorage ws,GlobalVariables globalVariables) {
        super(ws, globalVariables); 
    }

    @Override
    public void operation() {
        chosenBehaviorsMO.setI("FORAGE_FOOD_COMPETENCE");
        
    }

    @Override
    public void accessMemoryObjects() {
        chosenBehaviorsMO = (MemoryObject)this.getOutput("CHOSEN_BEHAVIOR");
    }

    @Override
    public void calculateActivation() {

    }
    
}
