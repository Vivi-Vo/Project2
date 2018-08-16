package com.revature.frontController;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.BatchDelegate;
import com.revature.delegates.TestDelegate;

public class RequestHelper {
    public static String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("process");
    //	String endpoint = req.getRequestURI().substring(req.getContextPath().length()+1);
    	String[] uri= req.getRequestURI().split("/");
    	String endpoint = uri[2];
    	System.out.println(Arrays.toString(uri));
    	switch (endpoint){
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
        }

        return null;
    }
}
