package interfaces;
import models.TestNG;
import java.util.ArrayList;

/** TestNG Dao Interface
 * Description: Methods for TestNG DAO class
 * @author Joshua Pressley
 * @version 1.0 */
public interface TNG_DAO_Interface {
    /** Insert a TestNG record */
    void insertTestNG(TestNG record);
    /** Gets all TestNG records */
    ArrayList<TestNG> getAllRecords();
    /** Gets more current TestNG records */
    ArrayList<TestNG> getCurrentRecords(int batchID);
    /** Update record --NOT IMPLEMENTED */
    void updateTestNG(TestNG record);
    /** Delete record --NOT IMPLEMENTED */
    void deleteTestNG(TestNG record);
}//end interface TNG_DAO_Interface
