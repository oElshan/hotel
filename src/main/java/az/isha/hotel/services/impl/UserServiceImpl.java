package az.isha.hotel.services.impl;

import az.isha.hotel.entity.User;
import az.isha.hotel.repository.UserRepository;
import az.isha.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepository userRepository;


    @Override
    public User findUserByLogin(final String login) {
     return  userRepository.findUserByLogin(login);
    }
}
