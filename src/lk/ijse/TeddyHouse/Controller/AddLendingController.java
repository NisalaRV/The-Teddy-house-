package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.TeddyHouse.model.LendingController;
import lk.ijse.TeddyHouse.to.Lending;
import lk.ijse.TeddyHouse.util.DateUtil;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.sql.SQLException;

public class AddLendingController {


    public JFXTextField txtCrustId;
    public JFXTextField txtNic;
    public Button add;
    public Button cancel;

    public void addOnAction(ActionEvent actionEvent) {
        try {
            if (LendingController.addLending(new Lending(
                    txtCrustId.getText(),
                    txtNic.getText(),
                    DateUtil.dateNow(),
                    "0000.00"
            ))){
                lk.ijse.TeddyHouse.Controller.LendingController.controller.settabledata();
                new Alert(Alert.AlertType.CONFIRMATION,"Ok").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        Navigation.close(actionEvent);
    }

    public void CancelOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    public void nick(KeyEvent keyEvent) {
        if (RegexUtil.regex(txtNic.getText(),"^(?:19|20)?\\d{2}[0-9]{10}|[0-9]{9}[x|X|v|V]$")){
            add.setDisable(false);
            txtNic.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            txtNic.setFocusColor(Paint.valueOf("red"));

        }

    }
}
