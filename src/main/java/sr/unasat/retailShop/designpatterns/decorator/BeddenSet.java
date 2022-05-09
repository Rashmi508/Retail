package sr.unasat.retailShop.designpatterns.decorator;

public abstract class BeddenSet {
    String description = "normal bedset";

    public String getdescription() {
        return description;
    }

    public abstract double price();

}
