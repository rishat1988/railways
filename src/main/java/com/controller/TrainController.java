package com.controller;


import com.model.Train;
import com.service.TrainService;
import com.validation.TrainValidator;
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
public class TrainController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainValidator trainValidator;

    @GetMapping("/TrainManagement")
    public ModelAndView allTrains() {
        List<Train> trains = trainService.allTrains();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("train", new Train());
        modelAndView.setViewName("TrainManagement");
        modelAndView.addObject("trainsList", trains);
        return modelAndView;
    }

    @GetMapping(value = "/deleteTrain/{id}")
    public ModelAndView deleteTrain(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Train train = trainService.getById(id);
        trainService.delete(train);
        modelAndView.setViewName("redirect:/TrainManagement");
        return modelAndView;
    }

    @PostMapping(value = "/TrainManagement")
    public ModelAndView addTrain(@ModelAttribute("train") @Valid Train train, BindingResult result) {
        trainValidator.validate(train, result);
        ModelAndView modelAndView = new ModelAndView();
        List<Train> trains = trainService.allTrains();
        modelAndView.addObject("trainsList", trains);
        if (result.hasErrors()) {
            modelAndView.setViewName("TrainManagement");
        } else {
            trainService.add(train);
            modelAndView.setViewName("redirect:/TrainManagement");
        }
        return modelAndView;
    }

    @GetMapping(value = "/TrainUpdate/{id}")
    public ModelAndView updateTrain(@PathVariable("id") int id) {
        Train train = trainService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TrainUpdate");
        modelAndView.addObject("train", train);
        return modelAndView;
    }

    @PostMapping(value = "/TrainUpdate")
    public ModelAndView editTrain(@ModelAttribute("train") @Valid Train train, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        //trainValidator.validate(train, result);
        if (result.hasErrors()) {
            modelAndView.setViewName("TrainUpdate");
        } else {
            trainService.update(train);
            modelAndView.setViewName("redirect:/TrainManagement");
        }
        return modelAndView;
    }

}