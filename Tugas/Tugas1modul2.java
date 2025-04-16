package Tugas;
import java.util.Scanner;

public class Tugas1modul2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Mahasiswa mahasiswa = new Mahasiswa("Bagas Dewantara", "202410370110441");
        Admin admin = new Admin("Admin441", "Password441", "Bagas Dewantara", "202410370110441");

        System.out.println("\nPilih login: ");
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

            admin.login(inputUsername,inputPassword);
        } else if (choice == 2){
            System.out.print("Masukkan nama: ");
            String inputNama = scan.nextLine();
            System.out.print("Masukkan nim: ");
            String inputNim = scan.nextLine();

            mahasiswa.login(inputNama, inputNim);
        }else{
            System.out.print("Bro really ?");
        }

        scan.close();
    }
}
