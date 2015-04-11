package oppts;

import oppts.communication.util.NodeMessageQueueIncoming;
import oppts.communication.util.NodeMessageQueueOutgoing;

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
    private NodeMessageQueueIncoming incomingQueue;
    private NodeMessageQueueOutgoing outgoingQueue;

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

    public NodeMessageQueueIncoming getIncomingQueue() {
        return incomingQueue;
    }

    public void setIncomingQueue(NodeMessageQueueIncoming incomingQueue) {
        this.incomingQueue = incomingQueue;
    }

    public NodeMessageQueueOutgoing getOutgoingQueue() {
        return outgoingQueue;
    }

    public void setOutgoingQueue(NodeMessageQueueOutgoing outgoingQueue) {
        this.outgoingQueue = outgoingQueue;
    }
    
    
    
    
    
}
