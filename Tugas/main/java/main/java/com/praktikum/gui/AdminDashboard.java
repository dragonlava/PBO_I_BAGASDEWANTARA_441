package main.java.com.praktikum.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import main.java.com.praktikum.data.*;
import main.java.com.praktikum.users.Admin;

public class AdminDashboard {
    private Stage stage;
    private Admin admin;

    public AdminDashboard(Stage stage, Admin admin) {
        this.stage = stage;
        this.admin = admin;
    }

    public VBox getLayout() {
        return buildMainLayout();
    }

    private VBox buildMainLayout() {
        VBox layout = new VBox(10);

        Label welcome = new Label("Selamat datang, " + admin.getNama());

        Button kelolaBarangBtn = new Button("Kelola Barang");
        Button kelolaUserBtn = new Button("Kelola Mahasiswa");
        Button logoutBtn = new Button("Logout");

        kelolaBarangBtn.setOnAction(e -> showItemList());
        kelolaUserBtn.setOnAction(e -> showAlert("Fitur kelola mahasiswa belum dibuat."));

        logoutBtn.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(stage);
            stage.setScene(new Scene(loginPane.getLayout(), 400, 300));
        });

        layout.getChildren().addAll(welcome, kelolaBarangBtn, kelolaUserBtn, logoutBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        return layout;
    }

    private void showItemList() {
        VBox itemLayout = new VBox(10);
        Label title = new Label("Daftar Barang:");
        TextArea listArea = new TextArea();
        listArea.setEditable(false);

        for (Item item : DataStore.reportedItem) {
            listArea.appendText(item.getItemName() + " - " + item.getStatus() + "\n");
        }

        Button kembaliBtn = new Button("Kembali");
        kembaliBtn.setOnAction(e -> {
            VBox mainLayout = buildMainLayout();
            stage.setScene(new Scene(mainLayout, 500, 400));
        });

        itemLayout.getChildren().addAll(title, listArea, kembaliBtn);
        stage.setScene(new Scene(itemLayout, 500, 400));
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.showAndWait();
    }
}
