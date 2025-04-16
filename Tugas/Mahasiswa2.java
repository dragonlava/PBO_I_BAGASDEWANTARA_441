package Tugas;

public class Mahasiswa2 extends User {
    public Mahasiswa2(String nama, String nim){
        super(nama, nim);
    }

    @Override
    public void displayInfo(){
        System.out.println("Berhasil");
        System.out.println("\nNama: " +getNama());
        System.out.println("Nim: " +getNim());
    }

    @Override
    public void login(String inputNama, String inputNim){
        if(this.getNama().equals(inputNama) && this.getNim().equals(inputNim)){
            displayInfo();
        }else{
            System.out.println("Gagal");
        }
    }
}
