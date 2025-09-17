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

import bn.codelets.behaviors.BehaviorToActionCodelet;
import bn.codelets.behaviors.EatBehavior;
import bn.codelets.behaviors.ExploreBehavior;
import bn.codelets.behaviors.ForageFoodBehavior;
import bn.codelets.perception.WorldStateDetector;
import br.unicamp.cst.behavior.bn.Behavior;
import br.unicamp.cst.behavior.bn.BehaviorNetwork;
import br.unicamp.cst.behavior.bn.GlobalVariables;
import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.memory.WorkingStorage;
import br.unicamp.cst.representation.idea.Idea;
import br.unicamp.cst.util.behavior.bn.BHMonitor;
import br.unicamp.cst.util.behavior.bn.BNplot;
import codelets.motor.HandsActionCodelet;
import codelets.motor.LegsActionCodelet;
import codelets.perception.AppleDetector;
import codelets.perception.ClosestAppleDetector;
import codelets.sensors.InnerSense;
import codelets.sensors.Vision;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static support.Constants.BEHAVIORAL;
import static support.Constants.COMPETENCE;
import static support.Constants.MOTOR;
import static support.Constants.PERCEPTION;
import static support.Constants.SENSORY;
import static support.Constants.WORKING;
import ws3dproxy.model.Thing;
/**
 *
 * @author rgudwin
 */
public class AgentMindBN extends Mind {
    
   
    public ArrayList<Codelet> behavioralCodelets = new ArrayList<>();
    
    public AgentMindBN(Environment env, String creatureName) {
                super();
                
                // Create CodeletGroups and MemoryGroups for organizing Codelets and Memories
                createCodeletGroup(SENSORY);
                createCodeletGroup(PERCEPTION);
                createCodeletGroup(BEHAVIORAL);
                createCodeletGroup(COMPETENCE);
                createCodeletGroup(MOTOR);
                
                
                createMemoryGroup(SENSORY);
                createMemoryGroup(MOTOR);
                createMemoryGroup(WORKING);
                
                // Declare Memory Objects
	        Memory legsMO;  // This Memory is going to be a MemoryContainer
	        Memory handsMO;
                Memory visionMO;
                Memory innerSenseMO;
                Memory closestAppleMO;
                Memory knownApplesMO;
                
                Memory worldStateHungryMO;
                Memory worldStateFoundFoodMO;
                Memory worldStateExploringMO;
                Memory worldStateExploringDetectorMO;
                Memory chosenBehaviorMO;
                
                //Declare world states
                String stateHungry = "hungry";
                String stateNotHungry = "NOT_hungry";
                String stateFoundFood = "foundFood";
                String stateExploring = "exploring";
                String stateNotExploring = "NOT_exploring";
                
                //Initialize Memory Objects
                legsMO=createMemoryContainer("LEGS");
                registerMemory(legsMO,"Motor");
		handsMO=createMemoryObject("HANDS", "");
                registerMemory(handsMO,"Motor");
                List<Thing> vision_list = Collections.synchronizedList(new ArrayList<>());
		visionMO=createMemoryObject("VISION",vision_list);
                registerMemory(visionMO,"Sensory");
                Idea cis = Idea.createIdea("cis" + creatureName,"", Idea.guessType("AbstractObject",null,1.0,0.5));
                cis.add(Idea.createIdea("cis"+ creatureName +".pitch", 0D, Idea.guessType("Property", null,1.0,0.5)));
                cis.add(Idea.createIdea("cis"+ creatureName +".fuel", 0D, Idea.guessType("Property", null,1.0,0.5)));
                Idea position = Idea.createIdea("cis"+ creatureName +".position","", Idea.guessType("Property",null,1.0,0.5));
                position.add(Idea.createIdea("cis"+ creatureName +".position.x",0D,Idea.guessType("QualityDimension",null,1.0,0.5)));
                position.add(Idea.createIdea("cis"+ creatureName +".position.y",0D,Idea.guessType("QualityDimension",null,1.0,0.5)));
                cis.add(position);
                Idea fov = Idea.createIdea("cis"+ creatureName +".FOV","", Idea.guessType("Property", null,1.0,0.5));
                Idea bounds = Idea.createIdea("cis"+ creatureName +".FOV.bounds","", Idea.guessType("Property", null,1.0,0.5));
                bounds.add(Idea.createIdea("cis"+ creatureName +".FOV.bounds.x",null, Idea.guessType("Property", null,1.0,0.5)));
                bounds.add(Idea.createIdea("cis"+ creatureName +".FOV.bounds.y",null, Idea.guessType("Property", null,1.0,0.5)));
                bounds.add(Idea.createIdea("cis"+ creatureName +".FOV.bounds.height",null, Idea.guessType("Property", null,1.0,0.5)));
                bounds.add(Idea.createIdea("cis"+ creatureName +".FOV.bounds.width",null, Idea.guessType("Property", null,1.0,0.5)));
                fov.add(bounds);
                fov.add(Idea.createIdea("cis"+ creatureName +".FOV.npoints",0, Idea.guessType("Property", null,1.0,0.5)));
                fov.add(Idea.createIdea("cis"+ creatureName +".FOV.points","", Idea.guessType("Property", null,1.0,0.5)));
                cis.add(fov);
                innerSenseMO=createMemoryObject("INNER", cis);
                registerMemory(innerSenseMO,"Sensory");
                Thing closestApple = null;
                closestAppleMO=createMemoryObject("CLOSEST_APPLE", closestApple);
                registerMemory(closestAppleMO,"Working");
                List<Thing> knownApples = Collections.synchronizedList(new ArrayList<>());
                knownApplesMO=createMemoryObject("KNOWN_APPLES", knownApples);
                registerMemory(knownApplesMO,"Working");
                
                //Define Behavior Network MOs
                chosenBehaviorMO = createMemoryObject("CHOSEN_BEHAVIOR", "");
                
                worldStateHungryMO = createMemoryObject("WORLD_STATE", "");
                worldStateFoundFoodMO = createMemoryObject("WORLD_STATE", "");
                worldStateExploringMO = createMemoryObject("WORLD_STATE", "");
                worldStateExploringDetectorMO = createMemoryObject("EXPLORING_STATE_DETECTOR", stateNotExploring);
                registerMemory(worldStateHungryMO,"Sensory");
                registerMemory(worldStateFoundFoodMO,"Sensory");
                registerMemory(worldStateExploringMO,"Sensory");
                
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
                legs.addOutput(worldStateExploringDetectorMO);
                insertCodelet(legs);
                registerCodelet(legs,"Motor");

		Codelet hands=new HandsActionCodelet(env.c);
		hands.addInput(handsMO);
                hands.addOutput(worldStateHungryMO);
                hands.addOutput(worldStateFoundFoodMO);
                hands.addOutput(worldStateExploringDetectorMO);
                
                insertCodelet(hands);
                registerCodelet(hands,"Motor");
		
		// Create Perception Codelets
                Codelet ad = new AppleDetector();
                ad.addInput(visionMO);
                ad.addOutput(knownApplesMO);
                insertCodelet(ad);
                registerCodelet(ad,"Perception");
                
		Codelet closestAppleDetector = new ClosestAppleDetector();
		closestAppleDetector.addInput(knownApplesMO);
		closestAppleDetector.addInput(innerSenseMO);
		closestAppleDetector.addOutput(closestAppleMO);
                insertCodelet(closestAppleDetector);
                registerCodelet(closestAppleDetector,"Perception");
               
		//Create detector codelet for world state detections
                Codelet workingStorageDetector = new WorldStateDetector(env.c);
                workingStorageDetector.addInput(closestAppleMO);
                workingStorageDetector.addInput(innerSenseMO); 
                workingStorageDetector.addInput(worldStateExploringDetectorMO);
                
                //Define Outputs
                workingStorageDetector.addOutput(worldStateHungryMO);
                workingStorageDetector.addOutput(worldStateFoundFoodMO);
                workingStorageDetector.addOutput(worldStateExploringMO);
                insertCodelet(workingStorageDetector);
                registerCodelet(workingStorageDetector,"Perception");

                Memory stateHungryMO = createMemoryObject("WORLD_STATE", stateHungry);
                Memory stateNotHungryMO = createMemoryObject("WORLD_STATE", stateNotHungry);
                Memory stateFoundFoodMO = createMemoryObject("WORLD_STATE", stateFoundFood);
                Memory stateExploringMO = createMemoryObject("WORLD_STATE", stateExploring);
                
                Memory goals1MO = createMemoryObject("PERMANENT_GOAL", stateNotHungry);
                Memory goals2MO = createMemoryObject("PERMANENT_GOAL", stateExploring);
            
                //Define working storage and global variables for competences
                WorkingStorage ws = null;
                GlobalVariables gv =  new GlobalVariables();
                
                Behavior forageFoodCompetence = new ForageFoodBehavior(ws, gv);
                
                //Define HARD-PRE-CONDITIONS
                ArrayList<Memory> preconditionsListForage = new ArrayList<>();
                preconditionsListForage.add(stateHungryMO);
                forageFoodCompetence.setListOfPreconditions(preconditionsListForage);
                
                //Define ADD-LIST
                ArrayList<Memory> addListForage = new ArrayList<>();
                addListForage.add(stateFoundFoodMO);
                forageFoodCompetence.setAddList(addListForage);
                
                //Define DELETE-LIST
                ArrayList<Memory> deleteListForage = new ArrayList<>();
                deleteListForage.add(stateExploringMO);
                forageFoodCompetence.setDeleteList(deleteListForage);
                
                //Define WORLD_STATE_PARAMETERS as inputs
                forageFoodCompetence.addInput(worldStateHungryMO);
                forageFoodCompetence.addInput(worldStateFoundFoodMO);
                forageFoodCompetence.addInput(worldStateExploringMO);
                
                //Define GOALS
                forageFoodCompetence.addInput(goals1MO);
                forageFoodCompetence.addInput(goals2MO);
                
                //Define OUTPUT the chosen behavior
                forageFoodCompetence.addOutput(chosenBehaviorMO);
                
                insertCodelet(forageFoodCompetence);
                registerCodelet(forageFoodCompetence, "Competence");
                behavioralCodelets.add(forageFoodCompetence);
                
                Behavior eatCompetence = new EatBehavior(ws, gv);
                
                //Define HARD-PRE-CONDITIONS
                ArrayList<Memory> preconditionsListEat = new ArrayList<>();
                preconditionsListEat.add(stateFoundFoodMO);
                eatCompetence.setListOfPreconditions(preconditionsListEat);
                
                //Define SOFT-PRE-CONDITIONS
                ArrayList<Memory> softPreconditionsListEat = new ArrayList<>();
                softPreconditionsListEat.add(stateHungryMO);
                eatCompetence.setSoftPreconList(softPreconditionsListEat);
                
                //Define ADD-LIST
                ArrayList<Memory> addListEat = new ArrayList<>();
                addListEat.add(stateNotHungryMO);
                eatCompetence.setAddList(addListEat);
                
                //Define DELETE-LIST
                ArrayList<Memory> deleteListEat= new ArrayList<>();
                deleteListEat.add(stateHungryMO);
                eatCompetence.setDeleteList(deleteListEat);
                
                //Define WORLD_STATE_PARAMETERS as inputs
                eatCompetence.addInput(worldStateHungryMO);
                eatCompetence.addInput(worldStateFoundFoodMO);
                eatCompetence.addInput(worldStateExploringMO);
                
                //Define GOALS
                eatCompetence.addInput(goals1MO);
                eatCompetence.addInput(goals2MO);
                
                //Define OUTPUT the chosen behavior 
                eatCompetence.addOutput(chosenBehaviorMO);
                
                insertCodelet(eatCompetence);
                registerCodelet(eatCompetence, "Competence");
                behavioralCodelets.add(eatCompetence);
             
                Behavior exploreCompetence = new ExploreBehavior(ws, gv);
                
                //Define HARD-PRE-CONDITIONS
                ArrayList<Memory> preconditionsListExplore = new ArrayList<>();
                preconditionsListExplore.add(stateNotHungryMO);
                exploreCompetence.setListOfPreconditions(preconditionsListExplore);
                
                //Define ADD-LIST
                ArrayList<Memory> addListExplore = new ArrayList<>();
                addListExplore.add(stateExploringMO);
                addListExplore.add(stateHungryMO);
                exploreCompetence.setAddList(addListExplore);
                
                //Define DELETE-LIST
                ArrayList<Memory> deleteListExplore= new ArrayList<>();
                deleteListExplore.add(stateNotHungryMO);
                exploreCompetence.setDeleteList(deleteListExplore);
                
                //Define WORLD_STATE_PARAMETERS as inputs
                exploreCompetence.addInput(worldStateHungryMO);
                exploreCompetence.addInput(worldStateFoundFoodMO);
                exploreCompetence.addInput(worldStateExploringMO);
                
                //Define GOALS as inputs
                exploreCompetence.addInput(goals1MO);
                exploreCompetence.addInput(goals2MO);
                
                //Define OUTPUTS with comands to actuator
                exploreCompetence.addOutput(chosenBehaviorMO);
                
                insertCodelet(exploreCompetence);
                registerCodelet(exploreCompetence, "Competence");
                behavioralCodelets.add(exploreCompetence);
                
                BehaviorNetwork bn = new BehaviorNetwork(this.getCodeRack(), ws);
                bn.addCodelet(forageFoodCompetence);
                bn.addCodelet(eatCompetence);
                bn.addCodelet(exploreCompetence);
                
                ArrayList<Behavior> behaviorList =  new ArrayList();
                behaviorList.add(eatCompetence);
                behaviorList.add(forageFoodCompetence);
                behaviorList.add(exploreCompetence);
                
                bn.setCoalition(behaviorList);
                
                BehaviorToActionCodelet behaviorToActionCodelet = new BehaviorToActionCodelet();
                behaviorToActionCodelet.addInput(chosenBehaviorMO);
                behaviorToActionCodelet.addInput(closestAppleMO);
                behaviorToActionCodelet.addInput(innerSenseMO);
                behaviorToActionCodelet.addOutput(handsMO);
                behaviorToActionCodelet.addOutput(knownApplesMO);
                behaviorToActionCodelet.addOutput(legsMO);
                insertCodelet(behaviorToActionCodelet);
                registerCodelet(behaviorToActionCodelet, "Competence");
                
                BNplot bNplot = new BNplot(behaviorList);
                bNplot.plot();
                                
                
                ArrayList<String> behaviorsIWantShownInGraphics = new ArrayList<>();
                behaviorsIWantShownInGraphics.add(eatCompetence.getName());
                behaviorsIWantShownInGraphics.add(forageFoodCompetence.getName());
                behaviorsIWantShownInGraphics.add(exploreCompetence.getName());
                BHMonitor bHMonitor = new BHMonitor(bn, behaviorsIWantShownInGraphics, gv);
                insertCodelet(bHMonitor);
                
                registerCodelet(bHMonitor, "Competence");
                
                // sets a time step for running the codelets to avoid heating too much your machine
                for (Codelet c : this.getCodeRack().getAllCodelets())
                    c.setTimeStep(200);
		
		// Start Cognitive Cycle
		start(); 
    }             
    
}
