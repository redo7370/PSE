package main.interfaces;

import java.awt.Frame;

/**
 * WindowController is an interface that defines methods for managing window events
 * in the application. It provides a way to add window listeners and register windows
 * to monitor their close events.
 */
public interface WindowController {
    void addWindowListener(Object obj);
    void registerWindow(Frame frame);
}
