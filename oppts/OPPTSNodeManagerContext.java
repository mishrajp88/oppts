package oppts;

import oppts.communication.util.NodeManagerMessageQueueIncoming;
import oppts.communication.util.NodeManagerMessageQueueOutgoing;


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
    private NodeManagerMessageQueueIncoming incomingQueue;
    private NodeManagerMessageQueueOutgoing outgoingQueue;

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

    public NodeManagerMessageQueueIncoming getIncomingQueue() {
        return incomingQueue;
    }

    public void setIncomingQueue(NodeManagerMessageQueueIncoming incomingQueue) {
        this.incomingQueue = incomingQueue;
    }

    public NodeManagerMessageQueueOutgoing getOutgoingQueue() {
        return outgoingQueue;
    }

    public void setOutgoingQueue(NodeManagerMessageQueueOutgoing outgoingQueue) {
        this.outgoingQueue = outgoingQueue;
    }
    
    
    
    
}
