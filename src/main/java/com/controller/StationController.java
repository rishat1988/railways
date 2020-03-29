package com.controller;



import com.model.Station;
import com.service.StationService;
import com.validation.StationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;

    @Autowired
    private StationValidator stationValidator;

    @GetMapping("/StationManagement")
    public ModelAndView allStations() {
        List<Station> stations = stationService.allStations();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("station", new Station());
        modelAndView.setViewName("StationManagement");
        modelAndView.addObject("stationsList", stations);
        return modelAndView;
    }

    @GetMapping(value = "/deleteStation/{id}")
    public ModelAndView deleteStation(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Station station = stationService.getById(id);
        stationService.delete(station);
        modelAndView.setViewName("redirect:/StationManagement");
        return modelAndView;
    }

    @PostMapping(value = "/StationManagement")
    public ModelAndView addStation(@ModelAttribute @Valid Station station, BindingResult result) {
        stationValidator.validate(station, result);
        List<Station> stations = stationService.allStations();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stationsList", stations);
        if (result.hasErrors()) {
            modelAndView.setViewName("StationManagement");
        } else {
            stationService.add(station);
            modelAndView.setViewName("redirect:/StationManagement");
        }
        return modelAndView;
    }

    @GetMapping(value = "/StationUpdate/{id}")
    public ModelAndView updateStation(@PathVariable("id") int id) {
        Station station = stationService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("StationUpdate");
        modelAndView.addObject("station", station);
        return modelAndView;
    }

    @PostMapping(value = "/StationUpdate")
    public ModelAndView updateStation(@ModelAttribute("station") @Valid Station station, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        //stationValidator.validate(station, result);
        if (result.hasErrors()) {
            modelAndView.setViewName("StationUpdate");
        } else {
            stationService.update(station);
            modelAndView.setViewName("redirect:/StationManagement");
        }
        return modelAndView;
    }
}
