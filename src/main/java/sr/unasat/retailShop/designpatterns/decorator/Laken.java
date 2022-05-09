package sr.unasat.retailShop.designpatterns.decorator;

public class Laken extends BeddenSetDecorator{

    public Laken(BeddenSet beddenSet) {
        this.beddenSet = beddenSet;
    }

    public String getdescription() {
        return beddenSet.getdescription() + " with an extra sheet";


    }

    public double price() {
        return beddenSet.price() + 10;
    }
}
