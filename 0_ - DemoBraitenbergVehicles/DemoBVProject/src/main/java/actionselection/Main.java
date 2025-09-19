package actionselection;

import br.unicamp.cst.util.viewer.MindViewer;
import remoteapi.zmq.RemoteAPIClient;

class Main {

    public static void main(String[] args){
        var client = new RemoteAPIClient();
        var sim = client.getObject().sim();
        AgentMind mind = new AgentMind(sim);
        MindViewer mv = new MindViewer(mind,"MindViewer", mind.codelets);
        mv.setVisible(true);
    }

}
