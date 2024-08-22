package com.baidu.searchbox.speech;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.BrowserRuntime;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.CallMusicPlayer;
import com.baidu.searchbox.music.PlayerInvokeParams;
import com.baidu.searchbox.music.internal.IMusicPlayerInterceptor;
import com.baidu.searchbox.music.internal.IMusicSchemeMediator;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;

public class VoiceMessageCenter {
    private static final boolean DEBUG = BrowserRuntime.GLOBAL_DEBUG;
    private static final String TAG = "VoiceMessageCenter";

    public static boolean invokeScheme(Context context, String cmd, String source, Bundle bundle) {
        if (TextUtils.isEmpty(cmd)) {
            if (DEBUG) {
                Log.d(TAG, "invokeScheme mode is not url");
            }
            return false;
        } else if (UnitedSchemeUtility.isUnitedScheme(cmd.trim())) {
            return invokeScheme(context, Uri.parse(cmd), source, (CallbackHandler) null);
        } else {
            return false;
        }
    }

    private static boolean invokeScheme(Context context, Uri uri, String source, CallbackHandler handler) {
        return createDispatcher(context, uri, source, new VoiceCallbackHandler(), false);
    }

    private static boolean createDispatcher(Context context, Uri uri, String source, CallbackHandler handler, boolean isOnlyVerift) {
        if (context == null) {
            context = AppRuntime.getAppContext();
        }
        if (context == null) {
            context = SchemeConfig.getAppContext();
        }
        UnitedSchemeBaseDispatcher musicDispatcher = IMusicSchemeMediator.Companion.getImpl().buildMusicScheme(new IMusicPlayerInterceptor() {
            public void onInvokeIntercept(PlayerInvokeParams params) {
                CallMusicPlayer callMusicPlayer = new CallMusicPlayer(params);
                callMusicPlayer.saveSchemeSource(params.getServiceInvokeParams().getSource());
                callMusicPlayer.source = "voice";
                BdEventBus.Companion.getDefault().post(callMusicPlayer);
            }
        });
        UnitedSchemeMainDispatcher mainDispatcher = new UnitedSchemeMainDispatcher();
        mainDispatcher.setDynamicDispatcher("audio", musicDispatcher);
        UnitedSchemeEntity entity = new UnitedSchemeEntity(uri, source);
        entity.setOnlyVerify(isOnlyVerift);
        return mainDispatcher.dispatch(context, entity, handler);
    }

    private static class VoiceCallbackHandler implements CallbackHandler {
        private VoiceCallbackHandler() {
        }

        public void handleSchemeDispatchCallback(String s, String s1) {
        }

        public String getCurrentPageUrl() {
            return null;
        }
    }
}
