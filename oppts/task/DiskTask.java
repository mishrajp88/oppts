/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.task;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import oppts.OPPTSNodeContext;
import oppts.communication.disk.DiskTaskStatusMessage;

/**
 *
 * @author ygovind
 */
public class DiskTask extends AbstractTask implements Runnable {
    
    static int N; // size of the file in disk
    static int M; // max items the memory buffer can hold
    
    @Override
    public void run()
    {
        String fileName = generateInput(N);
	externalSort(fileName);
    }
    
    public static void externalSort(String fileName){
	String tfile = "temp-file-";
	int[] buffer = new int[M < N ? M : N];
	  
	try
	{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int slices = (int) Math.ceil((double) N/M);
	   
            int i = 0,j = 0;
            //Iterate through the elements in the file
            for (i = 0; i < slices; i++)
            {
            // Read M-element chunk at a time from the file
                for (j = 0; j < (M < N ? M : N); j++)
                {
                    String t = br.readLine();
                    if (t != null)
                      buffer[j] = Integer.parseInt(t);
                    else
                        break;
                }
                // Sort M elements
                Arrays.sort(buffer);
                // Write the sorted numbers to temp file
        	FileWriter fw = new FileWriter(tfile + Integer.toString(i) + ".txt");
                PrintWriter pw = new PrintWriter(fw);
                for (int k = 0; k < j; k++)
                    pw.println(buffer[k]);
	    
                pw.close();
                fw.close();
            }
	   
            br.close();
            fr.close();
	   
	   // Now open each file and merge them, then write back to disk
            int[] topNums = new int[slices];
            BufferedReader[] brs = new BufferedReader[slices];
	   
            for (i = 0; i < slices; i++)
            {
                brs[i] = new BufferedReader(new FileReader(tfile + Integer.toString(i) + ".txt"));
                String t = brs[i].readLine();
                if (t != null)
                    topNums[i] = Integer.parseInt(t);
                else
                    topNums[i] = Integer.MAX_VALUE;
            }
	   
            FileWriter fw = new FileWriter("/Users/spidy/Documents/osproj/external-sort.txt");
            PrintWriter pw = new PrintWriter(fw);
	   
            for (i = 0; i < N; i++)
            {
                int min = topNums[0];
                int minFile = 0;
	        DiskTaskStatusMessage status = new DiskTaskStatusMessage();
                status.sizeOfDisk(i);
                status.setPercentageOver(((i + 1) / (float) N) * 100);
                status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
                status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
                OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
                for (j = 0; j < slices; j++)
                {
                    if (min > topNums[j])
                    {
                        min = topNums[j];
                        minFile = j;
                    }
                }
	    
                pw.println(min);
                String t = brs[minFile].readLine();
                if (t != null)
                    topNums[minFile] = Integer.parseInt(t);
                else
                    topNums[minFile] = Integer.MAX_VALUE;
            }
            
            DiskTaskStatusMessage status = new DiskTaskStatusMessage();
            status.sizeOfDisk(N);
            status.setPercentageOver(100);
            status.setOver(true);
            status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
            status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
            OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
            
            
            for (i = 0; i < slices; i++)
                brs[i].close();
	   
            pw.close();
            fw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }   catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
    public static String generateInput(int n)
    {
        String fileName = "/Users/spidy/Documents/osproj/external-sort.txt";
	Random rand = new Random();
	  
	try
	{
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
	   
            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(101));
	   
            pw.close();
	}
	  
	catch (IOException e)
	{
	   e.printStackTrace();
	}
	  
	return fileName;
    }
    
    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }
    
    public int getM() {
        return M;
    }

    public void setM(int M) {
        this.M = M;
    }
}
