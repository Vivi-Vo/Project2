package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ________ Class
 * Description:
 *
 * @author Joshua Pressley
 * @version 1.0
 */
@Entity
@Table(name = "Batch")
public class Batch {
    @Id

    private int batchID;

    private int passFail;

    public Batch() { super(); }

    public Batch(int batchID, int passFail) {
        super();
        this.batchID = batchID;
        this.passFail = passFail;
    }
}//end class Batch
