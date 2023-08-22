package pl.learning.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");

    public static void dialogAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(bundle.getString("about.title"));
        alert.setHeaderText(bundle.getString("about.header"));
        alert.setContentText(bundle.getString("about.content"));
        alert.showAndWait();
    }

    public static Optional<ButtonType> dialogExit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("exit.title"));
        alert.setHeaderText(bundle.getString("exit.header"));
        Optional<ButtonType> result = alert.showAndWait();
        return result;
    }
}
