package com.ewcode.aspectaop.algorithm;

import com.ewcode.libaspects.annotation.MeasureTime;
import com.ewcode.libaspects.annotation.ValidateData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("algorithm")
public class AlgorithmController {

    private static final Logger logger = Logger.getLogger(AlgorithmController.class.getName());

    @GetMapping
    @MeasureTime
    @ValidateData
    public void calculate(@RequestParam String data) {
        logger.info(data);
    }

    private double sum(double number1) {
        return number1 + 2;
    }

}