/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codelets.perception;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import br.unicamp.cst.util.viewer.Inspectable;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import support.WorldStateCustomView;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

/**
 *
 * @author karenlima
 */
public class WorldStateDetector extends Codelet implements Inspectable {
    
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
    
    private ArrayList<String> currentWorldState = new ArrayList();
    private ArrayList<String> lastWorldState = new ArrayList();
    private ArrayList<String> lastDifferentWorldState = new ArrayList();
    
    WorldStateCustomView worldStateCustomView;
     
    public WorldStateDetector(Creature nc) {
        c = nc;
        worldStateCustomView = new WorldStateCustomView("World State");
        this.name = "WorldStateDetector";
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
        foundFood();
        hungry();
        exploring();
        saveWorldStateIfChanged();
        updateWorldStateCustomView();
    }
    
    private void saveWorldStateIfChanged(){
        currentWorldState.clear();
        currentWorldState.add((String) worldStateHungryMO.getI());
        currentWorldState.add((String) worldStateFoundFoodMO.getI());
        currentWorldState.add((String) worldStateExploringMO.getI());
        
        if(!currentWorldState.equals(lastWorldState)){
            lastDifferentWorldState = new ArrayList<>(lastWorldState);
            lastWorldState = new ArrayList<>(currentWorldState);
        }
    }
    
    private void updateWorldStateCustomView() {
        worldStateCustomView.updateCurrentWorldState(currentWorldState);
        worldStateCustomView.updateLastDifferentWorldState(lastDifferentWorldState);
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
    
    @Override
    public void inspect() {
        worldStateCustomView.setVisible(true);
    }
    
}
