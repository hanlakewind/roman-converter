package com.adobe.aem.romanconverter.controller;

import com.adobe.aem.romanconverter.model.RomanDigit;
import com.adobe.aem.romanconverter.service.RomanService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class RomanControllerTests {

    @Mock
    private Model model;

    @Mock
    private RomanService romanService;

    @InjectMocks
    private RomanController romanController;

    @Test
    public void getRomanNumeralTest() {
        Mockito.when(romanService.getRomanDigits(Mockito.anyInt())).thenReturn(Mockito.<RomanDigit>anyList());
        Assert.assertEquals("roman", romanController.getRomanNumeral("123", model));
        Mockito.verify(model, Mockito.times(1))
                .addAttribute(Mockito.anyString(), Mockito.<RomanDigit>anyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRomanNumeralBlankInputTest() {
        romanController.getRomanNumeral("", model);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRomanNumeralInvalidInputTest() {
        romanController.getRomanNumeral("abc", model);
    }
}
