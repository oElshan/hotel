package az.isha.hotel.services;

import az.isha.hotel.entity.Booking;
import az.isha.hotel.entity.Rooms;
import az.isha.hotel.entity.User;
import az.isha.hotel.form.BookingForm;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.form.StaffForm;
import az.isha.hotel.form.UserForm;

import java.util.List;

public interface EditDataService {

    Booking createNewBooking(BookingForm bookingForm);


    User createNewUser(UserForm userForm);

    void deleteUser(String id);

    Rooms createRoom(RoomForm roomForm);

    List<Rooms> getAllRooms();

    List<Booking> getAllBooking();

    User createNewUser(StaffForm staffForm);

    User findUserByLogin(String login);

    List<User> findAllUsers();
}
