package com.functional.programming.controller;

import com.functional.programming.service.imp.IFunctionalProgrammingV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("functional-programming/v2")
public class FunctionalProgrammingV2Controller {

    @Autowired
    private IFunctionalProgrammingV2 functionalProgrammingV2;

    @GetMapping("add-all-numbers")
    public ResponseEntity<Integer> addAllNumbersFunctional(@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgrammingV2.addListFunctional(numbers));
    }

    @GetMapping("highest-number")
    public ResponseEntity<Integer> highestNumberFunctional(@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgrammingV2.highestNumberFunctional(numbers));
    }

    @GetMapping("square-numbers-sum")
    public ResponseEntity<Integer> squareNumbersSum (@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgrammingV2.squareNumbersSum(numbers));
    }
    @GetMapping("cube-numbers-sum")
    public ResponseEntity<Integer> cubeNumbersSum (@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgrammingV2.cubeNumbersSum(numbers));
    }

    @GetMapping("odd-numbers-sum")
    public ResponseEntity<Integer> oddNumbersSum (@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgrammingV2.oddNumbersSum(numbers));
    }

}
