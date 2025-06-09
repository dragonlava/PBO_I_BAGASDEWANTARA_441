module com.example.projekSceneBuilder {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    exports main.java.com.praktikum.gui;
    exports main.java.com.praktikum.users;
    exports main.java.com.praktikum.data;
    exports main.java.com.praktikum.main;
    exports main.java.com.praktikum.actions;

    opens com.example.SceneBuilder to javafx.fxml;
    exports com.example.SceneBuilder;
}