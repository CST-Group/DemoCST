package support;

import java.util.ArrayList;
import javax.swing.*;

public class WorldStateCustomView extends JFrame {

    private JTextArea textArea;
    
    private ArrayList<String> lastDifferentWorldState = new ArrayList();
    private ArrayList<String> currentWorldState = new ArrayList();
    

    public WorldStateCustomView(String name) {
        setTitle(name);
        initComponents();
    }

    private void initComponents() {
        textArea = new JTextArea();
        textArea.setFont(new java.awt.Font("Liberation Sans", 0, 16));
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setOpaque(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Usando um JScrollPane para o caso do texto crescer
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        getContentPane().add(scrollPane);

        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    // Atualiza o texto inteiro baseado nos valores atuais
    private void refreshText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current World State\n");
        for(String state : currentWorldState) {
            sb.append(state).append("\n");
        }
        if(lastDifferentWorldState.size() > 0) {
            sb.append("\nLast World State\n");
            for(String state : lastDifferentWorldState) {
                sb.append(state).append("\n");
            }
        }  
        textArea.setText(sb.toString());
    }

    public void updateCurrentWorldState(ArrayList<String> value) {
        this.currentWorldState = value;
        refreshText();
    }
    
    public void updateLastDifferentWorldState(ArrayList<String> value) {
        this.lastDifferentWorldState = value;
        refreshText();
    }
}
