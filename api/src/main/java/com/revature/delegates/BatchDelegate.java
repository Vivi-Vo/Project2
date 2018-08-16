package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.Batch_Service;
import service.TestNG_Service;

public class BatchDelegate {
    public static void requestSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
    	
        String method = req.getMethod();
        switch(method){
            case "GET":
                if(getBatch(req) != null);
                    res.setStatus(200);
                break;
            case "POST":
                if(postBatch(req) != 0)
                    res.setStatus(201);
                break;
        }
    }
    public static String getBatch(HttpServletRequest req){
        
        TestNG_Service service = new TestNG_Service();
        String id = req.getRequestURI().substring(req.getContextPath().length()+1);
        while(id.indexOf("/") > 0)
        id = id.substring(0, id.indexOf("/"));
        return service.getRecords(Integer.parseInt(id));
        }    
    
    public static int postBatch(HttpServletRequest req)throws IOException, ServletException{
        TestNG_Service service = new TestNG_Service();
    	Batch_Service b_service = new Batch_Service();

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
        
        return service.loadRecords(record_json, b_service.createBatch(status));
    }
}
