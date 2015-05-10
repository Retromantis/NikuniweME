package com.retromantis.nikuniwe;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * @author Retromantis
 */
public class NikNumber extends NikSprite {
    
    private String str;
    private int    len;
    private int    numWidth;
    private int    align; //0=right, 1=center, 2=left
    
    
    public NikNumber(final String name, int frameWidth, int frameHeight) {
        super(name, frameWidth, frameHeight);
    }

    public NikNumber(final Image image, int frameWidth, int frameHeight) {
        super(image, frameWidth, frameHeight);
    }
    
    public NikNumber(final Image image, int sx, int sy, int swidth, int sheight, int frameWidth, int frameHeight) {
        super(image, sx, sy, swidth, sheight, frameWidth, frameHeight);
    }
    
    public final void setValue(final int value, final int align) {
        this.align = align;
        str = Integer.toString(Math.abs(value));
        len = str.length();
        numWidth = 0;
        for(int idx=0; idx < len; idx++) {
            numWidth += frames[str.charAt(idx) - 48][2];
        }
    }
    
    public void onDraw(final Graphics g) {
        int tmp = x;
        switch(align) {
            case 1:
                x -= numWidth >> 1;
                break;
            case 2:
                x -= numWidth;
        }
        for(int idx=0; idx < len; idx++) {
            int frame = str.charAt(idx) - 48;
            setFrame(frame, false);
            super.onDraw(g);
            x += frames[frame][2];
        }
        x = tmp;
    }
    
}
