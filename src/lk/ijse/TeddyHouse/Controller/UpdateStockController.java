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
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.sql.SQLException;

public class UpdateStockController {

    public JFXTextField id;
    public JFXTextField name;
    public JFXTextField qty;
    public JFXTextField price;
    public  static UpdateStockController controller;
    public Button update;

    public UpdateStockController() {
        controller=this;
    }

    public void updateOnAction(ActionEvent actionEvent) {
        Item item=new Item(
                id.getText(),
                name.getText(),
                price.getText(),
                qty.getText()
        );
        try {
            if (ItemController.update(item)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                StockController.controller.settbledata();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        Navigation.close(actionEvent);
    }

    public void setData(String id, String name, String price, String qty) {
        this.id.setText(id);
        this.name.setText(name);
        this.price.setText(price);
        this.qty.setText(qty);
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

    public void qtyk(KeyEvent keyEvent) {
        if (RegexUtil.regex(qty.getText(),"^[\\d]{0,15}$")){
            update.setDisable(false);
            qty.setFocusColor(Paint.valueOf("white"));
        }else {
            update.setDisable(true);
            qty.setFocusColor(Paint.valueOf("red"));

        }

    }

    public void pricek(KeyEvent keyEvent) {
        if (RegexUtil.regex(price.getText(),"^([+-]?[0-9]+(?:\\.[0-9]{0,4})?)$")){
            update.setDisable(false);
            price.setFocusColor(Paint.valueOf("white"));
        }else {
            update.setDisable(true);
            price.setFocusColor(Paint.valueOf("red"));

        }
    }
}
