package az.isha.hotel.repository;

import az.isha.hotel.entity.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {


    List<Booking> findAll();

}
