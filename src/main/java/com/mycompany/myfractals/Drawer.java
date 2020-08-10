/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myfractals;

import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

/**
 *
 * @author martin
 */
public class Drawer {
    /**
    * Draws fractal.
    * @return fractal 
    */
    public ImagePlus drawMandelbrotSet(){
        int w = 1920;
        int h = 1080;
        
        int coef = 15;
        
        ImageProcessor image = new ColorProcessor(w, h);

        image.setValue(255); //set image default value
        image.fill(); //fill image with default value
        
        ComplexNumber number1 = new ComplexNumber();
        ComplexNumber number2 = new ComplexNumber();
        
  
        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            {
                number1.setRe((x-1100)/(double) 400);
                number1.setIm((y-500)/(double) 400);
                
                number2.setRe(0);
                number2.setIm(0);
                
                int[] color = {0, 0, 0};
                
                for(int k=0;k<200;k++){
                    number2.iterate(2);
                    number2.setRe(round(number2.getRe() + number1.getRe(), 3));
                    number2.setIm(round(number2.getIm() + number1.getIm(), 3));
                    
                    if(
                    (number2.getRe()*number2.getRe()
                    + number2.getIm()*number2.getIm()) > 4
                    )
                    {   
                        if(k<10){
                            image.putPixel(x, y, color);
                        }
                        else{
                            color[2] = coef*k;
                            image.putPixel(x, y, color);
                        }
                        break;
                    }
                    color[2] = coef*k;
                    image.putPixel(x, y, color);
                }
                
            }
        }
        ImagePlus img2 = new ImagePlus("fractal image", image);
        
        return img2;
        
    }
    
    /**
    * Draws fractal.
    * @return fractal 
    */
    public ImagePlus drawJuliaSet(double addRe, double addIm){
        int w = 1920;
        int h = 1080;
        
        int coef = 15;
        
        ImageProcessor image = new ColorProcessor(w, h);

        
        image.setValue(255); //set image default value
        image.fill(); //fill image with default value
        
        
        ComplexNumber number1 = new ComplexNumber();
        
        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            {
                number1.setRe((x-1100)/(double) 400);
                number1.setIm((y-500)/(double) 400);
                
                int[] color = {0, 0, 0};
                
                for(int k=0;k<200;k++){
                    number1.iterate(2);
                    number1.setRe(round(number1.getRe() + addRe,3));
                    number1.setIm(round(number1.getIm() + addIm, 3));
                    
                    if(
                    (number1.getRe()*number1.getRe()
                    + number1.getIm()*number1.getIm()) > 4
                    )
                    {   
                        if(k<10){
                            image.putPixel(x, y, color);
                        }
                        else{
                            color[2] = coef*k;
                            image.putPixel(x, y, color);
                        }
                        break;
                    }
                    color[2] = coef*k;
                    image.putPixel(x, y, color);
                }
                
            }
        }
        ImagePlus img2 = new ImagePlus("fractal image", image);
        
        return img2;
        
    }
    
    private double round(double value, int places) {
        for(int i=0; i<places; i++){
            value = value*10;
        }
        int between = (int) value;
        double result = (double) between;
        
        for(int i=0; i<places; i++){
            result = result/10;
        }
        
        return result;
    }
}
