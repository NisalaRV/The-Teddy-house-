package lk.ijse.TeddyHouse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import lk.ijse.TeddyHouse.model.CustomerController;
import lk.ijse.TeddyHouse.model.LendingController;
import lk.ijse.TeddyHouse.to.CustomerOrderDetails;
import lk.ijse.TeddyHouse.to.Orders;
import lk.ijse.TeddyHouse.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddToLendingController implements Initializable {
    public static String id;
    public static String amount;
    public static String date;
    public static String custId;
    public static ArrayList<CustomerOrderDetails> orderDetails;
    public Button add;
    public Button lending;

    public void addOnAction(ActionEvent actionEvent) {
        try {
            if (lk.ijse.TeddyHouse.model.OrdersController.setOrder(new Orders(
                            id,
                            date,
                            amount,
                            custId),
                    orderDetails

            )) {
                OrdersController.controller.tbl.getItems().clear();
                OrdersController.controller.comboNum.getItems().clear();
                OrdersController.controller.setCustNum();
                OrdersController.controller.txtTotal.setText("0.00");
                Navigation.close(actionEvent);
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addToLendingOnAction(ActionEvent actionEvent) {
        try {
            if (LendingController.updateLending1(amount, custId)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                Navigation.close(actionEvent);
                OrdersController.controller.tbl.getItems().clear();
                OrdersController.controller.comboNum.getItems().clear();
                OrdersController.controller.setCustNum();
                OrdersController.controller.txtTotal.setText("0.00");

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkLending();
    }

    private void checkLending() {
        System.out.println(custId);
        try {
            if (CustomerController.existCustomer(custId)){
                lending.setVisible(true);
            }else {
                lending.setVisible(false);
            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
