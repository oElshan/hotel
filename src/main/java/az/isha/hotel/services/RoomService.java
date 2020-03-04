package az.isha.hotel.services;

import az.isha.hotel.entity.Rooms;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {
    Rooms createRoom(RoomForm roomForm);

    List<Rooms> getAll();


}
