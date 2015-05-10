package com.retromantis.nikuniwe;

import javax.microedition.lcdui.Graphics;

/**
 * @author Retromantis
 */
public class NikDrawable extends NikRect {
    
    public NikDrawable parent;
    
    // content rectangle: x,y,width,height
    public int cx;
    public int cy;
    public int cwidth;
    public int cheight;
    
    // point/pin x,y
    public int px;
    public int py;
    
    // if drawable must be centered (x,y)
    public boolean centerX;
    public boolean centerY;
    
    // if visible then draw it
    public boolean isDrawable = true;
    
    public void posXY(final int X, final int Y) {
        x = px = X;
        if(centerX) {
            x -=(width >> 1);
        }
        y = py = Y;
        if(centerY) {
            y -= (height >> 1);
        }
    }
    
    public void moveXY(final int x, final int y) {
        posXY(px + x, py + y);
    }
    
    public void onDraw(final Graphics g) {}
    
}
