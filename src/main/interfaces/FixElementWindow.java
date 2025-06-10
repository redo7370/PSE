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