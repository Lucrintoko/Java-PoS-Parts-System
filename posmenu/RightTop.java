package posmenu;

import javax.swing.*;
import java.awt.*;

public class RightTop {
    private JPanel panel;
    private JTable cartTable;
    private JScrollPane scrollPane;


    public RightTop() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(55, 55, 55)); 

        
        String[] columns = {"Product", "Price (₱)", "Qty", "Subtotal (₱)"};
        Object[][] data = {
        
        };

        
        cartTable = new JTable(data, columns);
        cartTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cartTable.setRowHeight(25);
        cartTable.setBackground(new Color(245, 245, 245));
        cartTable.setGridColor(Color.GRAY);

        
        scrollPane = new JScrollPane(cartTable);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    
    public JPanel getPanel() {
        return panel;
    }

    
    public void updateCart(Object[][] newData) {
        String[] columns = {"Product", "Price (₱)", "Qty", "Subtotal (₱)"};
        cartTable.setModel(new javax.swing.table.DefaultTableModel(newData, columns));
    }
}
