package main.interfaces;

import javafx.scene.text.Font;

/** Font controller interface for managing font-related operations
 * This interface defines methods to retrieve fonts, supported font names,
 * default font size, and default font name.
 * Implementations of this interface should provide the actual font retrieval logic.
 */
public interface FontController {

    /**
     * Retrieves a Font object based on the specified font name and size.
     * If the font is not available, it should return a default font.
     * @param fontName
     * @param size
     * @return
     */
    Font getFont(String fontName, int size);

    /**
     * Returns an array of supported font names.
     * @return An array of strings representing supported font names.
     */
    String[] getSupportedFonts();
    
    /**
     * Returns the default font size.
     * @return An integer representing the default font size.
     */
    int getDefaultFontSize();

    /**
     * Returns the default font name.
     * @return A string representing the default font name.
     */
    String getDefaultFontName();
}
