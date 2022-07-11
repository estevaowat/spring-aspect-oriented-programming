package com.ewcode.aspectaop.algorithm;

import com.ewcode.libaspects.interfaces.IValidateDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateDataService implements IValidateDataService {

    @Override
    public List<String> validateData(String data) {
        
        List<String> errors = new ArrayList<>();
        errors.add("NOVO ERRO");
        return errors;
    }
}
