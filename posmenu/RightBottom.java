package posmenu;

import javax.swing.*;
import java.awt.*;

public class RightBottom {
    private JPanel panel;
    private JLabel statusLabel;
    private JComboBox<String> paymentOptions;

    
    public RightBottom() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(new Color(40, 40, 40)); 

        
        statusLabel = new JLabel("Status: Ready");
        statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        String[] methods = {"Cash", "Credit Card", "GCash", "PayMaya"};
        paymentOptions = new JComboBox<>(methods);
        paymentOptions.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        
        panel.add(statusLabel);
        panel.add(paymentOptions);
    }

    
    public JPanel getPanel() {
        return panel;
    }

    
    public void setStatus(String status) {
        statusLabel.setText("Status: " + status);
    }

    
    public String getSelectedPayment() {
        return (String) paymentOptions.getSelectedItem();
    }
}
