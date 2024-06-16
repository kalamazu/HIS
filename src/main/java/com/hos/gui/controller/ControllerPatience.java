package com.hos.gui.controller;

import com.hos.gui.entity.Patient;
import com.hos.gui.utils.SQL_UTILS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerPatience {
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane Pane;
    @FXML
    private Label Age;

    @FXML
    private Button Check;

    @FXML
    private Button Close;

    @FXML
    private Label Doctor;

    @FXML
    private Label Gender;

    @FXML
    private Label IDNumber;

    @FXML
    private Label Level;

    @FXML
    private TextField MedicalCertificate;

    @FXML
    private TextField MedicineList;

    @FXML
    private Label Name;

    @FXML
    private TextField PatienceNumber;

    @FXML
    private Label Room;

    @FXML
    private Button Save;

    @FXML
    private Label Time;

    @FXML
    private TextField TotalFee;
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

    @FXML//保存按钮
    void onSaveButton(ActionEvent event) {
        /**
         * 保存到数据库中
         */


    }
    @FXML//查询按钮
    void onCheckButton(ActionEvent event) {
        /**
         * 查询修改
         */
        //示例
        //PatienceNumber
        Patient patient = SQL_UTILS.getInstance().getPatientByName(PatienceNumber.getText());
        System.out.println(patient);
        Room.setText(patient.getDeptname());

    }

}
