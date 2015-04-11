/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.task;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import oppts.OPPTSNodeContext;
import oppts.communication.memory.MemoryTaskStatusMessage;

/**
 *
 * @author jmishra
 */
public class MemoryTask extends AbstractTask implements Runnable
{  
	private String inputFile, searchTerm;
	private int bufferSize;
	
	private static void searchWord(String inputFile, String searchTerm, int bufferSize)
	{
		BufferedReader br = null;
		long length = 0;
		try
		{
			File file = new File(inputFile);
			length = file.length();
        }
		catch (Exception ex)  
		{
			MemoryTaskStatusMessage status = new MemoryTaskStatusMessage();
	        status.setSizeRead(0);
	        status.setSizeTotal(length);
	        status.setPercentageOver(0);
	        status.setOver(true);
	        status.setCount(null);
	        status.setMessage(ex.getMessage());
	        status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
	        status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
	        OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
		}

		HashMap<String, Integer> map = new HashMap<>();
		try 
		{
			String sCurrentLine;
			br = new BufferedReader(new FileReader(inputFile), bufferSize);
			while ((sCurrentLine = br.readLine()) != null) 
			{
				String words[] = sCurrentLine.split(" ");
				for(int i = 0; i < words.length; i++)
				{
					if(words[i].equals(searchTerm))
					{
						if (map.containsKey(words[i])) 
						{
							map.put(words[i], map.get(words[i]) + 1);
						} 
						else 
						{
							map.put(words[i], 1);
						}
					}
				}
			}			
			
			MemoryTaskStatusMessage status = new MemoryTaskStatusMessage();
	        status.setSizeRead(length);
	        status.setSizeTotal(length);
	        status.setPercentageOver(100);
	        status.setOver(true);
	        status.setCount(map);
	        status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
	        status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
	        OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
		}
		catch (Exception ex) 
		{
			MemoryTaskStatusMessage status = new MemoryTaskStatusMessage();
	        status.setSizeRead(0);
	        status.setSizeTotal(length);
	        status.setPercentageOver(0);
	        status.setOver(true);
	        status.setCount(null);
	        status.setMessage(ex.getMessage());
	        status.setDestinationHostName(OPPTSNodeContext.getInstance().getNodeManagerHostName());
	        status.setDestinationPort(OPPTSNodeContext.getInstance().getNodeManagerPort());
	        OPPTSNodeContext.getInstance().getOutgoingQueue().insertMessage(status);
		} 
		finally 
		{
			try 
			{
				if (br != null)
				{
					br.close();
				}
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void run() 
	{
		searchWord(inputFile,searchTerm,bufferSize);
    }
	
	public String getInputFile()
    {
    	return inputFile;
    }
    
    public void setInputFile(String inputFile)
    {
    	this.inputFile = inputFile;
    }
    
    public String getSearchTerm()
    {
    	return searchTerm;
    }
    
    public void setSearchTerm(String searchTerm)
    {
    	this.searchTerm = searchTerm;
    }
    
    public void setBufferSize(int bufferSize)
    {
    	this.bufferSize = bufferSize;
    }
    
    public int getBufferSize()
    {
    	return bufferSize;
    }
}


