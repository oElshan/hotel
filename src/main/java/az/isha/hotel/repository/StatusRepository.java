package az.isha.hotel.repository;

import az.isha.hotel.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {

    Status getStatusByStatus(String status);
    Status getStatusById(Integer id);
}
