package main.java.com.praktikum.main;

import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.users.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        DataStore.intiData();

        System.out.println("\n=== Pilih login ===");
        System.out.println("1. Admin ");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan anda: ");
        int choice = scan.nextInt();
        scan.nextLine();

        User user = null;
        if(choice == 1){
            System.out.print("Masukkan username: ");
            String inputUsername = scan.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = scan.nextLine();

            user = DataStore.login(inputUsername, inputPassword);
        } else if (choice == 2){
            System.out.print("Masukkan nama: ");
            String inputNama = scan.nextLine();
            System.out.print("Masukkan nim: ");
            String inputNim = scan.nextLine();

            user = DataStore.login(inputNama, inputNim);
        }

        if (user != null){
            user.displayInfo();
            user.displayAppMenu();
        } else {
            System.out.println("logih gagal");
        }
        scan.close();
    }
}
