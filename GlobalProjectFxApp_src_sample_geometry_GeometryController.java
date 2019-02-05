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

public class GeometryController {
    NumberFormat nf = new DecimalFormat("#.######");
    private static double aTF,bTF,answer,aSUM,bSUM,SUM;
    private static double aTF1,bTF1,answer1,aSUM1,bSUM1,SUM1;
    private static double aTF2,bTF2,answer2,aSUM2,bSUM2,SUM2;
    @FXML
    private TextField a,a1,a2;

    @FXML
    private TextField b,c1,c2;

    @FXML
    private Button eq;
    @FXML
    private Button eq1;
    @FXML
    private Button eq2;

    @FXML
    private TextField answ,answ1,answ2;

    @FXML
    private Button clean;
    @FXML
    private Button clean1;
    @FXML
    private Button clean2;
    @FXML
    private Button back;
    @FXML
    public void close() {
        System.exit(0);
    }
    @FXML
    public void initialize() {
        //
        //формула 1
        //
        clean.setOnAction(event -> {
            a.setText(null);
            b.setText(null);
            answ.setText(null);
        });

        eq.setOnAction(event -> {
            try {
                aTF = Double.parseDouble(a.getText());
                bTF = Double.parseDouble(b.getText());
                aSUM = aTF * aTF;
                bSUM = bTF * bTF;
                SUM = aSUM + bSUM;
                answer = Math.sqrt(SUM);
                answ.setText((String.valueOf(nf.format(answer)))+ " см");
            } catch (Exception e){
                showAlertWithHeaderText();
            }
        });
        //
        //формула 2
        //
        clean1.setOnAction(event -> {
            a1.setText(null);
            c1.setText(null);
            answ1.setText(null);
        });

        eq1.setOnAction(event -> {
            try {
                aTF1 = Double.parseDouble(a1.getText());
                bTF1 = Double.parseDouble(c1.getText());
                aSUM1 = aTF1 * aTF1;
                bSUM1 = bTF1 * bTF1;
                SUM1 = aSUM1 - bSUM1;
                answer1 = Math.sqrt(SUM1);
                answ1.setText((String.valueOf(nf.format(answer1)))+ " см");
            } catch (Exception e){
                showAlertWithHeaderText();
            }
        });
        //
        //формула 3
        //
        clean2.setOnAction(event -> {
            a2.setText(null);
            c2.setText(null);
            answ2.setText(null);
        });
        eq2.setOnAction(event -> {
            try {
                aTF2 = Double.parseDouble(a2.getText());
                bTF2 = Double.parseDouble(c2.getText());
                aSUM2 = aTF2 * aTF2;
                bSUM2 = bTF2 * bTF2;
                SUM2 = aSUM2 - bSUM2;
                answer2 = Math.sqrt(SUM2);
                answ2.setText((String.valueOf(nf.format(answer2)))+ " см");
            } catch (Exception e){
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
