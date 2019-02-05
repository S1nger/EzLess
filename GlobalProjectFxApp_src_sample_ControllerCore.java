package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class ControllerCore {
    @FXML
    private Button physics;
    @FXML
    private Button chemistry;
    @FXML
    private Button geometry;
    @FXML
    private Button math;

    @FXML
    public void close() {
        System.exit(0);
    }
    @FXML
    private MenuItem about;
    @FXML
    public void initialize() {

        physics.setOnAction(event -> {
            priv("/sample/physics/TopWindow.fxml");
        });

        chemistry.setOnAction(event -> {
            priv("/sample/chemistry/TopWindow.fxml");
        });

        geometry.setOnAction(event -> {
            priv("/sample/geometry/TopWindow.fxml");
        });

        math.setOnAction(event -> {
            priv("/sample/math/TopWindow.fxml");
        });
        about.setOnAction(event -> {
            alert();
        });
    }
    public void priv(String scene){

        physics.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(scene));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("EzLess");
        stage.getIcons().add(new Image("/sample/1.png"));
        stage.setResizable(false);
        stage.show();
    }
    private void alert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Program");
        alert.setHeaderText("О программе");
        alert.setContentText("1. Версия программы: V.1.0\n2. Автор: Соломахин Игорь\n3. Связь с автором: Вконтакте vk.com/id.king.igorek , e-mail solomahin.ig@yandex.ru");
        alert.showAndWait();
    }



}
