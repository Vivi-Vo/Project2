package daoimp;
import interfaces.TNG_DAO_Interface;
import utils.HibernateUtil;
import models.TestNG;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;

/** TestNG_DAO
 * Description: DAO Implementation for the TestNG Class
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_DAO implements TNG_DAO_Interface
{
    /** Insert a TestNG record */
    public void insertTestNG(TestNG record) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(record);
            transaction.commit();
        }//end try
        catch (HibernateException he) { if (transaction != null) transaction.rollback(); }
        finally { session.close(); }
    }//end insertTestNG()

    public ArrayList<TestNG> getAllRecords()
    {
        ArrayList<TestNG> results = null;
        //TODO
        return results;//error
    }

    public ArrayList<TestNG> getCurrentRecords()
    {
        ArrayList<TestNG> results = null;
        //TODO
        return results;//error
    }

    public void updateTestNG(TestNG record) { System.out.println("Not Implemented"); }

    public void deleteTestNG(TestNG record) { System.out.println("Not Implemented"); }
}//end class TestNG_DAO
