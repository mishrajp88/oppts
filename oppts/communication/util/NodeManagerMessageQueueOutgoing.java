package oppts.communication.util;

import java.util.concurrent.ConcurrentLinkedQueue;
import oppts.communication.AbstractMessage;

/**
 *
 * @author jmishra
 */
public class NodeManagerMessageQueueOutgoing {
    private static ConcurrentLinkedQueue<AbstractMessage> queue = new ConcurrentLinkedQueue<>();
    
    public void insertMessage(AbstractMessage message) {
        queue.add(message);
    }
    
    public AbstractMessage getMessage() {
        return queue.poll();            
    }
}
