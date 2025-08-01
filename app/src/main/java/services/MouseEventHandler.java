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

package services;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import data.ChemicalElement;
import data.Elements;
import interfaces.AdjustableElementWindow;
import interfaces.AdjustableMenuWindow;
import interfaces.MouseController;
import ui.ElementWindow;
import ui.MenuWindow;
import ui.PSE;
import start.App;

/**
 * MouseEventHandler is a service class that implements MouseController to handle mouse events
 * for the application. It listens for mouse clicks on elements in the periodic table and opens
 * corresponding ElementWindows or MenuWindows based on the clicked element.
 */
public class MouseEventHandler implements MouseController {

    /**
     * The main application instance that this handler is associated with.
     * It is used to access application-wide services and functionalities.
     */
    private final App app;

    /**
     * Constructor for MouseEventHandler.
     * Initializes the handler with the main application instance.
     *
     * @param app The main application instance.
     */
    public MouseEventHandler(App app) {
        this.app = app;
    }
    
    /**
     * MouseListener that handles mouse click events on windows.
     * It opens an ElementWindow for the clicked element or a MenuWindow if the menu button is clicked.
     * It also allows double-clicking on PSE or ElementWindow to resize them to their standard dimensions.
     */
    private final MouseListener elementClickListener = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

            Object source = e.getSource();
            int clickCount = e.getClickCount();
            boolean isLeftMouseButton = SwingUtilities.isLeftMouseButton(e);

            switch (source) {

                case PSE pseFrame -> {
                    if (clickCount == 2 && isLeftMouseButton 
                            && !pseFrame.getSize().equals(pseFrame.getTrueDimension())) {
                        pseFrame.setSize(pseFrame.getTrueDimension());
                        pseFrame.setLocationRelativeTo(null);
                    }
                    return;
                }  

                case ElementWindow ewFrame -> {
                    if (clickCount == 2 && isLeftMouseButton 
                            && !ewFrame.getSize().equals(ewFrame.getTrueDimension())) {
                        ewFrame.setSize(ewFrame.getTrueDimension());
                        ewFrame.setLocationRelativeTo(null);
                    }
                    return;
                }

                case JButton button -> {
                        for (Frame frame : Frame.getFrames()) {
                            if (frame instanceof AdjustableMenuWindow mw && frame.isDisplayable()) {
                                ((JFrame) mw).toFront();
                                ((JFrame) mw).requestFocus();
                                ((JFrame) mw).setState(Frame.NORMAL);
                                return;
                            }
                        }
                        AdjustableMenuWindow mw = new MenuWindow();
                        app.getMouseListener().registerWindow((JFrame) mw);
                        app.getWindowListener().registerWindow((JFrame) mw);
                        ((JFrame) mw).requestFocus();
                        ((JFrame) mw).setState(Frame.NORMAL);
                        return;
                }

                case JLabel label -> {
                    // Do nothing for JLabel, handled below
                    break;
                }

                default -> {
                    // Do nothing for other sources
                    return;
                }
            }
            
            // Nur Labels behandeln
            if (!(source instanceof JLabel label)) {
                return;
            }

            String symbol = label.getName();  // Symbol wurde vorher per setName() gesetzt

            if (symbol == null || symbol.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bitte ein Element wählen.");
                return;
            }

            ChemicalElement element = Elements.getElement(symbol);

            if (element == null) {
                JOptionPane.showMessageDialog(null, "Element nicht gefunden: " + symbol);
                return;
            }

            byte targetAtomicNumber = element.getAtomicNumber();

            // Fenster prüfen
            for (Frame frame : Frame.getFrames()) {
                if (frame instanceof ElementWindow ew && frame.isDisplayable()) {
                    if (ew.getElementNum() == targetAtomicNumber) {
                        frame.toFront();
                        frame.requestFocus();
                        frame.setState(Frame.NORMAL);
                        return;
                    }
                }
            }

            AdjustableElementWindow ew = new ElementWindow(element);
            ((JFrame)ew).requestFocus();
            ((JFrame)ew).setState(Frame.NORMAL);
            app.getMouseListener().registerWindow((JFrame)ew);
            app.getWindowListener().registerWindow((JFrame)ew);
        }
    };

    /**
     * Returns the MouseListener that handles mouse events for elements.
     * This listener can be registered with any component that needs to respond to mouse clicks.
     *
     * @return The MouseListener instance for handling element clicks.
     */
    public MouseListener getMouseListener()  {
        return this.elementClickListener;
    }

    /**
     * Registers a window to listen for mouse events.
     * This method adds the elementClickListener to the specified Frame,
     * allowing it to respond to mouse clicks on that window.
     *
     * @param frame The Frame instance to register for mouse events.
     */
    public void registerWindow(Frame frame) {
        frame.addMouseListener(elementClickListener);
    }
}