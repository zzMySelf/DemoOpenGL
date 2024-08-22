package com.baidu.searchbox.feed.video.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.video.floating.VideoFloatingContext;
import com.baidu.searchbox.feed.video.plugin.service.FloatingPlayService;
import com.baidu.searchbox.floating.IFloatingPlayerContext;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.permission.DefaultPermissionGuide;
import com.baidu.searchbox.floating.permission.FloatPermissionUtil;
import com.baidu.searchbox.player.ShortVideoPlayer;
import com.baidu.searchbox.player.callback.BaseVideoPlayerCallbackManager;
import com.baidu.searchbox.video.detail.core.ComponentManager;
import com.baidu.searchbox.video.detail.core.exception.IntentDataException;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.core.model.VideoDetailModel;
import com.baidu.searchbox.video.detail.core.plugin.PluginAdapter;
import com.baidu.searchbox.video.detail.export.IVideoNetWorkUtils;
import com.baidu.searchbox.video.detail.export.IVideoUnitedSchemeUtility;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.searchbox.video.detail.message.MessageUtils;
import com.baidu.searchbox.video.detail.service.IFloatingPlayService;
import com.baidu.searchbox.video.detail.service.INetworkErrorService;
import com.baidu.searchbox.video.detail.utils.BdVideoSeriesFactory;
import com.baidu.searchbox.video.detail.utils.VideoFloatingUtils;
import com.baidu.searchbox.video.detail.utils.VideoUbc699;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.utils.SchemeUtilsKt;
import com.baidu.searchbox.video.videoplayer.util.VideoInfoProtocolKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.Subscription;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n*\u0002\u0004\u0012\u0018\u0000 82\u00020\u0001:\u000289B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u0006\u0010(\u001a\u00020\u0019J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u0016\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020$H\u0002J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/feed/video/plugin/FloatingPlugin;", "Lcom/baidu/searchbox/video/detail/core/plugin/PluginAdapter;", "()V", "cancelListener", "com/baidu/searchbox/feed/video/plugin/FloatingPlugin$cancelListener$1", "Lcom/baidu/searchbox/feed/video/plugin/FloatingPlugin$cancelListener$1;", "mPlayer", "Lcom/baidu/searchbox/player/ShortVideoPlayer;", "getMPlayer", "()Lcom/baidu/searchbox/player/ShortVideoPlayer;", "mPlayer$delegate", "Lkotlin/Lazy;", "mVideoFloatingContext", "Lcom/baidu/searchbox/feed/video/floating/VideoFloatingContext;", "getMVideoFloatingContext", "()Lcom/baidu/searchbox/feed/video/floating/VideoFloatingContext;", "mVideoFloatingContext$delegate", "resultListener", "com/baidu/searchbox/feed/video/plugin/FloatingPlugin$resultListener$1", "Lcom/baidu/searchbox/feed/video/plugin/FloatingPlugin$resultListener$1;", "subscription", "Lrx/Subscription;", "tag", "", "canSwitchFloatingMode", "", "player", "createIntent", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "params", "disabledByScheme", "exitToFloating", "needAlertAuth", "getIntentParams", "cmd", "handleMessage", "", "message", "Landroid/os/Message;", "injectService", "isNeedSwitchFloating", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "requestNextVideoData", "position", "", "max", "requestPermission", "requestPermissionOrSwitchToFloating", "switchToFloating", "switchToNormal", "updatePageDataIfNeed", "updateScheme", "Companion", "HomeWatcherReceiver", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingPlugin.kt */
public final class FloatingPlugin extends PluginAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SYSTEM_DIALOG_FROM_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_FROM_KEY = "reason";
    private final FloatingPlugin$cancelListener$1 cancelListener = new FloatingPlugin$cancelListener$1(this);
    private final Lazy mPlayer$delegate = LazyKt.lazy(new FloatingPlugin$mPlayer$2(this));
    private final Lazy mVideoFloatingContext$delegate = LazyKt.lazy(FloatingPlugin$mVideoFloatingContext$2.INSTANCE);
    private final FloatingPlugin$resultListener$1 resultListener = new FloatingPlugin$resultListener$1(this);
    private Subscription subscription;
    private final String tag = "FloatingPlugin";

    /* access modifiers changed from: private */
    public final ShortVideoPlayer getMPlayer() {
        return (ShortVideoPlayer) this.mPlayer$delegate.getValue();
    }

    private final VideoFloatingContext getMVideoFloatingContext() {
        return (VideoFloatingContext) this.mVideoFloatingContext$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/video/plugin/FloatingPlugin$Companion;", "", "()V", "SYSTEM_DIALOG_FROM_HOME_KEY", "", "SYSTEM_DIALOG_FROM_KEY", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FloatingPlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate() {
        Pair location = VideoFloatingUtils.defaultFloatingViewLocation();
        getMVideoFloatingContext().setLocation(location.getFirst().intValue(), location.getSecond().intValue());
        ScaleMode mode = VideoFloatingUtils.defaultFloatingViewScaleMode();
        getMVideoFloatingContext().setScaleMode(new Pair(mode, mode));
        ShortVideoPlayer mPlayer = getMPlayer();
        if (mPlayer != null) {
            mPlayer.registerContext(IFloatingPlayerContext.class, getMVideoFloatingContext());
        }
        updateScheme();
    }

    public void handleMessage(Message message) {
        boolean z = false;
        if (message != null && message.what == 36608) {
            z = true;
        }
        if (z && message.arg1 == 36610) {
            updateScheme();
        }
    }

    public void injectService() {
        this.mComponentManager.registerServices(IFloatingPlayService.class, new FloatingPlayService(this));
    }

    public void onStart() {
        super.onStart();
        ShortVideoPlayer mPlayer = getMPlayer();
        boolean z = true;
        if (mPlayer == null || !mPlayer.isFloatingMode()) {
            z = false;
        }
        if (z) {
            updatePageDataIfNeed();
        }
        switchToNormal();
    }

    private final void updatePageDataIfNeed() {
        String str;
        VideoDetailModel videoDetailModel;
        IntentData intentData;
        ComponentManager componentManager = this.mComponentManager;
        if (componentManager == null || (videoDetailModel = componentManager.currentModel) == null || (intentData = videoDetailModel.intentData) == null || (str = intentData.getVideoInfo()) == null) {
            str = "";
        }
        BdVideoSeries seriesPage = BdVideoSeriesFactory.createVideoSeries(str);
        ShortVideoPlayer mPlayer = getMPlayer();
        String str2 = null;
        BdVideoSeries seriesPlayer = mPlayer != null ? mPlayer.getVideoSeries() : null;
        if (seriesPage != null && seriesPlayer != null) {
            BdVideo selectedVideo = seriesPage.getSelectedVideo();
            CharSequence playUrl = selectedVideo != null ? selectedVideo.getPlayUrl() : null;
            BdVideo selectedVideo2 = seriesPlayer.getSelectedVideo();
            if (selectedVideo2 != null) {
                str2 = selectedVideo2.getPlayUrl();
            }
            if (!TextUtils.equals(playUrl, str2)) {
                INetworkErrorService service = (INetworkErrorService) this.mComponentManager.getService(INetworkErrorService.class);
                if (!IVideoNetWorkUtils.Impl.get().isConnected(this.mContext)) {
                    if (service != null) {
                        service.hideLoading();
                        service.showErrorView(true);
                    }
                    this.mComponentManager.notify(MessageUtils.obtainUbcMessage(MessageManifest.UBC.UBC_302));
                    return;
                }
                IntentData intentData2 = createIntent(getIntentParams(getMVideoFloatingContext().getScheme()));
                if (intentData2 != null) {
                    this.mComponentManager.updateIntentData(intentData2);
                }
                this.subscription = this.mComponentManager.fetchData();
            }
        }
    }

    private final String getIntentParams(String cmd) {
        if (!IVideoUnitedSchemeUtility.Impl.get().isUnitedScheme(cmd)) {
            return "";
        }
        String params = IVideoUnitedSchemeUtility.Impl.get().getParams(cmd).get("params");
        if (params == null) {
            params = "";
        }
        return params;
    }

    private final IntentData createIntent(String params) {
        if (TextUtils.isEmpty(params)) {
            return null;
        }
        try {
            return IntentData.create(params, false);
        } catch (IntentDataException e2) {
            this.mComponentManager.handIntentDataException(e2);
            return null;
        }
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public final boolean isNeedSwitchFloating() {
        return canSwitchFloatingMode(getMPlayer()) && VideoFloatingUtils.hasAlertAuthPermission() && FloatPermissionUtil.INSTANCE.checkPermission(this.mContext);
    }

    private final boolean requestPermissionOrSwitchToFloating() {
        boolean alertAuth = VideoFloatingUtils.hasAlertAuthPermission();
        if (FloatPermissionUtil.INSTANCE.checkPermission(this.mContext)) {
            switchToFloating();
            return false;
        } else if (!alertAuth) {
            requestPermission();
            return true;
        } else {
            VideoFloatingUtils.toastOpenPermission();
            return false;
        }
    }

    private final void switchToFloating() {
        ShortVideoPlayer mPlayer = getMPlayer();
        boolean z = true;
        if (mPlayer == null || !mPlayer.isFloatingMode()) {
            z = false;
        }
        if (!z) {
            ShortVideoPlayer mPlayer2 = getMPlayer();
            if (mPlayer2 != null) {
                mPlayer2.switchToFloating();
            }
            getMVideoFloatingContext().setPlayNextVideoCallback();
            this.mComponentManager.finish();
        }
    }

    public final boolean exitToFloating(boolean needAlertAuth) {
        if (needAlertAuth) {
            if (canSwitchFloatingMode(getMPlayer())) {
                return requestPermissionOrSwitchToFloating();
            }
        } else if (canSwitchFloatingMode(getMPlayer()) && VideoFloatingUtils.hasAlertAuthPermission() && FloatPermissionUtil.INSTANCE.checkPermission(this.mContext)) {
            switchToFloating();
            return false;
        }
        return false;
    }

    public void onDestroy() {
        BaseVideoPlayerCallbackManager playerCallbackManager;
        ShortVideoPlayer mPlayer = getMPlayer();
        boolean z = true;
        if (mPlayer == null || !mPlayer.isFloatingMode()) {
            z = false;
        }
        if (z) {
            ShortVideoPlayer mPlayer2 = getMPlayer();
            if (mPlayer2 != null) {
                mPlayer2.clearSwitchAssistant();
            }
            ShortVideoPlayer mPlayer3 = getMPlayer();
            if (mPlayer3 != null) {
                mPlayer3.resetDefaultSwitchHelper();
            }
            ShortVideoPlayer mPlayer4 = getMPlayer();
            if (!(mPlayer4 == null || (playerCallbackManager = mPlayer4.getPlayerCallbackManager()) == null)) {
                playerCallbackManager.release();
            }
            ShortVideoPlayer mPlayer5 = getMPlayer();
            if (mPlayer5 != null) {
                mPlayer5.detachFromContainer();
            }
            getMVideoFloatingContext().setPlayNextVideoCallback();
            getMVideoFloatingContext().setPlayerListener();
        }
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    public final void requestNextVideoData(int position, int max) {
        getMVideoFloatingContext().requestNextVideo(position, max);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/video/plugin/FloatingPlugin$HomeWatcherReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/baidu/searchbox/feed/video/plugin/FloatingPlugin;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "unregister", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FloatingPlugin.kt */
    public final class HomeWatcherReceiver extends BroadcastReceiver {
        public HomeWatcherReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ShortVideoPlayer access$getMPlayer;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (TextUtils.equals(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS") && Intrinsics.areEqual((Object) "homekey", (Object) intent.getStringExtra("reason"))) {
                FloatingPlugin floatingPlugin = FloatingPlugin.this;
                if (floatingPlugin.canSwitchFloatingMode(floatingPlugin.getMPlayer()) && VideoFloatingUtils.hasAlertAuthPermission() && FloatPermissionUtil.INSTANCE.checkPermission(FloatingPlugin.this.mContext)) {
                    ShortVideoPlayer access$getMPlayer2 = FloatingPlugin.this.getMPlayer();
                    boolean z = true;
                    if (access$getMPlayer2 == null || !access$getMPlayer2.isFullMode()) {
                        z = false;
                    }
                    if (!z && (access$getMPlayer = FloatingPlugin.this.getMPlayer()) != null) {
                        access$getMPlayer.switchToFloating();
                    }
                }
            }
        }

        public final void register(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.registerReceiver(this, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }

        public final void unregister(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.unregisterReceiver(this);
        }
    }

    private final void switchToNormal() {
        IFloatingPlayerContext iFloatingPlayerContext;
        ShortVideoPlayer mPlayer = getMPlayer();
        if (mPlayer != null && (iFloatingPlayerContext = (IFloatingPlayerContext) mPlayer.getPlayerContext(IFloatingPlayerContext.class)) != null) {
            iFloatingPlayerContext.switchToNormal();
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    private final void updateScheme() {
        IntentData intentData;
        String $this$updateScheme_u24lambda_u2d2;
        try {
            Context context = this.mContext;
            if (context != null) {
                Intent intent = ((Activity) context).getIntent();
                VideoDetailModel videoDetailModel = this.mComponentManager.currentModel;
                if (videoDetailModel != null && (intentData = videoDetailModel.intentData) != null && ($this$updateScheme_u24lambda_u2d2 = intentData.params) != null) {
                    JSONObject paramsObj = new JSONObject($this$updateScheme_u24lambda_u2d2);
                    JSONObject infoObj = paramsObj.optJSONObject("videoInfo");
                    if (infoObj != null) {
                        Intrinsics.checkNotNullExpressionValue(infoObj, "optJSONObject(\"videoInfo\")");
                        infoObj.put(VideoInfoProtocolKt.SEEK_SECONDS, "");
                        paramsObj.put("videoInfo", infoObj);
                        ExecutorUtilsExt.postOnElastic(new FloatingPlugin$$ExternalSyntheticLambda0(this, intent, paramsObj), "updateFloatingPluginScheme", 0);
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateScheme$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m19728updateScheme$lambda2$lambda1$lambda0(FloatingPlugin this$0, Intent $intent, JSONObject $paramsObj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($paramsObj, "$paramsObj");
        VideoFloatingContext mVideoFloatingContext = this$0.getMVideoFloatingContext();
        Intrinsics.checkNotNullExpressionValue($intent, "intent");
        mVideoFloatingContext.setScheme(SchemeUtilsKt.rebuildScheme($intent, $paramsObj.toString()));
    }

    /* access modifiers changed from: private */
    public final boolean canSwitchFloatingMode(ShortVideoPlayer player) {
        if (player == null || disabledByScheme() || player.isAdLayerShow()) {
            return false;
        }
        if (player.isPlaying() || player.isPause()) {
            return true;
        }
        return false;
    }

    private final boolean disabledByScheme() {
        IntentData intentData = this.mComponentManager.currentModel.intentData;
        if (intentData != null && !TextUtils.equals("1", intentData.mSuspenseDisable)) {
            return false;
        }
        return true;
    }

    private final void requestPermission() {
        IntentData intentData = this.mComponentManager.currentModel.intentData;
        VideoUbc699.reportVideoFloatingAuthShow(intentData != null ? intentData.vid : null);
        DefaultPermissionGuide defaultPermissionGuide = DefaultPermissionGuide.INSTANCE;
        Context context = this.mContext;
        if (context != null) {
            defaultPermissionGuide.showShortVideoGuideDialog((Activity) context, this.resultListener, this.cancelListener);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
