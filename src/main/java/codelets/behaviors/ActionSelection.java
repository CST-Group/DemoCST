/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codelets.behaviors;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryContainer;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import java.util.Random;
import org.json.JSONObject;
import support.Constants;
import static support.Constants.HANDS;
import static support.Constants.LEGS;
import ws3dproxy.model.Creature;

/**
 *
 * @author karenlima
 */
public class ActionSelection extends Codelet {
    
    private Memory handsMO;
    private MemoryContainer legsMO;
    private Memory outputLinkIdeaMO;
    private Idea outputLinkIdea;
    Creature creature;
    private int counter = 10;
    private double[] pos; 
    
    public int width;
    public int height;
    
    public ActionSelection(Creature c, int w, int h) {
        this.creature = c;
        this.width = w;
        this.height = h;
        this.name = "ActionSelection";
    }

    @Override
    public void accessMemoryObjects() {
        outputLinkIdeaMO=(MemoryObject)this.getInput(Constants.OUTPUT_LINK_MO);
        outputLinkIdea = (Idea) outputLinkIdeaMO.getI();
        
        handsMO=(MemoryObject)this.getOutput(HANDS);
        legsMO=(MemoryContainer)this.getOutput(LEGS);
    }

    @Override
    public void calculateActivation() {
    }

    @Override
    public void proc() {
        if(outputLinkIdea != null){
            
            Idea nextAction = getNextAction(outputLinkIdea);
            if(nextAction == null) return;
            
            JSONObject message = new JSONObject();
            if("MOVE".equals(nextAction.getName())) {
                if(nextAction.get("X") == null) {
                    pos = getRandomPosition();
                    message.put("ACTION", "GOTO");
                    message.put("X", pos[0]);
                    message.put("Y", pos[1]);
                    message.put("SPEED", 1);
                } else {
                    double posX = (double) ((Idea) nextAction.get("X").getValue()).getValue();
                    double posY = (double) ((Idea) nextAction.get("Y").getValue()).getValue();
                    message.put("ACTION", "GOTO");
                    message.put("X", posX);
                    message.put("Y", posY);
                    message.put("SPEED", 1);
                }
                legsMO.setI(message.toString(), 1.0, name);
            } else{
                if("GET".equals(nextAction.getName())) {
                    String objectName = (String) ((Idea) nextAction.get("Name").getValue()).getValue();
                    message.put("ACTION", "PICKUP");
                    message.put("OBJECT", objectName);
                } else if("EAT".equals(nextAction.getName())) {
                    String objectName = (String) ((Idea) nextAction.get("Name").getValue()).getValue();
                    message.put("ACTION", "EATIT");
                    message.put("OBJECT", objectName);
                }
                handsMO.setI(message.toString());
            }
        }
    }
    
    private Idea getNextAction(Idea outputLinkIdea) {
        Idea nextAction = null;
        if(outputLinkIdea.get("MOVE") != null) {
            nextAction = outputLinkIdea.get("MOVE");
        } else if(outputLinkIdea.get("GET") != null) {
            nextAction = outputLinkIdea.get("GET");
        } else if(outputLinkIdea.get("DELIVER") != null) {
            nextAction = outputLinkIdea.get("DELIVER");
        } else if(outputLinkIdea.get("HIDE") != null) {
            nextAction = outputLinkIdea.get("HIDE");
        } else if(outputLinkIdea.get("EAT") != null) {
            nextAction = outputLinkIdea.get("EAT");
        } else if(outputLinkIdea.get("plan") != null) {
            Idea actionZeroFromPlan = outputLinkIdea.get("plan").get("0");
            Idea actionZeroFromPlanName = actionZeroFromPlan.getL().get(0);
            nextAction = actionZeroFromPlanName.getL().get(0);
        }
        return nextAction;
    }
    
    private double[] getRandomPosition() {
        if(counter == 10){
            counter = 0;
            Random r = new Random();
            double x = r.nextInt(width);
            double y =  r.nextInt(height);
            pos = new double[]{x, y};
        } 
        counter++;
        return pos;
    }
}
