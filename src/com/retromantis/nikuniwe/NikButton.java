package com.retromantis.nikuniwe;

import javax.microedition.lcdui.Image;

/**
 * @author Retromantis
 */
public class NikButton extends NikSprite implements NikTouchable, NikRunnable {

    public NikRunnable runnable;
    protected boolean bPressed;
    
    public NikButton(final String name, int frameWidth, int frameHeight) {
        super(name, frameWidth, frameHeight);
    }

    public NikButton(final Image image, int frameWidth, int frameHeight) {
        super(image, frameWidth, frameHeight);
    }
    
    public NikButton(final Image image, int sx, int sy, int swidth, int sheight, int frameWidth, int frameHeight) {
        super(image, sx, sy, swidth, sheight, frameWidth, frameHeight);
    }
    
    public void onCreate() {
        cx = 2;
        cy = 2;
        cwidth -= 4;
        cheight -= 4;
        runnable = this;
    }
    
    public boolean onTouch(final Object sender, final int event, final int x, final int y) {
        boolean res = false;
        if(isDrawable) {
            switch(event) {
                case NikApplication.PRESSED:
                    if(inBounds(x,y)) {
                        res = true;
                        bPressed = true;
                        setFrame(1, false);
                    }
                    break;
                case NikApplication.RELEASED:
                    if(bPressed) {
                        res = true;
                        bPressed = false;
                        setFrame(0, false);
                        runnable.run(this);
                    }
                    break;
            }
        }
        return res;
    }
    
    public void run(final Object sender) {}

    public boolean isTouchable() {
        return isDrawable;
    }
    
}
