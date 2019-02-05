package sample.physics;

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

public class Sop {
    private static double R_1,R_2,r_1,r_2,SUM,TF,FT,sum;
    @FXML
    private TextField R1,R2,r1,r2,answer,answer1,ft1,ft2;
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
        clean.setOnAction(event ->{
            R1.setText(null);
            R2.setText(null);
            r2.setText(null);
            r1.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                R_1 = Double.parseDouble(R1.getText());
                R_2 = Double.parseDouble(R2.getText());
                r_1 = Double.parseDouble(r1.getText());
                r_2 = Double.parseDouble(r2.getText());
                SUM = (R_1 * R_2) / (r_1 + r_2) ;
                answer.setText((String.valueOf(nf.format(SUM)))+ " Ом ");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event ->{
            ft1.setText(null);
            ft2.setText(null);
            answer1.setText(null);
        });
        equals1.setOnAction(event -> {
            try {
                TF = Double.parseDouble(ft1.getText());
                FT = Double.parseDouble(ft2.getText());
                sum = TF + FT ;
                answer1.setText((String.valueOf(nf.format(sum)))+ " Ом ");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/physics/TopWindow.fxml"));

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
