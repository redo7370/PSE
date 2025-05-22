package main.ui;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.data.PeriodicTable;


public class MenuWindow extends JFrame{
    private JToggleButton lightModeToggle, darkModeToggle;
    
    public MenuWindow(Color bg){
        setTitle("Menü");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(bg);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(bg);
        this.add(mainPanel);


        // GridBagLayout
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setLayout(gbl);

        // Appearance
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = 1;
        lightModeToggle = new JToggleButton("Light");
        lightModeToggle.setBackground(PeriodicTable.getMAINBG());
        lightModeToggle.setOpaque(true);
        lightModeToggle.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(lightModeToggle, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = 1;
        darkModeToggle = new JToggleButton("Dark");
        darkModeToggle.setBackground(PeriodicTable.getMAINBG());
        darkModeToggle.setOpaque(true);
        darkModeToggle.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(darkModeToggle, gbc);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        // GUI Issue Handling For macOS
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Cannot set LookAndFeel");
        }

        // Reserve Thread To Run The GUI
        SwingUtilities.invokeLater(() -> new MenuWindow(PeriodicTable.getMAINBG()));
    }
    
}
