package com.revature.interfaces;
import com.revature.models.Batch;
import java.util.ArrayList;

/** Interface methods for Batch_DAO
 * @author Joshua Pressley
 * @version 1.0 */
public interface Batch_DAO_Interface {
    /** Create a batch */
    void createBatch(Batch batch1);
    /** Get most recent batch */
    int getMostRecent();
    /** Gets all batches */
    ArrayList<Batch> getAllBatches();
    /** get specific batch */
    Batch getBatch(int ID);
}//end interface Batch_DAO_Interface
