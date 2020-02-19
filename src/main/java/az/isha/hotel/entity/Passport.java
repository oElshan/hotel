package az.isha.hotel.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "passport")
public class Passport {
    private int id;
    private String path;
    private Client client;



    @OneToOne(
            mappedBy = "passport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



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
                Objects.equals(path, passport.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }
}
