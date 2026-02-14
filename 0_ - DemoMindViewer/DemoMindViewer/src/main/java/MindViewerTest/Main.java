/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindViewerTest;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryContainer;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.io.rest.RESTServer;
import br.unicamp.cst.representation.idea.Idea;
import br.unicamp.cst.util.viewer.MindViewer;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author rgudwin
 */
public class Main {
    
    Mind m;
    Boolean enablePlanSubsytem = true;
    
    void updateMemoryObject(MemoryObject mo) {
        Object o = mo.getI();
        if (o instanceof Double) {
            double value = (double) mo.getI();
            mo.setI(value+0.01);
        }
        else if (o instanceof Point2D.Double) {
            Point2D.Double p = (Point2D.Double) o;
            p.x += 0.01;
            p.y -= 0.01;
        }
        else if (o instanceof Idea) {
            Idea id = (Idea) o;
            Idea idea1 = id.get("idea2");
            if (idea1.getValue() instanceof Double) {
                double value = (double) idea1.getValue();
                idea1.setValue(value+0.01);
            }
            Idea ideap = id.get("idea15.profunda");
            if (idea1.getValue() instanceof Double) {
                double value = (double) ideap.getValue();
                ideap.setValue(value+0.01);
            }
        }
        else mo.setI(o);
    }
    
    void updateMemoryContainer(MemoryContainer mc) {
        for (Memory mem : mc.getAllMemories()) {
            if (mem.getClass().getCanonicalName().equalsIgnoreCase("br.unicamp.cst.core.entities.MemoryObject")) {
                updateMemoryObject((MemoryObject)mem);
                //System.out.println("Updating subnode");
            }    
        }
    }

    void updateMind() {
        //System.out.println("Updating Mind");
        for (Memory mem : m.getRawMemory().getAllMemoryObjects()) {
            if (mem.getName().equalsIgnoreCase("PlanningMemory")) continue;
            if (mem.getClass().getCanonicalName().equalsIgnoreCase("br.unicamp.cst.core.entities.MemoryObject")) {
                updateMemoryObject((MemoryObject)mem);
            }
            if (mem.getClass().getCanonicalName().equalsIgnoreCase("br.unicamp.cst.core.entities.MemoryContainer")) {
                updateMemoryContainer((MemoryContainer)mem);
            }
        }
        
    }
    
    public void StartTimer() {
        Timer t = new Timer();
        Main.mainTimerTask tt = new Main.mainTimerTask(this);
        t.scheduleAtFixedRate(tt, 0, 100);
    }

    public void tick() {
        if (m != null) {
            updateMind();
        } else {
            System.out.println("Mind is null");
        }
        //System.out.println("update");
    }
    
    class mainTimerTask extends TimerTask {

        Main wov;
        boolean enabled = true;

        public mainTimerTask(Main wovi) {
            wov = wovi;
        }

        public void run() {
            if (enabled) {
                wov.tick();
            }
        }

        public void setEnabled(boolean value) {
            enabled = value;
        }
    }
    
    
    public Mind prepareMind() {
        m = new Mind();
        m.createCodeletGroup("Sensory");
        m.createCodeletGroup("Perception");
        m.createCodeletGroup("Behavioral");
        m.createCodeletGroup("Motivational");
        m.createCodeletGroup("Motor");
        m.createMemoryGroup("StandardMemories");
        m.createMemoryGroup("Containers");
        
        MemoryObject m1 = m.createMemoryObject("M1", 1.12);
        m.registerMemory(m1,"StandardMemories");
        MemoryObject m2 = m.createMemoryObject("M2", 2.32);
        m.registerMemory(m2,"StandardMemories");
        MemoryObject m3 = m.createMemoryObject("M3", 3.44);
        m.registerMemory(m3,"StandardMemories");
        Point2D.Double p = new Point2D.Double(0,0);
        MemoryObject m4 = m.createMemoryObject("M4", p);
        m.registerMemory(m4,"StandardMemories");
        MemoryObject m5 = m.createMemoryObject("M5", 5.12);
        m.registerMemory(m5,"StandardMemories");
        MemoryContainer m6 = m.createMemoryContainer("C1");
        m.registerMemory(m6,"Containers");
        MemoryContainer m7 = m.createMemoryContainer("C2");
        m.registerMemory(m7,"Containers");
        int mc1 = m7.setI(7.55, 0.23);
        int mc2 = m6.setI(6.33, 0.22);
        int mc3 = m6.setI(6.12, 0.13);
        int mc4 = m6.add(m7);
        Idea idea = new Idea("idea","","AbstractObject",1);
        idea.add(new Idea("idea1",0.1D,"Property",1));
        idea.add(new Idea("idea2",0.2D,"Link",1));
        idea.add(new Idea("idea3",0.3D,"QualityDimension",1));
        idea.add(new Idea("idea4",0.4D,"Episode",1));
        idea.add(new Idea("idea5",0.5D,"Composite",1));
        idea.add(new Idea("idea6",0.6D,"Aggregate",1));
        idea.add(new Idea("idea7",0.7D,"Configuration",1));
        idea.add(new Idea("idea8",0.8D,"TimeStep",1));
        idea.add(new Idea("idea9",0.9D,"Property",2));
        idea.add(new Idea("idea10",1.0D,"AbstractObject",2));
        idea.add(new Idea("idea11",1.1D,"Episode",2));
        idea.add(new Idea("idea12",1.2D,"Property",0));
        idea.add(new Idea("idea13",1.3D,"AbstractObject",0));
        idea.add(new Idea("idea14",1.4D,"Episode",0));
        Idea idea15 = new Idea("idea15",1.5D,"Episode",0);
        Idea profunda = new Idea("profunda",1.6D,"Episode",0);
        Idea profunda2 = new Idea("profunda2",1.7D,"Episode",2);
        profunda.add(profunda2);
        idea15.add(profunda);
        idea.add(idea15);
        //idea.setCategory("Property");
        //idea.setScope(1);
        m5.setI(idea);
        //System.out.println("Memories: "+mc1+" "+mc2+" "+mc3+" "+mc4);
        
        Codelet c = new TestCodelet("Sensor1");
        c.addInput(m1);
        c.addInput(m2);
        c.addOutput(m3);
        c.addOutput(m4);
        c.addBroadcast(m5);
        m.insertCodelet(c,"Sensory");
        Codelet c2 = new TestCodelet("Motor1");
        c2.addInput(m4);
        c2.addInput(m5);
        c2.addOutput(m6);
        c2.addOutput(m3);
        c2.addBroadcast(m5);
        m.insertCodelet(c2,"Motor");
        
        Codelet mot1 = new TestCodelet("Curiosity");
        mot1.addInput(m7);
        mot1.addOutput(m5);
        m.insertCodelet(mot1,"Motivational");
        Codelet mot2 = new TestCodelet("Fear");
        mot2.addInput(m3);
        mot2.addOutput(m4);
        try {mot2.setActivation(1.0);} catch(Exception e){}
        m.insertCodelet(mot2,"Motivational");
        Codelet mot3 = new TestCodelet("Anger");
        mot3.addInput(m1);
        mot3.addOutput(m2);
        try {mot3.setActivation(0.5);} catch(Exception e){}
        m.insertCodelet(mot3,"Motivational");
        
        
        if(enablePlanSubsytem) {
            m.createCodeletGroup("Planning");
            Codelet testPlanningCodelet = new TestPlanningCodelet("JSoarCodelet");
            m.insertCodelet(testPlanningCodelet, "Planning");
        }
        
        m.start();
        return(m);
    }
    
private void createAndShowGUI(Mind m) {
        MindViewer mv = new MindViewer(m,"MindViewer",m.getCodeletGroupList("Motor"));
        mv.setVisible(true);
    }   

public Main() {
    Mind m = prepareMind();
    // The next line can be commented if you don't want the Desktop MindViewer
    createAndShowGUI(m);
    // The next line can be commented if you don't use the MindViewer Web
    RESTServer rs = new RESTServer(m,5000,true);
}
    
    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.StartTimer();
    }
    
}
