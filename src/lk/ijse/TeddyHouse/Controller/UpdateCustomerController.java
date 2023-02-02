package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.TeddyHouse.model.CustomerController;
import lk.ijse.TeddyHouse.model.SuppliersController;
import lk.ijse.TeddyHouse.to.Customer;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.sql.SQLException;

public class UpdateCustomerController {
    public JFXTextField name;
    public JFXTextField adress;
    public JFXTextField mobilenumber;
    public Button update;
    public JFXTextField id;

    public static UpdateCustomerController controller;

    public UpdateCustomerController() {
        controller=this;
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        Customer customer=new Customer(
                adress.getText(),
                id.getText(),
                name.getText(),
                mobilenumber.getText()
        );
        try {
            if (CustomerController.update(customer)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                lk.ijse.TeddyHouse.Controller.CustomerController.Instance.settabledata();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        Navigation.close(actionEvent);
    }

    public void setData(String name, String adress, String mobileNumber, String id) {
        this.name.setText(name);
        this.adress.setText(adress);
        this.mobilenumber.setText(mobileNumber);
        this.id.setText(id);
    }

    public void namek(KeyEvent keyEvent) {
        if (RegexUtil.regex(name.getText(),"\\b([a-z]|[A-Z])+")){
            update.setDisable(false);
            name.setFocusColor(Paint.valueOf("white"));
        }else {
            update.setDisable(true);
            name.setFocusColor(Paint.valueOf("red"));

        }

    }

    public void adressk(KeyEvent keyEvent) {
        if (RegexUtil.regex(adress.getText(),"\\b([a-z]|[A-Z])+")){
            update.setDisable(false);
            adress.setFocusColor(Paint.valueOf("white"));
        }else {
            update.setDisable(true);
            adress.setFocusColor(Paint.valueOf("red"));

        }

    }

    public void mobilek(KeyEvent keyEvent) {

        if (RegexUtil.regex(mobilenumber.getText(),"0((11)|(7(7|0|8|4|9|1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}")){
            update.setDisable(false);
            mobilenumber.setFocusColor(Paint.valueOf("white"));
        }else {
            update.setDisable(true);
            mobilenumber.setFocusColor(Paint.valueOf("red"));

        }
    }

    public void idk(KeyEvent keyEvent) {

    }
}
