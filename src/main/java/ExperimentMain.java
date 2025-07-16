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
import java.util.Random;

/**
 *
 * @author rgudwin
 */
public class ExperimentMain {
    public Logger logger = Logger.getLogger(ExperimentMain.class.getName());

    public ExperimentMain(String agentType, String growOption) {
        Logger.getLogger("codelets").setLevel(Level.SEVERE);
        // Create Environment
        Environment env=new Environment(growOption); //Creates only a creature and some apples
        String creatureName = env.c.getName();
        switch (agentType) {
            case "soar":
                AgentMindJSoar aJsoar1 = new AgentMindJSoar(env.c, env.c.getName()); 
                MindViewer mvAJsoar1 = new MindViewer(aJsoar1,"MindViewer - Agent Soar " + creatureName, null);
                mvAJsoar1.setVisible(true);
                break;
            case "default":
                AgentMindDefault a1 = new AgentMindDefault(env.c, "AgentDefault " +  creatureName);
                MindViewer mv = new MindViewer(a1,"MindViewer - AgentDefault " + creatureName, a1.behavioralCodelets);
                mv.setVisible(true);
                break;
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        /** 
         * aqui vai pegar o args e de acordo com cada tipo criar um agente diferente
         * soar, bn, default, vehicle, habits
         * define se vai usar o grow também com a flag -g food jewel
         * se for só '-g' ou '-g food jewel', cresce food e jewel - envia a string "grow"
         * se for só '-g food' cresce food- envia a string "grow-fodd"
         * se for só '-g jewel' cresce só jewel - envia a string "grow-jewel"
         * mandar como argumento do ExperimentMain essas informações, um com a string do tipo e um com a string de grow
        **/
        String agentType = "default"; 
        String growOption = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "soar":
                case "bn":
                case "default":
                case "vehicle":
                case "habits":
                    agentType = args[i];
                    System.out.println("AgentType: " + agentType);
                    break;
                case "-g":
                    if (i + 1 < args.length) {
                        if ("food".equals(args[i + 1]) && i + 2 < args.length && "jewel".equals(args[i + 2])) {
                            growOption = "grow";
                            i += 2;
                        } else if ("food".equals(args[i + 1])) {
                            growOption = "grow-food";
                            i++;
                        } else if ("jewel".equals(args[i + 1])) {
                            growOption = "grow-jewel";
                            i++;
                        } else {
                            growOption = "grow"; // default: ativa ambos se nenhum especificado
                        }
                    } else {
                        growOption = "grow";
                    }
                    break;
                default:
                    System.out.println("Unkown arg: " + args[i]);
                    break;
            }
        }
            ExperimentMain em = new ExperimentMain(agentType, growOption);
    }

}
