package lk.ijse.TeddyHouse.View.tm;


import javafx.scene.control.Button;

public class CustomerTm {
    private String id;
    private String name;
    private String adress;
    private String mobileNumber;
    private Button delete;
    private Button update;

    public CustomerTm(String id, String name, String adress, String mobileNumber, Button delete, Button update) {
        this.setId(id);
        this.setName(name);
        this.setAdress(adress);
        this.setMobileNumber(mobileNumber);
        this.setDelete(delete);
        this.setUpdate(update);
    }

    public CustomerTm() {
    }

    public  String getId() {
        return id  ;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
        return "CustomerTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", delete=" + delete +
                ", update=" + update +
                '}';
    }
}
