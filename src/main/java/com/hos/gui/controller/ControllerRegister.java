package com.hos.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerRegister {



        private double xOffset = 0;
        private double yOffset = 0;
        @FXML
        private AnchorPane Pane;

        @FXML
        private PasswordField Password;

        @FXML
        private PasswordField RePassword;

        @FXML
        private TextField UserName;

        @FXML
        private Label message;

        @FXML
        private Label info;

    @FXML
    private void Close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

        @FXML
        private void onMousePressedForMove(MouseEvent event) {

            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }

        @FXML
        private void onMouseDraggedForMove(MouseEvent event) {

            Stage stage = (Stage) Pane.getScene().getWindow();

            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }


        @FXML
        void register(ActionEvent event) {




            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Login.fxml"));
                Controller controller = new Controller();
                loader.setController(controller);
                StackPane root = loader.load();
                Scene secondWindowScene = new Scene(root);

                Stage secondWindowStage = new Stage();
                secondWindowStage.setScene(secondWindowScene);
                secondWindowStage.initStyle(StageStyle.UNDECORATED);
                secondWindowStage.show();

                Stage mainWindowStage = (Stage) UserName.getScene().getWindow();

                mainWindowStage.close();
            } catch (IOException e) {
                e.printStackTrace();

            }

        }

    }


