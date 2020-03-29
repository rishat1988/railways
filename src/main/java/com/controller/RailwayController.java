package com.controller;


import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RailwayController {

    @Autowired
//    private PassengerService passengerService;
    private UserService userService;

    @GetMapping(value = {"/", "MainPage"})
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MainPage");
        return modelAndView;
    }

    @GetMapping(value = "/AdminConsole")
    public ModelAndView employeePage() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AdminConsole");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    @GetMapping(value = "/PageForClients")
    public ModelAndView clientPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("PageForClients");
        return modelAndView;
    }

    @GetMapping(value = "/Error")
    public ModelAndView accessDeniedPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "You are not authorize to access this page.");
        modelAndView.setViewName("Error");
        return modelAndView;
    }

}