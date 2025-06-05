package lokesh_hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lokesh_hibernate.entity.Book;

public class UpdateData {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Book.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Book book=new Book();
		book.setId(1);
		book.setPrice(3000.00);
		//session.update(book);
		session.saveOrUpdate(book);
		Transaction transaction=session.getTransaction();
		transaction.commit();
		session.close();
		
	}

}
