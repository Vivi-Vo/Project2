package com.revature.service;
import com.revature.daoimp.TestNG_DAO;
import com.revature.interfaces.TNG_Interface;
import com.revature.models.TestNG;
import com.revature.utils.GsonCreateString;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

/** TestNG_Service Class
 * Description: Service class for TestNG methods. Methods defined using the TestNG Interface.
 * @author Joshua Pressley
 * @version 1.0 */
public class TestNG_Service implements TNG_Interface
{
    /** Loads in records from JSON*/
    @Override public int loadRecords(JSONArray json, int batchID)
    {
        ArrayList<TestNG> records = new ArrayList<>();
    	ArrayList<JSONObject> jobs = new ArrayList<>();
        Iterator<Object> itr = json.iterator();
        int success = 1;

    	while (itr.hasNext()) { jobs.add((JSONObject) itr.next()); }
        for (JSONObject jo : jobs) { records.add(this.createRecordFromJson(jo)); }
        for (TestNG test: records) {
            test.setBatchID(batchID);
            int res = new TestNG_DAO().insertTestNG(test);
            if (res == 0) success = 0;
        }//end for
        return success; //was there an insert failure
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

    /** Get a single test
     * @param testID test id*/
    @Override public String getTest(int testID)
    { return GsonCreateString.createJson(new TestNG_DAO().getTest(testID)); }

    /** Gets most current records from the database. */
    @Override public String getRecords(int batchID)
    { return GsonCreateString.createJson(new TestNG_DAO().getRecords(batchID)); }

    /** Gets all records from the Database. */
    @Override public String getAllRecords()
    { return GsonCreateString.createJson(new TestNG_DAO().getAllRecords()); }
}//end class TestNG_Service
