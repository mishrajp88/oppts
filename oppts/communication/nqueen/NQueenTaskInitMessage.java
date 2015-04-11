/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.nqueen;

import oppts.communication.AbstractTaskInitMessage;

/**
 *
 * @author jmishra
 */
public class NQueenTaskInitMessage extends AbstractTaskInitMessage {
    
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    
}
