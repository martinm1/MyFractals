/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myfractals;

/**
 *
 * @author martin
 */
public class ComplexNumber {
    private double re;
    private double im;
    
 
    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }   
    
    public void iterate(int num){
        double newRe;
        double newIm;
        for(int i=0; i<num-1; i++){
            newRe = re*re - im*im;
            newIm = 2*re*im;
            re = newRe;
            im = newIm;
        }
    }
    
    
}
