package oppts.communication;

/**
 *
 * @author jmishra
 */
public class AbstractTaskInitMessage extends AbstractMessage {
    private String destinationHostName;
    private int destinationPort;
    private long taskId;
    private boolean startImmediately;
    private long startAfterTask;

    public String getDestinationHostName() {
        return destinationHostName;
    }

    public void setDestinationHostName(String destinationHostName) {
        this.destinationHostName = destinationHostName;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(int destinationPort) {
        this.destinationPort = destinationPort;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public boolean isStartImmediately() {
        return startImmediately;
    }

    public void setStartImmediately(boolean startImmediately) {
        this.startImmediately = startImmediately;
    }

    public long getStartAfterTask() {
        return startAfterTask;
    }

    public void setStartAfterTask(long startAfterTask) {
        this.startAfterTask = startAfterTask;
    }
    
    
    
    
}
