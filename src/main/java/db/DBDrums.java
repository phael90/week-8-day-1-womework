package db;

import models.Drums;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
