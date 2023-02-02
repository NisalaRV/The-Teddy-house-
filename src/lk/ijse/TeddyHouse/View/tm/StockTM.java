package lk.ijse.TeddyHouse.View.tm;

import javafx.scene.control.Button;

public class StockTM {
    private String id;
    private String name;
    private String price;
    private String qty;
    private Button delete;
    private Button update;

    public StockTM(String id, String name, String qty, String price, Button delete, Button update) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQty(qty);
        this.setDelete(delete);
        this.setUpdate(update);
    }

    public StockTM() {
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

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        return "StockTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", price='" + price + '\'' +
                ", delete=" + delete +
                ", update=" + update +
                '}';
    }
}
