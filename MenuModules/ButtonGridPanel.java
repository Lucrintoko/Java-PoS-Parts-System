package MenuModules;
import java.awt.*;
import javax.swing.*;

public class ButtonGridPanel extends JPanel 
    {
        //Declaring the Button 3x3 outside of Constructor for ease of tracking
        JPanel buttonGrid;

        String[] names = {
            "Intel", "AMD", "Corsair", "NVIDIA", "Samsung",
            "Crucial", "Sandisk", "G.Skill", "ROG"
        };

        String[] files = {
            "intel.png", "AMDD.png", "corsair.png", "nvidia.png", "samsungg.png",
            "crucial.png", "sandiskk.png", "G.Skill.png", "rog.png"
        };

        Color[] bgColors = {
            new Color(0, 113, 197), //Intel Blue
            Color.RED,                     //AMD 
            Color.WHITE,                   //Corsair 
            new Color(118, 185, 0),//NVIDIA
            new Color(20, 40, 160),//Samsung 
            new Color(189, 3, 247),//Crucial 
            Color.RED,                    //SanDisk
            Color.WHITE,                  //G.Skill 
            Color.BLACK                   //ROG
        };

        Color[] fgColors = {
            Color.WHITE, //Intel Text
            Color.WHITE, //AMD Text
            Color.BLACK, //Corsair Text
            Color.BLACK, //NVIDIA Text
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
        };
        
        public ButtonGridPanel()
            {
                //Setting the Layout Manager of this panel to BorderLayout for ease of formatting
                this.setLayout(new BorderLayout());

                //Insantiating the buttonGrid JPanel 
                buttonGrid = new JPanel(new GridLayout(3, 3, 10, 10));
                //Background of Buttonm Grid as Black
                buttonGrid.setBackground(Color.BLACK);
                //10px Border around entire grid
                buttonGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                //Creation of buttons array to contain every single company
                JButton[] buttons = new JButton[names.length];

                //Creation of each button and adding them to Button Grid
                for (int i = 0; i < names.length; i++)
                    {
                        //Concatenating filePath string to instantly get each file path of image
                        String filePath = "MenuModules/ButtonAssets/" + files[i];

                        //Creation of Button 
                        buttons[i] = createButton(names[i], filePath);
                    
                        //Setting individual Background and Foreground to each button
                        buttons[i].setBackground(bgColors[i]);
                        buttons[i].setForeground(fgColors[i]);

                        //Adding to GridLayout of the panel
                        buttonGrid.add(buttons[i]);
                    }
                
                //Adding to the Panel itself
                this.add(buttonGrid, SwingConstants.CENTER);
            }
        
        private static JButton createButton (String name, String imagePath)
            {
                //Insantiating a Button
                JButton button = new JButton()
                    {
                        @Override
                        protected void paintComponent(Graphics g)
                            {
                                Graphics2D g2 = (Graphics2D) g.create();
                                
                                //Enabling anti-aliasing
                                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            
                                //Painting of the Button Background Color
                                g2.setColor(getBackground());
                                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                                //Handling of Pressed and Hover State of Button
                                if (getModel().isPressed())
                                    {   
                                        g2.setColor(new Color(173, 216, 230, 100));
                                        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                                    }
                                //Hover State
                                else if (getModel().isRollover())
                                    {
                                        g2.setColor(new Color(255, 255, 255, 40));
                                        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                                    }

                                g2.dispose();

                                //Paints image icon on top
                                super.paintComponent(g);
                            }

                        @Override
                        protected void paintBorder (Graphics g)
                            {
                                //Drawing rounded border
                                Graphics2D g2 = (Graphics2D) g.create();
                                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                g2.setColor(Color.BLACK);
                                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                                g2.dispose();
                            }
                    };

                //So that when implementing Action Listener can know what its name is
                button.setActionCommand(name);
                //When user hovers what name it is
                button.setToolTipText(name);

                //Button Configurations
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setBorderPainted(false);
                button.setOpaque(false);

                //Setting the size of the button
                button.setPreferredSize(new Dimension(150, 150));
                //Setting the color of the line border as black
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                //Getting the image via file path
                ImageIcon icon = new ImageIcon(imagePath);

                if (icon.getImage() != null)
                    {
                        //Taking image from file path and setting its size
                        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        button.setIcon(new ImageIcon(img));
                    }
                
                //Adding the image to the button
                button.setHorizontalAlignment(SwingConstants.CENTER);

                return button;
            }
    }
