package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.ProductDetails;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class ProductDetailsDao {
    private EntityManager entityManager;

    public ProductDetailsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ProductDetails> retrieveProductDetails() {
        entityManager.getTransaction().begin();
        String jpql = "select pd from ProductDetails pd";
        TypedQuery<ProductDetails> query = entityManager.createQuery(jpql, ProductDetails.class);
        List<ProductDetails> productDetailsList = query.getResultList();
        entityManager.getTransaction().commit();
        return productDetailsList;
    }
}
