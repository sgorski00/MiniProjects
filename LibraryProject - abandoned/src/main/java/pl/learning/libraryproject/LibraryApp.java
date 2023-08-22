package pl.learning.libraryproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/*
 * The LibraryProject is an app where you can save your favourite books,
 * see stats etc.
 * @author Sebastian Górski
 * @version 1.0
 * @since 09.08.2023
 */

//#30
public class LibraryApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/MainScene.fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        fxmlLoader.setResources(bundle);
        BorderPane mainBorderPane = fxmlLoader.load();
        Scene scene = new Scene(mainBorderPane);
        stage.setTitle(bundle.getString("tittle.application"));
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(LibraryApp.class.getResourceAsStream("/icons/app_icon.png"))));
        stage.show();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        launch();
    }
}