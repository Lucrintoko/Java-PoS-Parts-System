package menumodules.leftpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import menumodules.leftpanel.subpanels.*;

public class LeftPanel extends JPanel
    {

        public LeftPanel ()
            {
                //Left Panel Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                //-1 Indicates that to just resize based on window size
                this.setPreferredSize(new Dimension(350, -1));

                //Insantiating Sub Panels to be added to Main Left Panel
                TopSubPanel topSubPanel = new TopSubPanel();
                BottomSubPanel bottomSubPanel = new BottomSubPanel();

                //Creating Split Pane Divider 
                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topSubPanel, bottomSubPanel);
                //Split Pane Configurations
                splitPane.setEnabled(false);
                splitPane.setDividerSize(2);
                //Make Divider White
                splitPane.setBackground(Color.WHITE);
                splitPane.setResizeWeight(0.7);

                //Adding to the JPanel
                this.add(splitPane, BorderLayout.CENTER);
            }
    }