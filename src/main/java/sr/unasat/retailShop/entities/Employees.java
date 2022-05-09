package sr.unasat.retailShop.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import lombok.*;


@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    
    @Column(name = "employee_id")
    private long id;
    @Column
    private String voornaam;
    @Column
    private String achternaam;
    @Column
    private LocalDate geboortedatum;
    @Column
    private String salaris;
    @Column
    private String functie;
    @Column(name = "id_kaart", unique = true)
    private String idKaart;
    @Column(name = "telefoon_nummer")
    private String telefoonNummer;


    public Employees(String voornaam, String achternaam, LocalDate geboortedatum, String salaris, String functie, String idKaart, String telefoonNummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.salaris = salaris;
        this.functie = functie;
        this.idKaart = idKaart;
        this.telefoonNummer = telefoonNummer;
    }

    public Employees() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getSalaris() {
        return salaris;
    }

    public void setSalaris(String salaris) {
        this.salaris = salaris;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getIdKaart() {
        return idKaart;
    }

    public void setIdKaart(String idKaart) {
        this.idKaart = idKaart;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    @Override
    public String toString() {
        return "Employees: " +
                "\n id= " + id +
                "\n voornaam= " + voornaam +
                "\n achternaam= " + achternaam +
                "\n geboortedatum= " + geboortedatum +
                "\n salaris= " + salaris +
                "\n functie= " + functie +
                "\n idKaart= " + idKaart +
                "\n telefoon nummer= " + telefoonNummer + "\n";

    }
}

