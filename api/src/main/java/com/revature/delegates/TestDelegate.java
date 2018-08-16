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
import service.TestNG_Service;
import utils.GsonCreateList;

public class TestDelegate {
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
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

        List<TestNG> req_obj = new ArrayList<TestNG>();
        req_obj = gson.fromJson(record_json,new TypeToken<ArrayList<TestNG>>() {}.getType());

        String id = req.getRequestURI().substring(req.getContextPath().length()+1);
        while(id.indexOf("/") > 0)
            id = id.substring(0, id.indexOf("/"));
        switch(id){
            case "": //All test cases
                allTest(req.getMethod(), req_obj, status);
                break;
            default:
                singleTest(req.getMethod(), id);
        }
    }
    public static void allTest(String method, List<TestNG> req_obj, int status){
    	TestNG_Service service = new TestNG_Service();
        switch(method){
            case "GET":
                service.getAllRecords();
                break;
            case "PUT":
                updateRecords(req_obj);
                break;
            case "POST":
                service.loadRecords(req_obj, batchService(status));
                break;
            case "DELETE":
                service.deleteRecords();
                break;
        }
    }
    public static void singleTest(String method, String req_obj){
        TestNG_Service service = new TestNG_Service();        
        switch(method){
            case "GET":
            	service.getRecordsCurrent();
                break;
            case "DELETE":
                service.deleteRecords();
                break;
        }
    }

}
