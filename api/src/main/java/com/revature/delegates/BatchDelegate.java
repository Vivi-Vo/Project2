package com.revature.delegates;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import service.Batch_Service;
import service.TestNG_Service;

/** BatchDelegate
 * Retrieving Batch info for GET method, return a 200 status along with batch info if success
 * Inserting new batch for POST, return a 201 status for if insert succeed 
 * @author Vivi Vo
 * @version 1.0 */
public class BatchDelegate 
{
	/** Request handler for Batches */
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        switch(req.getMethod()) {
        	case "GET":
	        	String result = getBatch(req);
	            if(result != null) {
	                res.setStatus(200);
	                res.getWriter().append(result);
            }//end if
            break;
            case "POST":
            	int rest = postBatch(req);
                if (rest != -1) {
                	res.setStatus(201);
                	res.setHeader("location", "/batch/"+rest);
                	res.getWriter().append("Created");
                }//end if
                break;
        }//end switch
    }//end requestSubmit()
    
    /** Returns batch information from the Database*/
    public static String getBatch(HttpServletRequest req)
    {
        Batch_Service b_service = new Batch_Service();
        TestNG_Service service = new TestNG_Service();
        
        String[] uri = req.getRequestURI().split("/");
        System.out.println(Arrays.toString(uri));      
        String context = uri[2];

        if(context.equals("batch")) {
            int length = uri.length;
            switch (length){
                case 3: // /batch
            	    return b_service.getBatch(b_service.getMostRecentBatch());
                case 4: // /batch/id
            	    return b_service.getBatch(Integer.parseInt(uri[3]));
                case 5: // /batch/id/tests
                    return service.getRecords(Integer.parseInt(uri[3]));
                default:
                    return null;
            }//end switch
        }//end if
        else if (context.equals("batches"))
            return b_service.getAllBatches();
        else
            return null;
    }//end getBatch()    
    
    /** Posts a batch and returns the inserted records. */
    public static int postBatch(HttpServletRequest req)throws IOException, ServletException
    {
        TestNG_Service service = new TestNG_Service();
    	Batch_Service b_service = new Batch_Service();
    	
        String test = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        JSONObject jo = new JSONObject(test);
        JSONArray testArray = jo.getJSONArray("tests");
        int id = b_service.createBatch(jo.getInt("status")); 
        if(service.loadRecords(testArray, id) != 0)
        	return id;
        else
        	return -1;
    }//end postBatch()
}//end class BatchDelegate
