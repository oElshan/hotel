package az.isha.hotel.controllers;

import az.isha.hotel.entity.Rooms;
import az.isha.hotel.form.NewBookingForm;
import az.isha.hotel.form.SignInForm;
import az.isha.hotel.form.UserForm;
import az.isha.hotel.model.CurrentUser;
import az.isha.hotel.services.AdminService;
import az.isha.hotel.services.RoomService;
import az.isha.hotel.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
public class WelcomeController {
    private static final Logger logger =  LogManager.getLogger(WelcomeController.class);
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    RoomService roomService;

    @GetMapping(value = "/")
    public String handleRequest(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("currentUser",currentUser);
        System.out.println(currentUser.getLogin());
        return "user_profile";
    }


    @RequestMapping(value = "/login")
    public String signIn() {
        return "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "dashboard";
    }

    @RequestMapping(value = "/new_booking")
    public String newBooking(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "new_booking";
    }

    @RequestMapping(value = "/view_booking")
    public String viewBooking(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "view_booking";
    }

    @RequestMapping(value = "/edit_booking")
    public String editBooking(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "edit_booking";
    }

    @RequestMapping(value = "/add_room")
    public String addRoom(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "add_room";
    }

    @RequestMapping(value = "/all_room")
    public String allRoom(@AuthenticationPrincipal CurrentUser currentUser, Model model) {

        model.addAttribute("currentUser",currentUser);
        List<Rooms> list = roomService.getAll();
        for (Rooms rooms : list) {
            System.out.println(rooms.toString());
        }
        System.out.println( roomService.getAll());
        model.addAttribute("roomsList",roomService.getAll());
        return "all_rooms";
    }

    @RequestMapping(value = "/edit_room")
    public String editRoom(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "edit_room";
    }

    @RequestMapping(value = "/add_staff")
    public String addStaff(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "add_staff";
    }

    @RequestMapping(value = "/all_staffs")
    public String allStaff(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "all_staffs";
    }

    @RequestMapping(value = "/edit_staff")
    public String editStaff(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser",currentUser);
        return "edit_staff";
    }

    @RequestMapping(value = "/sign-in-failed")
    public String signInFail(Model model) {
        model.addAttribute("loginError",true);
        return "login";
    }



//   @RequestMapping(value = "/user_profile")
//    public String login(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
////        if (currentUser.getROLES().equals("ADMIN")) {
////            return "admin";
////        }
//       model.addAttribute("currentUser", currentUser.getLogin());
//       logger.info("пользователь"+ currentUser.getLogin()+"зашел в систему");
//       System.out.println(currentUser.getLogin());
//        return "user_profile";
//    }

}