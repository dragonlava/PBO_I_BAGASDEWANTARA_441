package Tugas;

public class Admin2 extends User {
    String username;
    String password;

    public Admin2(String username, String password, String nama, String nim){
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void displayInfo(){
        System.out.println("Berhasil");
        System.out.println("\nNama: " +getNama());
        System.out.println("Nim: " +getNim());
    }

    @Override
    public void login(String inputUsername, String inputPassword){
        if(this.username.equals(inputUsername) && this.password.equals(inputPassword)){
            displayInfo();
        }else{
            System.out.println("Gagal");
        }
    }
}
