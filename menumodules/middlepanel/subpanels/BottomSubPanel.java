package menumodules.middlepanel.subpanels;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import menumodules.ProductStorage;
import menumodules.parts.Product;

public class BottomSubPanel extends JPanel
    {
        //Declaring variable outside of Constructor to be manipulated by ActionListeners
        private JPanel contentPanel;

        public BottomSubPanel ()
            {
                //JPanel Default Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                
                //Insantiating Content Panel which will be manipulated by Methods via Action Listeners from ButtonGridPanel.java
                contentPanel = new JPanel();
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
                contentPanel.setBackground(Color.BLACK);
                
                //Ensures that the whole list is scrollable
                JScrollPane scrollPane = new JScrollPane(contentPanel);
                scrollPane.getViewport().setBackground(Color.BLACK);
                scrollPane.setBorder(null);
                
                //Adding Scroll Pane to JPanel
                this.add(scrollPane, BorderLayout.CENTER);
            }

        //Method for updataing all products inside of the brand
        public void updateProducts(String brand, ProductStorage storage) {
            //Clears the whole list 
            contentPanel.removeAll();
            
            addProducts(storage.getCPUs(), brand);
            addProducts(storage.getGPUs(), brand);
            addProducts(storage.getSSDs(), brand);
            addProducts(storage.getRAMs(), brand);
            
            contentPanel.revalidate();
            contentPanel.repaint();
        }

        //Method to display all of the current products of the brand
        private void addProducts(List<? extends Product> products, String brand) {
            for (Product p : products) {
                if (p.getBrand().equalsIgnoreCase(brand)) {
                    JLabel label = new JLabel(p.getPartName() + " - " + String.format("%.2f", p.getPrice()) + " (" + p.getAmount() + ")");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    contentPanel.add(label);
                }
            }
        }
    }
