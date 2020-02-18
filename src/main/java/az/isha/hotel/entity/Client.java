package az.isha.hotel.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {
    private int id;
    private int name;
    private Date dob;
    private int idGender;
    private String sn;
    private Integer phone;
    private Integer idPassport;
    private Timestamp dateCreate;
    private Timestamp dateUpdate;
    private List<Reservation> reservations;
    private Passport passport;
    private Gender gender;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_passport",nullable = false)
    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gender",nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Basic
    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "id_gender")
    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
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
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "id_passport")
    public Integer getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(Integer idPassport) {
        this.idPassport = idPassport;
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
        Client client = (Client) o;
        return id == client.id &&
                name == client.name &&
                idGender == client.idGender &&
                Objects.equals(dob, client.dob) &&
                Objects.equals(sn, client.sn) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(idPassport, client.idPassport) &&
                Objects.equals(dateCreate, client.dateCreate) &&
                Objects.equals(dateUpdate, client.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob, idGender, sn, phone, idPassport, dateCreate, dateUpdate);
    }
}
