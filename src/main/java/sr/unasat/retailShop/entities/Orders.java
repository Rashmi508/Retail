package sr.unasat.retailShop.entities;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private int id;
    @Column(name = "order_datum")
    private Date orderDatum;
    private String verzendingsduur;
    private String product;
//    private String customer;

    @OneToOne(mappedBy = "orders")
    private Bill bill;

    @ManyToMany(mappedBy = "orders")
    private Set<Customer> customer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDatum() {
        return orderDatum;
    }

    public void setOrderDatum(Date orderDatum) {
        this.orderDatum = orderDatum;
    }

    public String getVerzendingsduur() {
        return verzendingsduur;
    }

    public void setVerzendingsduur(String verzendingsduur) {
        this.verzendingsduur = verzendingsduur;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders: " +
                "\n id= " + id +
                "\n orderDatum= " + orderDatum +
                "\n verzendingsduur= " + verzendingsduur + "\n" +
                "\n products= " + product + "\n" +
                "\n customer= " + customer + "\n";

    }
}
