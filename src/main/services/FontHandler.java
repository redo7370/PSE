package main.services;

import java.awt.Font;
import java.io.File;

import main.interfaces.FontController;

public final class FontHandler implements FontController {

    /** Default font name */
    private final String DEFAULT_FONT_NAME = "Arial"; 
    
    /** Default font style */
    private final int DEFAULT_FONT_SIZE = 12; 

    /** List of supported fonts */
    private final String[] SUPPORTED_FONTS = {
        "Arial", "Fira Code", "Monospaced"
    }; 
    
    public FontHandler() {
        // Constructor can be used for initialization if needed
    }

    /**
     * Retrieves a Font object based on the specified font name and size.
     * If the font is not available, it returns a default font.
     *
     * @param fontName The name of the font to retrieve.
     * @param size The size of the font.
     * @return A Font object with the specified name and size, or a default font if not available.
     */
    @Override
    public Font getFont(String fontName, int size) {

        String path = "";

        switch (fontName) {
            case "Fira Code" -> {
                path = "res/fonts/FiraCode/FiraCode-Regular.ttf";
            }
            case "SpaceMono" -> {
                path = "res/fonts/SpaceMono/SpaceMono-Regular.ttf";
            }
            default -> {
                path = "res/fonts/Arial/arial.ttf"; // Default to Arial if unsupported
            }
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            return font.deriveFont(size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font(this.DEFAULT_FONT_NAME, Font.PLAIN, (int) this.DEFAULT_FONT_SIZE); // Fallback
        }
    }

    /**
     * Returns an array of supported font names.
     *
     * @return An array of strings representing supported font names.
     */
    @Override
    public String[] getSupportedFonts() {
        return this.SUPPORTED_FONTS;
    }

    /**
     * Returns the default font size.
     *
     * @return An integer representing the default font size.
     */
    @Override
    public int getDefaultFontSize() {
        return this.DEFAULT_FONT_SIZE;
    }

    /**
     * Returns the default font name.
     *
     * @return A string representing the default font name.
     */
    @Override
    public String getDefaultFontName() {
        return this.DEFAULT_FONT_NAME;
    }
}
