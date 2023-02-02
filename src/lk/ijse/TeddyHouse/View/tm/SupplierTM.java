package lk.ijse.TeddyHouse.View.tm;

import javafx.scene.control.Button;

public class SupplierTM {
    private String id;
    private String name;
    private String address;
    private String mobileNumber;
    private Button delete;
    private Button update;

    public SupplierTM(String id, String name, String address, String mobileNumber, Button delete, Button update) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setMobileNumber(mobileNumber);
        this.setDelete(delete);
        this.setUpdate(update);
    }

    public SupplierTM() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "SupplierTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", delete=" + delete +
                ", update=" + update +
                '}';
    }
}
