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

public class Om {
    private static double one_TF,sum_One,two_TF,sum_Two,three_TF,sum_Three;
    private static double C,M,SUM;
    private static double I_,R_,sum;
    @FXML
    private TextField U,R,answer,I,r,answer1;
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
            U.setText(null);
            R.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                C = Double.parseDouble(U.getText());
                M = Double.parseDouble(R.getText());
                SUM = C / M ;
                answer.setText((String.valueOf(nf.format(SUM)))+ " A");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event ->{
            I.setText(null);
            r.setText(null);
            answer1.setText(null);
        });
        equals1.setOnAction(event -> {
            try {
                I_ = Double.parseDouble(I.getText());
                R_ = Double.parseDouble(r.getText());
                sum = I_ * R_ ;
                answer1.setText((String.valueOf(nf.format(sum)))+ " B");


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
