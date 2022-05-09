package sr.unasat.retailShop.designpatterns.chainOfResponsibility;

import sr.unasat.retailShop.designpatterns.decorator.BeddenSet;

import java.util.Scanner;

//  om alles aan elkaar te chainen.
public class CouchesChain {

    public static CouchesHandler firstCouchHandler;


    public CouchesChain() {

        SectionalSofasHandler sectionalSofasHandler = new SectionalSofasHandler();
        SofaBedsHandler sofaBedsHandler = new SofaBedsHandler();
        HighBackSofasHandler highBackSofasHandler = new HighBackSofasHandler();
        highBackSofasHandler.setNextCouchHandler(sectionalSofasHandler);
        sofaBedsHandler.setNextCouchHandler(highBackSofasHandler);
        this.firstCouchHandler = sofaBedsHandler;
    }

    public void getchain() {

        CouchesChain cc = new CouchesChain();
        Couches couch = new Couches("sectional-sofa", "leder");
        cc.firstCouchHandler.check(couch);

    }





}


