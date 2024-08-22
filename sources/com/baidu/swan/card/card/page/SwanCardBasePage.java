package com.baidu.swan.card.card.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.swan.card.launch.model.SwanCardPageParam;
import com.baidu.swan.card.launch.model.SwanCardParam;
import com.baidu.swan.card.launch.permission.SwanCardPermission;
import com.baidu.swan.card.pkg.config.CardWindowConfig;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppSlaveManager;
import com.baidu.swan.card.utils.SwanAppLibConfig;

public abstract class SwanCardBasePage implements SwanCardPermission.PermissionCallback {
    protected static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    protected static final String TAG = "SwanCardBasePage";
    public boolean isTransparent;
    protected Activity mActivity;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private AudioManager mAudioManager;
    protected ICardPageContainer mPageContainer;
    protected SwanCardParam mParam;
    public int type;

    public SwanCardBasePage() {
        this.isTransparent = false;
        this.mPageContainer = new SwanCardPageContainer(this);
    }

    public SwanCardBasePage(ICardPageContainer pageContainer) {
        this.isTransparent = false;
        this.mPageContainer = pageContainer;
    }

    public ICardPageContainer getPageContainer() {
        return this.mPageContainer;
    }

    public void onAttach(Context context) {
        if (DEBUG) {
            Log.d(TAG, "onAttach");
        }
        this.mActivity = this.mPageContainer.getAttachedActivity();
    }

    public void onDetach() {
        if (DEBUG) {
            Log.d(TAG, "onDetach");
        }
        this.mActivity = null;
    }

    public void onStart() {
        if (DEBUG) {
            Log.d(TAG, "onStart");
        }
    }

    public void onResume() {
        if (DEBUG) {
            Log.d(TAG, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.mPageContainer.setUserVisibleHint(isVisibleToUser);
    }

    public void setPageVisibleHint(boolean isVisibleToUser) {
        this.mPageContainer.setPageVisibleHint(isVisibleToUser);
    }

    public boolean getPageVisibleHint() {
        return this.mPageContainer.getPageVisibleHint();
    }

    public void onPause() {
        if (DEBUG) {
            Log.d(TAG, "onPause");
        }
    }

    public void onStop() {
        if (DEBUG) {
            Log.d(TAG, "onPause");
        }
    }

    public CardWindowConfig getCurWindowConfig() {
        return null;
    }

    public final Resources getResourcesSafely() {
        if (this.mPageContainer.isPageAdded()) {
            return this.mPageContainer.getPageResources();
        }
        return AppRuntime.getAppContext().getResources();
    }

    /* access modifiers changed from: protected */
    public void requestAudioFocus(Context context) {
        if (context != null) {
            if (this.mAudioFocusListener == null) {
                this.mAudioFocusListener = new AudioFocusListener();
            }
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
            }
            this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 3, 2);
        }
    }

    /* access modifiers changed from: protected */
    public void abandonAudioFocus() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null && (onAudioFocusChangeListener = this.mAudioFocusListener) != null) {
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    public ISwanAppSlaveManager getCurrentWebViewManager() {
        return null;
    }

    public View getWebViewContainer() {
        return null;
    }

    public String getSlaveWebViewId() {
        return null;
    }

    public SwanCardPageParam getCurSwanAppPageParams() {
        return null;
    }

    private static class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {
        private AudioFocusListener() {
        }

        public void onAudioFocusChange(int focusChange) {
        }
    }

    public SwanCardParam getSwanAppParam() {
        return this.mParam;
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResult(String cardId, int requestCode, String[] permissions, int[] grantResults) {
    }

    public void onHiddenChanged(boolean hidden) {
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
    }
}
