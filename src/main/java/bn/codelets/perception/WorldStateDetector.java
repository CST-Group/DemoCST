/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bn.codelets.perception;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

/**
 *
 * @author karenlima
 */
public class WorldStateDetector extends Codelet {
    
    private Memory closestAppleMO;
    private Memory selfInfoMO;
    private Memory worldStateExploringDetectorMO;
    private Memory worldStateHungryMO;
    private Memory worldStateFoundFoodMO;
    private Memory worldStateExploringMO;
    private ArrayList<Memory> worldStateListMO;
    
    private static int reachDistance=50;
    private Creature c;
    
    String stateHungry = "hungry";
    String stateNotHungry = "NOT_hungry";
    String stateFoundFood = "foundFood";
    String stateNotFoundFood = "NOT_foundFood";
    String stateExploring = "exploring";
    String stateNotExploring = "NOT_exploring";
     
    public WorldStateDetector(Creature nc) {
        c = nc;
    }

    @Override
    public void accessMemoryObjects() {
       
        closestAppleMO=(MemoryObject)this.getInput("CLOSEST_APPLE");
        selfInfoMO=(MemoryObject)this.getInput("INNER");
        worldStateExploringDetectorMO=(MemoryObject)this.getInput("EXPLORING_STATE_DETECTOR");
        worldStateListMO=(ArrayList<Memory>)this.getOutputsOfType("WORLD_STATE");
        worldStateHungryMO = worldStateListMO.get(0);
        worldStateFoundFoodMO = worldStateListMO.get(1);
        worldStateExploringMO = worldStateListMO.get(2);
    }

    @Override
    public void calculateActivation() {
    }

    @Override
    public void proc() {
        System.out.println("WorkingStorageDetector proc");
        foundFood();
        hungry();
        exploring();
        printWorldState();
    }
    
    private void foundFood() {
        // Find distance between creature and closest apple
        //If far, go towards it
        //If close, stops

        Thing closestApple = (Thing) closestAppleMO.getI();
        Idea cis = (Idea) selfInfoMO.getI();
        String currentWorldStateFoundFoodInfo = (String) worldStateFoundFoodMO.getI();
        String newWorldStateFoundFoodInfo = "stateNotFoundFood"; 

        if(closestApple != null)
        {
            System.out.println("closes apple found in detector is: " + closestApple.getName());
            double appleX=0;
            double appleY=0;
            try {
                    appleX = closestApple.getCenterPosition().getX();
                    appleY = closestApple.getCenterPosition().getY();

            } catch (Exception e) {
                    e.printStackTrace();
            }

            double selfX=(double)cis.get("position.x").getValue();
            double selfY=(double)cis.get("position.y").getValue();

            Point2D pApple = new Point();
            pApple.setLocation(appleX, appleY);

            Point2D pSelf = new Point();
            pSelf.setLocation(selfX, selfY);

            double distance = pSelf.distance(pApple);
            
            
            if(distance>reachDistance){
                newWorldStateFoundFoodInfo = stateNotFoundFood;           
            } else {
                newWorldStateFoundFoodInfo = stateFoundFood;
            }

        }
                    
        if (!newWorldStateFoundFoodInfo.equals(currentWorldStateFoundFoodInfo)) {
            worldStateFoundFoodMO.setI(newWorldStateFoundFoodInfo);
        } 
    }
    
    private void hungry(){
        String currentWorldStateHungryInfo = (String) worldStateHungryMO.getI();
        String newWorldStateHungryInfo = "";
        if (c.getFuel() < 850) {
            newWorldStateHungryInfo = stateHungry;
        } else {
            newWorldStateHungryInfo = stateNotHungry;
            
        }
        if (!newWorldStateHungryInfo.equals(currentWorldStateHungryInfo)) {
            worldStateHungryMO.setI(newWorldStateHungryInfo);
        } 
    }
    
    private void exploring() {
        String currentWorldStateExploringInfo = (String) worldStateExploringMO.getI();
        String newWorldStateExploringyInfo = (String) worldStateExploringDetectorMO.getI();

        if (!newWorldStateExploringyInfo.equals(currentWorldStateExploringInfo)) {
            worldStateExploringMO.setI(newWorldStateExploringyInfo);
        }
        
    }
    
    private void printWorldState(){
        System.out.println("Hungry state:" + worldStateHungryMO.getI());
        System.out.println("FoundFood state:" +worldStateFoundFoodMO.getI());
        System.out.println("Exploring state:" +worldStateExploringMO.getI());
    }
    
}
