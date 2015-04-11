/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.multithreaded;

import oppts.communication.AbstractTaskStatusMessage;

/**
 *
 * @author jmishra
 */
public class MultiThreadedTaskStatusMessage extends AbstractTaskStatusMessage {
    
    private int threadNumber;
    private long nHandled;

    public int getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public long getnHandled() {
        return nHandled;
    }

    public void setnHandled(long nHandled) {
        this.nHandled = nHandled;
    }
    
    
}
