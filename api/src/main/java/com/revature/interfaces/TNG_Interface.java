package com.revature.interfaces;
import org.json.JSONArray;

/** TestNG Service Interface
 * Description: Methods for TestNG Service class
 * @author Joshua Pressley
 * @version 1.0 */
public interface TNG_Interface {
    /** Load records into the DB */
    int loadRecords(JSONArray json, int batchID);
    /** Get records from most recent load. */
    String getRecords(int batchID);
    /** Get records from all loads */
    String getAllRecords();
    /** Get a single test */
    String getTest(int testID);
}//end interface TNG_Interface
