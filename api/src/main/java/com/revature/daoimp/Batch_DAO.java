package com.revature.daoimp;
import com.revature.interfaces.Batch_DAO_Interface;
import com.revature.models.Batch;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/** Batch_DAO
 * Methods for Batch Operations in the Database
 * @author Joshua Pressley
 * @version 1.0 */
public class Batch_DAO implements Batch_DAO_Interface
{
    /** Create a batch */
    @Override public void createBatch(Batch batch1)
    { new CommonDAO().createRecord(batch1); }

    /** Get most recent batch */
    @Override public int getMostRecent() {
        Session session = HibernateUtil.getSession().openSession();
        List results = session.createCriteria(Batch.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.max("batchID") ) )
                .list();
        return Integer.parseInt(results.get(0).toString());
    }//end getMostRecent()

    /** Gets all batches */
    @Override public ArrayList<Batch> getAllBatches() {
        Session session = HibernateUtil.getSession().openSession();
        Query query = session.getNamedQuery("RetrieveAllBatch");
        return new ArrayList<Batch>(query.getResultList());
    }//end getAllBatches()

    /** Get specific batch.
     * @param ID id to fetch */
    @Override public Batch getBatch(int ID) {
        Session session = HibernateUtil.getSession().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Batch> criteria = builder.createQuery(Batch.class);
        Root<Batch> root = criteria.from(Batch.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("batchID"), ID));
        List<Batch> resultList = session.createQuery(criteria).getResultList();
        return new ArrayList<>(resultList).get(0);
    }//end getBatch()
}//end class Batch_DAO
