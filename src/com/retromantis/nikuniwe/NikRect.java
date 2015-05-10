package com.retromantis.nikuniwe;

/**
 * @author Retromantis
 */
public class NikRect {
    
    public  int x;
    public  int y;
    public  int width;
    public  int height;
    
    public boolean inBounds(final int px, final int py) {
        return ( (px >= x) && (px < (x+width)) && (py >= y) && (py < (y+height)));
    }
   
    public boolean collidesWith(final NikRect rect) {
        if( (x + width) <= rect.x ) return false;
        if( x >= (rect.x + rect.width) ) return false;
        if( (y + height) <= rect.y ) return false;
        return y < (rect.y + rect.height);
    }
    
}
