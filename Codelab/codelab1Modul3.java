package Codelab;

public class codelab1Modul3 {
    public static void main(String[] args){
        karakterGame karakterUmum = new karakterGame("Karakter umum", 100);
        pahlawan brimstone = new pahlawan("Brimstone", 150);
        musuh viper = new musuh("Viper", 200);

        System.out.println("\nStatus awal: ");
        System.out.println(brimstone.getNama() + " memeliki kesehatan " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan " + viper.getKesehatan());
        System.out.println();

        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
