package com.retromantis.nikuniwe;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/**
 * @author Retromantis
 */
public final class NikCanvas extends Canvas implements CommandListener {
    
    private final NikApplication app;
    private NikScreen screen;
    private boolean bRunning;
    private long msApp;
    private long msAppLast;
    public static Canvas canvas;
        
    public NikCanvas(final NikApplication application) {
        app = application;
	      setFullScreenMode(true);
        setCommandListener(this);
        canvas = this;
    }
    
    public final void start() {
        bRunning = true;
        run();
    }

    public final void stop() {
        bRunning = false;
    }
    
    public final void paint(Graphics g) {
        screen.onDraw(g);
    }

    public final void run() {
	      msAppLast = System.currentTimeMillis();
        while(bRunning) {
            // ---- time synchronization
            msApp = System.currentTimeMillis() - msAppLast;
            if( msApp > 0 ) msAppLast = System.currentTimeMillis();
            if( msApp < NikApplication.DELAY_MS ) { try{ Thread.sleep(NikApplication.DELAY_MS - msApp); } catch( InterruptedException e ) {} }
            
            screen.onUpdate();
            repaint(); serviceRepaints();
        }
    }
    
    public final void gotoScreen(final NikScreen scr) {
        screen = scr;
        scr.onStart();
    }
    
    protected final void pointerPressed(final int x, final int y) {
        screen.onTouch(app, NikApplication.PRESSED, x, y);
    }
    
    protected final void pointerDragged(final int x, final int y) {
        screen.onTouch(app, NikApplication.DRAGGED, x, y);
    }
    
    protected final void pointerReleased(final int x, final int y) {
        screen.onTouch(app, NikApplication.RELEASED, x, y);
    }
    
    protected final void keyPressed(final int keyCode) {
        screen.onKey(NikApplication.PRESSED, keyCode);
    }
    
    protected final void keyRepeated(final int keyCode) {
        screen.onKey(NikApplication.REPEATED, keyCode);
    }
    
    protected final void keReleased(final int keyCode) {
        screen.onKey(NikApplication.RELEASED, keyCode);
    }
    
    public final void commandAction(final Command cmd, final Displayable disp) {
        if(cmd.getCommandType() == Command.BACK) {
            screen.onBack();
        }
    }
    
}
