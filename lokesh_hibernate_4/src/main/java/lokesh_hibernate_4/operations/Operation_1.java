package lokesh_hibernate_4.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lokesh_hibernate_4.entity.Employee;
import lokesh_hibernate_4.entity.Laptop;

public class Operation_1 {
	private static Configuration configuration = null;
	private static SessionFactory factory = null;
	private static Session session=null;
	private static Transaction transaction=null;
	public static void insertData_2() {
	    openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    Laptop laptop = session.get(Laptop.class, 2);
	    if (laptop != null && laptop.getEmployee() != null) { 
	        System.out.println("Laptop is already assigned to another employee.");
	    } else {
	        System.out.println("Laptop is available.");
	    }
	    Employee employee = new Employee("Manoday", "Nashik");
	    employee.setLaptop(laptop);
	    session.persist(employee);
	    transaction.commit(); 
	    session.close();       
	}
	
	public static void insertData_1() {
		openSession();
		Laptop laptop = session.get(Laptop.class, 2);
		Employee employee = new Employee("Darshan","Nashik");
		employee.setLaptop(laptop);
		session.persist(employee);
		CloseSession();
	}
	public static void insertData() {
		openSession();
		Laptop laptop1=new Laptop("lenovo");
		Laptop laptop2=new Laptop("dell");
		Laptop laptop3=new Laptop("hp");
		Laptop laptop4=new Laptop("asus");
		
		Employee employee = new Employee();
		employee.setLaptop(laptop3);
		session.persist(laptop1);
		session.persist(laptop2);
		session.persist(laptop3);
		session.persist(laptop4);
		session.persist(employee);
		
		CloseSession();
	}
	
	
	public static void CloseSession() {
		transaction.commit();
		session.close();
	}
	
	public static void openSession() {
		configuration=new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Laptop.class);
		factory = configuration.buildSessionFactory();
		session=factory.openSession();
		
	}
		
}
