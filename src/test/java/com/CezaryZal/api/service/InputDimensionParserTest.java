package com.CezaryZal.api.service;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.service.validation.InputValidator;
import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class InputDimensionParserTest {

    @Spy
    private InputValidator inputValidator;

    @InjectMocks
    private InputDimensionParser inputDimensionParser;

    @SneakyThrows
    @Test(expected = InvalidValueOfDimensionException.class)
    public void parse_input_dimension_should_throw_invalid_value_of_dimension_exception() {
        inputDimensionParser.parseInputDimension("0a2");
        inputDimensionParser.parseInputDimension("501a2");
    }

    @SneakyThrows
    @Test(expected = InvalidSymbolsException.class)
    public void parse_input_dimension_should_throw_invalid_symbols_exception() {
        inputDimensionParser.parseInputDimension("1aa2");
        inputDimensionParser.parseInputDimension("1aa2");
        inputDimensionParser.parseInputDimension("1t2");
        inputDimensionParser.parseInputDimension("1T2");
        inputDimensionParser.parseInputDimension("1b2");
        inputDimensionParser.parseInputDimension("1i2");
        inputDimensionParser.parseInputDimension("1l2");
        inputDimensionParser.parseInputDimension("1o2");
        inputDimensionParser.parseInputDimension("1q2");
        inputDimensionParser.parseInputDimension("1B2");
        inputDimensionParser.parseInputDimension("1I2");
        inputDimensionParser.parseInputDimension("1L2");
        inputDimensionParser.parseInputDimension("1O2");
        inputDimensionParser.parseInputDimension("1Q2");
    }

    @SneakyThrows
    @Test(expected = InvalidValueOfItException.class)
    public void parse_input_dimension_should_throw_invalid_value_of_IT_exception() {
        inputDimensionParser.parseInputDimension("1a0");
        inputDimensionParser.parseInputDimension("1a19");
    }

    @SneakyThrows
    @Test(expected = InvalidInputException.class)
    public void parse_input_dimension_should_throw_invalid_input_exception() {
        inputDimensionParser.parseInputDimension("");
        inputDimensionParser.parseInputDimension("4%5E5k7");
        inputDimensionParser.parseInputDimension("5^1k8");
        inputDimensionParser.parseInputDimension("50t8k");
        inputDimensionParser.parseInputDimension("50t8k6");
        inputDimensionParser.parseInputDimension("58");
        inputDimensionParser.parseInputDimension("k8");
        inputDimensionParser.parseInputDimension("80G");
    }

    @SneakyThrows
    @Test
    public void parse_input_dimension_should_not_throw_exceptions() {
        String dimension1M7 = "1M7";
        String dimension500m5 = "500m5";
        String dimension55a3 = "55a3";
        String dimension72s4 = "72s4";
        String dimension8A2 = "8A2";
        String dimension43S4 = "43S4";
        String dimension22n1 = "22n1";
        String dimension89K18 = "89K18";

        ParsedInputDimension parsedInputDimensionFrom1M7 = inputDimensionParser.parseInputDimension(dimension1M7);
        ParsedInputDimension parsedInputDimensionFrom500m5 = inputDimensionParser.parseInputDimension(dimension500m5);
        ParsedInputDimension parsedInputDimensionFrom55a3 = inputDimensionParser.parseInputDimension(dimension55a3);
        ParsedInputDimension parsedInputDimensionFrom72s4 = inputDimensionParser.parseInputDimension(dimension72s4);
        ParsedInputDimension parsedInputDimensionFrom8A2 = inputDimensionParser.parseInputDimension(dimension8A2);
        ParsedInputDimension parsedInputDimensionFrom43S4 = inputDimensionParser.parseInputDimension(dimension43S4);
        ParsedInputDimension parsedInputDimensionFrom22n1 = inputDimensionParser.parseInputDimension(dimension22n1);
        ParsedInputDimension parsedInputDimensionFrom89K18 = inputDimensionParser.parseInputDimension(dimension89K18);

        ParsedInputDimension expectedParsedInputDimensionFrom1M7 = new ParsedInputDimension(1, 'M', 7);
        ParsedInputDimension expectedParsedInputDimensionFrom500m5 = new ParsedInputDimension(500, 'm', 5);
        ParsedInputDimension expectedParsedInputDimensionFrom55a3 = new ParsedInputDimension(55, 'a', 3);
        ParsedInputDimension expectedParsedInputDimensionFrom72s4 = new ParsedInputDimension(72, 's', 4);
        ParsedInputDimension expectedParsedInputDimensionFrom8A2 = new ParsedInputDimension(8, 'A', 2);
        ParsedInputDimension expectedParsedInputDimensionFrom43S4 = new ParsedInputDimension(43, 'S', 4);
        ParsedInputDimension expectedParsedInputDimensionFrom22n1 = new ParsedInputDimension(22, 'n', 1);
        ParsedInputDimension expectedParsedInputDimensionFrom89K18 = new ParsedInputDimension(89, 'K', 18);

        then(parsedInputDimensionFrom1M7)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension1M7)
                .isEqualTo(expectedParsedInputDimensionFrom1M7);
        then(parsedInputDimensionFrom500m5)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension500m5)
                .isEqualTo(expectedParsedInputDimensionFrom500m5);
        then(parsedInputDimensionFrom55a3)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension55a3)
                .isEqualTo(expectedParsedInputDimensionFrom55a3);
        then(parsedInputDimensionFrom72s4)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension72s4)
                .isEqualTo(expectedParsedInputDimensionFrom72s4);
        then(parsedInputDimensionFrom8A2)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension8A2)
                .isEqualTo(expectedParsedInputDimensionFrom8A2);
        then(parsedInputDimensionFrom43S4)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension43S4)
                .isEqualTo(expectedParsedInputDimensionFrom43S4);
        then(parsedInputDimensionFrom22n1)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension22n1)
                .isEqualTo(expectedParsedInputDimensionFrom22n1);
        then(parsedInputDimensionFrom89K18)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension89K18)
                .isEqualTo(expectedParsedInputDimensionFrom89K18);
    }
}