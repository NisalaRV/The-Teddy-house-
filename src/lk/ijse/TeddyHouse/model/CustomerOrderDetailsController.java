package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.to.CustomerOrderDetails;
import lk.ijse.TeddyHouse.to.Orders;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerOrderDetailsController {
    public static boolean setData(ArrayList<CustomerOrderDetails> orderDetails, Orders orders) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (CrudUtil.crudUtil("INSERT INTO customerorderdetails VALUES (?,?,?,?)",
                    orders.getOrderId(),
                    orderDetails.get(i).getItemId(),
                    orderDetails.get(i).getQty(),
                    orderDetails.get(i).getUnitPrice()

            )) {
            } else {
                return false;
            }
        }
        return true;
    }
}
