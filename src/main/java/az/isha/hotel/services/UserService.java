package az.isha.hotel.services;

import az.isha.hotel.entity.User;

public interface UserService {
    User findUserByLogin(String login);
}
