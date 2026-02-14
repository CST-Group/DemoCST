/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codelets.perception;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.representation.idea.Idea;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import support.Constants;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

/**
 *
 * @author karenlima
 */
public class SoarInputLinkGenerator extends Codelet {
    
    private Memory visionMO;
    private Memory inputLinkIdeaMO;
    private Idea inputLinkIdea;
    private Creature c;
    
    List<Thing> vision;
    
    public SoarInputLinkGenerator(Creature c) {
        this.c = c;
        this.name = "SoarInputLinkGenerator";
    }

    @Override
    public void accessMemoryObjects() {
        synchronized(this) {
            this.visionMO=(MemoryObject)this.getInput(Constants.VISION_MO);
        }
        inputLinkIdeaMO=(MemoryObject)this.getOutput(Constants.INPUT_LINK_MO);
        inputLinkIdea = (Idea) inputLinkIdeaMO.getI();
    }

    @Override
    public void calculateActivation() {
    }

    @Override
    public void proc() {
        
        synchronized (visionMO) {
            vision = new CopyOnWriteArrayList((List<Thing>) visionMO.getI()); 
            
            prepareInputLink();
            inputLinkIdeaMO.setI(inputLinkIdea);
        }
    }
    
    private void prepareInputLink() {
        synchronized (vision) {
                inputLinkIdea.setL(new CopyOnWriteArrayList<>());
                Idea creatureIdea = new Idea("CREATURE");

                Idea sensorIdea = new Idea("SENSOR");
                Idea visualIdea = new Idea("VISUAL");
                for (Thing t : vision) {
                    Idea entityIdea = new Idea("ENTITY");
                    entityIdea.add(new Idea("DISTANCE", GetGeometricDistanceToCreature(t.getX1(),t.getY1(),t.getX2(),t.getY2(),c.getPosition().getX(),c.getPosition().getY())));
                    entityIdea.add(new Idea("X", t.getX1()));
                    entityIdea.add(new Idea("Y", t.getY1()));
                    entityIdea.add(new Idea("X2", t.getX2()));
                    entityIdea.add(new Idea("Y2", t.getY2()));
                    entityIdea.add(new Idea("TYPE", getItemType(t.getCategory())));
                    entityIdea.add(new Idea("NAME", t.getName()));
                    entityIdea.add(new Idea("COLOR",ws3dproxy.util.Constants.getColorName(t.getMaterial().getColor())));

                    visualIdea.add(entityIdea);
                }

                sensorIdea.add(visualIdea);

                Idea fuelIdea = new Idea("FUEL");
                Idea fuelValueIdea = new Idea("VALUE", c.getFuel());
                fuelIdea.add(fuelValueIdea);
                sensorIdea.add(fuelIdea);
                creatureIdea.add(sensorIdea);

                Idea positionIdea = new Idea("POSITION");
                Idea creaturePositionXIdea = new Idea("X", c.getPosition().getX());
                Idea creaturePositionYIdea = new Idea("Y", c.getPosition().getY());
                positionIdea.add(creaturePositionXIdea);
                positionIdea.add(creaturePositionYIdea);
                creatureIdea.add(positionIdea);

                Idea parametersIdea = new Idea("PARAMETERS");
                Idea minFuelIdea = new Idea("MINFUEL", 400.0);
                parametersIdea.add(minFuelIdea);
                Calendar lCDateTime = Calendar.getInstance();
                Idea timestampIdea = new Idea("TIMESTAMP", lCDateTime.getTimeInMillis());
                parametersIdea.add(timestampIdea);
                creatureIdea.add(parametersIdea);
                inputLinkIdea.add(creatureIdea);
            }
            
        }
    
    private String getItemType(int categoryType) {
        String itemType = null;
        switch (categoryType) {
            case ws3dproxy.util.Constants.categoryBRICK:
                itemType = "BRICK";
                break;
            case ws3dproxy.util.Constants.categoryJEWEL:
                itemType = "JEWEL";
                break;
            case ws3dproxy.util.Constants.categoryFOOD:
            case ws3dproxy.util.Constants.categoryNPFOOD:
            case ws3dproxy.util.Constants.categoryPFOOD:
                itemType = "FOOD";
                break;
            case ws3dproxy.util.Constants.categoryCREATURE:
                itemType = "CREATURE";
                break;
            case ws3dproxy.util.Constants.categoryDeliverySPOT:
                itemType = "DELIVERY";
                break;
        }
        return itemType;
    }
    
    private double GetGeometricDistanceToCreature(double x1, double y1, double x2, double y2, double xCreature, double yCreature) {
          float squared_dist = 0.0f;
          double maxX = Math.max(x1, x2);
          double minX = Math.min(x1, x2);
          double maxY = Math.max(y1, y2);
          double minY = Math.min(y1, y2);

          if(xCreature > maxX)
          {
            squared_dist += (xCreature - maxX)*(xCreature - maxX);
          }
          else if(xCreature < minX)
          {
            squared_dist += (minX - xCreature)*(minX - xCreature);
          }

          if(yCreature > maxY)
          {
            squared_dist += (yCreature - maxY)*(yCreature - maxY);
          }
          else if(yCreature < minY)
          {
            squared_dist += (minY - yCreature)*(minY - yCreature);
          }

          return Math.sqrt(squared_dist);
    }
}
