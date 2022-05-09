package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.ProductGroupDao;
import sr.unasat.retailShop.entities.ProductGroup;

import java.util.List;

public class ProductGroupService {

    ProductGroupDao productGroupDao = new ProductGroupDao(JpaConfig.getEntityManager());

    public void findGroup() {

        List<ProductGroup> productGroupList = productGroupDao.retrieveProductGroup();
       for (ProductGroup productGroup : productGroupList) {
           System.out.println(productGroup);
       }
    }
}
