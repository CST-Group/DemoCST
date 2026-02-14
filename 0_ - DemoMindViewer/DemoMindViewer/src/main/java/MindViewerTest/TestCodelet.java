/**
 * 
 */
package MindViewerTest;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.exceptions.CodeletActivationBoundsException;
import br.unicamp.cst.util.viewer.Inspectable;

/**
 * 
 * @author gudwin
 *
 */
public class TestCodelet extends Codelet implements Inspectable{
    
        boolean ascending = true;
        CustomView customView;

	public TestCodelet(String name) {
		setName(name);
                customView = new CustomView();
	}

	@Override
	public void accessMemoryObjects() {
		
	}

	@Override
	public void calculateActivation() {
            double currentactivation = getActivation();
            if (ascending) {
                try {
                    setActivation(getActivation()+0.1);
                } catch (CodeletActivationBoundsException e) {
                    ascending = !ascending;
                    customView.updateInfo(ascending);
                }
            }
            else {
                try {
                    setActivation(getActivation()-0.1);
                } catch (CodeletActivationBoundsException e) {
                    ascending = !ascending;
                    customView.updateInfo(ascending);
                }
            }
	}

	@Override
	public void proc() {
		
	}

        @Override
        public void inspect() {
            customView.setVisible(true);

        }

}
