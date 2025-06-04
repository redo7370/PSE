package main.interfaces;

import java.awt.event.MouseListener;
import java.awt.Frame;

/**
 * MouseController is an interface that defines methods for handling mouse events
 * in the application. It provides a way to retrieve a MouseListener and register
 * windows to listen for mouse events.
 */
public interface MouseController {
    MouseListener getMouseListener();
    void registerWindow(Frame frame);
} 
