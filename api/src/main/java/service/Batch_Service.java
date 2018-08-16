package service;
import daoimp.Batch_DAO;
import interfaces.Batch_Interface;
import models.Batch;
import utils.GsonCreateString;

/** Batch Service Class
 * @author Joshua Pressley
 * @version 1.0 */
public class Batch_Service implements Batch_Interface
{
    /** Creates a batch and returns its batchID.
     * @param passFail boolean representing test group success
     * @return integer representing batchID to use in records*/
    @Override
    public int createBatch(int passFail) {
        Batch newBatch = new Batch(passFail);
        new Batch_DAO().createBatch(newBatch);
        return newBatch.getBatchID();
    }//end createBatch()

    /** Get most recent batch */
    @Override
    public int getMostRecentBatch()
    { return new Batch_DAO().getMostRecent();  }

    /** Gets all batches */
    @Override
    public String getAllBatches()
    { return GsonCreateString.createStringBatch(new Batch_DAO().getAllBatches()); }

    /** Get a specific batch */
    @Override
    public String getBatch(int ID)
    { return GsonCreateString.createBatch(new Batch_DAO().getBatch(ID)); }

    /** NOT IMPLEMENTED */
    @Override
    public void updateBatch(Batch batch) { System.out.println("Not Implemented"); }

    /** NOT IMPLEMENTED */
    @Override
    public void deleteBatch(Batch batch) { System.out.println("Not Implemented"); }
}//end class Batch_Service
