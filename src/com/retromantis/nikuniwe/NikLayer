package com.retromantis.nikuniwe;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

/**
 * @author Retromantis
 */
public class NikLayer extends NikDrawable implements NikUpdateable, NikTouchable {
    
    protected Vector drawables;
    protected Vector updateables;
    protected Vector touchables;
    
    protected int nDrawables;
    protected int nUpdateables;
    protected int nTouchables;
    
    public NikLayer() {
        parent = NikApplication.getInstance(null);
        width = parent.width;
        height = parent.height;
        onCreate();
    }
    
    public void onCreate() {}

    public void add(final Object child) {
        if(child instanceof NikDrawable) {
            if(drawables == null) {
                drawables = new Vector();
            }
            ((NikDrawable)child).parent = this;
            drawables.addElement(child);
            nDrawables++;
        }
        if(child instanceof NikUpdateable) {
            if(updateables == null) {
                updateables = new Vector();
            }
            updateables.addElement(child);
            nUpdateables++;
        }
        if(child instanceof NikTouchable) {
            if(touchables == null) {
                touchables = new Vector();
            }
            touchables.addElement(child);
            nTouchables++;
        }
    }
    
    public void remove(final Object child) {
        if(child instanceof NikDrawable) {
            if(drawables != null) {
                if(drawables.removeElement(child)) {
                    nDrawables--;
                }
            }
        }
        if(child instanceof NikUpdateable) {
            if(updateables != null) {
                if(updateables.removeElement(child)) {
                    nUpdateables--;
                }
            }
        }
        if(child instanceof NikTouchable) {
            if(touchables != null) {
                if(touchables.removeElement(child)) {
                    nTouchables--;
                }
            }
        }
    }
    
    public void onDraw(final Graphics g) {
        for(int idx=0; idx < nDrawables; idx++) {
            NikDrawable drawable = (NikDrawable)drawables.elementAt(idx);
            if(drawable.isDrawable) {
                drawable.onDraw(g);
            }
        }
    }
    
    public boolean isUpdateable() {
        return isDrawable;
    }

    public void onUpdate() {
        for(int idx=0; idx < nUpdateables; idx++) {
            NikUpdateable updateable = (NikUpdateable)updateables.elementAt(idx);
            if(updateable.isUpdateable()) {
                updateable.onUpdate();
            }
        }
    }

    public boolean isTouchable() {
        return isDrawable;
    }

    public boolean onTouch(final Object sender, final int event, final int x, final int y) {
        boolean res = false;
        for(int idx=0; idx < nTouchables; idx++) {
            NikTouchable touchable = (NikTouchable)touchables.elementAt(idx);
            if(touchable.isTouchable()) {
                if(res = touchable.onTouch(this, event, x, y)) {
                    break;
                }
            }
        }
        return res;
    }

}
