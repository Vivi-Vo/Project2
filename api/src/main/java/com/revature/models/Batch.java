package com.revature.models;
import javax.persistence.*;
import java.util.Objects;

/** Batch
 * Description: Model for the Batch Table
 * @author Joshua Pressley
 * @version 1.0 */
@Entity
@NamedQueries({ @NamedQuery(name="RetrieveAllBatch", query="from com.revature.models.Batch") })
@Table(name = "BATCH")
public class Batch
{
    /** Test Group ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_seq")
    @SequenceGenerator(initialValue = 1, sequenceName = "bid_seq", allocationSize = 1, name = "bid_seq")
    @Column(name = "B_ID", nullable = false, precision = 10)
    private int batchID;

    /** Result of the test group */
    @Column(name = "STATUS", nullable = false, precision = 10)
    private int passFail;

    //---------------------------------------

    /** Constructor- No Arguments */
    public Batch() { super(); }

    /** All Arguments Constructor */
    public Batch(int batchID, int passFail) {
        super();
        this.batchID = batchID;
        this.passFail = passFail;
    }//end constructor

    /** PassFail Constructor */
    public Batch(int passFail) {
        super();
        this.passFail = passFail;
    }//end constructor

    public int getBatchID() { return batchID; }
    public void setBatchID(int batchID) { this.batchID = batchID; }
    public int getPassFail() { return passFail; }
    public void setPassFail(int passFail) { this.passFail = passFail; }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Batch)) { return false; }
        Batch batch = (Batch) o;
        return batchID == batch.batchID && passFail == batch.passFail;
    }//end equals()

    @Override
    public int hashCode() { return Objects.hash(batchID, passFail); }

    @Override
    public String toString()
    { return "Batch {" + " batchID='" + getBatchID() + "'" + ", passFail='" + getPassFail() + "'}"; }
}//end class Batch
