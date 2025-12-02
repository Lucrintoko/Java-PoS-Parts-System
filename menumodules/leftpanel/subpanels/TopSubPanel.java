package menumodules.leftpanel.subpanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import menumodules.ProductStorage;

public class TopSubPanel extends JPanel
    {
        JLabel systemNameLabel;

        //Label to store all of the parts inside of ProductStorage.java
        JLabel[] partsLabel; 
        ProductStorage productStorage;

        public TopSubPanel ()
            {
                //JPanel Default Configurations
                this.setLayout(new GridBagLayout());

                //For setting parameters for the Grid Bag Layout
                GridBagConstraints gbc = new GridBagConstraints();

                //Setting External Padding for the Name of the PoSSystem
                gbc.insets = new Insets(5, 5, 10, 5);
                
                //Insantiating the Labels for all the parts of ProductStorage.java (CPU, GPU, SSD, and RAM)
                partsLabel = new JLabel[4];

                partsLabel[1] = new JLabel("CPU");
                partsLabel[2] = new JLabel("GPU");
                partsLabel[3] = new JLabel("SSD");
                partsLabel[4] = new JLabel("RAM");

                //Settings the Font of the Labels

                /*------------------------------- Row 0: Name -------------------------------*/
                //Ensures that all Labels will be at the left
                gbc.anchor = GridBagConstraints.LINE_START;
            }
    }