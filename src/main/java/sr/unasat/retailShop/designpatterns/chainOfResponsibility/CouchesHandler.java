package sr.unasat.retailShop.designpatterns.chainOfResponsibility;


//  om andere handlers methose op te roepen.
interface CouchesHandler {

    void setNextCouchHandler(CouchesHandler nextChain);

    void check(Couches couches);

    default void validate(Couches couches) {
        if (couches == null || couches.getBankstelType() == null || couches.getMateriaal() == null ) {
            System.out.println("There is no sofa type specified");
            return;
        }
    }
}


