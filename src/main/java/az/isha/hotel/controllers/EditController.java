package az.isha.hotel.controllers;


import az.isha.hotel.entity.Booking;
import az.isha.hotel.entity.Rooms;
import az.isha.hotel.entity.User;
import az.isha.hotel.form.BookingForm;
import az.isha.hotel.form.NewBookingForm;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.form.StaffForm;
import az.isha.hotel.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EditController {
    private static final Logger logger =  LogManager.getLogger(EditController.class);

    @Autowired
    EditDataService editDataService;


    @RequestMapping(value = "/startBooking", method = RequestMethod.POST)
    public String startBooking( @RequestBody NewBookingForm newBookingForm,Model model) {
        System.out.println(newBookingForm.toString());
        List<Rooms> list = editDataService.getAllRooms();
        model.addAttribute("roomsList",list);
        return "available_rooms::roomsList";
    }

    @RequestMapping(value = "/newBooking", method = RequestMethod.POST)
    public String newBooking(@Valid @ModelAttribute("bookingForm") BookingForm bookingForm, BindingResult bindingResult , Model model) {
        logger.info(bookingForm.toString());
        System.out.println(bookingForm.toString());
        if (bindingResult.hasErrors()) {
            return "add_booking";
        }
        Booking booking = editDataService.createNewBooking(bookingForm);
        List<Booking> bookingList = editDataService.getAllBooking();
        model.addAttribute("bookingList", bookingList);
        return "all_booking";
    }

    @RequestMapping(value = "/newRoom", method = RequestMethod.POST)
    public String newRoom(@Valid @ModelAttribute("roomForm") RoomForm roomForm, BindingResult bindingResult, Model model) {
        System.out.println(roomForm.toString());
        if (bindingResult.hasErrors()) {
            return "add_room";
        }
        Rooms rooms = editDataService.createRoom(roomForm);
        logger.info("Create new room"+rooms.toString());
        List<Rooms> roomsList = editDataService.getAllRooms();
        model.addAttribute("roomsList", roomsList);
        return "all_rooms";
    }


    @RequestMapping(value = "/newStaff", method = RequestMethod.POST)
    public String newStaff(@Valid @ModelAttribute("staffForm") StaffForm staffForm, BindingResult bindingResult, Model model) {
        System.out.println(staffForm.toString());
        if (bindingResult.hasErrors()) {
            return "add_staff";
        }
        // TODO: 2020-03-18 тут не верно походу
        if (editDataService.findUserByLogin(staffForm.getLogin()) != null) {
            bindingResult.addError(new ObjectError("loginError","Пользователь с таким длогином уже существует!"));
            return "add_staff";
        }
        editDataService.createNewUser(staffForm);
        List<User> usrers = editDataService.findAllUsers();
        model.addAttribute("listUsers", usrers);

        return "all_staffs";
    }





}
