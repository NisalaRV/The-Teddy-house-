package lk.ijse.TeddyHouse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminDashBoardController implements Initializable {
    public Pane pane;
    public Text time;
    public Text date;
    public Button btn;

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        navigate("EmployeeFrom.fxml");
    }
    private void navigate(String url) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/TeddyHouse/View/"+url));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }

    public void employeesOnAction(ActionEvent actionEvent) throws IOException {

        navigate("EmployeeFrom.fxml");

    }

    public void CustomersOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Customer.fxml");
    }

    public void SuppliersOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Supplier.fxml");
    }

    public void StockOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Stock.fxml");
    }

    public void OrdersOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Orders.fxml");
    }

    public void LendingOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Lending.fxml");
    }

   // public void ReportsOnAction(ActionEvent actionEvent) throws IOException {
   //     navigate("Report.fxml");
  //  }

    public void BookingsOnAction(ActionEvent actionEvent) throws IOException {
        navigate("Booking.fxml");
    }

    public void SignoutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.swatch("Loginform.fxml",actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        setTime();
        btn.fire();
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
