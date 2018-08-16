package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

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
                if(postBatch(req) != -1)
                    res.setStatus(201);
                break;
        }
    }
    public static String getBatch(HttpServletRequest req){
        Batch_Service b_service = new Batch_Service();
        TestNG_Service service = new TestNG_Service();
        String[] uri = req.getRequestURI().split("/");
                
        String context = uri[2];
        if(context.equals("batch"))
        {
            String id = req.getRequestURI().substring(req.getContextPath().length()+1);
      
        	while(id.indexOf("/") > 0)
        	{
                id = id.substring(0, id.indexOf("/"));
        	}
        	System.out.println("id: " + id);
                if(id.equals("tests")) {
            	id = uri[3];
                return service.getRecords(Integer.parseInt(id));
            }
            else if (id.equals("")) {
            	return b_service.getBatch(b_service.getMostRecentBatch());
            }
            else
            	return b_service.getBatch(Integer.parseInt(id));
        }
        
        else if (context.equals("batches")){
            return b_service.getAllBatches();
         }
        else
            return null;
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
        int id = b_service.createBatch(status);
        if(service.loadRecords(record_json, id) != 0)
        	return id;
        else
        	return -1;
    }
}
