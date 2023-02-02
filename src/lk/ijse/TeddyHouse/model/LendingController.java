package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.to.Lending;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LendingController {
    public static ResultSet getAllDetails() throws SQLException, ClassNotFoundException {

            return CrudUtil.crudUtil("SELECT lending.CustomerId,customer.Name,customer.Address,lending.NIC,lending.Date,lending.LoanAmount FROM lending INNER JOIN customer on lending.CustomerId = customer.CustomerId");
        }

    public static boolean addLending(Lending lending) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO lending VALUES (?,?,?,?)",
                lending.getCustomerId(),
                lending.getNIC(),
                lending.getDate(),
                lending.getLoanAmount()

                );
    }

    public static boolean updateLending(String text,String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE lending SET LoanAmount=LoanAmount-? WHERE CustomerId=?",text,id);
    }

    public static boolean updateLending1(String amount, String custId) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE lending SET LoanAmount=LoanAmount+? WHERE CustomerId=?",amount,custId);

    }

    public static ResultSet getAllDetailsSeach(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT lending.CustomerId,customer.Name,customer.Address,lending.NIC,lending.Date,lending.LoanAmount FROM lending INNER JOIN customer on lending.CustomerId = customer.CustomerId WHERE  Lending.NIC like ?",id+"%");
    }
}

