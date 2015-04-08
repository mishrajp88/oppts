package oppts.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import oppts.OPPTSNodeContext;
import oppts.communication.util.NodeManagerMessageQueueIncoming;
import oppts.communication.util.NodeMessageQueueIncoming;

/**
 *
 * @author jmishra
 */
public class NodeMessageReceiver implements Runnable {
        
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(OPPTSNodeContext.getInstance().getSelfPort());
        } catch (IOException ex) {            
        }
        while (true) {
            try {                
                Socket socket = serverSocket.accept();
                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
                AbstractMessage message = (AbstractMessage) inStream.readObject();
                NodeMessageQueueIncoming.insertMessage(message);
                socket.close();
            } catch (SocketException se) {

            } catch (IOException e) {

            } catch (ClassNotFoundException cn) {

            }
        }
    } 
}
