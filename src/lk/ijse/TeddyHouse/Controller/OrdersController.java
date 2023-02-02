package lk.ijse.TeddyHouse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.TeddyHouse.View.tm.OrderTm;
import lk.ijse.TeddyHouse.model.CustomerController;
import lk.ijse.TeddyHouse.model.ItemController;
import lk.ijse.TeddyHouse.to.CustomerOrderDetails;
import lk.ijse.TeddyHouse.to.Orders;
import lk.ijse.TeddyHouse.util.DateUtil;
import lk.ijse.TeddyHouse.util.Navigation;
import lk.ijse.TeddyHouse.util.RegexUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {
    public TableView tbl;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colQut;
    public TableColumn colPrice;
    public JFXComboBox comboNum;
    public JFXComboBox comboItemId;
    public Text txtItemName;
    public Text txtCrustName;
    public Text txtPrice;
    public JFXTextField lblQTY;
    public Text txtTotal;
    public TableColumn colQty;
    public JFXButton add;
    public JFXButton pay;
    ArrayList<CustomerOrderDetails> orderDetails = new ArrayList<>();
    ObservableList<OrderTm> orderTms = FXCollections.observableArrayList();
    public static OrdersController controller;

    public OrdersController() {
        controller = this;
    }

    public void AddOrderOnAction(ActionEvent actionEvent) throws IOException {

        if (comboItemId.getValue() == null | lblQTY.getText() == null | txtItemName.getText() == null | txtPrice.getText() == null | comboNum.getValue() == null | txtCrustName.getText() == null) {
            add.setDisable(true);

        } else {
            orderDetails.add(new CustomerOrderDetails(
                    null,
                    String.valueOf(comboItemId.getValue()),
                    lblQTY.getText(),
                    txtPrice.getText()

            ));
            orderTms.add(new OrderTm(
                    String.valueOf(comboItemId.getValue()),
                    txtItemName.getText(),
                    lblQTY.getText(),
                    txtPrice.getText()
            ));
            tbl.refresh();
            setTotal();
            Textclear();

        }
    }

    private void Textclear() {
        lblQTY.clear();
        txtPrice.setText("");
        comboItemId.getItems().clear();
        setItemId();
        txtItemName.setText("");
    }

    private void setTotal() {
        double total = 0;
        for (int i = 0; i < orderDetails.size(); i++) {
            total += Double.parseDouble(orderDetails.get(i).getUnitPrice()) * Integer.parseInt(orderDetails.get(i).getQty());
        }
        txtTotal.setText(String.valueOf(total));
    }

    public void payOnAction(ActionEvent actionEvent) throws IOException {

//        try {
//            if (lk.ijse.TeddyHouse.model.OrdersController.setOrder(new Orders(
//                    nextId(),
//                    DateUtil.dateNow(),
//                    txtTotal.getText(),
//                    String.valueOf(comboNum.getValue())
//
//            ), orderDetails)) {
//                tbl.getItems().clear();
//                comboNum.getItems().clear();
//                setCustNum();
//                txtTotal.setText("0.00");
//                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }



        AddToLendingController.amount = txtTotal.getText();
        AddToLendingController.id = nextId();
        AddToLendingController.date = DateUtil.dateNow();
        System.out.println(comboNum.getValue());
        AddToLendingController.custId = String.valueOf(comboNum.getValue());
        AddToLendingController.orderDetails = orderDetails;
        Navigation.popupNavigation("ChechLendig.fxml");

    }

    private String nextId() {
        String id = null;
        try {
            ResultSet set = lk.ijse.TeddyHouse.model.OrdersController.getId();
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] os = id.split("o");
                int nextId = Integer.parseInt(os[1]);
                nextId++;
                return "o" + nextId;
            } catch (NullPointerException e) {
                return "o1";
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void numOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = CustomerController.getName(String.valueOf(comboNum.getValue()));
            if (set.next()) {
                txtCrustName.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void itemIdOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = ItemController.getTotalName(String.valueOf(comboItemId.getValue()));
            while (set.next()) {
                txtItemName.setText(set.getString(1));
                txtPrice.setText(set.getString(2));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCustNum();
        setItemId();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tbl.setItems(orderTms);
    }

    private void setItemId() {
        ArrayList<String> id = new ArrayList<>();
        try {
            ResultSet set = ItemController.getAllId();
            while (set.next()) {
                id.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboItemId.getItems().addAll(id);

    }


    public void setCustNum() {
        ArrayList<String> id = new ArrayList<>();
        try {
            ResultSet set = CustomerController.getAllId();
            while (set.next()) {
                id.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboNum.getItems().addAll(id);
    }

    public void namek(KeyEvent keyEvent) {
//        if (RegexUtil.regex(comboItemId.getId(),"\\b([a-z]|[A-Z])+")){
//            add.setDisable(false);
//            comboItemId.setFocusColor(Paint.valueOf("white"));
//        }else {
//            add.setDisable(true);
//            comboItemId.setFocusColor(Paint.valueOf("red"));

       // }
    }

    public void qtyk(KeyEvent keyEvent) {
        if (RegexUtil.regex(lblQTY.getText(),"^[\\d]{0,15}$")){
            add.setDisable(false);
            lblQTY.setFocusColor(Paint.valueOf("white"));
        }else {
            add.setDisable(true);
            lblQTY.setFocusColor(Paint.valueOf("red"));

        }

    }
}
