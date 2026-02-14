package support;

import javax.swing.*;

public class BehaviorCustomView extends JFrame {

    private JTextArea textArea;

    private double inputFromGoals = 0.0;
    private double inputFromState = 0.0;
    private double spreadBw = 0.0;
    private double spreadFw = 0.0;
    private double activation = 0.0;
    private double activationWhenActive = 0.0;
    private boolean isExecutable = false;
    private boolean isActive = false;
    

    public BehaviorCustomView(String name) {
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

    private void refreshText() {
    StringBuilder sb = new StringBuilder();
        sb.append("Input from goals: ").append(String.format("%.2f", inputFromGoals)).append("\n");
        sb.append("Input from state: ").append(String.format("%.2f", inputFromState)).append("\n");
        sb.append("Spread bw: ").append(String.format("%.2f", spreadBw)).append("\n");
        sb.append("Spread fw: ").append(String.format("%.2f", spreadFw)).append("\n");
        sb.append("Activation: ").append(String.format("%.2f", activation)).append("\n");
        sb.append("Activation when active: ").append(String.format("%.2f", activationWhenActive)).append("\n");
        sb.append("Is executable: ").append(isExecutable).append("\n");
        sb.append("Is active: ").append(isActive).append("\n");
        textArea.setText(sb.toString());
    }

    public void updateInputFromGoals(double value) {
        this.inputFromGoals = value;
        refreshText();
    }

    public void updateInputFromState(double value) {
        this.inputFromState = value;
        refreshText();
    }

    public void updateSpreadBw(double value) {
        this.spreadBw = value;
        refreshText();
    }

    public void updateSpreadFw(double value) {
        this.spreadFw = value;
        refreshText();
    }
    
    public void updateActivation(double value) {
        this.activation = value;
        refreshText();
    }
    
    public void updateActivationWhenActive(double value) {
        this.activationWhenActive = value;
        refreshText();
    }
    
    public void updateExecutable(boolean value) {
        this.isExecutable = value;
        refreshText();
    }
    
    public void updateIsActive(boolean value) {
        this.isActive = value;
        refreshText();
    }
}
