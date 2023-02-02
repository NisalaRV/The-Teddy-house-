package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.TeddyHouse.View.tm.LendingTM;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LendingController implements Initializable {
    public static LendingController controller;
    public TableView tbl;
    public TableColumn id;
    public TableColumn name;
    public TableColumn adress;
    public TableColumn nic;
    public TableColumn date;
    public TableColumn loanmount;
    public TableColumn pay;
    public JFXTextField search;
    ObservableList<LendingTM> tm = FXCollections.observableArrayList();

    public LendingController() {
        controller = this;
    }

    public void AddlendingOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddLending.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settabledata();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        adress.setCellValueFactory(new PropertyValueFactory<>("address"));
        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        loanmount.setCellValueFactory(new PropertyValueFactory<>("loanAmount"));
        pay.setCellValueFactory(new PropertyValueFactory<>("pay"));


    }

    public void settabledata() {
        tbl.getItems().clear();
        try {

            ResultSet set = lk.ijse.TeddyHouse.model.LendingController.getAllDetails();
            while (set.next()) {
                Button pay = new Button();


                pay.setText("PAY");

                pay.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: #4374E4;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
                LendingTM lendingTM = new LendingTM(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6), pay);
                tm.add(lendingTM);
                pay.setOnAction(event -> {
                    try {
                        AddBookingController.cid = lendingTM.getId();
                        Navigation.popupNavigation("AddBooking.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            }
            tbl.setItems(tm);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void searchId(KeyEvent keyEvent) {
        tbl.getItems().clear();
        tm.clear();
        if (search.getText().equals("")) {
            settabledata();
        } else {

            try {

                ResultSet set = lk.ijse.TeddyHouse.model.LendingController.getAllDetailsSeach(search.getText());
                while (set.next()) {
                    Button pay = new Button();


                    pay.setText("PAY");

                    pay.setStyle("-fx-background-radius: 20;" +
                            "-fx-background-color: #4374E4;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;");
                    LendingTM lendingTM = new LendingTM(set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5),
                            set.getString(6), pay);
                    tm.add(lendingTM);
                    pay.setOnAction(event -> {
                        try {
                            AddBookingController.cid = lendingTM.getId();
                            Navigation.popupNavigation("AddBooking.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                }
                tbl.setItems(tm);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
