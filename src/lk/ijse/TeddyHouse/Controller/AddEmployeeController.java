package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.TeddyHouse.model.EmployeeController;
import lk.ijse.TeddyHouse.to.Employee;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    public JFXTextField name;
    public JFXTextField adress;
    public JFXTextField mobilenumber;
    public JFXTextField nic;
    public Text id;
    public Button cancel;
    public Button add;


    public void addOnAction(ActionEvent actionEvent) {

        try {
            if (EmployeeController.setValue(new Employee(

                    id.getText(),name.getText(),nic.getText(),adress.getText(),mobilenumber.getText()
            ))){
                Navigation.close(actionEvent);

               EmployeeFromController.getInstance().settbledata();
                new Alert(Alert.AlertType.CONFIRMATION,"DATA ADDED");
            }else {
                new Alert(Alert.AlertType.ERROR,"ERROR");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setid();

    }

    private void setid() {
        try {
            ResultSet set = EmployeeController.getlastid();
            if (set.next()) {
                String[] e00s = set.getString(1).split("e00");
                int id = Integer.parseInt(e00s[1]);
                id++;
                this.id.setText("e00" + id);
            } else {
                id.setText("e001");
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

    public void namekey(KeyEvent keyEvent) {
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

    public void nicl(KeyEvent keyEvent) {
        if (RegexUtil.regex(nic.getText(),"^(?:19|20)?\\d{2}[0-9]{10}|[0-9]{9}[x|X|v|V]$")){
            add.setDisable(false);
            nic.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
           nic.setFocusColor(Paint.valueOf("red"));

        }


    }
}
