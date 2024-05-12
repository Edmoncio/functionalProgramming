package com.functional.programming.controller;

import com.functional.programming.service.imp.IStructuredProgramming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("structured-programming/v1")
public class StructuredProgrammingController {

    @Autowired
    private IStructuredProgramming structuredProgramming;

    @PostMapping("print-numbers")
    public ResponseEntity<?> printAllNumbers(@RequestBody List<Integer> numbers){
        String result = structuredProgramming.PrintAllNumbersInListStructured(numbers);
        return ResponseEntity.ok(result);
    }

}
