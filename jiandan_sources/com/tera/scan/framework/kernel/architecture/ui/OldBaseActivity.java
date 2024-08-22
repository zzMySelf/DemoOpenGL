package com.tera.scan.framework.kernel.architecture.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tera.scan.framework.kernel.architecture.component.IBaseActivityCallback;
import com.tera.scan.themeskin.base.SkinBaseActivity;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.j.uk;
import fe.mmm.qw.p030switch.rg.de;
import java.util.Iterator;
import java.util.Stack;

public abstract class OldBaseActivity extends SkinBaseActivity implements IView {
    public static final Stack<FragmentActivity> ACTIVITY_STACK = new Stack<>();
    public static final String ADVERTISE_SHOW_SERVICE = "advertise_show_service";
    public static final String AI_APPS_SERVICE = "ai_apps_service";
    public static final String ALBUM_SERVICE = "album_service";
    public static final String APK_BACKUP_SERVICE = "apk_backup_service";
    public static final String AUDIO_BACKUP_SERVICE = "audio_backup_service";
    public static final String CLOUD_FILE_SERVICE = "cloud_file_service";
    public static final String CLOUD_UNZIP_SERVICE = "cloud_unzip";
    public static final String DOCUEMNT_BACKUP_SERVICE = "docuemnt_backup_service";
    public static final String NEWS_FEED_SERVICE = "news_feed_service";
    public static final int NO_LAYOUT = 0;
    public static final String PHOTO_BACKUP_SERVICE = "photo_backup_service";
    public static final String PLUGIN_FILE_META_SERVICE = "plugin_file_meta_service";
    public static final String PROBATIONARY_SERVICE = "probationary_service";
    public static final int REQUEST_CODE_BIND_SINGKIL = 60;
    public static final int RTN_CODE_UNZIP = 12343;
    public static final String SAVE_FILE_SERVICE = "save_file_service";
    public static final String SHARE_CLOUD_IMAGE_SERVICE = "share_cloud_image_service";
    public static final String SHARE_DIRECTORY_SERVICE = "share_directory_service";
    public static final String SMART_DEVICE_SERVICE = "smart_device_service";
    public static final String TAG = "OldBaseActivity";
    public static final String TRANS_ASSISTANT_SERVICE = "trans_assistant_service";
    public static final String VIDEO_BACKUP_SERVICE = "video_backup_service";
    public static final String VIP_SERVICE = "vip";
    public static final String WAP_CONTROL_SERVICE = "wap_control_service";
    public static final String WEB_DATA_PRE_PULL_SERVICE = "web_data_pre_pull_service";
    public static final String WECHAT_FILE_BACKUP_SERVICE = "wechat_file_backup_service";
    public static final String WECHAT_OTHER_FILE_BACKUP_SERVICE = "wechat_other_file_backup_service";
    public static final String WECHAT_PHOTO_BACKUP_SERVICE = "wechat_photo_backup_service";
    public static final String WECHAT_VIDEO_BACKUP_SERVICE = "wechat_video_backup_service";
    public boolean mNavigate = false;
    public boolean mSplash = false;

    public static void addActivity(OldBaseActivity oldBaseActivity) {
        if (oldBaseActivity != null) {
            ACTIVITY_STACK.push(oldBaseActivity);
        }
    }

    public static void closeApplication() {
        qw.uk(TAG, "closeApplication ");
        if (!ACTIVITY_STACK.empty()) {
            Iterator it = ACTIVITY_STACK.iterator();
            while (it.hasNext()) {
                FragmentActivity fragmentActivity = (FragmentActivity) it.next();
                if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                    fragmentActivity.finish();
                }
            }
            ACTIVITY_STACK.clear();
        }
    }

    public static void closeApplicationExceptAuthenticatorPage(Class<?> cls, Class<?> cls2) {
        if (!ACTIVITY_STACK.empty()) {
            Iterator it = ACTIVITY_STACK.iterator();
            while (it.hasNext()) {
                FragmentActivity fragmentActivity = (FragmentActivity) it.next();
                if (fragmentActivity != null && !fragmentActivity.isFinishing() && cls != null && cls2 != null && !cls.isInstance(fragmentActivity) && !cls2.isInstance(fragmentActivity)) {
                    fragmentActivity.finish();
                }
            }
            ACTIVITY_STACK.clear();
        }
    }

    public static void closeApplicationExceptSearchboxPage(Class<?> cls) {
        if (!ACTIVITY_STACK.empty()) {
            Iterator it = ACTIVITY_STACK.iterator();
            while (it.hasNext()) {
                FragmentActivity fragmentActivity = (FragmentActivity) it.next();
                if (fragmentActivity != null && !fragmentActivity.isFinishing() && cls != null && !cls.isInstance(fragmentActivity)) {
                    fragmentActivity.finish();
                }
            }
            ACTIVITY_STACK.clear();
        }
    }

    public static void closeApplicationExceptVideoPage(Class<?> cls, Class<?> cls2) {
        if (!ACTIVITY_STACK.empty()) {
            Iterator it = ACTIVITY_STACK.iterator();
            while (it.hasNext()) {
                FragmentActivity fragmentActivity = (FragmentActivity) it.next();
                if (fragmentActivity != null && !fragmentActivity.isFinishing() && cls != null && cls2 != null && !cls.isInstance(fragmentActivity) && !cls2.isInstance(fragmentActivity)) {
                    fragmentActivity.finish();
                }
            }
            ACTIVITY_STACK.clear();
        }
    }

    public static boolean closeTopActivities(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z = false;
        while (!ACTIVITY_STACK.empty()) {
            FragmentActivity peek = ACTIVITY_STACK.peek();
            String name = peek.getClass().getName();
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (name.equals(strArr[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z || peek.getParent() != null) {
                break;
            }
            if (peek != null && !peek.isFinishing() && !name.equals(str)) {
                peek.finish();
            }
            ACTIVITY_STACK.pop();
        }
        return z;
    }

    public static void closeVideoPage(Class<?> cls) {
        if (!ACTIVITY_STACK.empty()) {
            Iterator it = ACTIVITY_STACK.iterator();
            while (it.hasNext()) {
                FragmentActivity fragmentActivity = (FragmentActivity) it.next();
                if (fragmentActivity != null && !fragmentActivity.isFinishing() && cls != null && cls.isInstance(fragmentActivity)) {
                    fragmentActivity.finish();
                }
            }
        }
    }

    public static Stack<FragmentActivity> getActivityStack() {
        return ACTIVITY_STACK;
    }

    public static OldBaseActivity getBottomBaseActivity() {
        if (ACTIVITY_STACK.empty()) {
            return null;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) ACTIVITY_STACK.firstElement();
        if (fragmentActivity instanceof OldBaseActivity) {
            return (OldBaseActivity) fragmentActivity;
        }
        return null;
    }

    public static FragmentActivity getTopActivity() {
        if (ACTIVITY_STACK.empty()) {
            return null;
        }
        return ACTIVITY_STACK.peek();
    }

    public static FragmentActivity getTopAvailableActivity() {
        if (ACTIVITY_STACK.empty()) {
            return null;
        }
        for (int size = ACTIVITY_STACK.size() - 1; size >= 0; size--) {
            FragmentActivity fragmentActivity = (FragmentActivity) ACTIVITY_STACK.get(size);
            if (!fragmentActivity.isFinishing()) {
                return fragmentActivity;
            }
        }
        return null;
    }

    private void initVolume() {
        setVolumeControlStream(3);
    }

    public static void refreshTopActivity(OldBaseActivity oldBaseActivity) {
        removeActivity(oldBaseActivity);
        addActivity(oldBaseActivity);
    }

    public static void removeActivity(OldBaseActivity oldBaseActivity) {
        if (oldBaseActivity != null) {
            ACTIVITY_STACK.remove(oldBaseActivity);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void setPortrait() {
        if (Build.VERSION.SDK_INT != 26 && needSetPortrait()) {
            setRequestedOrientation(1);
        }
    }

    public boolean backFragment() {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public abstract int getLayoutId();

    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public <T> T getService(String str) {
        IBaseActivityCallback qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw();
        if (qw != null) {
            return qw.getService(str);
        }
        return null;
    }

    public void initEvent() {
    }

    public void initParams() {
    }

    public abstract void initView();

    public boolean isDestroying() {
        return super.isFinishing();
    }

    public boolean needSetPortrait() {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        IBaseActivityCallback qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw();
        if (qw != null) {
            qw.onActivityResult(i2, i3, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe.mmm.qw.p030switch.th.de.ad.qw.yj(this, configuration);
    }

    public void onCreate(Bundle bundle) {
        qw.m973switch(getClass().getSimpleName(), "onCreate");
        de.qw().yj(this);
        super.onCreate(bundle);
        setPortrait();
        setContentView();
        initParams();
        initView();
        initEvent();
        addActivity(this);
        initVolume();
        IBaseActivityCallback qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw();
        if (qw != null) {
            qw.onCreate(bundle);
        }
        de.qw().uk(this);
    }

    public void onDestroy() {
        qw.m973switch(getClass().getSimpleName(), "onDestroy");
        removeActivity(this);
        de.qw().qw(this);
        super.onDestroy();
    }

    public void onPause() {
        qw.m973switch(getClass().getSimpleName(), "onPause");
        super.onPause();
        IBaseActivityCallback qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw();
        if (qw != null) {
            qw.onPause();
        }
        de.qw().i(this);
    }

    public void onResume() {
        IBaseActivityCallback qw;
        qw.m973switch(TAG, "Activity Name=" + getClass().getSimpleName());
        super.onResume();
        if (!this.mNavigate) {
            de.qw().ad(this);
        }
        if (!this.mSplash && (qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw()) != null) {
            qw.qw(this);
        }
        if (fe.mmm.qw.p030switch.th.de.ad.qw.rg() != uk.qw.ad(this)) {
            fe.mmm.qw.p030switch.th.de.ad.qw.th(this);
        }
    }

    public void onStart() {
        super.onStart();
        IBaseActivityCallback qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw();
        if (qw != null) {
            qw.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        IBaseActivityCallback qw = fe.mmm.qw.p030switch.th.de.qw.qw.ad().qw();
        if (qw != null) {
            qw.onStop();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        de.qw().th(this, z);
    }

    public void setContentView() {
        int layoutId = getLayoutId();
        if (layoutId != 0) {
            setContentView(layoutId);
        }
    }

    public void setNavigate(boolean z) {
        this.mNavigate = z;
    }

    public void setSplash(boolean z) {
        this.mSplash = z;
    }

    public void showError(int i2) {
    }

    public void showError(int i2, String str) {
    }

    public void showError(String str) {
    }

    public void showSuccess(int i2) {
    }

    public void showSuccess(String str) {
    }

    public void startProgress(int i2) {
    }

    public void stopProgress(int i2) {
    }
}
