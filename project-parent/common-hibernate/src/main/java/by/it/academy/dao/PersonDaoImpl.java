package by.it.academy.dao;

import by.it.academy.entity.PersonEntity;
import by.it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void create(PersonEntity pe) {
        Transaction tx1 = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.save(pe);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) {
                tx1.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(PersonEntity pe) {
        Transaction tx1 = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.update(pe);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) {
                tx1.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void read(long id) {
        Transaction tx1 = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.load(PersonEntity.class, id);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) {
                tx1.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PersonEntity pe) {
        Transaction tx1 = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(pe);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) {
                tx1.rollback();
            }
            e.printStackTrace();
        }
    }
}
