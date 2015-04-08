package oppts;

/**
 *
 * @author jyotiprakash
 */
public class OPPTSNodeContext {
    
    private static OPPTSNodeContext self = null;
    
    private OPPTSNodeContext() {
        
    }
    
    public static OPPTSNodeContext getInstance() {
        if (self == null)
            self = new OPPTSNodeContext();
        return self;
    }
    
    private int nodeManagerPort;
    private String nodeManagerHostName;
    private int selfPort;    

    public int getNodeManagerPort() {
        return nodeManagerPort;
    }

    public void setNodeManagerPort(int nodeManagerPort) {
        this.nodeManagerPort = nodeManagerPort;
    }

    public String getNodeManagerHostName() {
        return nodeManagerHostName;
    }

    public void setNodeManagerHostName(String nodeManagerHostName) {
        this.nodeManagerHostName = nodeManagerHostName;
    }

    public int getSelfPort() {
        return selfPort;
    }

    public void setSelfPort(int selfPort) {
        this.selfPort = selfPort;
    }
    
    
    
}
