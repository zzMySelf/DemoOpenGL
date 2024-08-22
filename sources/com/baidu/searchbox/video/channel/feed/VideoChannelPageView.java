package com.baidu.searchbox.video.channel.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.api.IService;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.introduction.IntroductionAdStatusChannel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.channel.feed.VideoChannelPageView$playerSyncEventListener$2;
import com.baidu.searchbox.video.channel.feed.VideoChannelPageView$splashStatusListener$2;
import com.baidu.searchbox.video.channel.feed.widgetguide.FeedChannelWidgetFirstActManager;
import com.baidu.searchbox.video.channel.flow.pageview.ChannelFlowPageView;
import com.baidu.searchbox.video.channel.flow.pageview.OnChannelConstructorCallback;
import com.baidu.searchbox.video.channel.flow.pageview.drawer.ChannelFlowDrawerManager;
import com.baidu.searchbox.video.channel.flow.pageview.drawer.IChannelDrawer;
import com.baidu.searchbox.video.channel.flow.utils.ChannelJumpModel;
import com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.channel.ChannelPageExtParamState;
import com.baidu.searchbox.video.feedflow.channel.ChannelPageExtParamStateKt;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerListenerService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005*\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001c\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001bH\b¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u001fJ\b\u0010(\u001a\u00020\u001fH\u0016J\u0006\u0010)\u001a\u00020\u001fJ\b\u0010*\u001a\u00020\u001fH\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/video/channel/feed/VideoChannelPageView;", "Lcom/baidu/searchbox/video/channel/flow/pageview/ChannelFlowPageView;", "context", "Landroid/content/Context;", "extParams", "Landroid/os/Bundle;", "(Landroid/content/Context;Landroid/os/Bundle;)V", "playerSyncEventListener", "com/baidu/searchbox/video/channel/feed/VideoChannelPageView$playerSyncEventListener$2$1", "getPlayerSyncEventListener", "()Lcom/baidu/searchbox/video/channel/feed/VideoChannelPageView$playerSyncEventListener$2$1;", "playerSyncEventListener$delegate", "Lkotlin/Lazy;", "splashStatusListener", "com/baidu/searchbox/video/channel/feed/VideoChannelPageView$splashStatusListener$2$1", "getSplashStatusListener", "()Lcom/baidu/searchbox/video/channel/feed/VideoChannelPageView$splashStatusListener$2$1;", "splashStatusListener$delegate", "canDispatchActiveOnResume", "", "jumpModel", "Lcom/baidu/searchbox/video/channel/flow/utils/ChannelJumpModel;", "createIntentData", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "getIntentData", "getService", "T", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "()Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "haveUsedPreCreatePage", "onUserVisibleHint", "", "isVisibleToUser", "onViewDestroy", "registerTopViewEvent", "setPreCreateTime", "isStart", "time", "", "setPreCreateUsed", "tryActive", "tryReissueDrawerLifeCycle", "unRegisterTopViewEvent", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoChannelPageView.kt */
public final class VideoChannelPageView extends ChannelFlowPageView {
    private final Lazy playerSyncEventListener$delegate;
    private final Lazy splashStatusListener$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoChannelPageView(Context context, Bundle extParams) {
        super(context, extParams, (Intent) null, (OnChannelConstructorCallback) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.playerSyncEventListener$delegate = BdPlayerUtils.lazyNone(new VideoChannelPageView$playerSyncEventListener$2(this));
        this.splashStatusListener$delegate = BdPlayerUtils.lazyNone(new VideoChannelPageView$splashStatusListener$2(this, context));
        IPlayerListenerService iPlayerListenerService = (IPlayerListenerService) getComponentManager().getService(IPlayerListenerService.class);
        if (iPlayerListenerService != null) {
            iPlayerListenerService.addPlayerComponentListener(this, getPlayerSyncEventListener(), true);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoChannelPageView(Context context, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : bundle);
    }

    private final VideoChannelPageView$playerSyncEventListener$2.AnonymousClass1 getPlayerSyncEventListener() {
        return (VideoChannelPageView$playerSyncEventListener$2.AnonymousClass1) this.playerSyncEventListener$delegate.getValue();
    }

    private final VideoChannelPageView$splashStatusListener$2.AnonymousClass1 getSplashStatusListener() {
        return (VideoChannelPageView$splashStatusListener$2.AnonymousClass1) this.splashStatusListener$delegate.getValue();
    }

    public void onUserVisibleHint(boolean isVisibleToUser) {
        super.onUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            FeedChannelWidgetFirstActManager.INSTANCE.onVideoViewResume();
        }
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        unRegisterTopViewEvent();
    }

    public void tryActive() {
        registerTopViewEvent();
        super.tryActive();
    }

    /* access modifiers changed from: protected */
    public boolean canDispatchActiveOnResume(ChannelJumpModel jumpModel) {
        return super.canDispatchActiveOnResume(jumpModel) && (jumpModel == null || !IntroductionAdStatusChannel.isTopViewShowing());
    }

    /* access modifiers changed from: protected */
    public IntentData createIntentData() {
        IntentData $this$createIntentData_u24lambda_u2d0 = super.createIntentData();
        ChannelTabUtilsKt.setFeedChannelKey($this$createIntentData_u24lambda_u2d0);
        return $this$createIntentData_u24lambda_u2d0;
    }

    private final void registerTopViewEvent() {
        IntroductionAdStatusChannel.registerListener(getSplashStatusListener());
    }

    private final void unRegisterTopViewEvent() {
        IntroductionAdStatusChannel.unRegisterListener(getSplashStatusListener());
    }

    public final IntentData getIntentData() {
        State state = getStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(IntentData.class);
        }
        return (IntentData) obj;
    }

    public final /* synthetic */ <T extends IService> T getService() {
        ComponentArchManager $this$getService$iv = getComponentManager();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<IService> cls = IService.class;
        Class cls2 = cls;
        return $this$getService$iv.getService(cls);
    }

    public final void setPreCreateUsed() {
        State state = getStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ChannelPageExtParamState.class);
        }
        ChannelPageExtParamState channelPageExtParamState = (ChannelPageExtParamState) obj;
        if (channelPageExtParamState != null) {
            channelPageExtParamState.setHaveUsedPreCreatePage(true);
        }
    }

    public final boolean haveUsedPreCreatePage() {
        return ChannelPageExtParamStateKt.isUsedPreCreate((Store<?>) getStore());
    }

    public static /* synthetic */ void setPreCreateTime$default(VideoChannelPageView videoChannelPageView, boolean z, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = System.currentTimeMillis();
        }
        videoChannelPageView.setPreCreateTime(z, j2);
    }

    public final void setPreCreateTime(boolean isStart, long time) {
        if (isStart) {
            ChannelPageExtParamStateKt.setPreCreateStartTime(getStore(), time);
        } else {
            ChannelPageExtParamStateKt.setPreCreateEndTime(getStore(), time);
        }
    }

    public final void tryReissueDrawerLifeCycle() {
        IChannelDrawer drawerManager = getDrawerManager();
        ChannelFlowDrawerManager $this$tryReissueDrawerLifeCycle_u24lambda_u2d1 = drawerManager instanceof ChannelFlowDrawerManager ? (ChannelFlowDrawerManager) drawerManager : null;
        if ($this$tryReissueDrawerLifeCycle_u24lambda_u2d1 != null) {
            $this$tryReissueDrawerLifeCycle_u24lambda_u2d1.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            $this$tryReissueDrawerLifeCycle_u24lambda_u2d1.onUserVisibleHint(true);
        }
    }
}
