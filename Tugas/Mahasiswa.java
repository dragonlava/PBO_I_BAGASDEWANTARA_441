package Tugas;

public class Mahasiswa {
    String nama;
    String nim;

    public Mahasiswa(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public void displayInfo(){
        System.out.println("Berhasil;");
        System.out.println("\nNama: " +nama);
        System.out.println("Nim: "+nim);
    }

    public void login(String inputnama, String inputNim){
        if(this.nama.equals(inputnama) && this.nim.equals(inputNim)){
            displayInfo();
        }else{
            System.out.println("Gagal");
        }
    }
}
