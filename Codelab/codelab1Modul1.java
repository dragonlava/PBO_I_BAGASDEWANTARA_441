package Codelab;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class codelab1Modul1 {
        public static void main(String[] args) {
            LocalDateTime sekarang = LocalDateTime.now();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyy");
            int tahunSekarang = Integer.parseInt(sekarang.format(formater));
            Scanner zeta = new Scanner(System.in);

            System.out.print("Masukkan nama anda: ");
            String nama = zeta.nextLine();

            char kelamin;
            String jenisKelamin = "";
            do{
                System.out.print("Masukkan jenis kelamin anda(p/l): ");
                kelamin = zeta.next().charAt(0);

                if (kelamin == 'p'){
                    jenisKelamin = "perempuan";
                }else if (kelamin == 'l'){
                    jenisKelamin = "Laki - laki";
                }else{
                    System.out.println("input tidak valid, silahkan masukkan p atau l");
                }
            }while(kelamin != 'p' && kelamin != 'l');

            System.out.print("Masukkan tahun lahir anda: ");
            int tahunLahir = zeta.nextInt();

            int umur = tahunSekarang - tahunLahir;

            System.out.println("----------------------------");
            System.out.println("Data diri ");
            System.out.println("----------------------------");
            System.out.println("Nama    : " +nama);
            System.out.println("Kelamin : " +jenisKelamin);
            System.out.println("Umur    : " +umur);
            System.out.println("----------------------------");

            zeta.close();
        }
    }


