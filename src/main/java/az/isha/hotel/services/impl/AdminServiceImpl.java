package az.isha.hotel.services.impl;

import az.isha.hotel.entity.Roles;
import az.isha.hotel.entity.User;
import az.isha.hotel.form.UserForm;
import az.isha.hotel.repository.UserRepository;
import az.isha.hotel.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public User createNewUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setLogin(userForm.getLogin());
        user.setPassword(userForm.getPassword());
        if (userForm.getRole().equals("admin")) {
            user.setRoles(new Roles("admin"));
        }else user.setRoles(new Roles("user"));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {

    }
}
