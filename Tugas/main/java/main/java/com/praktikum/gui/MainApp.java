package main.java.com.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import main.java.com.praktikum.data.DataStore;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        DataStore.intiData();

        LoginPane loginPane = new LoginPane(primaryStage);
        Scene scene = new Scene(loginPane.getLayout(), 400, 300);

        primaryStage.setTitle("Aplikasi Barang Hilang");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//buat button, textfield,