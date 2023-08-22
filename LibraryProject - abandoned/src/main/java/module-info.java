module pl.learning.libraryproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens pl.learning.libraryproject to javafx.fxml;
    exports pl.learning.libraryproject;

    opens pl.learning.controllers to javafx.fxml;
    exports pl.learning.controllers;
}