package menumodules.leftpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class LeftPanel extends JPanel
    {

        public LeftPanel ()
            {
                //Left Panel Configurations
                this.setLayout(new BorderLayout());
                //-1 Indicates that to just resize based on window size
                this.setPreferredSize(new Dimension(350, -1));
            }
    }