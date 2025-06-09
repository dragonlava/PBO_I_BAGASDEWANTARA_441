package main.java.com.praktikum.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.users.*;

public class LoginPane {
    private VBox layout = new VBox(10);

    public LoginPane(Stage stage) {
        Label label = new Label("Login sebagai:");
        Button hafidBtn = new Button("Hehe");

        ToggleGroup group = new ToggleGroup();
        RadioButton adminRadio = new RadioButton("Admin");
        RadioButton mahasiswaRadio = new RadioButton("Mahasiswa");
        RadioButton hafid = new RadioButton("hehe");
        adminRadio.setToggleGroup(group);
        mahasiswaRadio.setToggleGroup(group);
        hafid.setToggleGroup(group);

        Button lanjutBtn = new Button("Lanjut");

        TextField waduh = new TextField();

        lanjutBtn.setOnAction(e -> {
            if (adminRadio.isSelected()) {
                showAdminLogin(stage);
            } else if (mahasiswaRadio.isSelected()) {
                showMahasiswaLogin(stage);
            } else {
                showAlert("Silakan pilih jenis login terlebih dahulu.");
            }
        });

        layout.getChildren().addAll(label, adminRadio, mahasiswaRadio, lanjutBtn, hafidBtn, waduh);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
    }

    private void showAdminLogin(Stage stage) {
        VBox adminLayout = new VBox(10);
        adminLayout.setAlignment(Pos.CENTER);
        adminLayout.setPadding(new Insets(20));

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginBtn = new Button("Login");

        adminLayout.getChildren().addAll(new Label("Username:"), usernameField,
                new Label("Password:"), passwordField, loginBtn);

        loginBtn.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Semua field harus diisi.");
                return;
            }

            User user = DataStore.login(username, password);
            if (user instanceof Admin admin) {
                showAlert("Login berhasil sebagai admin.");
                AdminDashboard dash = new AdminDashboard(stage, admin);
                stage.setScene(new Scene(dash.getLayout(), 500, 400));
            } else {
                showAlert("Login gagal sebagai admin.");
            }
        });

        stage.setScene(new Scene(adminLayout, 300, 200));
    }

    private void showMahasiswaLogin(Stage stage) {
        VBox mhsLayout = new VBox(10);
        mhsLayout.setAlignment(Pos.CENTER);
        mhsLayout.setPadding(new Insets(20));

        TextField namaField = new TextField();
        TextField nimField = new TextField();
        Button loginBtn = new Button("Login");

        mhsLayout.getChildren().addAll(new Label("Nama:"), namaField,
                new Label("NIM:"), nimField, loginBtn);

        loginBtn.setOnAction(e -> {
            String nama = namaField.getText().trim();
            String nim = nimField.getText().trim();

            if (nama.isEmpty() || nim.isEmpty()) {
                showAlert("Nama dan NIM wajib diisi.");
                return;
            }

            User user = DataStore.login(nama, nim);
            if (user instanceof Mahasiswa mhs) {
                showAlert("Login berhasil sebagai mahasiswa.");
                MahasiswaDashboard dash = new MahasiswaDashboard(stage, mhs);
                stage.setScene(new Scene(dash.getLayout(), 500, 400));
            } else {
                showAlert("Login gagal sebagai mahasiswa.");
            }
        });

        stage.setScene(new Scene(mhsLayout, 300, 200));
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.showAndWait();
    }

    public VBox getLayout() {
        return layout;
    }
}
