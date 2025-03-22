package Codelab;

public class pahlawan extends karakterGame {
    public pahlawan(String nama, int kesehatan){
        super(nama, kesehatan);
    }

    @Override
    public void serang(karakterGame target){
        System.out.println(getNama() + " menyerang " + target.getNama()+ " mengggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " +target.getKesehatan());
    }
}
