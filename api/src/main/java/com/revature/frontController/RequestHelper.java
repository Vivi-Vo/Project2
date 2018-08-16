package com.revature.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.BatchDelegate;
import com.revature.delegates.TestDelegate;

public class RequestHelper {
    public static String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String endpoint = req.getRequestURI().substring(req.getContextPath().length()+1);
        switch (endpoint){
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
        }

        return null;
    }
}
