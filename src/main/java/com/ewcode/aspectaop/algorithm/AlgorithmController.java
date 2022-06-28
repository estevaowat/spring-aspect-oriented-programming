package com.ewcode.aspectaop.algorithm;

import com.ewcode.aspectaop.annotations.LogExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.logging.Logger;

@RestController
@RequestMapping("algorithm")
public class AlgorithmController {

    private static final Logger logger = Logger.getLogger(AlgorithmController.class.getName());

    @GetMapping
    @LogExecutionTime
    public void calculate() {
        double sum = 0d;

        for(int i = 0; i < 10000000; i++) {
            if(i % 2 == 0) // if the remainder of `i/2` is 0
                sum += -1 / (2 * i - 1);
            else
                sum += 1 / (2 * i - 1);
        }

        String calculationSumLog = MessageFormat.format("The calculation sum is = {0}", sum);
        logger.info(calculationSumLog);
    }
}