package sr.unasat.retailShop.services;

import sr.unasat.retailShop.config.JpaConfig;
import sr.unasat.retailShop.dao.EmployeesDao;
import sr.unasat.retailShop.entities.Employees;

import java.time.LocalDate;
import java.util.List;

public class EmployeeService {

    EmployeesDao employeesDao = new EmployeesDao(JpaConfig.getEntityManager());

    public void findEmployee() {
        List<Employees> employeesList = employeesDao.retrieveEmployees();
        for (Employees employees : employeesList)
            System.out.println(employees);
    }

    public void insertEmployee(Employees employees) {

        System.out.println("Employee: " + employeesDao.insert(employees));
    }

    public void deleteEmployee(String idKaart) {

        System.out.println("Deleted employee: " + employeesDao.delete(idKaart) );
    }

    public void updateEmployee (String idKaart, String salaris) {

        System.out.println("updated employee" + employeesDao.updateEmployee(idKaart, salaris));
    }
}
