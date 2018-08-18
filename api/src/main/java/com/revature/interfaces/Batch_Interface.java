package com.revature.interfaces;
/** Interface methods for Batch_DAO
 * @author Joshua Pressley
 * @version 1.0 */
public interface Batch_Interface {
    /** Create a batch */
    int createBatch(int passFail);
    /** Get most recent batch */
    int getMostRecentBatch();
    /** gets all batches */
    String getAllBatches();
    /** Get a specific batch*/
    String getBatch(int ID);
}//end interface Batch_Interface
