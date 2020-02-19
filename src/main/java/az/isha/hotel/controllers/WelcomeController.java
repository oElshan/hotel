package az.isha.hotel.controllers;

import az.isha.hotel.form.SignInForm;
import az.isha.hotel.form.UserForm;
import az.isha.hotel.services.AdminService;
import az.isha.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @GetMapping
    public String handleRequest (Model model) {

        return "welcome";
    }

    @GetMapping(value = "/login")
    public String login(SignInForm signInForm, Model model) {
        model.addAttribute("signIn", new SignInForm());
        return "sign-in";
    }

//    @PostMapping(value = "/sign-in")
//    public String signIn(@ModelAttribute SignInForm signInForm, Model model) {
//
//
//        return "input";
//    }

}