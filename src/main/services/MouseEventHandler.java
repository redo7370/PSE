package main.services;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import main.data.ChemicalElement;
import main.data.Elements;
import main.data.PeriodicTable;
import main.interfaces.MouseController;
import main.ui.ElementWindow;
import main.ui.MenuWindow;
import main.ui.PSE;
import main.App;

/**
 * MouseEventHandler is a service class that implements MouseController to handle mouse events
 * for the application. It listens for mouse clicks on elements in the periodic table and opens
 * corresponding ElementWindows or MenuWindows based on the clicked element.
 */
public class MouseEventHandler implements MouseController {

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

            // Falls das Event vom PSE Fenster kommt (nicht Label oder Button)
            if (e.getSource() instanceof PSE pseFrame) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e) 
                        && !pseFrame.getSize().equals(pseFrame.getTrueDimension())) {
                    pseFrame.setSize(pseFrame.getTrueDimension());
                    pseFrame.setLocationRelativeTo(null);
                }
                return;
            } else if (e.getSource() instanceof ElementWindow ewFrame) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e) 
                        && !ewFrame.getSize().equals(ewFrame.getTrueDimension())) {
                    ewFrame.setSize(ewFrame.getTrueDimension());
                    ewFrame.setLocationRelativeTo(null);
                }
            }

            // Menübutton-Klick
            if (e.getSource() instanceof JButton button && "Menü".equals(button.getText())) {
                for (Frame frame : Frame.getFrames()) {
                    if (frame instanceof main.ui.MenuWindow mw && frame.isDisplayable()) {
                        mw.toFront();
                        mw.requestFocus();
                        mw.setState(Frame.NORMAL);
                        return;
                    }
                }
                new MenuWindow(PeriodicTable.getMAINBG());
                return;
            }

            // Nur Labels behandeln
            if (!(e.getSource() instanceof JLabel label)) {
                return;
            }

            String symbol = label.getName();  // Symbol wurde vorher per setName() gesetzt

            if (symbol == null || symbol.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bitte ein Element eingeben.");
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

            ElementWindow ew = new ElementWindow(element);
            app.getMouseListener().registerWindow(ew);
            app.getWindowListener().registerWindow(ew);
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
