package com.functional.programming.service.imp;

import com.functional.programming.entities.CourseEntity;

import java.util.List;

public interface IFunctionalProgramming {

    String printAllNumbersInListFunctional(List<Integer> numbers);

    List<Integer> printEvenNumbersOfTheListFunctional(List<Integer> numbers);

    List<CourseEntity> printAllCourses();

    List<CourseEntity> printCoursesFilterByWord(String word);

    List<CourseEntity> printCoursesByNumberOfLetters(int number);

    List<Integer> printSquareOfEvenNumbersInListFunctional(List<Integer> numbers);
    List<Integer> printCubesOfOddNumbersInListFunctional(List<Integer> numbers);
    List<String> printNumberOfCharactersForEachCourse();

}
