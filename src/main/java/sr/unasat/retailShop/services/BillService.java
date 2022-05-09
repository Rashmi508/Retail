package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.BillDao;

import sr.unasat.retailShop.entities.Bill;

import java.time.LocalDate;
import java.util.List;

public class BillService {

    BillDao billDao = new BillDao(JpaConfig.getEntityManager());

    public void retrieveBill() {
        List<Bill> billList = billDao.retrieveBillList();
       for (Bill bill : billList) {
           System.out.println(bill);
       }
    }

    public void insertBill(Bill bill) {
        //Bill bill = new Bill(LocalDate.parse("2021-10-19"), "SRD 12000");
         //Bill savedBill = billDao.insert(bill);
          System.out.println("bill: " + billDao.insert(bill));
    }




}
