package az.isha.hotel.controllers;

import az.isha.hotel.form.SignInForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @GetMapping
    public String handleRequest (Model model) {

        return "welcome";
    }

    @GetMapping(value = "/login")
    public String login(SignInForm signInForm, Model model) {
        model.addAttribute("signIn", new SignInForm());
        return "sign-in";
    }

}