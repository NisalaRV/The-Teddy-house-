package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.TeddyHouse.model.ItemController;
import lk.ijse.TeddyHouse.to.Item;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddStockController {
    public JFXTextField txtName;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;
    public Button cancel;
    public Button add;
    public JFXTextField supplierid;

    public void addOnAction(ActionEvent actionEvent) {
        try {
            if (ItemController.addItem(new Item(
                    nextId(),
                    txtName.getText(),
                    txtPrice.getText(),
                    txtQty.getText()


            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Add ");
                StockController.controller.settbledata();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        Navigation.close(actionEvent);
    }

    private String nextId() {
        try {
            ResultSet set= ItemController.getLastId();
            if (set.next()){
                String[] i00s = set.getString(1).split("i00");
                int id= Integer.parseInt(i00s[1]);
                id++;
                return "i00"+id;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "i001";
    }

    public void CancelOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    public void namek(KeyEvent keyEvent) {
        if (RegexUtil.regex(txtName.getText(),"\\b([a-z]|[A-Z])+")){
            add.setDisable(false);
            txtName.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            txtName.setFocusColor(Paint.valueOf("red"));

        }


    }

    public void qtyk(KeyEvent keyEvent) {
        if (RegexUtil.regex(txtQty.getText(),"^[\\d]{0,15}$")){
            add.setDisable(false);
            txtQty.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            txtQty.setFocusColor(Paint.valueOf("red"));

        }

    }

    public void pricek(KeyEvent keyEvent) {
        if (RegexUtil.regex(txtPrice.getText(),"^([+-]?[0-9]+(?:\\.[0-9]{0,4})?)$")){
            add.setDisable(false);
            txtPrice.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            txtPrice.setFocusColor(Paint.valueOf("red"));

        }

    }
}
