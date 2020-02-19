package az.isha.hotel.services;

import az.isha.hotel.entity.User;
import az.isha.hotel.form.UserForm;

public interface AdminService {

    User createNewUser(UserForm userForm);

    void deleteUser(String id);

}
