package pl.learning.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class TopMenuButtonsController {
    private static final String LIBRARY_PATH = "/fxml/LibraryScene.fxml";
    private static final String LIST_OF_BOOKS_PATH = "/fxml/ListOfBooksScene.fxml";
    private static final String STATS_PATH = "/fxml/StatsScene.fxml";
    private static final String ADD_BOOK_PATH = "/fxml/AddBookForm.fxml";
    private MainSceneController mainSceneController;

    @FXML
    private ToggleGroup topMenuToggleButtons;

    @FXML
    private ToggleButton library;

    void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    @FXML
    private void initialize() throws IOException {
        library.setSelected(true);
    }

    @FXML
    private void goToLibrary() throws IOException {
        mainSceneController.setCenter(LIBRARY_PATH);
    }

    @FXML
    private void goToListOfBooks() throws IOException {
        mainSceneController.setCenter(LIST_OF_BOOKS_PATH);
    }

    @FXML
    private void goToStats() throws IOException {
        mainSceneController.setCenter(STATS_PATH);
    }

    @FXML
    private void goToAddBookForm() throws IOException {
        if(topMenuToggleButtons.getSelectedToggle() != null){
            topMenuToggleButtons.getSelectedToggle().setSelected(false);
        }
        mainSceneController.setCenter(ADD_BOOK_PATH);
    }

    public void setMainCenter(){
        library.fire();
    }
}
