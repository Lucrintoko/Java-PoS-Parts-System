package menumodules.leftpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import menumodules.leftpanel.subpanels.*;

public class LeftPanel extends JPanel
    {
        private TopSubPanel topSubPanel;

        public LeftPanel ()
            {
                //Left Panel Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                //0 Indicates that we don't care about height (BorderLayout handles it), but avoids invalid -1
                this.setPreferredSize(new Dimension(350, 0));

                //Insantiating Sub Panels to be added to Main Left Panel
                topSubPanel = new TopSubPanel();

                //Adding to the JPanel
                this.add(topSubPanel, BorderLayout.CENTER);
            }
        
        //Method for setting dependency
        public TopSubPanel getTopSubPanel() 
            {
                return topSubPanel;
            }
    }