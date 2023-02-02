package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.TeddyHouse.View.tm.CustomerTm;
import lk.ijse.TeddyHouse.View.tm.EmployeeTM;
import lk.ijse.TeddyHouse.model.EmployeeController;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeFromController implements Initializable {
    static EmployeeFromController Instance;
    public TableColumn id;
    public TableColumn name;
    public TableColumn nic;
    public TableColumn address;
    public TableColumn mobilenumber;
    public TableColumn delete;
    public TableColumn update;
    public TableView tbl;
    public JFXTextField search;
    ObservableList<EmployeeTM> tm = FXCollections.observableArrayList();

    public EmployeeFromController() {
        Instance = this;


    }

    public static EmployeeFromController getInstance() {
        return Instance;
    }


    public void Addemployee(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddEmployee.fxml");
    }

    public void Updateemployee(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("UpdateEmployee.fxml");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settbledata();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        address.setCellValueFactory(new PropertyValueFactory<>("adress"));
        mobilenumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        update.setCellValueFactory(new PropertyValueFactory<>("update"));
    }


    public void settbledata() {
        tbl.getItems().clear();
        try {
            ResultSet set = EmployeeController.getAllDetails();
            while (set.next()) {
                Button update = new Button();
                Button delete = new Button();

                update.setText("UPDATE");
                delete.setText("DELETE");
                delete.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: red;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");
                update.setStyle("-fx-background-radius: 20;" +
                        "-fx-background-color: #4374E4;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;");

                EmployeeTM employeeTM = new EmployeeTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        delete,
                        update
                );
                tm.add(employeeTM);

                delete.setOnAction(event -> {
                    try {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                        alert.showAndWait();

                        if (alert.getResult().equals(ButtonType.YES)) {

                            System.out.println(employeeTM.getId());

                            if (EmployeeController.deleteemplyoee(employeeTM.getId())) {
                                new Alert(Alert.AlertType.CONFIRMATION, "DELETED").show();
                                settbledata();
                            }
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }


                });
                update.setOnAction(event -> {
                    try {
                        Navigation.popupNavigation("UpdateEmployee.fxml");
                        UpdateEmployeeController.controller.setData(employeeTM.getName(), employeeTM.getAdress(), employeeTM.getMobileNumber(), employeeTM.getNic(), employeeTM.getId());
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


    public void searchiId(KeyEvent keyEvent) {
        tbl.getItems().clear();
        tm.clear();
        if (search.getText().equals("")) {
            settbledata();
        }else {
//            ++++++++++++++++++++++++++++++++++++++++
            try {
                ResultSet set = EmployeeController.searchID(search.getText());
                while (set.next()) {
                    Button update = new Button();
                    Button delete = new Button();

                    update.setText("UPDATE");
                    delete.setText("DELETE");
                    delete.setStyle("-fx-background-radius: 20;" +
                            "-fx-background-color: red;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;");
                    update.setStyle("-fx-background-radius: 20;" +
                            "-fx-background-color: #4374E4;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;");

                    EmployeeTM employeeTM = new EmployeeTM(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5),
                            delete,
                            update
                    );
                    tm.add(employeeTM);
                    tbl.refresh();

                    delete.setOnAction(event -> {
                        try {
                            Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                            alert.showAndWait();

                            if (alert.getResult().equals(ButtonType.YES)) {

                                System.out.println(employeeTM.getId());

                                if (EmployeeController.deleteemplyoee(employeeTM.getId())) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "DELETED").show();
                                    settbledata();
                                }
                            }

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }


                    });
                    update.setOnAction(event -> {
                        try {
                            Navigation.popupNavigation("UpdateEmployee.fxml");
                            UpdateEmployeeController.controller.setData(employeeTM.getName(), employeeTM.getAdress(), employeeTM.getMobileNumber(), employeeTM.getNic(), employeeTM.getId());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


//            ==================================
        }
    }
}

