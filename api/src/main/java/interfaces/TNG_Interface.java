package interfaces;

/** TestNG Service Interface
 * Description: Methods for TestNG Service class
 * @author Joshua Pressley
 * @version 1.0 */
public interface TNG_Interface {
    /** Load records into the DB */
    int loadRecords(String json, int batchID);
    /** Get records from most recent load. */
    String getRecords(int batchID);
    /** Get records from all loads */
    String getAllRecords();
    /** Update record --NOT IMPLEMENTED */
    void updateRecords(String json);
    /** Delete record --NOT IMPLEMENTED */
    void deleteRecords(String json);
    /** Get a single test */
    String getTest(int testID);
}//end interface TNG_Interface
