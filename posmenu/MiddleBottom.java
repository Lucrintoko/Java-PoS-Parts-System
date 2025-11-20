package posmenu;

import javax.swing.*;
import java.awt.*;

public class MiddleBottom {
    private JPanel panel;
    private JButton checkoutButton, clearButton, exitButton;
    private JLabel totalLabel;

    
    public MiddleBottom() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1)); 
        panel.setBackground(new Color(50, 50, 50));

        
        totalLabel = new JLabel("Total: ₱0.00");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        buttonPanel.setBackground(new Color(50, 50, 50));

        checkoutButton = new JButton("Checkout");
        clearButton = new JButton("Clear Cart");
        exitButton = new JButton("Exit");

        
        buttonPanel.add(checkoutButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        
        panel.add(totalLabel);
        panel.add(buttonPanel);
    }

    
    public JPanel getPanel() {
        return panel;
    }

    
    public void setTotal(double amount) {
        totalLabel.setText("Total: ₱" + String.format("%.2f", amount));
    }
}
