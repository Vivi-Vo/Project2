package com.revature.service;
import com.revature.daoimp.Batch_DAO;
import com.revature.interfaces.Batch_Interface;
import com.revature.models.Batch;
import com.revature.utils.GsonCreateString;

/** Batch Service Class
 * @author Joshua Pressley
 * @version 1.0 */
public class Batch_Service implements Batch_Interface
{
    /** Creates a batch and returns its batchID.
     * @param passFail boolean representing test group success
     * @return integer representing batchID to use in records*/
    @Override public int createBatch(int passFail) {
        Batch newBatch = new Batch(passFail);
        new Batch_DAO().createBatch(newBatch);
        return newBatch.getBatchID();
    }//end createBatch()

    /** Get most recent batch */
    @Override public int getMostRecentBatch()
    { return new Batch_DAO().getMostRecent();  }

    /** Gets all batches */
    @Override public String getAllBatches()
    { return GsonCreateString.createJson(new Batch_DAO().getAllBatches()); }

    /** Get a specific batch */
    @Override public String getBatch(int ID)
    { return GsonCreateString.createJson(new Batch_DAO().getBatch(ID)); }
}//end class Batch_Service
