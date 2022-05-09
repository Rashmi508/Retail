package sr.unasat.retailShop.app;


import sr.unasat.retailShop.config.JpaConfig;


import static sr.unasat.retailShop.dao.OrdersDao.getOrderList;
import static sr.unasat.retailShop.designpatterns.chainOfResponsibility.CouchTypeConstant.*;

import sr.unasat.retailShop.dao.BillDao;
import sr.unasat.retailShop.dao.CustomerDao;
import sr.unasat.retailShop.dao.EmployeesDao;
import sr.unasat.retailShop.dao.OrdersDao;
import sr.unasat.retailShop.designpatterns.chainOfResponsibility.*;

import sr.unasat.retailShop.designpatterns.decorator.*;
import sr.unasat.retailShop.designpatterns.factory.MerkFactory;
import sr.unasat.retailShop.designpatterns.factory.Sealy;
import sr.unasat.retailShop.designpatterns.factory.Serta;
import sr.unasat.retailShop.designpatterns.factory.Sierra;
import sr.unasat.retailShop.entities.*;
import sr.unasat.retailShop.services.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Applicatie {

    public static void main(String[] args) {


        BillService bs = new BillService();
//        bs.retrieveBill();
//        bs.insertBill(new Bill(LocalDate.parse("2021-01-09"), "SRD 1000"));

        CustomerService cs = new CustomerService();
//        cs.findAllCustomers();
//        cs.insertCustomer(new Customer("Chis", "Bang", "8973645", "chrisB97@gmail.com" , LocalDate.parse("2022-05-19"), "Passiebloemstraat #16"));
//        cs.deleteCustomer("8973645");

        EmployeeService es = new EmployeeService();
//        es.findEmployee();
//        es.insertEmployee(new Employees("Praveen", "Kalloe", LocalDate.parse("1999-06-18"), "SRD 2000", "verkoper", "FD3457392"));
//        es.deleteEmployee("FD3457392");
//        es.updateEmployee("FD93483489", "SRD 20,000");

        OrdersService os = new OrdersService();
//        os.findOrder();


        ProductService prs = new ProductService();
//        prs.findProduct();

        ProductDetailsService pds = new ProductDetailsService();
//        pds.findDetails();

        ProductGroupService pgs = new ProductGroupService();
//        pgs.findGroup();
        






//          Decorator pattern!

        BedsetDec bed = new BedsetDec();
        //bed.getDecorator();



//          CHAIN OF RESPONSIBILITY!!

        CouchesChain chain = new CouchesChain();
        //chain.getchain();


//          FACTORY PATTERN!!!
        MerkFactory mf = new MerkFactory();
        //mf.chooseBedBrandScanner();


//        OrdersDao ordersDao = new OrdersDao(JpaConfig.getEntityManager());
//        List<Orders> orderList = getOrderList(Date.valueOf("2022-01-01"), Date.valueOf("2022-03-31"));


//        CustomerDao customerDao = new CustomerDao(JpaConfig.getEntityManager());
//
//        List<Customer> customersList = CustomerDao.getCustomers();

//        EmployeesDao employeesDao = new EmployeesDao(JpaConfig.getEntityManager());
//        List<Employees> employeesList = EmployeesDao.getEmployees();

        
        JpaConfig.shutdown();


    }
}









    



