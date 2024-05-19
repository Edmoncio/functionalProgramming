package com.functional.programming.controller;

import com.functional.programming.service.imp.IFunctionalProgramming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("functional-programming/v1")
public class FunctionalProgrammingController {

    @Autowired
    private IFunctionalProgramming functionalProgramming;

    @PostMapping("print-numbers")
    public ResponseEntity<?> printAllNumbers(@RequestBody List<Integer> numbers){
        String result = functionalProgramming.printAllNumbersInListFunctional(numbers);
        return ResponseEntity.ok(result);
    }

    @GetMapping("print-even-numbers")
    public ResponseEntity<?> printEvenNumbersOfTheList (@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgramming.printEvenNumbersOfTheListFunctional(numbers));
    }

    @GetMapping("courses")
    public ResponseEntity<?> getAllCourses (){
        return ResponseEntity.ok(functionalProgramming.printAllCourses());
    }

    @GetMapping("courses-filtered")//TODO: improve this implementation
    public ResponseEntity<?> getCoursesFilterByWord(@RequestParam(name = "word", required = false) String word,
                                                    @RequestParam(name = "length", required = false) Integer length){

        if (word != null)
            return ResponseEntity.ok(functionalProgramming.printCoursesFilterByWord(word));
        return ResponseEntity.ok(functionalProgramming.printCoursesByNumberOfLetters(length));
    }

    @GetMapping("print-square-numbers")
    public ResponseEntity<?> getPrintSquareOfEvenNumbersInListFunctional(@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgramming.printSquareOfEvenNumbersInListFunctional(numbers));
    }

}
