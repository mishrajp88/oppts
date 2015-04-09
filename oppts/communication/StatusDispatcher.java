package oppts.communication;

import oppts.communication.util.NodeMessageQueueOutgoing;
import oppts.communication.util.TCPConnectionSetup;

/**
 *
 * @author jmishra
 */
public class StatusDispatcher implements Runnable {

    @Override
    public void run() {
        while (true) {
            AbstractMessage message = NodeMessageQueueOutgoing.getMessage();
            TCPConnectionSetup.sendMessage(message, ((AbstractTaskStatusMessage)message).getDestinationHostName(), ((AbstractTaskStatusMessage)message).getDestinationPort());
        }
    }
    
}