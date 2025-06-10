package main.services;

import javafx.scene.text.Font;
import main.interfaces.FontController;

import java.io.InputStream;

public final class FontHandler implements FontController {

    /** Default font name */
    private final String DEFAULT_FONT_NAME = "Arial";

    /** Default font size */
    private final int DEFAULT_FONT_SIZE = 12;

    /** List of supported fonts */
    private final String[] SUPPORTED_FONTS = {
        "Arial", "Fira Code", "Monospaced"
    };

    public FontHandler() {
        // Konstruktor falls später Initialisierung benötigt wird
    }

    /**
     * Lädt eine JavaFX Font aus den Ressourcen oder verwendet eine Standardschrift.
     *
     * @param fontName Name der Schriftart
     * @param size     Größe der Schriftart
     * @return JavaFX Font-Objekt
     */
    @Override
    public Font getFont(String fontName, int size) {
        String path = null;

        switch (fontName) {
            case "Fira Code" -> path = "/res/fonts/FiraCode/FiraCode-Regular.ttf";
            case "SpaceMono" -> path = "/res/fonts/SpaceMono/SpaceMono-Regular.ttf";
            case "Monospaced" -> {
                // Hier kannst du optional einen Pfad für Monospaced-Schriftart definieren
                path = null;
            }
            case "Arial" -> {
                // Arial ist meist systemseitig verfügbar, kein Pfad nötig
                path = null;
            }
            default -> path = null;
        }

        try {
            if (path != null) {
                InputStream fontStream = getClass().getResourceAsStream(path);
                if (fontStream != null) {
                    return Font.loadFont(fontStream, size);
                }
            }
            // Fallback: Systemschriftart
            return Font.font(fontName != null ? fontName : DEFAULT_FONT_NAME, size > 0 ? size : DEFAULT_FONT_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
            return Font.font(DEFAULT_FONT_NAME, DEFAULT_FONT_SIZE);
        }
    }

    @Override
    public String[] getSupportedFonts() {
        return this.SUPPORTED_FONTS;
    }

    @Override
    public int getDefaultFontSize() {
        return this.DEFAULT_FONT_SIZE;
    }

    @Override
    public String getDefaultFontName() {
        return this.DEFAULT_FONT_NAME;
    }
}
