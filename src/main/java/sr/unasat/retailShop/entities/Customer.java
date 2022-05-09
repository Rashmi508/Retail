package sr.unasat.retailShop.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    private String voornaam;
    private String achternaam;
    private LocalDate bestelling;

    @Column(name = "telefoon_nummer", unique = true)
    private String telefoonNummer;
    @Column(name = "email_adres")
    private String emailAdres;
    @Column(name = "adres")
    private String adres;

    @ManyToMany
    @JoinTable(name = "customer_order",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private Set<Orders> orders;

    public Customer(String voornaam, String achternaam, String telefoonNummer, String emailAdres, LocalDate bestelling, String adres) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.telefoonNummer = telefoonNummer;
        this.emailAdres = emailAdres;
        this.bestelling = bestelling;
        this.adres = adres;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }



    public LocalDate getBestelling() {
        return bestelling;
    }

    public void setBestelling(LocalDate bestelling) {
        this.bestelling = bestelling;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }



    @Override
    public String toString() {
        return "Customer: " +
                "\n id=" + id  +
                "\n voornaam= " + voornaam   +
                "\n achternaam= " + achternaam   +
                "\n telefoonNummer= " + telefoonNummer   +
                "\n bestelling= " + bestelling +
                "\n emailAdres= " + emailAdres  +
                "\n adres= " + adres + "\n";

    }
}
