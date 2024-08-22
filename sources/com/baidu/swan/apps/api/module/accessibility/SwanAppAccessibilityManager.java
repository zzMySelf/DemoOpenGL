package com.baidu.swan.apps.api.module.accessibility;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.baidu.swan.apps.event.message.SwanAppCustomMessage;
import com.baidu.swan.apps.lifecycle.SwanAppController;

public class SwanAppAccessibilityManager {
    private static final String DATA_KEY = "data";
    private static final String EVENT_REDUCE_MOTION_CHANGED = "reduceMotionChange";
    private static final String EVENT_SCREEN_READER_CHANGED = "screenReaderChange";
    private static final String SETTING_REDUCE_MOTION = "transition_animation_scale";
    private static final String TAG = "SwanAppAccessibilityManager";
    private static volatile SwanAppAccessibilityManager sInstance;
    private ContentObserver mReduceMotionObserver;
    private AccessibilityManager.TouchExplorationStateChangeListener mScreenReaderListener;
    private AccessibilityManager mScreenReaderManager;

    private SwanAppAccessibilityManager() {
    }

    public static SwanAppAccessibilityManager getInstance() {
        if (sInstance == null) {
            synchronized (SwanAppAccessibilityManager.class) {
                if (sInstance == null) {
                    sInstance = new SwanAppAccessibilityManager();
                }
            }
        }
        return sInstance;
    }

    public void register(Context context) {
        registerReduceMotionObserver(context);
        registerScreenReaderListener(context);
    }

    public void unregister(Context context) {
        unRegisterReduceMotionObserver(context);
        unRegisterScreenReaderListener();
        doRelease();
    }

    private void doRelease() {
        if (sInstance != null) {
            sInstance = null;
            this.mReduceMotionObserver = null;
            this.mScreenReaderManager = null;
            this.mScreenReaderListener = null;
        }
    }

    private void registerReduceMotionObserver(Context context) {
        if (this.mReduceMotionObserver == null) {
            final ContentResolver contentResolver = context.getContentResolver();
            this.mReduceMotionObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
                public void onChange(boolean selfChange) {
                    boolean isReduceMotion = TextUtils.equals(Settings.Global.getString(contentResolver, SwanAppAccessibilityManager.SETTING_REDUCE_MOTION), "0.0");
                    SwanAppCustomMessage msg = new SwanAppCustomMessage(SwanAppAccessibilityManager.EVENT_REDUCE_MOTION_CHANGED);
                    msg.putValueToData(AccessibilityApi.KEY_IS_REDUCE_MOTION_ENABLED, Boolean.valueOf(isReduceMotion));
                    SwanAppController.getInstance().sendJSMessage(msg);
                }
            };
            contentResolver.registerContentObserver(Settings.Global.getUriFor(SETTING_REDUCE_MOTION), true, this.mReduceMotionObserver);
        }
    }

    private void unRegisterReduceMotionObserver(Context context) {
        if (this.mReduceMotionObserver != null) {
            context.getContentResolver().unregisterContentObserver(this.mReduceMotionObserver);
        }
    }

    private void registerScreenReaderListener(Context context) {
        if (this.mScreenReaderManager == null) {
            this.mScreenReaderManager = (AccessibilityManager) context.getSystemService("accessibility");
            AnonymousClass2 r0 = new AccessibilityManager.TouchExplorationStateChangeListener() {
                public void onTouchExplorationStateChanged(boolean enabled) {
                    SwanAppCustomMessage msg = new SwanAppCustomMessage(SwanAppAccessibilityManager.EVENT_SCREEN_READER_CHANGED);
                    msg.putValueToData(AccessibilityApi.KEY_IS_SCREEN_READER_ENABLED, Boolean.valueOf(enabled));
                    SwanAppController.getInstance().sendJSMessage(msg);
                }
            };
            this.mScreenReaderListener = r0;
            this.mScreenReaderManager.addTouchExplorationStateChangeListener(r0);
        }
    }

    private void unRegisterScreenReaderListener() {
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
        AccessibilityManager accessibilityManager = this.mScreenReaderManager;
        if (accessibilityManager != null && (touchExplorationStateChangeListener = this.mScreenReaderListener) != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }
}
