package perpustakaan;

public class Anggota implements Peminjaman{
    private String name;
    private String idAnggota;

    public Anggota(String name, String idAnggota){
        this.name = name;
        this.idAnggota = idAnggota;
    }

    public void displayInfo(){
        System.out.println("Anggota: " + name + " (ID: " + idAnggota + ")");
    }

    public void pinjamBuku(String judul){
        System.out.println(name + " meminjam buku berjudul: " +judul);
    }
    public void pinjamBUku(String judul, int durasi){
        System.out.println(name + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");
    }

    public void kembalikanBuku(String judul){
        System.out.println(name + " mengembalikan buku berjudul: " + judul);
    }

    @Override
    public void pinjamBuku(){
        System.out.println(name + " sedang meminjam buku.");
    }

    @Override
    public void kembalikanBuku(){
        System.out.println(name + " mengembalikan buku.");
    }
}
