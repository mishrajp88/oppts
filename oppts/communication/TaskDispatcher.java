package oppts.communication;

import oppts.communication.util.NodeManagerMessageQueueOutgoing;
import oppts.communication.util.TCPConnectionSetup;

/**
 *
 * @author jmishra
 */
public class TaskDispatcher implements Runnable {

    @Override
    public void run() {
        while (true) {
            AbstractMessage message = NodeManagerMessageQueueOutgoing.getMessage();
            if (message != null) {
                if (message instanceof AbstractTaskInitMessage) {
                    TCPConnectionSetup.sendMessage(message, ((AbstractTaskInitMessage)message).getDestinationHostName(), ((AbstractTaskInitMessage)message).getDestinationPort());
                } else {
                    NodeManagerMessageQueueOutgoing.insertMessage(message);
                }
            }
        }
    }
    
}
