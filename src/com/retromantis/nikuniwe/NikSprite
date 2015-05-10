package com.retromantis.nikuniwe;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * @author Retromantis
 */
public class NikSprite extends NikDrawable {
    
    public static final byte	DIR_NONE    = 0;
    public static final byte	DIR_LEFT    = 1;
    public static final byte	DIR_RIGHT   = 2;
    public static final byte	DIR_UP	    = 3;
    public static final byte	DIR_DOWN    = 4;
    
    // direction, horizontal speed, vertical speed
    public int dir;
    public int vx;
    public int vy;
    public int id;
    
    protected Image   image;
    protected boolean bAnimated;
    
    protected int[][] frames;
    protected int frameCount;
    protected int frameIndex;
    
    protected int  [] frameAnim;
    protected int     frameAnimIndex;
    protected int     frameAnimCount;
    protected int     frameAnimDelay;
    protected boolean frameAnimLoop;
    
    public NikSprite() {}

    public NikSprite(final String name, int frameWidth, int frameHeight) {
        constructor(name, 0, 0, 0, 0, frameWidth, frameHeight);
    }
    
    public NikSprite(final Image image, int frameWidth, int frameHeight) {
        constructor(image, 0, 0, 0, 0, frameWidth, frameHeight);
    }
    
    public NikSprite(final String name, int sx, int sy, int swidth, int sheight, int frameWidth, int frameHeight) {
        constructor(name, sx, sy, swidth, sheight, frameWidth, frameHeight);
    }
    
    public NikSprite(final Image image, int sx, int sy, int swidth, int sheight, int frameWidth, int frameHeight) {
        constructor(image, sx, sy, swidth, sheight, frameWidth, frameHeight);
    }
    
    public NikSprite(final String name, int[][] frames) {
        constructor(name, frames);
    }
    
    public NikSprite(final Image image, int[][] frames) {
        constructor(image, frames);
    }
    
    public NikSprite(final NikSprite sprite) {
        if(sprite instanceof NikSprite) {
            parent = sprite.parent;
            centerX = sprite.centerX;
            centerY = sprite.centerY;
            x = sprite.x;
            y = sprite.y;
            width = sprite.width;
            height = sprite.height;
            vx = sprite.vx;
            vy = sprite.vy;
            image = sprite.image;
            bAnimated = sprite.bAnimated;
            frames = sprite.frames;
            frameCount = sprite.frameCount;
            frameIndex = sprite.frameIndex;
            frameAnim = sprite.frameAnim;
            frameAnimIndex = sprite.frameAnimIndex;
            frameAnimCount = sprite.frameAnimCount;
            frameAnimDelay = sprite.frameAnimDelay;
            frameAnimLoop = sprite.frameAnimLoop;
            cx = sprite.cx;
            cy = sprite.cy;
            cwidth = sprite.cwidth;
            cheight = sprite.cheight;
            onCreate();
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    protected final void constructor(final String name, int sx, int sy, int swidth, int sheight, int frameWidth, int frameHeight) {
        try {
            constructor(Image.createImage(name), sx, sy, swidth, sheight, frameWidth, frameHeight);
        } catch (IOException ex) {}
    }
    
    protected final void constructor(final Image img, int sx, int sy, int swidth, int sheight, int frameWidth, int frameHeight) {
        parent = NikApplication.getInstance(null);
        image = img;
        if(swidth <= 0) {
            swidth = image.getWidth();
        }
        if(sheight <= 0) {
            sheight = image.getHeight();
        }
        if(frameWidth <= 0) {
            frameWidth = swidth;
        }
        if(frameHeight <= 0) {
            frameHeight = sheight;
        }
        int cols = swidth / frameWidth;
        int rows = sheight / frameHeight;
        frameCount = cols*rows;
        
            frames = new int[frameCount][8];
            int idx = 0;
            for(int row=0, ofsy=sy; row < rows; row++, ofsy+=frameHeight) {
                for(int col=0, ofsx=sx; col < cols; col++, ofsx+=frameWidth) {
                    frames[idx][0] = ofsx;
                    frames[idx][1] = ofsy;
                    frames[idx][2] = frameWidth;
                    frames[idx][3] = frameHeight;
                    frames[idx][6] = frameWidth;
                    frames[idx][7] = frameHeight;
                    idx++;
                }
            }
            
        width = frameWidth;
        height = frameHeight;
        cwidth = width;
        cheight = height;
        onCreate();
    }
    
    protected final void constructor(final String name, int[][] frames) {
        try {
            constructor(Image.createImage(name), frames);
        } catch (IOException ex) {}
    }
    
    protected final void constructor(final Image img, int[][] frames) {
        parent = NikApplication.getInstance(null);
        image = img;
        this.frames = frames;
        frameCount = frames.length;
        width = frames[0][2];
        height = frames[0][3];
        cwidth = width;
        cheight = height;
        onCreate();
    }
    
    public void onCreate() {}
    
    public final int getFrameWidth(){
        return frames[frameIndex][2];
    }

    public final int getFrameHeight(){
        return frames[frameIndex][3];
    }
    
    public final void setFrameAnimation(final int[] animation, final int delay, final boolean loop) {
        frameAnimLoop = loop;
        frameAnimIndex = 0;
        if(animation == null) {
            frameAnim = new int[frameCount];
            for(int idx=0; idx < frameCount; idx++) {
                frameAnim[idx] = idx;
            }
        } else {
            frameAnim = animation;
        }
        frameIndex = frameAnim[frameAnimIndex];
        updateCollisionRect();
        bAnimated = frameAnim.length > 1;
        frameAnimDelay = delay;
    }
    
    public final void setFrame(final int index, final boolean fromSeq) {
        if(fromSeq && frameAnim != null) {
            frameAnimIndex = index;
            frameIndex = frameAnim[frameAnimIndex];
        } else {
            frameIndex = index;
        }
        updateCollisionRect();
    }
    
    public final int getFrame(final boolean fromAnim) {
        if(fromAnim && frameAnim != null) {
            return frameAnim[frameAnimIndex];
        } else return frameIndex;
    }
    
    public final void nextFrame() {
        if(bAnimated) {
            if(frameAnimCount > frameAnimDelay) {
                frameAnimCount = 0;
                if(frameAnimIndex < (frameAnim.length - 1)) {
                    frameAnimIndex++;
                } else if(frameAnimLoop) {
                    frameAnimIndex = 0;
                } else {
                    onEndAnimation(frameAnim);
                }
                frameIndex = frameAnim[frameAnimIndex];
                updateCollisionRect();
            } else {
                frameAnimCount++;
            }
        }
    }
    
    protected void onEndAnimation(final int[] frameAnim) {}
    
    public void onDraw(final Graphics g) {
        if(isDrawable && frameIndex >= 0) {
            g.setClip(parent.x + x, parent.y + y, frames[frameIndex][2], frames[frameIndex][3]);
            g.drawImage(image, parent.x + (x - frames[frameIndex][0]), parent.y + (y - frames[frameIndex][1]), Graphics.TOP|Graphics.LEFT);
        }
    }
    
    public void posXY(final int X, final int Y) {
        x = px = X;
        if(centerX) {
            x -= (frames[frameIndex][2] >> 1);
        }
        y = py = Y;
        if(centerY) {
            y -= (frames[frameIndex][3] >> 1);
        }
        updateCollisionRect();
    }
    
    public void setCollisiontRect(final int x, final int y, final int width, final int height) {
        for(int idx=0; idx < frameCount; idx++) {
            frames[idx][4] = x;
            frames[idx][5] = y;
            frames[idx][6] = width;
            frames[idx][7] = height;
        }
        updateCollisionRect();
    }
    
    public void updateCollisionRect() {
        if(frameIndex >= 0) {
            cx = x + frames[frameIndex][4];
            cy = y + frames[frameIndex][5];
            cwidth  = frames[frameIndex][6];
            cheight = frames[frameIndex][7];
        }
    }
    
    public boolean inBounds(final int x, final int y) {
        return ( (x >= cx) && (x < (cx+cwidth)) && (y >= cy) && (y < (cy+cheight)));
    }
   
    public boolean collidesWith(final NikDrawable rect) {
        if( (cx + cwidth) <= rect.cx ) return false;
        if( cx >= (rect.cx + rect.cwidth) ) return false;
        if( (cy + cheight) <= rect.cy ) return false;
        return cy < (rect.cy + rect.cheight);
    }

}
