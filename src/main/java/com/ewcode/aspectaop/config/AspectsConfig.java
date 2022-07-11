package com.ewcode.aspectaop.config;

import com.ewcode.libaspects.aspects.ValidateDataAspect;
import com.ewcode.libaspects.interfaces.IValidateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectsConfig {

    @Autowired
    IValidateDataService validateDataService;


    @Bean
    public ValidateDataAspect validateDataAspect() {
        return new ValidateDataAspect(validateDataService);
    }

}
