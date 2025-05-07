package com.praktikum.main;

import com.praktikum.users.*;

import java.util.Scanner;

public class tugasModul4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Admin admin = new Admin("Admin441", "Password441", "Bagas Dewantara", "202410370110441");
        Mahasiswa mahasiswa = new Mahasiswa("Bagas Dewantara", "202410370110441");

        System.out.println("\n=== Pilih login ===");
        System.out.println("1. Admin ");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan anda: ");
        int choice = scan.nextInt();
        scan.nextLine();

        if(choice == 1){
            System.out.print("Masukkan username: ");
            String inputUsername = scan.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = scan.nextLine();

            if (admin.login(inputUsername, inputPassword)){
                admin.displayAppMenu();
            }

        } else if (choice == 2){
            System.out.print("Masukkan nama: ");
            String inputNama = scan.nextLine();
            System.out.print("Masukkan nim: ");
            String inputNim = scan.nextLine();

            if (mahasiswa.login(inputNama, inputNim)){
                mahasiswa.displayAppMenu();
            }

        }else{
            System.out.print("Bro really ?");
        }
        scan.close();
    }
}
