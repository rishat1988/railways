package com.validation;


import com.model.Station;
import com.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class StationValidator implements Validator{

    @Autowired
    private StationService stationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Station.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Station station = (Station) o;

        List<Station> stations = stationService.allStations();
        for (Station s : stations) {
            if (s.getName().equals(station.getName())) {
                errors.rejectValue("name", "", "Station with this name is already exist");
                break;
            }
        }

    }
}