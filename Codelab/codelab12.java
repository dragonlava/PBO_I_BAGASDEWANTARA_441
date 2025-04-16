package Codelab;

public class codelab12 {
    public static void main(String[] args){
        hewan hewan1 = new hewan();
        hewan1.nama = "Kucing";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Nyann~~";
        hewan1.warna = "hitam";

        hewan hewan2 = new hewan();
        hewan2.nama = "Anjing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Woof-Woof!!!";
        hewan2.warna = "coklat";

        hewan1.tampillkanInfo1();
        hewan2.tampillkanInfo1();
    }
}
