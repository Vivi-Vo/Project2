package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import models.TestNG;
import service.Batch_Service;
import service.TestNG_Service;
import utils.GsonCreateList;

public class TestDelegate {
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
/*        List<TestNG> req_obj = new ArrayList<TestNG>();
        req_obj = gson.fromJson(record_json,new TypeToken<ArrayList<TestNG>>() {}.getType());
*/ 
        String id = req.getRequestURI().substring(req.getContextPath().length()+1);
        while(id.indexOf("/") > 0)
            id = id.substring(0, id.indexOf("/"));
        switch(id){
            case "": //All test cases
                allTest(req.getMethod(), req);
                break;
            default:
                singleTest(req.getMethod(), req);
        }
    }
    public static void allTest(String method, HttpServletRequest req ) throws ServletException, IOException{
    	TestNG_Service service = new TestNG_Service();
    	Batch_Service b_service = new Batch_Service();

        switch(method){
            case "GET":
                service.getAllRecords();
                break;
            case "PUT":
//                service.updateRecords(json);
                break;
            case "POST":
                BufferedReader req_json = req.getReader();
                StringBuilder sb = new StringBuilder();
                while(req_json.readLine() != null){
                    sb.append(req_json);
                }
                String json = sb.toString();
                Gson gson = new GsonBuilder().create();
                String status_json = json.split(",")[0];
                int status = gson.fromJson(status_json, Integer.class);                
                String record_json = json.substring(status_json.indexOf(","));
                
                service.loadRecords(record_json, b_service.createBatch(status));
                break;
            case "DELETE":
 //               service.deleteRecords(json);
                break;
        }
    }
    public static void singleTest(String method, HttpServletRequest req) throws IOException, ServletException{
    	TestNG_Service service = new TestNG_Service();
    	TestNG test = new TestNG();    	
        switch(method){
            case "GET":
            	service.getRecordsCurrent(test.getBatchID());
                break;
            case "DELETE":
//                service.deleteRecords();
                break;
        }
    }
    
}
