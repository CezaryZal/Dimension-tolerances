package com.CezaryZal.api.model;

public class ParsedInputDimension {

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
    private boolean isSymbolOverH;

    public ParsedInputDimension(
            int valueOfDimension,
            char symbolFromInput,
            int valueITFromInput,
            boolean isSymbolOverH) {
        this.valueOfDimension = valueOfDimension;
        this.symbolFromInput = symbolFromInput;
        this.valueITFromInput = valueITFromInput;
        this.isSymbolOverH = isSymbolOverH;
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

    @Override
    public String toString() {
        return "ParsedInputDimension{" +
                "valueOfDimension=" + valueOfDimension +
                ", symbolFromInput=" + symbolFromInput +
                ", valueITFromInput=" + valueITFromInput +
                ", isSymbolOverH=" + isSymbolOverH +
                '}';
    }
}
