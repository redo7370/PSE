package main.services;

import main.interfaces.WindowController;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;

/**
 * WindowEventHandler is a service that manages window events in the application.
 * It keeps track of all open windows and ensures that the application exits when
 * the last window is closed.
 * This class implements the WindowController interface to handle window-related actions.
 */
public class WindowEventHandler implements WindowController {

    private final List<Frame> openWindows = new ArrayList<>();

    /**
     * WindowListener that listens for window close events.
     * When a window is closed, it removes the window from the list of open windows.
     * If there are no more open windows, it exits the application.
     */
    private final WindowListener windowListener = new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            openWindows.remove(e.getSource());
            if (openWindows.isEmpty()) {
                System.exit(0);
            }
        }
    };

    /**
     * Returns the WindowListener that handles window events.
     * This listener is used to register with each window to monitor close events.
     * @param obj the object for which the listener is requested
     */
    @Override
    public void addWindowListener(Object obj) {
        if (obj instanceof Frame frame) {
            registerWindow(frame);
        }
    }

    /**
     * Registers a window to be monitored for close events.
     * If the window is not already registered, it adds the window to the list
     * and attaches the window listener to it.
     *
     * @param frame the Frame instance to register
     */
    public void registerWindow(Frame frame) {
        if (!openWindows.contains(frame)) {
            openWindows.add(frame);
            frame.addWindowListener(windowListener);
        }
    }
}
