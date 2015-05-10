package com.retromantis.nikuniwe;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * @author Retromantis
 */
public class NikBackground extends NikDrawable {
    
    private int SCR_WDT;
    private int SCR_HGT;
    private int BG_WDT;
    private int BG_HGT;
    private int BG_COLS;
    private int BG_ROWS;
    private int velX;
    private int velY;
    private int ofsX;
    private int ofsY;
    private int startX;
    private int startY;
    private int stopX;
    private int stopY;
    private Image bg;
    
    public NikBackground(final String name, final int vx, final int vy) {
        Image image = null;
        try {
            image = Image.createImage(name);
        } catch (IOException ex) {}
        constructor(image,vx,vy);
    }
    
    public NikBackground(final Image image, final int vx, final int vy) {
        constructor(image,vx,vy);
    }
    
    protected final void constructor(final Image image, final int vx, final int vy) {
        bg = image;
        NikApplication app = NikApplication.getInstance(null);
        SCR_WDT = app.canvas.getWidth();
        SCR_HGT = app.canvas.getHeight();
        BG_WDT = bg.getWidth();
        BG_HGT = bg.getHeight();
        BG_COLS = (SCR_WDT + (BG_WDT-1)) / BG_WDT;
        BG_ROWS = (SCR_HGT + (BG_HGT-1)) / BG_HGT;
        velX = vx;
        velY = vy;
        if(velX > 0) {
            startX = -BG_WDT;
            stopX = BG_WDT;
        } else if(velX < 0) {
            startX = 0;
            stopX = -BG_WDT;
        } else {
            BG_COLS--;
        }
        if(velY > 0) {
            startY = -BG_HGT;
            stopY = BG_HGT;
        } else if(velY < 0) {
            startY = 0;
            stopY = -BG_HGT;
        } else {
            BG_ROWS--;
        }
    }
    
    public final void onDraw(final Graphics g) {
        g.setClip(0, 0, SCR_WDT, SCR_HGT);
        for(int r=0, py=startY; r <= BG_ROWS; r++, py+=BG_HGT) {
            for(int c=0, px=startX; c <= BG_COLS; c++, px+=BG_WDT) {
                g.drawImage(bg, px + ofsX, py + ofsY, Graphics.LEFT|Graphics.TOP);
            }
        }
    }
    
    public void onUpdate() {
        if(ofsX != stopX) {
            ofsX += velX;
        } else {
            ofsX = 0;
        }
        if(ofsY != stopY) {
            ofsY += velY;
        } else {
            ofsY = 0;
        }
    }
    
}
