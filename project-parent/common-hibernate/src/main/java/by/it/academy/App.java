package by.it.academy;

import by.it.academy.entity.PersonEntity;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;

import static by.it.academy.util.HibernateUtil.getSessionFactory;


public class App {

    public static void main(String[] args) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        PersonEntity personEntity = new PersonEntity(null,"Kolya", "Vaskin",45);

        session.save(personEntity);
        session.getTransaction().commit();

        session.close();

        HibernateUtil.shutdown();




    }
}
