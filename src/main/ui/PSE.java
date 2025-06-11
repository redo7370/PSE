/*
 * PSE - Periodic System of Elements (Learn and Information Application)
 * Copyright (C) 2025 Jim Feser
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact:
 *  Github: https://github.com/jimfeserHTW
 *
 * If this program interacts with users remotely through a computer network,
 * it must provide a way for users to get its source code, for example by
 * offering a “Source” link in the user interface (see section 13 of the AGPL).
 */

package main.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import main.data.PeriodicTable;
import main.interfaces.AdjustablePSE;
import main.interfaces.MouseController;

/**
 * PSE (Periodicsystem of Elements) is a JFrame that displays the periodic table of elements.
 * It uses a GridBagLayout to arrange the elements in a grid format.
 * Each element is represented by a JLabel, and mouse events can be handled through a MouseController.
 * The class also provides methods to set mouse event listeners and retrieve the true dimension of the frame.
 */
public class PSE extends JFrame implements AdjustablePSE{

    /**
     * The maximum number of columns in the periodic table.
     * This value is determined dynamically based on the element table data.
     */
    private static int maxColumns;

    /**
     * The maximum number of rows in the periodic table.
     * This is a constant value representing the number of rows in the periodic table.
     */
    private static final int MAX_ROWS = 7;

    /**
     * The true dimension of the PSE window, used to reset the window size.
     * This is set when the window is initialized and can be retrieved later.
     */
    private final Dimension TRUE_DIMENSION;

    /**
     * A list of JLabel objects representing the elements in the periodic table.
     * Each label corresponds to an element and is used to display its symbol and properties.
     */
    private final List<JLabel> elementLabels = new ArrayList<>();  // Liste für alle Element-Labels

    /**
     * A list of JButton objects for additional functionality, such as a menu button.
     * These buttons can be used to trigger actions or navigate within the application.
     */
    private final List<JButton> buttons = new ArrayList<>();

    /**
     * Constructor for the PSE class.
     * Initializes the JFrame with a title, size, and background color.
     * It also sets up the periodic table elements in a grid layout.
     */
    public PSE() {
        setTitle("Periodensystem der Elemente");
        setSize(1000, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(PeriodicTable.getMAINBG());

        TRUE_DIMENSION = getSize();

        String[][] elementTable = PeriodicTable.getElementTable();

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(PeriodicTable.getMAINBG());
        this.add(mainPanel);

        maxColumns = 0;
        for (String[] row : elementTable) {
            maxColumns = Math.max(maxColumns, row.length);
        }

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setLayout(gbl);

        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < maxColumns; j++) {

                if (elementTable[i][j].equals("")) {
                    JLabel label = new JLabel(" ");
                    label.setBackground(PeriodicTable.getElementColor(elementTable[i][j]));
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

                JLabel label = new JLabel(" " + elementTable[i][j]);
                label.setBackground(PeriodicTable.getElementColor(elementTable[i][j]));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
                label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                label.setName(elementTable[i][j]);
                elementLabels.add(label); // Label in Liste speichern (Listener wird später gesetzt)

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
        gbc.gridwidth = maxColumns - 2;
        JLabel fillerLabel = new JLabel(" ");
        fillerLabel.setBackground(PeriodicTable.getMAINBG().brighter());
        fillerLabel.setOpaque(true);
        fillerLabel.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        mainPanel.add(fillerLabel, gbc);

        // Menu Button //
        gbc.gridx = maxColumns - 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridwidth = 2;
        JButton menuButton = new JButton("Menü");
        menuButton.setBackground(new Color(150, 150, 150));
        menuButton.setOpaque(true);
        menuButton.setBorder(BorderFactory.createLineBorder(PeriodicTable.getMAINBG(), 2));
        buttons.add(menuButton);
        mainPanel.add(menuButton, gbc);

        setVisible(true);
    }

    /**
     * Returns the start/standard window dimension of the PSE.
     * 
     * @return the start/standard dimension of the PSE window
     */
    @Override
    public Dimension getTrueDimension() {
        return this.TRUE_DIMENSION;
    }

    /**
     * Sets the mouse event listener for the PSE.
     * This method adds the provided MouseController's MouseListener to all element labels and buttons,
     * allowing them to respond to mouse events.
     * 
     * @param mouseController the MouseController that handles mouse events
     */
    @Override
    public void setMouseEventListener(MouseController mouseController) {
        if (mouseController != null) {
            MouseListener ml = mouseController.getMouseListener();

            // Listener an alle Element-Labels hängen
            for (JLabel label : elementLabels) {
                label.addMouseListener(ml);
            }

            // Listener auch ans JFrame selbst hängen (für Fenster-Klicks)
            this.addMouseListener(ml);

            for (JButton button : buttons) {
                button.addMouseListener(ml);
            }
        }
    }

    @Override
    public void setLanguage(String lang) {
        //TODO: Implement language setting logic here if needed
        // Implement language setting logic here if needed
        // This method can be used to change the language of the PSE interface
    }

    @Override
    public void setFont(String fontName, int fontSize) {
        //TODO: Implement font setting logic here if needed
        // Implement font setting logic here if needed
        // This method can be used to change the font of the PSE interface
    }

    @Override
    public void setDarkMode(boolean darkMode) {
        //TODO: Implement dark mode setting logic here if needed
        // Implement dark mode setting logic here if needed
        // This method can be used to toggle dark mode for the PSE interface
    }
}