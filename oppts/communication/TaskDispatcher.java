package oppts.communication;

import oppts.OPPTSNodeManagerContext;
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
            AbstractMessage message = OPPTSNodeManagerContext.getInstance().getOutgoingQueue().getMessage();
            TCPConnectionSetup.sendMessage(message, ((AbstractTaskInitMessage)message).getDestinationHostName(), ((AbstractTaskInitMessage)message).getDestinationPort());
        }
    }
    
}
