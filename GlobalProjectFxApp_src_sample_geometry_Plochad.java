package sample.geometry;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Plochad {
    private static double A,H,Sum,A1,B,SUM;
    @FXML
    private TextField a1;

    @FXML
    private TextField a;

    @FXML
    private TextField b;

    @FXML
    private TextField answer;

    @FXML
    private Button equals1;

    @FXML
    private Button equals;

    @FXML
    private TextField h;

    @FXML
    private Button back;

    @FXML
    private Button clean1;

    @FXML
    private Button clean;

    @FXML
    private TextField answer1;

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void initialize() {
        NumberFormat nf = new DecimalFormat("#.######");
        clean.setOnAction(event -> {
            a.setText(null);
            h.setText(null);
            answer.setText(null);

                });
        equals.setOnAction(event -> {
            try {
                A = Double.parseDouble(a.getText());
                H = Double.parseDouble(h.getText());
                Sum = A * H * 0.5;
                answer.setText((String.valueOf(nf.format(Sum)))+ " см");

            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event -> {
            a1.setText(null);
            b.setText(null);
            answer1.setText(null);

        });
        equals1.setOnAction(event -> {
            try {
                A1 = Double.parseDouble(a1.getText());
                B = Double.parseDouble(b.getText());
                SUM = A1 * B * 0.5;
                answer1.setText((String.valueOf(nf.format(SUM)))+ " см");

            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });

        back.setOnAction(event -> {
            back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/geometry/TopWindow.fxml"));

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
    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Unknown error");
        alert.setHeaderText("Произошла неизвестная ошибка");
        alert.setContentText("Возможно вы найдете ошибку в этих пунктах: \n1) вы набрали слишком длинное число \n2) вы нажали на '=' без ввода чисел\n3)вы при вводе дробного числа ввели ',' вместо '.'");

        alert.showAndWait();
    }
}
