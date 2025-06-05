package lokesh_hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lokesh_hibernate.entity.Student;

public class hibernate_config {
    public static void main(String[] args) {
        // Load configuration and build session factory
        Configuration config = new Configuration();
        config.configure();  // Reads hibernate.cfg.xml
        config.addAnnotatedClass(Student.class);

        SessionFactory factory = config.buildSessionFactory();
        
        // Open a session and begin transaction
        Session session = factory.openSession();
        session.beginTransaction();
        Student stud =session.get(Student.class, 5);
        System.out.println(stud);

    }
}
