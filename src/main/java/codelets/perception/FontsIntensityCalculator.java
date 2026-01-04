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

package codelets.perception;



import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import static java.lang.Math.max;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ws3dproxy.model.Thing;

/**
 * @author klaus
 *
 */
public class FontsIntensityCalculator extends Codelet {

	private Memory knownFontsMO;
	private Memory fontsIntensityMO;
	private Memory innerSenseMO;
	
        private List<Thing> knownFonts;

	public FontsIntensityCalculator() {
            this.name = "ClosestAppleDetector";
	}


	@Override
	public void accessMemoryObjects() {
		this.knownFontsMO=(MemoryObject)this.getInput("KNOWN_FONTS");
		this.innerSenseMO=(MemoryObject)this.getInput("INNER");
		this.fontsIntensityMO=(MemoryObject)this.getOutput("FONTS_INTENSITY");	
	}
	@Override
	public void proc() {
            Idea fontsIntensityIdea = (Idea) fontsIntensityMO.getI();
            fontsIntensityIdea.setL(new ArrayList<Idea>());
            
            knownFonts = Collections.synchronizedList((List<Thing>) knownFontsMO.getI());
            Idea cis = (Idea) innerSenseMO.getI();
            
            synchronized(knownFonts) {
               if(knownFonts.size() != 0){
                   System.out.println("Known fonts size: " + knownFonts.size());
                    //Iterate over objects in vision, calculating the distance from the creature and the intensity
                    CopyOnWriteArrayList<Thing> myknown = new CopyOnWriteArrayList<>(knownFonts);
                    for (Thing font : myknown) {
                        String fontName=font.getName();
                        Idea intensityIdea = null;
                        if(fontName.contains("PFood") && !fontName.contains("NPFood")){ //Then, it is an apple
                            intensityIdea = calculateFontIntensity(font, cis, "foodSensor");
                        } else if(fontName.contains("Jewel")){
                            String jewelColor = font.getAttributes().getColor();
                            if(jewelColor.equals("Yellow")){
                                 intensityIdea = calculateFontIntensity(font, cis, "yellowJewelSensor");
                            } else if (jewelColor.equals("Green")){
                                intensityIdea = calculateFontIntensity(font, cis, "greenJewelSensor");
                            }
                        } else if(fontName.contains("Brick")){
                            intensityIdea = calculateFontIntensity(font, cis, "brickSensor");
                        }
                        if(intensityIdea != null){
                            fontsIntensityIdea.add(intensityIdea);
                        }
                    }
                }
            }
            fontsIntensityMO.setI(fontsIntensityIdea);
	}//end proc

        @Override
        public void calculateActivation() {
        
        }
        
        private double calculateDistance(double x1, double y1, double x2, double y2) {
            return(Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)));
        }
        
        private Idea calculateFontIntensity(Thing font, Idea cis, String fontType){
            double creatureSensorRightX = (double)cis.get("sensors."+ fontType+".right.x").getValue();
            double creatureSensorRightY = (double)cis.get("sensors."+ fontType+".right.y").getValue();
            double creatureSensorLeftX = (double)cis.get("sensors."+ fontType+".left.x").getValue();
            double creatureSensorLeftY = (double)cis.get("sensors."+ fontType+".left.y").getValue();
            double distR;
            double distL;
            if(fontType.contains("brick")) {
                distR = calculateBrickFontIntensity(font, creatureSensorRightX, creatureSensorRightY);
                distL = calculateBrickFontIntensity(font, creatureSensorLeftX, creatureSensorLeftY);
            } else {
                distR = calculateDistance(font.getX1(), font.getY1(), creatureSensorRightX, creatureSensorRightY);
                distL = calculateDistance(font.getX1(), font.getY1(), creatureSensorLeftX, creatureSensorLeftY);
            }
            int K = 1000;
//            double intensityRight =  K/(Math.pow(distR, 2) + 0.1);
//            double intensityLeft =  K/(Math.pow(distL, 2) + 0.1);
            double intensityRight =  K/(distR + 0.1);
            double intensityLeft =  K/(distL + 0.1);
            if(intensityLeft > intensityRight) {
                intensityLeft = Double.min(intensityLeft, 20.0);
                intensityRight = Double.min(intensityRight, 18.0);
            } else{
                intensityLeft = Double.min(intensityLeft, 18.0);
                intensityRight = Double.min(intensityRight, 20.0);
            }
            Idea jewelIntensityIdea = new Idea(fontType + "IntensityIdea","", Idea.guessType("Property", null,1.0,0.5));
            jewelIntensityIdea.add(new Idea("right",Double.max(0.0,intensityRight), Idea.guessType("Property", null,1.0,0.5)));
            jewelIntensityIdea.add(new Idea("left",Double.max(0.0,intensityLeft), Idea.guessType("Property", null,1.0,0.5)));
            return jewelIntensityIdea;
        }
        private double calculateBrickFontIntensity(Thing font, double cx, double cy) {
        
            double minX = Math.min(font.getX1(), font.getX2());
            double maxX = Math.max(font.getX1(), font.getX2());
            double minY = Math.min(font.getY1(), font.getY2());
            double maxY = Math.max(font.getY1(), font.getY2());

            double dx = Math.max(minX - cx, cx - maxX);
            dx = Math.max(dx, 0);

            double dy = Math.max(minY - cy, cy - maxY);
            dy = Math.max(dy, 0);
            double distance = Math.sqrt(dx * dx + dy * dy);
            if(distance >100){
                distance = 1000000;
            }
            return distance;
        }

}
