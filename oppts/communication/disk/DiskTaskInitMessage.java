/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppts.communication.disk;

import oppts.communication.AbstractTaskInitMessage;

/**
 *
 * @author jmishra
 */
public class DiskTaskInitMessage extends AbstractTaskInitMessage {

    private int n;
    private int m;
    
    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
    
    public void setN(int n) {
        this.n = n;
    }
    
    public void setM(int m) {
        this.m = m;
    }
}
