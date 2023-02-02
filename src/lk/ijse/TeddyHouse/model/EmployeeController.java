package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.to.Employee;
import lk.ijse.TeddyHouse.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController{

    public static ResultSet getAllDetails() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM employee");
    }

    public static ResultSet getlastid() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT EmployeeId from employee order by  EmployeeId desc limit 1");
    }

    public static boolean setValue(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO employee VALUES (?,?,?,?,?)",employee.getEmployeeId(),employee.getName(),employee.getIdCardNumber(),employee.getAddress(),employee.getMobileNo());
    }

    public static boolean deleteemplyoee(String id) throws SQLException, ClassNotFoundException {
        System.out.println(id);
      return CrudUtil.crudUtil("DELETE FROM employee WHERE EmployeeId =?",id);

    }

    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE employee SET Name=?,IdCardNumber=?,Address=?,MobileNo=? WHERE EmployeeId=?",
                employee.getName(),
                employee.getIdCardNumber(),
                employee.getAddress(),
                employee.getMobileNo(),
                employee.getEmployeeId()

                );
    }

    public static ResultSet searchID(String text) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM employee WHERE EmployeeId LIKE ?",text+"%");
    }

}
