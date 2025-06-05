package lokesh_hibernate_operations;

import org.hibernate.Session;
import java.util.List; // Correct List interface
import org.hibernate.query.Query; // Hibernate's generic Query interface

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lokesh_hibernate_entity.Car;

public class Operation_1 {
	private static Configuration configuration = null;
	private static SessionFactory factory = null;
	private static Session session=null;
	private static Transaction transaction=null;
	
	public static void deleteData_1() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.load(Car.class, 3);
    	session.remove(car);
    	transaction.commit();
        session.close();
	}
	
	// delete() method
	public static void deleteData() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.load(Car.class, 4);
    	session.delete(car);
    	
    	transaction.commit();
        session.close();
	}
	
	public static void getAllData() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    configuration.addAnnotatedClass(Car.class);
	    factory = configuration.buildSessionFactory();
	    session = factory.openSession();
	    session.beginTransaction();
	    transaction = session.getTransaction();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
	    Root<Car> root = criteria.from(Car.class);
	    criteria.select(root);
	    Query<Car> query = session.createQuery(criteria);
	    List<Car> carList = query.getResultList();
	    transaction.commit();
	    session.close();
	    Car.printCar(carList);
	}

	
	// load() method
	public static void getData_3() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.load(Car.class, 4);
    	System.out.println(car);
    	transaction.commit();
        session.close();
	}
	public static void getData_2() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.find(Car.class, 3);
    	System.out.println(car);
    	transaction.commit();
        session.close();
	}
	// get() method
	public static void getData() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.get(Car.class, 2);
    	System.out.println(car);
    	transaction.commit();
        session.close();
	}
	// merge() method
	public static void updateData_2() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.get(Car.class, 1);
    	car.setColor("Pink");
    	Car car1=session.merge(car);
    	System.out.println(car1);
    	transaction.commit();
        session.close();
	}
	
	//update() method
	public static void updateData() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car=session.get(Car.class, 1);
    	car.setColor("Blue");
    	session.update(car);
    	transaction.commit();
        session.close();
	}
	
	public static void insertData_3() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	session.beginTransaction();
    	transaction=session.getTransaction();
    	Car car= new Car("Alto","CNG",10000,"Silver");
    	//session.save(car);
         session.persist(car);
         transaction.commit();
         session.close();
	}
	
	// sava() method
	public static void insertData_2() {
		Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Car.class);
    	factory = configuration.buildSessionFactory();
    	session=factory.openSession();
    	transaction=session.beginTransaction();
    	Car car = new Car("Lamborgini","Petrol",10000,"Red");
    	session.save(car);
        // session.persist(car);
         transaction.commit();
         session.close();
    	
	}

	public static void insertData() {
        Session session = DoConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        Car car = new Car("Nano", "Petrol", 50000, "Yellow");
        session.save(car);

        transaction.commit();
        session.close();
    }
}
