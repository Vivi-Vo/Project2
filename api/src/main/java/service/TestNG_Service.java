package service;
import daoimp.TestNG_DAO;
import interfaces.TNG_Interface;
import models.TestNG;
import utils.GsonCreateList;
import utils.GsonCreateString;
import java.util.ArrayList;

/** TestNG_Service Class
 * Description: Service class for TestNG methods. Methods defined using the TestNG Interface.
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_Service implements TNG_Interface
{
    /** Loads in records from JSON*/
    @Override
    public int loadRecords(String json, int batchID) {
        ArrayList<TestNG> records = GsonCreateList.createListFromJSON(json);
        int success = 1;
        for (TestNG test: records) {
            test.setBatchID(batchID);
            int res = new TestNG_DAO().insertTestNG(test);
            if (res == 0) success = 0;
        }//end for
        return success;
    }//end loadRecords()

    /** Gets most current records from the database. */
    @Override
    public String getRecords(int batchID) {
        ArrayList<TestNG> records = new TestNG_DAO().getRecords(batchID);
        return GsonCreateString.createStringTestNG(records);
    }//end getRecords()

    /** Gets all records from the Database. */
    @Override
    public String getAllRecords() {
        ArrayList<TestNG> records = new TestNG_DAO().getAllRecords();
        return GsonCreateString.createStringTestNG(records);
    }//end getAllRecords()

    /** NOT IMPLEMENTED*/
    @Override
    public void updateRecords(String json) { System.out.println("Update Method Not Implemented"); }

    /** NOT IMPLEMENTED*/
    @Override
    public void deleteRecords(String json) { System.out.println("Delete Method Not Implemented"); }

    /** Get a single test
     * @param testID test id*/
    @Override
    public String getTest(int testID)
    { return GsonCreateString.createTest(new TestNG_DAO().getTest(testID)); }
}//end class TestNG_Service
