package menumodules.rightpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class RightPanel extends JPanel
    {
        
        public RightPanel ()
            {
                //Right Panel Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                //-1 Indicates that to just resize based on window size
                this.setPreferredSize(new Dimension(350, -1));
            }
    }