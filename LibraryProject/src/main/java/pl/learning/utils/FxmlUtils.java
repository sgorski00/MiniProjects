package pl.learning.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

public class FxmlUtils {
    public static Pane fxmlloader(String fxmlPath){
        FXMLLoader fxmlLoader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        fxmlLoader.setResources(getResourceBundle());
        try {
            return fxmlLoader.load();
        } catch (Exception e) {
            DialogsUtil.dialogError(e.getMessage());
        }
        return null;
    }

    public static ResourceBundle getResourceBundle(){
        return ResourceBundle.getBundle("bundles.messages");
    }
}
