package com.revature.delegates;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestDelegate {
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res){
        String id = req.getRequestURI().substring(req.getContextPath().length()+1);
        while(id.indexOf("/") > 0)
            id = id.substring(0, id.indexOf("/"));
        switch(id){
            case "": //All test cases
                allTest(req.getMethod());
                break;
            default:
                singleTest(req.getMethod(), id);
        }
    }
    public static void allTest(String method){
        switch(method){
            case "GET":
                // call service class
                break;
            case "PUT":
                break;
            case "POST":
                break;
            case "DELETE":
                break;
        }
    }
    public static void singleTest(String method, String id){
        switch(method){
            case "GET":
                break;
            case "PUT":
                break;
            case "POST":
                break;
            case "DELETE":
                break;
        }
    }
}
