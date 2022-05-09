package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Orders;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrdersDao {
    private static  EntityManager entityManager;

    public OrdersDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Orders> retrieveOrdersList() {
        entityManager.getTransaction().begin();
        String jpql = "select o from Orders o";
        TypedQuery<Orders> query = entityManager.createQuery(jpql, Orders.class);
        List<Orders> ordersList = query.getResultList();
        entityManager.getTransaction().commit();
        return ordersList;
    }

    public static List<Orders> getOrderList(java.util.Date startDate, java.util.Date endDate) {
        entityManager.getTransaction().begin();
        String jpql = "select o from Orders o where o.orderDatum between :startDate and :endDate ";
        TypedQuery<Orders> query = entityManager.createQuery(jpql, Orders.class);
        query.setParameter("startDate",startDate);
        query.setParameter("endDate",endDate);
        List<Orders> orderList = query.getResultList();
        System.out.printf("%10s %10s %20s", "orderId", "ORDER DATUM", "VERZENDINGS DUUR");
        System.out.println();
        for (Orders orders : orderList) {
            System.out.format("%5s %20s %20s ",
                    orders.getId(), orders.getOrderDatum(), orders.getVerzendingsduur());
            System.out.println();
        }


        entityManager.getTransaction().commit();
        System.out.println("-----------------------------------------------------------------------------");
        return orderList;
    }

}
