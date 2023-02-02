package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.Controller.EmployeeFromController;
import lk.ijse.TeddyHouse.to.Suppliers;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SuppliersController {
    public static EmployeeFromController controller;

    public static ResultSet getAllDetails() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM supplier");
    }

    public static boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM supplier WHERE SupplierId =?", id);
    }


    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT SupplierId FROM supplier ORDER BY SupplierId DESC LIMIT 1");
    }

    public static boolean AddSupplier(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO supplier VALUES (?,?,?,?)",
                suppliers.getSupplierId(),
               suppliers. getName(),
               suppliers.getAddress(),
              suppliers.getMobileNo()


        );

    }

    public static boolean update(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE supplier SET Name=? ,Address=?,MobileNo=? WHERE SupplierId=?",
                suppliers.getName(),
                suppliers.getAddress(),
                suppliers.getMobileNo(),
                suppliers.getSupplierId()
                );
    }

    public static ResultSet getAllDetailsSearch(String text) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM supplier WHERE MobileNo LIKE ?",text+"%");
    }
}







