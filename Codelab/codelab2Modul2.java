package Codelab;

public class codelab2Modul2 {
    public static void main(String[] args){
        RekeningBank Bagas = new RekeningBank();
        Bagas.nomorRekening = "202410370110441";
        Bagas.NamaPemilik = "Bagas Dewantara";
        Bagas.saldo = 500000;

        RekeningBank Danta = new RekeningBank();
        Danta.nomorRekening = "202410370110424";
        Danta.NamaPemilik = "Danta";
        Danta.saldo = 1000000;

        Bagas.tampilkanInfo();
        Danta.tampilkanInfo();

        Bagas.setorUang(200000);
        Danta.setorUang(500000);

        Bagas.tarikUang(1000000);
        Danta.tarikUang(300000);

        Bagas.tampilkanInfo2();
        Danta.tampilkanInfo2();
    }
}
