package oppts.communication.util;

import java.util.concurrent.ConcurrentLinkedQueue;
import oppts.communication.AbstractMessage;

/**
 *
 * @author jmishra
 */
public class NodeMessageQueueIncoming {
    private static ConcurrentLinkedQueue<AbstractMessage> queue = new ConcurrentLinkedQueue<>();
    
    public static void insertMessage(AbstractMessage message) {
        queue.add(message);
    }
    
    public static AbstractMessage getMessage() {
        return queue.poll();            
    }
}
