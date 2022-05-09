package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Bill;
import sr.unasat.retailShop.entities.Orders;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class BillDao {
    private static EntityManager entityManager;

    public BillDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Bill> retrieveBillList() {
        entityManager.getTransaction().begin();
        String jpql = "select b from Bill b";
        TypedQuery<Bill> query = entityManager.createQuery(jpql, Bill.class);
        List<Bill> billList = query.getResultList();
        entityManager.getTransaction().commit();
        return billList;
    }


    public Bill insert(Bill bill) {
        entityManager.getTransaction().begin();
        entityManager.persist(bill);
        entityManager.getTransaction().commit();
        return bill;
    }
}
