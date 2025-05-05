package main.data;

public class ChemicalElement {
    private final int atomicNumber;
    private final String symbol;
    private final String[] names;
    private final double atomicWeight;
    private final double electronegativity;
    private final String electronConfig;
    private final int meltingPoint;
    private final int boilingPoint;
    private final int[] oxidationNums;
    private final double standardElectrodePotential;
    private final boolean extra;

    private final int EXITNUM = -1000;

    public ChemicalElement(int num, String letter, String[] elementNames, double weight, double negativity, String eConfig, int melt, int boil, int[] oxidation, double electrodePotential){
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
        this.extra = false;
    }
    public ChemicalElement(int num, String letter, String[] elementNames, double weight, String eConfig, int melt, int boil, int[] oxidation, double electrodePotential){
        this.atomicNumber = num;
        this.symbol = letter;
        this.names = elementNames;
        this.atomicWeight = weight;
        this.electronegativity = EXITNUM;
        this.electronConfig = eConfig;
        this.meltingPoint = melt;
        this.boilingPoint = boil;
        this.oxidationNums = oxidation;
        this.standardElectrodePotential = electrodePotential;
        this.extra = false;
    }

    public ChemicalElement(int num, String letter, String[] elementNames, double weight, String eConfig, int melt, int boil){
        this.atomicNumber = num;
        this.symbol = letter;
        this.names = elementNames;
        this.atomicWeight = weight;
        this.electronegativity = -1000;
        this.electronConfig = eConfig;
        this.meltingPoint = melt;
        this.boilingPoint = boil;
        this.oxidationNums = new int[] {EXITNUM};
        this.standardElectrodePotential = EXITNUM;
        this.extra = false;
    }

    public ChemicalElement(int num, String letter, String[] elementNames, double weight, double negativity, String eConfig, int melt, int boil, int[] oxidation, double electrodePotential, boolean xtra){
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
        this.extra = xtra;
    }

    public ChemicalElement(int num, String letter, String[] elementNames, double weight, double negativity, String eConfig, int[] oxidation, double electrodePotential, boolean xtra){
        this.atomicNumber = num;
        this.symbol = letter;
        this.names = elementNames;
        this.atomicWeight = weight;
        this.electronegativity = negativity;
        this.electronConfig = eConfig;
        this.meltingPoint = EXITNUM;
        this.boilingPoint = EXITNUM;
        this.oxidationNums = oxidation;
        this.standardElectrodePotential = electrodePotential;
        this.extra = xtra;
    }

    public int getAtomicNumber(){
        return this.atomicNumber;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String[] getName(){
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

    public boolean isExtra(){
        return this.extra;
    }
}