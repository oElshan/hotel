package az.isha.hotel.repository;

import az.isha.hotel.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository  extends CrudRepository<User,Long> {
    User findUserByLogin(String login);
    User findUserByName(String login);
    List<User> findAll();
}
