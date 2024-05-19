package com.functional.programming.service.imp;

import com.functional.programming.entities.CoursesEntity;

import java.util.List;

public interface IFunctionalProgramming {

    String printAllNumbersInListFunctional(List<Integer> numbers);

    List<Integer> printEvenNumbersOfTheListFunctional(List<Integer> numbers);

    List<CoursesEntity> printAllCourses();

    List<CoursesEntity> printCoursesFilterByWord(String word);

    List<CoursesEntity> printCoursesByNumberOfLetters(int number);

    List<Integer> printSquareOfEvenNumbersInListFunctional(List<Integer> numbers);
    List<Integer> printCubesOfOddNumbersInListFunctional(List<Integer> numbers);
    List<String> printNumberOfCharactersForEachCourse();

}
