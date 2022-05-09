package sr.unasat.retailShop.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_naam")
    private String naam;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "groep_id")
    private ProductGroup productGroup;

    @OneToOne (mappedBy = "product")
    private ProductDetails productDetails;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Product: " +
                "\n id=" + id +
                "\n naam='" + naam + "\n" +
                "\n productDetails=" + productDetails + "\n";

    }
}
