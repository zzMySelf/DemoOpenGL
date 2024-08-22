package com.baidu.searchbox.feed.controller.mutevideo;

import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.feed.flow.assistants.PageStateAssistant;
import com.baidu.searchbox.feed.log.OnLineLogs;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.template.tplinterface.IBiSerialVideoPlayer;
import com.baidu.searchbox.safemode.impl.config.ConfigImpl;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004/012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0018\u0010!\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\bJ\u0016\u0010#\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010'\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010*\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005J+\u0010+\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0-¢\u0006\u0002\b.H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController;", "", "()V", "channelItems", "Ljava/util/HashMap;", "", "Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$ChannelItem;", "findPlayingOnVisibleScale", "", "item", "getVideoPlayCount", "", "channelId", "handlePlayerDetach", "", "hasItemClick", "hasPlaying", "netChangeOnDelay", "pause", "play", "playOnDelay", "playOnScroll", "registerVideoPlayListener", "listener", "Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$VideoPlayListener;", "registerVideoPlayer", "player", "Lcom/baidu/searchbox/feed/template/tplinterface/IBiSerialVideoPlayer;", "setAssistantHolder", "pageStateHolder", "Lcom/baidu/searchbox/feed/flow/assistants/PageStateAssistant;", "setFirstVid", "firstVid", "setItemClick", "isClick", "setVideoHitPolicy", "policy", "Lcom/baidu/searchbox/feed/controller/mutevideo/IBiSerialVideoHitPolicy;", "stop", "unregisterVideoPlayListener", "unregisterVideoPlayListeners", "unregisterVideoPlayer", "unregisterVideoPlayers", "withChannelItem", "func", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ChannelItem", "MuteVideoPlayRunnable", "NetChangeRunnable", "VideoPlayListener", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialMuteVideoPlayController.kt */
public final class BiSerialMuteVideoPlayController {
    public static final BiSerialMuteVideoPlayController INSTANCE = new BiSerialMuteVideoPlayController();
    private static final HashMap<String, ChannelItem> channelItems = new HashMap<>();

    private BiSerialMuteVideoPlayController() {
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R!\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8FX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0017008FX\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b1\u00102R!\u00104\u001a\b\u0012\u0004\u0012\u0002050)8FX\u0002¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b6\u0010,¨\u00068"}, d2 = {"Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$ChannelItem;", "", "()V", "assistantRef", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/feed/flow/assistants/PageStateAssistant;", "getAssistantRef", "()Ljava/lang/ref/WeakReference;", "setAssistantRef", "(Ljava/lang/ref/WeakReference;)V", "delayNetRunnable", "Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$NetChangeRunnable;", "getDelayNetRunnable", "()Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$NetChangeRunnable;", "setDelayNetRunnable", "(Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$NetChangeRunnable;)V", "delayPlayRunnable", "Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$MuteVideoPlayRunnable;", "getDelayPlayRunnable", "()Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$MuteVideoPlayRunnable;", "setDelayPlayRunnable", "(Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$MuteVideoPlayRunnable;)V", "firstVid", "", "getFirstVid", "()Ljava/lang/String;", "setFirstVid", "(Ljava/lang/String;)V", "hasItemClick", "", "getHasItemClick", "()Z", "setHasItemClick", "(Z)V", "hitPolicy", "Lcom/baidu/searchbox/feed/controller/mutevideo/IBiSerialVideoHitPolicy;", "getHitPolicy", "()Lcom/baidu/searchbox/feed/controller/mutevideo/IBiSerialVideoHitPolicy;", "setHitPolicy", "(Lcom/baidu/searchbox/feed/controller/mutevideo/IBiSerialVideoHitPolicy;)V", "muteVideoListeners", "", "Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$VideoPlayListener;", "getMuteVideoListeners", "()Ljava/util/List;", "muteVideoListeners$delegate", "Lkotlin/Lazy;", "muteVideoPlayVids", "", "getMuteVideoPlayVids", "()Ljava/util/Set;", "muteVideoPlayVids$delegate", "muteVideos", "Lcom/baidu/searchbox/feed/template/tplinterface/IBiSerialVideoPlayer;", "getMuteVideos", "muteVideos$delegate", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialMuteVideoPlayController.kt */
    public static final class ChannelItem {
        private WeakReference<PageStateAssistant> assistantRef;
        private NetChangeRunnable delayNetRunnable;
        private MuteVideoPlayRunnable delayPlayRunnable;
        private String firstVid;
        private boolean hasItemClick;
        private IBiSerialVideoHitPolicy hitPolicy = IBiSerialVideoHitPolicyKt.createDefault();
        private final Lazy muteVideoListeners$delegate = LazyKt.lazy(BiSerialMuteVideoPlayController$ChannelItem$muteVideoListeners$2.INSTANCE);
        private final Lazy muteVideoPlayVids$delegate = LazyKt.lazy(BiSerialMuteVideoPlayController$ChannelItem$muteVideoPlayVids$2.INSTANCE);
        private final Lazy muteVideos$delegate = LazyKt.lazy(BiSerialMuteVideoPlayController$ChannelItem$muteVideos$2.INSTANCE);

        public final String getFirstVid() {
            return this.firstVid;
        }

        public final void setFirstVid(String str) {
            this.firstVid = str;
        }

        public final boolean getHasItemClick() {
            return this.hasItemClick;
        }

        public final void setHasItemClick(boolean z) {
            this.hasItemClick = z;
        }

        public final Set<String> getMuteVideoPlayVids() {
            return (Set) this.muteVideoPlayVids$delegate.getValue();
        }

        public final List<IBiSerialVideoPlayer> getMuteVideos() {
            return (List) this.muteVideos$delegate.getValue();
        }

        public final List<VideoPlayListener> getMuteVideoListeners() {
            return (List) this.muteVideoListeners$delegate.getValue();
        }

        public final WeakReference<PageStateAssistant> getAssistantRef() {
            return this.assistantRef;
        }

        public final void setAssistantRef(WeakReference<PageStateAssistant> weakReference) {
            this.assistantRef = weakReference;
        }

        public final MuteVideoPlayRunnable getDelayPlayRunnable() {
            return this.delayPlayRunnable;
        }

        public final void setDelayPlayRunnable(MuteVideoPlayRunnable muteVideoPlayRunnable) {
            this.delayPlayRunnable = muteVideoPlayRunnable;
        }

        public final NetChangeRunnable getDelayNetRunnable() {
            return this.delayNetRunnable;
        }

        public final void setDelayNetRunnable(NetChangeRunnable netChangeRunnable) {
            this.delayNetRunnable = netChangeRunnable;
        }

        public final IBiSerialVideoHitPolicy getHitPolicy() {
            return this.hitPolicy;
        }

        public final void setHitPolicy(IBiSerialVideoHitPolicy iBiSerialVideoHitPolicy) {
            Intrinsics.checkNotNullParameter(iBiSerialVideoHitPolicy, "<set-?>");
            this.hitPolicy = iBiSerialVideoHitPolicy;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$MuteVideoPlayRunnable;", "Ljava/lang/Runnable;", "()V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "run", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialMuteVideoPlayController.kt */
    public static final class MuteVideoPlayRunnable implements Runnable {
        private String channelId;

        public final String getChannelId() {
            return this.channelId;
        }

        public final void setChannelId(String str) {
            this.channelId = str;
        }

        public void run() {
            BiSerialMuteVideoPlayController.INSTANCE.play(this.channelId);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$NetChangeRunnable;", "Ljava/lang/Runnable;", "()V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "run", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialMuteVideoPlayController.kt */
    public static final class NetChangeRunnable implements Runnable {
        private String channelId;

        public final String getChannelId() {
            return this.channelId;
        }

        public final void setChannelId(String str) {
            this.channelId = str;
        }

        public void run() {
            boolean isWifiConnected = NetWorkUtils.isWifiNetworkConnected();
            boolean isMobileConnected = NetWorkUtils.isMobileNetworkConnected();
            OnLineLogs.getBiSerialVideo().i("netchange  wifiConnected: " + isWifiConnected + " mobileConnected: " + isMobileConnected);
            if (isWifiConnected || isMobileConnected) {
                BiSerialMuteVideoPlayController biSerialMuteVideoPlayController = BiSerialMuteVideoPlayController.INSTANCE;
                String str = this.channelId;
                Intrinsics.checkNotNull(str);
                biSerialMuteVideoPlayController.play(str);
                return;
            }
            BiSerialMuteVideoPlayController biSerialMuteVideoPlayController2 = BiSerialMuteVideoPlayController.INSTANCE;
            String str2 = this.channelId;
            Intrinsics.checkNotNull(str2);
            biSerialMuteVideoPlayController2.pause(str2);
        }
    }

    private final void withChannelItem(String channelId, Function1<? super ChannelItem, Unit> func) {
        CharSequence charSequence = channelId;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            OnLineLogs.getBiSerialVideo().e("channelId为空");
            return;
        }
        HashMap<String, ChannelItem> hashMap = channelItems;
        ChannelItem item = hashMap.get(channelId);
        if (item == null) {
            item = new ChannelItem();
            hashMap.put(channelId, item);
        }
        func.invoke(item);
    }

    public final void setFirstVid(String channelId, String firstVid) {
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$setFirstVid$1(firstVid));
    }

    public final void setItemClick(String channelId, boolean isClick) {
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$setItemClick$1(isClick));
    }

    public final boolean hasItemClick(String channelId) {
        Ref.BooleanRef hasClick = new Ref.BooleanRef();
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$hasItemClick$1(hasClick));
        return hasClick.element;
    }

    public final int getVideoPlayCount(String channelId) {
        Ref.IntRef count = new Ref.IntRef();
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$getVideoPlayCount$1(count));
        return count.element;
    }

    public final void setVideoHitPolicy(String channelId, IBiSerialVideoHitPolicy policy) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(policy, ConfigImpl.JSONConstant.POLICY);
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$setVideoHitPolicy$1(policy));
    }

    public final void registerVideoPlayer(String channelId, IBiSerialVideoPlayer player) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(player, "player");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$registerVideoPlayer$1(player));
    }

    public final void unregisterVideoPlayer(String channelId, @Nonnull IBiSerialVideoPlayer player) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(player, "player");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$unregisterVideoPlayer$1(player));
    }

    public final void unregisterVideoPlayers(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, BiSerialMuteVideoPlayController$unregisterVideoPlayers$1.INSTANCE);
    }

    public final void registerVideoPlayListener(String channelId, @Nonnull VideoPlayListener listener) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$registerVideoPlayListener$1(listener));
    }

    public final void unregisterVideoPlayListener(String channelId, @Nonnull VideoPlayListener listener) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$unregisterVideoPlayListener$1(listener));
    }

    public final void unregisterVideoPlayListeners(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, BiSerialMuteVideoPlayController$unregisterVideoPlayListeners$1.INSTANCE);
    }

    public final void setAssistantHolder(String channelId, PageStateAssistant pageStateHolder) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(pageStateHolder, "pageStateHolder");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$setAssistantHolder$1(pageStateHolder));
    }

    public final void netChangeOnDelay(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$netChangeOnDelay$1(channelId));
    }

    public final void playOnDelay(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$playOnDelay$1(channelId));
    }

    public final void playOnScroll(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, BiSerialMuteVideoPlayController$playOnScroll$1.INSTANCE);
    }

    public final void play(String channelId) {
        withChannelItem(channelId, BiSerialMuteVideoPlayController$play$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final boolean findPlayingOnVisibleScale(ChannelItem item) {
        boolean isFound = false;
        for (IBiSerialVideoPlayer player : item.getMuteVideos()) {
            if (player.isPlaying()) {
                if (isFound || !player.matchPlayConfigure()) {
                    player.stop();
                } else {
                    isFound = true;
                }
            }
        }
        return isFound;
    }

    public final void pause(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, BiSerialMuteVideoPlayController$pause$1.INSTANCE);
    }

    public final void stop(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, BiSerialMuteVideoPlayController$stop$1.INSTANCE);
    }

    public final boolean hasPlaying(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Ref.BooleanRef hasPlaying = new Ref.BooleanRef();
        withChannelItem(channelId, new BiSerialMuteVideoPlayController$hasPlaying$1(hasPlaying));
        return hasPlaying.element;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$VideoPlayListener;", "", "onStartAutoPlay", "", "entity", "Lcom/baidu/searchbox/feed/model/FeedItemDataTabVideo$VideoInfoEntity;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialMuteVideoPlayController.kt */
    public interface VideoPlayListener {
        void onStartAutoPlay(FeedItemDataTabVideo.VideoInfoEntity videoInfoEntity);

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BiSerialMuteVideoPlayController.kt */
        public static final class DefaultImpls {
            public static void onStartAutoPlay(VideoPlayListener videoPlayListener, FeedItemDataTabVideo.VideoInfoEntity entity) {
            }
        }
    }

    public final void handlePlayerDetach(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        withChannelItem(channelId, BiSerialMuteVideoPlayController$handlePlayerDetach$1.INSTANCE);
    }
}
