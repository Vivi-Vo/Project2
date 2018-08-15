package com.revature.frontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.OtherDelegate;
import com.revature.delegates.TestDelegate;

public class RequestHelper {
    public static String process(HttpServletRequest req, HttpServletResponse res){
        String endpoint = req.getRequestURI().substring(req.getContextPath().length()+1);
        switch (endpoint){
            case "test":
                TestDelegate.requestSubmit(req, res);
                break;
            case "other":
                OtherDelegate.requestSubmit(req, res);
        }

        return null;
    }
}
