package com.revature.delegates;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TestNG_Service;

/** TestDelegate
 * Retrieving test from database for GET method
 * Returning 403 Error for POST test 
 *  * @author Vivi Vo
 * @version 1.0 */
public class TestDelegate 
{
	/** */
	public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
        switch(req.getMethod()) {
            case "GET":
            	String result = getTest(req);
                if(result != null) {
                    res.setStatus(200);
                    res.getWriter().append(result);
                }//end if
                break;
            case "POST":
                res.sendError(403);
                break;
        }//end switch
    }//end requestSubmit()
    
	/** */
    public static String getTest(HttpServletRequest req)
    {
        TestNG_Service service = new TestNG_Service();
        if(req.getQueryString() == null) 
        {
        	String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
        	String context = "";
        	
        	try 
        	{ context = path.substring(0, path.indexOf('/')); } 
        	catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) 
        	{ context = path; }
        	
            if(context.equals("test")) 
                return service.getRecords(Integer.parseInt(path.substring(path.indexOf('/')+1)));
            else if (context.equals("tests"))
            	return service.getAllRecords();
            else
                return null;
        }//end if
        else {
            String id = req.getQueryString().substring(req.getQueryString().length()-1);
            return service.getRecords(Integer.parseInt(id));
        }//end else    
    }//end getTest()
}//end class TestDelegate
