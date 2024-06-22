package com.functional.programming.controller;

import com.functional.programming.entities.CourseEntity;
import com.functional.programming.service.imp.IFunctionalProgramming;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all curses", description = "Get the list of all the courses store in the database")
    @GetMapping("courses")
    public ResponseEntity<List<CourseEntity>> getAllCourses (){
        return ResponseEntity.ok(functionalProgramming.printAllCourses());
    }

    @GetMapping("courses-length")
    public ResponseEntity<?> geNumberOfCharactersForEachCourse (){
        return ResponseEntity.ok(functionalProgramming.printNumberOfCharactersForEachCourse());
    }

    @GetMapping("courses-filtered")//TODO: improve this implementation
    public ResponseEntity<List<CourseEntity>> getCoursesFilterByWord(@RequestParam(name = "word", required = false) String word,
                                                                     @RequestParam(name = "length", required = false) Integer length){

        if (word != null)
            return ResponseEntity.ok(functionalProgramming.printCoursesFilterByWord(word));
        return ResponseEntity.ok(functionalProgramming.printCoursesByNumberOfLetters(length));
    }

    @GetMapping("print-square-numbers")
    public ResponseEntity<?> getPrintSquareOfEvenNumbersInListFunctional(@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgramming.printSquareOfEvenNumbersInListFunctional(numbers));
    }

    @GetMapping("print-cube-numbers")
    public ResponseEntity<?> getPrintCubeOfOddNumbersInListFunctional(@RequestBody List<Integer> numbers){
        return ResponseEntity.ok(functionalProgramming.printCubesOfOddNumbersInListFunctional(numbers));
    }

}
