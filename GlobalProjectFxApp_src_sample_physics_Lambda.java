package sample.physics;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Lambda {
    private static double one_TF,sum_One,two_TF,sum_Two,three_TF,sum_Three;
    private static double C,M,SUM;
    @FXML
    private TextField massa;
    @FXML
    private SplitMenuButton splitButton;
    @FXML
    private TextField answerTF;
    @FXML
    private Button cleanTop;
    @FXML
    private TextField lambda;

    @FXML
    private TextField answer;

    @FXML
    private Button equals;

    @FXML
    private Button back;

    @FXML
    private Button clean;

    @FXML
    private TextField m;
    @FXML
    private MenuItem action1;
    @FXML
    private MenuItem action2;
    @FXML
    private MenuItem action3;
    @FXML
    public void close() {
        System.exit(0);
    }


    @FXML
    public void initialize() {
        NumberFormat nf = new DecimalFormat("#.######");
        cleanTop.setOnAction(event -> {
            answerTF.setText(null);
            massa.setText(null);
        });
        action1.setOnAction(event1 -> {
            splitButton.setOnAction(event -> {
                try{
                one_TF = Double.parseDouble(massa.getText());
                sum_One = one_TF / 1000;
                answerTF.setText((String.valueOf(nf.format(sum_One)))+" Кг");
                } catch (Exception e) {
                    showAlertWithHeaderText();
                }
            });
        });
        action2.setOnAction(event1 -> {
            splitButton.setOnAction(event -> {
                try{
                two_TF = Double.parseDouble(massa.getText());
                sum_Two = two_TF * 1000;
                answerTF.setText((String.valueOf(nf.format(sum_Two)))+" Кг");
                } catch (Exception e) {
                    showAlertWithHeaderText();
                }
            });
        });
        action3.setOnAction(event1 -> {
            splitButton.setOnAction(event -> {
                try{
                three_TF = Double.parseDouble(massa.getText());
                sum_Three = three_TF * 100;
                answerTF.setText((String.valueOf(nf.format(sum_Three)))+" Кг");
                } catch (Exception e) {
                    showAlertWithHeaderText();
                }
            });
        });
        clean.setOnAction(event ->{
            lambda.setText(null);
            m.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                C = Double.parseDouble(lambda.getText());
                M = Double.parseDouble(m.getText());
                SUM = C * M ;
                answer.setText((String.valueOf(nf.format(SUM)))+ " Дж/кг");


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
