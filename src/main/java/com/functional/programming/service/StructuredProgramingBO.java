package com.functional.programming.service;

import com.functional.programming.service.imp.IStructuredProgramming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StructuredProgramingBO implements IStructuredProgramming {


    @Override
    public String PrintAllNumbersInListStructured(List<Integer> numbers) {
        log.info("Starting PrintAllNumbersInListStructured method");
        long startTime = System.currentTimeMillis();

        for (Integer number: numbers) {
            log.info("{}",number);
        }


        long executionTime = System.currentTimeMillis() - startTime;

        log.info("Execution time of PrintAllNumbersInListStructured method: " + executionTime + "ms");

        return "Execution time of PrintAllNumbersInListStructured method: " + executionTime + "ms";
    }

}
