package db;

import models.Drums;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDrums {

    private static Session session;
    private static Transaction transaction;

    public static void save(Drums drums){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction =  session.beginTransaction();
            session.save(drums);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static List<Drums> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Drums> results = null;

        try {
            Criteria cr = session.createCriteria(Drums.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Drums findById(int id){
        Drums result = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Drums.class);
            cr.add(Restrictions.eq("id", id));
            result = (Drums) cr.uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
