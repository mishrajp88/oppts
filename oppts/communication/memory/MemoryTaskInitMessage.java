/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.memory;

import oppts.communication.AbstractTaskInitMessage;

/**
 *
 * @author jmishra
 */
public class MemoryTaskInitMessage extends AbstractTaskInitMessage {
    private String inputFile;
    private String searchTerm;
    private int bufferSize;
    
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
