package menumodules;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import menumodules.*;
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
                this.setSize(1200, 800);
                //Center the window
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLayout(new BorderLayout());

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

                //Make Frame Visible
                this.setVisible(true);
            }
    }