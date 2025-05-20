package codelabModul5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args){
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        daftarBarang.add(new Barang("Pensil", 100));
        boolean run = true;

        while (run) {
            //isi kontennya
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kuramgi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan anda: ");

            int opsi = -1;
            try {//isi sistem
                opsi = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input stok harus berupa angka!");//error handling
                scan.nextLine();
                continue;
            }

            switch (opsi) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String name = scan.nextLine();
                    System.out.print("Masukkan stok awal: ");
                    try {//logika program
                        int stok = scan.nextInt();
                        scan.nextLine();
                        daftarBarang.add(new Barang(name, stok));
                        System.out.println("Barang " +name+ " berhasil ditambahkan");
                        System.out.println();
                    } catch (InputMismatchException e) {//error handling
                        System.out.println("Input harus berupa angka!");
                        scan.nextLine();
                        System.out.println();
                    }
                    break;

                case 2:
                    if(daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong");
                    } else {
                        System.out.println();
                        System.out.println("=== Daftar Barang ===");
                        int index = 0;
                        for (Barang b : daftarBarang) {
                            System.out.println(index+ " Nama: " +b.getName()+ " stok: " +b.getStok());
                            index++;
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()){
                        System.out.println("Tidak ada barang untuk dikurangi.");
                        break;
                    }

                    System.out.println();
                    System.out.println("=== Daftar Barang ===");
                    for (int i = 0; i < daftarBarang.size(); i++){
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " +b.getName()+ " (stok: " +b.getStok()+ ")");
                    }

                    try {//logika pemograman
                        System.out.print("Masukkan nomer indeks barang: ");
                        int indeks = scan.nextInt();
                        scan.nextLine();

                        Barang barangDipilih = daftarBarang.get(indeks);

                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlah = scan.nextInt();
                        scan.nextLine();

                        if (jumlah > barangDipilih.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " +barangDipilih.getName()+ " hanya tersisa " +barangDipilih.getStok());
                        }//melempar ke class StokTidakCukupException

                        barangDipilih.setStok((barangDipilih.getStok()) - jumlah);
                        System.out.println("Stok barang " +barangDipilih.getName()+ " berhasil dikurangi. sisa stok: " +barangDipilih.getStok());
                        System.out.println();//logika pemogramannya

                    } catch (InputMismatchException e) {//error handling
                        System.out.println("Input harus berupa angka!");
                        scan.nextLine();
                        System.out.println();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index tidak valid.");
                        System.out.println();
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;

                case 0:
                    run = false;
                    System.out.println("Terimakasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silahkan pilih kembali.");
                    System.out.println();
            }
        }

        scan.close();
    }
}
