package daoimp;
import interfaces.TNG_DAO_Interface;
import models.TestNG;
import org.hibernate.Session;
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
    public int insertTestNG(TestNG record)
    { return new CommonDAO().createRecord(record); }

    /** Gets all Records from the TestNG Table*/
    public ArrayList<TestNG> getAllRecords() {
        Session session = utils.HibernateUtil.getSession().openSession();
        Query query = session.getNamedQuery("RetrieveAllTestNG");
        return new ArrayList<TestNG>(query.getResultList());
    }//end getAllRecords()

    /** Gets current records */
    public ArrayList<TestNG> getRecords(int batchID) {
        Session session = utils.HibernateUtil.getSession().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestNG> criteria = builder.createQuery(TestNG.class);
        Root<TestNG> root = criteria.from(TestNG.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("batchID"), batchID));
        List<TestNG> resultList = session.createQuery(criteria).getResultList();
        return new ArrayList<>(resultList);
    }//end getRecords()

    public void updateTestNG(TestNG record) { System.out.println("Not Implemented"); }
    public void deleteTestNG(TestNG record) { System.out.println("Not Implemented"); }
}//end class TestNG_DAO
