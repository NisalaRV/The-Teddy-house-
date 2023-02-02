package lk.ijse.TeddyHouse.to;

public class CustomerOrderDetails {
    private String OrderId;
    private String itemId;
    private String qty;
    private String unitPrice;

    public CustomerOrderDetails() {
    }

    public CustomerOrderDetails(String orderId, String itemId, String qty, String unitPrice) {
        OrderId = orderId;
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "CustomerOrderDetails{" +
                "OrderId='" + OrderId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", qty='" + qty + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
