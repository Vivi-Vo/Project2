package models;
import javax.persistence.*;
import java.util.Objects;

/** Hibernate Mapping Class for TestNG records.
 * @author Joshua Pressley
 * @version 1.0 */
@Entity
@NamedQueries({ @NamedQuery(name="RetrieveAllTestNG", query="from models.TestNG") })
@Table(name = "TESTNG")
public class TestNG
{
    /** Auto-Generated record id. */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rid_seq")
    @SequenceGenerator(initialValue = 1, sequenceName = "rid_seq", allocationSize = 1, name = "rid_seq")
    @Column(name = "RECORD_ID", nullable = false, precision = 10)
    private int recordID;

    /** The Testing Batch */
    @Column(name = "BATCH_ID", nullable = false, precision = 10)
    private int batchID;

    /** Who initiated the test. */
    @Column(name = "INIT_BY", length = 40, nullable = false)
    private String initiatedBy;

    /** The Status result of the test. */
    @Column(name = "TEST_STATUS", length = 30, nullable = false)
    private String status;

    /** The method signature of the test. */
    @Column(name = "SIGNATURE", length = 100, nullable = false)
    private String signature;

    /** The name of the test. */
    @Column(name = "TEST_NAME", nullable = false, length = 100)
    private String name;

    /** Duration in milliseconds that the test ran. */
    @Column(name = "DURATION", precision = 10)
    private int duration_ms;

    /** Start Time of the test*/
    @Column(name = "START_TIME", nullable = false)
    private String startTime;

    /** End time of the Test*/
    @Column(name = "FINISH_TIME", nullable = false)
    private String finishTime;

    /** The exception class for a failure. */
    @Column(name = "EX_CLASS", length = 100)
    private String exceptionClass;

    /** The message for the failure/exception. */
    @Column(name = "EX_MESASGE", length = 200)
    private String exceptionMessage;

    /** The stack trace of the failure. */
    @Column(name = "EX_STACK", length = 900)
    private String stackTrace;

    //----------------------------------------------
    //Constructor
    //----------------------------------------------

    /** Constructor - No Fields*/
    public TestNG() { super(); }

    /** Constructor - All Fields Except recordID*/
    public TestNG(int batchID, String initiatedBy, String status, String signature, String name,
                  int duration_ms, String startTime, String finishTime, String exceptionClass,
                  String exceptionMessage, String stackTrace) {
        super();
        this.batchID = batchID;
        this.initiatedBy = initiatedBy;
        this.status = status;
        this.signature = signature;
        this.name = name;
        this.duration_ms = duration_ms;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.exceptionClass = exceptionClass;
        this.exceptionMessage = exceptionMessage;
        this.stackTrace = stackTrace;
    }//end constructor

    /** Constructor - All Fields */
    public TestNG(int recordID, int batchID, String initiatedBy, String status, String signature, String name,
                  int duration_ms, String startTime, String finishTime, String exceptionClass,
                  String exceptionMessage, String stackTrace) {
        super();
        this.recordID = recordID;
        this.batchID = batchID;
        this.initiatedBy = initiatedBy;
        this.status = status;
        this.signature = signature;
        this.name = name;
        this.duration_ms = duration_ms;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.exceptionClass = exceptionClass;
        this.exceptionMessage = exceptionMessage;
        this.stackTrace = stackTrace;
    }//end constructor

    /** Constructor - All Fields Except recordID*/
    public TestNG(int batchID, String initiatedBy, String status, String signature, String name,
                  int duration_ms, String startTime, String finishTime) {
        super();
        this.batchID = batchID;
        this.initiatedBy = initiatedBy;
        this.status = status;
        this.signature = signature;
        this.name = name;
        this.duration_ms = duration_ms;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }//end constructor

    //----------------------------------------------
    //Getter and Setter
    //----------------------------------------------

    public int getRecordID() { return recordID; }
    public void setRecordID(int recordID) { this.recordID = recordID; }

    public int getBatchID() { return batchID; }
    public void setBatchID(int batchID) { this.batchID = batchID; }

    public String getInitiatedBy() { return initiatedBy; }
    public void setInitiatedBy(String initiatedBy) { this.initiatedBy = initiatedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDuration_ms() { return duration_ms; }
    public void setDuration_ms(int duration_ms) { this.duration_ms = duration_ms; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getFinishTime() { return finishTime; }
    public void setFinishTime(String finishTime) { this.finishTime = finishTime; }

    public String getExceptionClass() { return exceptionClass; }
    public void setExceptionClass(String exceptionClass) { this.exceptionClass = exceptionClass; }

    public String getExceptionMessage() { return exceptionMessage; }
    public void setExceptionMessage(String exceptionMessage) { this.exceptionMessage = exceptionMessage; }

    public String getStackTrace() { return stackTrace; }
    public void setStackTrace(String stackTrace) { this.stackTrace = stackTrace; }

    //----------------------------------------------
    // Other Generated Methpds
    //----------------------------------------------

    @Override
    public String toString() {
        return "TestNG{" +
                "recordID=" + recordID +
                ", batchID=" + batchID +
                ", initiatedBy='" + initiatedBy + '\'' +
                ", status='" + status + '\'' +
                ", signature='" + signature + '\'' +
                ", name='" + name + '\'' +
                ", duration_ms=" + duration_ms +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", exceptionClass='" + exceptionClass + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                '}';
    }//end toString()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestNG)) return false;
        TestNG testNG = (TestNG) o;
        return getRecordID() == testNG.getRecordID() &&
                getBatchID() == testNG.getBatchID() &&
                getDuration_ms() == testNG.getDuration_ms() &&
                Objects.equals(getInitiatedBy(), testNG.getInitiatedBy()) &&
                Objects.equals(getStatus(), testNG.getStatus()) &&
                Objects.equals(getSignature(), testNG.getSignature()) &&
                Objects.equals(getName(), testNG.getName()) &&
                Objects.equals(getStartTime(), testNG.getStartTime()) &&
                Objects.equals(getFinishTime(), testNG.getFinishTime()) &&
                Objects.equals(getExceptionClass(), testNG.getExceptionClass()) &&
                Objects.equals(getExceptionMessage(), testNG.getExceptionMessage()) &&
                Objects.equals(getStackTrace(), testNG.getStackTrace());
    }//end equals()

    @Override
    public int hashCode() {
        return Objects.hash(getRecordID(), getBatchID(), getInitiatedBy(), getStatus(),
                getSignature(), getName(), getDuration_ms(), getStartTime(), getFinishTime(), getExceptionClass(), getExceptionMessage(), getStackTrace());
    }//end hashCode()
}//end class TestNG
