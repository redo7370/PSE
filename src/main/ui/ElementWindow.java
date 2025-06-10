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
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.stream.IntStream;

import main.data.ChemicalElement;
import main.data.PeriodicTable;
import main.interfaces.FixElementWindow;

/**
 * ElementWindow is a JFrame that displays detailed information about a specific chemical element.
 * It includes the element's symbol, atomic number, name, atomic weight, electronegativity,
 * electron configuration, melting and boiling points, oxidation numbers, standard potential,
 * and group information. The window is styled with a background color corresponding to the element's
 * color in the periodic table.
 * 
 */
public class ElementWindow extends JFrame implements FixElementWindow {

    /**
     * The atomic number of the element displayed in this window.
     * This is used to identify the element and retrieve its properties.
     * It is a byte value, as atomic numbers are typically small integers.
     */
    private final byte ELEMENT_INDEX;

    /**
     * The true dimension of the JFrame, which is used to reset the window size
     * to its original dimensions when needed.
     * This is set when the window is initialized and can be retrieved later.
     */
    private final Dimension TRUE_DIMENSION;

    /**
     * Constructor for the ElementWindow class.
     * Initializes the JFrame with the element's details and styles it according to the element's color.
     *
     * @param element The ChemicalElement object containing the element's data.
     */
    public ElementWindow( ChemicalElement element) {
        this.ELEMENT_INDEX = element.getAtomicNumber();

        setTitle(element.getNames().get("de"));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // MouseListener
        TRUE_DIMENSION = getSize();

        // Hintergrundfarbe aus PeriodicTable holen
        Color elementColor = PeriodicTable.getElementColor(element.getSymbol());
        getContentPane().setBackground(elementColor);

        setLayout(new BorderLayout());

        JLabel symbolLabel = new JLabel(element.getSymbol(), SwingConstants.CENTER);
        symbolLabel.setFont(this.loadFontFromFile("res/fonts/FiraCode-Medium.ttf", 60));
        symbolLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        symbolLabel.setForeground(getContrastColor(elementColor));
        symbolLabel.setOpaque(false);
        add(symbolLabel, BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        detailsPanel.setOpaque(false);
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        addDetail(detailsPanel, "Ordnungszahl:", String.valueOf(element.getAtomicNumber()), 0);
        addDetail(detailsPanel, "Name:", element.getNames().getOrDefault("de", "-"), 1);
        addDetail(detailsPanel, "Atomgewicht:", String.valueOf(element.getAtomicWeight()), 1);
        addDetail(detailsPanel, "Elektronegativität:", String.valueOf(element.getElectronegativity()), 0);
        addDetail(detailsPanel, "Elektronenkonfiguration:", element.getElectronConfiguration(), 1);
        addDetail(detailsPanel, "Schmelzpunkt (°K):", String.valueOf(element.getMeltingPoint()), 0);
        addDetail(detailsPanel, "Siedepunkt (°K):", String.valueOf(element.getBoilingPoint()), 1);
        addDetail(detailsPanel, "Oxidationszahlen:", oxidationArrayToString(IntStream.range(0, element.getOxidationNumbers().length).map(i -> element.getOxidationNumbers()[i]).toArray()), 0);
        addDetail(detailsPanel, "Standardpotential (V):", String.valueOf(element.getStandardPotential()), 1);
        addDetail(detailsPanel, "Gruppe:", element.isExtra().getOrDefault("de", "-"), 0);

        add(detailsPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Adds a detail label and its corresponding value to the details panel.
     * The background color alternates for each row to improve readability.
     *
     * @param panel The JPanel to which the detail will be added.
     * @param label The label text for the detail.
     * @param value The value text for the detail.
     * @param rowIndex The index of the row, used to determine the background color.
     */
    private void addDetail(JPanel panel, String label, String value, int rowIndex) {
        Color bgColor = (rowIndex % 2 == 0) ? new Color(200, 200, 200, 100) : new Color(220, 220, 220, 100);
        JLabel labelComp = new JLabel(label);
        JLabel valueComp = new JLabel(value);

        labelComp.setOpaque(true);
        valueComp.setOpaque(true);
        labelComp.setBackground(bgColor);
        valueComp.setBackground(bgColor);

        labelComp.setForeground(Color.BLACK);
        valueComp.setForeground(Color.BLACK);

        labelComp.setFont(loadFontFromFile("res/fonts/FiraCode/FiraCode-Medium.ttf", 12));
        valueComp.setFont(loadFontFromFile("res/fonts/FiraCode/FiraCode-Medium.ttf", 12));

        panel.add(labelComp);
        panel.add(valueComp);
    }

    /**
     * Converts an array of oxidation states to a string representation.
     * If the array is empty or null, it returns a dash ("-").
     *
     * @param arr The array of oxidation states.
     * @return A string representation of the oxidation states.
     */
    private String oxidationArrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "-";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length -1) sb.append(", ");
        }
        return sb.toString();
    }

    /**
     * Determines a contrasting color (black or white) based on the luminance of the background color.
     * This is used to ensure that text is readable against the background color.
     *
     * @param bg The background color.
     * @return A contrasting color (black or white).
     */
    private Color getContrastColor(Color bg) {
        double luminance = (0.299 * bg.getRed() + 0.587 * bg.getGreen() + 0.114 * bg.getBlue()) / 255;
        return luminance > 0.5 ? Color.BLACK : Color.WHITE;
    }

    /**
     * Returns the atomic number of the element displayed in this window.
     *
     * @return The atomic number of the element.
     */
    public byte getElementNum() {
        return this.ELEMENT_INDEX;
    }

    /**
     * Loads a font from a file and returns it with the specified size.
     * If the font cannot be loaded, it falls back to a default monospaced font.
     *
     * @param path The path to the font file.
     * @param size The desired font size.
     * @return The loaded Font object.
     */
    private Font loadFontFromFile(String path, float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            return font.deriveFont(size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Monospaced", Font.PLAIN, (int) size); // Fallback
        }
    }

    /**
     * Returns the true dimension of the window, which is the size of the JFrame.
     * This can be useful for layout calculations or resizing operations.
     *
     * @return The true dimension of the JFrame.
     */
    public Dimension getTrueDimension() {
        return this.TRUE_DIMENSION;
    }
}