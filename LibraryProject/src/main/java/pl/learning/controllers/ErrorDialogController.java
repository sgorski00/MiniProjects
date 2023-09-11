package pl.learning.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pl.learning.utils.DialogsUtil;

public class ErrorDialogController {
    @FXML
    private Label attachmentLabel;

    @FXML
    private void highlightText(){
        attachmentLabel.underlineProperty().set(true);
        attachmentLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
    }

    @FXML
    private void disHighlightText(){
        attachmentLabel.underlineProperty().set(false);
        attachmentLabel.setFont(Font.font("System",12));
    }

    @FXML
    private void openBugReportWindow() {
        closeWindow();
        DialogsUtil.dialogReportBug();
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) attachmentLabel.getScene().getWindow();
        stage.close();
    }
}
