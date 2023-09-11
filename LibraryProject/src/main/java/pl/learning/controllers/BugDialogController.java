package pl.learning.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class BugDialogController{
    @FXML
    private TextArea bugDescription;

    @FXML
    private void sendMail(){
        //add sending mails
    }

    @FXML
    private void exit(){
        getBugStage().close();
    }

    private Stage getBugStage(){
        return (Stage) bugDescription.getScene().getWindow();
    }
}
