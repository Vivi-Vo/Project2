package DAO;

import Util.HibernateUtil;
import model.TestNG;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ________ Class
 * Description:
 *
 * @author Joshua Pressley
 * @version 1.0
 */
public class TestNG_DAO {
    
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
}//end class TestNG_DAO
