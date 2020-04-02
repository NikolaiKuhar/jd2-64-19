package by.it.academy;

import by.it.academy.entity.Employee;
import by.it.academy.entity.Person;
import org.hibernate.Session;


import java.util.Date;

import static by.it.academy.util.HibernateUtil.getSessionFactory;


public class PersonMain {
    Session session = getSessionFactory().openSession();
        session.beginTransaction();


    Person person = new Person(null, 25, "Kolya", "Pupkin");
		session.save();

    Employee employee = new Employee("");
		session.save(employee);

		session.getTransaction().commit();
		session.close();

}

