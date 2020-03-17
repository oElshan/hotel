package az.isha.hotel.form;

import javax.validation.constraints.*;

public class BookingForm {

    @NotEmpty(message = "Пустое поле! Введите имя клиента!")
    @Size(max = 50,message = "max size  = 50  ")
    private String fullName;
    @Email
    @Size(max = 50)
    private String email;
    private String gender;
    @NotEmpty(message = "Пустое поле! Введите номер телефона!")
    @Pattern(regexp = "^([0-9]+)$", message = "Ошибка заполнения номера")
    private String phone;
    @NotEmpty(message = "Пустое поле! Введите дату заселения!")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "ошибка даты")
    private String arrive;
    @NotEmpty(message = "Пустое поле! Введите дату выезда!")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "ошибка даты")
    private String depart;
    @NotNull(message = "Пустое поле!Введите количество мест!")
    private Integer seats;
    @NotEmpty(message = "Пустое поле!Введите тип номера!")
    private String type;
    private String address;
    private String comment;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BookingForm{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", arrive=" + arrive +
                ", depart=" + depart +
                ", seats=" + seats +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
