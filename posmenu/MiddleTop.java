package posmenu;

import javax.swing.*;
import java.awt.*;

public class MiddleTop {
    private JPanel panel;
    private JTable productTable;
    private JScrollPane scrollPane;

    
    public MiddleTop() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(60, 60, 60)); 

        
        String[] columns = {"Product", "Price (₱)", "Quantity"};
        Object[][] data = {
            {"AMD Ryzen 9 9950X3D", "₱72,841", 10},
            {"AMD Ryzen 7 9700X", "₱28,500", 15},
            {"AMD Ryzen 5 9600X", "₱18,200", 20}
        };

        
        productTable = new JTable(data, columns);
        productTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        productTable.setRowHeight(25);
        productTable.setBackground(new Color(245, 245, 245));
        productTable.setGridColor(Color.GRAY);

        
        scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    
    public JPanel getPanel() {
        return panel;
    }

    
    public void updateProducts(Object[][] newData) {
        String[] columns = {"Product", "Price (₱)", "Quantity"};
        productTable.setModel(new javax.swing.table.DefaultTableModel(newData, columns));
    }
}
