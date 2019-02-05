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

public class MathController {
    NumberFormat nf = new DecimalFormat("#.######");
    @FXML
    private Button clean;
    @FXML
    private Button clean1;
    private static double coren,answer,coren1,SUM;
    @FXML
    private TextField answ,cor,answ1,x;
    @FXML
    private Button eq;
    @FXML
    private Button eq1;
    @FXML
    private Button back;
    @FXML
    public void close() {
        System.exit(0);
    }
    @FXML
    public void initialize() {

        clean.setOnAction(event -> {
            answ.setText(null);
            cor.setText(null);
        });
        eq.setOnAction(event -> {
            try {
                answer = Math.sqrt(coren = Double.parseDouble(cor.getText()));
                answ.setText(String.valueOf(nf.format(answer)));
            }catch (Exception e){
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event -> {
            answ1.setText(null);
            x.setText(null);
        });

        eq1.setOnAction(event -> {
            try {
                coren1 = Double.parseDouble(x.getText());
                SUM = coren1 * coren1;
                answ1.setText(String.valueOf(nf.format(SUM)));
            }catch (Exception e){
                showAlertWithHeaderText();
            }
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
