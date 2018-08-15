package daoimp;
import interfaces.Batch_DAO_Interface;
import models.Batch;

/** Batch_DAO
 * Methods for Batch Operations in the Database
 * @author Joshua Pressley
 * @version 1.0 */
public class Batch_DAO implements Batch_DAO_Interface
{
    /** Create a batch */
    public void createBatch(Batch batch1)
    { new CommonDAO().createRecord(batch1); }
}//end class Batch_DAO
