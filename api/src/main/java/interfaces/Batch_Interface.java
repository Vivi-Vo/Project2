package interfaces;
import models.Batch;

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
    /** NOT IMPLEMENTED*/
    void updateBatch(Batch batch);
    /** NOT IMPLEMENTED*/
    void deleteBatch(Batch batch);
}//end interface Batch_Interface
