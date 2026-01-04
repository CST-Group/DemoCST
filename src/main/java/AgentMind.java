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

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.representation.idea.Idea;
import codelets.behaviors.IntensityToVelocity;
import codelets.behaviors.VelocityToNextPosition;
import codelets.motor.LegsActionCodelet;
import codelets.perception.FontsDetector;
import codelets.perception.FontsIntensityCalculator;
import codelets.sensors.InnerSense;
import codelets.sensors.Vision;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ws3dproxy.model.Thing;
/**
 *
 * @author rgudwin
 */
public class AgentMind extends Mind {
    
    private static int creatureBasicSpeed=3;
    private static int reachDistance=50;
    public ArrayList<Codelet> behavioralCodelets = new ArrayList<Codelet>();
    
    public AgentMind(Environment env) {
                super();
                
                // Create CodeletGroups and MemoryGroups for organizing Codelets and Memories
                createCodeletGroup("Sensory");
                createCodeletGroup("Motor");
                createCodeletGroup("Perception");
                createCodeletGroup("Behavioral");
                createMemoryGroup("Sensory");
                createMemoryGroup("Motor");
                createMemoryGroup("Working");
                
                // Declare Memory Objects
	        Memory legsMO;  // This Memory is going to be a MemoryContainer
                Memory visionMO;
                Memory innerSenseMO;
                Memory fontsIntensityMO;
                Memory knownFontsMO;
                Memory wheelsVelocityMO;
                
                //Initialize Memory Objects
                legsMO=createMemoryObject("LEGS");
                registerMemory(legsMO,"Motor");
                
                List<Thing> vision_list = Collections.synchronizedList(new ArrayList<Thing>());
		visionMO=createMemoryObject("VISION",vision_list);
                registerMemory(visionMO,"Sensory");
                //CreatureInnerSense cis = new CreatureInnerSense();
                Idea cis = Idea.createIdea("cis","", Idea.guessType("AbstractObject",null,1.0,0.5));
                cis.add(Idea.createIdea("cis.pitch", 0D, Idea.guessType("Property", null,1.0,0.5)));
                cis.add(Idea.createIdea("cis.fuel", 0D, Idea.guessType("Property", null,1.0,0.5)));
                Idea position = Idea.createIdea("cis.position","", Idea.guessType("Property",null,1.0,0.5));
                position.add(Idea.createIdea("cis.position.x",0D,Idea.guessType("QualityDimension",null,1.0,0.5)));
                position.add(Idea.createIdea("cis.position.y",0D,Idea.guessType("QualityDimension",null,1.0,0.5)));
                cis.add(position);
                
                Idea sensors = Idea.createIdea("cis.sensors","", Idea.guessType("Property", null,1.0,0.5));
                
                Idea brickSensor = Idea.createIdea("cis.sensors.brickSensor","", Idea.guessType("Property", null,1.0,0.5));
                
                Idea brickSensorRight = Idea.createIdea("cis.sensors.brickSensor.right","", Idea.guessType("Property", null,1.0,0.5));
                brickSensorRight.add(Idea.createIdea("cis.sensors.brickSensor.right.x",0D, Idea.guessType("Property", null,1.0,0.5)));
                brickSensorRight.add(Idea.createIdea("cis.sensors.brickSensor.right.y",0D, Idea.guessType("Property", null,1.0,0.5)));
                brickSensor.add(brickSensorRight);
                
                Idea brickSensorLeft = Idea.createIdea("cis.sensors.brickSensor.left","", Idea.guessType("Property", null,1.0,0.5));
                brickSensorLeft.add(Idea.createIdea("cis.sensors.brickSensor.left.x",0D, Idea.guessType("Property", null,1.0,0.5)));
                brickSensorLeft.add(Idea.createIdea("cis.sensors.brickSensor.left.y",0D, Idea.guessType("Property", null,1.0,0.5)));
                brickSensor.add(brickSensorLeft);
                
                sensors.add(brickSensor);
                
                Idea foodSensor = Idea.createIdea("cis.sensors.foodSensor","", Idea.guessType("Property", null,1.0,0.5));
                
                Idea foodSensorRight = Idea.createIdea("cis.sensors.foodSensor.right","", Idea.guessType("Property", null,1.0,0.5));
                foodSensorRight.add(Idea.createIdea("cis.sensors.foodSensor.right.x",null, Idea.guessType("Property", null,1.0,0.5)));
                foodSensorRight.add(Idea.createIdea("cis.sensors.foodSensor.right.y",null, Idea.guessType("Property", null,1.0,0.5)));
                foodSensor.add(foodSensorRight);
                
                Idea foodSensorLeft = Idea.createIdea("cis.sensors.foodSensor.left","", Idea.guessType("Property", null,1.0,0.5));
                foodSensorLeft.add(Idea.createIdea("cis.sensors.foodSensor.left.x",0D, Idea.guessType("Property", null,1.0,0.5)));
                foodSensorLeft.add(Idea.createIdea("cis.sensors.foodSensor.left.y",0D, Idea.guessType("Property", null,1.0,0.5)));
                foodSensor.add(foodSensorLeft);
                
                sensors.add(foodSensor);
                
                Idea greenJewelSensor = Idea.createIdea("cis.sensors.greenJewelSensor","", Idea.guessType("Property", null,1.0,0.5));
                
                Idea greenJewelSensorRight = Idea.createIdea("cis.sensors.greenJewelSensor.right","", Idea.guessType("Property", null,1.0,0.5));
                greenJewelSensorRight.add(Idea.createIdea("cis.sensors.greenJewelSensor.right.x",0D, Idea.guessType("Property", null,1.0,0.5)));
                greenJewelSensorRight.add(Idea.createIdea("cis.sensors.greenJewelSensor.right.y",0D, Idea.guessType("Property", null,1.0,0.5)));
                greenJewelSensor.add(greenJewelSensorRight);
                
                Idea greenJewelSensorLeft = Idea.createIdea("cis.sensors.greenJewelSensor.left","", Idea.guessType("Property", null,1.0,0.5));
                greenJewelSensorLeft.add(Idea.createIdea("cis.sensors.greenJewelSensor.left.x",0D, Idea.guessType("Property", null,1.0,0.5)));
                greenJewelSensorLeft.add(Idea.createIdea("cis.sensors.greenJewelSensor.left.y",0D, Idea.guessType("Property", null,1.0,0.5)));
                greenJewelSensor.add(greenJewelSensorLeft);
                sensors.add(greenJewelSensor);
                
                Idea yellowJewelSensor = Idea.createIdea("cis.sensors.yellowJewelSensor","", Idea.guessType("Property", null,1.0,0.5));
                
                Idea yellowJewelSensorRight = Idea.createIdea("cis.sensors.yellowJewelSensor.right","", Idea.guessType("Property", null,1.0,0.5));
                yellowJewelSensorRight.add(Idea.createIdea("cis.sensors.yellowJewelSensor.right.x",null, Idea.guessType("Property", null,1.0,0.5)));
                yellowJewelSensorRight.add(Idea.createIdea("cis.sensors.yellowJewelSensor.right.y",null, Idea.guessType("Property", null,1.0,0.5)));
                yellowJewelSensor.add(yellowJewelSensorRight);
                
                Idea yellowJewelSensorLeft = Idea.createIdea("cis.sensors.yellowJewelSensor.left","", Idea.guessType("Property", null,1.0,0.5));
                yellowJewelSensorLeft.add(Idea.createIdea("cis.sensors.yellowJewelSensor.left.x",null, Idea.guessType("Property", null,1.0,0.5)));
                yellowJewelSensorLeft.add(Idea.createIdea("cis.sensors.yellowJewelSensor.left.y",null, Idea.guessType("Property", null,1.0,0.5)));
                yellowJewelSensor.add(yellowJewelSensorLeft);
                
                sensors.add(yellowJewelSensor);
                
                cis.add(sensors);
                
                Idea fov = Idea.createIdea("cis.FOV","", Idea.guessType("Property", null,1.0,0.5));
                Idea bounds = Idea.createIdea("cis.FOV.bounds","", Idea.guessType("Property", null,1.0,0.5));
                bounds.add(Idea.createIdea("cis.FOV.bounds.x",null, Idea.guessType("Property", null,1.0,0.5)));
                bounds.add(Idea.createIdea("cis.FOV.bounds.y",null, Idea.guessType("Property", null,1.0,0.5)));
                bounds.add(Idea.createIdea("cis.FOV.bounds.height",null, Idea.guessType("Property", null,1.0,0.5)));
                bounds.add(Idea.createIdea("cis.FOV.bounds.width",null, Idea.guessType("Property", null,1.0,0.5)));
                fov.add(bounds);
                fov.add(Idea.createIdea("cis.FOV.npoints",0, Idea.guessType("Property", null,1.0,0.5)));
                fov.add(Idea.createIdea("cis.FOV.points","", Idea.guessType("Property", null,1.0,0.5)));
                cis.add(fov);
                innerSenseMO=createMemoryObject("INNER", cis);
                registerMemory(innerSenseMO,"Sensory");
                Idea fontsIntensityIdea = Idea.createIdea("fontsIntensity","", Idea.guessType("Property", null,1.0,0.5));
                fontsIntensityMO=createMemoryObject("FONTS_INTENSITY", fontsIntensityIdea);
                registerMemory(fontsIntensityMO,"Working");
                List<Thing> knownFonts = Collections.synchronizedList(new ArrayList<Thing>());
                knownFontsMO=createMemoryObject("KNOWN_FONTS", knownFonts);
                registerMemory(knownFontsMO,"Working");
                
                
                Idea wheelsVelocityIdea = new Idea("wheelsVelocityIdea","", Idea.guessType("Property", null,1.0,0.5));
                Idea rightVelocityIdea = new Idea("VRight",0D, Idea.guessType("Property", null,1.0,0.5));
                wheelsVelocityIdea.add(rightVelocityIdea);
                Idea leftVelocityIdea = new Idea("VLeft",0D, Idea.guessType("Property", null,1.0,0.5));
                wheelsVelocityIdea.add(leftVelocityIdea);
                wheelsVelocityMO=createMemoryObject("WHEELS_VELOCITY", wheelsVelocityIdea);
                registerMemory(wheelsVelocityMO,"Sensory");
                
 		// Create Sensor Codelets	
		Codelet vision=new Vision(env.c);
		vision.addOutput(visionMO);
                insertCodelet(vision); //Creates a vision sensor
                registerCodelet(vision,"Sensory");
		
		Codelet innerSense=new InnerSense(env.c);
		innerSense.addOutput(innerSenseMO);
                insertCodelet(innerSense); //A sensor for the inner state of the creature
                registerCodelet(innerSense,"Sensory");
		
		// Create Actuator Codelets
		Codelet legs=new LegsActionCodelet(env.c);
		legs.addInput(legsMO);
                insertCodelet(legs);
                registerCodelet(legs,"Motor");
		
		// Create Perception Codelets
                Codelet fontsDetector = new FontsDetector();
                fontsDetector.addInput(visionMO);
                fontsDetector.addOutput(knownFontsMO);
                insertCodelet(fontsDetector);
                registerCodelet(fontsDetector,"Perception");
                
		Codelet fontsIntensityCalculator = new FontsIntensityCalculator();
		fontsIntensityCalculator.addInput(knownFontsMO);
		fontsIntensityCalculator.addInput(innerSenseMO);
		fontsIntensityCalculator.addOutput(fontsIntensityMO);
                insertCodelet(fontsIntensityCalculator);
                registerCodelet(fontsIntensityCalculator,"Perception");
		
		// Create Behavior Codelets
		
		Codelet intensityToVelocity=new IntensityToVelocity();
		intensityToVelocity.addInput(fontsIntensityMO);
		intensityToVelocity.addInput(innerSenseMO);
		intensityToVelocity.addOutput(wheelsVelocityMO);
                insertCodelet(intensityToVelocity);
                registerCodelet(intensityToVelocity,"Behavioral");
                behavioralCodelets.add(intensityToVelocity);
                
                Codelet velocityToNextPosition=new VelocityToNextPosition();
		velocityToNextPosition.addInput(wheelsVelocityMO);
		velocityToNextPosition.addInput(innerSenseMO);
		velocityToNextPosition.addOutput(legsMO);
                insertCodelet(velocityToNextPosition);
                registerCodelet(velocityToNextPosition,"Behavioral");
                behavioralCodelets.add(velocityToNextPosition);
                
                // sets a time step for running the codelets to avoid heating too much your machine
                for (Codelet c : this.getCodeRack().getAllCodelets())
                    c.setTimeStep(200);
		
		// Start Cognitive Cycle
		start(); 
    }             
    
}
