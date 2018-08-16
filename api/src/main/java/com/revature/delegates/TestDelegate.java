package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TestNG_Service;

public class TestDelegate {
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String method = req.getMethod();
        switch(method){
            case "GET":
                if(getTest(req) != null);
                    res.setStatus(200);
                break;
            case "POST":
                res.sendError(403);
                break;
        }
    }
    public static String getTest(HttpServletRequest req){
        TestNG_Service service = new TestNG_Service();
        if(req.getQueryString() == null)
        {
            String context = req.getRequestURI().substring(req.getContextPath().length() + 1);
            if(context.equals("test"))
            {
                String id = req.getRequestURI().substring(req.getContextPath().length()+1);
                while(id.indexOf("/") > 0)
                {
                	id = id.substring(0, id.indexOf("/"));
                }
            	System.out.println(id);

                return service.getRecords(Integer.parseInt(id));
            }
            else if (context.equals("tests")){
                return service.getAllRecords();
            }
            else
                return null;
        }
        else{

            String id = req.getQueryString().substring(req.getQueryString().length()-1);
            return service.getRecords(Integer.parseInt(id));
        }    
    }
}
