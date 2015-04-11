/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.task;

import oppts.OPPTSNodeContext;
import oppts.communication.multithreaded.MultiThreadedTaskStatusMessage;

/**
 *
 * @author jyotiprakash
 */
public class MultiThreadedWorker implements Runnable {

    private long n;
    private double sum = 0;
    private int threadNumber;
    
    public MultiThreadedWorker(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() {
        float percentOverNow = 10;
        for (long i = 0; i < n; ++i) {
            if (((float) i / n) > percentOverNow) {
                MultiThreadedTaskStatusMessage status = new MultiThreadedTaskStatusMessage();
                status.setPercentageOver(((float) i / n) * 100);
                status.setnHandled(i);
                status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
                status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
                status.setThreadNumber(threadNumber);
                OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
                percentOverNow += 10;
            }
            sum += Math.sqrt(Math.abs(Math.sin(i)) + Math.abs(Math.cos(i)));
        }
        MultiThreadedTaskStatusMessage status = new MultiThreadedTaskStatusMessage();
        status.setPercentageOver(100);
        status.setnHandled(n);
        status.setOver(true);
        status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
        status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
        status.setThreadNumber(threadNumber);
        OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
    }
    
    public long getN() {
        return n;
    }
    
    public void setN(long n) {
        this.n = n;
    }
    
    public int getThreadNumber() {
        return threadNumber;
    }
    
    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    
}
