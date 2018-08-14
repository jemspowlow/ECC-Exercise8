//package infra;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import entities.*;
public class ManagePerson {
   private EntityUtil eu = new EntityUtil();
   public ManagePerson() {}
   
   public static void main(String[] args) {
   		PersonView pv = new PersonView();   
      
      ManagePerson ME = new ManagePerson();

      /* Add employee records in the database */
      //Person person = pv.addMenu();
      //Integer personID1 = ME.addPerson(person);
      /* Add another employee record in the database */
     // Integer personID2 = ME.addEmployee("Dilip", "Kumar", 3000, address);

      /* List down all the employees */
      //ME.listPeople();
      pv.menu(2);
      ME.listPeople();
	  HibernateUtil.shutdown();
	  System.exit(0);
      /* Update employee's salary records */
      //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      //ME.deleteEmployee(empID2);

      /* List down all the employees */
      //ME.listEmployees();

   }
     
   /* Method to add an address record in the database */
   public Address addAddress(String streetNumber, String city, String zipCode) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer addressID = null;
      Address address = null;
      
      try {
         tx = session.beginTransaction();
         address = new Address(streetNumber, city, zipCode);
         addressID = (Integer) session.save(address); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return address;
   }

   /* Method to add an employee record in the database */
   public Integer addPerson(Person person) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer personID = null;
      
      try {
         tx = session.beginTransaction();
   
         personID = (Integer) session.save(person); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return personID;
   }

   /* Method to list all the employees detail */
   public void listPeople(){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List persons = session.createQuery("FROM Person").list(); 
         for (Iterator iterator = persons.iterator(); iterator.hasNext();){
            Person person = (Person) iterator.next(); 
            eu.printPerson(person);
         	
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
     
   } 
   
   /* Method to update salary for an employee 
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
         session.update(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to delete an employee from the records 
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   } */
}
