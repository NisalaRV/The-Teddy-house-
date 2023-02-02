package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBookingController implements Initializable {

    public static String cid;
    public JFXTextField id;
    public Button add;
    public Button cancel;
    public JFXTextField pay;

    public void addOnAction(ActionEvent actionEvent) {
        try {
            if (lk.ijse.TeddyHouse.model.LendingController.updateLending(pay.getText(),id.getText())) {
                Navigation.close(actionEvent);
                LendingController.controller.settabledata();
                new Alert(Alert.AlertType.CONFIRMATION, "payed ! ").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public void CancelOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }


    public void namek(KeyEvent keyEvent) {
    }

    public void namek2(KeyEvent keyEvent) {
        if (RegexUtil.regex(pay.getText(),"^([+-]?[0-9]+(?:\\.[0-9]{0,4})?)$")){
            add.setDisable(false);
            pay.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
          pay .setFocusColor(Paint.valueOf("red"));

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setText(cid);
    }
}
