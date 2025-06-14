package lokesh_hibernate_6.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lokesh_hibernate_6.entity.Employee_2;
import lokesh_hibernate_6.entity.Project;

public class Operations {
	private static Configuration configuration = null;
	private static SessionFactory factory = null;
	private static Session session=null;
	private static Transaction transaction=null;
	
	public static void insertData() {
		openSession();
		Employee_2 e1= new Employee_2("Rohan");
		Employee_2 e2= new Employee_2("Lokesh");
		Project project1=new Project("School Project");
		
		project1.getEmp_list().add(e1);
		project1.getEmp_list().add(e2);
		
		session.persist(e1);
		session.persist(e2);
		session.persist(project1);
		
		CloseSession();
	}
	
	public static void CloseSession() {
		transaction.commit();
		session.close();
	}
	
	public static void openSession() {
		configuration=new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee_2.class);
		configuration.addAnnotatedClass(Project.class);
		factory = configuration.buildSessionFactory();
		session=factory.openSession();
		session.beginTransaction();
		transaction=session.getTransaction();
	}
}
