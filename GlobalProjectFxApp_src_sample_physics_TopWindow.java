package sample.physics;

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
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;

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
            stage.setTitle("EzLess");
            stage.getIcons().add(new Image("/sample/1.png"));
            stage.setResizable(false);
            stage.show();
        });
        button1.setOnAction(event -> {
            button1.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/physics.fxml"));

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
        });
        button5.setOnAction(event -> {
            button5.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/Om.fxml"));

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
        });
        button2.setOnAction(event -> {
            button2.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/physics1.fxml"));

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
        });
        button3.setOnAction(event -> {
            button3.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/physics2.fxml"));

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
        });
        button4.setOnAction(event -> {
            button4.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/Kpd.fxml"));

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
        });
        button6.setOnAction(event -> {
            button6.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/sop.fxml"));

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
        });
        button7.setOnAction(event -> {
            button7.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/Work.fxml"));

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
        });
        button8.setOnAction(event -> {
            button8.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/p.fxml"));

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
        });
    }

}
