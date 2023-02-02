package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.TeddyHouse.model.CustomerController;
import lk.ijse.TeddyHouse.to.Customer;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomerController {
    public JFXTextField cname;
    public JFXTextField cadress;
    public JFXTextField cmobilenumber;
    public Button caddy;
    public Button cancel;

    private String setnextid(){
        try {
            ResultSet set= CustomerController.lastid();
            if (set.next()) {
                String[] c00s = set.getString(1).split("c00");
                int id= Integer.parseInt(c00s[1]);
                id++;
                return "c00"+id;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "c001";
    }

    public void addOnAction(ActionEvent actionEvent) {
        try {
            if(CustomerController.setvalue(new Customer(
               cadress.getText(),
               setnextid(),
               cname.getText(),
               cmobilenumber.getText()

            ))){
               new Alert(Alert.AlertType.CONFIRMATION,"DATA ADDED").show();
                Navigation.close(actionEvent);

                lk.ijse.TeddyHouse.Controller.CustomerController.Instance.settabledata();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void CancelOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    public void namek(KeyEvent keyEvent) {
        if (RegexUtil.regex(cname.getText(),"\\b([a-z]|[A-Z])+")){
            caddy.setDisable(false);
            cname.setFocusColor(Paint.valueOf("white"));
        }else {
            caddy.setDisable(true);
            cname.setFocusColor(Paint.valueOf("red"));

        }
    }

    public void addressk(KeyEvent keyEvent) {
        if (RegexUtil.regex(cadress.getText(),"\\b([a-z]|[A-Z])+")){
            caddy.setDisable(false);
            cadress.setFocusColor(Paint.valueOf("white"));
        }else {
            caddy.setDisable(true);
            cadress.setFocusColor(Paint.valueOf("red"));

        }
    }

    public void mobilek(KeyEvent keyEvent) {
        if (RegexUtil.regex(cmobilenumber.getText(),"0((11)|(7(7|0|8|4|9|1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}")){
            caddy.setDisable(false);
            cmobilenumber.setFocusColor(Paint.valueOf("white"));
        }else {
            caddy.setDisable(true);
            cmobilenumber.setFocusColor(Paint.valueOf("red"));

        }
    }
}
