import db.DBDrummer;
import models.Drummer;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Drummer drummer1 = new Drummer("Newman", "Baker");
        DBDrummer.save(drummer1);

        Drummer drummer2 = new Drummer("Erick", "Allen");
        DBDrummer.save(drummer2);

        Drummer drummer3 = new Drummer("Arron", "Scott");
        DBDrummer.save(drummer3);

        Drummer drummer4 = new Drummer("John", "Betsch");
        DBDrummer.save(drummer4);
    }

    List<Drummer> drummers = DBDrummer.getAll();

    Drummer foundDrummer = DBDrummer.findById(2);
}






