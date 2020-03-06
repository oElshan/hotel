package az.isha.hotel.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RoomForm {

    @NotNull(message = "not null")
   private Integer number;
   private String type;
   private String ac;
   @NotNull(message = "not null")
   private Integer seats;
   @Pattern(regexp = "^\\d+$", message = "Invalid value")
   private String phone;
   @NotNull(message = "not null")
   private Float price;
   private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomForm{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", AC='" + ac + '\'' +
                ", seats=" + seats +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                '}';
    }
}
