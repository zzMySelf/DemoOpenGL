package com.baidu.searchbox.feed.tts.playback;

import com.baidu.searchbox.bdmediacore.players.Playback;
import com.baidu.searchbox.bdmediacore.utils.MediaDataHelper;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedTtsItemCallback implements ITTSItemPlayCallback {
    private static final boolean DEBUG = TTSRuntime.DEBUG;
    private static final String TAG = "BDMEDIA-tts-player";
    private WeakReference<Playback.Callback> mCallbackWR;

    public void setCallback(Playback.Callback cb) {
        this.mCallbackWR = new WeakReference<>(cb);
    }

    public void onItemPlayStatusChange(int status, int reason, String nid) {
        JSONObject ubc3Ext = new JSONObject();
        try {
            ubc3Ext.put("desUid", nid);
            ubc3Ext.put("reason", reason);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        OnLineLog.get(OnLineLog.TAG_TTS).d("BDMEDIA-tts-player[NotifyStatusChange]" + ubc3Ext);
        WeakReference<Playback.Callback> weakReference = this.mCallbackWR;
        if (weakReference != null && weakReference.get() != null) {
            ((Playback.Callback) this.mCallbackWR.get()).onPlaybackStateChanged(status, reason, nid);
        }
    }

    public void onItemPlayFinish(int status, IFeedTTSModel data) {
        String str;
        JSONObject ubc3Ext = new JSONObject();
        if (data == null) {
            str = "";
        } else {
            try {
                str = data.getId();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        ubc3Ext.put("desUid", str);
        ubc3Ext.put("status", status);
        OnLineLog.get(OnLineLog.TAG_TTS).e("BDMEDIA-tts-player[ItemFinish]" + ubc3Ext);
        WeakReference<Playback.Callback> weakReference = this.mCallbackWR;
        if (weakReference != null && weakReference.get() != null) {
            ((Playback.Callback) this.mCallbackWR.get()).onCompletion(status, MediaDataHelper.convertFeetTtsToMeta(data));
        }
    }
}
