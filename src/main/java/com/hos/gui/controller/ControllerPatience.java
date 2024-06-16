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
        Patient patient = SQL_UTILS.getInstance().getPatientById(PatienceNumber.getText());
        String medicalCertificate = MedicalCertificate.getText();
        String medicineList = MedicineList.getText();
        double totalFee = Double.parseDouble(TotalFee.getText());

        // 设置新的值到Patient对象中
        patient.setDiagiosis(medicalCertificate);
        patient.setPrescription(medicineList);
        patient.setDrugprice(totalFee);
        // 更新病人信息
        SQL_UTILS sqlUtils = SQL_UTILS.getInstance();
        sqlUtils.updatePatient(patient);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    /**
     * 查询并且回显
     * @param event
     */
    @FXML//查询按钮
    void onCheckButton(ActionEvent event) {
        // 获取用户输入的病历号
        String patientNumber = PatienceNumber.getText();

        // 查询数据库，获取患者信息
        Patient patient = SQL_UTILS.getInstance().getPatientById(PatienceNumber.getText());

        // 打印患者信息到控制台
        System.out.println(patient);

        // 更新界面上的Label
        if (patient != null) {
            if ("male".equalsIgnoreCase(patient.getGender())) {
                Gender.setText("男");
            } else if ("female".equalsIgnoreCase(patient.getGender())) {
                Gender.setText("女");
            } else {
                Gender.setText("其他");
            }
            Room.setText(patient.getDeptname());
            Name.setText(patient.getRealname());
            Age.setText(String.valueOf(patient.getAge()));
            IDNumber.setText(patient.getCardnumber());
            Doctor.setText(patient.getDoctorname());
            Level.setText(patient.getRegistlevel());
            Time.setText(patient.getRegistdate());
            TotalFee.setText(String.valueOf(patient.getDrugprice()));
            MedicineList.setText(patient.getPrescription());
            MedicalCertificate.setText(patient.getDiagiosis());
        } else {
            // 如果未找到患者，清空相应的Label
            Room.setText("");
            Name.setText("");
            Age.setText("");
            Gender.setText("");
            IDNumber.setText("");
            Doctor.setText("");
            Level.setText("");
            Time.setText("");
            TotalFee.setText("");
            MedicineList.setText("");
            MedicalCertificate.setText("");
            System.out.println("未找到该患者");

        }
    }
}
