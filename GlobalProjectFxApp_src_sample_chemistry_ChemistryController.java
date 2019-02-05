package sample.chemistry;

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

public class ChemistryController {
    private static double C,M,SUM;
    private static double C1,M1,SUM1;
    @FXML
    private Button equals1;
    @FXML
    private TextField molar1;
    @FXML
    private Button clean1;
    @FXML
    private TextField massa1;
    @FXML
    private TextField answer1;

    @FXML
    private TextField massa;

    @FXML
    private TextField answer;

    @FXML
    private Button equals;

    @FXML
    private Button back;

    @FXML
    private Button clean;

    @FXML
    private TextField molar;

    @FXML
    public void close() {
        System.exit(0);
    }
    @FXML
    public void initialize() {
        NumberFormat nf = new DecimalFormat("#.######");
        clean.setOnAction(event ->{
            massa.setText(null);
            molar.setText(null);
            answer.setText(null);
        });
        equals.setOnAction(event -> {
            try {
                C = Double.parseDouble(massa.getText());
                M = Double.parseDouble(molar.getText());
                SUM = C / M ;
                answer.setText((String.valueOf(nf.format(SUM)))+" ");


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
        });
        clean1.setOnAction(event ->{
            massa1.setText(null);
            molar1.setText(null);
            answer1.setText(null);
        });
        equals1.setOnAction(event -> {
            try {
                C1 = Double.parseDouble(massa1.getText());
                M1 = Double.parseDouble(molar1.getText());
                SUM1 = C1 * M1 ;
                answer1.setText(String.valueOf(nf.format(SUM1)));


            } catch (Exception e) {
                showAlertWithHeaderText();
            }
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
            stage.getIcons().add(new Image("/sample/1.png"));
            stage.setTitle("EzLess");
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
