package db;

import models.Drummer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDrummer {

    private static Session session;
    private static Transaction transaction;

    public static void save(Drummer drummer) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(drummer);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();

        } finally {
            session.close();
        }
    }

    public static List<Drummer> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Drummer> results = null;

        try {
            Criteria cr = session.createCriteria(Drummer.class);
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }

    public static Drummer findById(int id) {
        Drummer result = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Drummer.class);
            cr.add(Restrictions.eq("id", id));
            result = (Drummer) cr.uniqueResult();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
