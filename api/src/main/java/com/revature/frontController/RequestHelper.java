package com.revature.frontController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.delegates.BatchDelegate;
import com.revature.delegates.TestDelegate;

/** RequestHelper
 * Reroute requests to specific delegate based on request endpoint
 *  * @author Vivi Vo
 * @version 1.0 */
public class RequestHelper 
{
	/** */
    public static String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	String[] uri= req.getRequestURI().split("/");
    	switch (uri[2]) {
            case "test":
            	System.out.println("test");
                TestDelegate.requestSubmit(req, res);
                break;
            case "tests":
            	System.out.println("tests");
                TestDelegate.requestSubmit(req, res);
                break;
            case "batch":
            	System.out.println("Batch");
                BatchDelegate.requestSubmit(req, res);
                break;
            case "batches":
            	System.out.println("Batches");
                BatchDelegate.requestSubmit(req, res);
                break;
        }//end switch
        return null;
    }//end process
}//end class RequestHelper
