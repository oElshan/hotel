package az.isha.hotel.repository;

import az.isha.hotel.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepository extends CrudRepository<Client, Long> {


    Client findByName(String name);

}
