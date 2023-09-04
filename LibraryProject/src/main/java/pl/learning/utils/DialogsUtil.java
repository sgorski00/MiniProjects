package pl.learning.utils;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtil {
    private static final ResourceBundle BUNDLE = FxmlUtils.getResourceBundle();
    public static final String ERROR_DIALOG_FXML = "/fxml/dialogs/ErrorDialog.fxml";
    public static final String REPORT_BUG_DIALOG_FXML = "/fxml/dialogs/ReportBugDialog.fxml";

    public static void dialogAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(BUNDLE.getString("about.title"));
        alert.setHeaderText(BUNDLE.getString("about.header"));
        alert.setContentText(BUNDLE.getString("about.content"));
        alert.showAndWait();
    }

    public static Optional<ButtonType> dialogExit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(BUNDLE.getString("exit.title"));
        alert.setHeaderText(BUNDLE.getString("exit.header"));
        return alert.showAndWait();
    }

    public static void dialogError(String error){
        Pane pane = FxmlUtils.fxmlloader(ERROR_DIALOG_FXML);

        TextArea errorMessage = new TextArea(error);
        errorMessage.setLayoutX(12);
        errorMessage.setLayoutY(56);
        errorMessage.setPrefSize(275, 50);
        errorMessage.disableProperty().set(true);
        Objects.requireNonNull(pane).getChildren().add(errorMessage);

        Scene scene = new Scene(pane);
        Stage errorStage = new Stage();
        errorStage.setTitle(BUNDLE.getString("error.title"));
        errorStage.setScene(scene);
        errorStage.show();
        errorStage.setAlwaysOnTop(true);
    }

    public static void dialogReportBug(){
        Pane pane = FxmlUtils.fxmlloader(REPORT_BUG_DIALOG_FXML);
        Scene scene = new Scene(pane);
        Stage bugStage = new Stage();
        bugStage.setScene(scene);
        bugStage.setTitle(BUNDLE.getString("bug.title"));
        bugStage.show();
    }
}
