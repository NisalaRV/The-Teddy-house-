package lk.ijse.TeddyHouse.model;

import lk.ijse.TeddyHouse.to.Booking;
import lk.ijse.TeddyHouse.util.CrudUtil;
import lk.ijse.TeddyHouse.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingController {
    public static ResultSet getAllDetails() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil(
                "SELECT booking.BookingId,customer.Name,customer.MobileNo,booking.Date,booking.Price FROM customer INNER JOIN booking ON customer.CustomerId = booking.CustomerId");


    }

    public static ResultSet getTodayBookingCount() throws SQLException, ClassNotFoundException {

        return CrudUtil.crudUtil("SELECT count(*)from booking where Date=?", DateUtil.dateNow());
    }

    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT BookingId FROM booking ORDER BY LENGTH(BookingId),BookingId");
    }

    public static boolean addBooking(Booking booking) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO booking VALUES (?,?,?,?,?)",
                booking.getCustomerId(),
                booking.getBookingId(),
                booking.getTime(),
                booking.getDate(),
                booking.getPrice()

                );
    }

    public static ResultSet getAllDetailsSearch(String text) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT booking.BookingId,customer.Name,customer.MobileNo,booking.Date,booking.Price FROM customer INNER JOIN booking ON customer.CustomerId = booking.CustomerId WHERE MobileNo LIKE ?",text+"%");
    }
}
