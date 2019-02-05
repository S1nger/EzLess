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

public class PhysicsController {
    private static double cTF, mTF, t2TF, t1TF, tSum, cmSum, sum;
    private static double C,M,T,SUM;
    private static double C1,M1,T1,SUM1;
    private static double one_TF,sum_One,two_TF,sum_Two,three_TF,sum_Three;
    @FXML
    private TextField c, m, t2, t1, answer;
    @FXML
    private TextField c1,m1,delta,answer1;
    @FXML
    private TextField c2,m2,delta2,answer2;
    @FXML
    private Button equals;
    @FXML
    private Button equals2;
    @FXML
    private Button clean;
    @FXML
    private Button back;
    @FXML
    private Button equals1;
    @FXML
    private Button clean2;
    @FXML
    private Button clean1;
    @FXML
    private Button cleanTop;
    @FXML
    private SplitMenuButton splitButton;
    @FXML
    private TextField answerTF;
    @FXML
    private MenuItem action1;
    @FXML
    private MenuItem action2;
    @FXML
    private MenuItem action3;
    @FXML
    private TextField massa;
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
        //формула 1
        clean.setOnAction(event ->{
            c.setText(null);
            m.setText(null);
            t2.setText(null);
            t1.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                cTF = Double.parseDouble(c.getText());
                mTF = Double.parseDouble(m.getText());
                t2TF = Double.parseDouble(t2.getText());
                t1TF = Double.parseDouble(t1.getText());
                tSum = t2TF - t1TF;
                cmSum = cTF * mTF;
                sum = cmSum * tSum;
                answer.setText((String.valueOf(nf.format(sum)))+ " Дж");


            }catch (Exception e){
                showAlertWithHeaderText();
            }
        });
        //формула 2
        clean1.setOnAction(event ->{
            c1.setText(null);
            m1.setText(null);
            delta.setText(null);
            answer1.setText(null);
        });
        equals1.setOnAction(event -> {
                    try {
                        C = Double.parseDouble(c1.getText());
                        M = Double.parseDouble(m1.getText());
                        T = Double.parseDouble(delta.getText());
                        SUM = C * M * T;
                        answer1.setText(String.valueOf(nf.format(SUM)));


                    } catch (Exception e) {
                        showAlertWithHeaderText();
                    }
                });
        //формула 3
        clean2.setOnAction(event ->{
            c2.setText(null);
            m2.setText(null);
            delta2.setText(null);
            answer2.setText(null);
        });
        equals2.setOnAction(event -> {
            try {
                C1 = Double.parseDouble(c2.getText());
                M1 = Double.parseDouble(m2.getText());
                T1 = Double.parseDouble(delta2.getText());
                SUM1 = C1 / (M1 * T1);
                answer2.setText(String.valueOf(nf.format(SUM1)));


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
