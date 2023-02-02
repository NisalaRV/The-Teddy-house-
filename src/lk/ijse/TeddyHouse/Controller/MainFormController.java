package lk.ijse.TeddyHouse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;

public class MainFormController {
    public TextField lblUsaerName;
    public PasswordField lblPassword;
    public Button btnLogin;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String userNa0me=lblUsaerName.getText();
       String password=lblPassword.getText();
       if (userNa0me.equals("Admin")&password.equals("1234")){
                   Navigation.swatch("AdminDashBoard.fxml",actionEvent);

       }else if (userNa0me.equals("Cashier")&password.equals("1234")){
            Navigation.swatch("CashierDashBoard.fxml",actionEvent);

        }else {
          new Alert(Alert.AlertType.WARNING,"Wrong Password UserName").show();
        }
    }

    public void userNameOnAction(ActionEvent actionEvent) {
        lblPassword.requestFocus();

    }

    public void passwordOnAction(ActionEvent actionEvent) {
        btnLogin.fire();
    }
}
