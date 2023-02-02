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
import lk.ijse.TeddyHouse.View.tm.SupplierTM;
import lk.ijse.TeddyHouse.model.SuppliersController;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {
    public static SupplierController Controller;
    public TableView tbl;
    public TableColumn id;
    public TableColumn name;
    public TableColumn address;
    public TableColumn delete;
    public TableColumn update;
    public TableColumn mobilenumber;
    public JFXTextField search;
    ObservableList<SupplierTM> tm = FXCollections.observableArrayList();

    public SupplierController() {
        Controller = this;
    }

    public void AddSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddSupplier.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settbledata();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        mobilenumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        update.setCellValueFactory(new PropertyValueFactory<>("update"));

    }

    void settbledata() {
        tbl.getItems().clear();
        try {
            ResultSet set = lk.ijse.TeddyHouse.model.SuppliersController.getAllDetails();
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
                SupplierTM supplierTM = new SupplierTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4), delete, update


                );
                tm.add(supplierTM);

                delete.setOnAction(event -> {
                    try {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                        alert.showAndWait();

                        if (alert.getResult().equals(ButtonType.YES)) {


                            if (SuppliersController.deleteSupplier(supplierTM.getId())) {
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
                        Navigation.popupNavigation("UpdateSupplier.fxml");
                        UpdateSupplierController.controller.setData(supplierTM.getName(), supplierTM.getAddress(), supplierTM.getMobileNumber(), supplierTM.getId());

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
            settbledata();
        } else {

            try {
                ResultSet set = lk.ijse.TeddyHouse.model.SuppliersController.getAllDetailsSearch(search.getText());
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
                    SupplierTM supplierTM = new SupplierTM(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4), delete, update


                    );
                    tm.add(supplierTM);

                    delete.setOnAction(event -> {
                        try {
                            Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                            alert.showAndWait();

                            if (alert.getResult().equals(ButtonType.YES)) {


                                if (SuppliersController.deleteSupplier(supplierTM.getId())) {
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
                            Navigation.popupNavigation("UpdateSupplier.fxml");
                            UpdateSupplierController.controller.setData(supplierTM.getName(), supplierTM.getAddress(), supplierTM.getMobileNumber(), supplierTM.getId());

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
