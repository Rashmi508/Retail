package sr.unasat.retailShop.designpatterns.decorator;

public class BedsetDec {

    public void getDecorator() {

        BeddenSet bedinabag = new BedInABag();
        BeddenSet comferterSet = new ComferterSet();
        BeddenSet lakenset = new Laken(bedinabag);
        BeddenSet mixedSet = new Dekbed(lakenset);
        BeddenSet kussenslopenset = new Kussenslopen(comferterSet);

//        System.out.println("Bed-in-a-bag and sheet: " + lakenset.getdescription()
//                + " \n Totale prijs: SRD " + lakenset.price());

//        System.out.println("Comferter: " + comferterSet.getdescription()
//                + "\n Prijs: SRD " + comferterSet.price());

//        System.out.println("Comferter with pillowcases: " + kussenslopenset.getdescription()
//                + "\n Totale prijs : SRD " + kussenslopenset.price());

        System.out.println("Bed-in-a-bag with extra sheets and pillowcases: " + mixedSet.getdescription()
                + " \n Totale prijs: SRD " + mixedSet.price());

//        System.out.println("Bed-in-a-bag: " + bedinabag.getdescription()
//                + "\n Prijs : SRD " + bedinabag.price());
    }
}
