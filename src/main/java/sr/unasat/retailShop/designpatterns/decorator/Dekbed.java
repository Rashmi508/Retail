package sr.unasat.retailShop.designpatterns.decorator;

public class Dekbed extends BeddenSetDecorator{

    public Dekbed(BeddenSet beddenSet) {
        this.beddenSet = beddenSet;
    }


    public String getdescription() {
        return beddenSet.getdescription() + " and extra comferter";
    }

    public double price() {
        return beddenSet.price() + 30;
    }
}
