package daoimp;
import interfaces.Batch_DAO_Interface;
import models.Batch;
import models.TestNG;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import java.util.List;

/** Batch_DAO
 * Methods for Batch Operations in the Database
 * @author Joshua Pressley
 * @version 1.0 */
public class Batch_DAO implements Batch_DAO_Interface
{
    /** Create a batch */
    public void createBatch(Batch batch1)
    { new CommonDAO().createRecord(batch1); }

    /** Get most recent batch */
    @Override
    public int getMostRecent() {
        Session session = utils.HibernateUtil.getSession().openSession();
        List results = session.createCriteria(TestNG.class)
                .setProjection( Projections.projectionList()
                        .add( Projections.max("batchID") ) )
                .list();
        return Integer.parseInt(results.get(0).toString());
    }//end getMostRecent()
}//end class Batch_DAO
