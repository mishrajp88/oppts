/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.multithreaded;

import oppts.communication.AbstractTaskInitMessage;

/**
 *
 * @author jmishra
 */
public class MultiThreadedTaskInitMessage extends AbstractTaskInitMessage {
    
    private long n;
    private int numberOfThreads;

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }
    
    
}
