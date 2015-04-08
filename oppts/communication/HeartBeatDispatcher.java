/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication;

import oppts.communication.util.NodeMessageQueueOutgoing;
import oppts.communication.util.TCPConnectionSetup;

/**
 *
 * @author jmishra
 */
public class HeartBeatDispatcher implements Runnable {

    @Override
    public void run() {
        while (true) {
            AbstractMessage message = NodeMessageQueueOutgoing.getMessage();
            if (message != null) {
                if (message instanceof HeartBeatMessage) {
                    TCPConnectionSetup.sendMessage(message, ((HeartBeatMessage)message).getDestinationHostName(), ((HeartBeatMessage)message).getDestinationPort());
                } else {
                    NodeMessageQueueOutgoing.insertMessage(message);
                }
            }
        }
    }
    
}