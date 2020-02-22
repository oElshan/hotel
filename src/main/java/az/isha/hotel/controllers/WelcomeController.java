package az.isha.hotel.controllers;

import az.isha.hotel.form.SignInForm;
import az.isha.hotel.form.UserForm;
import az.isha.hotel.model.CurrentUser;
import az.isha.hotel.services.AdminService;
import az.isha.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String handleRequest(Model model) {

        return "welcome";
    }


    @RequestMapping(value = "/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @RequestMapping(value = "/sign-in-failed")
    public String signInFail(Model model) {
        model.addAttribute("loginError",true);
        return "sign-in";
    }

   @RequestMapping(value = "/profile")
    public String login(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        if (currentUser.getROLES().equals("ADMIN")) {
            return "admin";
        }
        return "user";
    }

}