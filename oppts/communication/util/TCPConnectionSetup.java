package oppts.communication.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import oppts.communication.AbstractMessage;

/**
 *
 * @author jmishra
 */
public class TCPConnectionSetup {

    public static void sendMessage(AbstractMessage message, String host, int port) {
        Socket socket = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        boolean isConnected = false;
        while (!isConnected) {
            try {
                socket = new Socket(host, port);
                isConnected = true;
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(message);
            } catch (SocketException se) {

            } catch (IOException e) {

            }

        }
    }

}
