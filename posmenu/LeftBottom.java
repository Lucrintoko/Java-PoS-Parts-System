package posmenu;

import javax.swing.*;
import java.awt.*;

public class LeftBottom {
    JLabel namePanel, userImage;
    JPanel panel;

    public LeftBottom() {

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(45, 45, 45));

        
        ImageIcon icon = new ImageIcon("assets/user.png");
        Image scaled = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        userImage = new JLabel(new ImageIcon(scaled));
        userImage.setHorizontalAlignment(SwingConstants.CENTER);

        
        namePanel = new JLabel("Nash Francisco"); //Temporary name for now since idk what to put 
        namePanel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        namePanel.setForeground(Color.WHITE);
        namePanel.setHorizontalAlignment(SwingConstants.CENTER);

        
        panel.add(userImage, BorderLayout.CENTER);
        panel.add(namePanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}
