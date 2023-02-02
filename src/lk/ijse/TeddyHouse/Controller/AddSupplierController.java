package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.TeddyHouse.model.ItemController;
import lk.ijse.TeddyHouse.model.SuppliersController;
import lk.ijse.TeddyHouse.to.Item;
import lk.ijse.TeddyHouse.to.Suppliers;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;

public class AddSupplierController {


    public JFXTextField name;
    public JFXTextField adress;
    public JFXTextField mobilenumber;
    public Button cancel;
    public Button add;




    public void addOnAction(ActionEvent actionEvent) {
        try {
            if (SuppliersController.AddSupplier(new Suppliers(
                    supplierNextId(),
                    name.getText(),
                    adress.getText(),
                    mobilenumber.getText()
                    )

            )){
                new Alert(Alert.AlertType.CONFIRMATION,"Add ");
            SupplierController.Controller.settbledata();

            }
        }catch (SQLException | ClassNotFoundException q){
    }
        Navigation.close(actionEvent);
    }

    private String supplierNextId() {
        try {
            ResultSet set=SuppliersController.getLastId();
            if (set.next()){
                String[] s = set.getString(1).split("S");
                int id= Integer.parseInt(s[1]);
                id++;
                return "S"+id;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "S1";
    }

    public void CancelOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    public void namek(KeyEvent keyEvent) {

            if (RegexUtil.regex(name.getText(),"\\b([a-z]|[A-Z])+")){
               add.setDisable(false);
                name.setFocusColor(Paint.valueOf("white"));
            }else {
                add.setDisable(true);
                name.setFocusColor(Paint.valueOf("red"));

            }
    }

    public void adressk(KeyEvent keyEvent) {
        if (RegexUtil.regex(adress.getText(),"\\b([a-z]|[A-Z])+")){
            add.setDisable(false);
            adress.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            adress.setFocusColor(Paint.valueOf("red"));

        }

    }

    public void mobilek(KeyEvent keyEvent) {
        if (RegexUtil.regex(mobilenumber.getText(),"0((11)|(7(7|0|8|4|9|1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}")){
            add.setDisable(false);
            mobilenumber.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            mobilenumber.setFocusColor(Paint.valueOf("red"));

        }

    }
}

