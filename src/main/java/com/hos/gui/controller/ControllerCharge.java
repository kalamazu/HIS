package com.hos.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerCharge {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private AnchorPane Pane;

    @FXML
    private TextField ActuallyCharge;

    @FXML
    private TextField Age;

    @FXML
    private DatePicker BirthDate;


    @FXML
    private Button Close;

    @FXML
    private ChoiceBox<?> Doctor;

    @FXML
    private RadioButton GenderFemale;

    @FXML
    private RadioButton GenderMale;

    @FXML
    private TextField HomeAddress;

    @FXML
    private TextField IdNumber;

    @FXML
    private CheckBox MedicalHistoryBook;

    @FXML
    private TextField Name;

    @FXML
    private ChoiceBox<?> NumberInLine;

    @FXML
    private TextField PatienceNumber;

    @FXML
    private ChoiceBox<?> Room;


    @FXML
    private DatePicker Time;

    @FXML
    private Button register;
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
    private void Close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML//挂号按钮
    void onRegisterButton(ActionEvent event) {

    }
    @FXML
    void checkDoctor(ActionEvent event) {

    }
    //Test
}
