import javax.swing.*;
import java.awt.*;

public class PoSSystem {
    JFrame frame;
    JPanel mainPanel, leftPanel, middlePanel, rightPanel;
    JPanel leftTopPanel, leftBottomPanel;
    JPanel middleTopPanel, middleBottomPanel;
    JPanel rightTopPanel, rightBottomPanel;

    public PoSSystem() {
        // Initialize frame
        frame = new JFrame("NameNatin - PoS System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());

        // Main panel with GridLayout for three columns
        mainPanel = new JPanel(new GridLayout(1, 3));
        frame.add(mainPanel, BorderLayout.CENTER);

        // Left Panel
        leftPanel = new JPanel(new BorderLayout());
        leftTopPanel = new JPanel();
        leftBottomPanel = new JPanel();
        leftTopPanel.setBackground(Color.LIGHT_GRAY);
        leftBottomPanel.setBackground(Color.WHITE);
        leftPanel.add(leftTopPanel, BorderLayout.NORTH);
        leftPanel.add(leftBottomPanel, BorderLayout.CENTER);

        // Middle Panel
        middlePanel = new JPanel(new BorderLayout());
        middleTopPanel = new JPanel();
        middleBottomPanel = new JPanel();
        middleTopPanel.setBackground(Color.LIGHT_GRAY);
        middleBottomPanel.setBackground(Color.WHITE);
        middlePanel.add(middleTopPanel, BorderLayout.NORTH);
        middlePanel.add(middleBottomPanel, BorderLayout.CENTER);

        // Right Panel
        rightPanel = new JPanel(new BorderLayout());
        rightTopPanel = new JPanel();
        rightBottomPanel = new JPanel();
        rightTopPanel.setBackground(Color.LIGHT_GRAY);
        rightBottomPanel.setBackground(Color.WHITE);
        rightPanel.add(rightTopPanel, BorderLayout.NORTH);
        rightPanel.add(rightBottomPanel, BorderLayout.CENTER);

        // Add all three panels to mainPanel
        mainPanel.add(leftPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(rightPanel);

        // Finalize frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PoSSystem());
    }
