/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication;

import java.util.logging.Level;
import java.util.logging.Logger;
import oppts.communication.util.NodeMessageQueueOutgoing;
import oppts.communication.util.TCPConnectionSetup;

/**
 *
 * @author jmishra
 */
public class HeartBeatDispatcher implements Runnable {

    private long counter;
    
    @Override
    public void run() {
        while (true) {
            HeartBeatMessage message = new HeartBeatMessage(counter);
            TCPConnectionSetup.sendMessage(message, ((HeartBeatMessage)message).getDestinationHostName(), ((HeartBeatMessage)message).getDestinationPort());
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}