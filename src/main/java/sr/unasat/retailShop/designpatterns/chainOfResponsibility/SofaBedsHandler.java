package sr.unasat.retailShop.designpatterns.chainOfResponsibility;


import static sr.unasat.retailShop.designpatterns.chainOfResponsibility.CouchTypeConstant.SOFA_BED;

public class SofaBedsHandler implements CouchesHandler {

    private CouchesHandler nextCouchesHandler;

    @Override
    public void setNextCouchHandler(CouchesHandler nextCouchesHandler) {
        this.nextCouchesHandler = nextCouchesHandler;

    }

    @Override
    public void check(Couches couches) {
        if (couches == null || couches.getBankstelType() == null || couches.getMateriaal() == null ) {
            System.out.println("You need to specify a valid sofa type");

        } if (SOFA_BED.equalsIgnoreCase(couches.getBankstelType())) {

            System.out.println("ITEM: " + SOFA_BED);
            System.out.println("DESCRIPTION: it is a couch with a metal frame and thin mattress that can be unfolded or opened up to make a bed.");
            System.out.println("COLOR: Black");
            System.out.println("MATERIAL: leder ");
            System.out.println("Your total is SRD 90,000");
        }

        else {
            this.nextCouchesHandler.check(couches);
        }

    }
}
