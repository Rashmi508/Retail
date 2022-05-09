package sr.unasat.retailShop.designpatterns.factory;

public class Serta implements Merk{
    @Override
    public void merk() {
        System.out.println("SERTA 95x25 MATTRESS IN A BOX");
    }

    @Override
    public void prijs() {
        System.out.println("SRD 1500");
    }
}
