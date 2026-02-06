package com.example.studentprogram.maths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calc")
public class MathController {
    int firstValue = 500;
    int secondValue = 1000;

    @GetMapping(value="/get-addition")
    public int getSum(){
        return firstValue+secondValue;
    }

    @GetMapping(value = "/get-subtraction")
    public int getMinus(){
        return firstValue-secondValue;
    }

    @GetMapping(value="/get-multiplication")
    public long getMul(){
        return (long)firstValue*secondValue;
    }

    @GetMapping(value = "/get-devision")
    public double getDev(){
        if(secondValue <= 0)
            return 0;

        return (double)firstValue/secondValue;
    }


}
