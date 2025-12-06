package menumodules.rightpanel.subpanels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import javax.swing.*;
import menumodules.parts.Product;

public class BottomSubPanel extends JPanel implements ActionListener
    {
        JButton btnCheckout, btnClearCart, btnViewReceipts;
        Font labelFont;
        TopSubPanel cartPanel;

        public BottomSubPanel ()
            {
                //Default JPanel Configurations
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                this.setBackground(Color.BLACK);

                //Insantiating Custom Label Font
                Font customFont;
                try 
                    {
                        java.io.InputStream is = getClass().getResourceAsStream("/menumodules/fonts/Montserrat-Bold.ttf");
                        customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(24f);
                    } 
                catch (Exception e) 
                    {
                        // Fallback to a system font if the custom font fails to load
                        customFont = new Font("Segoe UI", Font.BOLD, 24);
                    }

                //For ease of usage
                labelFont = customFont;

                // Add buttons and spacing
                this.add(Box.createVerticalGlue()); // Flexible spacer to push buttons down from top

                //------------------------- Checkout Button -------------------------*/
                btnCheckout = new JButton("Checkout");
                btnCheckout.setFont(labelFont);
                btnCheckout.setForeground(Color.WHITE);
                btnCheckout.setBackground(Color.GRAY);
                btnCheckout.setOpaque(true);
                btnCheckout.setFocusPainted(false);
                btnCheckout.setBorderPainted(false);
                btnCheckout.setPreferredSize(new Dimension(300, 60));
                btnCheckout.setMaximumSize(new Dimension(300, 60));
                btnCheckout.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
                btnCheckout.addActionListener(this);
                this.add(btnCheckout);

                this.add(Box.createVerticalStrut(10)); // Small vertical gap between Checkout and Clear Cart

                //------------------------- Clear Cart Button -------------------------*/
                btnClearCart = new JButton("Clear Cart");
                btnClearCart.setFont(labelFont);
                btnClearCart.setForeground(Color.WHITE);
                btnClearCart.setBackground(Color.GRAY);
                btnClearCart.setOpaque(true);
                btnClearCart.setFocusPainted(false);
                btnClearCart.setBorderPainted(false);
                btnClearCart.setPreferredSize(new Dimension(300, 60));
                btnClearCart.setMaximumSize(new Dimension(300, 60));
                btnClearCart.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
                btnClearCart.addActionListener(this);
                this.add(btnClearCart);

                this.add(Box.createVerticalStrut(20)); // Fixed vertical gap between Clear Cart and View Receipts

                //------------------------- View Receipts Button -------------------------*/
                btnViewReceipts = new JButton("View Receipts");
                btnViewReceipts.setFont(labelFont.deriveFont(18f));
                btnViewReceipts.setForeground(Color.WHITE);
                btnViewReceipts.setBackground(Color.GRAY);
                btnViewReceipts.setOpaque(true);
                btnViewReceipts.setFocusPainted(false);
                btnViewReceipts.setBorderPainted(false);
                btnViewReceipts.setPreferredSize(new Dimension(300, 60));
                btnViewReceipts.setMaximumSize(new Dimension(300, 60));
                btnViewReceipts.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
                btnViewReceipts.addActionListener(this);
                this.add(btnViewReceipts);
                
                this.add(Box.createVerticalGlue()); // Flexible spacer to push buttons up from bottom
            }

        public void setCartPanel(TopSubPanel cartPanel) 
            {
                this.cartPanel = cartPanel;
            }

        @Override
        public void actionPerformed (ActionEvent e)
            {
                //Logic Handling for Checkout Button
                if (e.getSource() == btnCheckout)
                    {
                        //Ensures that the Cart is not empty
                        if (cartPanel == null || cartPanel.getCartContents().isEmpty()) 
                            {
                                JOptionPane.showMessageDialog(this, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                        //Make a HashMap to make it easier to layout everything
                        Map<Product, Integer> cart = cartPanel.getCartContents();
                        //Utilize a String Builder to make appending easier and save resources
                        StringBuilder receipt = new StringBuilder();
                        //Would be utilize to store the sub total and tax total
                        double subTotal = 0;
                        double totalTax = 0;
                        
                        //Number formatter to make them have commas and have 2 decimal places
                        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
                        currencyFormatter.setMinimumFractionDigits(2);
                        currencyFormatter.setMaximumFractionDigits(2);

                        //Writing the Formatting for the Receipt (.txt file)
                        receipt.append("------------------------------------------------\n");
                        receipt.append("                OFFICIAL RECEIPT                \n");
                        receipt.append("------------------------------------------------\n\n");
                        receipt.append(String.format("%-30s %-5s %-30s\n", "Product", "Qty", "Price"));
                        receipt.append("------------------------------------------------\n");

                        for (Map.Entry<Product, Integer> entry : cart.entrySet()) 
                            {
                                Product p = entry.getKey();
                                int qty = entry.getValue();
                                double itemTotal = p.getPrice() * qty;
                                
                                subTotal += itemTotal;
                                totalTax += itemTotal * p.getTax();
                                
                                String productName = p.getPartName();
                                int productNameWidth = 30;
                                int currentIdx = 0;
                                boolean firstLine = true;

                                while (currentIdx < productName.length()) {
                                    String linePart;
                                    if (currentIdx + productNameWidth < productName.length()) {
                                        linePart = productName.substring(currentIdx, currentIdx + productNameWidth);
                                    } else {
                                        linePart = productName.substring(currentIdx);
                                    }

                                    if (firstLine) {
                                        receipt.append(String.format("%-" + productNameWidth + "s %-5d %15s\n",
                                            linePart.trim(),
                                            qty,
                                            currencyFormatter.format(itemTotal)));
                                        firstLine = false;
                                    } else {
                                        // For wrapped lines, only print the product name part, padded to 30 chars, and fill the rest
                                        receipt.append(String.format("%-" + productNameWidth + "s %-5s %15s\n",
                                            linePart.trim(),
                                            "", // Empty Qty for wrapped lines
                                            ""));// Empty Price for wrapped lines
                                    }
                                    currentIdx += productNameWidth;
                                }
                            }

                        double grandTotal = subTotal + totalTax;

                        receipt.append("--------------------------------------------------\n"); // 50 dashes
                        receipt.append(String.format("%-30s %20s\n", "Sub-Total:", currencyFormatter.format(subTotal))); // 30+20 = 50
                        receipt.append(String.format("%-30s %20s\n", "Tax (12%):", currencyFormatter.format(totalTax))); // 30+20 = 50
                        receipt.append("--------------------------------------------------\n"); // 50 dashes
                        receipt.append(String.format("%-30s %20s\n", "GRAND TOTAL:", currencyFormatter.format(grandTotal))); // 30+20 = 50
                        receipt.append("--------------------------------------------------\n"); // 50 dashes
                        receipt.append("\n          Thank you for shopping with us!         \n");

                        // Create receipts folder
                        File folder = new File("receipts");
                        if (!folder.exists()) 
                            {
                                folder.mkdir();
                            }

                        // Generate filename with timestamp
                        String timestamp = new SimpleDateFormat("yyyy_MM_dd HH;mm;ss").format(new Date());
                        File receiptFile = new File(folder, "receipt_" + timestamp + ".txt");

                        //Attempt to Create a .txt file
                        try (FileWriter writer = new FileWriter(receiptFile)) 
                            {
                                writer.write(receipt.toString());
                                JOptionPane.showMessageDialog(this, "Receipt generated successfully!\nSaved to: " + receiptFile.getPath(), "Success", JOptionPane.INFORMATION_MESSAGE);
                                // Clear cart after successful checkout
                                cartPanel.clearCart();
                            } 
                        catch (IOException ex) 
                            {
                                JOptionPane.showMessageDialog(this, "Error generating receipt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }

                //Logic Handling for Clear Cart Button    
                if (e.getSource() == btnClearCart)
                    {
                        //Clearing the Cart
                        cartPanel.clearCart();
                    }

                //Logic Handling for Viewing Receipts
                if (e.getSource() == btnViewReceipts)
                    {
                        //Add a File Chooser to view .txt files inside of receipts/
                        JFileChooser fileChooser = new JFileChooser(new File("receipts"));
                        //How it will be seen
                        fileChooser.setDialogTitle("Select Receipt to View");
                        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));

                        //Null Allows it to Center
                        int result = fileChooser.showOpenDialog(null);
                        
                        if (result == JFileChooser.APPROVE_OPTION) 
                            {
                                File selectedFile = fileChooser.getSelectedFile();
                                try 
                                    {
                                        // Read file content
                                        StringBuilder content = new StringBuilder();
                                        java.util.Scanner scanner = new java.util.Scanner(selectedFile);
                                        while (scanner.hasNextLine()) 
                                            {
                                                content.append(scanner.nextLine()).append("\n");
                                            }
                                        scanner.close();

                                        // Display content in a scrollable text area
                                        JTextArea textArea = new JTextArea(content.toString());
                                        textArea.setEditable(false);
                                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                                        JScrollPane scrollPane = new JScrollPane(textArea);
                                        scrollPane.setPreferredSize(new Dimension(400, 500));
                                        
                                        JOptionPane.showMessageDialog(this, scrollPane, "Receipt View: " + selectedFile.getName(), JOptionPane.PLAIN_MESSAGE);
                                    } 
                                catch (IOException ex) 
                                    {
                                        JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                            }
                    }
            }
    }