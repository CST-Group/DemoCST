/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codelets.behaviors;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryContainer;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import ws3dproxy.model.Thing;

/**
 *
 * @author karenlima
 */
public class BehaviorToActionCodelet extends Codelet {

    private MemoryObject chosenBehaviorMO;
    private String chosenBehavior;
    private MemoryObject closestAppleMO;
    private MemoryObject handsMO;
    private MemoryObject knownApplesMO;
    private Thing closestApple;
    private List<Thing> knownApples;
    private MemoryContainer legsMO;
    private final int creatureBasicSpeed=3;
    private final double reachDistance = 50;
    private String lastBehavior = "";
    private MemoryObject innerSenseMO;
    private Idea cis;
    private double positionX = -1; 
    private double positionY = -1; 
    
    
    public void BehaviorToActionCodelet() {
        System.currentTimeMillis();
        this.name = "BehaviorToAction";
    }

    @Override
    public void accessMemoryObjects() {
        chosenBehaviorMO = (MemoryObject)this.getInput("CHOSEN_BEHAVIOR");

        closestAppleMO=(MemoryObject)this.getInput("CLOSEST_APPLE");
        innerSenseMO=(MemoryObject)this.getInput("INNER");
        
        handsMO=(MemoryObject)this.getOutput("HANDS");
        knownApplesMO = (MemoryObject)this.getOutput("KNOWN_APPLES");
        
        legsMO = (MemoryContainer)this.getOutput("LEGS");
    }

    @Override
    public void calculateActivation() {
    }

    @Override
    public void proc() {
        if (chosenBehaviorMO != null) {
            chosenBehavior = (String) chosenBehaviorMO.getI();
            System.out.println("Chosen behavior: " + chosenBehavior);
            switch(chosenBehavior) {
                case "EAT_COMPETENCE":
                    eatProc();
                    break;
                case "EXPLORE_COMPETENCE":
//                    exploreRandomProc();
                    exploreRotateProc();
                    break;
                case "FORAGE_FOOD_COMPETENCE":
                    forageFoodProc();
                    break;
                default:
                    System.out.println("No behavior ");    
                    break;
                    
            }
            lastBehavior = chosenBehavior;
        }
    }
    
    private void eatProc() {
        String appleName="";
        closestApple = (Thing) closestAppleMO.getI();
        cis = (Idea) innerSenseMO.getI();
        knownApples = (List<Thing>) knownApplesMO.getI();
        //Find distance between closest apple and self
        //If closer than reachDistance, eat the apple

        if(closestApple != null){
            double appleX=0;
            double appleY=0;
            try {
                appleX=closestApple.getCenterPosition().getX();
                appleY=closestApple.getCenterPosition().getY();
                appleName = closestApple.getName();
            } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            
            double selfX=(double)cis.get("position.x").getValue();
            double selfY=(double)cis.get("position.y").getValue();

            Point2D pApple = new Point();
            pApple.setLocation(appleX, appleY);

            Point2D pSelf = new Point();
            pSelf.setLocation(selfX, selfY);

            double distance = pSelf.distance(pApple);
            JSONObject message=new JSONObject();
            try {
                if(distance<=reachDistance){ //eat it	
                    DestroyClosestApple();
                    message.put("OBJECT", appleName);
                    message.put("ACTION", "EATIT");
                    handsMO.setI(message.toString());


                }else{
                        handsMO.setI("");	//nothing
                }

		System.out.println(message);
            } catch (JSONException e) {
                    e.printStackTrace();
            }
        }else{
                handsMO.setI("");	//nothing
                activation=0.0;
        }	
    }
    
    public void DestroyClosestApple() {
        int r = -1;
        int i = 0;
        synchronized(knownApples) {
          for (Thing t : knownApples) {
           if (closestApple != null) 
              if (t.getName().equals(closestApple.getName())) r = i;
          i++;
          }   
          if (r != -1) {
              knownApples.remove(r);
          }
          closestApple = null;
          knownApplesMO.setI(knownApples);
        }
     }
    
    private void exploreRandomProc() {
        Random random = new Random();
        if(isCreatureInLastTarget() || !lastBehavior.equals("EXPLORE_COMPETENCE")) {
            positionX = (double) random.nextInt(800);
            positionY = (double) random.nextInt(600);
            Idea message = Idea.createIdea("message","", Idea.guessType("Property",1));
            message.add(Idea.createIdea("ACTION","RANDOM", Idea.guessType("Property",1)));
            message.add(Idea.createIdea("X",(int)positionX, Idea.guessType("Property",1)));
            message.add(Idea.createIdea("Y",(int)positionY, Idea.guessType("Property",1)));
            message.add(Idea.createIdea("SPEED",creatureBasicSpeed, Idea.guessType("Property",1)));
            activation=1.0;
            legsMO.setI(toJson(message),activation,name);
        }
    }
    
    private void exploreRotateProc() {
        if(isCreatureInLastTarget() || !lastBehavior.equals("EXPLORE_COMPETENCE")) {
            Idea message = Idea.createIdea("message","", Idea.guessType("Property",1));
            message.add(Idea.createIdea("ACTION","FORAGE", Idea.guessType("Property",1)));
            activation=1.0;
            legsMO.setI(toJson(message),activation,name);
        }
    }
    
    private Boolean isCreatureInLastTarget() {
        if (positionX == -1) return true;
        cis = (Idea) innerSenseMO.getI();
        double selfX=(double)cis.get("position.x").getValue();
        double selfY=(double)cis.get("position.y").getValue();
        return calculateDistance(positionX, positionY, selfX, selfY) < 50;
    }
    
    private double calculateDistance(double x1, double y1, double x2, double y2) {
        return(Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)));
    }
    
    private void forageFoodProc() {
        // Find distance between creature and closest apple
        //If far, go towards it
        //If close, stops

        Thing closestApple = (Thing) closestAppleMO.getI();
        Idea cis = (Idea) innerSenseMO.getI();

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
                Idea message = Idea.createIdea("message","", Idea.guessType("Property",1));
                try {		
                        if(distance>reachDistance){ //Go to it
                                message.add(Idea.createIdea("ACTION","GOTO", Idea.guessType("Property",1)));
                                message.add(Idea.createIdea("X",(int)appleX, Idea.guessType("Property",1)));
                                message.add(Idea.createIdea("Y",(int)appleY, Idea.guessType("Property",1)));
                                message.add(Idea.createIdea("SPEED",creatureBasicSpeed, Idea.guessType("Property",1)));
                                activation=1.0;

                        }else{//Stop
                                message.add(Idea.createIdea("ACTION","GOTO", Idea.guessType("Property",1)));
                                message.add(Idea.createIdea("X",(int)appleX, Idea.guessType("Property",1)));
                                message.add(Idea.createIdea("Y",(int)appleY, Idea.guessType("Property",1)));
                                message.add(Idea.createIdea("SPEED",0, Idea.guessType("Property",1)));
                                activation=0.5;
                        }
                        legsMO.setI(toJson(message),activation,name);
                } catch (JSONException e) {
                        e.printStackTrace();
                }	
        }
        else {
            activation=0.0;
            legsMO.setI("",activation,name);
        }
    }
    
    String toJson(Idea i) {
        String q = "\"";
        String out = "{";
        String val;
        int ii=0;
        for (Idea il : i.getL()) {
            if (il.getL().isEmpty()) {
                if (il.isNumber()) val = il.getValue().toString();
                else val = q+il.getValue()+q;
            }
            else val = toJson(il);
            if (ii == 0) out += q+il.getName()+q+":"+val;
            else out += ","+q+il.getName()+q+":"+val;
            ii++;
        }
        out += "}";
        return out;
    }
}
