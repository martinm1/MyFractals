package com.mycompany.myfractals;

import ij.ImagePlus;
import ij.io.FileSaver;

class MyFractals {
    
    public static void main(String[] args) 
    {
        Drawer drawer = new Drawer();
        ImagePlus julia = drawer.drawJuliaSet(-0.4, 0.6);
        ImagePlus mandelbrot = drawer.drawMandelbrotSet();
        julia.show();
        mandelbrot.show();
        new FileSaver(julia).saveAsPng("julia.png");
        new FileSaver(mandelbrot).saveAsPng("mandelbrot.png");
    }
}