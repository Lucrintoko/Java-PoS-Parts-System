package menumodules.middlepanel.subpanels;

import java.awt.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import menumodules.ProductStorage;
import menumodules.parts.Product;
import menumodules.rightpanel.subpanels.TopSubPanel;

public class BottomSubPanel extends JPanel
    {
        //Declaring variable outside of Constructor to be manipulated by ActionListeners
        private JPanel contentPanel;
        private TopSubPanel cartPanel;
        //Connecting to the Left Top Panel for Counter Update
        private menumodules.leftpanel.subpanels.TopSubPanel leftTopPanel;

        public BottomSubPanel ()
            {
                //JPanel Default Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                
                //Insantiating Content Panel which will be manipulated by Methods via Action Listeners from ButtonGridPanel.java
                contentPanel = new JPanel();
                contentPanel.setLayout(new GridLayout(0, 3, 10, 10));
                contentPanel.setBackground(Color.BLACK);
                
                //Wrapper Panel to prevent grid from stretching
                JPanel wrapperPanel = new JPanel(new BorderLayout());
                wrapperPanel.setBackground(Color.BLACK);
                wrapperPanel.add(contentPanel, BorderLayout.NORTH);
                
                //Ensures that the whole list is scrollable, only vertically
                JScrollPane scrollPane = new JScrollPane(wrapperPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.getViewport().setBackground(Color.BLACK);
                scrollPane.setBorder(null);
                
                //Adding Scroll Pane to JPanel
                this.add(scrollPane, BorderLayout.CENTER);
            }

        //Setter for Linking Java Files
        public void setCartPanel(TopSubPanel cartPanel) {
            this.cartPanel = cartPanel;
        }

        public void setLeftTopPanel(menumodules.leftpanel.subpanels.TopSubPanel leftTopPanel) {
            this.leftTopPanel = leftTopPanel;
        }

        //Method for updataing all products inside of the brand
        public void updateProducts(String brand, ProductStorage storage) {
            //Clears the whole list 
            contentPanel.removeAll();
            
            //Goes to the ProductStorage and take each individual product and update them
            addProducts(storage.getCPUs(), brand, storage);
            addProducts(storage.getGPUs(), brand, storage);
            addProducts(storage.getSSDs(), brand, storage);
            addProducts(storage.getRAMs(), brand, storage);
            
            contentPanel.revalidate();
            contentPanel.repaint();
        }

        //Method to display all of the current products of the brand
        private void addProducts(List<? extends Product> products, String brand, ProductStorage storage) {
            for (Product p : products) {
                if (p.getBrand().equalsIgnoreCase(brand)) 
                    {
                        //Card Layout
                        JPanel card = new JPanel(new BorderLayout());
                        card.setBackground(Color.DARK_GRAY);
                        card.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        card.setPreferredSize(new Dimension(100, 100)); 
                        
                        //Name of the Component
                        JLabel nameLabel = new JLabel("<html><center>" + p.getPartName() + "</center></html>", SwingConstants.CENTER);
                        nameLabel.setForeground(Color.WHITE);
                        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
                        card.add(nameLabel, BorderLayout.NORTH);
                        
                        //Price of the Component
                        //Formatting the Price
                        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
                        currencyFormatter.setMinimumFractionDigits(2);
                        currencyFormatter.setMaximumFractionDigits(2);
                        JLabel priceLabel = new JLabel(currencyFormatter.format(p.getPrice()), SwingConstants.CENTER);
                        priceLabel.setForeground(Color.CYAN);
                        priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        
                        JLabel stockLabel = new JLabel("Stock: " + p.getAmount(), SwingConstants.CENTER);
                        stockLabel.setForeground(Color.WHITE);
                        stockLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));

                        JPanel detailsPanel = new JPanel(new GridLayout(2, 1));
                        detailsPanel.setOpaque(false);
                        detailsPanel.add(priceLabel);
                        detailsPanel.add(stockLabel);
                        
                        card.add(detailsPanel, BorderLayout.CENTER);
                        
                        //Creating a JPanel to ease the layoutting of control buttons
                        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
                        controls.setOpaque(false);
                        controls.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

                        //Minus Button
                        JButton minus = new JButton("-");
                        minus.setPreferredSize(new Dimension(25, 25));
                        minus.setMargin(new Insets(0, 0, 0, 0));
                        minus.setBorderPainted(false);
                        minus.setBackground(Color.decode("#E63946"));
                        minus.setContentAreaFilled(false);
                        minus.setForeground(Color.WHITE);
                        
                        //Stock Counter
                        JLabel count = new JLabel("0");
                        count.setForeground(Color.WHITE);
                        count.setFont(new Font("Segoe UI", Font.BOLD, 12));
                        
                        //Addition Button
                        JButton plus = new JButton("+");
                        plus.setPreferredSize(new Dimension(25, 25));
                        plus.setMargin(new Insets(0, 0, 0, 0));
                        plus.setBorderPainted(false);
                        plus.setBackground(Color.decode("#06D6A0"));
                        plus.setContentAreaFilled(false);
                        plus.setForeground(Color.WHITE);
                        
                        //Action listener for subtracting to the cart
                        minus.addActionListener(e -> 
                            {
                                //Ensures that the Right Panel Top Sub Panel Exists
                                if (cartPanel != null) 
                                    {
                                    int current = Integer.parseInt(count.getText());
                                        if (current > 0) 
                                            {
                                                cartPanel.removeFromCart(p);
                                                p.setAmount(p.getAmount() + 1);
                                                count.setText(String.valueOf(current - 1));
                                                //Update the counter inside of card
                                                stockLabel.setText("Stock: " + p.getAmount());
                                                //Refreshes counter to the current stock quantity
                                                if (leftTopPanel != null) 
                                                    {
                                                        leftTopPanel.updateCounts(brand, storage);
                                                    }
                                            }
                                    }
                            });

                        //Action Listener for adding to the card
                        plus.addActionListener(e -> 
                            {
                                //Ensures that the Right Panel Top Sub Panel Exists
                                if (cartPanel != null) 
                                    {
                                        if (p.getAmount() > 0) 
                                            {
                                            cartPanel.addToCart(p);
                                            p.setAmount(p.getAmount() - 1);
                                            int current = Integer.parseInt(count.getText());
                                            count.setText(String.valueOf(current + 1));
                                            //Update the counter inside of card
                                            stockLabel.setText("Stock: " + p.getAmount());
                                            //Refreshes the counter to the current stock quantity
                                            if (leftTopPanel != null) 
                                                {
                                                    leftTopPanel.updateCounts(brand, storage);
                                                }
                                            }
                                    }
                            });

                        //Adding to Flow Layout Panel to ensure same size
                        controls.add(minus);
                        controls.add(count);
                        controls.add(plus);

                        //Adding the controls to the card itself
                        card.add(controls, BorderLayout.SOUTH);
                        
                        //Adding to Main JPanel
                        contentPanel.add(card);
                    }
            }
        }
    }
