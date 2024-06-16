package com.hos.gui.controller;

import com.hos.gui.entity.Patient;
import com.hos.gui.utils.SQL_UTILS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCharge implements Initializable {
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
    private Label Change;

    @FXML
    private Label Charger;

    @FXML
    private Button Close;

    @FXML
    private ChoiceBox<String> Doctor;

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
    private ChoiceBox<String> NumberInLine;

    @FXML
    private TextField PatienceNumber;

    @FXML
    private ChoiceBox<String> Room;

    @FXML
    private Label ShouldCharge;

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


    @FXML
//挂号按钮
    void onRegisterButton(ActionEvent event) {
        Patient patient = new Patient();
        patient.setAge((Integer.parseInt(Age.getText())));//年龄
        if(GenderFemale.isSelected())
           patient.setGender("Female");
        else if(GenderMale.isSelected())
            patient.setGender("Male"); //性别
        patient.setHomeaddress(HomeAddress.getText());//住址
        patient.setRealname(Name.getText());//病人姓名
        patient.setId((Integer.parseInt(PatienceNumber.getText())));//病例号
        patient.setCardnumber(IdNumber.getText());//身份证号
        patient.setRegistfee(Double.parseDouble(ActuallyCharge.getText()));//实付费用
        patient.setIsbook(MedicalHistoryBook.isSelected());//病历本
        patient.setRegistdate(Time.getValue().toString());//挂号日期
        patient.setDeptname(Room.getValue());//科室
        patient.setBirthdate(BirthDate.getValue().toString());//生日
        for (Object s: SQL_UTILS.getInstance().getDoctorsByDep(Room.getValue(),NumberInLine.getValue())) {
            Doctor.getItems().addAll(s.toString());
        }
        patient.setDoctorname(Doctor.getValue());//挂号医生


        if(MedicalHistoryBook.isSelected()){
            ShouldCharge.setText(SQL_UTILS.getInstance().getDoctorByName(Doctor.getValue()).getRegistfee().toString() + 10);//应付金额
        }else{
            ShouldCharge.setText(SQL_UTILS.getInstance().getDoctorByName(Doctor.getValue()).getRegistfee().toString());//应付金额
        }


        patient.setRegistlevel(NumberInLine.getValue());//号别
        SQL_UTILS.getInstance().updatePatient(patient);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Room.getItems().addAll("心脏科", "神经科", "骨科","儿科");
       NumberInLine.getItems().addAll("普通","主任医师","专家");

    }
    //Test
}
