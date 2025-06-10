package main.ui;

import javafx.scene.Scene;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

import main.data.PeriodicTable;
import main.interfaces.MouseController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * PSE (Periodensystem der Elemente) als JavaFX Stage mit GridPane Layout.
 */
public class PSE extends Stage {

    private static int maxColumns;
    private static final int MAX_ROWS = 7;

    private final double START_WIDTH = 1000;
    private final double START_HEIGHT = 300;

    private final List<Label> elementLabels = new ArrayList<>();
    private final List<Button> buttons = new ArrayList<>();

    private GridPane mainGrid;

    public PSE() {
        setTitle("Periodensystem der Elemente");

        mainGrid = new GridPane();
        mainGrid.setBackground(new Background(new BackgroundFill(
                javafx.scene.paint.Paint.valueOf(toRgbString(PeriodicTable.getMAINBG())), CornerRadii.EMPTY, Insets.EMPTY)));

        String[][] elementTable = PeriodicTable.getElementTable();

        maxColumns = 0;
        for (String[] row : elementTable) {
            maxColumns = Math.max(maxColumns, row.length);
        }

        // Spalten- und Zeilenconstraints für gleichmäßige Verteilung
        for (int i = 0; i < maxColumns; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / maxColumns);
            mainGrid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < MAX_ROWS + 2; i++) {  // +2 für Menü-Button und Filler-Zeile
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / (MAX_ROWS + 2));
            mainGrid.getRowConstraints().add(rowConst);
        }

        // Elemente erzeugen und ins Grid einfügen
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < maxColumns; j++) {
                String symbol = elementTable[i][j];
                Label label;
                if (symbol == null || symbol.isEmpty()) {
                    label = createLabel(" ", PeriodicTable.getMAINBG());
                } else {
                    label = createLabel(" " + symbol, PeriodicTable.getElementColor(symbol));
                    label.setCursor(Cursor.HAND);
                    label.setId(symbol);  // ID als Ersatz für label.setName()
                    elementLabels.add(label);
                }
                mainGrid.add(label, j, i);
            }
        }

        // Filler Label - Trennung Tabelle / Input (Zeile 8)
        Label fillerLabel = createLabel(" ", PeriodicTable.getMAINBG().brighter());
        GridPane.setColumnSpan(fillerLabel, maxColumns - 2);
        mainGrid.add(fillerLabel, 0, 8);

        // Menü Button
        Button menuButton = new Button("Menü");
        menuButton.setStyle("-fx-background-color: rgb(150,150,150); -fx-border-color: " + toRgbString(PeriodicTable.getMAINBG()) + ";");
        buttons.add(menuButton);
        GridPane.setColumnSpan(menuButton, 2);
        mainGrid.add(menuButton, maxColumns - 2, 8);

        Scene scene = new Scene(mainGrid, START_WIDTH, START_HEIGHT);
        setScene(scene);
        show();
    }

    /**
     * Hilfsmethode: Label mit Text und Hintergrundfarbe erstellen.
     */
    private Label createLabel(String text, Color bgColor) {
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setStyle("-fx-border-color: " + toRgbString(PeriodicTable.getMAINBG()) + "; -fx-border-width: 2;");
        return label;
    }

    /**
     * Hilfsmethode: JavaFX Color in CSS rgb String umwandeln.
     */
    private String toRgbString(Color c) {
        int r = (int) (c.getRed() * 255);
        int g = (int) (c.getGreen() * 255);
        int b = (int) (c.getBlue() * 255);
        return String.format("rgb(%d,%d,%d)", r, g, b);
    }

    /**
     * Gibt die Startgröße des Fensters zurück.
     */
    public javafx.geometry.Dimension2D getStartDimension() {
        return new javafx.geometry.Dimension2D(START_WIDTH, START_HEIGHT);
    }

    /**
     * Setzt den MouseController als EventHandler für alle Elemente und Buttons.
     * Die Methode hängt die MouseListener des Controllers an alle Labels und Buttons.
     * @param mouseController Controller mit MouseListener (JavaFX EventHandler)
     */
    public void setMouseEventListener(MouseController mouseController) {
        if (mouseController != null) {
            // In JavaFX erwartet man EventHandler<MouseEvent> statt MouseListener
            EventHandler<MouseEvent> handler = mouseController.getMouseListener();

            // An alle Element-Labels binden
            for (Label label : elementLabels) {
                label.setOnMouseClicked(handler);
            }
            // An alle Buttons binden
            for (Button button : buttons) {
                button.setOnMouseClicked(handler);
            }
            // An das Stage (Fenster) selbst binden
            getScene().setOnMouseClicked(handler);
        }
    }
}
