/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication;

/**
 *
 * @author jmishra
 */
public class HeartBeatMessage extends AbstractMessage {
    
    private String destinationHostName;
    private int destinationPort;

    public String getDestinationHostName() {
        return destinationHostName;
    }

    public void setDestinationHostName(String destinationHostName) {
        this.destinationHostName = destinationHostName;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(int destinationPort) {
        this.destinationPort = destinationPort;
    }
}
