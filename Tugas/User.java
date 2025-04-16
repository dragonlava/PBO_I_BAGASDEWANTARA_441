package Tugas;

public class User {
    private String nama;
    private String nim;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getNim(){
        return nim;
    }

    public void displayInfo(){
        System.out.println("Data anda: ");
    }

    public void login(String inputNama, String inputNim){
        System.out.println("Login ke user class");
    }
}
