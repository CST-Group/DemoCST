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
 *    Patricia Rocha de Toro, Elisa Calhau de Castro, Ricardo Ribeiro Gudwin
 *****************************************************************************/
package support;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;
import ws3dproxy.util.Constants;
import ws3dproxy.util.Logger;

/**
 *
 * @author eccastro
 */
public class ResourcesGenerator extends Thread {

    // Variáveis de controle para a lógica solicitada
    private static final int ITEMS_PER_BATCH = 1; // Adiciona 1 por vez
    private static final int MAX_ITEMS_ALLOWED = 1; // Máximo de 3 no mundo
    private int timeInMinutes;
    private List<Thing> allThings = new ArrayList<Thing>();
    private double width;
    private double height;
    private WorldPoint dsLocation;
    private Creature creature;

    public ResourcesGenerator(int timeframe, double envWidth, double envHeight, double xDS, double yDS, Creature c) {
        super("ResourcesGenerator");
        if (timeframe == 0) timeInMinutes = Constants.TIMEFRAME;
        else timeInMinutes = timeframe;
        width = envWidth;
        height = envHeight;
        dsLocation = new WorldPoint(xDS,yDS); //delivery spot
        this.creature = c;
    }

    public void run() {
        generateBrick();
        while (true) {
            try {
                //System.out.println(".......ResourcesGenerator cycle running.........");

                //generate food
                //perishable
                generateFood(0);
                generateJewel(1);
                generateJewel(3);
                //non-perishable
                //generateFood(1);
                ///generate jewels
                //for (int jewelType = 0; jewelType < 6; jewelType++) {
                //    generateJewel(jewelType);
                //}

                //System.out.println("..............ResourcesGenerator SLEEPING........");
                //Thread.sleep(timeInMinutes * 60000);
                Thread.sleep(timeInMinutes * 6000);

            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }

        }

    }

    /**
     * Knuth's algorithm to generate random Poisson distributed numbers
     * @param lambda average rate of success in a Poisson distribution
     * @return random number
     */
    public static int getPoissonRandomNumber(double lambda) {
        int k = 1;
        double p = 1.0;
        Random rd = new Random();

        do {
            k += 1;
            p *= rd.nextDouble();
        } while (p > Math.exp((double) -lambda));
        return k - 1;
    }

    private boolean checkAvailability(double cX, double cY) {
        //discard the location of the DeliverySpot:
        if((dsLocation.getX() == cX) && (dsLocation.getY() == cY)){
            return false;
        }

        for (Thing each : allThings) {
            if (each.secAreaContain(cX, cY)) {
                return false;
            }

        }
        return true;
    }

    private void generateFood(int type) {
        try {
            allThings = World.getWorldEntities();
            removeExcessResources("Red", "Food", 21);
            int number = ITEMS_PER_BATCH;
            Random rdX = new Random();
            Random rdY = new Random();
            double cX, cY;
            String pointListStr = "" ;
            
            for (int i = 0; i < number; i++) {
                do {
                    cX = rdX.nextDouble() * width;
                    cY = rdY.nextDouble() * height;

                } while (!checkAvailability(cX, cY));

                pointListStr = pointListStr+" "+cX+" "+cY;
            }
            World.createFoodInBatch(type, number, pointListStr);
        } catch (CommandExecException ex) {
            Logger.logException(ResourcesGenerator.class.getName(), ex);
        }

    }

    private void generateJewel(int type) {
        try {
            allThings = World.getWorldEntities();
            if(type == 1){
                
                removeExcessResources("Green", "Jewel", 3);
            } else if(type == 3){
                removeExcessResources("Yellow", "Jewel", 3);
            }
            
            int number = ITEMS_PER_BATCH;
            Random rdX = new Random();
            Random rdY = new Random();
            double cX, cY;
            String pointListStr = "" ;
            
            for (int i = 0; i < number; i++) {
                do {
                    cX = rdX.nextDouble() * width;
                    cY = rdY.nextDouble() * height;

                } while (!checkAvailability(cX, cY));

                    pointListStr = pointListStr+" "+cX+" "+cY;
                }
                World.createJewelsInBatch(type, number, pointListStr);
        } catch (CommandExecException ex) {
            Logger.logException(ResourcesGenerator.class.getName(), ex);
        }

    }
    
    private void generateBrick() {
        System.out.println("Creating bricks");
        try {
            World.createBrick(2, 0, 0, width, 0);
            //World.createBrick(3, 100, 100, 30, 30);
            World.createBrick(2, 0, 0, 0, height);
            World.createBrick(2, 0, height, width, height);
            World.createBrick(2, width, 0, width, height);
//            World.createBrick(2, 0, 0, width, height);
//            World.createBrick(2, 0, 0, width, height);
        } catch (CommandExecException ex) {
            Logger.logException(ResourcesGenerator.class.getName(), ex);
        }

    }
    
    // Método auxiliar para limpar os recursos antigos
    private void removeExcessResources(String color, String name, int category) {
        // Filtra a lista allThings para pegar apenas os itens do tipo atual
        // category seria "Food" ou "Jewel" e o type o subtipo (cor ou perecível)
        List<Thing> currentItems = new ArrayList<>();
        try {
            allThings = World.getWorldEntities();
        } catch (CommandExecException ex) {
            java.util.logging.Logger.getLogger(ResourcesGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Thing t : allThings) {
            if (t.getName().contains(name) && t.getAttributes().getCategory()== category) {
                if(t.getAttributes().getCategory() == 3){
                    if(t.getAttributes().getColor().equals(color)) {
                        currentItems.add(t);
                    }
                } else {
                    currentItems.add(t);
                }
            }
        }
        int currentCount = currentItems.size();
        int futureTotal = currentCount + ITEMS_PER_BATCH;
        int toRemove = futureTotal - MAX_ITEMS_ALLOWED;

        if (toRemove > 0) {
            System.out.println("Removendo " + toRemove + " itens antigos de tipo " + category);
            // Remove os primeiros da lista (assumindo que allThings retorna na ordem de criação ou ID crescente)
            for (int i = 0; i < toRemove; i++) {
                try {
                    String nameToRemove = currentItems.get(i).getName();
                    // Chama o comando para deletar do mundo
                    creature.putInSack(nameToRemove);
                    
                } catch (Exception ex) {
                     Logger.logException(ResourcesGenerator.class.getName(), ex);
                }
            }
        }
    }
}
