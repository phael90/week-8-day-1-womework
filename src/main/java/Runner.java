import db.DBDrummer;
import db.DBDrums;
import models.Drummer;
import models.Drums;

public class Runner {

    public static void main(String[] args) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Drummer drummer = new Drummer("Newman", "Baker");
        DBDrummer.save(drummer);

    Drums drums = new Drums("Gretch");
        DBDrums.save(drums);
    }
}
