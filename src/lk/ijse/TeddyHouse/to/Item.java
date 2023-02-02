package lk.ijse.TeddyHouse.to;

public class Item {
    private String ItemId;
    private String ITemName;
    private String unitPrice;
    private String qty;

    public Item(String itemId, String ITemName, String unitPrice, String qty) {
        ItemId = itemId;
        this.ITemName = ITemName;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public Item() {
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getITemName() {
        return ITemName;
    }

    public void setITemName(String ITemName) {
        this.ITemName = ITemName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemId='" + ItemId + '\'' +
                ", ITemName='" + ITemName + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
