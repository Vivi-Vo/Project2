package com.revature.delegates;
import com.revature.service.TestNG_Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** TestDelegate
 * Retrieving test from database for GET method
 * Returning 403 Error for POST test 
 *  * @author Vivi Vo
 * @version 1.0 */
public class TestDelegate 
{
	/** Submits request*/
	public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
        switch(req.getMethod()) {
            case "GET":
            	String result = getTest(req);
                if(result != null) {
                    res.setContentType("application/json");
                    res.setStatus(200);
                    res.getWriter().append(result);
                }//end if
                break;
            case "POST":
                res.setContentType("application/json");
                res.sendError(403);
                break;
        }//end switch
    }//end requestSubmit()
    
	/** Gets a test */
    private static String getTest(HttpServletRequest req)
    {
        TestNG_Service service = new TestNG_Service();
        if(req.getQueryString() == null) 
        {
        	String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
        	String context;
        	
        	try 
        	{ context = path.substring(0, path.indexOf('/')); }
        	catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) 
        	{ context = path; }

            switch (context) {
                case "test": return service.getRecords(Integer.parseInt(path.substring(path.indexOf('/') + 1)));
                case "tests": return service.getAllRecords();
                default: return null;
            }//end switch
        }//end if
        else {
            String id = req.getQueryString().substring(req.getQueryString().length()-1);
            return service.getRecords(Integer.parseInt(id));
        }//end else
    }//end getTest()
}//end class TestDelegate
