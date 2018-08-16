package utils;
import com.google.gson.Gson;
import models.Batch;
import models.TestNG;
import java.util.ArrayList;

/** GsonCreateString
 * Description: Creates JSON string from list of objects
 * @author Joshua Pressley
 * @version 1.0 */
public class GsonCreateString
{
    /** Creates JSON string of TestNG records. */
    public static String createStringTestNG(ArrayList<TestNG> records) {
        if (records != null) return new Gson().toJson(records);
        return null;
    }//end createStringTestNG()

    /** Creates JSON string of TestNG records. */
    public static String createStringBatch(ArrayList<Batch> records) {
        if (records != null) return new Gson().toJson(records);
        return null;
    }//end createStringBatch()
}//end class GsonCreateString
