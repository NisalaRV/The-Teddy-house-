package lk.ijse.TeddyHouse.to;

public class Booking {
    private String CustomerId;
    private String BookingId;
    private String time;
    private String Date;
    private String Price;

    public Booking(String customerId, String bookingId, String time, String date, String price) {
        setCustomerId(customerId);
        setBookingId(bookingId);
        this.setTime(time);
        setDate(date);
        setPrice(price);
    }

    public Booking() {
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "CustomerId='" + CustomerId + '\'' +
                ", BookingId='" + BookingId + '\'' +
                ", time='" + time + '\'' +
                ", Date='" + Date + '\'' +
                ", Price='" + Price + '\'' +
                '}';
    }
}
