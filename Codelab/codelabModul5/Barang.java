package codelabModul5;

public class Barang {
    //tempat penampungan attribute
    private String name;
    private int stok;

    public Barang(String name, int stok){
        this.name = name;
        this.stok = stok;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public int getStok(){
        return stok;
    }
}
