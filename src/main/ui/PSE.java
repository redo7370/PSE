package main.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.data.PeriodicTable;

public class PSE extends JFrame {

    // List of Elements
    private static final String[][] ELEMENTS = {
        {"H", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "He"},
        {"Li", "Be", "", "", "", "", "", "", "", "", "", "", "B", "C", "N", "O", "F", "Ne"},
        {"Na", "Mg", "", "", "", "", "", "", "", "", "", "", "Al", "Si", "P", "S", "Cl", "Ar"},
        {"K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr"},
        {"Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe"},
        {"Cs", "Ba", "La", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn"},
        {"Fr", "Ra", "Ac", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"}
    };

    private static int maxColumns;
    private static final int MAX_ROWS = 7;
    private static final Color MAIN_BG = new Color(64, 63, 60);
    private static JTextField inputField;
    private static JLabel label, fillerLabel;
    private static JButton menuButton, confirmButton;

    public PSE() {        
        setTitle("Periodensystem der Elemente");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(MAIN_BG);

        maxColumns = 0;
        for (String[] row : PeriodicTable.ELEMENTS) {
            maxColumns = Math.max(maxColumns, row.length);
        }
    
        // GridLayout mit der richtigen Anzahl an Zeilen und Spalten setHorizontalAlignment
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
    
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < maxColumns; j++) {
                
                // Empty Fields
                if (PeriodicTable.ELEMENTS[i][j].equals("")){ //TODO: Change to automatic detection
                    label = new JLabel(" ");
                    label.setBackground(PeriodicTable.getElementColor(ELEMENTS[i][j]));
                    label.setOpaque(true);
                    label.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));

                    gbc.gridx = j;
                    gbc.gridy = i;
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.weightx = 20;
                    gbc.weighty = 20;
        
                    add(label, gbc);
                    continue;
                }

                // Set Fields
                label = new JLabel(" " + PeriodicTable.ELEMENTS[i][j]);
                label.setBackground(PeriodicTable.getElementColor(ELEMENTS[i][j]));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));
                
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.weightx = 20;
                gbc.weighty = 20;
    
                add(label, gbc);
            }
        }

        // Filler Label -- Seperator: Table/Input //
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = maxColumns;
        fillerLabel = new JLabel(" ");
        fillerLabel.setBackground(MAIN_BG);
        fillerLabel.setOpaque(true);
        fillerLabel.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));
        add(fillerLabel, gbc);

        // Input Field //
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = 7;
        inputField = new JTextField();
        inputField.setBackground(new Color(150, 150, 150));
        inputField.setOpaque(true);
        inputField.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));
        add(inputField, gbc);

        // Confirm Button //
        gbc.gridx = 8;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = 4;
        confirmButton = new JButton("Eingabe bestätigen");
        confirmButton.setBackground(new Color(150, 150, 150));
        confirmButton.setOpaque(true);
        confirmButton.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));
        add(confirmButton, gbc);

        // Menu Button //
        gbc.gridx = maxColumns - 2;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = 2;
        menuButton = new JButton("Menü");
        menuButton.setBackground(new Color(150, 150, 150));
        menuButton.setOpaque(true);
        menuButton.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));
        add(menuButton, gbc);

        menuButton.addActionListener((final ActionEvent e) -> {
            new Menu(MAIN_BG);
        });
        
        setVisible(true);
    }


    public static void main(String[] args) {
        

         // GUI Issue Handling For macOS
         try {
            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Cannot set LookAndFeel");
        }

        // Reserve Thread To Run The GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            SwingUtilities.invokeLater(PSE::new); // –––– START PROGRAM –––– //
        });
    }
}
