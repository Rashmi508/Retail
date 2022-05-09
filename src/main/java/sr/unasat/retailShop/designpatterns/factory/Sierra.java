package sr.unasat.retailShop.designpatterns.factory;

public class Sierra implements Merk{
    @Override
    public void merk() {
        System.out.println("SIERRA 90x21 MATTRESS IN A BOX");
    }

    @Override
    public void prijs() {
        System.out.println("SRD 1000");
    }
}
