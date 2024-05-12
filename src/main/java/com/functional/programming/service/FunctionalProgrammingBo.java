package com.functional.programming.service;

import com.functional.programming.service.imp.IFunctionalProgramming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FunctionalProgrammingBo  implements IFunctionalProgramming {


    @Override
    public String PrintAllNumbersInListFunctional(List<Integer> numbers) {
        log.info("Starting PrintAllNumbersInListFunctional method");
        long startTime = System.currentTimeMillis();

        numbers.stream().parallel().forEach(FunctionalProgrammingBo::printNumber); // This is a method reference

        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of PrintAllNumbersInListFunctional method: " + executionTime + "ms");

        return "Execution time of PrintAllNumbersInListFunctional method: " + executionTime + "ms";
    }

    private static void printNumber(int number){
     log.info("{}",number);
    }

}
