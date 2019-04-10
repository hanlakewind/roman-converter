package com.adobe.aem.romanconverter.service;

import com.adobe.aem.romanconverter.model.RomanDigit;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.adobe.aem.romanconverter.service.RomanService.MAX_SUPPORTED_NUMBER;

@RunWith(MockitoJUnitRunner.class)
public class RomanServiceTests {

    @InjectMocks
    private RomanService romanService;

    @Test
    public void getRomanDigitsTest() {
        final List<RomanDigit> expected = ImmutableList.of(
                new RomanDigit("IX", 2, 9000000),
                new RomanDigit("C", 1, 100000),
                new RomanDigit("C", 1, 100000),
                new RomanDigit("L", 0, 50),
                new RomanDigit("I", 0, 1)
        );
        Assert.assertEquals(expected, romanService.getRomanDigits(9200051));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRomanDigitsTooBigExceptionTest() {
        romanService.getRomanDigits(MAX_SUPPORTED_NUMBER + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRomanDigitsTooSmallExceptionTest() {
        romanService.getRomanDigits(0);
    }
}
