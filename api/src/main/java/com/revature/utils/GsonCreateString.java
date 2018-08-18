package com.revature.utils;
import com.google.gson.Gson;

/** GsonCreateString
 * Description: Creates JSON string from object/list of objects
 * @author Joshua Pressley
 * @version 1.0 */
public class GsonCreateString
{
    public static String createJson(Object o) {
        if (o != null) return new Gson().toJson(o);
        return null;
    }//end createJson()
}//end class GsonCreateString
