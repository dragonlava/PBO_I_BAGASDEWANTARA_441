package Codelab;
public class RekeningBank {
    String nomorRekening;
    String NamaPemilik;
    double saldo;



    void tampilkanInfo(){
        System.out.println("\nNo rekening: " +nomorRekening);
        System.out.println("Nama pemilik: " +NamaPemilik);
        System.out.println("Saldo: " +saldo);
        System.out.println();
    }

    void setorUang(double setor){
        saldo += setor;

        System.out.println(NamaPemilik +" menyetor " + setor + " Saldo sekarang " +saldo);
    }

    void tarikUang(double narikUang){
        if(narikUang <= saldo){
            saldo -= narikUang;

            System.out.println("Amelia menarik " + narikUang + "(Berhasil) saldo sekarang: " +saldo);
        }else if (narikUang > saldo){
            System.out.println("\nMaharani menarik " + narikUang + "(Gagal) saldo sekarang: " +saldo);
        }
    }

    void tampilkanInfo2(){
        System.out.println("\nNomor rekekning: " +nomorRekening);
        System.out.println("Nama: "+NamaPemilik);
        System.out.println("Saldo: " +saldo);
    }
}
