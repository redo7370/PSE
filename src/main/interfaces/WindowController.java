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

import javax.swing.JFrame;

/**
 * WindowController is an interface that defines methods for managing window events
 * in the application. It provides a way to add window listeners and register windows
 * to monitor their close events.
 */
public interface WindowController {

    /**
     * Adds a window listener to the specified object.
     * This method is used to register a window to listen for close events.
     *
     * @param obj The object for which the window listener is requested.
     */
    void addWindowListener(Object obj);

    /**
     * Registers a window to be monitored for close events.
     * This method adds the window to the list of open windows and attaches
     * a window listener to it. ElementWindows are excluded from being registered.
     *
     * @param frame The Frame instance to register.
     */
    void registerWindow(JFrame frame);

    void unregisterWindow(JFrame frame);
}