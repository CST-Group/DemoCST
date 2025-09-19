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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoar.kernel.memory.Wme;
import org.jsoar.kernel.symbols.Identifier;
import org.jsoar.kernel.symbols.Symbol;
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
            
            List<Idea> nextActions = getNextActions(outputLinkIdea);
            if(nextActions == null || nextActions.isEmpty()) return;
                for(Idea nextAction : nextActions) {
                     JSONObject message = new JSONObject();
                    if("IMPASSE_INFO".equals(nextAction.getName())){
                        showImpasseInfo(nextAction);
                        continue;
                    }

                    if("INPUT_LINK".equals(nextAction.getName())){
                        saveInputLink(nextAction);
                        continue;
                    }

                    if("MOVE".equals(nextAction.getName())) {
                        if(nextAction.get("X") == null) {
                            pos = getRandomPosition();
                            message.put("ACTION", "GOTO");
                            message.put("X", pos[0]);
                            message.put("Y", pos[1]);
                            message.put("SPEED", 1);
                        } else {
                            double posX = (double) nextAction.get("X").getValue();
                            double posY = (double) nextAction.get("Y").getValue();
                            message.put("ACTION", "GOTO");
                            message.put("X", posX);
                            message.put("Y", posY);
                            message.put("SPEED", 1);
                        }
                        legsMO.setI(message.toString(), 1.0, name);
                    } else {
                        if("GET".equals(nextAction.getName())) {
                            String objectName = (String) nextAction.get("Name").getValue();
                            message.put("ACTION", "PICKUP");
                            message.put("OBJECT", objectName);
                        } else if("EAT".equals(nextAction.getName())) {
                            String objectName = (String) nextAction.get("Name").getValue();
                            message.put("ACTION", "EATIT");
                            message.put("OBJECT", objectName);
                        }
                        handsMO.setI(message.toString());
                    }

            }
        }
    }
    
    private List<Idea> getNextActions(Idea outputLinkIdea) {
        
        List<Idea> nextActions = new ArrayList<>();
        if(outputLinkIdea.get("MOVE") != null) {
            nextActions.add(outputLinkIdea.get("MOVE"));
        } 
        if(outputLinkIdea.get("GET") != null) {
            nextActions.add(outputLinkIdea.get("GET"));
        } 
        if(outputLinkIdea.get("DELIVER") != null) {
            nextActions.add(outputLinkIdea.get("DELIVER"));
        } 
        if(outputLinkIdea.get("HIDE") != null) {
            nextActions.add(outputLinkIdea.get("HIDE"));
        }
        if(outputLinkIdea.get("EAT") != null) {
            nextActions.add(outputLinkIdea.get("EAT"));
        } 
        if(outputLinkIdea.get("IMPASSE_INFO") != null) {
            nextActions.add(outputLinkIdea.get("IMPASSE_INFO"));
        }
        if(outputLinkIdea.get("INPUT_LINK") != null) {
            nextActions.add(outputLinkIdea.get("INPUT_LINK"));
            System.out.println("Detectou input link");
        } 
        if(outputLinkIdea.get("plan") != null) {
            Idea actionZeroFromPlan = outputLinkIdea.get("plan").get("0");
            Idea actionZeroFromPlanName = actionZeroFromPlan.getL().get(0);
            nextActions.add(actionZeroFromPlanName.getL().get(0));
        }
        return nextActions;
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
    
    private static void showImpasseInfo(Idea impasseOutputLinkIdea) {
        StringBuilder impasseInfo = new StringBuilder();
        exportIdeaGraph(impasseOutputLinkIdea, impasseInfo, 0);
        System.out.println("Impasse happened. This are the impasse infos:\n" + impasseInfo.toString());
    }
    
    private static void saveInputLink(Idea impasseInputLinkIdea) {
        StringBuilder inputLink = new StringBuilder();
        exportIdeaGraph(impasseInputLinkIdea, inputLink, 0);
        try {
            Files.write(Paths.get("inputlink.txt"), inputLink.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(ActionSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Input link is in file 'inputlink.txt'");
    }
    
    
 public static void exportIdeaGraph(Idea idea, StringBuilder builder, int indentLevel) {
        String indent = "   ".repeat(indentLevel);
        
        // Se tiver subideias na lista, percorre cada uma
        if (!idea.getL().isEmpty()) {
            builder.append(indent).append("* ").append(idea.getName()).append("\n");
            for (Idea subIdea : idea.getL()) {
                exportIdeaGraph(subIdea, builder, indentLevel + 1);
            }
        } else {
            if (idea.getValue() instanceof Idea) {
                exportIdeaGraph((Idea) idea.getValue(), builder, indentLevel);
            } else {
                builder.append(indent).append("- ").append(idea.getName())
                   .append(": ").append(String.valueOf(idea.getValue())).append("\n");
            }
            
        }

        
    }


}
