package com.functional.programming.service;

import com.functional.programming.dao.CoursesDao;
import com.functional.programming.service.imp.IStructuredProgramming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StructuredProgramingBO implements IStructuredProgramming {

    private final CoursesDao coursesDao;

    @Autowired
    public StructuredProgramingBO (CoursesDao coursesDao){
        this.coursesDao = coursesDao;
    }


    @Override
    public String printAllNumbersInListStructured(List<Integer> numbers) {
        log.info("Starting printAllNumbersInListStructured method");
        long startTime = System.currentTimeMillis();

        for (Integer number: numbers) {
            log.info("{}",number);
        }


        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printAllNumbersInListStructured method: " + executionTime + "ms");

        return "Execution time of printAllNumbersInListStructured method: " + executionTime + "ms";
    }

    @Override
    public List<Integer> printEvenNumbersOfTheListStructured(List<Integer> numbers) {
        log.info("Starting printEvenNumbersOfTheListStructured method");
        long startTime = System.currentTimeMillis();

        List<Integer> filteredList  = new ArrayList<>();

        for (Integer number: numbers){
            if ((number%2) == 0){
                log.info("{}", number);
                filteredList.add(number);
            }
        }

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of printEvenNumbersOfTheListStructured method: " + executionTime + "ms");

        return filteredList;
    }

    @Override
    public Integer addListStructured(List<Integer> numbers) {
        log.info("Starting addListStructured method ");
        long startTime = System.currentTimeMillis();

        Integer total = 0;

        for (Integer number: numbers){
            total += number;
        }

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of addListStructured method: " + executionTime + "ms");

        return total;
    }


}
