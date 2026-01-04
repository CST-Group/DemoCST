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

import java.awt.Point;
import java.awt.geom.Point2D;

import org.json.JSONException;
import org.json.JSONObject;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ws3dproxy.model.Thing;

public class VelocityToNextPosition extends Codelet {

	private Memory wheelsVelocityMO;
	private Memory innerSenseMO;
	private Memory legsMO;
        Idea cis;
        Idea wheelsVelocityIdea;
        double vDefault = 1.0;
        double vLeft;
        double vRight;
	public VelocityToNextPosition() {
            setTimeStep(50);
            this.name = "VelocityToNextPosition";
            vLeft = vDefault;
            vRight = vDefault;
	}

	@Override
	public void accessMemoryObjects() {
            wheelsVelocityMO=(MemoryObject)this.getInput("WHEELS_VELOCITY");
            innerSenseMO=(MemoryObject)this.getInput("INNER");
            legsMO=(MemoryObject)this.getOutput("LEGS");
	}

	@Override
	public void proc() {
            wheelsVelocityIdea = (Idea) wheelsVelocityMO.getI();
            cis = (Idea) innerSenseMO.getI();

            //Transform the velocity to next creature position
            if(wheelsVelocityIdea != null) {
                vRight = (double) wheelsVelocityIdea.get("VRight").getValue();
                vLeft = (double) wheelsVelocityIdea.get("VLeft").getValue();
                velocityToPosition(vRight, vLeft);
            }
        }
        
        @Override
        public void calculateActivation() {
        
        }
        
        public void velocityToPosition(double vRight, double vLeft){
            double nextX = 0.0;
            double nextY = 0.0;
            double nextSpeed = 0.0;
            double D = 20 / Math.PI;
            double pRad = Math.toRadians((double)cis.get("pitch").getValue());
            double friction = 0.1;
            double aux = (1 - friction);
            double w = (vLeft - vRight) / D; //clockwise is positive
            double cosp, senp, a, cosWP, senWP;
            double creatureX = (double)cis.get("position.x").getValue();
            double creatureY = (double)cis.get("position.y").getValue();
            double dt = 10.0;
            
            //cosp = Math.cos(-pRad); //counterclockwise is negative
            //senp = Math.sin(-pRad);
            cosp = Math.cos(-pRad); //counterclockwise is negative
            senp = Math.sin(-pRad);
            
            nextSpeed = (vRight + vLeft) / 2;
            nextX = creatureX + (nextSpeed * Math.cos(pRad)*dt);
            nextY = creatureY - (nextSpeed * Math.sin(pRad)*dt);
            
//            if (Math.abs(vLeft-vRight) < 0.01) {
//                System.out.println("Same velocity in wheels");
//                //System.out.println("...............................1st and speed= " + c.getSpeed());
//                //a = aux * (c.getVleft() + c.getVright()) / 2;
//                //a = aux * nextSpeed;
//
//                //nextX = creatureX + a * cosp;
//                //nextY = creatureY - a * senp;
//                
//            } else {
//                a = aux * (D / 2) * ((vLeft + vRight) / (vLeft - vRight));
//                senWP = Math.sin(w - pRad);
//                cosWP = Math.cos(w - pRad);
//
//                nextX = creatureX + a * (senWP + Math.sin(pRad));
//                nextY = creatureY - a * (cosWP - Math.cos(pRad));
//            }
            
            System.out.println("CreatureX: " + creatureX + "CreatureY: "+ creatureY + "Pitch: " + pRad+ "VRight: " + vRight+ "NextX: " + nextX + "NextY: "+ nextY);
            JSONObject message=new JSONObject();
            try {
                message.put("ACTION", "GOTO");
                message.put("X", (int)nextX);
                message.put("Y", (int)nextY);
                message.put("SPEED", (int)nextSpeed);
                legsMO.setI(message.toString());
            } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }

}
