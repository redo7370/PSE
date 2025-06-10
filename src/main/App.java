package main;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.interfaces.FontController;
import main.interfaces.MouseController;
import main.interfaces.WindowController;
import main.services.FontHandler;
import main.services.MouseEventHandler;
import main.services.WindowEventHandler;
import main.ui.PSE;
import main.util.MemoryMonitor;

public class App extends Application {

    private MouseController mc;
    private WindowController wc;
    private FontController fc;

    @Override
    public void start(Stage primaryStage) {
        // MemoryMonitor läuft im Hintergrund
        startMemoryMonitor();

        // Event-Handler initialisieren
        mc = new MouseEventHandler(this);
        wc = new WindowEventHandler();
        fc = new FontHandler();

        // JavaFX UI starten
        PSE pse = new PSE();
        pse.setMouseEventListener(mc);
        wc.addWindowListener(pse);

        primaryStage.show();
    }

    private void startMemoryMonitor() {
        MemoryMonitor monitor = new MemoryMonitor();
        Thread monitorThread = new Thread(monitor);
        monitorThread.setName("Monitor");
        monitorThread.setDaemon(true);
        monitorThread.start();
    }

    public MouseController getMouseListener() {
        return this.mc;
    }

    public WindowController getWindowListener() {
        return this.wc;
    }

    public FontController getFontController() {
        return this.fc;
    }

    public Font requestFont(String fontName, int size) {
        return this.fc.getFont(fontName, size);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
