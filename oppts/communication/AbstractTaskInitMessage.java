package oppts.communication;

/**
 *
 * @author jmishra
 */
public class AbstractTaskInitMessage extends AbstractMessage {
    private String destinationHostName;
    private int destinationPort;

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
    
    
}
