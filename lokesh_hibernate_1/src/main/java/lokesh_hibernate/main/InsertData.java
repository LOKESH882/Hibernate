package lokesh_hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import lokesh_hibernate.entity.Employee;

public class InsertData {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Employee.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee emp = new Employee("John Doe", "Engineering", 75000.0f, "Pune");
        session.persist(emp);
        Transaction transact=session.getTransaction();
        transact.commit();
        session.close();
        factory.close();
    }
}
