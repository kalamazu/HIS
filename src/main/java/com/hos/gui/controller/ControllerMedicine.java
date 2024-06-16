package com.hos.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextField MedicineDetail;


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

    }

    @FXML//查询按钮
    void onCheckButton(ActionEvent event) {

    }
    @FXML//确认发药按钮
    void onConfirmButton(ActionEvent event) {
        Image image = new Image("/scanme.jpg");

        ImageView imageView = new ImageView(image);
/*        imageView.setFitWidth(3000);
        imageView.setFitHeight(2000);*/
        imageView.setPreserveRatio(true);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeight(1124);
        alert.setWidth(824);
        alert.setTitle("图片弹出窗口");
        alert.setHeaderText(null);
        alert.setGraphic(imageView);


        alert.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

}
