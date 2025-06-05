package lokesh_hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import lokesh_hibernate.entity.Book;

public class GetData {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Book.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Book book=null;
		//book=session.get(Book.class,1);
		//book=session.find(Book.class, 1);
		book=session.load(Book.class, 1);
		Transaction transaction=session.getTransaction();
		transaction.commit();
		session.close();
		System.out.println(book);

	}

}
