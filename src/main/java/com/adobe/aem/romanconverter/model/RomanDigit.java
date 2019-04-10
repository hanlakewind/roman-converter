package com.adobe.aem.romanconverter.model;

import com.google.common.collect.ImmutableList;
import lombok.Data;

import java.util.List;

/**
 * A model represents a single digit of roman numeral.
 */
@Data
public class RomanDigit {

    /**
     * The roman numeral symbol as a String.
     */
    private final String romanSymbol;

    /**
     * The number of over lines above the symbol to represent Vinculum for numbers above 3999.
     */
    private final int overLineCount;

    /**
     * The decimal value of the roman digit.
     */
    private final int decimalNumber;

    /**
     * A static immutable list of RomanDigit that is sorted by the value in descending order.
     * This list only contains necessary digits for values between 1 and 10000000.
     */
    public static final List<RomanDigit> ROMAN_DIGIT_LIST = ImmutableList.of(
            new RomanDigit("X", 2, 10000000),
            new RomanDigit("IX", 2, 9000000),
            new RomanDigit("V", 2, 5000000),
            new RomanDigit("IV", 2, 4000000),
            new RomanDigit("M", 1, 1000000),
            new RomanDigit("CM", 1, 900000),
            new RomanDigit("D", 1, 500000),
            new RomanDigit("CD", 1, 400000),
            new RomanDigit("C", 1, 100000),
            new RomanDigit("XC", 1, 90000),
            new RomanDigit("L", 1, 50000),
            new RomanDigit("XL", 1, 40000),
            new RomanDigit("X", 1, 10000),
            new RomanDigit("IX", 1, 9000),
            new RomanDigit("V", 1, 5000),
            new RomanDigit("IV", 1, 4000),
            new RomanDigit("M", 0, 1000),
            new RomanDigit("CM", 0, 900),
            new RomanDigit("D", 0, 500),
            new RomanDigit("CD", 0, 400),
            new RomanDigit("C", 0, 100),
            new RomanDigit("XC", 0, 90),
            new RomanDigit("L", 0, 50),
            new RomanDigit("XL", 0, 40),
            new RomanDigit("X", 0, 10),
            new RomanDigit("IX", 0, 9),
            new RomanDigit("V", 0, 5),
            new RomanDigit("IV", 0, 4),
            new RomanDigit("I", 0, 1)
    );
}
