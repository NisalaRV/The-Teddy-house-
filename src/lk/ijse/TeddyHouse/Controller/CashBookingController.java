package lk.ijse.TeddyHouse.Controller;

import javafx.event.ActionEvent;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;

public class CashBookingController {
    public void AddbookingOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddBooking.fxml");
    }
}
