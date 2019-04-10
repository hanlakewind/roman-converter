package com.adobe.aem.romanconverter.controller.advice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.MissingServletRequestParameterException;

@RunWith(MockitoJUnitRunner.class)
public class InvalidArgumentAdviceTests {

    @InjectMocks
    private InvalidArgumentAdvice invalidArgumentAdvice;

    @Test
    public void handleExceptionTest() {
        final String testError = "test";
        Assert.assertEquals(testError, invalidArgumentAdvice.handleIllegalArgumentException(
                new IllegalArgumentException(testError)).getBody());
    }

    @Test
    public void handleMissingParamExceptionTest() {
        MissingServletRequestParameterException test = new MissingServletRequestParameterException("name", "type");
        Assert.assertEquals(test.getMessage(), invalidArgumentAdvice.handleMissingParamException(test).getBody());
    }
}
