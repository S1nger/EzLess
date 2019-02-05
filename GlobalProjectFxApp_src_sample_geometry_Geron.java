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

public class Geron {
    private static double PTOP,P1,P2,P3,A,B,C,SUM,A2,B2,C2,Sum;
    @FXML
    private TextField pTop,a1,b1,c1;

    @FXML
    private TextField p1;

    @FXML
    private TextField a;

    @FXML
    private TextField b;

    @FXML
    private TextField p2;

    @FXML
    private TextField c;

    @FXML
    private TextField p3;

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
    public void initialize() {
        NumberFormat nf = new DecimalFormat("#.######");
        clean1.setOnAction(event -> {
            a1.setText(null);
            b1.setText(null);
            c1.setText(null);
            answer1.setText(null);
        });
        equals1.setOnAction(event -> {
            try {
                A2 = Double.parseDouble(a1.getText().trim());
                B2 = Double.parseDouble(b1.getText().trim());
                C2 = Double.parseDouble(c1.getText().trim());
                Sum = 0.5 * (A2 + B2 + C2);
                answer1.setText((String.valueOf(nf.format(Sum)))+ " см");
            }catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        equals.setOnAction(event -> {
            try{
            A = Double.parseDouble(a.getText());
            B = Double.parseDouble(b.getText());
            C = Double.parseDouble(c.getText());
            PTOP = Double.parseDouble(pTop.getText());
            P1 = Double.parseDouble(p1.getText());
            P2 = Double.parseDouble(p2.getText());
            P3 = Double.parseDouble(p3.getText());
            SUM = Math.sqrt(PTOP * (P1 - A) * (P2 - B) * (P3 - C));
            answer.setText((String.valueOf(nf.format(SUM)))+ " см");
            }catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean.setOnAction(event -> {
            pTop.setText(null);
            p1.setText(null);
            p2.setText(null);
            p3.setText(null);
            a.setText(null);
            b.setText(null);
            c.setText(null);
            answer.setText(null);
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
