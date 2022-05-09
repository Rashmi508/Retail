package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.ProductGroup;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductGroupDao {
    private EntityManager entityManager;

    public ProductGroupDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ProductGroup> retrieveProductGroup() {
        entityManager.getTransaction().begin();
        String jpql = "select pg from ProductGroup pg";
        TypedQuery<ProductGroup> query = entityManager.createQuery(jpql, ProductGroup.class);
        List<ProductGroup> productGroupList = query.getResultList();
        entityManager.getTransaction().commit();
        return productGroupList;
    }
}
