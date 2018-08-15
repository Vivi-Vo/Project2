package daoimp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/** Common_DAO
 * Methods for Common Operations in the Database for multiple Tables
 * @author Joshua Pressley
 * @version 1.0 */
class CommonDAO
{
    void createRecord(Object o) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
        }//end try
        catch (HibernateException he) { if (transaction != null) transaction.rollback(); }
        finally { session.close(); }
    }//end createRecord()
}//end class CommonDAO
