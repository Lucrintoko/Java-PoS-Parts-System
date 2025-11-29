import MenuModules.ButtonGridPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class PoSSystem extends JFrame
    {
        JPanel mainPanel,
               leftPanel, leftTopPanel, leftBottomPanel,
               middlePanel, middleTopPanel, middleBottomPanel,
               rightPanel, rightTopPanel, rightBottomPanel;

        public PoSSystem()
            {
                //Basic JFrame Properties
                this.setSize(1200, 800);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLayout(new BorderLayout());

                mainPanel = new JPanel(new BorderLayout());

                //----------------Left Panel----------------
                //Left Panel Configurations
                leftPanel = new JPanel();
                leftPanel.setBackground(Color.BLACK);
                leftPanel.setPreferredSize(new Dimension(280, 0));

                //----------------Middle Panel----------------
                //Middle Panel Configurations
                middlePanel = new JPanel(new BorderLayout());
                middlePanel.setBackground(Color.BLACK);

                //Insantiating Top and Bottom side
                middleTopPanel = new JPanel(new BorderLayout());
                middleBottomPanel = new JPanel(new BorderLayout());

                //Insantiating ButtonGridPanel for all Company Buttons
                ButtonGridPanel buttonGridPanel = new ButtonGridPanel();
                middleTopPanel.add(buttonGridPanel, BorderLayout.CENTER);
                
                //----------------Split Pane for Bottom and Top Panel----------------
                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, middleTopPanel, middleBottomPanel);

                //Split Pane Configurations
                splitPane.setDividerLocation(400);
                splitPane.setResizeWeight(0.7);

                middlePanel.add(splitPane, BorderLayout.CENTER);

                //----------------Right Panel----------------
                //Right Panel Configurations
                rightPanel = new JPanel();
                rightPanel.setBackground(Color.BLACK);
                rightPanel.setPreferredSize(new Dimension(300, 0));
                
                //Merging all Panels for Main Panel
                mainPanel.add(leftPanel, BorderLayout.WEST);                
                mainPanel.add(middlePanel, BorderLayout.CENTER);
                mainPanel.add(rightPanel, BorderLayout.EAST);                

                //Adding Main Panel to the JFrame
                this.add(mainPanel, BorderLayout.CENTER);

                //Make Frame Visible
                this.setVisible(true);
            }

        public static void main (String[] args)
            {
                SwingUtilities.invokeLater(() -> new PoSSystem());
            }
    }