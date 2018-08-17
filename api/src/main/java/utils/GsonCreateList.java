package utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.TestNG;
import java.util.ArrayList;

/** GsonCreateList
 * Description: Creates a list of type T from JSON.
 * @author Joshua Pressley
 * @version 1.0 */
public class GsonCreateList {
    /** Creates List of type TestNG */
    public static ArrayList<TestNG> createListFromJSON(String json)
    { return new Gson().fromJson(json,new TypeToken<ArrayList<TestNG>>() {}.getType()); }
}//end class GsonCreateList
