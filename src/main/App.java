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

package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import main.interfaces.FontController;
import main.interfaces.MouseController;
import main.interfaces.WindowController;
import main.services.FontHandler;
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
     * The FontController instance that manages font operations in the application.
     */
    private FontController fc;

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
        fc = new FontHandler();

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

    /**
     * Returns the font controller for this application.
     * 
     * @return the FontController instance handling font operations
     */
    public FontController getFontController() {
        return this.fc;
    }

    public Font requestFont(String fontName, int size) {
        return this.fc.getFont(fontName, size);
    }
    
}