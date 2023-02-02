package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.TeddyHouse.View.tm.CustomerTm;
import lk.ijse.TeddyHouse.to.Customer;
import lk.ijse.TeddyHouse.util.CrudUtil;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    public static CustomerController Instance;
    public TableColumn id;
    public TableColumn name;
    public TableColumn address;
    public TableColumn mobilenumber;
    public TableView tbl;
    public TableColumn delete;
    public TableColumn update;
    public JFXTextField Search;
    ObservableList<CustomerTm> tm = FXCollections.observableArrayList();

    public CustomerController() {
        Instance = this;
    }

    private static boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM customer WHERE CustomerId=?", id);
    }

    public void addOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddCustomer.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settabledata();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("adress"));
        mobilenumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        update.setCellValueFactory(new PropertyValueFactory<>("update"));

    }

    public void settabledata() {
        tbl.getItems().clear();
        try {

            ResultSet set = lk.ijse.TeddyHouse.model.CustomerController.getAllDetails();
            while (set.next()) {
                Button update = new Button();
                Button delete = new Button();

                update.setText("UPDATE");
                delete.setText("DELETE");
                delete.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: red;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
                update.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: #4374E4;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
                CustomerTm customerTm = new CustomerTm(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4), delete, update
                );
                tm.add(customerTm);
                tbl.setItems(tm);
                delete.setOnAction(event -> {
                    try {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                        alert.showAndWait();

                        if (alert.getResult().equals(ButtonType.YES)) {


                            if (CustomerController.deleteEmployee(customerTm.getId())) {
                                new Alert(Alert.AlertType.CONFIRMATION, "DELETED").show();
                                settabledata();
                            }
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                });
                update.setOnAction(event -> {
                    try {
                        Navigation.popupNavigation("UpdateCustomer.fxml");
                        UpdateCustomerController.controller.setData(customerTm.getName(), customerTm.getAdress(), customerTm.getMobileNumber(), customerTm.getId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void searchName(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        tbl.getItems().clear();
        tm.clear();
        if (Search.getText().equals("")) {
            settabledata();
        } else {
            ResultSet set = lk.ijse.TeddyHouse.model.CustomerController.getAllDetailsSearch(Search.getText());
            while (set.next()) {
                Button update = new Button();
                Button delete = new Button();

                update.setText("UPDATE");
                delete.setText("DELETE");
                delete.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: red;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
                update.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: #4374E4;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
                CustomerTm customerTm=new CustomerTm(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4), delete, update
                );
                tm.add(customerTm);
                tbl.setItems(tm);
                delete.setOnAction(event -> {
                    try {
                        Alert alert=new Alert(Alert.AlertType.WARNING,"ARE YOU SURE", ButtonType.YES,ButtonType.NO);
                        alert.showAndWait();

                        if (alert.getResult().equals(ButtonType.YES)){



                            if(CustomerController.deleteEmployee(customerTm.getId())){
                                new Alert(Alert.AlertType.CONFIRMATION,"DELETED").show();
                                settabledata();
                            }
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                });
                update.setOnAction(event -> {
                    try {
                        Navigation.popupNavigation("UpdateCustomer.fxml");
                        UpdateCustomerController.controller.setData(customerTm.getName(),customerTm.getAdress(),customerTm.getMobileNumber(),customerTm.getId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}

