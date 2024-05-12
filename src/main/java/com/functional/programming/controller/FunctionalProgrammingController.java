package com.functional.programming.controller;

import com.functional.programming.service.imp.IFunctionalProgramming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("functional-programming/v1")
public class FunctionalProgrammingController {

    @Autowired
    private IFunctionalProgramming functionalProgramming;

    @PostMapping("print-numbers")
    public ResponseEntity<?> printAllNumbers(@RequestBody List<Integer> numbers){
        String result = functionalProgramming.PrintAllNumbersInListFunctional(numbers);
        return ResponseEntity.ok(result);
    }

}
