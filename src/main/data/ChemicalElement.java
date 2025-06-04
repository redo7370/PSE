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

import java.util.Map;

/**
 * Elements class contains static instances of ChemicalElement representing
 * the first 20 elements of the periodic table, along with their properties.
 * This class is designed
 */

public class ChemicalElement {

    /**
     * Represents a chemical element with its properties.
     * Each element has an atomic number, symbol, names in different languages,
     * atomic weight, electronegativity, electron configuration, melting and boiling points,
     * oxidation numbers, standard electrode potential, and group information.
     */
    private final byte atomicNumber;
    private final String symbol;
    private final Map<String, String> names;
    private final double atomicWeight;
    private final double electronegativity;
    private final String electronConfig;
    private final int meltingPoint;
    private final int boilingPoint;
    private final byte[] oxidationNums;
    private final double standardElectrodePotential;
    private final Map<String, String> group;

    /**
     * Constructor for ChemicalElement.
     * Initializes the properties of the chemical element.
     *
     * @param atomicNumber Atomic number of the element.
     * @param symbol Symbol of the element.
     * @param names Map containing names of the element in different languages.
     * @param atomicWeight Atomic weight of the element.
     * @param electronegativity Electronegativity value of the element.
     * @param electronConfig Electron configuration string of the element.
     * @param meltingPoint Melting point in Kelvin.
     * @param boilingPoint Boiling point in Kelvin.
     * @param oxidationNums Array of oxidation numbers for the element.
     * @param standardElectrodePotential Standard electrode potential in volts.
     * @param group Map containing group information of the element.
     */
    public ChemicalElement(
        byte atomicNumber, 
        String symbol,
        Map<String, String> names,
        double atomicWeight,
        double electronegativity,
        String electronConfig,
        int meltingPoint,
        int boilingPoint,
        byte[] oxidationNums,
        double standardElectrodePotential,
        Map<String, String> group
        ) {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.names = names;
        this.atomicWeight = atomicWeight;
        this.electronegativity = electronegativity;
        this.electronConfig = electronConfig;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.oxidationNums = oxidationNums;
        this.standardElectrodePotential = standardElectrodePotential;
        this.group = group;
    }

    /**
     * Getters for the properties of the chemical element.
     * 
     * @return The atomic number of the element.
     */
    public byte getAtomicNumber(){
        return this.atomicNumber;
    }

    /**
     * Returns the symbol of the chemical element.
     *
     * @return The symbol of the element.
     */
    public String getSymbol(){
        return this.symbol;
    }

    /**
     * Returns a map of names for the chemical element in different languages.
     *
     * @return A map where keys are language codes and values are element names.
     */
    public Map<String, String> getNames(){
       return this.names;
    }

    /**
     * Returns the atomic weight of the chemical element.
     *
     * @return The atomic weight as a double.
     */
    public double getAtomicWeight(){
        return this.atomicWeight;
    }

    /**
     * Returns the electronegativity of the chemical element.
     *
     * @return The electronegativity as a double.
     */
    public double getElectronegativity(){
        return this.electronegativity;
    }

    /**
     * Returns the electron configuration of the chemical element.
     *
     * @return The electron configuration as a string.
     */
    public String getElectronConfiguration(){
        return this.electronConfig;
    }

    /**
     * Returns the melting point of the chemical element.
     *
     * @return The melting point in Kelvin as an integer.
     */
    public int getMeltingPoint(){
        return this.meltingPoint;
    }

    /**
     * Returns the boiling point of the chemical element.
     *
     * @return The boiling point in Kelvin as an integer.
     */
    public int getBoilingPoint(){
        return this.boilingPoint;
    }

    /**
     * Returns the oxidation numbers of the chemical element.
     *
     * @return An array of bytes representing the oxidation numbers.
     */
    public byte[] getOxidationNumbers(){
        return this.oxidationNums;
    }

    /**
     * Returns the standard electrode potential of the chemical element.
     *
     * @return The standard electrode potential in volts as a double.
     */
    public double getStandardPotential(){
        return this.standardElectrodePotential;
    }

    /**
     * Returns a map containing additional group information about the chemical element.
     *
     * @return A map where keys are group names and values are their descriptions.
     */
    public Map<String, String> isExtra(){
        return this.group;
    }
}