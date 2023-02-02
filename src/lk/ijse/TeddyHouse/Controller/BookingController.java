package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import lk.ijse.TeddyHouse.View.tm.BookingTM;
import lk.ijse.TeddyHouse.model.CustomerController;
import lk.ijse.TeddyHouse.to.Booking;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingController implements Initializable {
    public TableView tbl;
    public TableColumn bid;
    public TableColumn name;
    public TableColumn mobilenumber;
    public TableColumn date;
    public TableColumn price;
    public Text txtTodayCount;
    public JFXTimePicker tPTimeNow;
    public JFXDatePicker dpDateNow;
    public Text txtCrustName;
    public JFXComboBox cmbCrustId;
    public JFXTextField txtPrice;
    public JFXTextField search;
    ObservableList<BookingTM> tm = FXCollections.observableArrayList();

    public void AddbookingOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if(txtPrice.getText()==null | cmbCrustId.getValue()==null | dpDateNow.getValue()==null |tPTimeNow.getValue()==null){

        }else {
            if (Integer.parseInt(txtTodayCount.getText()) < 2) {
                if (lk.ijse.TeddyHouse.model.BookingController.addBooking(new Booking(
                        String.valueOf(cmbCrustId.getValue()),
                        getBookigId(),
                        String.valueOf(tPTimeNow.getValue()),
                        DateNow(),
                        String.valueOf(txtPrice.getText())

                ))) {
                    setTodayBookingCount();
                    new Alert(Alert.AlertType.CONFIRMATION, "Booking Successful ! ").show();
                    settabledata();
                    txtPrice.setText("");
                    txtCrustName.setText("");
                    tPTimeNow.getEditor().clear();
                    dpDateNow.getEditor().clear();
                    cmbCrustId.getItems().clear();
                    setCustIds();
                }
            } else {
                txtPrice.setText("");
                txtCrustName.setText("");
                tPTimeNow.getEditor().clear();
                dpDateNow.getEditor().clear();
                cmbCrustId.getItems().clear();
                setCustIds();
                new Alert(Alert.AlertType.WARNING, "Can't Booking Today ! Already Booking ").show();
        }

        }
    }

    private void setCustIds() {
        ArrayList<String> ids = new ArrayList<>();
        try {
            ResultSet set = CustomerController.getAllId();
            while (set.next()) {
                ids.add(set.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbCrustId.getItems().addAll(ids);
    }

    private String getBookigId() {
        String id = null;
        try {

            ResultSet set = lk.ijse.TeddyHouse.model.BookingController.getIds();
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] B = id.split("B");
                int nextId = Integer.parseInt(B[1]);
                nextId++;
                return "B" + nextId;

            } catch (NullPointerException e) {
                return "B1";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private String DateNow() {
        LocalDate date = dpDateNow.getValue();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCustIds();
        setTodayBookingCount();
        settabledata();
        bid.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mobilenumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void setTodayBookingCount() {
        try {
            ResultSet set = lk.ijse.TeddyHouse.model.BookingController.getTodayBookingCount();
            if (set.next()) {
                txtTodayCount.setText(set.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void settabledata() {
        tbl.getItems().clear();
        try {

            ResultSet set = lk.ijse.TeddyHouse.model.BookingController.getAllDetails();
            while (set.next()) {

                tm.add(new BookingTM(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5)
                ));

            }
            tbl.setItems(tm);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void cusIdonAction(ActionEvent actionEvent) {
        try {
            ResultSet set=CustomerController.getName(String.valueOf(cmbCrustId.getValue()));
            while (set.next()){
                txtCrustName.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void searchId(KeyEvent keyEvent) {
        tbl.getItems().clear();
        tm.clear();
        if (search.getText().equals("")){
            settabledata();
        }else {
            try {

                ResultSet set = lk.ijse.TeddyHouse.model.BookingController.getAllDetailsSearch(search.getText());
                while (set.next()) {

                    tm.add(new BookingTM(set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5)
                    ));

                }
                tbl.setItems(tm);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
