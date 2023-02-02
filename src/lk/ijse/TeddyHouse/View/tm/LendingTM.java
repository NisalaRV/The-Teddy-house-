package lk.ijse.TeddyHouse.View.tm;

import javafx.scene.control.Button;

public class LendingTM {
    private String id;
    private String name;
    private String address;
    private String nic;
    private String date;
    private String loanAmount;
    private Button  pay;

    public LendingTM(String id, String name, String address, String nic, String date, String loanAmount, Button pay) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setNic(nic);
        this.setDate(date);
        this.setLoanAmount(loanAmount);
        this.setPay(pay);
    }

    public LendingTM() {
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Button getPay() {
        return pay;
    }

    public void setPay(Button pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "LendingTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", date='" + date + '\'' +
                ", loanAmount='" + loanAmount + '\'' +
                ", pay=" + pay +
                '}';
    }
}
