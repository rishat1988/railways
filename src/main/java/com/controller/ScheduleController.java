package com.controller;


import com.dto.ScheduleDto;

import com.model.Schedule;
import com.model.Station;
import com.model.Train;
import com.service.ScheduleService;
import com.service.StationService;
import com.service.TrainService;
import com.validation.ScheduleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private ScheduleValidator scheduleValidator;

    @GetMapping(value = "/ScheduleManagement")
    public ModelAndView allSchedules() {
        List<Schedule> schedules = scheduleService.allSchedules();
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleDto scheduleDto = scheduleService.getData(schedule.getId());
            scheduleDtos.add(scheduleDto);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("schedule", new Schedule());

        List<Integer> trainsNumbers = new ArrayList<>();
        for (Train train : trainService.allTrains()) {
            trainsNumbers.add(train.getNumber());
        }

        List<String> stationsNamesList = new ArrayList<>();
        for (Station station : stationService.allStations()) {
            stationsNamesList.add(station.getName());
        }

        modelAndView.addObject("scheduleDtosList", scheduleDtos);
        modelAndView.addObject("scheduleTrainsList", trainsNumbers);
        modelAndView.addObject("scheduleStationsList", stationsNamesList);
        modelAndView.setViewName("ScheduleManagement");
        modelAndView.addObject("scheduleDtosList", scheduleDtos);
        return modelAndView;
    }

    @GetMapping(value="/deleteSchedule/{id}")
    public ModelAndView deleteSchedule(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Schedule schedule = scheduleService.getById(id);
        scheduleService.delete(schedule);
        modelAndView.setViewName("redirect:/ScheduleManagement");
        return modelAndView;
    }

    @PostMapping(value = "/ScheduleManagement")
    public ModelAndView addSchedule(@ModelAttribute @Valid Schedule schedule, BindingResult result) {
        //timetableValidator.validate(timetable, result);
        List<Schedule> schedules = scheduleService.allSchedules();
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for ( Schedule s : schedules) {
            ScheduleDto scheduleDto = scheduleService.getData(s.getId());
            scheduleDtos.add(scheduleDto);
        }
        ModelAndView modelAndView = new ModelAndView();

        List<Integer> trainsNumbersList = new ArrayList<>();
        for (Train train : trainService.allTrains()) {
            trainsNumbersList.add(train.getId());
        }

        List<String> stationsNamesList = new ArrayList<>();
        for (Station station : stationService.allStations()) {
            stationsNamesList.add(station.getName());
        }

        modelAndView.addObject("scheduleDtosList", scheduleDtos);
        modelAndView.addObject("scheduleTrainsList", trainsNumbersList);
        modelAndView.addObject("scheduleStationsList", stationsNamesList);
        if (result.hasErrors()) {
            modelAndView.setViewName("ScheduleManagement");
        } else {
            scheduleService.add(schedule);
            modelAndView.setViewName("redirect:/ScheduleManagement");
        }
        return modelAndView;
    }

    @GetMapping(value = "/ScheduleUpdate/{id}")
    public ModelAndView updatePage(@PathVariable("id") int id) {
        Schedule schedule = scheduleService.getById(id);
        List<Schedule> schedules = scheduleService.allSchedules();
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for (Schedule s : schedules) {
            ScheduleDto scheduleDto = scheduleService.getData(s.getId());
            scheduleDtos.add(scheduleDto);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ScheduleUpdate");
        modelAndView.addObject("schedule", schedule);

        List<Integer> trainsNumbersList = new ArrayList<>();
        for (Train train : trainService.allTrains()) {
            trainsNumbersList.add(train.getNumber());
        }

        List<String> stationsNamesList = new ArrayList<>();
        for (Station station : stationService.allStations()) {
            stationsNamesList.add(station.getName());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        modelAndView.addObject("scheduleDtosList", scheduleDtos);
        modelAndView.addObject("scheduleTrainsList", trainsNumbersList);
        modelAndView.addObject("scheduleStationsList", stationsNamesList);

        return modelAndView;
    }

    @PostMapping(value = "/ScheduleUpdate")
    public ModelAndView updateSchedule(@ModelAttribute("schedule") @Valid Schedule schedule, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        //scheduleValidator.validate(schedule, result);

        List<Schedule> schedules = scheduleService.allSchedules();
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for (Schedule s : schedules) {
            ScheduleDto scheduleDto = scheduleService.getData(s.getId());
            scheduleDtos.add(scheduleDto);
        }

        List<Integer> trainsNumbersList = new ArrayList<>();
        for (Train train : trainService.allTrains()) {
            trainsNumbersList.add(train.getNumber());
        }

        List<String> stationsNamesList = new ArrayList<>();
        for (Station station : stationService.allStations()) {
            stationsNamesList.add(station.getName());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        modelAndView.addObject("scheduleDtosList", scheduleDtos);
        modelAndView.addObject("trainsNumbersList", trainsNumbersList);
        modelAndView.addObject("scheduleStationsList", stationsNamesList);

        if (result.hasErrors()) {
            modelAndView.setViewName("ScheduleUpdate");
        } else {
            scheduleService.update(schedule);
            modelAndView.setViewName("redirect:/ScheduleManagement");
        }
        return modelAndView;
    }

}