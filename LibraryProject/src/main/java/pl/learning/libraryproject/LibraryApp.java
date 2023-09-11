package pl.learning.libraryproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pl.learning.utils.FxmlUtils;

import java.util.Locale;
import java.util.Objects;

/*
 * The LibraryProject is an app where you can save your favourite books,
 * see stats etc.
 * @author Sebastian Górski
 * @version 1.0
 * @since 09.08.2023
 */

//#30
public class LibraryApp extends Application {

    public static final String MAIN_SCENE_FXML = "/fxml/MainScene.fxml";
    public static final String APP_ICON_PATH = "/icons/app_icon.png";

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(FxmlUtils.fxmlloader(MAIN_SCENE_FXML));
        stage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(LibraryApp.class.getResourceAsStream(APP_ICON_PATH))));
        stage.show();
    }

    public static void main(String[] args) {
//        Locale.setDefault(Locale.ENGLISH);
        launch();
    }
}