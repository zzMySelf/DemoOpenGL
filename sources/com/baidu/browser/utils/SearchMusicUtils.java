package com.baidu.browser.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.browser.framework.AbsBdFrameView;
import com.baidu.browser.framework.BdWindowWrapper;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdmediacore.MediaRuntime;
import com.baidu.searchbox.music.CallMusicPlayer;
import com.baidu.searchbox.music.MusicInvokeCallback;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.music.ServiceInvokeParams;
import com.baidu.searchbox.music.bean.PlayerExtInfo;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import org.json.JSONObject;

public class SearchMusicUtils {
    public static void registerCallMusicPlayerEvent(final Context context, final AbsBdFrameView frameView, final BdWindowWrapper windowWrapper) {
        BdEventBus.Companion.getDefault().register(frameView, CallMusicPlayer.class, 1, new Action<CallMusicPlayer>() {
            public void call(CallMusicPlayer callMusicPlayer) {
                if (TextUtils.equals(callMusicPlayer.source, "voice")) {
                    callMusicPlayer.source = callMusicPlayer.getSchemeSource();
                }
                SearchMusicUtils.callMusicPlayer(context, frameView, windowWrapper, callMusicPlayer.source, callMusicPlayer.playerType, callMusicPlayer.currentIndext, callMusicPlayer.mSongs, callMusicPlayer.mCallback, callMusicPlayer.getPlayerExtInfo(), callMusicPlayer.isClearPlayedList);
            }
        });
    }

    public static void postInterruptedEvent(String from) {
        MusicManager.Companion.get().interrupt(from);
    }

    /* access modifiers changed from: private */
    public static void callMusicPlayer(Context context, AbsBdFrameView frameView, BdWindowWrapper windowWrapper, String source, int playerType, int currentIndex, ArrayList<Song> mSongs, String callback, PlayerExtInfo extInfo, boolean isClearPlayedList) {
        BdWindowWrapper bdWindowWrapper = windowWrapper;
        invokeMusicSchemeCallback(windowWrapper, callback, CallMusicPlayer.generateMusicCallbackParams("0", ""));
        if (!(bdWindowWrapper == null || windowWrapper.getCurrentWindow() == null || windowWrapper.getCurrentWindow().getExploreView() == null)) {
            CallbackHandler handler = windowWrapper.getCurrentWindow().getExploreView();
        }
        switchPlayer(context, frameView, source, playerType, currentIndex, mSongs, extInfo, isClearPlayedList);
    }

    private static void invokeMusicSchemeCallback(BdWindowWrapper windowWrapper, String callback, JSONObject params) {
        if (!TextUtils.isEmpty(callback) && params != null && windowWrapper.getCurrentWindow() != null) {
            windowWrapper.getCurrentWindow().handleSchemeDispatchCallback(callback, UnitedSchemeUtility.wrapCallbackParams(params, 0).toString());
        }
    }

    private static void switchPlayer(Context context, AbsBdFrameView frameView, String source, int playerType, int currentIndex, ArrayList<Song> songList, PlayerExtInfo extInfo, boolean isClearPlayedList) {
        if (!(frameView == null || extInfo == null)) {
            String shareUrl = frameView.getCurrentUrl();
            extInfo.setMusicShareUrl(TextUtils.isEmpty(shareUrl) ? "" : shareUrl);
        }
        MediaRuntime.getContext().switchPlayerFromSearch(context, frameView, source, playerType, extInfo);
        if (playerType == 0 || playerType == 1) {
            ServiceInvokeParams params = new ServiceInvokeParams(source, songList);
            params.setStartIndex(currentIndex);
            if (extInfo != null) {
                params.setStatInfo(extInfo.getStatInfo());
                params.setPlayTimestamp(extInfo.getPlayTimestamp());
                params.setAutoPlay(extInfo.getAutoPlay());
                params.setStartPlay(extInfo.getStartPlay());
                params.setClearPlayedList(isClearPlayedList);
            }
            MusicManager.Companion.get().startMusicService(context, params, (MusicInvokeCallback) null);
        }
    }
}
