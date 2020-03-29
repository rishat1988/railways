package com.validation;


import com.model.Schedule;
import com.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ScheduleValidator implements Validator {

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Schedule.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
       Schedule schedule = (Schedule) o;

    }
}
