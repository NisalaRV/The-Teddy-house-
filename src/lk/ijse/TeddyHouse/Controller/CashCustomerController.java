package lk.ijse.TeddyHouse.Controller;

import javafx.event.ActionEvent;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;

public class CashCustomerController {
    public void addOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddCustomer.fxml");
    }
}
