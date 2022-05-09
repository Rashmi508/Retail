package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.OrdersDao;
import sr.unasat.retailShop.entities.Orders;

import java.util.List;

public class OrdersService {

    OrdersDao ordersDao = new OrdersDao(JpaConfig.getEntityManager());

    public void findOrder() {
        List<Orders> ordersList = ordersDao.retrieveOrdersList();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }
}
