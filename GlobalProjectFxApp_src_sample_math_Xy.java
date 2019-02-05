package sample.math;

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

public class Xy {
    private static double A,B,SUM,A1,B1,X2,X,C,Sum;
    @FXML
    private TextField a,b,a1,b1,x2,x,c;
    @FXML
    private TextField answer,answer1;

    @FXML
    private Button equals;
    @FXML
    private Button equals1;

    @FXML
    private Button clean;

    @FXML
    private Button clean1;

    @FXML
    private Button back;

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void initialize() {
        NumberFormat nf = new DecimalFormat("#.######");
        equals1.setOnAction(event -> {
            try {
                A1 = Double.parseDouble(a1.getText());
                B1 = Double.parseDouble(b1.getText());
                X2 = Double.parseDouble(x2.getText());
                X = Double.parseDouble(x.getText());
                C = Double.parseDouble(c.getText());
                Sum = (A1*X2) + (B1 * X) + C;
                answer1.setText(String.valueOf(nf.format(Sum)));


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event ->{
            a1.setText(null);
            b1.setText(null);
            x2.setText(null);
            x.setText(null);
            c.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                A = Double.parseDouble(a.getText());
                B = Double.parseDouble(b.getText());
                SUM = -B / (2 * A) ;
                answer.setText(String.valueOf(nf.format(SUM)));


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean.setOnAction(event ->{
            a.setText(null);
            b.setText(null);
            answer.setText(null);
        });
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/math/TopWindow.fxml"));

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
