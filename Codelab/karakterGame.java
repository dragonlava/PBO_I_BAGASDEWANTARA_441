package Codelab;

public class karakterGame {
    private String nama;
    private int kesehatan;

    public karakterGame(String nama, int kesehatan){
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setKesehatan(int kesehatan){
        this.kesehatan = kesehatan;
    }

    public int getKesehatan(){
        return kesehatan;
    }

    public void serang(karakterGame target){
        System.out.println(nama + " menyerang " + nama + " menggunakan Orbital Strike");
    }
}
