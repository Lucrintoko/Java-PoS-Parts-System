import java.awt.*;
import javax.swing.*;

public class GridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Logo Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);

        JPanel panel = new JPanel(new java.awt.GridLayout(3, 3, 10, 10));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton button1 = createButton("Intel", "intel.png");
        JButton button2 = createButton("AMD", "amd.png");
        JButton button3 = createButton("Qualcomm", "qualcomm.png");
        JButton button4 = createButton("Apple", "apple.png");
        JButton button5 = createButton("Samsung", "samsung.png");
        JButton button6 = createButton("RockChip", "rockchip.png");
        JButton button7 = createButton("Ampere", "ampere.png");
        JButton button8 = createButton("IBM", "ibm.png");
        JButton button9 = createButton("Huawei", "huawei.png");

        
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);

        button2.setBackground(Color.RED);
        button2.setForeground(Color.WHITE);

        button3.setBackground(Color.WHITE);
        button3.setForeground(Color.WHITE);

        button4.setBackground(Color.WHITE);
        button4.setForeground(Color.WHITE);

        button5.setBackground(Color.BLUE);
        button5.setForeground(Color.WHITE);

        button6.setBackground(Color.WHITE);
        button6.setForeground(Color.WHITE);

        button7.setBackground(Color.WHITE);
        button7.setForeground(Color.WHITE);

        button8.setBackground(Color.WHITE);
        button8.setForeground(Color.WHITE);

        button9.setBackground(Color.WHITE);
        button9.setForeground(Color.WHITE);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton createButton(String name, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaled = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JButton button = new JButton(new ImageIcon(scaled));
        button.setToolTipText(name);
        button.setPreferredSize(new Dimension(150, 150));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }
}

