package sr.unasat.retailShop.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "product_details_id")
    private Long id;
    private double gewicht;
    private double breedte;
    private double hoogte;
    private String kleur;
    private double prijs;

    @OneToOne
    @JoinColumn (name = "product_id")
    private Product product;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductDetails: " +
                "\n id= " + id +
                "\n gewicht= " + gewicht +
                "\n breedte= " + breedte +
                "\n hoogte= " + hoogte +
                "\n kleur= " + kleur  +
                "\n prijs= " + prijs + "\n";

    }
}
