package com.adobe.aem.romanconverter.controller;

import com.adobe.aem.romanconverter.model.RomanDigit;
import com.adobe.aem.romanconverter.service.RomanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The controller class that handle roman numeral related requests.
 */
@Controller
@Slf4j
public class RomanController {

    /**
     * The attribute key name that will be used to set the roman digits.
     */
    private static final String ROMAN_ATTRIBUTE_NAME = "romanDigits";

    private RomanService romanService;

    @Autowired
    public RomanController(RomanService romanService) {
        this.romanService = romanService;
    }

    /**
     * This method takes an integer request param and a Thymeleaf model, converts the integer to roman numeral.
     * This is not a Restful API controller. It responds the request with HTML.
     * @param inputString {@link String} of an integer.
     * @param model {@link Model} Thymeleaf model
     * @return a Thymeleaf template named roman.html
     */
    @RequestMapping("/romannumeral")
    public String getRomanNumeral(final @RequestParam(value = "query") String inputString,
                                  final Model model) {
        if (StringUtils.isBlank(inputString)) {
            throw new IllegalArgumentException("Query parameter cannot be blank.");
        }
        int inputInteger;
        try {
            inputInteger = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            log.warn(String.format("Cannot parse %s to an integer.", inputString));
            throw new IllegalArgumentException(e);
        }
        final List<RomanDigit> romanDigits = romanService.getRomanDigits(inputInteger);
        model.addAttribute(ROMAN_ATTRIBUTE_NAME, romanDigits);
        return "roman";
    }
}
