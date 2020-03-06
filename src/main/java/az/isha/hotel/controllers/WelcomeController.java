package az.isha.hotel.controllers;

import az.isha.hotel.entity.Booking;
import az.isha.hotel.entity.Rooms;
import az.isha.hotel.form.BookingForm;
import az.isha.hotel.form.RoomForm;
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

@Controller
public class WelcomeController {
    private static final Logger logger =  LogManager.getLogger(WelcomeController.class);

    @Autowired
    EditDataService editDataService;

    @GetMapping(value = "/")
    public String handleRequest(@AuthenticationPrincipal CurrentUser currentUser, HttpSession httpSession, Model model) {
        httpSession.setAttribute("currentUser", currentUser);
        System.out.println(currentUser.getLogin());
        return "user_profile";
    }


    @RequestMapping(value = "/login")
    public String signIn() {
        return "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard( Model model) {
        return "dashboard";
    }

    @RequestMapping(value = "/new_booking")
    public String newBooking(Model model) {
        model.addAttribute("bookingForm", new BookingForm());
        return "new_booking";
    }

    @RequestMapping(value = "/view_booking")
    public String viewBooking( Model model) {
        List<Booking> bookingList = editDataService.getAllBooking();
        model.addAttribute("bookingList", bookingList);
        return "view_booking";
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
        for (Rooms rooms : list) {
            System.out.println(rooms.toString());
        }
        System.out.println( editDataService.getAllRooms());
        model.addAttribute("roomsList",editDataService.getAllRooms());
        return "all_rooms";
    }

    @RequestMapping(value = "/edit_room")
    public String editRoom(Model model) {
        return "edit_room";
    }

    @RequestMapping(value = "/add_staff")
    public String addStaff(Model model) {
        return "add_staff";
    }

    @RequestMapping(value = "/all_staffs")
    public String allStaff( Model model) {
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


}