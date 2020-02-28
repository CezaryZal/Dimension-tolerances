package com.CezaryZal.api.model;

public class ParsedInputDimension {

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;

    public ParsedInputDimension(int valueOfDimension, char symbolFromInput, int valueITFromInput) {
        this.valueOfDimension = valueOfDimension;
        this.symbolFromInput = symbolFromInput;
        this.valueITFromInput = valueITFromInput;
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

    @Override
    public String toString() {
        return "ParsedInputDimension{" +
                "valueOfDimension=" + valueOfDimension +
                ", symbolFromInput=" + symbolFromInput +
                ", valueITFromInput=" + valueITFromInput +
                '}';
    }
}
