package com.baidu.swan.apps.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.api.models.SwanAppLifecycleEvent;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.embed.interfaces.ISwanEmbed;
import com.baidu.swan.apps.embed.model.SwanAppRuntimeConfig;
import com.baidu.swan.apps.embed.view.SwanAppEmbedView;
import com.baidu.swan.apps.runtime.Swan;

public class SwanAppEmbedWrapperView extends FrameLayout implements ISwanEmbed {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppEmbedWrapperView";
    protected SwanAppRuntimeConfig mAppRuntimeConfig;
    protected SwanAppEmbedView mSwanAppEmbedView;
    private int mToken;

    public SwanAppEmbedWrapperView(Context context) {
        super(context);
    }

    public SwanAppEmbedWrapperView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwanAppEmbedWrapperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void loadApp(String scheme, Activity activity) {
        this.mToken = String.valueOf(System.currentTimeMillis()).hashCode();
        this.mSwanAppEmbedView.loadApp(scheme, activity);
    }

    public void loadApp(Bundle data, Activity activity) {
        this.mToken = String.valueOf(System.currentTimeMillis()).hashCode();
        this.mSwanAppEmbedView.loadApp(data, activity);
    }

    public void onStart() {
        this.mSwanAppEmbedView.onStart();
    }

    public void onStop() {
        this.mSwanAppEmbedView.onStop();
    }

    public void onResume() {
        this.mSwanAppEmbedView.onResume();
    }

    public void onPause() {
        this.mSwanAppEmbedView.onPause();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return this.mSwanAppEmbedView.onKeyDown(keyCode, event);
    }

    public boolean onBackPressed() {
        return this.mSwanAppEmbedView.onBackPressed();
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return this.mSwanAppEmbedView.onActivityResult(requestCode, resultCode, data);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        this.mSwanAppEmbedView.onConfigurationChanged(newConfig);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        this.mSwanAppEmbedView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onTrimMemory(int level) {
        this.mSwanAppEmbedView.onTrimMemory(level);
    }

    public void onDestroy() {
        this.mSwanAppEmbedView.onDestroy();
    }

    public ActivityResultDispatcher getResultDispatcher() {
        return this.mSwanAppEmbedView.getResultDispatcher();
    }

    public String getLaunchAppId() {
        return this.mSwanAppEmbedView.getLaunchAppId();
    }

    public void sendEventToHost(String eventType) {
        SwanAppLifecycleEvent event = new SwanAppLifecycleEvent(getLaunchAppId(), eventType);
        event.token = String.valueOf(this.mToken);
        if (DEBUG) {
            Log.d(TAG, "sendEvent=" + event.toString());
        }
        Swan.get().getMsgClient().sendSwanLifecycleMessage(event);
    }
}
