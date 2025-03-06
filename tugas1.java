import java.util.Scanner;

class kata_kunci{
    public static final String USERNAME_ADMIN = "Admin441";
    public static final String PASSWORD_ADMIN = "Password441";
    public static final String MAHASISWA_nama = "Bagas Dewantara";
    public static final String MAHASISWA_nim = "202410370110441";
}

public class tugas1 {
    public static void main(String[] args){
        Scanner zeta = new Scanner(System.in);

        int input;

        do{
            System.out.println("Pilih login: ");
            System.out.println("1. Admin ");
            System.out.println("2. Mahasiswa ");

            System.out.println("Masukkan pilihan anda: ");
            input = zeta.nextInt();
            zeta.nextLine();

            if(input != 1 && input != 2){
                System.out.println("Hanya dapat memilih 1 atau 2\n");
            }
        }while(input != 1 && input != 2);

        if(input == 1){
            System.out.print("Masukkan username anda: ");
            String username = zeta.nextLine();
            System.out.print("Masukkan password anda: ");
            String password = zeta.nextLine();

            if(username.equals(kata_kunci.USERNAME_ADMIN) && password.equals(kata_kunci.PASSWORD_ADMIN)){
                System.out.println("Berhasil");
            }else{
                System.out.println("Gagal");
            }

        } else if (input == 2){
            System.out.print("Masukkan nama anda: ");
            String nama = zeta.nextLine();
            System.out.print("Masukkan nim anda: ");
            String nim = zeta.nextLine();

            if(nama.equals(kata_kunci.MAHASISWA_nama) && nim.equals(kata_kunci.MAHASISWA_nim)){
                System.out.println("Berhasil");
                System.out.println("Nama: " +nama);
                System.out.println("Nim: " +nim);
            }else{
                System.out.println("Gagal");
            }

        } else{
            System.out.println("silahkan pilih 1 atau 2");
        }

        zeta.close();


    }
}
