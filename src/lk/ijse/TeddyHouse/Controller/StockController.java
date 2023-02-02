package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.TeddyHouse.View.tm.StockTM;
import lk.ijse.TeddyHouse.View.tm.SupplierTM;
import lk.ijse.TeddyHouse.model.ItemController;
import lk.ijse.TeddyHouse.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StockController implements Initializable {
    public static StockController controller;
    public TableView tbl;
    public TableColumn id;
    public TableColumn name;
    public TableColumn price;
    public TableColumn qty;
    public TableColumn delete;
    public TableColumn update;
    public JFXTextField search;
    ObservableList<StockTM> tm = FXCollections.observableArrayList();

    public StockController() {
        controller = this;
    }

    public void AddStockOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddStock.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settbledata();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        try {
            delete.setCellValueFactory(new PropertyValueFactory<>("delete"));
            update.setCellValueFactory(new PropertyValueFactory<>("update"));
        } catch (Exception e) {
        }

    }

    public void settbledata() {
        tbl.getItems().clear();
        try {
            ResultSet set = lk.ijse.TeddyHouse.model.ItemController.getAllDetails();
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
                StockTM stockTM = new StockTM(set.getString(1),
                        set.getString(2),
                        set.getString(4),
                        set.getString(3), delete, update


                );
                tm.add(stockTM);
                tbl.setItems(tm);
                delete.setOnAction(event -> {
                    try {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                        alert.showAndWait();

                        if (alert.getResult().equals(ButtonType.YES)) {


                            if (ItemController.deleteStock(stockTM.getId())) {
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
                        Navigation.popupNavigation("UpdateStock.fxml");
                        UpdateStockController.controller.setData(stockTM.getId(), stockTM.getName(), stockTM.getPrice(), stockTM.getQty());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void serchId(KeyEvent keyEvent) {
        tbl.getItems().clear();
        tm.clear();
        if (search.getText().equals("")) {
            settbledata();
        } else {


            try {
                ResultSet set = lk.ijse.TeddyHouse.model.ItemController.getAllDetailsSearch(search.getText());
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
                    StockTM stockTM = new StockTM(set.getString(1),
                            set.getString(2),
                            set.getString(4),
                            set.getString(3), delete, update


                    );
                    tm.add(stockTM);
                    tbl.setItems(tm);
                    delete.setOnAction(event -> {
                        try {
                            Alert alert = new Alert(Alert.AlertType.WARNING, "ARE YOU SURE", ButtonType.YES, ButtonType.NO);
                            alert.showAndWait();

                            if (alert.getResult().equals(ButtonType.YES)) {


                                if (ItemController.deleteStock(stockTM.getId())) {
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
                            Navigation.popupNavigation("UpdateStock.fxml");
                            UpdateStockController.controller.setData(stockTM.getId(), stockTM.getName(), stockTM.getPrice(), stockTM.getQty());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                }

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
