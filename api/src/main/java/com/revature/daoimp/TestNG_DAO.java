package com.revature.daoimp;
import com.revature.interfaces.TNG_DAO_Interface;
import com.revature.models.TestNG;
import org.hibernate.Session;
import com.revature.utils.HibernateUtil;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/** TestNG_DAO
 * Description: DAO Implementation for the TestNG Class
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_DAO implements TNG_DAO_Interface
{
    /** Insert a TestNG record */
    @Override public int insertTestNG(TestNG record)
    { return new CommonDAO().createRecord(record); }

    /** Gets all Records from the TestNG Table*/
    @Override public ArrayList<TestNG> getAllRecords() {
        Session session = HibernateUtil.getSession().openSession();
        Query query = session.getNamedQuery("RetrieveAllTestNG");
        return new ArrayList<TestNG>(query.getResultList());
    }//end getAllRecords()

    /** Gets current records */
    @Override public ArrayList<TestNG> getRecords(int batchID) {
        Session session = HibernateUtil.getSession().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestNG> criteria = builder.createQuery(TestNG.class);
        Root<TestNG> root = criteria.from(TestNG.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("batchID"), batchID));
        List<TestNG> resultList = session.createQuery(criteria).getResultList();
        return new ArrayList<>(resultList);
    }//end getRecords()

    /** Get a single test
     * @param testID test id */
    @Override public TestNG getTest(int testID) {
        Session session = HibernateUtil.getSession().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestNG> criteria = builder.createQuery(TestNG.class);
        Root<TestNG> root = criteria.from(TestNG.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("recordID"), testID));
        List<TestNG> resultList = session.createQuery(criteria).getResultList();
        return new ArrayList<>(resultList).get(0);
    }//end getTest()
}//end class TestNG_DAO
