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

package main.data;

import java.awt.Color;

/**
 * PeriodicTable is a utility class that provides methods to retrieve information
 * about the periodic table of elements, including element colors and their arrangement.
 * It contains a static method to get the color associated with each element based on its type,
 * and a method to retrieve the 2D array representation of the periodic table.
 */
public class PeriodicTable {
    
    /**
     * The main background color used in the periodic table UI.
     * This color is applied to elements that do not have a specific chemical symbol.
     */
    private static final Color MAIN_BG = new Color(64, 63, 60);
    
    /**
     * A 2D array representing the periodic table of elements.
     * Each row corresponds to a period, and each column corresponds to a group.
     * The elements are represented by their chemical symbols.
     * Empty strings represent unoccupied positions in the table.
     */
    private static final String[][] ELEMENTS = {
        {"H", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "He"},
        {"Li", "Be", "", "", "", "", "", "", "", "", "", "", "B", "C", "N", "O", "F", "Ne"},
        {"Na", "Mg", "", "", "", "", "", "", "", "", "", "", "Al", "Si", "P", "S", "Cl", "Ar"},
        {"K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr"},
        {"Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe"},
        {"Cs", "Ba", "La", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn"},
        {"Fr", "Ra", "Ac", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"}
    };

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private PeriodicTable() {
    }

    /**
     * Returns the color associated with a given chemical element.
     * The color is determined based on the type of element (e.g., nonmetals, metals, etc.).
     *
     * @param element The symbol of the chemical element (e.g., "H", "O", "Fe").
     * @return The Color object representing the element's color.
     */
    public static Color getElementColor(String element) {

        // default
        if (" ".contains(element)){
            return MAIN_BG;
        }

        // Nichtmetalle (Rot)
        for (String elem: new String[] {"H", "C", "N", "O", "P", "S", "Se"}) {
            if (element.equals(elem)){
                return new Color(225, 130, 135);      
            }
        }
        // Alkaliemetalle (Grün)
        for (String elem: new String[] {"Li", "Na", "K", "Rb", "Cs", "Fr"}) {
            if (element.equals(elem)){
                return new Color(183, 206, 143);     
            }
        }
        // Erdalkalimetalle (Dunkelgrün)
        for (String elem: new String[] {"Be", "Mg", "Ca", "Sr", "Ba", "Ra"}) {
            if (element.equals(elem)){
                return new Color(152, 173, 121);     
            }
        }
        // Übergangsmetalle (Blau)
        for (String elem: new String[] {"Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "La", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ac", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn"}) {
            if (element.equals(elem)){
                return new Color(122, 149, 179);    
            }
        }
        // Andere Metalle (Lila)
        for (String elem: new String[] {"B", "Si", "Ge", "As", "Sb", "Te", "Po"}) {
            if (element.equals(elem)){
                return new Color(194, 156, 178);    
            }
        }
        // Halbmetalle (hell Lila)
        for (String elem: new String[] {"Al", "Ga", "In", "Sn", "Tl", "Pb", "Bi", "Nh", "Fl", "Mc", "Lv"}) {
            if (element.equals(elem)){
                return new Color(164, 131, 166);   
            }
        }
        // Halogene (orange/beige)
        for (String elem: new String[] {"F", "Cl", "Br", "I", "At", "Ts"}) {
            if (element.equals(elem)){
                return new Color(233, 165, 153);   
            }
        }
        // Edelgase (Gelb/Beige)
        for (String elem: new String[] {"He", "Ne", "Ar", "Kr", "Xe", "Rn", "Og"}) {
            if (element.equals(elem)){
                return new Color(241, 197, 169);  
            }
        }
        
        return MAIN_BG; 
    }

    /**
     * Returns a 2D array representing the periodic table of elements.
     * Each row corresponds to a period, and each column corresponds to a group.
     *
     * @return A 2D array of strings representing the periodic table.
     */
    public static String[][] getElementTable() {
        return ELEMENTS;
    }

    /**
     * Returns the main background color used in the periodic table UI.
     *
     * @return The Color object representing the main background color.
     */
    public static Color getMAINBG() {
        return MAIN_BG;
    }
}
