package sr.unasat.retailShop.designpatterns.chainOfResponsibility;


import static sr.unasat.retailShop.designpatterns.chainOfResponsibility.CouchTypeConstant.SECTIONAL_SOFA;

public class SectionalSofasHandler implements CouchesHandler{

    private CouchesHandler CouchesHandler;

    @Override
    public void setNextCouchHandler(CouchesHandler CouchesHandler) {
        this.CouchesHandler = CouchesHandler;


    }

    public void check(Couches couches) {
        if (couches == null || couches.getBankstelType() == null || couches.getMateriaal() == null) {
            System.out.println("You need to specify a valid sofa type"); // niet processen.

        } if (SECTIONAL_SOFA.equalsIgnoreCase(couches.getBankstelType())) {

            System.out.println("ITEM: " + SECTIONAL_SOFA);
            System.out.println("DESCRIPTION: upholstered furniture that consists of three joined sections for sitting with two recliner seats.");
            System.out.println("COLOR: Beige.");
            System.out.println("MATERIAL: leder ");
            System.out.println("Your total is SRD 2407.90");
        }


        else {
            this.CouchesHandler.check(couches);
        }



    }
}
