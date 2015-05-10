package com.retromantis.nikuniwe;

import java.util.Random;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/**
 * @author Retromantis
 */
public final class NikApplication extends NikDrawable {
    
    public static int DELAY_MS = 100;
    
    public static final int PRESSED  = 1;
    public static final int DRAGGED  = 2;
    public static final int REPEATED = 3;
    public static final int RELEASED = 4;
        
    private static NikApplication instance;
    public final NikCanvas canvas;
    private final Random rnd;
    public MIDlet midlet;
    private boolean bStarted;
    private NikScreen screen;

    private NikApplication() {
        canvas = new NikCanvas(this);
        rnd = new Random();
        width  = canvas.getWidth();
        height = canvas.getHeight();
    }
    
    public static final NikApplication getInstance(final MIDlet midlet){
        if(instance == null) {
            instance = new NikApplication();
        }
        if(midlet instanceof MIDlet) {
            instance.midlet = midlet;
        }
        return instance;
    }
    
    public final void setDelayMS(final int delay_ms) {
        DELAY_MS = delay_ms;
    }
    
    public final void gotoScreen(final NikScreen scr) {
        screen = scr;
        if(bStarted) {
            canvas.gotoScreen(screen);
        } else {
            if(screen instanceof NikScreen) {
                bStarted = true;
                canvas.gotoScreen(screen);
                Display.getDisplay(midlet).setCurrent(canvas);            
                canvas.start();
            }
        }
    }
    
    public final int random(final int max) {
        return (Math.abs(rnd.nextInt()) % max);
    }

    public final void closeApp() {
        canvas.stop();
        midlet.notifyDestroyed();
    }

}
