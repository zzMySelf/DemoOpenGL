package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.dialog.UgcPermissionDialogUtils;
import com.baidu.searchbox.ugc.event.LocalAlbumEvent;
import com.baidu.searchbox.ugc.utils.UgcPermissionUtils;

public class LocalAlbumDelegateActivity extends BaseActivity {
    public static final String VIDEO_COVER = "videoCover";
    private static boolean isRunning = false;
    private static ILocalAlbumDelegateDispatcher mLocalAlbumDelegateDispatcher;
    private static LocalAlbumDelegateListener mLocalAlbumDelegateListener;

    public interface ILocalAlbumDelegateDispatcher {
        void dispatch(Activity activity);
    }

    public interface LocalAlbumDelegateListener {
        void onActivityResultDelegate(int i2, int i3, Intent intent);

        void onRequestPermissionsResultDelegate(int i2, String[] strArr, int[] iArr);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ILocalAlbumDelegateDispatcher iLocalAlbumDelegateDispatcher = mLocalAlbumDelegateDispatcher;
        if (iLocalAlbumDelegateDispatcher != null) {
            iLocalAlbumDelegateDispatcher.dispatch(this);
        }
        registerEvent();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LocalAlbumDelegateListener localAlbumDelegateListener = mLocalAlbumDelegateListener;
        if (localAlbumDelegateListener != null) {
            localAlbumDelegateListener.onActivityResultDelegate(requestCode, resultCode, data);
        }
        finish();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LocalAlbumDelegateListener localAlbumDelegateListener = mLocalAlbumDelegateListener;
        if (localAlbumDelegateListener != null) {
            localAlbumDelegateListener.onRequestPermissionsResultDelegate(requestCode, permissions, grantResults);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BdEventBus.Companion.getDefault().unregister(this);
        if (mLocalAlbumDelegateListener != null) {
            mLocalAlbumDelegateListener = null;
        }
        if (mLocalAlbumDelegateDispatcher != null) {
            mLocalAlbumDelegateDispatcher = null;
        }
        if (isRunning) {
            isRunning = false;
        }
        super.onDestroy();
    }

    public void finish() {
        isRunning = false;
        super.finish();
        overridePendingTransition(R.anim.ugc_slide_bottom_in, 0);
    }

    private void registerEvent() {
        BdEventBus.Companion.getDefault().register(this, LocalAlbumEvent.class, 1, new Action<LocalAlbumEvent>() {
            public void call(LocalAlbumEvent localAlbumEvent) {
                if (localAlbumEvent == null) {
                    return;
                }
                if (localAlbumEvent.eventType == 2) {
                    Intent intent = new Intent();
                    intent.putExtra("path", localAlbumEvent.videoPath);
                    intent.putExtra(LocalAlbumDelegateActivity.VIDEO_COVER, localAlbumEvent.videoCover);
                    LocalAlbumDelegateActivity.this.onActivityResult(3, -1, intent);
                } else if (localAlbumEvent.eventType == 3) {
                    LocalAlbumDelegateActivity.this.finish();
                }
            }
        });
    }

    public static void startDelegateActivityForResult(Context context, LocalAlbumDelegateListener listener, ILocalAlbumDelegateDispatcher dispatcher) {
        startDelegateActivityForResult(context, listener, dispatcher, true);
    }

    public static void startDelegateActivityForResult(Context context, LocalAlbumDelegateListener listener, ILocalAlbumDelegateDispatcher dispatcher, boolean checkCameraPermission) {
        if (context != null && !isRunning) {
            if (!checkCameraPermission) {
                startLocalAlbumDelegate(context, listener, dispatcher);
                return;
            }
            String[] permissions = {"android.permission.CAMERA"};
            if (!UgcPermissionUtils.isPermissionGroupGranted(context, permissions)) {
                UgcRuntime.getUgcInterface().requestAllPermisson("ugc_pic", permissions, 0, context, new LocalAlbumDelegateActivity$$ExternalSyntheticLambda0(context, listener, dispatcher), 1, (UgcPermissionDialogUtils.UgcPermissionCallback) null);
                return;
            }
            startLocalAlbumDelegate(context, listener, dispatcher);
        }
    }

    static /* synthetic */ void lambda$startDelegateActivityForResult$0(Context context, LocalAlbumDelegateListener listener, ILocalAlbumDelegateDispatcher dispatcher, boolean isAllAgree) {
        if (isAllAgree) {
            startLocalAlbumDelegate(context, listener, dispatcher);
        }
    }

    private static void startLocalAlbumDelegate(Context context, LocalAlbumDelegateListener listener, ILocalAlbumDelegateDispatcher dispatcher) {
        isRunning = true;
        mLocalAlbumDelegateListener = listener;
        mLocalAlbumDelegateDispatcher = dispatcher;
        context.startActivity(new Intent(context, LocalAlbumDelegateActivity.class));
    }
}
