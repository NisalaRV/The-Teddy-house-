package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.db.DBConnection;
import lk.ijse.TeddyHouse.to.CustomerOrderDetails;
import lk.ijse.TeddyHouse.to.Orders;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersController {
    public static ResultSet getId() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT OrderId FROM orders ORDER BY LENGTH(OrderId),OrderId");
    }

    public static boolean setOrder(Orders orders, ArrayList<CustomerOrderDetails> orderDetails) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (OrdersController.setOrder2(orders)) {
                if (CustomerOrderDetailsController.setData(orderDetails, orders)) {
                    if (ItemController.updateQTY(orderDetails)) {
                        connection.commit();
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return true;
    }

    public static boolean setOrder2(Orders orders) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO orders VALUES (?,?,?,?)",
                orders.getOrderId(),
                orders.getDate(),
                orders.getTotal(),
                orders.getCustomerId()

        );
    }
}
