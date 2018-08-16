package com.revature.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("doget");
		RequestHelper.process(req, res);
	}
	protected void doPut(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		RequestHelper.process(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		RequestHelper.process(req, res);
	}
	protected void doDelete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		RequestHelper.process(req, res);
	}

	
}
