package com.CezaryZal.api.model;

public class ParsedInputDimension {

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
    private boolean isSymbolOverH;
    private boolean isSymbolBetweenHAndP;
    private boolean isForShaft;

    public ParsedInputDimension(
            int valueOfDimension,
            char symbolFromInput,
            int valueITFromInput,
            boolean isSymbolOverH,
            boolean isSymbolBetweenHAndP,
            boolean isForShaft) {
        this.valueOfDimension = valueOfDimension;
        this.symbolFromInput = symbolFromInput;
        this.valueITFromInput = valueITFromInput;
        this.isSymbolOverH = isSymbolOverH;
        this.isSymbolBetweenHAndP = isSymbolBetweenHAndP;
        this.isForShaft = isForShaft;
    }

    public int getValueOfDimension() {
        return valueOfDimension;
    }

    public char getSymbolFromInput() {
        return symbolFromInput;
    }

    public int getValueITFromInput() {
        return valueITFromInput;
    }

    public boolean isSymbolOverH() {
        return isSymbolOverH;
    }

    public boolean isSymbolBetweenHAndP() {
        return isSymbolBetweenHAndP;
    }

    public boolean isForShaft() {
        return isForShaft;
    }

    @Override
    public String toString() {
        return "ParsedInputDimension{" +
                "valueOfDimension=" + valueOfDimension +
                ", symbolFromInput=" + symbolFromInput +
                ", valueITFromInput=" + valueITFromInput +
                ", isSymbolOverH=" + isSymbolOverH +
                ", isSymbolBetweenHAndP=" + isSymbolBetweenHAndP +
                ", isForShaft=" + isForShaft +
                '}';
    }
}
