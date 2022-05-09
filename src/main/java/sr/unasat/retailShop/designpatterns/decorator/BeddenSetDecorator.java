package sr.unasat.retailShop.designpatterns.decorator;

public abstract class BeddenSetDecorator extends BeddenSet {

     BeddenSet beddenSet;

    public abstract String getdescription();


    public abstract double price();
}
