package com.functional.programming.controller;

import com.functional.programming.service.imp.IStructuredProgramming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("structured-programming/v1")
public class StructuredProgrammingController {

    @Autowired
    private IStructuredProgramming structuredProgramming;

    @PostMapping("print-numbers")
    public ResponseEntity<?> printAllNumbers(@RequestBody List<Integer> numbers){
        String result = structuredProgramming.printAllNumbersInListStructured(numbers);
        return ResponseEntity.ok(result);
    }

    @GetMapping("print-even-numbers")
    public ResponseEntity<?> printEvenNumbersOfTheList (@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(structuredProgramming.printEvenNumbersOfTheListStructured(numbers));
    }

    @GetMapping("add-all-numbers")
    public ResponseEntity<Integer> addAllNumbersStructured (@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(structuredProgramming.addListStructured(numbers));
    }



}
