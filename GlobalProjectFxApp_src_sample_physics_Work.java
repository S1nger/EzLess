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

public class Work {
    private static double U_1,R_1,t_1,SUM;
    private static double i,r,t_tf,sum;
    @FXML
    private TextField I,answer,R,t,answer1,U1,R1,t1;
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
            I.setText(null);
            R.setText(null);
            t.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                i = Double.parseDouble(I.getText());
                r = Double.parseDouble(R.getText());
                t_tf = Double.parseDouble((t.getText()));
                sum = (i * i) * r * t_tf ;
                answer.setText((String.valueOf(nf.format(sum)))+ " Дж");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event ->{
            U1.setText(null);
            R1.setText(null);
            t1.setText(null);
            answer1.setText(null);
        });
        equals1.setOnAction(event -> {
            try {
                U_1 = Double.parseDouble(U1.getText());
                R_1 = Double.parseDouble(R1.getText());
                t_1 = Double.parseDouble(t1.getText());
                SUM = (U_1 * U_1) / R_1 * t_1  ;
                answer1.setText((String.valueOf(nf.format(SUM)))+ " Дж");


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
