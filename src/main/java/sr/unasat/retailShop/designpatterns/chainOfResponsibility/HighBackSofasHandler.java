package sr.unasat.retailShop.designpatterns.chainOfResponsibility;


import static sr.unasat.retailShop.designpatterns.chainOfResponsibility.CouchTypeConstant.HIGHBACK_SOFA;

public class HighBackSofasHandler implements CouchesHandler {

    private CouchesHandler nextCouchesHandler;

    @Override
    public void setNextCouchHandler(CouchesHandler nextCouchesHandler) {
        this.nextCouchesHandler = nextCouchesHandler;

    }

    @Override
    public void check(Couches couches) {
        if (couches == null || couches.getBankstelType() == null || couches.getMateriaal() == null ) {
            System.out.println("You need to specify a valid sofa type"); // gaat nie processen.

    } if (HIGHBACK_SOFA.equalsIgnoreCase(couches.getBankstelType())) {

            System.out.println("ITEM: " + HIGHBACK_SOFA);
            System.out.println("DESCRIPTION: it is taller in the back so it offers great support and comfort for the head and neck, which allows complete relaxation.");
            System.out.println("COLOR: Red ");
            System.out.println("MATERIAL: leder ");
            System.out.println("Your total is SRD 3000");
            
        }


        else {
            this.nextCouchesHandler.check(couches); // doorsturen.
        }
    }
}
