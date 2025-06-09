package main.java.com.praktikum.users;

import main.java.com.praktikum.data.*;
import main.java.com.praktikum.actions.MahasiswaActions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions{
    Scanner scan = new Scanner(System.in);

    public Mahasiswa(String nama, String nim){
        super(nama, nim);
    }

    @Override
    public void displayInfo(){
        System.out.println("Berhasil");
        System.out.println();
        System.out.println("Mahasiswa: ");
        System.out.println("Nama     : " +getNama());
        System.out.println("Nim      : " +getNim());
        System.out.println();
        System.out.println("Apa yang ingin anda lakukan hari ini ?");
        System.out.println();
    }

    @Override
    public boolean login(String inputNama, String inputNim){
        return this.getNama().equals(inputNama) && this.getNim().equals(inputNim);
    }

    @Override
    public void reportItem(){
        System.out.print("Masukkan nama barang: ");
        String inputNama = scan.nextLine();
        System.out.print("Masukkan deskripsi barang: ");
        String inputDeskripsi = scan.nextLine();
        System.out.print("Masukkan lokasi terkahir barang ditemukan: ");
        String inputLokasi = scan.nextLine();
        System.out.println();

        Item item = new Item(inputNama, inputDeskripsi, inputLokasi, "Reported");
        DataStore.reportedItem.add(item);

        System.out.println("Barang berhasil dicatat");
        System.out.println();
    }

    @Override
    public void viewReportedItems(){
        if (DataStore.reportedItem.isEmpty()){
            System.out.println("Belum ada laporan barang");
            return;
        }

        System.out.println("Daftar Barang yang Dilaporkan");
        int i = 1;
        for (Item item : DataStore.reportedItem){
            if("Reported".equalsIgnoreCase(item.getStatus())){
                System.out.println(i++ + ". " + item.getItemName() + " | " + item.getDescription() + " | " + item.getLocation());
            }
        }

        System.out.println();
    }

    @Override
    public void displayAppMenu(){
        int choice = 0;

        do {
            System.out.println("=== Menu Mahasiswa ===");
            System.out.println("1. Laporan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            try {
                choice = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Input harus berupa angka");
                scan.nextLine();
                continue;
            }

            System.out.println();

            switch (choice){
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }while (choice != 0);
    }
}
