package com.retromantis.nikuniwe;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * @author Retromantis
 */
public class NikImage extends NikDrawable {
    
    protected Image image;
    
    public NikImage(final String name) {
        try {
            image = Image.createImage(name);
        } catch (IOException ex) {}
        width = image.getWidth();
        cwidth = width;
        height = image.getHeight();
        cheight = height;
    }
    
    public void onDraw(final Graphics g) {
        g.setClip(x, y, width, height);
        g.drawImage(image, x, y, Graphics.LEFT|Graphics.TOP);
    }
    
}
