package sr.unasat.retailShop.dao;

import sr.unasat.retailShop.entities.Customer;
import sr.unasat.retailShop.entities.Employees;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

public class EmployeesDao {

    private static EntityManager entityManager;

    public EmployeesDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employees findByIdKaart(String idKaart) {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employees e where e.idKaart = :idKaart";
        TypedQuery<Employees> query = entityManager.createQuery(jpql, Employees.class);
        Employees employees = query.setParameter("idKaart", idKaart).getSingleResult();
        entityManager.getTransaction().commit();
        return employees;
    }

    public List<Employees> retrieveEmployees() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employees e";
        TypedQuery<Employees> query = entityManager.createQuery(jpql, Employees.class);
        List<Employees> employeesList = query.getResultList();
        entityManager.getTransaction().commit();
        return employeesList;
    }

    public Employees insert(Employees employees) {
        entityManager.getTransaction().begin();
        entityManager.persist(employees);
        entityManager.getTransaction().commit();
        return employees;
    }

    public int delete(String idKaart) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Employees e where e.idKaart = :idKaart ");
        query.setParameter("idKaart", idKaart);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    public int updateEmployee (String idKaart, String salaris) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Employees e set e.salaris = :salaris where idKaart = :idKaart");
        query.setParameter("idKaart", idKaart);
        query.setParameter("salaris", salaris);
        int rowsupdated = query.executeUpdate();
        System.out.println("entities updated: " + rowsupdated);
        entityManager.getTransaction().commit();
        return rowsupdated;
    }

    public static List<Employees> getEmployees() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employees e ";
        TypedQuery<Employees> query = entityManager.createQuery(jpql, Employees.class);
        List<Employees> employeesList = query.getResultList();
        System.out.printf("%10s %15s %20s %20s %15s %17s %19s %25s", "EMPLOYEE NUMMER", "ACHTERNAAM", "VOORNAAM", "GEBOORTE DATUM", "FUNCTIE", "SALARIS", "ID-KAART", "TELEFOON NUMMER");
        System.out.println();
        for (Employees employees : employeesList) {
            System.out.format("%5s %20s %20s %20s %20s %20s %20s %20s",
                    employees.getId(), employees.getAchternaam(), employees.getVoornaam(),
                    employees.getGeboortedatum(), employees.getFunctie(), employees.getSalaris(),
                    employees.getIdKaart(), employees.getTelefoonNummer());
            System.out.println();
        }


        entityManager.getTransaction().commit();

        return employeesList;
    }


}
