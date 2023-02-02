package lk.ijse.TeddyHouse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CashierDashBoardController implements Initializable {
    public Pane pane1;
    public Text time;
    public Text date;

    public void CashCustomerOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Customer.fxml");
    }

    public void CashOrderOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Orders.fxml");
    }

    public void CashStockOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Stock2.fxml");
    }

    public void CashLendingOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Lending2.fxml");
    }

    public void CashBookingOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Booking.fxml");
    }

    public void CashSignoutOnAction(ActionEvent actionEvent) throws IOException {
      Navigation.swatch("Loginform.fxml",actionEvent);
    }

    private void navigate(String url) throws IOException {
        pane1.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/TeddyHouse/View/" + url));
        Parent root = loader.load();
        pane1.getChildren().add(root);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        setTime();
    }

    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat time2 = new SimpleDateFormat("hh : mm aaa");
                    time.setText(time2.format(new Date()));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }

    private void setDate() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("EEE, MMM d");
        date.setText(dateFormat.format(new Date()));
    }
}
