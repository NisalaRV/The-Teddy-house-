package lk.ijse.TeddyHouse.to;

public class Suppliers {
    private String SupplierId;
    private String Name;
    private String Address;
    private String MobileNo;

    public Suppliers(String supplierId, String name, String address, String mobileNo) {
        setSupplierId(supplierId);
        setName(name);
        setAddress(address);
        setMobileNo(mobileNo);
    }

    public Suppliers() {
    }

    public  String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public  String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "SupplierId='" + SupplierId + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", MobileNo='" + MobileNo + '\'' +
                '}';
    }
}




