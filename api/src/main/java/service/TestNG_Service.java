package service;
import daoimp.TestNG_DAO;
import interfaces.TNG_Interface;
import models.TestNG;
import utils.GsonCreateString;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/** TestNG_Service Class
 * Description: Service class for TestNG methods. Methods defined using the TestNG Interface.
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_Service implements TNG_Interface
{
    /** Loads in records from JSON*/
    @Override
    public int loadRecords(JSONArray json, int batchID) 
    {
    	Iterator<Object> itr = json.iterator();
    	ArrayList<JSONObject> jobs = new ArrayList<JSONObject>();
    	while (itr.hasNext()) { jobs.add((JSONObject) itr.next()); }
    	int success = 1;
        ArrayList<TestNG> records = new ArrayList<TestNG>();
        for (JSONObject jo : jobs) { records.add(this.createRecordFromJson(jo)); }
        for (TestNG test: records) {
            test.setBatchID(batchID);
            int res = new TestNG_DAO().insertTestNG(test);
            if (res == 0) success = 0;
        }//end for
        return success;
    }//end loadRecords()
    
    /** Create TestNG record from JSONObject */
    private TestNG createRecordFromJson(JSONObject jo) 
    {
    	TestNG t = new TestNG();
    	//REQUIRED
    	t.setInitiatedBy(jo.getString("InitiatedBy"));
    	t.setStatus(jo.getInt("status")+"");
    	t.setSignature(jo.getString("signature"));
    	t.setName(jo.getString("name"));
    	t.setDuration_ms(jo.getInt("duration_ms"));
    	t.setStartTime(jo.getString("startTime"));
    	t.setFinishTime(jo.getString("finishTime"));
    	
    	//OPTIONAL
    	if (t.getStatus().equals("0")) {
    		t.setExceptionClass(jo.getString("exceptionClass"));
    		t.setExceptionMessage(jo.getString("exceptionMessage"));
    		t.setStackTrace(jo.getString("stackTrace"));
    	}//end if 
    	return t;
    }//end createRecordFromJson()

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
