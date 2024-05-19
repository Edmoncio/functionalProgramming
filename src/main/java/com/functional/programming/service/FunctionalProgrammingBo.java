package com.functional.programming.service;

import com.functional.programming.dao.CoursesDao;
import com.functional.programming.entities.CoursesEntity;
import com.functional.programming.service.imp.IFunctionalProgramming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class FunctionalProgrammingBo  implements IFunctionalProgramming {

    private final CoursesDao coursesDao;

    @Autowired
    public FunctionalProgrammingBo (CoursesDao coursesDao){
        this.coursesDao = coursesDao;
    }

    @Override
    public List<CoursesEntity> printCoursesByNumberOfLetters(int number) {
        log.info("Starting printCoursesByNumberOfLetters method");
        long startTime = System.currentTimeMillis();

        List<CoursesEntity> courses = coursesDao.findAll();

        List<CoursesEntity> filteredCourses = courses.stream().filter(course -> course.getName().length() >= number).toList();

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printCoursesByNumberOfLetters method: " + executionTime + "ms");

        return filteredCourses;
    }

    @Override
    public String printAllNumbersInListFunctional(List<Integer> numbers) {
        log.info("Starting PrintAllNumbersInListFunctional method");
        long startTime = System.currentTimeMillis();

        numbers.stream().parallel().forEach(FunctionalProgrammingBo::printer); // This is a method reference

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of PrintAllNumbersInListFunctional method: " + executionTime + "ms");

        return "Execution time of PrintAllNumbersInListFunctional method: " + executionTime + "ms";
    }

    @Override
    public List<Integer> printSquareOfEvenNumbersInListFunctional(List<Integer> numbers) {
        log.info("Starting printSquareOfEvenNumbersInListFunctional method");
        long startTime = System.currentTimeMillis();

        List<Integer> squareNumbers;

        squareNumbers = numbers.stream()
                .filter(FunctionalProgrammingBo::isEvenNumber)
                .map(FunctionalProgrammingBo::squareNumber)
                .toList();

        squareNumbers.forEach(FunctionalProgrammingBo::printer);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printSquareOfEvenNumbersInListFunctional method: " + executionTime + "ms");

        return squareNumbers;
    }

    @Override
    public List<Integer> printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        log.info("Starting printCubesOfOddNumbersInListFunctional method");
        long startTime = System.currentTimeMillis();

        List<Integer> cubeOfOddNumbersList = numbers.stream()
                .filter(FunctionalProgrammingBo::isOddNumber)
                .map(FunctionalProgrammingBo::cubeNumber).toList();

        cubeOfOddNumbersList.forEach(FunctionalProgrammingBo::printer);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printCubesOfOddNumbersInListFunctional method: " + executionTime + "ms");
        return cubeOfOddNumbersList;
    }

    @Override
    public List<String> printNumberOfCharactersForEachCourse() {
        log.info("Starting printNumberOfCharactersForEachCourse method");
        long startTime = System.currentTimeMillis();

        List<CoursesEntity> courses = coursesDao.findAll();

        List<String> courseLength = courses.stream().map(course ->
                course.getName() + " : " + course.getName().length())
                .toList();

        courseLength.forEach(FunctionalProgrammingBo::printer);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printNumberOfCharactersForEachCourse method: " + executionTime + "ms");
        return courseLength;
    }

    @Override
    public List<Integer> printEvenNumbersOfTheListFunctional(List<Integer> numbers) {
        log.info("Starting printEvenNumbersOfTheListFunctional method");
        long startTime = System.currentTimeMillis();

        List<Integer> filteredList;

//        filteredList = numbers.stream().filter(number -> (number % 2) == 0).toList();

        filteredList = numbers.stream().filter(FunctionalProgrammingBo::isEvenNumber).toList(); //Mrryhof trgrtrnvr

        filteredList.forEach(FunctionalProgrammingBo::printer);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printEvenNumbersOfTheListFunctional method: " + executionTime + "ms");

        return filteredList;
    }

    @Override
    public List<CoursesEntity> printAllCourses() {
        log.info("Starting printAllCourses method");
        long startTime = System.currentTimeMillis();

        List<CoursesEntity> courses = coursesDao.findAll();

        courses.forEach(FunctionalProgrammingBo::printer);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printAllCourses method: " + executionTime + "ms");
        return courses;
    }

    @Override
    public List<CoursesEntity> printCoursesFilterByWord(String word) {
        log.info("Starting printCoursesFilterByWord method");
        long startTime = System.currentTimeMillis();

        List<CoursesEntity> courses = coursesDao.findAll();

        List<CoursesEntity> coursesFiltered = courses.stream().filter(course -> course.getName().contains(word)).toList();

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printCoursesFilterByWord method: " + executionTime + "ms");

        return coursesFiltered;
    }

    private static boolean isEvenNumber(int number){
        return (number % 2) == 0;
    }

    private static boolean isOddNumber(int number){
        return (number % 2) != 0;
    }

    private static int squareNumber(int number){
        return number * number;
    }

    private static int cubeNumber(int number){
        return number * number * number;
    }

    private static void printer(Object value){
     log.info("{}",value);
    }

}
