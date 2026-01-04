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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ws3dproxy.model.Thing;

public class IntensityToVelocity extends Codelet {

	private Memory fontsIntensityMO;
	private Memory innerSenseMO;
	private Memory wheelsVelocityMO;
        Idea cis;
        Idea fontsIntensityIdea;
        double vDefault = 1.5;
        double vLeft;
        double vRight;
	public IntensityToVelocity() {
            setTimeStep(50);
            this.name = "IntensityToVelocity";
            vLeft = vDefault;
            vRight = vDefault;
	}

	@Override
	public void accessMemoryObjects() {
            fontsIntensityMO=(MemoryObject)this.getInput("FONTS_INTENSITY");
            innerSenseMO=(MemoryObject)this.getInput("INNER");
            wheelsVelocityMO=(MemoryObject)this.getOutput("WHEELS_VELOCITY");
	}

	@Override
	public void proc() {
                fontsIntensityIdea = (Idea) fontsIntensityMO.getI();
                cis = (Idea) innerSenseMO.getI();
                
		//Transform the intensity to velocity acceleration or stopping
		if(fontsIntensityIdea != null) {
                    vLeft = vDefault;
                    vRight = vDefault;
                    double fator =0.15;
                    List<Idea> fontsIntensityList = fontsIntensityIdea.getL();
                    if(fontsIntensityList != null){
                        CopyOnWriteArrayList<Idea> fontsIntensityListCopy = new CopyOnWriteArrayList<>(fontsIntensityList); 
                        for(Idea fontIntensity : fontsIntensityListCopy) {
                            String fontType = fontIntensity.getName();
                            double rightSensorIntensity = (double) ((Idea) fontIntensity.get("right")).getValue();
                            double leftSensorIntensity = (double) ((Idea) fontIntensity.get("left")).getValue();
                            switch (fontType) {
                                case "foodSensorIntensityIdea":
//                                    fator = 10.0;
                                    vRight -= (rightSensorIntensity * fator); 
                                    vLeft -= (leftSensorIntensity * fator);
                                    break;
                                case "brickSensorIntensityIdea":
//                                    fator = 10.0;
                                    vRight -= (leftSensorIntensity * fator); 
                                    vLeft -= (rightSensorIntensity * fator);
                                    break;
                                case "greenJewelSensorIntensityIdea":
//                                    fator = 10.0;
                                    vRight += fator * leftSensorIntensity; 
                                    vLeft += fator * rightSensorIntensity;
                                    break;
                                case "yellowJewelSensorIntensityIdea":
//                                    fator = 10.01;
                                    vRight += fator * rightSensorIntensity; 
                                    vLeft += fator * leftSensorIntensity;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        }
                    }
                }
                
                vRight = Double.max(vRight, 0.0);
                vLeft = Double.max(vLeft, 0.0);
                vRight = Double.min(vRight, 3.0);
                vLeft = Double.min(vLeft, 3.0);
                Idea wheelsVelocityIdea = (Idea) wheelsVelocityMO.getI();
                wheelsVelocityIdea.get("VRight").setValue(vRight);
                wheelsVelocityIdea.get("VLeft").setValue(vLeft);
                wheelsVelocityMO.setI(wheelsVelocityIdea);
        }
        
        @Override
        public void calculateActivation() {
        
        }
}
