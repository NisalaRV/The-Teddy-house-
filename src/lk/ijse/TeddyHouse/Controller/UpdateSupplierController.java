package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import lk.ijse.TeddyHouse.model.SuppliersController;
import lk.ijse.TeddyHouse.to.Suppliers;
import lk.ijse.TeddyHouse.util.Navigation;

import java.sql.SQLException;

public class UpdateSupplierController {
    public JFXTextField name;
    public JFXTextField adress;
    public JFXTextField mobilenumber;
    public Button update;
    public JFXTextField id;

    public static UpdateSupplierController controller;
    public UpdateSupplierController() {
        controller=this;
    }

    public void setData(String name, String address, String number , String id) {
        this.name.setText(name);
        adress.setText(address);
        mobilenumber.setText(number);
        this.id.setText(id);
    }

    public void updateOnAction(ActionEvent actionEvent) {
        Suppliers suppliers = new Suppliers(
                id.getText(),
                name.getText(),
                adress.getText(),
                mobilenumber.getText()
        );
        try {
            if (SuppliersController.update(suppliers)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                SupplierController.Controller.settbledata();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        Navigation.close(actionEvent);
    }
}
