package az.isha.hotel.controllers;

import az.isha.hotel.entity.Booking;
import az.isha.hotel.entity.Rooms;
import az.isha.hotel.entity.User;
import az.isha.hotel.form.BookingForm;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.form.SignInForm;
import az.isha.hotel.form.StaffForm;
import az.isha.hotel.model.CurrentUser;
import az.isha.hotel.services.EditDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
public class WelcomeController {
    private static final Logger logger =  LogManager.getLogger(WelcomeController.class);

    @Autowired
    EditDataService editDataService;

    @GetMapping(value = "/")
    public String handleRequest(@AuthenticationPrincipal CurrentUser currentUser, HttpSession httpSession, Model model) {
        httpSession.setAttribute("currentUser", currentUser);
        System.out.println(currentUser.getLogin());
        return "dashboard";
    }


    @RequestMapping(value = "/login")
    public String signIn() {
        return "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(Locale locale, Model model) {
        return "dashboard";

    }

    @RequestMapping(value = "/new_booking")
    public String newBooking(Model model) {
        model.addAttribute("bookingForm", new BookingForm());
        return "add_booking";
    }

    @RequestMapping(value = "/view_booking")
    public String viewBooking( Model model) {
        List<Booking> bookingList = editDataService.getAllBooking();
        model.addAttribute("bookingList", bookingList);
        return "all_booking";
    }

    @RequestMapping(value = "/edit_booking")
    public String editBooking( Model model) {

        return "edit_booking";
    }

    @RequestMapping(value = "/add_room")
    public String addRoom(Model model) {
        model.addAttribute("roomForm", new RoomForm());
        return "add_room";
    }

    @RequestMapping(value = "/all_room")
    public String allRoom( Model model) {

        List<Rooms> list = editDataService.getAllRooms();
        model.addAttribute("roomsList",list);
        return "all_rooms";
    }

    @RequestMapping(value = "/edit_room")
    public String editRoom(Model model) {
        return "edit_room";
    }

    @RequestMapping(value = "/add_staff")
    public String addStaff(Model model) {
        model.addAttribute("staffForm", new StaffForm());
        return "add_staff";
    }

    @RequestMapping(value = "/all_staffs")
    public String allStaff( Model model) {
        List<User> usrers = editDataService.findAllUsers();
        model.addAttribute("listUsers", usrers);
        return "all_staffs";
    }

    @RequestMapping(value = "/edit_staff")
    public String editStaff( Model model) {
        return "edit_staff";
    }

    @RequestMapping(value = "/sign-in-failed")
    public String signInFail(Model model) {
        model.addAttribute("loginError",true);
        return "login";
    }

    @RequestMapping(value = "/check_in")
    public String checkIn(Model model) {
        return "check_in";
    }


}