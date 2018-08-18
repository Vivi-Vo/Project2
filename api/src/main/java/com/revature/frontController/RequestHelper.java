package com.revature.frontController;
import com.revature.delegates.BatchDelegate;
import com.revature.delegates.TestDelegate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** RequestHelper
 * Reroute requests to specific delegate based on request endpoint
 *  * @author Vivi Vo
 * @version 1.0 */
public class RequestHelper 
{
	/** processes request*/
    public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	String[] uri= req.getRequestURI().split("/");
    	String context;
    	try { context = uri[2]; }
    	catch (ArrayIndexOutOfBoundsException e) { context = "";}

    	switch (context) {
            case "test":
                TestDelegate.requestSubmit(req, res);
                break;
            case "tests":
                TestDelegate.requestSubmit(req, res);
                break;
            case "batch":
                BatchDelegate.requestSubmit(req, res);
                break;
            case "batches":
                BatchDelegate.requestSubmit(req, res);
                break;
             default:
                 res.setContentType("application/json");
                 res.setStatus(200);
                 res.getWriter().append("Welcome, You have contacted the server");
        }//end switch
    }//end process()
}//end class RequestHelper
