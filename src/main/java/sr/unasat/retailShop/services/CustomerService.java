package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.CustomerDao;
import sr.unasat.retailShop.entities.Customer;

import java.util.List;

public class CustomerService {

    CustomerDao customerDao = new CustomerDao(JpaConfig.getEntityManager());

    public void findAllCustomers() {
        List<Customer> customerList = customerDao.retrieveCustomerList();

        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }



    public void insertCustomer(Customer customer) {

          System.out.println("Customer: " + customerDao.insert(customer));
    }

    public void deleteCustomer(String telefoonNummer) {

        System.out.println("deleted: " + customerDao.delete(telefoonNummer));

        JpaConfig.shutdown();

    }
}
