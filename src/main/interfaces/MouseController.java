package main.interfaces;

import java.awt.event.MouseListener;
import java.awt.Frame;

/**
 * MouseController is an interface that defines methods for handling mouse events
 * in the application. It provides a way to retrieve a MouseListener and register
 * windows to listen for mouse events.
 */
public interface MouseController {

    /**
     * Returns a MouseListener that handles mouse events for the application.
     * This listener can be used to register with components that need to respond
     * to mouse clicks or movements.
     *
     * @return A MouseListener instance that handles mouse events.
     */
    MouseListener getMouseListener();

    /**
     * Registers a window to listen for mouse events.
     * This method adds the MouseListener to the specified Frame,
     * allowing it to respond to mouse clicks on that window.
     *
     * @param frame The Frame instance to register for mouse events.
     */
    void registerWindow(Frame frame);
} 
