package lk.ijse.TeddyHouse.View.tm;

public class BookingTM {
    private String id;
    private String name;
    private String MobileNumber;
    private String date;
    private String price;

    public BookingTM(String id, String name, String mobileNumber, String date, String price) {
        this.setId(id);
        this.setName(name);
        setMobileNumber(mobileNumber);
        this.setDate(date);
        this.setPrice(price);
    }

    public BookingTM() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookingTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", MobileNumber='" + MobileNumber + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
