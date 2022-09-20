package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    // divide two integers (division by zero is undefined)
    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam int value2) {

        if (value2 == 0) {
            throw new IllegalArgumentException("Division by 0 is undefined.");
        }
        return value1 / value2;

    }

    // square integer (cap value at greatest possible int closest to sqrt of max int)
    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable int value) {

        if (value > 46340) {        // square root of max int rounded down
            throw new IllegalArgumentException("Square cannot exceed maximum integer value of 2,147,483,647.");
        }
            return value * value;
    }
}
