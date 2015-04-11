/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.disk;

import oppts.communication.AbstractTaskStatusMessage;

/**
 *
 * @author jmishra
 */
public class DiskTaskStatusMessage extends AbstractTaskStatusMessage {

    private int sizeOfDisk;
    private int memoryBuffer;

    public int sizeOfDisk() {
        return sizeOfDisk;
    }

    public void sizeOfDisk(int sizeOfDisk) {
        this.sizeOfDisk = sizeOfDisk;
    }
    
    public int memoryBuffer() {
        return memoryBuffer;
    }

    public void memoryBuffer(int memoryBuffer) {
        this.memoryBuffer = memoryBuffer;
    }
    
}
