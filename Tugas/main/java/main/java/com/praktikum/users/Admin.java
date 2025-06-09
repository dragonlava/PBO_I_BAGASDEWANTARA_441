package main.java.com.praktikum.users;

import main.java.com.praktikum.actions.AdminActions;
import main.java.com.praktikum.data.*;

import java.util.Scanner;

public class Admin extends User implements AdminActions{
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
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void manageItems(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println();
            System.out.println("=== Kelola Barang ===");
            System.out.println("1. Lihat semua barang");
            System.out.println("2. Tandai barang sudah diambil(claimed)");
            System.out.println("0. Kemballi");
            System.out.print("Masukkan pilihan anda: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Input harus berupa angka!");
                sc.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    if (DataStore.reportedItem.isEmpty()){
                        System.out.println("Tidak ada laporan barang");
                    } else {
                        for (int  i = 0; i < DataStore.reportedItem.size(); i++){
                            Item item = DataStore.reportedItem.get(i);
                            System.out.println((i + 1) + ". " + item.getItemName() + " | " + item.getDescription() + " | " + item.getStatus() + " | " + item.getLocation());
                        }
                    }
                    break;

                case 2:
                    int index;
                    System.out.println("Barang yang dilaporkan");
                    for (int i = 0; i < DataStore.reportedItem.size(); i++){
                        Item item = DataStore.reportedItem.get(i);
                        if ("Reported".equalsIgnoreCase(item.getStatus())){
                            System.out.println(i + ". " + item.getItemName() + " | " + item.getDescription() + " | " + item.getStatus() + " | " + item.getLocation());
                        }
                    }

                    System.out.print("Masukkan index barang yang ingin ditandai: ");
                    try {
                        index = sc.nextInt();
                        sc.nextLine();

                        Item selected = DataStore.reportedItem.get(index);
                        selected.setStatus("Claimned");
                        System.out.println("Barang berhasil ditandai sebagai (claimed)");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Index tidak valid!");
                    }catch (Exception e){
                        System.out.println("Input harus berupa angka!");
                        sc.nextLine();
                    }
                    break;

                case 0:
                    System.out.println("Kembali ke menu.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }while (choice != 0);
    }

    @Override
    public void manageUser(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println();
            System.out.println("=== Kelola Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan anda: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();
            }catch (Exception e){
                System.out.println("Input harus berupa angka");
                sc.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = sc.nextLine();

                    DataStore.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
                    nim = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < DataStore.userList.size(); i++){
                        User user = DataStore.userList.get(i);
                        if (user instanceof Mahasiswa && user.getNim().equals(nim)){
                            DataStore.userList.remove(i);
                            System.out.println("Mahasiswa berhasil dihapus.");
                            found = true;
                            break;
                        }
                    }

                    if (!found){
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan");
                    }

                case 0:
                    System.out.println("Kembali ke menu");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }while (choice != 0);
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
