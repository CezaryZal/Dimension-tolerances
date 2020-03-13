package com.CezaryZal.api.model;

import java.util.Objects;

public class ParsedInputDimension {

    private int valueOfDimension;
    private char symbol;
    private int valueOfIt;
    private boolean isSymbolOverH;

    public ParsedInputDimension(int valueOfDimension, char symbol, int valueOfIt) {
        this.valueOfDimension = valueOfDimension;
        this.symbol = symbol;
        this.valueOfIt = valueOfIt;
        this.isSymbolOverH = Character.toLowerCase(symbol) > 'h';
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParsedInputDimension)) return false;
        ParsedInputDimension that = (ParsedInputDimension) o;
        return valueOfDimension == that.valueOfDimension &&
                symbol == that.symbol &&
                valueOfIt == that.valueOfIt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueOfDimension, symbol, valueOfIt);
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
