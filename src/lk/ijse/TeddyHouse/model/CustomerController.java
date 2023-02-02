package lk.ijse.TeddyHouse.model;

import javafx.scene.control.TableColumn;
import lk.ijse.TeddyHouse.to.Customer;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    public static ResultSet getAllDetails() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM customer");
    }

    public static ResultSet lastid() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT CustomerId FROM customer ORDER BY CustomerId desc LIMIT 1");

    }

    public static boolean setvalue(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO customer VALUES(?,?,?,?)",
                customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getMobileNo()
        );
    }

    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE customer SET Name=?,Address=?,MobileNo=? WHERE CustomerId=?",
                customer.getName(),
                customer.getAddress(),
                customer.getMobileNo(),
                customer.getCustomerId()
        );
    }

    public static ResultSet getAllId() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT CustomerId  FROM customer");
    }

    public static ResultSet getName(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT Name  FROM customer WHERE CustomerId=?", s);
    }

    public static boolean existCustomer(String id) throws SQLException, ClassNotFoundException {

        ResultSet set = CrudUtil.crudUtil("SELECT * FROM lending WHERE CustomerId=?", id);
        if (set.next())
            return set.getString(1) == null ? false : true;
        return false;
    }

    public static ResultSet getAllDetailsSearch(String text) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM customer WHERE MobileNo LIKE ?",text+"%");
    }
}
