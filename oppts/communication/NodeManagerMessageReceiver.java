package oppts.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oppts.OPPTSNodeManagerContext;
import oppts.communication.util.NodeManagerMessageQueueIncoming;

/**
 *
 * @author jmishra
 */
public class NodeManagerMessageReceiver implements Runnable {

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(OPPTSNodeManagerContext.getInstance().getNodeManagerPort());
        } catch (IOException ex) {            
        }
        while (true) {
            try {                
                Socket socket = serverSocket.accept();
                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
                AbstractMessage message = (AbstractMessage) inStream.readObject();
                OPPTSNodeManagerContext.getInstance().getIncomingQueue().insertMessage(message);
                socket.close();
            } catch (SocketException se) {

            } catch (IOException e) {

            } catch (ClassNotFoundException cn) {

            }
        }
    }

}
