package main.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.data.ChemicalElement;
import main.data.Elements;
import main.data.PeriodicTable;

public class PSE extends JFrame {

    private static int maxColumns;
    private static final int MAX_ROWS = 7;
    private static JTextField inputField;
    private static JLabel label, fillerLabel;
    private static JButton menuButton, confirmButton;

    public PSE() {        
        setTitle("Periodensystem der Elemente");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(PeriodicTable.getMAINBG());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(PeriodicTable.getMAINBG());
        this.add(mainPanel);

        maxColumns = 0;
        for (String[] row : PeriodicTable.getElementTable()) {
            maxColumns = Math.max(maxColumns, row.length);
        }
        
        // GridBagLayout
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setLayout(gbl);
    
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < maxColumns; j++) {
                
                // Empty Fields
                if (PeriodicTable.getElementTable()[i][j].equals("")){ //TODO: Change to automatic detection
                    label = new JLabel(" ");
                    label.setBackground(PeriodicTable.getElementColor(PeriodicTable.getElementTable()[i][j]));
                    label.setOpaque(true);
                    label.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));

                    gbc.gridx = j;
                    gbc.gridy = i;
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.weightx = 20;
                    gbc.weighty = 20;
        
                    mainPanel.add(label, gbc);
                    continue;
                }

                // Set Fields
                label = new JLabel(" " + PeriodicTable.getElementTable()[i][j]);
                label.setBackground(PeriodicTable.getElementColor(PeriodicTable.getElementTable()[i][j]));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
                
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.weightx = 20;
                gbc.weighty = 20;
    
                mainPanel.add(label, gbc);
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
        fillerLabel.setBackground(PeriodicTable.getMAINBG().brighter());
        fillerLabel.setOpaque(true);
        fillerLabel.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(fillerLabel, gbc);

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
        inputField.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(inputField, gbc);

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
        confirmButton.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(confirmButton, gbc);

        confirmButton.addActionListener((final ActionEvent e) -> {
            String input = inputField.getText().trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bitte ein Element eingeben.");
                return;
            }

            ChemicalElement element = Elements.getElement(input);

            if (element == null) {
                JOptionPane.showMessageDialog(null, "Element nicht gefunden: " + input);
                return;
            }

            byte targetAtomicNumber = element.getAtomicNumber();

            // Alle offenen Fenster durchgehen
            for (Frame frame : Frame.getFrames()) {
                if (frame instanceof ElementWindow ew && frame.isDisplayable()) {
                    if (ew.getElementNum() == targetAtomicNumber) {
                        // Fenster gefunden, das dieses Element bereits darstellt
                        frame.toFront();        // Bringt das Fenster in den Vordergrund
                        frame.requestFocus();   // Setzt den Fokus auf das Fenster
                        frame.setState(Frame.NORMAL); // Falls minimiert, wiederherstellen
                        return; // Kein neues Fenster öffnen
                    }
                }
            }

            // Fenster wurde nicht gefunden – neues Fenster öffnen
            new ElementWindow(element);
        });


        
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
        menuButton.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(menuButton, gbc);
        
        menuButton.addActionListener((final ActionEvent e) -> {
            new MenuWindow(PeriodicTable.getMAINBG());
        });
        
        setVisible(true);
    }


}
