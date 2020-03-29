package com.controller;


import org.springframework.stereotype.Controller;
import com.model.User;
import com.security.SecurityService;
import com.service.UserService;
import com.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;

@Controller
public class UserController {


    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/RegistrationPage")
    public ModelAndView RegistrationPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user", new User());
        modelAndView.setViewName("RegistrationPage");
        return modelAndView;
    }

    @PostMapping(value = "/RegistrationPage")
    public ModelAndView RegistrationPage(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("RegistrationPage");
        } else {
//            userService.userRegistration(user);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");

            userService.add(user);
            securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
            modelAndView.setViewName("PageForClients");
        }
        return modelAndView;
    }

    @GetMapping("/LoginPage")
    public ModelAndView LoginPage(String error, String logout) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Username or password is incorrect");
        }

        if (logout != null) {
            modelAndView.addObject("message", "Logged out successfully");
        }
        modelAndView.setViewName("LoginPage");
        return modelAndView;
    }

}
