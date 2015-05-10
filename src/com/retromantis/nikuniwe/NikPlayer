package com.retromantis.nikuniwe;

import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

/**
 * @author Retromantis
 */
public class NikPlayer {
    
    private static NikPlayer instance;
    
    private int bVolume;
    
    private NikPlayer() {
        bVolume = 100;
    }
    
    public static final NikPlayer getInstance() {
        if(instance == null) {
            instance = new NikPlayer();
        }
        return instance;
    }
    
    public final Player createPlayer(final String filename, final String mimetype) {
        Player player = null;
        InputStream stream = NikPlayer.class.getResourceAsStream(filename);
        try {
            player = Manager.createPlayer(stream, mimetype);
            player.realize();
            player.prefetch();
        } catch (Exception ex) {}
        return player;
    }
    
    public final void start(final Player player, final int loopCount) {
        if(bVolume > 0) {
            try {
                player.setLoopCount(loopCount);
                player.start();
            } catch (Exception ex) {}
        }
    }
    
    public final void setVolume(final int vol) {
        bVolume = vol;
    }
    
    public final int getVolume() {
        return bVolume;
    }
    
}
