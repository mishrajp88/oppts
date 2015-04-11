/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.memory;

import java.util.HashMap;

import oppts.communication.AbstractTaskStatusMessage;

/**
 *
 * @author jmishra
 */
public class MemoryTaskStatusMessage extends AbstractTaskStatusMessage {
    private long sizeTotal;
    private long sizeRead;
    private HashMap<String, Integer> count;
    private String message;
    
    public String getMessage()
    {
    	return message;
    }
    
    public void setMessage(String message)
    {
    	this.message = message;
    }
   
    public void setCount(HashMap<String, Integer> count)
    {
    	count = new HashMap<String, Integer>();
    	this.count = count;
    }
    
    public HashMap<String, Integer> getCount()
    {
    	return count;
    }
    
    public void setSizeTotal(long l)
    {
    	this.sizeTotal = l;
    }
    
    public long getSizeTotal()
    {
    	return sizeTotal;
    }
    
    public void setSizeRead(long length)
    {
    	this.sizeRead = length;
    }
    
    public long getSizeRead()
    {
    	return sizeRead;
    }
}
