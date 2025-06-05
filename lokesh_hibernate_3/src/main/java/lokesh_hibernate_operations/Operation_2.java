package lokesh_hibernate_operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

import lokesh_hibernate_entity.Car;

import java.util.List;
import java.util.Scanner; 

public class Operation_2 {
	private static Configuration configuration = null;
	private static SessionFactory factory = null;
	private static Session session=null;
	private static Transaction transaction=null;
	
	public static void getDataByID() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		openSession();
		SelectionQuery query = session.createSelectionQuery("from Car where id = :id",Car.class);
		query.setParameter("id", id);
		Car car=(Car) query.getSingleResult();
		closeSession();
		System.out.println(car);
		
		
		closeSession();
		
	}
	
	public static void getAllData() {
		openSession();
		SelectionQuery<Car> query = session.createSelectionQuery("from Car",Car.class);
		List car = (List) query.getResultList();
		closeSession();
		Car.printCar(car);
	}
	public static void closeSession() {
		transaction.commit();
		session.close();
	}
	
	public static void openSession() {
		configuration =new Configuration();
		configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
		
	}
	
	
}
