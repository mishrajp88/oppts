package oppts.task;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmishra
 */
public class MultiThreadedTask extends AbstractTask implements Runnable {

    private int numberOfThreads;
    private long n;
    
    @Override
    public void run() {        
        MultiThreadedWorker[] runnables = new MultiThreadedWorker[numberOfThreads];
        for (int i = 0; i < numberOfThreads; ++i) {
            runnables[i] = new MultiThreadedWorker(i);
            runnables[i].setN(n);
        }

        List<Thread> threads = new ArrayList<Thread>();       

        for (MultiThreadedWorker runnable : runnables) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {                
            }
        }
        
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }
    
    
    
    
    
}
