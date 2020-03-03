package az.isha.hotel.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {
    private int id;
    private String status;
    private List<Rooms> rooms;

    @OneToMany(mappedBy = "status",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return id == status1.id &&
                Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
