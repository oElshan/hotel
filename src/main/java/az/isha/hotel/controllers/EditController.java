package az.isha.hotel.controllers;


import az.isha.hotel.entity.Booking;
import az.isha.hotel.entity.Rooms;
import az.isha.hotel.form.BookingForm;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EditController {
    private static final Logger logger =  LogManager.getLogger(EditController.class);

    @Autowired
    EditDataService editDataService;

    // TODO: 2020-03-05 добавить отображение
    @RequestMapping(value = "/newBooking", method = RequestMethod.POST)
    public String newBooking(@Valid @ModelAttribute("bookingForm") BookingForm bookingForm, BindingResult bindingResult , Model model) { System.out.println(bookingForm.toString());
        logger.info(bookingForm.toString());
        if (bindingResult.hasErrors()) {
            return "new_booking";
        }
        Booking booking = editDataService.createNewBooking(bookingForm);
        List<Booking> bookingList = editDataService.getAllBooking();
        model.addAttribute("bookingList", bookingList);
        return "view_booking";
    }

    @RequestMapping(value = "/newRoom", method = RequestMethod.POST)
    public String newRoom(@Valid @ModelAttribute RoomForm roomForm, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roomFormError");
            return "/add_room";
        }
        Rooms rooms = editDataService.createRoom(roomForm);
        logger.info("Create new room"+rooms.toString());
        List<Rooms> roomsList = editDataService.getAllRooms();
        model.addAttribute("roomsList", roomsList);
        return "all_rooms";
    }





}
