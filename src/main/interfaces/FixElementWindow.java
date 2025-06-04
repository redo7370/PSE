package main.interfaces;

/**
 * FixElementWindow is an interface that represents a window displaying information
 * about a specific chemical element in the periodic table.
 * It provides a method to retrieve the element number associated with the window.
 * This interface is used to ensure that all element windows implement a consistent
 * method for accessing the element number.
 */
public interface FixElementWindow {

    /**
     * Retrieves the atomic number of the element displayed in this window.
     * The atomic number is a byte value representing the unique identifier for the element.
     *
     * @return The atomic number of the element as a byte.
     */
    byte getElementNum();
}
