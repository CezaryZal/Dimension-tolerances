package com.CezaryZal.api.model;

public class ParsedInputDimension {

    private int valueOfDimension;
    private char symbol;
    private int valueOfIt;
    private boolean isSymbolOverH;

    public ParsedInputDimension(
            int valueOfDimension,
            char symbol,
            int valueOfIt,
            boolean isSymbolOverH) {
        this.valueOfDimension = valueOfDimension;
        this.symbol = symbol;
        this.valueOfIt = valueOfIt;
        this.isSymbolOverH = isSymbolOverH;
    }

    public int getValueOfDimension() {
        return valueOfDimension;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getValueOfIt() {
        return valueOfIt;
    }

    public boolean isSymbolOverH() {
        return isSymbolOverH;
    }

    @Override
    public String toString() {
        return "ParsedInputDimension{" +
                "valueOfDimension=" + valueOfDimension +
                ", symbol=" + symbol +
                ", valueOfIt=" + valueOfIt +
                ", isSymbolOverH=" + isSymbolOverH +
                '}';
    }
}
