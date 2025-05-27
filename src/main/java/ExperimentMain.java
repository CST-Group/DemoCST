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

import br.unicamp.cst.util.viewer.MindViewer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rgudwin
 */
public class ExperimentMain {
	
	
        
        public Logger logger = Logger.getLogger(ExperimentMain.class.getName());
        
        
        public ExperimentMain() {
            Logger.getLogger("codelets").setLevel(Level.SEVERE);
            // Create Environment
            Environment env=new Environment(); //Creates only a creature and some apples
            AgentMindDefault a1 = new AgentMindDefault(env.cDefault, "AgentDefault1");  // Creates the Agent Mind and start it   
            // The following lines create the MindViewer and configure it 
            MindViewer mv = new MindViewer(a1,"MindViewer",a1.behavioralCodelets);
            mv.setVisible(true);
            
            AgentMindDefault a2 = new AgentMindDefault(env.cDefault2, "AgentDefault2"); 
            MindViewer mv2 = new MindViewer(a2,"MindViewer",a2.behavioralCodelets);
            mv2.setVisible(true);
            
            AgentMindJSoar aJsoar1 = new AgentMindJSoar(env.cJSoar1, env.cJSoar1.getName()); 
            MindViewer mvAJsoar1 = new MindViewer(aJsoar1,"MindViewer  Agent Soar 1", null);
            mvAJsoar1.setVisible(true);
            
            AgentMindJSoar aJsoar2 = new AgentMindJSoar(env.cJSoar2, env.cJSoar2.getName()); 
            MindViewer mvAJsoar2 = new MindViewer(aJsoar2,"MindViewer Agent Soar 2", null);
            mvAJsoar2.setVisible(true);
            
        }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExperimentMain em = new ExperimentMain();
	}

}
