/**
 * 
 */
package MindViewerTest;

import br.unicamp.cst.bindings.soar.JSoarCodelet;
import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.core.exceptions.CodeletActivationBoundsException;
import br.unicamp.cst.representation.idea.Idea;
import br.unicamp.cst.util.viewer.Inspectable;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author gudwin
 *
 */
public class TestPlanningCodelet extends JSoarCodelet {
        private static String soarRulesPath = "soarPlanning.soar";
        private static String soarFileRulesPath = "/soarRules/soarPlanning.soar";
        Idea mockInputLinkIdea;
        Boolean first = true;
        
	public TestPlanningCodelet(String name) {
            try {
                NativeUtils.loadFileFromJar(soarFileRulesPath);
            } catch (IOException ex) {
                Logger.getLogger(TestPlanningCodelet.class.getName()).log(Level.SEVERE, null, ex);
            }
            setName(name);
            initSoarPlugin("agent", new File(soarRulesPath), false);
            createMockInpuLinkIdea();
            
	}

	@Override
	public void accessMemoryObjects() {
	}

	@Override
	public void calculateActivation() {
	}

	@Override
	public void proc() {
            setInputLinkIdea(mockInputLinkIdea);
            if (getDebugState() == 0) {
                getJsoar().step();
            }
	}
        
        private void createMockInpuLinkIdea() {
            mockInputLinkIdea = new Idea("InputLink",null,"AbstractObject",1);
            Idea creatureIdea = new Idea("CREATURE", null,"AbstractObject", 1);
            creatureIdea.add(new Idea("NAME", "agent_1","Property", 1));
            mockInputLinkIdea.add(creatureIdea);

        }

}
