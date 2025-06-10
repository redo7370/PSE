package main.services;

import java.awt.Frame;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.data.ChemicalElement;
import main.data.Elements;
import main.data.PeriodicTable;
import main.interfaces.MouseController;
import main.ui.ElementWindow;
import main.ui.MenuWindow;
import main.App;

public class MouseEventHandler implements MouseController {

    private final App app;

    public MouseEventHandler(App app) {
        this.app = app;
    }

    @Override
    public void handle(MouseEvent event) {
        Object source = event.getSource();

        // Beispiel: Button "Menü" in JavaFX
        if (source instanceof Button button) {
            if ("Menü".equals(button.getText())) {
                // Menüfenster anzeigen oder fokussieren
                for (Window window : Stage.getWindows()) {
                    if (window instanceof MenuWindow mw && window.isShowing()) {
                        mw.toFront();
                        mw.requestFocus();
                        return;
                    }
                }
                MenuWindow mw = new MenuWindow(PeriodicTable.getMAINBG());
                // hier müsstest du evtl. Register-Methoden für Fenster aufrufen, analog Swing
                mw.show();
                mw.requestFocus();
                return;
            }
        }

        // Labels mit Symbolen behandeln
        if (!(source instanceof Label label)) {
            return;
        }

        String symbol = label.getId();  // In JavaFX besser id statt Name

        if (symbol == null || symbol.isEmpty()) {
            // JavaFX-Dialog oder eigene Fehlermeldung
            System.out.println("Bitte ein Element eingeben.");
            return;
        }

        ChemicalElement element = Elements.getElement(symbol);

        if (element == null) {
            System.out.println("Element nicht gefunden: " + symbol);
            return;
        }

        byte targetAtomicNumber = element.getAtomicNumber();

        // Fenster-Logik JavaFX: Du müsstest deine Fensterklasse so anpassen,
        // dass du alle offenen Fenster trackst. 
        // Beispiel: Elemente öffnen, falls noch nicht offen, sonst fokusieren.

        // Hier musst du deine Logik ergänzen, um offene Fenster zu tracken (z.B. mit eigener Liste).

        ElementWindow ew = new ElementWindow(element, app);
        ew.requestFocus();
        // app.getMouseListener().registerWindow(ew); // Eventuell anpassen
        // app.getWindowListener().registerWindow(ew); // Eventuell anpassen
    }

    // Optional kannst du eine Methode zum Registrieren als EventHandler schreiben:
    public EventHandler<MouseEvent> getMouseEventHandler() {
        return this;
    }

    @Override
    public EventHandler<MouseEvent> getMouseListener() {
        return event -> {
            // Beispielverhalten
            System.out.println("Mouse clicked: " + event.getSceneX() + ", " + event.getSceneY());
        };
    }

    @Override
    public void registerWindow(Frame frame) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerWindow'");
    }
}
