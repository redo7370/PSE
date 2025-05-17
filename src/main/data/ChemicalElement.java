package main.data;

import java.util.Map;

public class ChemicalElement {
    private final int atomicNumber;
    private final String symbol;
    private final Map<String, String> names;
    private final double atomicWeight;
    private final double electronegativity;
    private final String electronConfig;
    private final int meltingPoint;
    private final int boilingPoint;
    private final int[] oxidationNums;
    private final double standardElectrodePotential;
    private final Map<String, String> group;

    public ChemicalElement(
        int num, 
        String letter,
        Map<String, String> elementNames,
        double weight,
        double negativity,
        String eConfig,
        int melt,
        int boil,
        int[] oxidation,
        double electrodePotential,
        Map<String, String> type
        ) {
        this.atomicNumber = num;
        this.symbol = letter;
        this.names = elementNames;
        this.atomicWeight = weight;
        this.electronegativity = negativity;
        this.electronConfig = eConfig;
        this.meltingPoint = melt;
        this.boilingPoint = boil;
        this.oxidationNums = oxidation;
        this.standardElectrodePotential = electrodePotential;
        this.group = type;
    }

    public int getAtomicNumber(){
        return this.atomicNumber;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public Map<String, String> getNames(){
       return this.names;
    }

    public double getAtomicWeight(){
        return this.atomicWeight;
    }

    public double getElectronegativity(){
        return this.electronegativity;
    }

    public String getElectronConfiguration(){
        return this.electronConfig;
    }

    public int getMeltingPoint(){
        return this.meltingPoint;
    }

    public int getBoilingPoint(){
        return this.boilingPoint;
    }

    public int[] getOxidationNumbers(){
        return this.oxidationNums;
    }

    public double getStandardPotential(){
        return this.standardElectrodePotential;
    }

    public Map<String, String> isExtra(){
        return this.group;
    }
}