package com.baidu.searchbox.download.center.clearcache.view.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.support.appcompat.storage.util.UriUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.ScanBean;
import com.baidu.searchbox.download.center.clearcache.view.funison.local.AbsClearCachePhoneActivity;
import com.baidu.searchbox.download.center.ioc.IDownloadCenterApp;
import com.baidu.searchbox.download.center.ui.DownloadSwitchHelper;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeFileDeleteUtils;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeSuccessEvent;
import com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer;
import com.baidu.searchbox.download.center.ui.video.vulcan.VulcanControlLayerCallback;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.config.PlayerConfig;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0014J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0014J\b\u0010 \u001a\u00020\u0011H\u0014J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/local/AbsClearCachePhoneActivity;", "()V", "mLocalVideoPlayer", "Lcom/baidu/searchbox/download/center/ui/video/vulcan/DownloadVulcanVideoPlayer;", "mPlayerCallback", "Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity$PlayerCallback;", "getMPlayerCallback", "()Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity$PlayerCallback;", "mPlayerCallback$delegate", "Lkotlin/Lazy;", "videoHolderView", "Landroid/widget/FrameLayout;", "getVideoHolderView", "()Landroid/widget/FrameLayout;", "videoHolderView$delegate", "doPlayVideo", "", "phoneFileInfo", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "initViewOnCreate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "resetWithCurImmersion", "shouldReleasePlayer", "PlayerCallback", "VideoSwitchHelper", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsClearCachePhoneVideoActivity.kt */
public abstract class AbsClearCachePhoneVideoActivity extends AbsClearCachePhoneActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public DownloadVulcanVideoPlayer mLocalVideoPlayer;
    private final Lazy mPlayerCallback$delegate = LazyKt.lazy(new AbsClearCachePhoneVideoActivity$mPlayerCallback$2(this));
    private final Lazy videoHolderView$delegate = LazyKt.lazy(new AbsClearCachePhoneVideoActivity$videoHolderView$2(this));

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    private final FrameLayout getVideoHolderView() {
        return (FrameLayout) this.videoHolderView$delegate.getValue();
    }

    private final PlayerCallback getMPlayerCallback() {
        return (PlayerCallback) this.mPlayerCallback$delegate.getValue();
    }

    public void initViewOnCreate() {
        super.initViewOnCreate();
        switch (getPhoneFileType()) {
            case 4:
            case 5:
            case 6:
            case 7:
                ViewGroup.LayoutParams videoHolderLayoutParams = new ViewGroup.LayoutParams(-1, -1);
                RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.clearCachePhoneFileRootView);
                if (relativeLayout != null) {
                    relativeLayout.addView(getVideoHolderView(), videoHolderLayoutParams);
                }
                BdEventBus.Companion.getDefault().register(this, TranscodeSuccessEvent.class, 1, new AbsClearCachePhoneVideoActivity$$ExternalSyntheticLambda0());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewOnCreate$lambda-0  reason: not valid java name */
    public static final void m17147initViewOnCreate$lambda0(TranscodeSuccessEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public final void doPlayVideo(ScanBean phoneFileInfo) {
        String videoPlayPath;
        String videoPlayUriPath;
        Intrinsics.checkNotNullParameter(phoneFileInfo, "phoneFileInfo");
        String phoneFilePath = phoneFileInfo.getPath();
        if (!StringsKt.isBlank(phoneFilePath)) {
            try {
                videoPlayPath = URLDecoder.decode(phoneFilePath, "utf-8");
            } catch (Exception exception) {
                if (AppConfig.isDebug()) {
                    exception.printStackTrace();
                }
                String str = null;
                videoPlayPath = null;
            }
            CharSequence charSequence = videoPlayPath;
            boolean isDownloadByKernel = false;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                try {
                    videoPlayUriPath = Uri.parse(videoPlayPath).getEncodedPath();
                } catch (Exception exception2) {
                    if (AppConfig.isDebug()) {
                        exception2.printStackTrace();
                    }
                    String str2 = null;
                    videoPlayUriPath = null;
                }
                CharSequence charSequence2 = videoPlayUriPath;
                if (!(charSequence2 == null || StringsKt.isBlank(charSequence2)) && FileUtils.isExistFile(videoPlayUriPath)) {
                    DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
                    if (downloadVulcanVideoPlayer == null) {
                        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer2 = new DownloadVulcanVideoPlayer(this, (PlayerConfig) null, 2, (DefaultConstructorMarker) null);
                        DownloadVulcanVideoPlayer $this$doPlayVideo_u24lambda_u2d1 = downloadVulcanVideoPlayer2;
                        $this$doPlayVideo_u24lambda_u2d1.attachToContainer(getVideoHolderView());
                        $this$doPlayVideo_u24lambda_u2d1.getPlayerCallbackManager().setControlLayerCallback(getMPlayerCallback());
                        this.mLocalVideoPlayer = downloadVulcanVideoPlayer2;
                    } else if (downloadVulcanVideoPlayer != null) {
                        downloadVulcanVideoPlayer.stop();
                    }
                    DownloadVulcanVideoPlayer videoPlayer = this.mLocalVideoPlayer;
                    if (videoPlayer != null) {
                        videoPlayer.setStyleSwitchHelper(new VideoSwitchHelper(this, videoPlayer));
                        videoPlayer.switchToPortrait(1, 1);
                        videoPlayer.setSpeed(1.0f);
                        videoPlayer.setPlayerListener();
                        videoPlayer.getPlayerCallbackManager().setVideoPlayerCallback(new AbsClearCachePhoneVideoActivity$doPlayVideo$2(videoPlayer));
                        videoPlayer.goBackOrForeground(true);
                        if (1 == phoneFileInfo.getType()) {
                            isDownloadByKernel = true;
                        }
                        videoPlayer.removeShareButton();
                        videoPlayer.removePreviewButton();
                        if (DownloadMediaHelper.noNeedMediaFileProcessor(videoPlayPath)) {
                            TranscodeFileDeleteUtils.INSTANCE.setVideoFilePathPlaying(videoPlayPath);
                            DownloadVulcanVideoPlayer downloadVulcanVideoPlayer3 = this.mLocalVideoPlayer;
                            if (downloadVulcanVideoPlayer3 != null) {
                                downloadVulcanVideoPlayer3.setVideoInfo(videoPlayPath, phoneFileInfo.getDisplayName(), "clear_cache", isDownloadByKernel);
                            }
                            DownloadVulcanVideoPlayer downloadVulcanVideoPlayer4 = this.mLocalVideoPlayer;
                            if (downloadVulcanVideoPlayer4 != null) {
                                downloadVulcanVideoPlayer4.start();
                                return;
                            }
                            return;
                        }
                        UriUtils.convertFileUri(this, Uri.parse(videoPlayPath), new AbsClearCachePhoneVideoActivity$$ExternalSyntheticLambda1(this, phoneFileInfo.getDisplayName(), isDownloadByKernel));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: doPlayVideo$lambda-2  reason: not valid java name */
    public static final void m17146doPlayVideo$lambda2(AbsClearCachePhoneVideoActivity this$0, String $title, boolean $isDownloadByKernel, Uri uri, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($title, "$title");
        String realUri = IDownloadCenterApp.Impl.get().getVideoFilePathFromUri(this$0, uri);
        TranscodeFileDeleteUtils.INSTANCE.setVideoFilePathPlaying(realUri);
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this$0.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null) {
            downloadVulcanVideoPlayer.setVideoInfo(realUri, $title, "clear_cache", $isDownloadByKernel);
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer2 = this$0.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer2 != null) {
            downloadVulcanVideoPlayer2.start();
        }
    }

    /* access modifiers changed from: private */
    public final void resetWithCurImmersion() {
        if (immersionEnabled() && this.mImmersionHelper != null && getRequestedOrientation() == 1) {
            getWindow().clearFlags(1024);
            this.mImmersionHelper.resetWithCurImmersion();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null) {
            downloadVulcanVideoPlayer.resume();
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer2 = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer2 != null) {
            downloadVulcanVideoPlayer2.goBackOrForeground(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null) {
            downloadVulcanVideoPlayer.pause();
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer2 = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer2 != null) {
            downloadVulcanVideoPlayer2.goBackOrForeground(false);
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null) {
            downloadVulcanVideoPlayer.release();
        }
        BdEventBus.Companion.getDefault().unregister(this);
        super.onDestroy();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !shouldReleasePlayer()) {
            return super.onKeyDown(keyCode, event);
        }
        TranscodeFileDeleteUtils.INSTANCE.setVideoFilePathPlaying((String) null);
        return true;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (immersionEnabled() && this.mImmersionHelper != null && newConfig.orientation == 1) {
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(1024);
            }
            UiThreadUtils.runOnUiThread(new AbsClearCachePhoneVideoActivity$$ExternalSyntheticLambda2(this), 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onConfigurationChanged$lambda-3  reason: not valid java name */
    public static final void m17148onConfigurationChanged$lambda3(AbsClearCachePhoneVideoActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mImmersionHelper.resetWithCurImmersion();
    }

    private final boolean shouldReleasePlayer() {
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer == null) {
            return false;
        }
        if (downloadVulcanVideoPlayer != null) {
            downloadVulcanVideoPlayer.switchToHalf(3);
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer2 = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer2 != null) {
            downloadVulcanVideoPlayer2.stop();
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer3 = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer3 != null) {
            downloadVulcanVideoPlayer3.release();
        }
        this.mLocalVideoPlayer = null;
        return true;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity$PlayerCallback;", "Lcom/baidu/searchbox/download/center/ui/video/vulcan/VulcanControlLayerCallback;", "(Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity;)V", "onBackClick", "", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsClearCachePhoneVideoActivity.kt */
    public final class PlayerCallback extends VulcanControlLayerCallback {
        public PlayerCallback() {
        }

        public void onBackClick() {
            super.onBackClick();
            DownloadVulcanVideoPlayer access$getMLocalVideoPlayer$p = AbsClearCachePhoneVideoActivity.this.mLocalVideoPlayer;
            if (access$getMLocalVideoPlayer$p != null) {
                access$getMLocalVideoPlayer$p.release();
            }
            AbsClearCachePhoneVideoActivity.this.mLocalVideoPlayer = null;
            TranscodeFileDeleteUtils.INSTANCE.setVideoFilePathPlaying((String) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity$VideoSwitchHelper;", "Lcom/baidu/searchbox/download/center/ui/DownloadSwitchHelper;", "player", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "(Lcom/baidu/searchbox/download/center/clearcache/view/activity/AbsClearCachePhoneVideoActivity;Lcom/baidu/searchbox/player/BaseVideoPlayer;)V", "requestPortrait", "", "activity", "Landroid/app/Activity;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsClearCachePhoneVideoActivity.kt */
    public final class VideoSwitchHelper extends DownloadSwitchHelper {
        final /* synthetic */ AbsClearCachePhoneVideoActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VideoSwitchHelper(AbsClearCachePhoneVideoActivity this$02, BaseVideoPlayer player) {
            super(player);
            Intrinsics.checkNotNullParameter(player, "player");
            this.this$0 = this$02;
        }

        /* access modifiers changed from: protected */
        public void requestPortrait(Activity activity) {
            super.requestPortrait(activity);
            AbsClearCachePhoneVideoActivity absClearCachePhoneVideoActivity = activity instanceof AbsClearCachePhoneVideoActivity ? (AbsClearCachePhoneVideoActivity) activity : null;
            if (absClearCachePhoneVideoActivity != null) {
                absClearCachePhoneVideoActivity.resetWithCurImmersion();
            }
        }
    }
}
