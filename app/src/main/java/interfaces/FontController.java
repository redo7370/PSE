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

package interfaces;

import java.awt.Font;

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