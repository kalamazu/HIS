package com.hos.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerMedicine {
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private Label Age;

    @FXML
    private Button Check;

    @FXML
    private Label Gender;

    @FXML
    private Label IDNumber;

    @FXML
    private TableView<?> MedicineDetail;

    @FXML
    private Label Name;

    @FXML
    private AnchorPane Pane;

    @FXML
    private TextField PatienceNumber;

    @FXML
    private Button Save;

    @FXML
    private Label TotalFee;


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
    void Close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
