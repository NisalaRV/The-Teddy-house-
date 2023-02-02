package lk.ijse.TeddyHouse.to;

public class SupplierOrders {
    private String SupplierOrderId;
    private String date;
    private String SupplierId;

    public SupplierOrders(String supplierOrderId, String date, String supplierId) {
        setSupplierOrderId(supplierOrderId);
        this.setDate(date);
        setSupplierId(supplierId);
    }

    public SupplierOrders() {
    }

    public String getSupplierOrderId() {
        return SupplierOrderId;
    }

    public void setSupplierOrderId(String supplierOrderId) {
        SupplierOrderId = supplierOrderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    @Override
    public String toString() {
        return "SupplierOrders{" +
                "SupplierOrderId='" + SupplierOrderId + '\'' +
                ", date='" + date + '\'' +
                ", SupplierId='" + SupplierId + '\'' +
                '}';
    }
}
