package az.isha.hotel.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "guests")
public class Guests {
    private int id;
    private String name;
    private String sn;
    private Timestamp checkIn;
    private Timestamp сheckOut;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;
    private Rooms rooms;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_number",nullable = false)
    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sn")
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Basic
    @Column(name = "check_in")
    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "сheck_out")
    public Timestamp getСheckOut() {
        return сheckOut;
    }

    public void setСheckOut(Timestamp сheckOut) {
        this.сheckOut = сheckOut;
    }

    @Basic
    @Column(name = "date_create")
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "date_update")
    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guests guests = (Guests) o;
        return id == guests.id &&
                Objects.equals(name, guests.name) &&
                Objects.equals(sn, guests.sn) &&
                Objects.equals(checkIn, guests.checkIn) &&
                Objects.equals(сheckOut, guests.сheckOut) &&
                Objects.equals(dateCreate, guests.dateCreate) &&
                Objects.equals(dateUpdate, guests.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sn, checkIn, сheckOut, dateCreate, dateUpdate);
    }
}
