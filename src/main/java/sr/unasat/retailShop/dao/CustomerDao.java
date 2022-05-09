package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Customer;
import sr.unasat.retailShop.entities.Orders;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDao {
    private static EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  Customer findByTelefoonNummer(String telefoonNummer) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c where c.telefoonNummer = :telefoonNummer";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        Customer customer = query.setParameter("telefoonNummer", telefoonNummer).getSingleResult();
        entityManager.getTransaction().commit();
        return customer;
    }

    public  Customer findByBestelling(String bestelling) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c where c.bestelling = :bestelling";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        Customer customer = query.setParameter("bestelling", bestelling).getSingleResult();
        entityManager.getTransaction().commit();
        return customer;
    }

    public List<Customer> retrieveCustomerList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        List<Customer> customerList = query.getResultList();
        entityManager.getTransaction().commit();
        return customerList;
    }

    public Customer insert(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    public int delete(String telefoonNummer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Customer c where c.telefoonNummer = :telefoonNummer");
        query.setParameter("telefoonNummer", telefoonNummer);
        int rowsDeleted = query.executeUpdate();
        System.out.println("deleted:" + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    public static List<Customer> getCustomers() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c ";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        List<Customer> customerList = query.getResultList();
        System.out.printf("%10s %20s %20s %20s %20s %20s %35s", "CUSTOMER NUMMER", "FAMILIENAAM", "VOORNAAM", "TELEFOON NUMMER", "ADRES", "EMAIL", "BESTELLING");
        System.out.println();
        for (Customer customer : customerList) {
            System.out.format("%10s %20s %20s %20s %30s %30s %20s",
                    customer.getId(), customer.getAchternaam(), customer.getVoornaam(), customer.getTelefoonNummer(),
                    customer.getAdres(), customer.getEmailAdres(), customer.getBestelling());
            System.out.println();
        }


        entityManager.getTransaction().commit();
        System.out.println("-----------------------------------------------------------------------------");
        return customerList;
    }



}
