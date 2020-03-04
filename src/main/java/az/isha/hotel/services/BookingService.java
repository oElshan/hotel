package az.isha.hotel.services;

import az.isha.hotel.entity.Booking;
import az.isha.hotel.form.NewBookingForm;
import az.isha.hotel.model.CurrentUser;

public interface BookingService {

    Booking createBooking(NewBookingForm bookingForm, CurrentUser currentUser);

}
