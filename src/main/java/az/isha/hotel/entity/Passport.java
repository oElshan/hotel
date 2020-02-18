package az.isha.hotel.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "passport")
public class Passport {
    private int id;
    private int idClient;
    private String path;
    // TODO: 2020-02-18 ввести свзязь!!


    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_client")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id &&
                idClient == passport.idClient &&
                Objects.equals(path, passport.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, path);
    }
}
