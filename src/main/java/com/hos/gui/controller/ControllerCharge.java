package com.hos.gui.controller;

import com.hos.gui.entity.Doctor;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerCharge implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    private Patient patient = new Patient();

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

        SQL_UTILS.getInstance().createPatient(patient);
        Double fee = patient.getRegistfee();

        Image image = new Image("/scanme.jpg");

        ImageView imageView = new ImageView(image);
/*        imageView.setFitWidth(224.8);
        imageView.setFitHeight(164.8);*/
        imageView.setPreserveRatio(true);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeight(224.8);
        alert.setWidth(164.8);
        alert.setTitle("图片弹出窗口");
        alert.setHeaderText(null);
        alert.setGraphic(imageView);


        alert.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Room.getItems().addAll("心脏科", "神经科", "骨科","儿科");
       NumberInLine.getItems().addAll("普通","主任医师","专家");

    }

    @FXML
    void checkDoctor(ActionEvent event) {

        patient.setAge((Integer.parseInt(Age.getText())));//年龄
        if(GenderFemale.isSelected())
            patient.setGender("Female");
        else if(GenderMale.isSelected())
            patient.setGender("Male"); //性别
        patient.setHomeaddress(HomeAddress.getText());
        //住址
        patient.setRealname(Name.getText());
        //病人姓名
        patient.setId((Integer.parseInt(PatienceNumber.getText())));
        //病例号
        patient.setCardnumber(IdNumber.getText());
        //身份证号
/*        patient.setRegistfee(Double.parseDouble(ActuallyCharge.getText()));
        //实付费用*/
        patient.setIsbook(MedicalHistoryBook.isSelected());
        //病历本
        patient.setRegistdate(Time.getValue().toString());
        //挂号日期
        patient.setBirthdate(BirthDate.getValue().toString());
        //生日
        patient.setDeptname(Room.getValue());
        //科室
        patient.setRegistlevel(NumberInLine.getValue());
        //号别

        List<Doctor> doctors = SQL_UTILS.getInstance().getDoctorsByDep(Room.getValue(), NumberInLine.getValue());

        if(doctors == null)
            Doctor.getItems().addAll("没有此类医生");
        else {

            for (int i = 0; i < doctors.size(); i++) {
                com.hos.gui.entity.Doctor s = doctors.get(i);
                Doctor.getItems().add(s.getRealname());
            }
        }

        patient.setDoctorname(Doctor.getValue());//挂号医生
    }
    //Test
}
