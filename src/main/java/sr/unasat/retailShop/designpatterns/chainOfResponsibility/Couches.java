package sr.unasat.retailShop.designpatterns.chainOfResponsibility;


// request
public class Couches {

    private String bankstelType;
    private String materiaal;



    public Couches(String bankstelType, String materiaal) {
        this.bankstelType = bankstelType;
        this.materiaal = materiaal;
    }

    public String getBankstelType() {
        return bankstelType;
    }

    public void setBankstelType(String bankstelType) {
        this.bankstelType = bankstelType;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }

    @Override
    public String toString() {
        return "Couches{" +
                "bankstelType='" + bankstelType + '\'' +
                ", materiaal='" + materiaal + '\'' +
                '}';
    }
}
