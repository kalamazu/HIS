package com.hos.gui.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Controller {




    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private Label label;

    @FXML
    private AnchorPane Pane;

    @FXML
    public Button login;

    @FXML
    private void initialize(){

    }

    @FXML
    private void Close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML
    private void Minimize(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
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
    public void openOptionWindows(ActionEvent event){
     try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Main.fxml"));
         ControllerOption controller=new ControllerOption();
         loader.setController(controller);
         StackPane root = loader.load();
         Scene secondWindowScene = new Scene(root);

         Stage secondWindowStage = new Stage();
         secondWindowStage.setScene(secondWindowScene);
         secondWindowStage.initStyle(StageStyle.UNDECORATED);
         secondWindowStage.show();

         Stage mainWindowStage = (Stage) login.getScene().getWindow();

         mainWindowStage.close();
     } catch (IOException e) {
         e.printStackTrace();

     }

 }
}

