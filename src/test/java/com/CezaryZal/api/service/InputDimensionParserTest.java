package com.CezaryZal.api.service;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.service.validation.InputValidator;
import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InputDimensionParserTest {

    @Spy
    InputValidator inputValidator;

    @InjectMocks
    InputDimensionParser inputDimensionParser;

    @Test
    public void parse_input_dimension_should_throw_invalid_value_of_dimension_exception() {
        Assert.assertThrows(
                InvalidValueOfDimensionException.class, () -> inputDimensionParser.parseInputDimension("0a2"));
        Assert.assertThrows(
                InvalidValueOfDimensionException.class, () -> inputDimensionParser.parseInputDimension("501a2"));
    }

    @Test
    public void parse_input_dimension_should_throw_invalid_symbols_exception() {
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1aa2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1t2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1T2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1b2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1i2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1l2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1o2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1q2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1B2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1I2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1L2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1O2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> inputDimensionParser.parseInputDimension("1Q2"));
    }

    @Test
    public void parse_input_dimension_should_throw_invalid_value_of_IT_exception() {
        Assert.assertThrows(
                InvalidValueOfItException.class, () -> inputDimensionParser.parseInputDimension("1a0"));
        Assert.assertThrows(
                InvalidValueOfItException.class, () -> inputDimensionParser.parseInputDimension("1a19"));
    }

    @Test
    public void parse_input_dimension_should_throw_invalid_input_exception() {
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension(""));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("4%5E5k7"));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("5^1k8"));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("50t8k"));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("50t8k6"));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("58"));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("k8"));
        Assert.assertThrows(
                InvalidInputException.class, () -> inputDimensionParser.parseInputDimension("80G"));
    }

    @SneakyThrows
    @Test
    public void parse_input_dimension_should_not_throw_exceptions() {
        ParsedInputDimension parsedInputDimensionFrom1s7 = inputDimensionParser.parseInputDimension("1s7");
        ParsedInputDimension parsedInputDimensionFrom500s7 = inputDimensionParser.parseInputDimension("500s7");
        ParsedInputDimension parsedInputDimensionFrom50S7 = inputDimensionParser.parseInputDimension("50S7");
        ParsedInputDimension parsedInputDimensionFrom50S1 = inputDimensionParser.parseInputDimension("50S1");
        ParsedInputDimension parsedInputDimensionFrom50S18 = inputDimensionParser.parseInputDimension("50S18");

        ParsedInputDimension expectedParsedInputDimensionFrom1s7 = new ParsedInputDimension(1, 's', 7);
        ParsedInputDimension expectedParsedInputDimensionFrom500s7 = new ParsedInputDimension(500, 's', 7);
        ParsedInputDimension expectedParsedInputDimensionFrom50S7 = new ParsedInputDimension(50, 'S', 7);
        ParsedInputDimension expectedParsedInputDimensionFrom50S1 = new ParsedInputDimension(50, 'S', 1);
        ParsedInputDimension expectedParsedInputDimensionFrom50S18 = new ParsedInputDimension(50, 'S', 18);

        Assert.assertEquals(expectedParsedInputDimensionFrom1s7, parsedInputDimensionFrom1s7);
        Assert.assertEquals(expectedParsedInputDimensionFrom500s7, parsedInputDimensionFrom500s7);
        Assert.assertEquals(expectedParsedInputDimensionFrom50S7, parsedInputDimensionFrom50S7);
        Assert.assertEquals(expectedParsedInputDimensionFrom50S1, parsedInputDimensionFrom50S1);
        Assert.assertEquals(expectedParsedInputDimensionFrom50S18, parsedInputDimensionFrom50S18);
    }
}