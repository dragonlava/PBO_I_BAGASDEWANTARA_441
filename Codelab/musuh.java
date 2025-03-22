package Codelab;

public class musuh extends karakterGame{
    public musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(karakterGame target){
        System.out.println(getNama() + " menyerang " + getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " +target.getKesehatan());
    }
}
