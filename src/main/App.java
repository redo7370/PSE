package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.interfaces.MouseController;
import main.interfaces.WindowController;
import main.services.MouseEventHandler;
import main.services.WindowEventHandler;
import main.ui.PSE;
import main.util.MemoryMonitor;

/**
 * The main application class that initializes the mouse and window event handlers,
 * sets the GUI look and feel, and starts the application.
 * This class is responsible for managing the application's lifecycle and
 * ensuring that all components are properly initialized.
 * 
 * @author Jim Feser
 * @version 0.1.1
 * 
 * <p>
 * The application runs on the Event Dispatch Thread (EDT) to ensure thread safety
 * for GUI operations. It also starts a memory monitor thread to keep track of memory usage. (Only Development)
 * </p>
 */
public class App {

    /**
     * The MouseController instance that handles mouse events in the application.
     */
    private MouseController mc;

    /**
     * The WindowController instance that handles window events in the application.
     */
    private WindowController wc;

    /**
     * The main method that serves as the entry point for the application.
     * It initializes the MemoryMonitor and starts the application by invoking the start method.
     * The MemoryMonitor runs in a separate daemon thread to monitor memory usage without blocking
     * JVM shutdown (optional, removed on release).
     */
    public App() {
        start();
    }
    
    /**
     * The main method to run the application.
     * It creates an instance of MemoryMonitor and starts
     * it in a daemon thread (optional, removed on release),
     * then creates an instance of the App class to initialize the application.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        MemoryMonitor monitor = new MemoryMonitor();
        Thread monitorThread = new Thread(monitor);
        monitorThread.setName("Monitor");
        monitorThread.setDaemon(true);
        monitorThread.start();
        
        new App();
    }

    /**
     * Initializes the application by setting up the mouse and window event handlers,
     * and configuring the GUI look and feel.
     * This method is invoked on the Event Dispatch Thread (EDT) to ensure that
     * all GUI-related operations are performed in a thread-safe manner.
     */
    private void start() {
        mc = new MouseEventHandler(this);
        wc = new WindowEventHandler();

        // GUI Issue Handling For macOS
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Cannot set LookAndFeel");
        }

        // Reserve Thread To Run The GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            PSE pse = new PSE();
            pse.setMouseEventListener(mc);
            wc.addWindowListener(pse);
        });
    }

    /**
     * Returns the mouse event handler for this application.
     * 
     * @return the MouseController instance handling mouse events
     */
    public MouseController getMouseListener() {
        return this.mc;
    }
    
    /**
     * Returns the window event handler for this application.
     * 
     * @return the WindowController instance handling window events
     */
    public WindowController getWindowListener() {
        return this.wc;
    }
    
}
