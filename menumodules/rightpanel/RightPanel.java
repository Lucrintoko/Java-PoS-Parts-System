package menumodules.rightpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import menumodules.rightpanel.subpanels.*;

public class RightPanel extends JPanel
    {
        private TopSubPanel topSubPanel;
        private BottomSubPanel bottomSubPanel;

        public RightPanel ()
            {
                //Right Panel Configurations
                this.setLayout(new GridBagLayout());
                this.setBackground(Color.BLACK);
                //0 Indicates that we don't care about height (BorderLayout handles it), but avoids invalid -1
                this.setPreferredSize(new Dimension(350, 0));

                //Insantiating Sub Panels
                topSubPanel = new TopSubPanel();
                topSubPanel.setPreferredSize(new Dimension(350, 500)); // Explicit hint
                
                bottomSubPanel = new BottomSubPanel();
                bottomSubPanel.setPreferredSize(new Dimension(350, 200)); // Explicit hint

                GridBagConstraints gbc = new GridBagConstraints();
                
                // Top Panel (Cart) - Takes 70% of vertical space
                gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 0.6;
                gbc.fill = GridBagConstraints.BOTH;
                this.add(topSubPanel, gbc);

                // Bottom Panel (Buttons) - Takes 30% of vertical space
                gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 1; gbc.weighty = 0.4;
                gbc.fill = GridBagConstraints.BOTH;
                this.add(bottomSubPanel, gbc);
            }

        //Getter for Top Sub Panel
        public TopSubPanel getTopSubPanel() 
            {
                return topSubPanel;
            }

        //Getter for Bottom Sub Panel
        public BottomSubPanel getBottomSubPanel ()
            {
                return bottomSubPanel;
            }
    }