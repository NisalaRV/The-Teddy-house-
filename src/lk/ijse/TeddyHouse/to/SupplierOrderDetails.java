package lk.ijse.TeddyHouse.to;

public class SupplierOrderDetails {
    private String SupplierOrderId;
    private String SupplierId;
    private String qty;
    private String date;

    public SupplierOrderDetails(String supplierOrderId, String supplierId, String qty, String date) {
        setSupplierOrderId(supplierOrderId);
        setSupplierId(supplierId);
        this.setQty(qty);
        this.setDate(date);
    }

    public SupplierOrderDetails() {
    }

    public String getSupplierOrderId() {
        return SupplierOrderId;
    }

    public void setSupplierOrderId(String supplierOrderId) {
        SupplierOrderId = supplierOrderId;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SupplierOrderDetails{" +
                "SupplierOrderId='" + SupplierOrderId + '\'' +
                ", SupplierId='" + SupplierId + '\'' +
                ", qty='" + qty + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
