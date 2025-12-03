package menumodules.leftpanel.subpanels;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class BottomSubPanel extends JPanel
    {

        public BottomSubPanel ()
            {
                //JPanel Default Configurations
                this.setLayout(new GridBagLayout());
                this.setBackground(Color.BLACK);

                //Insantiating GridBagConstraints for ease of use
                GridBagConstraints gbc = new GridBagConstraints();

                // Font Loading
                Font customFont;
                try 
                    {
                        File fontFile = new File("menumodules/fonts/Montserrat-Bold.ttf");
                        customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(22f);
                    } 
                catch (Exception e) 
                    {
                        customFont = new Font("Segoe UI", Font.BOLD, 22);
                    }

                // --- Vertical Spacer ---
                // Pushes the profile to the bottom
                gbc.gridx = 0; 
                gbc.gridy = 0; // Start at row 0
                gbc.weightx = 1.0;
                gbc.weighty = 1.0; // Absorb all extra vertical space
                gbc.fill = GridBagConstraints.BOTH; // Allow it to expand
                this.add(new JLabel(), gbc); 
                
                // --- User Profile Pill ---
                JPanel userPill = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setColor(Color.BLACK);
                        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 50, 50); // Pill shape background
                        
                        // Draw Border
                        g2.setColor(Color.WHITE);
                        g2.setStroke(new BasicStroke(1)); // Thin border
                        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 50, 50);
                        
                        g2.dispose();
                    }
                };
                userPill.setLayout(new GridBagLayout());
                userPill.setOpaque(false);
                
                // Inner Layout for Pill
                GridBagConstraints pillGbc = new GridBagConstraints();
                pillGbc.insets = new Insets(10, 10, 10, 15);
                
                // Avatar Circle
                JLabel avatarLabel = new JLabel("NF", SwingConstants.CENTER) {
                     @Override
                     protected void paintComponent(Graphics g) {
                         Graphics2D g2 = (Graphics2D) g.create();
                         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                         g2.setColor(new Color(40, 70, 160)); // Blue color
                         g2.fillOval(0, 0, getWidth(), getHeight());
                         g2.dispose();
                         super.paintComponent(g);
                     }
                };
                avatarLabel.setForeground(Color.WHITE);
                avatarLabel.setFont(customFont.deriveFont(14f)); 
                avatarLabel.setPreferredSize(new Dimension(40, 40)); // Circle size
                
                pillGbc.gridx = 0;
                userPill.add(avatarLabel, pillGbc);

                // Name Label
                JLabel nameLabel = new JLabel("Nash Francisco");
                nameLabel.setForeground(Color.WHITE);
                nameLabel.setFont(customFont.deriveFont(18f));
                
                pillGbc.gridx = 1;
                userPill.add(nameLabel, pillGbc);
                
                // Add Pill to Main Panel
                gbc.gridy = 1; // Now in row 1
                gbc.weighty = 0; // Reset weight
                gbc.fill = GridBagConstraints.NONE;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(0, 20, 30, 0); // Padding from left and bottom
                this.add(userPill, gbc);
            }
    }