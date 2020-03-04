package az.isha.hotel.controllers;


import az.isha.hotel.entity.Rooms;
import az.isha.hotel.form.NewBookingForm;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.model.CurrentUser;
import az.isha.hotel.services.AdminService;
import az.isha.hotel.services.BookingService;
import az.isha.hotel.services.RoomService;
import az.isha.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EditController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/newBooking", method = RequestMethod.POST)
    public String newBooking(@Valid @ModelAttribute NewBookingForm bookingForm, @AuthenticationPrincipal CurrentUser currentUser, Model model) { System.out.println(bookingForm.toString());

        model.addAttribute("currentUser",currentUser);
        model.addAttribute("bookingForm", bookingForm.getFullName());
        return "testData";
    }

    // TODO: 2020-03-03 мапинг на тимлеаф
    @RequestMapping(value = "/newRoom", method = RequestMethod.POST)
    public String newRoom(@ModelAttribute RoomForm roomForm,Model model) {
        System.out.println(roomForm);
        Rooms rooms = roomService.createRoom(roomForm);
        System.out.println(rooms);
        List<Rooms> roomsList =  roomService.getAll();
        model.addAttribute("roomsList", roomsList);
        return "all_rooms";
    }





}
