package com.CezaryZal.api.model;

public class ParsedInputDimension {

    private int valueOfDimension;
    private char symbol;
    private int valueOfIT;
    private boolean isSymbolOverH;

    public ParsedInputDimension(
            int valueOfDimension,
            char symbol,
            int valueOfIT,
            boolean isSymbolOverH) {
        this.valueOfDimension = valueOfDimension;
        this.symbol = symbol;
        this.valueOfIT = valueOfIT;
        this.isSymbolOverH = isSymbolOverH;
    }

    public int getValueOfDimension() {
        return valueOfDimension;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getValueOfIT() {
        return valueOfIT;
    }

    public boolean isSymbolOverH() {
        return isSymbolOverH;
    }

    @Override
    public String toString() {
        return "ParsedInputDimension{" +
                "valueOfDimension=" + valueOfDimension +
                ", symbol=" + symbol +
                ", valueOfIT=" + valueOfIT +
                ", isSymbolOverH=" + isSymbolOverH +
                '}';
    }
}
