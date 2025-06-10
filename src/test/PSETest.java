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

package test;

import main.data.PeriodicTable;

import static org.junit.Assert.*;
import org.junit.Test;
import javafx.scene.paint.Color;

// Nur AssertEquals wird im Bash Skript berücksichtigt

public class PSETest {

    @Test
    public void testGetElementColor() {
        Color color = PeriodicTable.getElementColor("Mg");
        assertArrayEquals(new int[] {152, 173, 121}, new int[] { (int)(color.getRed() * 255), (int)(color.getGreen() * 255), (int)(color.getBlue() * 255) });
    }

}