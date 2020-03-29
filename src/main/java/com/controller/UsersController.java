//package com.controller;
//
//import com.model.User;
//import com.security.SecurityService;
//import com.service.UserService;
//import com.validation.UserValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//public class RegistrationController {
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//
//    @GetMapping({"/login"})
//
//
//    public String login(Model model) {
//        return "login";
//    }
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.create(userForm);
//
//        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());
//
////        return "
//    }
//
//    @GetMapping("/signin")
//    public String getSignIn( Model model) {
//        model.addAttribute("userForm", new User());
//        return "signin";
//    }
//
//    @PostMapping("/signin")
//    public String signIn(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validateUserAuth(userForm.getUserName(), userForm.getPassword(), bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "signin";
//        }
//        securityService.autoLogin(userForm.getUserName(), userForm.getPassword());
////        return "redirect:/list";
//        return "redirect:/login";
//    }
//
//    @GetMapping("/logout")
//    public String logout( Model model) {
//        return "redirect:/login";
//    }
//}
//
//import com.model.User;
//import com.security.SecurityService;
//import com.service.UserService;
//import com.validation.UserValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.create(userForm);
//
//
//        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());
//        return "redirect:/index";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }
//
//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "index";
//    }
//}