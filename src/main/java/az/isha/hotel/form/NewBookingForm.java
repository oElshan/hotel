package az.isha.hotel.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NewBookingForm {

    @NotNull
    @Size(max = 100)
    private String fullName;
    @Email
    @Size(max = 100)
    private String email;
    private String gender;
    @Pattern(regexp = "([0-9]+) ", message = "Ошибка заполнения номера")
    private String mobileNumber;
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "ошибка даты")
    private String arrive;
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "ошибка даты")
    private String depart;
    private Integer noOfPersons;
    private String roomType;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public Integer getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(Integer noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
        return "NewBookingForm{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", arrive=" + arrive +
                ", depart=" + depart +
                ", noOfPersons=" + noOfPersons +
                ", roomType='" + roomType + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
