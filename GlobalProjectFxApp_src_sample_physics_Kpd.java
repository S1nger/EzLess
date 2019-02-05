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

public class Kpd {
    private static double Al,Ql,SUM,Q_1,Q_2,Q_3,sum;
    @FXML
    private TextField A;

    @FXML
    private TextField Q,q1,Q2,Q3;

    @FXML
    private TextField answer,answer1;

    @FXML
    private Button equals;
    @FXML
    private Button equals1;

    @FXML
    private Button back;

    @FXML
    private Button clean;
    @FXML
    private Button clean1;

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void initialize(){
        NumberFormat nf = new DecimalFormat("#.######");
        equals.setOnAction(event -> {
            try {
                Al = Double.parseDouble(A.getText());
                Ql = Double.parseDouble(Q.getText());
                SUM = (Al / Ql) * 100 ;
                answer.setText((String.valueOf(nf.format(SUM)))+ " %");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean.setOnAction(event ->{
            A.setText(null);
            Q.setText(null);
            answer.setText(null);
        });
        equals1.setOnAction(event -> {
            try {
                Q_1 = Double.parseDouble(q1.getText());
                Q_2 = Double.parseDouble(Q2.getText());
                Q_3 = Double.parseDouble(Q3.getText());
                sum = ((Q_1 - Math.abs(Q_2)) / Q_3)* 100 ;
                answer1.setText((String.valueOf(nf.format(sum)))+ " %");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event ->{
            q1.setText(null);
            Q2.setText(null);
            Q3.setText(null);
            answer1.setText(null);
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
