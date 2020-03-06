package az.isha.hotel.services.impl;

import az.isha.hotel.entity.*;
import az.isha.hotel.form.BookingForm;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.form.UserForm;
import az.isha.hotel.repository.BookingRepository;
import az.isha.hotel.repository.RoomRepository;
import az.isha.hotel.repository.StatusRepository;
import az.isha.hotel.repository.UserRepository;
import az.isha.hotel.services.EditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class EditDataServiceImp implements EditDataService {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional
    public Booking createNewBooking(BookingForm bookingForm) {
        Booking booking = new Booking();
        booking.setName(bookingForm.getFullName());
        booking.setEmail(bookingForm.getEmail());
        booking.setPhone(bookingForm.getPhone());
        booking.setType(bookingForm.getType());
        booking.setSeats(bookingForm.getSeats());
        booking.setCheckIn(Date.valueOf(bookingForm.getArrive()));
        booking.setCheckOut(Date.valueOf(bookingForm.getDepart()));
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findUserByName(username);
        booking.setUser(user);
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    @Transactional
    public User createNewUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setLogin(userForm.getLogin());
        user.setPassword(userForm.getPassword());
        if (userForm.getRole().equals("admin")) {
            user.setRoles(new Roles("admin"));
        }else user.setRoles(new Roles("user"));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {

    }

    @Transactional
    @Override
    public Rooms createRoom(RoomForm roomForm) {
        Rooms rooms = new Rooms();
        rooms.setNumber(roomForm.getNumber());
        rooms.setSeats(roomForm.getSeats());
        rooms.setPrice(roomForm.getPrice());
        rooms.setInfo(roomForm.getInfo());
        rooms.setAc(roomForm.getAc());
        rooms.setPhone(roomForm.getPhone());
        rooms.setType(roomForm.getType());
//        rooms.setStatus(repository.getStatusByStatus("Free"));
//        Status status = statusRepository.getStatusByStatus("Free");
        Status status = statusRepository.getStatusById(1);
        rooms.setStatus(status);
        return roomRepository.save(rooms);
    }

    public List<Rooms> getAllRooms() {
        return roomRepository.getAllrooms();
    }

    @Override
    public User findUserByLogin(final String login) {
        return  userRepository.findUserByLogin(login);
    }
}
