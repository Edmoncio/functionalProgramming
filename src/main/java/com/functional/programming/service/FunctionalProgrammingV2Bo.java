package com.functional.programming.service;

import com.functional.programming.service.imp.IFunctionalProgrammingV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FunctionalProgrammingV2Bo implements IFunctionalProgrammingV2 {

    @Override
    public int addListFunctional(List<Integer> numbers) {

        log.info("Starting addListFunctional method ");
        long startTime = System.currentTimeMillis();

        int total = numbers.stream().reduce(0, FunctionalProgrammingV2Bo::sum);

//        int total = numbers.stream().reduce(0, (x,y) -> x+y);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of addListFunctional method: " + executionTime + "ms");

        return total;

    }

    @Override
    public Integer highestNumberFunctional(List<Integer> numbers) {
        log.info("Starting highestNumberFunctional method ");
        long startTime = System.currentTimeMillis();

        Integer highest = numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of highestNumberFunctional method: " + executionTime + "ms");

        return highest;
    }

    @Override
    public Integer squareNumbersSum(List<Integer> numbers) {
        log.info("Starting squareNumbersSum method ");
        long startTime = System.currentTimeMillis();

        Integer total = numbers.stream().map(FunctionalProgrammingV2Bo::squareNumber).reduce(0, FunctionalProgrammingV2Bo::sum);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of squareNumbersSum method: " + executionTime + "ms");

        return total;
    }

    @Override
    public Integer cubeNumbersSum(List<Integer> numbers) {
        log.info("Starting cubeNumbersSum method ");
        long startTime = System.currentTimeMillis();

        Integer total = numbers.stream().map(FunctionalProgrammingV2Bo::cube).reduce(0, Integer::sum);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of cubeNumbersSum method: " + executionTime + "ms");

        return total;
    }

    @Override
    public Integer oddNumbersSum(List<Integer> numbers) {
        log.info("Starting cubeNumbersSum method ");
        long startTime = System.currentTimeMillis();

        Integer total = numbers.stream().filter(number -> number % 2 == 1).reduce(0, Integer::sum);

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of cubeNumbersSum method: " + executionTime + "ms");
        return total;
    }

    private static Integer cube (Integer number) {
        return number * number * number;
    }

    private static int sum (int aggregate, int nextNumber){
        return aggregate + nextNumber;
    }

    private static int squareNumber(int number){
        return number * number;
    }

}
