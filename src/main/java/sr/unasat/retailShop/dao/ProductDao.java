package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Customer;
import sr.unasat.retailShop.entities.Employees;
import sr.unasat.retailShop.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDao {
    private EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Product> retrieveProductList() {
        entityManager.getTransaction().begin();
        String jpql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        List<Product> productList = query.getResultList();
        entityManager.getTransaction().commit();
        return productList;
    }

}
