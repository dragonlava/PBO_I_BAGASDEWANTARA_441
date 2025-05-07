package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
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
        if(this.getNama().equals(inputNama) && this.getNim().equals(inputNim)){
            displayInfo();
            return true;
        }else{
            System.out.println("Gagal");
            return false;
        }
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

        System.out.println("Barang berhasil dicatat");
    }

    @Override
    public void viewReportedItems(){
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu(){
        int choice;

        do {
            System.out.println("=== Menu Mahasiswa ===");
            System.out.println("1. Laporan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            choice = scan.nextInt();
            scan.nextLine();

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
