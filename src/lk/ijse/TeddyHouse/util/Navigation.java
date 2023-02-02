package lk.ijse.TeddyHouse.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class Navigation {
    private static Stage stage;
    private static Scene scene;
    private static Parent parent;
    public static void swatch(String url, ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(Navigation.class.getResource("/lk/ijse/TeddyHouse/View/" + url));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void popupNavigation(String link) throws IOException {
        URL resource = Navigation.class.getResource("/lk/ijse/TeddyHouse/view/" + link);
        Parent parent = FXMLLoader.load(resource);
        scene = new Scene(parent);
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }
    public static void close(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}

