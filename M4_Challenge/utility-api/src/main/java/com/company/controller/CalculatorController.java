package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam int value2) {

        if (value2 == 0) {
            throw new IllegalArgumentException("Division by 0 is undefined.");
        }
        return value1 / value2;

    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable int value) {

        int valueSquared = value * value;

        if (valueSquared > 2147483647) {
            throw new IllegalArgumentException("Square cannot exceed maximum integer value of 2,147,483,647.");
        }
            return valueSquared;
    }
}
