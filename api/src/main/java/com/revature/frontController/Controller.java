package com.revature.frontController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Controller
 * FrontController to receive and process httpServletRequest
 * @author Vivi Vo
 * @version 1.0 */
public class Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{ RequestHelper.process(req, res); }
	
	protected void doPut(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{ RequestHelper.process(req, res); }

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{ RequestHelper.process(req, res); }
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{ RequestHelper.process(req, res); }
}//end class Controller
