package com.baidu.searchbox.dynamicpublisher.uploadvideo;

import com.baidu.searchbox.dynamicpublisher.video.VideoModel;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.ugc.model.VideoUploadInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "CollectData", "RestoreData", "SendData", "UploadVideo", "UploadVideoFail", "UploadVideoProgress", "UploadVideoSuccess", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideo;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideoProgress;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideoSuccess;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideoFail;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$CollectData;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$SendData;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$RestoreData;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UploadVideoAction.kt */
public abstract class UploadVideoAction implements Action {
    public /* synthetic */ UploadVideoAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private UploadVideoAction() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideo;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "videoModel", "Lcom/baidu/searchbox/dynamicpublisher/video/VideoModel;", "(Lcom/baidu/searchbox/dynamicpublisher/video/VideoModel;)V", "getVideoModel", "()Lcom/baidu/searchbox/dynamicpublisher/video/VideoModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class UploadVideo extends UploadVideoAction {
        private final VideoModel videoModel;

        public static /* synthetic */ UploadVideo copy$default(UploadVideo uploadVideo, VideoModel videoModel2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                videoModel2 = uploadVideo.videoModel;
            }
            return uploadVideo.copy(videoModel2);
        }

        public final VideoModel component1() {
            return this.videoModel;
        }

        public final UploadVideo copy(VideoModel videoModel2) {
            return new UploadVideo(videoModel2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UploadVideo) && Intrinsics.areEqual((Object) this.videoModel, (Object) ((UploadVideo) obj).videoModel);
        }

        public int hashCode() {
            VideoModel videoModel2 = this.videoModel;
            if (videoModel2 == null) {
                return 0;
            }
            return videoModel2.hashCode();
        }

        public String toString() {
            return "UploadVideo(videoModel=" + this.videoModel + ')';
        }

        public UploadVideo(VideoModel videoModel2) {
            super((DefaultConstructorMarker) null);
            this.videoModel = videoModel2;
        }

        public final VideoModel getVideoModel() {
            return this.videoModel;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideoProgress;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "progressValue", "", "progressMax", "(JJ)V", "getProgressMax", "()J", "getProgressValue", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class UploadVideoProgress extends UploadVideoAction {
        private final long progressMax;
        private final long progressValue;

        public static /* synthetic */ UploadVideoProgress copy$default(UploadVideoProgress uploadVideoProgress, long j2, long j3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j2 = uploadVideoProgress.progressValue;
            }
            if ((i2 & 2) != 0) {
                j3 = uploadVideoProgress.progressMax;
            }
            return uploadVideoProgress.copy(j2, j3);
        }

        public final long component1() {
            return this.progressValue;
        }

        public final long component2() {
            return this.progressMax;
        }

        public final UploadVideoProgress copy(long j2, long j3) {
            return new UploadVideoProgress(j2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UploadVideoProgress)) {
                return false;
            }
            UploadVideoProgress uploadVideoProgress = (UploadVideoProgress) obj;
            return this.progressValue == uploadVideoProgress.progressValue && this.progressMax == uploadVideoProgress.progressMax;
        }

        public int hashCode() {
            return (Long.hashCode(this.progressValue) * 31) + Long.hashCode(this.progressMax);
        }

        public String toString() {
            return "UploadVideoProgress(progressValue=" + this.progressValue + ", progressMax=" + this.progressMax + ')';
        }

        public UploadVideoProgress(long progressValue2, long progressMax2) {
            super((DefaultConstructorMarker) null);
            this.progressValue = progressValue2;
            this.progressMax = progressMax2;
        }

        public final long getProgressMax() {
            return this.progressMax;
        }

        public final long getProgressValue() {
            return this.progressValue;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideoSuccess;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class UploadVideoSuccess extends UploadVideoAction {
        private final String mediaId;

        public UploadVideoSuccess() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ UploadVideoSuccess copy$default(UploadVideoSuccess uploadVideoSuccess, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = uploadVideoSuccess.mediaId;
            }
            return uploadVideoSuccess.copy(str);
        }

        public final String component1() {
            return this.mediaId;
        }

        public final UploadVideoSuccess copy(String str) {
            return new UploadVideoSuccess(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UploadVideoSuccess) && Intrinsics.areEqual((Object) this.mediaId, (Object) ((UploadVideoSuccess) obj).mediaId);
        }

        public int hashCode() {
            String str = this.mediaId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "UploadVideoSuccess(mediaId=" + this.mediaId + ')';
        }

        public UploadVideoSuccess(String mediaId2) {
            super((DefaultConstructorMarker) null);
            this.mediaId = mediaId2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UploadVideoSuccess(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str);
        }

        public final String getMediaId() {
            return this.mediaId;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$UploadVideoFail;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class UploadVideoFail extends UploadVideoAction {
        public static final UploadVideoFail INSTANCE = new UploadVideoFail();

        private UploadVideoFail() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$CollectData;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class CollectData extends UploadVideoAction {
        public static final CollectData INSTANCE = new CollectData();

        private CollectData() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$SendData;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "mediaIdMap", "", "", "Lcom/baidu/searchbox/ugc/model/VideoUploadInfo;", "(Ljava/util/Map;)V", "getMediaIdMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class SendData extends UploadVideoAction {
        private final Map<String, VideoUploadInfo> mediaIdMap;

        public SendData() {
            this((Map) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SendData copy$default(SendData sendData, Map<String, VideoUploadInfo> map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                map = sendData.mediaIdMap;
            }
            return sendData.copy(map);
        }

        public final Map<String, VideoUploadInfo> component1() {
            return this.mediaIdMap;
        }

        public final SendData copy(Map<String, VideoUploadInfo> map) {
            return new SendData(map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SendData) && Intrinsics.areEqual((Object) this.mediaIdMap, (Object) ((SendData) obj).mediaIdMap);
        }

        public int hashCode() {
            Map<String, VideoUploadInfo> map = this.mediaIdMap;
            if (map == null) {
                return 0;
            }
            return map.hashCode();
        }

        public String toString() {
            return "SendData(mediaIdMap=" + this.mediaIdMap + ')';
        }

        public SendData(Map<String, VideoUploadInfo> mediaIdMap2) {
            super((DefaultConstructorMarker) null);
            this.mediaIdMap = mediaIdMap2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SendData(Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, VideoUploadInfo> getMediaIdMap() {
            return this.mediaIdMap;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction$RestoreData;", "Lcom/baidu/searchbox/dynamicpublisher/uploadvideo/UploadVideoAction;", "mediaIdMap", "", "", "Lcom/baidu/searchbox/ugc/model/VideoUploadInfo;", "(Ljava/util/Map;)V", "getMediaIdMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UploadVideoAction.kt */
    public static final class RestoreData extends UploadVideoAction {
        private final Map<String, VideoUploadInfo> mediaIdMap;

        public RestoreData() {
            this((Map) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RestoreData copy$default(RestoreData restoreData, Map<String, VideoUploadInfo> map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                map = restoreData.mediaIdMap;
            }
            return restoreData.copy(map);
        }

        public final Map<String, VideoUploadInfo> component1() {
            return this.mediaIdMap;
        }

        public final RestoreData copy(Map<String, VideoUploadInfo> map) {
            return new RestoreData(map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RestoreData) && Intrinsics.areEqual((Object) this.mediaIdMap, (Object) ((RestoreData) obj).mediaIdMap);
        }

        public int hashCode() {
            Map<String, VideoUploadInfo> map = this.mediaIdMap;
            if (map == null) {
                return 0;
            }
            return map.hashCode();
        }

        public String toString() {
            return "RestoreData(mediaIdMap=" + this.mediaIdMap + ')';
        }

        public RestoreData(Map<String, VideoUploadInfo> mediaIdMap2) {
            super((DefaultConstructorMarker) null);
            this.mediaIdMap = mediaIdMap2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RestoreData(Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, VideoUploadInfo> getMediaIdMap() {
            return this.mediaIdMap;
        }
    }
}
