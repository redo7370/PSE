package main.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuWindow extends Stage {

    private final ToggleButton lightModeToggle;
    private final ToggleButton darkModeToggle;
    private final double WIDTH = 300;
    private final double HEIGHT = 300;

    public MenuWindow(Color bg) {
        setTitle("Menü");

        // Layout-Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(16));
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setStyle("-fx-background-color: " + toRgbString(bg) + ";");

        // ToggleGroup für Light / Dark Mode
        ToggleGroup toggleGroup = new ToggleGroup();

        lightModeToggle = new ToggleButton("Light");
        lightModeToggle.setToggleGroup(toggleGroup);
        lightModeToggle.setSelected(true);
        lightModeToggle.setStyle(
            "-fx-background-color: #FFFFB4;" +  // hellgelb
            "-fx-text-fill: #4B4B4B;" +        // dunkles Grau
            "-fx-border-color: #BDBE00;" +     // gelb dunkler
            "-fx-border-width: 2;"
        );

        darkModeToggle = new ToggleButton("Dark");
        darkModeToggle.setToggleGroup(toggleGroup);
        darkModeToggle.setStyle(
            "-fx-background-color: #323264;" +  // dunkles Blau
            "-fx-text-fill: white;" +            // weißer Text
            "-fx-border-color: #00008B;" +       // blau dunkel
            "-fx-border-width: 2;"
        );

        // Listener ToggleGroup
        toggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == lightModeToggle) {
                System.out.println("Light mode aktiviert");
            } else if (newToggle == darkModeToggle) {
                System.out.println("Dark mode aktiviert");
            } else {
                // Falls keiner gewählt ist, wähle Light mode
                lightModeToggle.setSelected(true);
            }
        });

        // Language ComboBox
        ComboBox<String> languageSelect = new ComboBox<>();
        languageSelect.getItems().addAll("Deutsch", "English");
        languageSelect.getSelectionModel().selectFirst();
        languageSelect.setStyle(
            "-fx-background-color: #78C878;" +  // helles Grün
            "-fx-text-fill: white;" +            // weißer Text
            "-fx-border-color: #009600;" +       // dunkler Grün
            "-fx-border-width: 2;"
        );

        // Positionierung im GridPane
        grid.add(lightModeToggle, 1, 0);
        grid.add(darkModeToggle, 3, 0);
        grid.add(languageSelect, 1, 1, 3, 1);  // colspan 3

        // Scene & Stage Setup
        Scene scene = new Scene(grid, WIDTH, HEIGHT);
        setScene(scene);
    }

    public ToggleButton[] getToggleButtons() {
        return new ToggleButton[]{lightModeToggle, darkModeToggle};
    }

    // Hilfsmethode: JavaFX Color zu CSS RGB String
    private static String toRgbString(Color c) {
        int r = (int) Math.round(c.getRed() * 255);
        int g = (int) Math.round(c.getGreen() * 255);
        int b = (int) Math.round(c.getBlue() * 255);
        return String.format("rgb(%d, %d, %d)", r, g, b);
    }
}
