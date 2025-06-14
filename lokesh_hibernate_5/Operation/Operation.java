package lokesh_hibernate_5.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lokesh_hibernate_5.entity.Department;
import lokesh_hibernate_5.entity.Employee1;

public class Operation {
	private static Configuration configuration = null;
	private static SessionFactory factory = null;
	private static Session session=null;
	private static Transaction transaction=null;
	
	public static void insertData_2() {
		openSession();
		Department department = session.get(Department.class, 1);
		Employee1 employee1 = new Employee1("Lokesh");
		employee1.setDepartment(department);
		session.persist(employee1);
		CloseSession();
	}
	
	public static void insertData() {
		openSession();
		Department department1 = new Department("HR");
		Department department2 = new Department("Testing");
		Department department3 = new Department("Development");
		Department department4 = new Department("Account");
		Employee1 employee1 = new Employee1("Rohan");
		employee1.setDepartment(department1);
		session.persist(department1);
		session.persist(department2);
		session.persist(department3);
		session.persist(department4);
		session.persist(employee1);
		CloseSession();
		
	}
	public static void CloseSession() {
		transaction.commit();
		session.close();
	}
	
	public static void openSession() {
		//configuration=new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee1.class);
		configuration.addAnnotatedClass(Department.class);
		factory = configuration.buildSessionFactory();
		session=factory.openSession();
		session.beginTransaction();
		transaction=session.getTransaction();
	}
}
