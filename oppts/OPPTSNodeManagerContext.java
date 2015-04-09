package oppts;

/**
 *
 * @author jyotiprakash
 */
public class OPPTSNodeManagerContext {
    private static OPPTSNodeManagerContext self = null;
    
    private OPPTSNodeManagerContext() {
        
    }
    
    public static OPPTSNodeManagerContext getInstance() {
        if (self == null)
            self = new OPPTSNodeManagerContext();
        return self;
    }
    
    private int nodeManagerPort;
    private String nodeManagerHostName;

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
    
    
}
