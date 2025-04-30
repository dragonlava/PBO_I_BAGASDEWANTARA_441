import perpustakaan.*;

public class mainCodelabMod4 {
    public static void main(String[] args){
        Buku buku1 = new Fiksi("Hainuwele: sang putri palapa" , "Lilis Hiu", "Dongeng");
        Buku buku2 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah dan Ilmu Pengetahuan");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Bagas Dewantara", "441");
        Anggota anggota2 = new Anggota("Maezar Danta", "434");

        anggota1.displayInfo();
        anggota2.displayInfo();
        System.out.println();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBUku("Hainuwele: sang putri palapa", 7);
        System.out.println();

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: sang putri palapa");
    }
}
