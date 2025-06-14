package lokesh_hibernate.Operations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lokesh_hibernate.entity.Employee3;
import lokesh_hibernate.entity.Languages;

public class operation {
	public static Configuration configuration=null;
	public static SessionFactory factory=null;
	public static Session session =null;
	public static Transaction transaction=null;
	
	public static void insert_Data_2() {
		opensession();
		Languages language = session.get(Languages.class,3);
		List<Languages> list=new ArrayList<Languages>();
		
		list.add(language);
		Employee3 emp = new Employee3("Manoday");
		emp.setLanguage_list(list);
		session.persist(emp);
		
		
		closesession();
	}
	
	public static void insert_Data() {
		opensession();
		
		Languages lang1 = new Languages("Java");
		Languages lang2 = new Languages("SQL");
		Languages lang3 = new Languages("HTML");
		Languages lang4 = new Languages("Python");
		
		List<Languages> list = new ArrayList<Languages>();
		list.add(lang1);
		list.add(lang2);
		
		Employee3 emp = new Employee3("Lokesh");
		
		emp.setLanguage_list(list);
		session.persist(lang1);
		session.persist(lang2);
		session.persist(lang3);
		session.persist(lang4);
		session.persist(emp);
		closesession();
	}
	public static void closesession() {
		transaction.commit();
		session.close();
	}
	public static void opensession() {
		configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee3.class);
		configuration.addAnnotatedClass(Languages.class);
		factory=configuration.buildSessionFactory();
		
		session=factory.openSession();
		session.beginTransaction();
		
		transaction = session.getTransaction();
		
		
	}
}
