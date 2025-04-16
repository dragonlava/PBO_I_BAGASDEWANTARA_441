package Tugas;

public class Admin {
    String username;
    String password;
    String nama;
    String nim;

    public Admin(String username, String password, String nama, String nim){
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.nim = nim;
    }

    public void displayInfo(){
        System.out.println("Berhasil ");
        System.out.println("\nNama: " +nama);
        System.out.println("Nim: " +nim);
    }

    public void login(String inputUsername, String inputPassword){
        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)){
            displayInfo();
        }else{
            System.out.println("Gagal");
        }
    }
}
