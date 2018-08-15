package service;

/**
 * Description:
 * @author Joshua Pressley
 * @version 1.0 */
public interface TestNG_Inf {
    void loadRecords(String json);
    String getRecordsCurrent();
    String getAllRecords();
    void updateRecords(String json);
    void deleteRecords(String json);
}//end interface TestNG_Inf
