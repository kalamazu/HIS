package com.hos.gui.controller;



import com.hos.gui.utils.SQL_UTILS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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
    private PasswordField Password;

    @FXML
    private TextField UserName;

    @FXML
    private Label message;


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

     /**
      * 登录校验
      */
     if(SQL_UTILS.getInstance().Login(UserName.getText(), Password.getText())
             && SQL_UTILS.getInstance().isValidPassword(Password.getText())
             && SQL_UTILS.getInstance().isValidUsername(UserName.getText())) {


         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Main.fxml"));
             ControllerOption controller = new ControllerOption();
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
     else{
         if (!(SQL_UTILS.getInstance().isValidPassword(Password.getText()))) {
             message.setText("密码非法,密码可以包含字母、数字和特殊字符");
         }
         else if(!(SQL_UTILS.getInstance().isValidPassword(UserName.getText()))){
             message.setText("用户名非法,用户名只能包含字母、数字和下划线");
         }
         else if(!(SQL_UTILS.getInstance().Login(UserName.getText(), Password.getText()))){
             message.setText("账号或密码错误");
         }
         UserName.setText("");
         Password.setText("");


     }
 }
    @FXML
    void register(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hos/gui/Register.fxml"));
            ControllerRegister controller = new ControllerRegister();
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


}

