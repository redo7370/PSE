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
        int atomicNumber, 
        String symbol,
        Map<String, String> names,
        double atomicWeight,
        double electronegativity,
        String electronConfig,
        int meltingPoint,
        int boilingPoint,
        int[] oxidationNums,
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