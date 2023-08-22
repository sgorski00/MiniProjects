package pl.learning.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.learning.dialogs.DialogsUtil;

import java.io.IOException;
import java.util.Optional;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;

public class MainSceneController {
    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private void initialize(){
        topMenuButtonsController.setMainSceneController(this);
        topMenuButtonsController.setMainCenter();
    }

    @FXML
    private void exitApp(){
        if(DialogsUtil.dialogExit().get() == ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    private void setStyleCaspian() {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
    }

    @FXML
    private void setStyleModena() {
        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
    }

    @FXML
    private void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) mainBorderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }

    @FXML
    private void goToAbout() {
        DialogsUtil.dialogAbout();
    }

    public void setCenter(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = fxmlLoader.load();
        mainBorderPane.setCenter(parent);
    }
}
