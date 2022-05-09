package sr.unasat.retailShop.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "bon_id")
    private Long id;
    @Column(name = "bon_datum")
    private Date bonDatum;
    @Column(name = "betaald_bedrag")
    private String betaaldBedrag;


    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    public Bill(Date bonDatum, String betaaldBedrag) {
        this.bonDatum = bonDatum;
        this.betaaldBedrag = betaaldBedrag;
    }

    public Bill() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBonDatum() {
        return bonDatum;
    }

    public void setBonDatum(Date bonDatum) {
        this.bonDatum = bonDatum;
    }

    public String getBetaaldBedrag() {
        return betaaldBedrag;
    }

    public void setBetaaldBedrag(String betaaldBedrag) {
        this.betaaldBedrag = betaaldBedrag;
    }




    @Override
    public String toString() {
        return "Bill: " +
                "\n id= " + id +
                "\n bonDatum= " + bonDatum +
                "\n betaaldBedrag= " + betaaldBedrag + "\n" +
                "\n order= " + orders + "\n" ;

    }
}
