package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.TestNG;
import service.TestNG_Service;

public class TestDelegate {
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String id = req.getRequestURI().substring(req.getContextPath().length()+1);

        BufferedReader req_json = req.getReader();
        List<TestNG> req_obj = new ArrayList<TestNG>();

        req_obj = utils.GsonCreateList(req_json);

        while(id.indexOf("/") > 0)
            id = id.substring(0, id.indexOf("/"));
        switch(id){
            case "": //All test cases
                allTest(req.getMethod(), req_obj);
                break;
            default:
                singleTest(req.getMethod(), id);
        }
    }
    public static void allTest(String method, List<TestNG> req_obj){
    	TestNG_Service service = new TestNG_Service();
        switch(method){
            case "GET":
                service.getAllRecords();
                break;
            case "PUT":
                updateRecords(req_obj);
                break;
            case "POST":
                service.loadRecords(req_obj);
                break;
            case "DELETE":
                deleteRecords();
                break;
        }
    }
    public static void singleTest(String method, String req_obj){
    	TestNG_Service service = new TestNG_Service();

        switch(method){
            case "GET":
            	service.getRecordsCurrent();
                break;
            case "PUT":
            	// not implemented
                break;
            case "POST":
            	// not implemented
                break;
            case "DELETE":
                service.deleteRecords();
                break;
        }
    }

}
