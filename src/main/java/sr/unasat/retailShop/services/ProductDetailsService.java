package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.ProductDetailsDao;
import sr.unasat.retailShop.entities.ProductDetails;

import java.util.List;

public class ProductDetailsService {

    ProductDetailsDao productDetailsDao = new ProductDetailsDao(JpaConfig.getEntityManager());

    public void findDetails() {

        List<ProductDetails> productDetailsList = productDetailsDao.retrieveProductDetails();
        //productDetailsList.stream().forEach(System.out::println);
        for (ProductDetails productDetails : productDetailsList) {
            System.out.println(productDetails);
        }
    }
}
