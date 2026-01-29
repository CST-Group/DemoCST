/*****************************************************************************
 * Copyright 2007-2015 DCA-FEEC-UNICAMP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Contributors:
 *    Klaus Raizer, Andre Paraense, Ricardo Ribeiro Gudwin
 *****************************************************************************/

package codelets.behaviors;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryContainer;
import br.unicamp.cst.core.entities.MemoryObject;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import static support.Constants.*;
import ws3dproxy.model.Thing;

/** 
 * 
 * @author klaus
 * 
 * 
 */

public class Explore extends Codelet {
    
        private Memory knownMO;
        private List<Thing> known;
        private MemoryContainer legsMO;


	/**
	 * Default constructor
	 */
	public Explore(){
            this.name = "Explore";
	}

	@Override
	public void proc() {
            System.out.println("Executing proc explore");
            known = (List<Thing>) knownMO.getI();
            if (known.size() == 0) {
                activation=1.0;
            }
            else activation=0.0;
            JSONObject message=new JSONObject();
            message.put(ACTION, EXPLORE);
            if(legsMO.getI() == message.toString() &&  legsMO.getEvaluation() == activation) {
                System.out.println("Nothing changed explore");
            } else {
                legsMO.setI(message.toString(),activation,name);		
            }
            
	}

	@Override
	public void accessMemoryObjects() {
            knownMO = (MemoryObject)this.getInput(KNOWN_APPLES);
            legsMO = (MemoryContainer)this.getOutput(LEGS);
	}
        
        @Override
        public void calculateActivation() {
            
        }


}
