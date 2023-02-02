package lk.ijse.TeddyHouse.to;

public class Orders {
    private String OrderId;
    private String date;
    private String total;
    private String CustomerId;
    public Orders() {
    }

    public Orders(String orderId, String date, String total, String customerId) {
        OrderId = orderId;
        this.date = date;
        this.total = total;
        CustomerId = customerId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }



    @Override
    public String toString() {
        return "Orders{" +
                "OrderId='" + OrderId + '\'' +
                ", date='" + date + '\'' +
                ", total='" + total + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                '}';
    }
}
