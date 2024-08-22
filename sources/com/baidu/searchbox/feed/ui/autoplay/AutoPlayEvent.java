package com.baidu.searchbox.feed.ui.autoplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\t\n\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "", "()V", "bizUniqueKey", "", "getBizUniqueKey", "()Ljava/lang/String;", "setBizUniqueKey", "(Ljava/lang/String;)V", "AutoPlay", "PausePlay", "PlayNext", "Regist", "ResumePlay", "UnRegist", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$Regist;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$UnRegist;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$AutoPlay;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$PlayNext;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$PausePlay;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$ResumePlay;", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoPlayEvent.kt */
public abstract class AutoPlayEvent {
    private String bizUniqueKey;

    public /* synthetic */ AutoPlayEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AutoPlayEvent() {
    }

    public final String getBizUniqueKey() {
        return this.bizUniqueKey;
    }

    public final void setBizUniqueKey(String str) {
        this.bizUniqueKey = str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$Regist;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "()V", "player", "Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;", "getPlayer", "()Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;", "setPlayer", "(Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;)V", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AutoPlayEvent.kt */
    public static final class Regist extends AutoPlayEvent {
        private IAutoPlay player;

        public Regist() {
            super((DefaultConstructorMarker) null);
        }

        public final IAutoPlay getPlayer() {
            return this.player;
        }

        public final void setPlayer(IAutoPlay iAutoPlay) {
            this.player = iAutoPlay;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$UnRegist;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "()V", "player", "Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;", "getPlayer", "()Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;", "setPlayer", "(Lcom/baidu/searchbox/feed/ui/autoplay/IAutoPlay;)V", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AutoPlayEvent.kt */
    public static final class UnRegist extends AutoPlayEvent {
        private IAutoPlay player;

        public UnRegist() {
            super((DefaultConstructorMarker) null);
        }

        public final IAutoPlay getPlayer() {
            return this.player;
        }

        public final void setPlayer(IAutoPlay iAutoPlay) {
            this.player = iAutoPlay;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$AutoPlay;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "()V", "isTrigger", "", "()Z", "setTrigger", "(Z)V", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AutoPlayEvent.kt */
    public static final class AutoPlay extends AutoPlayEvent {
        private boolean isTrigger;

        public AutoPlay() {
            super((DefaultConstructorMarker) null);
        }

        public final boolean isTrigger() {
            return this.isTrigger;
        }

        public final void setTrigger(boolean z) {
            this.isTrigger = z;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$PlayNext;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "()V", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AutoPlayEvent.kt */
    public static final class PlayNext extends AutoPlayEvent {
        public static final PlayNext INSTANCE = new PlayNext();

        private PlayNext() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$PausePlay;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "()V", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AutoPlayEvent.kt */
    public static final class PausePlay extends AutoPlayEvent {
        public PausePlay() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent$ResumePlay;", "Lcom/baidu/searchbox/feed/ui/autoplay/AutoPlayEvent;", "()V", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AutoPlayEvent.kt */
    public static final class ResumePlay extends AutoPlayEvent {
        public ResumePlay() {
            super((DefaultConstructorMarker) null);
        }
    }
}
