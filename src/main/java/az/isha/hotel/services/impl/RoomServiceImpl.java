package az.isha.hotel.services.impl;

import az.isha.hotel.entity.Rooms;
import az.isha.hotel.entity.Status;
import az.isha.hotel.form.RoomForm;
import az.isha.hotel.repository.RoomRepository;
import az.isha.hotel.repository.StatusRepository;
import az.isha.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Persistence;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StatusRepository statusRepository;

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
        System.out.println("-------------"+status.toString()+"--------------");
        rooms.setStatus(status);
        return roomRepository.save(rooms);
    }

    public List<Rooms> getAll() {
        return roomRepository.getAllrooms();
    }
}
