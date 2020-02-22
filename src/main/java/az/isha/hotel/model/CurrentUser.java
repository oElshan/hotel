package az.isha.hotel.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CurrentUser extends User {

    private String login;
    private Long id;
    private  String ROLES;


    public CurrentUser(az.isha.hotel.entity.User user) {
//        super(username, password, authorities);

        super(user.getName(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRoles().getName())) );
        this.login = user.getLogin();
        this.id = user.getId();
        this.ROLES = user.getRoles().getName();
    }

    public String getROLES() {
        return ROLES;
    }

    public void setROLES(String ROLES) {
        this.ROLES = ROLES;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
