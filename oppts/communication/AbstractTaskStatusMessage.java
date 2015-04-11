package oppts.communication;

/**
 *
 * @author jmishra
 */
public class AbstractTaskStatusMessage extends AbstractMessage {
    
    private String destinationHostName;
    private int destinationPort;
    private float percentageOver;
    private boolean over;

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

    public float getPercentageOver() {
        return percentageOver;
    }

    public void setPercentageOver(float percentageOver) {
        this.percentageOver = percentageOver;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }
    
    
    
    
    
    
}
