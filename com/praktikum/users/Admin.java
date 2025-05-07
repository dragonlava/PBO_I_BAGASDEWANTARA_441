package com.praktikum.users;

import com.praktikum.actions.AdminActions;

import java.util.Scanner;

public class Admin extends User implements AdminActions {
    String username;
    String password;

    public Admin(String username, String password, String nama, String nim){
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void displayInfo(){
        System.out.println();
        System.out.println("Sukses");
        System.out.println();
        System.out.println("Admin: ");
        System.out.println("Nama : " +getNama());
        System.out.println("Nim  : " +getNim());
        System.out.println();
        System.out.println("Apa yang ingin anda lakukan hari ini ?");
    }

    @Override
    public boolean login(String inputUsername, String inputPassword){
        if(this.username.equals(inputUsername) && this.password.equals(inputPassword)){
            displayInfo();
            return true;
        }else{
            System.out.println("Gagal");
            return false;
        }
    }

    @Override
    public void manageItems(){
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUser(){
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            choice = sc.nextInt();
            System.out.println();

            switch (choice){
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUser();
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
