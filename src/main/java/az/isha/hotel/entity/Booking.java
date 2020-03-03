package az.isha.hotel.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking {
    private int id;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private String name;
    private String phone;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;
    private String email;
    private User user;
    private Rooms rooms;


    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rooms",nullable = false)
    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "check_in")
    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "check_out")
    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        Booking booking = (Booking) o;
        return id == booking.id  &&
                Objects.equals(name, booking.name)  &&
                Objects.equals(checkIn, booking.checkIn) &&
                Objects.equals(checkOut, booking.checkOut) &&
                Objects.equals(phone, booking.phone) &&
                Objects.equals(dateCreate, booking.dateCreate) &&
                Objects.equals(dateUpdate, booking.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkIn, checkOut, name, phone,  dateCreate, dateUpdate);
    }
}
