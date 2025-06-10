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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory;

/**
 * MenuWindow is a JFrame that provides a user interface for selecting light and dark modes,
 * as well as a language selection dropdown. It uses a GridBagLayout to arrange the components
 * in a structured manner.
 * 
 * The window features two toggle buttons for light and dark modes, and a combo box for language selection.
 * The background color can be customized, and the layout is designed to be user-friendly with appropriate spacing.
 */
public class MenuWindow extends JFrame {

    private final JToggleButton lightModeToggle, darkModeToggle;
    private final Dimension startDimension = new Dimension(300, 300);
    
    /**
     * Constructor for the MenuWindow class.
     * Initializes the JFrame with a title, size, and background color.
     * Sets up the layout and adds toggle buttons for light and dark modes,
     * as well as a language selection combo box.
     *
     * @param bg The background color for the window.
     */
    public MenuWindow(Color bg) {
        setTitle("Menü");
        setSize(startDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(bg);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(bg);
        this.add(mainPanel);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setLayout(gbl);

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(8, 8, 8, 8); // größerer Abstand für Luftigkeit

        // Light Button - freundlich hellgelb
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        lightModeToggle = new JToggleButton("Light");
        lightModeToggle.setBackground(new Color(255, 255, 180));  // hellgelb
        lightModeToggle.setOpaque(true);
        lightModeToggle.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker(), 2));
        lightModeToggle.setForeground(Color.DARK_GRAY);
        mainPanel.add(lightModeToggle, gbc);

        // Dark Button - dunkles Blau mit weißem Text
        gbc.gridx = 3;
        gbc.gridy = 0;
        darkModeToggle = new JToggleButton("Dark");
        darkModeToggle.setBackground(new Color(50, 50, 100));  // dunkles Blau
        darkModeToggle.setOpaque(true);
        darkModeToggle.setBorder(BorderFactory.createLineBorder(Color.BLUE.darker(), 2));
        darkModeToggle.setForeground(Color.WHITE);
        mainPanel.add(darkModeToggle, gbc);

        lightModeToggle.setSelected(true);
        darkModeToggle.setSelected(false);

        // Gemeinsamer Listener
        ActionListener toggleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton source = (JToggleButton) e.getSource();
                if (source == lightModeToggle) {
                    if (lightModeToggle.isSelected()) {
                        darkModeToggle.setSelected(false);
                        System.out.println("Light mode aktiviert");
                    } else if (!darkModeToggle.isSelected()) {
                        // Immer einen ausgewählt lassen
                        lightModeToggle.setSelected(true);
                    }
                } else if (source == darkModeToggle) {
                    if (darkModeToggle.isSelected()) {
                        lightModeToggle.setSelected(false);
                        System.out.println("Dark mode aktiviert");
                    } else if (!lightModeToggle.isSelected()) {
                        // Immer einen ausgewählt lassen
                        darkModeToggle.setSelected(true);
                    }
                }
            }
        };

        // Listener hinzufügen
        lightModeToggle.addActionListener(toggleListener);
        darkModeToggle.addActionListener(toggleListener);


        // Language ComboBox - frisches Grün mit weißem Text
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        JComboBox<String> languageSelect = new JComboBox<>(new String[]{"Deutsch", "English"});
        languageSelect.setBackground(new Color(120, 200, 120));  // helles Grün
        languageSelect.setOpaque(true);
        languageSelect.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 0), 2));
        languageSelect.setForeground(Color.WHITE);
        mainPanel.add(languageSelect, gbc);

        // Fenster sichtbar machen
        setVisible(true);
    }

    public JToggleButton[] getToggleButtons() {
        return new JToggleButton[]{ lightModeToggle, darkModeToggle };
    }

    public Dimension getStartDimension() {
        return startDimension;
    }
}