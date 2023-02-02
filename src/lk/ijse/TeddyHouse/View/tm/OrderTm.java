package lk.ijse.TeddyHouse.View.tm;

public class OrderTm {
    private String id;
    private String name;
    private String qty;
    private String price;

    public OrderTm() {
    }

    public OrderTm(String id, String name, String qty, String price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
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

    @Override
    public String toString() {
        return "OrderTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
