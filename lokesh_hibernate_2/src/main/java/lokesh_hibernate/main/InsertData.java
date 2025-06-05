package lokesh_hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import lokesh_hibernate.entity.Book;
public class InsertData {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
        configuration.addAnnotatedClass(Book.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = new Book(101,"Java","JBK","Mayur",2000);
       // session.persist(book);
        Transaction transact=session.getTransaction();
        session.save(book);
        transact.commit();
        session.close();
        factory.close();

	}

}
