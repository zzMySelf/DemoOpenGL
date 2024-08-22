package com.yy.transvod.player;

import android.text.TextUtils;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VodPlayerManager {
    private static final String TAG = "[VodPlayerManager]";
    private static final int TASK_ID_FAILED = -1;
    private static VodPlayerManager sIns;
    private ConcurrentHashMap<String, VodPlayer> mVodPlayerInsPool = new ConcurrentHashMap<>();

    public static VodPlayerManager instance() {
        if (sIns == null) {
            synchronized (VodPlayerManager.class) {
                if (sIns == null) {
                    sIns = new VodPlayerManager();
                }
            }
        }
        return sIns;
    }

    public void bindUniqueKeyForPlayer(String key, VodPlayer player) {
        if (TextUtils.isEmpty(key) || player == null) {
            TLog.error(TAG, "player or key is null");
        } else if (!this.mVodPlayerInsPool.containsKey(key) || this.mVodPlayerInsPool.get(key) == null) {
            if (this.mVodPlayerInsPool.containsValue(player)) {
                Iterator<Map.Entry<String, VodPlayer>> it = this.mVodPlayerInsPool.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, VodPlayer> entry = it.next();
                    if (player == entry.getValue()) {
                        this.mVodPlayerInsPool.remove(entry.getKey());
                        break;
                    }
                }
            }
            this.mVodPlayerInsPool.put(key, player);
            TLog.warn(TAG, "player bind suc, tastId:" + player.getCurrentTaskID() + " bindUniqueKeyForPlayer key:" + key + "-vodPlayer:" + player);
        } else {
            TLog.warn(TAG, "bindUniqueKeyForPlayer contain key and player");
        }
    }

    public boolean updatePlayerUniqueKey(String key, VodPlayer player) {
        if (TextUtils.isEmpty(key) || player == null) {
            TLog.error(TAG, "updatePlayerUniqueKey player or key is null");
            return false;
        } else if (!this.mVodPlayerInsPool.containsKey(key) || this.mVodPlayerInsPool.get(key) == null) {
            return false;
        } else {
            this.mVodPlayerInsPool.put(key, player);
            TLog.warn(TAG, "player update suc, taskid:" + player.getCurrentTaskID() + "updatePlayerUniqueKey key:" + key + "-vodPlayer:" + player);
            return true;
        }
    }

    public VodPlayer obtainPlayer(String key, boolean hasCallback) {
        OnPlayerStateUpdateListener listener;
        if (TextUtils.isEmpty(key) || !this.mVodPlayerInsPool.containsKey(key)) {
            TLog.error(TAG, "obtainPlayer player is null, key:" + key);
            return null;
        }
        VodPlayer vodPlayer = this.mVodPlayerInsPool.get(key);
        TLog.warn(TAG, "TaskID:" + vodPlayer.getCurrentTaskID() + "-obtainPlayer vodPlayer:" + vodPlayer + " key:" + key);
        if (hasCallback && (listener = vodPlayer.getPlayerStateUpdateListener()) != null) {
            listener.onPlayerStateUpdate(vodPlayer, 10, 0);
        }
        return vodPlayer;
    }

    public void removePlayerUniqueKey(String key, String source) {
        TLog.warn(TAG, "removePlayerUniqueKey key:" + key + ", source:" + source);
        if (!TextUtils.isEmpty(key) && this.mVodPlayerInsPool.containsKey(key)) {
            this.mVodPlayerInsPool.remove(key);
        }
    }

    public void removePlayerUniqueKey(String key) {
        removePlayerUniqueKey(key, "");
    }

    public boolean isUniqueKeyHasBindPlayer(String key) {
        if (TextUtils.isEmpty(key) || !this.mVodPlayerInsPool.containsKey(key) || this.mVodPlayerInsPool.get(key) == null) {
            TLog.warn(TAG, "isUniqueKeyHasBindPlayer not bind key:" + key);
            return false;
        }
        TLog.warn(TAG, "isUniqueKeyHasBindPlayer has bind key:" + key);
        return true;
    }
}
