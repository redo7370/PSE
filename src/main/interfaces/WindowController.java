package main.interfaces;

import java.awt.Frame;

/**
 * WindowController is an interface that defines methods for managing window events
 * in the application. It provides a way to add window listeners and register windows
 * to monitor their close events.
 */
public interface WindowController {

    /**
     * Adds a window listener to the specified object.
     * This method is used to register a window to listen for close events.
     *
     * @param obj The object for which the window listener is requested.
     */
    void addWindowListener(Object obj);

    /**
     * Registers a window to be monitored for close events.
     * This method adds the window to the list of open windows and attaches
     * a window listener to it. ElementWindows are excluded from being registered.
     *
     * @param frame The Frame instance to register.
     */
    void registerWindow(Frame frame);
}
