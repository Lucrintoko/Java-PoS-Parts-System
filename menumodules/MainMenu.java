package menumodules;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import menumodules.leftpanel.LeftPanel;
import menumodules.middlepanel.MiddlePanel;
import menumodules.rightpanel.RightPanel;

public class MainMenu extends JFrame
    {
        JPanel mainPanel;
        LeftPanel leftPanel;
        MiddlePanel middlePanel;
        RightPanel rightPanel;

        public MainMenu()
            {
                //Basic JFrame Properties
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                //Center the window
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);

                //To add all of the panels
                mainPanel = new JPanel(new BorderLayout());

                //----------------Left Panel----------------
                leftPanel = new LeftPanel();

                //----------------Middle Panel----------------
                //Middle Panel Configurations
                middlePanel = new MiddlePanel();

                //----------------Right Panel----------------
                rightPanel = new RightPanel();

                //Merging all Panels for Main Panel
                mainPanel.add(leftPanel, BorderLayout.WEST);
                mainPanel.add(middlePanel, BorderLayout.CENTER);
                mainPanel.add(rightPanel, BorderLayout.EAST);

                //Adding Main Panel to the JFrame
                this.add(mainPanel, BorderLayout.CENTER);

                //Connecting the Button Grid Panel to the Let Main Panel's Sub Panels, ProductStorage.java, and RightPanel.java
                ProductStorage productStorage = new ProductStorage();
                
                menumodules.leftpanel.subpanels.TopSubPanel topSubPanel = leftPanel.getTopSubPanel();
                menumodules.middlepanel.subpanels.BottomSubPanel bottomSubPanel = middlePanel.getBottomSubPanel();
                menumodules.middlepanel.subpanels.ButtonGridPanel buttonGridPanel = middlePanel.getButtonGridPanel();
                menumodules.rightpanel.subpanels.TopSubPanel cartPanel = rightPanel.getTopSubPanel();

                buttonGridPanel.setDependencies(topSubPanel, bottomSubPanel, productStorage);
                bottomSubPanel.setCartPanel(cartPanel);
                bottomSubPanel.setLeftTopPanel(topSubPanel);
                
                cartPanel.setLeftTopPanel(topSubPanel);
                cartPanel.setProductStorage(productStorage);

                // Link Right Panel Bottom to Top
                rightPanel.getBottomSubPanel().setCartPanel(cartPanel);

                //Make Frame Visible
                this.setVisible(true);
            }
    }