package com.validation;


import com.model.Train;

import com.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TrainValidator implements Validator {

    @Autowired
    private TrainService trainService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Train.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Train train = (Train) target;

        if (train.getNumber() != null) {
            if (trainService.getById(train.getNumber()) != null) {
                errors.rejectValue("id", "", "This id is already in use");
            }
        }

    }
}
