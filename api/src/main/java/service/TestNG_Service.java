package service;
import daoimp.TestNG_DAO;
import interfaces.TNG_Interface;
import models.TestNG;
import utils.GsonCreateList;
import utils.GsonCreateString;
import java.util.ArrayList;

/** TestNG_Service Class
 * Description: Service class for TestNG methods.
 *      Methods defined using the TestNG Interface.
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_Service implements TNG_Interface
{
    @Override
    public void loadRecords(String json, int batchID) {
        ArrayList<TestNG> records = GsonCreateList.createListFromJSON(json);
        for (TestNG test: records) {
            test.setBatchID(batchID);
            new TestNG_DAO().insertTestNG(test);
        }//end for
    }//end loadRecords()

    /** Gets most current records from the database. */
    @Override
    public String getRecords(int batchID) {
        ArrayList<TestNG> records = new TestNG_DAO().getRecords(batchID);
        return GsonCreateString.createStringTestNG(records);
    }//end getRecords()

    /** Gets al records from the Database. */
    @Override
    public String getAllRecords() {
        ArrayList<TestNG> records = new TestNG_DAO().getAllRecords();
        return GsonCreateString.createStringTestNG(records);
    }//end getAllRecords()

    @Override
    public void updateRecords(String json) { System.out.println("Update Method Not Implemented"); }

    @Override
    public void deleteRecords(String json) { System.out.println("Delete Method Not Implemented"); }
}//end class TestNG_Service
