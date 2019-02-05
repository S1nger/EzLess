package sample.chemistry;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TopWindow {


    @FXML
    private Button button2;

    @FXML
    private Button back;

    @FXML
    private Button button1;

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void initialize(){
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("/sample/1.png"));
            stage.setTitle("EzLess");
            stage.setResizable(false);
            stage.show();
        });
        button1.setOnAction(event -> {
            button1.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/chemistry/chemistry.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("/sample/1.png"));
            stage.setTitle("EzLess");
            stage.setResizable(false);
            stage.show();
        });
        button2.setOnAction(event -> {
            button2.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/chemistry/molar.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("/sample/1.png"));
            stage.setTitle("EzLess");
            stage.setResizable(false);
            stage.show();
        });

    }

}
