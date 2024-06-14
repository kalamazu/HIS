package com.hos.gui.controller;

import com.hos.gui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerOption {
@FXML
private Button logout;
@FXML
    private void openChargeWindows(){
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Charge.fxml"));
        ControllerCharge controller=new ControllerCharge();
        loader.setController(controller);
        StackPane root = loader.load();
        Scene secondWindowScene = new Scene(root);

        Stage secondWindowStage = new Stage();
        secondWindowStage.setScene(secondWindowScene);
        secondWindowStage.initStyle(StageStyle.UNDECORATED);
        secondWindowStage.show();


    } catch (IOException e) {
        e.printStackTrace();

    }
}
    @FXML
    private void openPatienceWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Patiences.fxml"));
            ControllerPatience controller=new ControllerPatience();
            loader.setController(controller);
            StackPane root = loader.load();
            Scene secondWindowScene = new Scene(root);

            Stage secondWindowStage = new Stage();
            secondWindowStage.setScene(secondWindowScene);
            secondWindowStage.initStyle(StageStyle.UNDECORATED);
            secondWindowStage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @FXML
    private void openMedicineWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Medicine.fxml"));
            ControllerMedicine controller=new ControllerMedicine();
            loader.setController(controller);
            StackPane root = loader.load();
            Scene secondWindowScene = new Scene(root);

            Stage secondWindowStage = new Stage();
            secondWindowStage.setScene(secondWindowScene);
            secondWindowStage.initStyle(StageStyle.UNDECORATED);
            secondWindowStage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @FXML
    private void logOut(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Login.fxml"));
            Controller controller=new Controller();
            loader.setController(controller);
            StackPane root = loader.load();
            Scene secondWindowScene = new Scene(root);

            Stage secondWindowStage = new Stage();
            secondWindowStage.setScene(secondWindowScene);
            secondWindowStage.initStyle(StageStyle.UNDECORATED);
            secondWindowStage.show();

            Stage stage = (Stage) logout.getScene().getWindow();
            stage.close();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
