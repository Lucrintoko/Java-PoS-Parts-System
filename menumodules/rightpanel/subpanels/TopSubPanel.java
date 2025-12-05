package menumodules.rightpanel.subpanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.*;
import menumodules.parts.Product;

public class TopSubPanel extends JPanel
    {
        private JPanel cartItemsPanel;
        private Map<Product, Integer> cartContents;
        private JLabel totalLabel;

        public TopSubPanel ()
            {
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                
                cartContents = new HashMap<>();

                JLabel title = new JLabel("Cart");
                title.setForeground(Color.WHITE);
                title.setFont(new Font("Segoe UI", Font.BOLD, 24));
                title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                this.add(title, BorderLayout.NORTH);

                cartItemsPanel = new JPanel();
                cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel, BoxLayout.Y_AXIS));
                cartItemsPanel.setBackground(Color.BLACK);
                
                JScrollPane scrollPane = new JScrollPane(cartItemsPanel);
                scrollPane.getViewport().setBackground(Color.BLACK);
                scrollPane.setBorder(null);
                this.add(scrollPane, BorderLayout.CENTER);

                totalLabel = new JLabel("Total: 0.00");
                totalLabel.setForeground(Color.WHITE);
                totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                this.add(totalLabel, BorderLayout.SOUTH);
            }

        //Add to Cart Method to be utilized by other Java Files
        public void addToCart(Product p) 
            {
                cartContents.put(p, cartContents.getOrDefault(p, 0) + 1);
                refreshCartDisplay();
            }

        //Remove to Cart Method
        public void removeFromCart(Product p) 
            {
                if (cartContents.containsKey(p)) 
                    {
                        int count = cartContents.get(p);
                        if (count > 1) 
                            {
                                cartContents.put(p, count - 1);
                            } 
                        else 
                            {
                                cartContents.remove(p);
                            }
                        refreshCartDisplay();
                    }
            }

        //Refresh Cart Method every time you add or remove a product
        private void refreshCartDisplay() 
        {
            cartItemsPanel.removeAll();
            double total = 0;

            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
            currencyFormatter.setMinimumFractionDigits(2);
            currencyFormatter.setMaximumFractionDigits(2);

            for (Map.Entry<Product, Integer> entry : cartContents.entrySet()) 
                {
                    Product p = entry.getKey();
                    int qty = entry.getValue();
                    double subtotal = p.getPrice() * qty;
                    total += subtotal;

                    // Format the subtotal
                    String formattedSubtotal = currencyFormatter.format(subtotal);

                    // Construct the HTML string for the JLabel
                    String itemText = "<html>" + p.getPartName() + " (" + qty + ") <br> " + formattedSubtotal + "</html>";
                    
                    JLabel itemLabel = new JLabel(itemText);
                    itemLabel.setForeground(Color.WHITE);
                    itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    cartItemsPanel.add(itemLabel);
                }
            totalLabel.setText("Total: " + currencyFormatter.format(total));
            cartItemsPanel.revalidate();
            cartItemsPanel.repaint();
        }
    }