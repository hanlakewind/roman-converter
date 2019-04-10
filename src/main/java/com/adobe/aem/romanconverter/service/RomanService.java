package com.adobe.aem.romanconverter.service;

import com.adobe.aem.romanconverter.model.RomanDigit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The service class that handles business logic related to roman numeral.
 */
@Service
@Slf4j
public class RomanService {

    /**
     * The maximum supported number to convert to roman numeral.
     */
    public static final int MAX_SUPPORTED_NUMBER = 10000000;

    /**
     * This method converts an integer to a list of RomanDigit.
     * @param number input int that must be between 1 and 10000000.
     * @return {@link List<RomanDigit>}
     */
    public List<RomanDigit> getRomanDigits(int number) {
        if (number < 1 || number > 10000000) {
            log.warn(String.format("%d is not a valid number.", number));
            throw new IllegalArgumentException("Input integer must be between 1 and 10000000.");
        }
        final List<RomanDigit> result = new ArrayList<RomanDigit>();
        int currentIndex = 0;
        while (number > 0) {
            final RomanDigit currentRomanDigit = RomanDigit.ROMAN_DIGIT_LIST.get(currentIndex);
            if (number >= currentRomanDigit.getDecimalNumber()) {
                result.add(currentRomanDigit);
                number -= currentRomanDigit.getDecimalNumber();
            } else {
                currentIndex++;
            }
        }
        return result;
    }
}
