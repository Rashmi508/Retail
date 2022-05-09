package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.ProductDao;
import sr.unasat.retailShop.entities.Product;

import java.util.List;

public class ProductService {

    ProductDao productDao = new ProductDao(JpaConfig.getEntityManager());

    public void findProduct() {
        List<Product> productList = productDao.retrieveProductList();
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
