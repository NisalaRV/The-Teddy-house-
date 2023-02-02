package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.to.CustomerOrderDetails;
import lk.ijse.TeddyHouse.to.Item;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemController {
    private static Object SQLException;
    private static Object ClassNotFoundException;

    public static ResultSet getAllDetails() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM item");


    }

    public static boolean deleteStock(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM item WHERE ItemId=?", id);
    }

    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT ItemId FROM item ORDER BY ItemId DESC limit 1");
    }

    public static boolean addItem(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO item VALUES (?,?,?,?)",
                item.getItemId(),
                item.getITemName(),
                item.getUnitPrice(),
                item.getQty()

        );
    }

    public static boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE item SET ITemName=?,unitPrice=?,qty=? WHERE ItemId=?",
                item.getITemName(),
                item.getUnitPrice(),
                item.getQty(),
                item.getItemId()
        );
    }

    public static boolean updateQTY(ArrayList<CustomerOrderDetails> orderDetails) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (CrudUtil.crudUtil("UPDATE item SET qty=qty-? WHERE ItemId=?",
                    orderDetails.get(i).getQty(),
                    orderDetails.get(i).getItemId()
            )) {
            } else {
                return false;
            }

        }
        return true;
    }

    public static ResultSet getAllId() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT  ItemId FROM item");
    }

    public static ResultSet getTotalName(String id) throws SQLException, ClassNotFoundException {

        return CrudUtil.crudUtil("SELECT ITemName,unitPrice FROM item WHERE ItemId=?",id);
    }

    public static ResultSet getAllDetailsSearch(String text) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM item WHERE ITemName LIKE ?",text+"%");
    }
}
