package az.isha.hotel.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rooms")
public class Rooms {
    private int id;
    private Integer number;
    private int seats;
    private float price;
    private String info;
    private String ac;
    private String phone;
    private String type;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;
    private List<Guests> guests;
    private List<Reservation> reservations;
    private List<Booking> bookings;
    private Status status;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status",nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "rooms",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @OneToMany(mappedBy = "rooms",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(mappedBy = "rooms",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    public List<Guests> getGuests() {
        return guests;
    }

    public void setGuests(List<Guests> guests) {
        this.guests = guests;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    @Basic
    @Column(name = "seats")
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Basic
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "ac")
    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public String toString() {
        return "Rooms{" +
                "number=" + number +
                ", seats=" + seats +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", ac=" + ac +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms rooms = (Rooms) o;
        return id == rooms.id &&
                seats == rooms.seats &&
                Float.compare(rooms.price, price) == 0 &&
                ac == rooms.ac &&
                Objects.equals(number, rooms.number) &&
                Objects.equals(info, rooms.info) &&
                Objects.equals(phone, rooms.phone) &&
                Objects.equals(type, rooms.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, seats, price, info,  dateCreate, dateUpdate);
    }
}
