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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import main.data.ChemicalElement;
import main.data.PeriodicTable;
import main.App;

import java.util.ArrayList;

/**
 * ElementWindow ist ein JavaFX-Stage, das Details eines chemischen Elements anzeigt.
 * Entspricht funktional dem Swing-JFrame ElementWindow.
 */
public class ElementWindow extends Stage {

    private final byte ELEMENT_INDEX;
    private final double START_WIDTH = 400;
    private final double START_HEIGHT = 400;

    private final App app;

    private final ArrayList<Label> labelList = new ArrayList<>();

    public ElementWindow(ChemicalElement element, App app) {
        this.ELEMENT_INDEX = element.getAtomicNumber();
        this.app = app;

        setTitle(element.getNames().get("de"));

        // Hintergrundfarbe ermitteln (JavaFX Color)
        Color elementColor = PeriodicTable.getElementColor(element.getSymbol());

        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(elementColor, CornerRadii.EMPTY, Insets.EMPTY)));

        // Symbol Label oben
        Label symbolLabel = new Label(element.getSymbol());
        symbolLabel.setFont(app.getFontController().getFont("Fira", 60)); // JavaFX-Font laden, siehe Erklärung weiter unten
        symbolLabel.setTextFill(getContrastColor(elementColor));
        symbolLabel.setPadding(new Insets(10));
        symbolLabel.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(symbolLabel, Pos.CENTER);
        root.setTop(symbolLabel);

        // Details-Grid
        GridPane detailsGrid = new GridPane();
        detailsGrid.setHgap(10);
        detailsGrid.setVgap(5);
        detailsGrid.setPadding(new Insets(10, 20, 10, 20));

        // Details einfügen (Zeilenindex zählt)
        int row = 0;
        row = addDetail(detailsGrid, "Ordnungszahl:", String.valueOf(element.getAtomicNumber()), row);
        row = addDetail(detailsGrid, "Name:", element.getNames().getOrDefault("de", "-"), row);
        row = addDetail(detailsGrid, "Atomgewicht:", String.valueOf(element.getAtomicWeight()), row);
        row = addDetail(detailsGrid, "Elektronegativität:", String.valueOf(element.getElectronegativity()), row);
        row = addDetail(detailsGrid, "Elektronenkonfiguration:", element.getElectronConfiguration(), row);
        row = addDetail(detailsGrid, "Schmelzpunkt (°K):", String.valueOf(element.getMeltingPoint()), row);
        row = addDetail(detailsGrid, "Siedepunkt (°K):", String.valueOf(element.getBoilingPoint()), row);
        row = addDetail(detailsGrid, "Oxidationszahlen:", oxidationArrayToString(element.getOxidationNumbers()), row);
        row = addDetail(detailsGrid, "Standardpotential (V):", String.valueOf(element.getStandardPotential()), row);
        row = addDetail(detailsGrid, "Gruppe:", element.isExtra().getOrDefault("de", "-"), row);

        root.setCenter(detailsGrid);

        Scene scene = new Scene(root, START_WIDTH, START_HEIGHT);
        setScene(scene);
        setResizable(false);

        show();
    }

    private int addDetail(GridPane grid, String labelText, String valueText, int rowIndex) {
        Color bgColor = (rowIndex % 2 == 0) ? Color.rgb(200, 200, 200, 0.4) : Color.rgb(220, 220, 220, 0.4);

        Label label = new Label(labelText);
        Label value = new Label(valueText);

        label.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
        value.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));

        label.setTextFill(Color.BLACK);
        value.setTextFill(Color.BLACK);

        label.setFont(app.getFontController().getFont("FiraCode", 12));
        value.setFont(app.getFontController().getFont("FiraCode", 12));

        label.setPadding(new Insets(2, 5, 2, 5));
        value.setPadding(new Insets(2, 5, 2, 5));

        grid.add(label, 0, rowIndex);
        grid.add(value, 1, rowIndex);

        labelList.add(label);
        labelList.add(value);

        return rowIndex + 1;
    }

    private String oxidationArrayToString(byte[] arr) {
        if (arr == null || arr.length == 0) return "-";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        return sb.toString();
    }

    private Color getContrastColor(Color bg) {
        double luminance = (0.299 * bg.getRed() + 0.587 * bg.getGreen() + 0.114 * bg.getBlue());
        return luminance > 0.5 ? Color.BLACK : Color.WHITE;
    }

    public byte getElementNum() {
        return ELEMENT_INDEX;
    }

    public double getStartWidth() {
        return START_WIDTH;
    }

    public double getStartHeight() {
        return START_HEIGHT;
    }

    /**
     * Update font aller Labels dynamisch (entsprechend Swing-Methode)
     */
    public void updateLabelFont(String fontName, int size) {
        Font font = app.getFontController().getFont(fontName, size);
        for (Label label : labelList) {
            label.setFont(font);
        }
    }
}
