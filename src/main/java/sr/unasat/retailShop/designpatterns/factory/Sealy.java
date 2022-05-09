package sr.unasat.retailShop.designpatterns.factory;

public class Sealy implements Merk{

    @Override
    public void merk() {
        System.out.println("SEALY 90x25 MATTRESS IN A BOX");
    }

    @Override
    public void prijs() {
        System.out.println("SRD 1200");
    }
}
