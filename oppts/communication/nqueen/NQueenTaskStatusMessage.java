/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.nqueen;

import oppts.communication.AbstractTaskStatusMessage;

/**
 *
 * @author jmishra
 */
public class NQueenTaskStatusMessage extends AbstractTaskStatusMessage {
    
    private int numberOfColumnsHandled;

    public int getNumberOfColumnsHandled() {
        return numberOfColumnsHandled;
    }

    public void setNumberOfColumnsHandled(int numberOfColumnsHandled) {
        this.numberOfColumnsHandled = numberOfColumnsHandled;
    }
        
}
