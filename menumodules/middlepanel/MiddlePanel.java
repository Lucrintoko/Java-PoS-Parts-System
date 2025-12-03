package menumodules.middlepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import menumodules.middlepanel.subpanels.*;

public class MiddlePanel extends JPanel
    {
        private ButtonGridPanel buttonGridPanel;
        private BottomSubPanel bottomSubPanel;

        public MiddlePanel ()
            {
                //Middle Panel Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                //-1 Indicates to resize based on window height
                this.setPreferredSize(new Dimension(500, -1));

                //Insantiating Top and Bottom side
                JPanel middleTopPanel = new JPanel(new BorderLayout());
                JPanel middleBottomPanel = new JPanel(new BorderLayout());

                //To make it uniform with Button Grid Panel above it
                middleBottomPanel.setBackground(Color.BLACK);

                //Insantiating ButtonGridPanel for all Company Buttons
                buttonGridPanel = new ButtonGridPanel();
                middleTopPanel.add(buttonGridPanel, BorderLayout.CENTER);

                //Insantiating Bottom Sub Panel for List of Companies
                bottomSubPanel = new BottomSubPanel();
                middleBottomPanel.add(bottomSubPanel, BorderLayout.CENTER);
                
                //----------------Split Pane for Middle Bottom and Top Panel----------------
                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, middleTopPanel, middleBottomPanel);

                //Split Pane Configurations
                splitPane.setDividerLocation(400);
                splitPane.setResizeWeight(0.7);
                //Disable user ability to resize the split pane
                splitPane.setEnabled(false);
                splitPane.setDividerSize(2); //Set the divider to be 2 pixels thin
                splitPane.setBackground(Color.WHITE); //Making the split pane divider white

                this.add(splitPane, BorderLayout.CENTER);
            }

        public ButtonGridPanel getButtonGridPanel() {
            return buttonGridPanel;
        }

        public BottomSubPanel getBottomSubPanel() {
            return bottomSubPanel;
        }
    }
