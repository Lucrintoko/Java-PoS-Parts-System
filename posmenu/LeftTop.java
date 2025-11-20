package posmenu;

import javax.swing.*;
import java.awt.*;

public class LeftTop {
    private JPanel panel;
    private JLabel titleLabel, logoLabel;

    
    public LeftTop() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(33, 33, 33)); 

        
        ImageIcon logoIcon = new ImageIcon("assets/logo.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        titleLabel = new JLabel("POS System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        panel.add(logoLabel, BorderLayout.CENTER);
        panel.add(titleLabel, BorderLayout.SOUTH);
    }


    public JPanel getPanel() {
        return panel;
    }
}
