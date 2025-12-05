package menumodules.rightpanel.subpanels;

import java.awt.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.*;
import menumodules.ProductStorage;
import menumodules.parts.Product;

public class TopSubPanel extends JPanel
    {
        private JPanel cartItemsPanel;
        private Map<Product, Integer> cartContents;
        private JLabel totalLabel;
        private menumodules.leftpanel.subpanels.TopSubPanel leftTopPanel;
        private ProductStorage productStorage;

        public TopSubPanel ()
            {
                //JPanel Default Configurations
                this.setLayout(new BorderLayout());
                this.setBackground(Color.BLACK);
                
                cartContents = new HashMap<>();

                //Cart Label
                JLabel title = new JLabel("Cart", SwingConstants.CENTER); // Centering the text
                title.setForeground(Color.WHITE);
                title.setFont(new Font("Segoe UI", Font.BOLD, 24));
                title.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE), // Bottom border
                                BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Padding
                this.add(title, BorderLayout.NORTH);

                //Setting Alignment
                cartItemsPanel = new JPanel();
                cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel, BoxLayout.Y_AXIS));
                cartItemsPanel.setBackground(Color.BLACK);
                
                //Ensures that if Cart List surpasses the Panel it will become scroll able
                JScrollPane scrollPane = new JScrollPane(cartItemsPanel);
                scrollPane.getViewport().setBackground(Color.BLACK);
                scrollPane.setBorder(null);
                this.add(scrollPane, BorderLayout.CENTER);

                //Total Label
                totalLabel = new JLabel("Total: 0.00", SwingConstants.CENTER); // Centering the text
                totalLabel.setForeground(Color.WHITE);
                totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                totalLabel.setBorder(BorderFactory.createCompoundBorder(
                                     BorderFactory.createMatteBorder(1, 0, 2, 0, Color.WHITE), // Top and Bottom border
                                     BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Padding
                this.add(totalLabel, BorderLayout.SOUTH);
            }

        //Setter for connection
        public void setLeftTopPanel(menumodules.leftpanel.subpanels.TopSubPanel leftTopPanel) 
            {
                this.leftTopPanel = leftTopPanel;
            }

        public void setProductStorage(ProductStorage productStorage) 
            {
                this.productStorage = productStorage;
            }

        //Getter for Cart Contents
        public Map<Product, Integer> getCartContents()
            {
                return cartContents;
            }

        //Clearing the Cart
        public void clearCart()
            {
                cartContents.clear();
                refreshCartDisplay();
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
            //Removing all to ensure that it doesn't overlap
            cartItemsPanel.removeAll();
            //Initializing Total Attributes
            double subTotal = 0;
            double totalTax = 0;

            //Formatting the Price
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
            currencyFormatter.setMinimumFractionDigits(2);
            currencyFormatter.setMaximumFractionDigits(2);

            //Adding each product inside of the list
            for (Map.Entry<Product, Integer> entry : cartContents.entrySet()) 
                {
                    Product p = entry.getKey();
                    int qty = entry.getValue();
                    double itemSubtotal = p.getPrice() * qty;
                    
                    subTotal += itemSubtotal;
                    totalTax += itemSubtotal * p.getTax();

                    // Format the subtotal
                    String formattedSubtotal = currencyFormatter.format(itemSubtotal);

                    // Construct the HTML string for the JLabel
                    String itemText = "<html><center>" + p.getPartName() + " (" + qty + ") <br> " + formattedSubtotal + "</center></html>";
                    
                    JLabel itemLabel = new JLabel(itemText, SwingConstants.CENTER);
                    itemLabel.setForeground(Color.WHITE);
                    itemLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label within itemPanel
                    
                    // Create a panel for each item to control centering and add a separator
                    JPanel itemPanel = new JPanel();
                    itemPanel.setBackground(Color.BLACK);
                    itemPanel.setLayout(new BorderLayout()); // Changed to BorderLayout for side button
                    itemPanel.add(itemLabel, BorderLayout.CENTER);
                    
                    // Minus Button
                    JButton minusBtn = new JButton("-");
                    minusBtn.setMargin(new Insets(0, 5, 0, 5)); // Compact
                    minusBtn.setBackground(Color.BLACK);
                    minusBtn.setForeground(Color.WHITE);
                    minusBtn.setFocusPainted(false);
                    minusBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    minusBtn.setPreferredSize(new java.awt.Dimension(30, 30));
                    
                    //Handling Minus Button for Product Deletion
                    minusBtn.addActionListener(e -> 
                        {
                            removeFromCart(p);
                            // Update Stock
                            p.setAmount(p.getAmount() + 1);
                            // Update Left Panel
                            if (leftTopPanel != null && productStorage != null) 
                                {
                                    leftTopPanel.updateCounts(p.getBrand(), productStorage);
                                }
                        });

                    // Wrapper for button to center vertically or align
                    JPanel btnPanel = new JPanel(new java.awt.FlowLayout(FlowLayout.CENTER));
                    btnPanel.setBackground(Color.BLACK);
                    btnPanel.add(minusBtn);
                    
                    //Adding to the Right of the Product
                    itemPanel.add(btnPanel, BorderLayout.EAST);

                    itemPanel.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, itemLabel.getPreferredSize().height + 20)); // Adjusted height
                    itemPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(50, 50, 50))); // Subtle separator

                    cartItemsPanel.add(itemPanel);
                }
            
            //Calculating total amount of products
            double grandTotal = subTotal + totalTax;

            //Adding up the total of each
            String totalText = "<html><center>" +
                               "Sub-Total: " + currencyFormatter.format(subTotal) + "<br>" +
                               "Tax: " + currencyFormatter.format(totalTax) + "<br>" +
                               "Grand Total: " + currencyFormatter.format(grandTotal) +
                               "</center></html>";
            totalLabel.setText(totalText);
            
            //Sees if the whole component layout has been changed and then displays it again
            cartItemsPanel.revalidate();
            cartItemsPanel.repaint();
        }
    }
