package com.baidu.searchbox.account.userinfo;

import com.baidu.searchbox.datachannel.DataChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr;", "", "()V", "hasRegisteredVideoEditAction", "", "hasRegisteredVideoUpdateAction", "shortVideosPaidCallback", "Lkotlin/Function1;", "Lcom/baidu/searchbox/account/userinfo/ShortVideosPaidAction;", "Lkotlin/ParameterName;", "name", "paidAction", "", "getShortVideosPaidCallback", "()Lkotlin/jvm/functions/Function1;", "setShortVideosPaidCallback", "(Lkotlin/jvm/functions/Function1;)V", "videoEditCallback", "Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr$VideoEditData;", "data", "getVideoEditCallback", "setVideoEditCallback", "registerFeedItemUpdateAction", "registerVideoEditAction", "release", "VideoEditData", "VideoEditTypeEnum", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageVideoDataChannelMgr.kt */
public final class PersonalPageVideoDataChannelMgr {
    private boolean hasRegisteredVideoEditAction;
    private boolean hasRegisteredVideoUpdateAction;
    private Function1<? super ShortVideosPaidAction, Unit> shortVideosPaidCallback;
    private Function1<? super VideoEditData, Unit> videoEditCallback;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr$VideoEditTypeEnum;", "", "(Ljava/lang/String;I)V", "EDIT", "DELETE", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalPageVideoDataChannelMgr.kt */
    public enum VideoEditTypeEnum {
        EDIT,
        DELETE
    }

    public final Function1<VideoEditData, Unit> getVideoEditCallback() {
        return this.videoEditCallback;
    }

    public final void setVideoEditCallback(Function1<? super VideoEditData, Unit> function1) {
        this.videoEditCallback = function1;
    }

    public final Function1<ShortVideosPaidAction, Unit> getShortVideosPaidCallback() {
        return this.shortVideosPaidCallback;
    }

    public final void setShortVideosPaidCallback(Function1<? super ShortVideosPaidAction, Unit> function1) {
        this.shortVideosPaidCallback = function1;
    }

    public final void registerVideoEditAction() {
        if (!this.hasRegisteredVideoEditAction) {
            this.hasRegisteredVideoEditAction = true;
            DataChannel.Registry.registerNAReceiver((String) null, (String) null, "com.baidu.channel.ugc.editordelete", new PersonalPageVideoDataChannelMgr$registerVideoEditAction$1(this));
        }
    }

    public final void registerFeedItemUpdateAction() {
        if (!this.hasRegisteredVideoUpdateAction) {
            this.hasRegisteredVideoUpdateAction = true;
            DataChannel.Registry.registerNAReceiver((String) null, (String) null, "com.baidu.channel.feed.assistmessage", new PersonalPageVideoDataChannelMgr$registerFeedItemUpdateAction$1(this));
        }
    }

    public final void release() {
        DataChannel.Registry.unregisterReceiver((String) null, (String) null, "com.baidu.channel.ugc.editordelete");
        DataChannel.Registry.unregisterReceiver((String) null, (String) null, "com.baidu.channel.feed.assistmessage");
        this.hasRegisteredVideoEditAction = false;
        this.hasRegisteredVideoUpdateAction = false;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr$VideoEditData;", "", "type", "Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr$VideoEditTypeEnum;", "feedId", "", "(Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr$VideoEditTypeEnum;Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "getType", "()Lcom/baidu/searchbox/account/userinfo/PersonalPageVideoDataChannelMgr$VideoEditTypeEnum;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalPageVideoDataChannelMgr.kt */
    public static final class VideoEditData {
        private final String feedId;
        private final VideoEditTypeEnum type;

        public static /* synthetic */ VideoEditData copy$default(VideoEditData videoEditData, VideoEditTypeEnum videoEditTypeEnum, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                videoEditTypeEnum = videoEditData.type;
            }
            if ((i2 & 2) != 0) {
                str = videoEditData.feedId;
            }
            return videoEditData.copy(videoEditTypeEnum, str);
        }

        public final VideoEditTypeEnum component1() {
            return this.type;
        }

        public final String component2() {
            return this.feedId;
        }

        public final VideoEditData copy(VideoEditTypeEnum videoEditTypeEnum, String str) {
            Intrinsics.checkNotNullParameter(videoEditTypeEnum, "type");
            Intrinsics.checkNotNullParameter(str, "feedId");
            return new VideoEditData(videoEditTypeEnum, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VideoEditData)) {
                return false;
            }
            VideoEditData videoEditData = (VideoEditData) obj;
            return this.type == videoEditData.type && Intrinsics.areEqual((Object) this.feedId, (Object) videoEditData.feedId);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.feedId.hashCode();
        }

        public String toString() {
            return "VideoEditData(type=" + this.type + ", feedId=" + this.feedId + ')';
        }

        public VideoEditData(VideoEditTypeEnum type2, String feedId2) {
            Intrinsics.checkNotNullParameter(type2, "type");
            Intrinsics.checkNotNullParameter(feedId2, "feedId");
            this.type = type2;
            this.feedId = feedId2;
        }

        public final VideoEditTypeEnum getType() {
            return this.type;
        }

        public final String getFeedId() {
            return this.feedId;
        }
    }
}
