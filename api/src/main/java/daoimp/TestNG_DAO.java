package daoimp;
import interfaces.TNG_DAO_Interface;
import models.TestNG;
import java.util.ArrayList;

/** TestNG_DAO
 * Description: DAO Implementation for the TestNG Class
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_DAO implements TNG_DAO_Interface
{
    /** Insert a TestNG record */
    public void insertTestNG(TestNG record)
    { new CommonDAO().createRecord(record); }

    /** Gets all Records from the TestNG Table*/
    public ArrayList<TestNG> getAllRecords()
    {
        ArrayList<TestNG> results = null;
        //TODO
        return results;//error
    }//end getAllRecords()

    public ArrayList<TestNG> getCurrentRecords(int batchID)
    {
        ArrayList<TestNG> results = null;
        //TODO
        return results;//error
    }//end getCurrentRecords()

    public void updateTestNG(TestNG record) { System.out.println("Not Implemented"); }

    public void deleteTestNG(TestNG record) { System.out.println("Not Implemented"); }
}//end class TestNG_DAO
