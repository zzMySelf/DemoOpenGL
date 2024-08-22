package com.yy.transvod.player;

import com.yy.transvod.player.core.AudioFocusListener;
import com.yy.transvod.player.impl.VodPlayerBase;
import com.yy.transvod.player.impl.subprocess.VodPlayerClient;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlayerGlobalOptions {
    private static AtomicBoolean mAutoControl = new AtomicBoolean(false);
    private static final LinkedList<VodPlayerClient> mSubPlayerList = new LinkedList<>();
    private static final String tag = "PlayerGlobalOptions";

    public static void addSubPlayer(VodPlayerClient player) {
        synchronized (PlayerGlobalOptions.class) {
            LinkedList<VodPlayerClient> linkedList = mSubPlayerList;
            if (linkedList.size() == 0) {
                setOptions(player);
            }
            if (!linkedList.contains(player)) {
                linkedList.add(player);
            }
        }
    }

    public static void removeSubPlayer(VodPlayerBase player) {
        synchronized (PlayerGlobalOptions.class) {
            LinkedList<VodPlayerClient> linkedList = mSubPlayerList;
            if (linkedList.contains(player)) {
                linkedList.remove(player);
            }
        }
    }

    private static void setOptions(VodPlayerClient player) {
        if (player != null) {
            player.setAudioFocusEnable(mAutoControl.get());
        }
    }

    public static void setAudioFocusEnable(boolean enable) {
        TLog.info(tag, " setAudioFocusEnable:" + enable);
        mAutoControl.set(enable);
        AudioFocusListener.enableAutoControl(enable);
        synchronized (PlayerGlobalOptions.class) {
            LinkedList<VodPlayerClient> linkedList = mSubPlayerList;
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    VodPlayerClient player = (VodPlayerClient) it.next();
                    if (player != null) {
                        player.setAudioFocusEnable(enable);
                    }
                }
            }
        }
    }
}
