package com.baidu.searchbox.music.adapter;

import android.content.IntentFilter;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.R;
import com.baidu.searchbox.music.ext.album.playback.PlaybackRepo;
import com.baidu.searchbox.music.ext.album.playback.PlaybackState;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/music/adapter/MobileNetworkDetector;", "", "()V", "connectivityReceiver", "com/baidu/searchbox/music/adapter/MobileNetworkDetector$connectivityReceiver$1", "Lcom/baidu/searchbox/music/adapter/MobileNetworkDetector$connectivityReceiver$1;", "isReceiverRegistered", "", "playbackSubscription", "Lrx/subscriptions/CompositeSubscription;", "registerConnectivityReceiver", "", "release", "showMobileNetworkToast", "subscribePlayback", "unregisterConnectivityReceiver", "unsubscribePlayback", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MobileNetworkDetector.kt */
public final class MobileNetworkDetector {
    private final MobileNetworkDetector$connectivityReceiver$1 connectivityReceiver = new MobileNetworkDetector$connectivityReceiver$1(this);
    private boolean isReceiverRegistered;
    private final CompositeSubscription playbackSubscription = new CompositeSubscription();

    public MobileNetworkDetector() {
        registerConnectivityReceiver();
        subscribePlayback();
    }

    private final void registerConnectivityReceiver() {
        if (!this.isReceiverRegistered) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
            AppRuntime.getAppContext().registerReceiver(this.connectivityReceiver, filter);
            this.isReceiverRegistered = true;
            if (MobileNetworkDetectorKt.DEBUG) {
                Log.i("MobileNetworkDetector", "registerConnectivityReceiver!");
            }
        }
    }

    private final void unregisterConnectivityReceiver() {
        if (this.isReceiverRegistered) {
            try {
                AppRuntime.getAppContext().unregisterReceiver(this.connectivityReceiver);
                this.isReceiverRegistered = false;
                if (MobileNetworkDetectorKt.DEBUG) {
                    Log.i("MobileNetworkDetector", "unregisterConnectivityReceiver!");
                }
            } catch (Throwable t) {
                if (MobileNetworkDetectorKt.DEBUG) {
                    t.printStackTrace();
                    Log.e("MobileNetworkDetector", "unregister connectivity receiver err: " + t.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showMobileNetworkToast() {
        if (!MobileNetworkDetectorKt.hasShowMobilePlayToast && NetWorkUtils.isMobileConnected(AppRuntime.getAppContext())) {
            if (MobileNetworkDetectorKt.DEBUG) {
                Log.i("MobileNetworkDetector", "show mobile play toast!");
            }
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.music_mobile_play_toast).showToast();
            MobileNetworkDetectorKt.hasShowMobilePlayToast = true;
            unsubscribePlayback();
            unregisterConnectivityReceiver();
        }
    }

    private final void subscribePlayback() {
        this.playbackSubscription.add(PlaybackRepo.INSTANCE.getPlayStateChange().subscribe(new MobileNetworkDetector$$ExternalSyntheticLambda0(this), (Action1<Throwable>) new MobileNetworkDetector$$ExternalSyntheticLambda1()));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayback$lambda-0  reason: not valid java name */
    public static final void m464subscribePlayback$lambda0(MobileNetworkDetector this$0, PlaybackState curState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (curState == PlaybackState.PLAYING) {
            this$0.showMobileNetworkToast();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayback$lambda-1  reason: not valid java name */
    public static final void m465subscribePlayback$lambda1(Throwable it) {
    }

    private final void unsubscribePlayback() {
        this.playbackSubscription.unsubscribe();
        if (MobileNetworkDetectorKt.DEBUG) {
            Log.i("MobileNetworkDetector", "unsubscribePlayback!");
        }
    }

    public final void release() {
        unsubscribePlayback();
        unregisterConnectivityReceiver();
    }
}
