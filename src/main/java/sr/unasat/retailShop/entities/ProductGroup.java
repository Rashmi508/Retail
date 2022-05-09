package sr.unasat.retailShop.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "product_group")
public class ProductGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "groep_id")
    private Long id;
    @Column(name = "groep_naam")
    private String groepNaam;

    @OneToMany (mappedBy = "productGroup",cascade = CascadeType.ALL)
    @Column
    private Set<Product> product;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroepNaam() {
        return groepNaam;
    }

    public void setGroepNaam(String groepNaam) {
        this.groepNaam = groepNaam;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductGroup: " +
                "\n id=" + id +
                "\n groepNaam='" + groepNaam + "\n" +
                "\n product=" + product + "\n";

    }
}
