package sample.chemistry;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Molar {
    private static double one_TF,sum_One,two_TF,sum_Two,three_TF,sum_Three;
    private static double A,B,D,C,F,G,H,J,SUM,A1,B1,D1,C1,F1,G1,SUM1,A2,B2,C2,D2,SUM2,A3,B3,SUM3;
    @FXML
    private Label plus1,plus2,plus3,plus4,plus5,plus7;
    @FXML
    private Label min3,min2,min1,min4,min5,min7;
    @FXML
    private TextField add1,add2,add3,add4,add5,add6,add7,add8,t1,t2,t3,t4,t5,t6,f1,f2,f3,f4,ft1,ft2;
    @FXML
    private Button back;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_3;
    @FXML
    private Button clean;
    @FXML
    private TextField answer;
    @FXML
    private Button btn4;
    @FXML
    private Button equals;
    @FXML
    private Button btn3;
    @FXML
    private Button btn5;
    NumberFormat nf = new DecimalFormat("#.######");
    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void initialize() {

        add1.setVisible(false);
        add1.setVisible(false);
        add2.setVisible(false);
        add3.setVisible(false);
        add4.setVisible(false);
        add5.setVisible(false);
        add6.setVisible(false);
        add7.setVisible(false);
        add8.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        t4.setVisible(false);
        t5.setVisible(false);
        t6.setVisible(false);
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        equals.setOnAction(event -> {
            try {
                makeEq();
            }catch (Exception e){
                showAlertWithHeaderText();
            }
        });
        clean.setOnAction(event -> {
            add1.setText(null);
            add2.setText(null);
            add3.setText(null);
            add4.setText(null);
            add5.setText(null);
            add6.setText(null);
            add7.setText(null);
            add8.setText(null);
            answer.setText(null);
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            t5.setText(null);
            t6.setText(null);
            f1.setText(null);
            f2.setText(null);
            f3.setText(null);
            f4.setText(null);
            ft1.setText(null);
            ft2.setText(null);
        });
                btn_3.setOnAction(event -> {

                    btn3.setDisable(false);
                    btn_4.setDisable(false);
                    plus4.setVisible(false);
                    min4.setVisible(false);
                    plus5.setVisible(false);
                    min5.setVisible(false);
                    plus7.setVisible(false);
                    min7.setVisible(false);
                    plus3.setVisible(false);
                    min3.setVisible(false);
                    plus2.setVisible(false);
                    min2.setVisible(false);
                    plus1.setVisible(false);
                    min1.setVisible(false);
                    add1.setVisible(false);
                    add1.setVisible(false);
                    add2.setVisible(false);
                    add3.setVisible(false);
                    add4.setVisible(false);
                    add5.setVisible(false);
                    add6.setVisible(false);
                    add7.setVisible(false);
                    add8.setVisible(false);
                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                    ft1.setVisible(false);
                    ft2.setVisible(false);
                    plus7.setVisible(true);
                    min7.setVisible(true);
                    f1.setVisible(true);
                    f2.setVisible(true);
                    f3.setVisible(true);
                    f4.setVisible(true);
                    equals.setOnAction(event1 -> {
                        try{
                        A2 = Double.parseDouble(f1.getText());
                        B2 = Double.parseDouble(f2.getText());
                        D2 = Double.parseDouble(f4.getText());
                        C2 = Double.parseDouble(f3.getText());
                        SUM2 = (A2 * B2) + (D2 * C2 );
                        answer.setText(String.valueOf(nf.format(SUM2)));
                    }catch (Exception e){
                            showAlertWithHeaderText();
                        }
                    });
                });
                btn3.setOnAction(event -> {
                    btn3.setDisable(true);
                    btn_4.setDisable(true);
                    equals.setOnAction(event1 -> {
                        try{
                        makeEq();
                        }catch (Exception e){
                            showAlertWithHeaderText();
                        }
                    });
                    ft1.setVisible(true);
                    ft2.setVisible(true);
                    f1.setVisible(false);
                    f2.setVisible(false);
                    f3.setVisible(false);
                    f4.setVisible(false);
                    plus7.setVisible(false);
                    min7.setVisible(false);

                });
                btn_4.setOnAction(event -> {
                    btn_5.setDisable(false);
                    btn_3.setDisable(true);
                    btn3.setDisable(true);
                    btn4.setDisable(false);
                    plus3.setVisible(false);
                    min3.setVisible(false);
                    plus2.setVisible(false);
                    min2.setVisible(false);
                    plus1.setVisible(false);
                    min1.setVisible(false);
                    ft1.setVisible(false);
                    ft2.setVisible(false);
                    f1.setVisible(false);
                    f2.setVisible(false);
                    f3.setVisible(false);
                    f4.setVisible(false);
                    plus4.setVisible(true);
                    min4.setVisible(true);
                    plus5.setVisible(true);
                    min5.setVisible(true);
                    t1.setVisible(true);
                    t2.setVisible(true);
                    t3.setVisible(true);
                    t4.setVisible(true);
                    t5.setVisible(true);
                    t6.setVisible(true);
                    add1.setVisible(false);
                    add1.setVisible(false);
                    add2.setVisible(false);
                    add3.setVisible(false);
                    add4.setVisible(false);
                    add5.setVisible(false);
                    add6.setVisible(false);
                    add7.setVisible(false);
                    add8.setVisible(false);
                    f1.setVisible(false);
                    f2.setVisible(false);
                    f3.setVisible(false);
                    f4.setVisible(false);
                    equals.setOnAction(event1 -> {
                        try{
                        A1 = Double.parseDouble(t1.getText());
                        B1 = Double.parseDouble(t2.getText());
                        D1 = Double.parseDouble(t3.getText());
                        C1 = Double.parseDouble(t4.getText());
                        F1 = Double.parseDouble(t5.getText());
                        G1 = Double.parseDouble(t6.getText());
                        SUM1 = (A1 * B1) + (D1 * C1 )+ (F1 * G1 );
                        answer.setText(String.valueOf(nf.format(SUM1)));
                        }catch (Exception e){
                            showAlertWithHeaderText();
                        }
                    });
                });
                btn4.setOnAction(event -> {
                    btn4.setDisable(true);
                    btn_3.setDisable(false);
                    btn3.setDisable(true);
                    btn_4.setDisable(true);
                    btn_5.setDisable(true);
                    equals.setOnAction(event1 -> {
                        try{
                        makeEq();
                        }catch (Exception e){
                            showAlertWithHeaderText();
                        }
                    });
                    ft1.setVisible(true);
                    ft2.setVisible(true);
                    plus4.setVisible(false);
                    min4.setVisible(false);
                    plus5.setVisible(false);
                    min5.setVisible(false);
                    plus7.setVisible(false);
                    min7.setVisible(false);
                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                });
                btn_5.setOnAction(event1 -> {
                    btn_4.setDisable(true);
                    btn4.setDisable(true);

                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                    f1.setVisible(false);
                    f2.setVisible(false);
                    f3.setVisible(false);
                    f4.setVisible(false);
                    btn5.setDisable(false);
                    ft1.setVisible(false);
                    ft2.setVisible(false);
                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                    plus3.setVisible(true);
                    min3.setVisible(true);
                    plus2.setVisible(true);
                    min2.setVisible(true);
                    plus1.setVisible(true);
                    min1.setVisible(true);
                    add1.setVisible(true);
                    add1.setVisible(true);
                    add2.setVisible(true);
                    add3.setVisible(true);
                    add4.setVisible(true);
                    add5.setVisible(true);
                    add6.setVisible(true);
                    add7.setVisible(true);
                    add8.setVisible(true);
                    equals.setOnAction(event -> {
                        try{
                    A = Double.parseDouble(add1.getText());
                    B = Double.parseDouble(add2.getText());
                    D = Double.parseDouble(add3.getText());
                    C = Double.parseDouble(add4.getText());
                    F = Double.parseDouble(add5.getText());
                    G = Double.parseDouble(add6.getText());
                    H = Double.parseDouble(add7.getText());
                    J = Double.parseDouble(add8.getText());
                    SUM = (A * B) + (D * C )+ (F * G )+ (H * J );
                    answer.setText(String.valueOf(nf.format(SUM)));
                        }catch (Exception e){
                            showAlertWithHeaderText();
                        }

                });



        });
                btn5.setOnAction(event -> {
                    equals.setOnAction(event1 -> {
                        try{
                                makeEq();
                        }catch (Exception e){
                            showAlertWithHeaderText();
                        }
                            });
                    btn5.setDisable(true);
                    btn_5.setDisable(true);
                    btn_3.setDisable(false);
                    ft1.setVisible(true);
                    ft2.setVisible(true);
                    plus3.setVisible(false);
                    min3.setVisible(false);
                    plus2.setVisible(false);
                    min2.setVisible(false);
                    plus1.setVisible(false);
                    min1.setVisible(false);
                    plus4.setVisible(false);
                    min4.setVisible(false);
                    plus5.setVisible(false);
                    min5.setVisible(false);
                    plus7.setVisible(false);
                    min7.setVisible(false);
                    add1.setVisible(false);
                    add1.setVisible(false);
                    add2.setVisible(false);
                    add3.setVisible(false);
                    add4.setVisible(false);
                    add5.setVisible(false);
                    add6.setVisible(false);
                    add7.setVisible(false);
                    add8.setVisible(false);

                });

        back.setOnAction(event -> {
            back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/chemistry/TopWindow.fxml"));

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
    private void makeEq(){
        A3 = Double.parseDouble(ft1.getText());
        B3 = Double.parseDouble(ft2.getText());
        SUM3 = A3 * B3;
        answer.setText(String.valueOf(nf.format(SUM3)));
    }
}
