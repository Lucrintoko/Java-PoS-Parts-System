package menumodules.leftpanel.subpanels;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import menumodules.ProductStorage;

public class TopSubPanel extends JPanel
    {
        JLabel systemNameLabel;

        //Label to store all of the parts inside of ProductStorage.java
        JLabel[] partsLabel, remainingPartsLabel; 
        ProductStorage productStorage;

        public TopSubPanel ()
            {
                //JPanel Default Configurations
                this.setLayout(new GridBagLayout());
                this.setBackground(Color.BLACK);
                this.setPreferredSize(new Dimension(350, 500));
                this.setMinimumSize(new Dimension(350, 300));

                //For setting parameters for the Grid Bag Layout
                GridBagConstraints gbc = new GridBagConstraints();

                //Setting External Padding for the Name of the PoSSystem
                gbc.insets = new Insets(5, 5, 10, 5);

                //Adding internal padding to make sure that it's not too cramped for the text
                gbc.ipady = 12;

                //Ensures that the Labels extend to the maximum width
                gbc.fill = GridBagConstraints.HORIZONTAL;
                
                /*Insantiating the Labels for all the parts of ProductStorage.java (CPU, GPU, SSD, and RAM)
                  [Determines how much of each part still remains]*/
                partsLabel = new JLabel[4];

                partsLabel[0] = new JLabel("CPU");
                partsLabel[1] = new JLabel("GPU");
                partsLabel[2] = new JLabel("SSD");
                partsLabel[3] = new JLabel("RAM");

                for(JLabel label : partsLabel) 
                    {
                        label.setForeground(Color.WHITE);
                    }

                /*Insantiating the Counter of Labels of the parts from ProductStorage.java*/
                remainingPartsLabel = new JLabel[4];

                remainingPartsLabel[0] = new JLabel("()");
                remainingPartsLabel[1] = new JLabel("()");
                remainingPartsLabel[2] = new JLabel("()");
                remainingPartsLabel[3] = new JLabel("()");

                for(JLabel label : remainingPartsLabel) 
                    {
                        label.setForeground(Color.WHITE);
                    }

                //Font Layout for the Title
                Font customFont;
                try 
                    {
                        File fontFile = new File("menumodules/fonts/Montserrat-Bold.ttf");
                        customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(40f);
                    } 
                catch (Exception e) 
                    {
                        // Fallback to a system font if the custom font fails to load
                        customFont = new Font("Segoe UI", Font.BOLD, 40);
                    }

                /*------------------------------- Row 0: Name -------------------------------*/
                //Setting all the Cols to be occupeied by all Labels to 5 Cols Wide
                gbc.gridwidth = 5; 
                //Ensures that all Labels will be at the left
                gbc.gridx = 0; gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.CENTER;
                systemNameLabel = new JLabel("Sparks POS");
                systemNameLabel.setForeground(Color.WHITE);
                systemNameLabel.setFont(customFont);

                //Creating a panel to encompass a bottom border
                JPanel systemNamePanel = new JPanel(new BorderLayout()); //Using BorderLayout for the label
                systemNamePanel.setBackground(Color.BLACK); //Ensuring background is black
                systemNamePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE)); //Applying border to the panel

                //Adding the label to the panel
                systemNamePanel.add(systemNameLabel, BorderLayout.WEST);

                this.add(systemNamePanel, gbc); //Adding the Panel
                
                /*------------------------------- Row 1-4: -------------------------------*/
                /*------------------------------- CPU Row -------------------------------*/
                //Font Configuration for Part Labels
                try 
                    {
                        File fontFile = new File("menumodules/fonts/Montserrat-Bold.ttf");
                        customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(28f);
                    } 
                catch (Exception e) 
                    {
                        // Fallback to a system font if the custom font fails to load
                        customFont = new Font("Segoe UI", Font.BOLD, 28);
                    }
                //Setting Column Occupation back to 1
                gbc.gridwidth = 1;
                // Left Spacer (pushes content to center)
                gbc.gridx = 0; gbc.gridy = 1; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = 1;
                this.add(new JLabel(), gbc);

                // Parts Label (Center)
                gbc.gridx = 1; gbc.gridy = 1; 
                gbc.weightx = 0.0; 
                gbc.anchor = GridBagConstraints.LINE_END;
                partsLabel[0].setFont(customFont);
                this.add(partsLabel[0], gbc);

                // Remaining Parts Label (Center)
                gbc.gridx = 2; gbc.gridy = 1; 
                gbc.weightx = 0.0; 
                gbc.anchor = GridBagConstraints.LINE_START;
                remainingPartsLabel[0].setFont(customFont);
                this.add(remainingPartsLabel[0], gbc);

                // Right Spacer (pushes content to center)
                gbc.gridx = 3; gbc.gridy = 1; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                this.add(new JLabel(), gbc);

                /*------------------------------- GPU Row -------------------------------*/
                // Left Spacer
                gbc.gridx = 0; gbc.gridy = 2; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = 1;
                this.add(new JLabel(), gbc);

                // Parts Label (Center)
                gbc.gridx = 1; gbc.gridy = 2;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.LINE_END;
                partsLabel[1].setFont(customFont);
                this.add(partsLabel[1], gbc);

                // Remaining Parts Label (Center)
                gbc.gridx = 2; gbc.gridy = 2;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.LINE_START;
                remainingPartsLabel[1].setFont(customFont);
                this.add(remainingPartsLabel[1], gbc);

                // Right Spacer
                gbc.gridx = 3; gbc.gridy = 2; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                this.add(new JLabel(), gbc);

                /*------------------------------- SSD Row -------------------------------*/
                // Left Spacer
                gbc.gridx = 0; gbc.gridy = 3; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = 1;
                this.add(new JLabel(), gbc);

                // Parts Label (Center)
                gbc.gridx = 1; gbc.gridy = 3;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.LINE_END;
                partsLabel[2].setFont(customFont);
                this.add(partsLabel[2], gbc);

                // Remaining Parts Label (Center)
                gbc.gridx = 2; gbc.gridy = 3;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.LINE_START;
                remainingPartsLabel[2].setFont(customFont);
                this.add(remainingPartsLabel[2], gbc);

                // Right Spacer
                gbc.gridx = 3; gbc.gridy = 3; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                this.add(new JLabel(), gbc);

                /*------------------------------- RAM Row -------------------------------*/
                // Left Spacer
                gbc.gridx = 0; gbc.gridy = 4; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = 1;
                this.add(new JLabel(), gbc);

                // Parts Label (Center)
                gbc.gridx = 1; gbc.gridy = 4;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.LINE_END;
                partsLabel[3].setFont(customFont);
                this.add(partsLabel[3], gbc);

                // Remaining Parts Label (Center)
                gbc.gridx = 2; gbc.gridy = 4;
                gbc.weightx = 0.0;
                gbc.anchor = GridBagConstraints.LINE_START;
                remainingPartsLabel[3].setFont(customFont);
                this.add(remainingPartsLabel[3], gbc);

                // Right Spacer
                gbc.gridx = 3; gbc.gridy = 4; 
                gbc.weightx = 0.5; 
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                this.add(new JLabel(), gbc);

                // Vertical Spacer to push content to the top
                gbc.gridx = 0; gbc.gridy = 5; // New row below all content
                gbc.gridwidth = GridBagConstraints.REMAINDER; // Span all columns
                gbc.weighty = 1.0; // Absorb all extra vertical space
                gbc.fill = GridBagConstraints.BOTH; // Allow it to expand vertically
                this.add(new JLabel(), gbc); // Add an empty label as a spacer
            }

        //Method to update counters to accurately display what is and what's not available inside of the brand that's selected
        public void updateCounts(String brand, ProductStorage storage) 
            {
                //Taking the individual stock amount of each category
                long cpuCount = storage.getCPUs().stream().filter(p -> p.getBrand().equalsIgnoreCase(brand)).mapToInt(p -> p.getAmount()).sum();
                long gpuCount = storage.getGPUs().stream().filter(p -> p.getBrand().equalsIgnoreCase(brand)).mapToInt(p -> p.getAmount()).sum();
                long ssdCount = storage.getSSDs().stream().filter(p -> p.getBrand().equalsIgnoreCase(brand)).mapToInt(p -> p.getAmount()).sum();
                long ramCount = storage.getRAMs().stream().filter(p -> p.getBrand().equalsIgnoreCase(brand)).mapToInt(p -> p.getAmount()).sum();

                //Setting the amount to the label itself
                remainingPartsLabel[0].setText("(" + cpuCount + ")");
                remainingPartsLabel[1].setText("(" + gpuCount + ")");
                remainingPartsLabel[2].setText("(" + ssdCount + ")");
                remainingPartsLabel[3].setText("(" + ramCount + ")");
                
                this.revalidate();
                this.repaint();
            }
    }