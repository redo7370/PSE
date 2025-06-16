package main.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import main.data.PeriodicTable;
import main.interfaces.AdjustableMenuWindow;

import javax.swing.BorderFactory;

/**
 * MenuWindow is a JFrame that provides a user interface for selecting light and dark modes,
 * as well as a language selection dropdown and font settings.
 * It uses a GridBagLayout to arrange the components in a structured manner.
 */
public class MenuWindow extends JFrame implements AdjustableMenuWindow{

    private final JToggleButton lightModeToggle, darkModeToggle;
    private final Dimension trueDimension = new Dimension(350, 220);
    private final JComboBox<String> fontSelect;
    private final JComboBox<Integer> fontSizeSelect;
    private final Color MAINBG; // Hintergrundfarbe des Fensters, z.B. Wasserstoff-Farbe

    /**
     * Constructor for the MenuWindow class.
     * Initializes the JFrame with a title, size, and background color.
     * Sets up the layout and adds toggle buttons for light and dark modes,
     * as well as a language selection combo box and font selection controls.
     *
     * @param bg The background color for the window.
     */
    public MenuWindow() {
        this.MAINBG = PeriodicTable.getMAINBG();
        setTitle("Menü");
        setSize(trueDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(this.MAINBG); // Set background color to Hydrogen color

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(this.MAINBG);
        this.add(mainPanel);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setLayout(gbl);

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(8, 8, 8, 8); // Abstand für Luftigkeit

        // Light Mode Toggle Button - hellgelb
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        lightModeToggle = new JToggleButton("Light");
        lightModeToggle.setBackground(new Color(255, 255, 180));
        lightModeToggle.setOpaque(true);
        lightModeToggle.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker(), 2));
        lightModeToggle.setForeground(Color.DARK_GRAY);
        mainPanel.add(lightModeToggle, gbc);

        // Dark Mode Toggle Button - dunkles Blau
        gbc.gridx = 3;
        darkModeToggle = new JToggleButton("Dark");
        darkModeToggle.setBackground(new Color(50, 50, 100));
        darkModeToggle.setOpaque(true);
        darkModeToggle.setBorder(BorderFactory.createLineBorder(Color.BLUE.darker(), 2));
        darkModeToggle.setForeground(Color.WHITE);
        mainPanel.add(darkModeToggle, gbc);

        lightModeToggle.setSelected(true);
        darkModeToggle.setSelected(false);

        // Gemeinsamer Listener für Mode Toggle Buttons
        ActionListener toggleListener = e -> {
            JToggleButton source = (JToggleButton) e.getSource();
            if (source == lightModeToggle) {
                if (lightModeToggle.isSelected()) {
                    darkModeToggle.setSelected(false);
                    System.out.println("Light mode aktiviert");
                } else if (!darkModeToggle.isSelected()) {
                    lightModeToggle.setSelected(true); // mind. einer aktiv
                }
            } else if (source == darkModeToggle) {
                if (darkModeToggle.isSelected()) {
                    lightModeToggle.setSelected(false);
                    System.out.println("Dark mode aktiviert");
                } else if (!lightModeToggle.isSelected()) {
                    darkModeToggle.setSelected(true); // mind. einer aktiv
                }
            }
        };
        lightModeToggle.addActionListener(toggleListener);
        darkModeToggle.addActionListener(toggleListener);

        // Sprache ComboBox - hellgrün mit weißem Text
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        JComboBox<String> languageSelect = new JComboBox<>(new String[]{"Deutsch", "English"});
        languageSelect.setBackground(new Color(120, 200, 120));
        languageSelect.setOpaque(true);
        languageSelect.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 0), 2));
        languageSelect.setForeground(Color.WHITE);
        mainPanel.add(languageSelect, gbc);

        // Font Auswahl - System-Schriftarten laden
        String[] fonts = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        fontSelect = new JComboBox<>(fonts);
        fontSelect.setSelectedItem("SansSerif"); // Default
        fontSelect.setBackground(Color.WHITE);
        fontSelect.setForeground(Color.BLACK);

        // Schriftgröße Auswahl (z.B. 8 bis 48 in Steps)
        Integer[] sizes = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 48};
        fontSizeSelect = new JComboBox<>(sizes);
        fontSizeSelect.setSelectedItem(12);
        fontSizeSelect.setBackground(Color.WHITE);
        fontSizeSelect.setForeground(Color.BLACK);

        // 3. Zeile: Labels und Controls für Font und Größe
        gbc.gridy = 2;
        gbc.gridwidth = 1;

        // Label Schriftart
        gbc.gridx = 0;
        JLabel fontLabel = new JLabel("Schriftart:");
        fontLabel.setForeground(Color.WHITE);
        mainPanel.add(fontLabel, gbc);

        // Font ComboBox
        gbc.gridx = 1;
        mainPanel.add(fontSelect, gbc);

        // Label Schriftgröße
        gbc.gridx = 2;
        JLabel fontSizeLabel = new JLabel("Größe:");
        fontSizeLabel.setForeground(Color.WHITE);
        mainPanel.add(fontSizeLabel, gbc);

        // FontSize ComboBox
        gbc.gridx = 3;
        mainPanel.add(fontSizeSelect, gbc);

        setVisible(true);
    }

    @Override
    public JToggleButton[] getToggleButtons() {
        return new JToggleButton[]{lightModeToggle, darkModeToggle};
    }

    @Override
    public Dimension getTrueDimension() {
        return trueDimension;
    }

    @Override
    public JComboBox<String> getFontSelect() {
        return fontSelect;
    }

    @Override
    public JComboBox<Integer> getFontSizeSelect() {
        return fontSizeSelect;
    }

    @Override
    public void setLanguage(String language) {
        // Implement language change logic here if needed
        //TODO: Implement language change logic here if needed
    }

    @Override
    public void setDarkMode(boolean darkMode) {
        // Implement dark mode logic here if needed
        //TODO: Implement dark mode logic here if needed
    }

    @Override
    public void setFont(String fontName, int fontSize) {
        // Implement font setting logic here if needed
        //TODO: Implement font setting logic here if needed
    }

}