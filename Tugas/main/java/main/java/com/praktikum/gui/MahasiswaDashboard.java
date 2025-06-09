package main.java.com.praktikum.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import main.java.com.praktikum.users.Mahasiswa;
import main.java.com.praktikum.data.*;

public class MahasiswaDashboard {
    private Stage stage;
    private Mahasiswa mhs;

    public MahasiswaDashboard(Stage stage, Mahasiswa mhs) {
        this.stage = stage;
        this.mhs = mhs;
    }

    private VBox buildMainLayout() {
        VBox layout = new VBox(10);
        Label welcome = new Label("Halo, " + mhs.getNama());

        Button laporBtn = new Button("Laporkan Barang");
        Button lihatLaporanBtn = new Button("Lihat Laporan");
        Button logoutBtn = new Button("Logout");

        laporBtn.setOnAction(e -> showReportForm());
        lihatLaporanBtn.setOnAction(e -> showReportList());
        logoutBtn.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(stage);
            stage.setScene(new Scene(loginPane.getLayout(), 400, 300));
        });

        layout.getChildren().addAll(welcome, laporBtn, lihatLaporanBtn, logoutBtn);
        return layout;
    }

    private void showReportForm() {
        TextField namaField = new TextField();
        TextField deskripsiField = new TextField();
        TextField lokasiField = new TextField();
        Button kirim = new Button("Kirim");

        VBox form = new VBox(10, new Label("Nama Barang:"), namaField,
                new Label("Deskripsi:"), deskripsiField,
                new Label("Lokasi:"), lokasiField, kirim);

        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        kirim.setOnAction(ev -> {
            Item item = new Item(namaField.getText(), deskripsiField.getText(), lokasiField.getText(), "Reported");
            DataStore.reportedItem.add(item);
            showAlert("Laporan dikirim.");

            // Kembali ke menu utama mahasiswa
            VBox mainLayout = buildMainLayout();
            stage.setScene(new Scene(mainLayout, 500, 400));
        });

        stage.setScene(new Scene(form, 400, 300));
    }

    private void showReportList() {
        TextArea laporan = new TextArea();
        for (Item item : DataStore.reportedItem) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                laporan.appendText(item.getItemName() + " - " + item.getLocation() + "\n");
            }
        }
        Button kembali = new Button("Kembali");
        kembali.setOnAction(ev -> {
            VBox mainLayout = buildMainLayout();
            stage.setScene(new Scene(mainLayout, 500, 400));
        });

        VBox box = new VBox(10, new Label("Laporan Barang:"), laporan, kembali);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));

        stage.setScene(new Scene(box, 500, 400));
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.showAndWait();
    }

    public VBox getLayout() {
        return buildMainLayout();
    }
}
