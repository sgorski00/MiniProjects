package pl.learning.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {
    private static final String LIBRARY_FXML = "/fxml/bookmarks/LibraryScene.fxml";
    private static final String LIST_OF_BOOKS_FXML = "/fxml/bookmarks/ListOfBooksScene.fxml";
    private static final String STATS_FXML = "/fxml/StatsScene.ml";
    private static final String ADD_BOOK_FXML = "/fxml/bookmarks/AddBookForm.fxml";
    private MainSceneController mainSceneController;

    @FXML
    private ToggleGroup topMenuToggleButtons;

    @FXML
    private ToggleButton library;

    void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    @FXML
    private void initialize() {
        library.setSelected(true);
    }

    @FXML
    private void goToLibrary(){
        mainSceneController.setCenter(LIBRARY_FXML);
    }

    @FXML
    private void goToListOfBooks() {
        mainSceneController.setCenter(LIST_OF_BOOKS_FXML);
    }

    @FXML
    private void goToStats() {
        mainSceneController.setCenter(STATS_FXML);
    }

    @FXML
    private void goToAddBookForm() {
        if(topMenuToggleButtons.getSelectedToggle() != null){
            topMenuToggleButtons.getSelectedToggle().setSelected(false);
        }
        mainSceneController.setCenter(ADD_BOOK_FXML);
    }

    public void setMainCenter(){
        library.fire();
    }
}
