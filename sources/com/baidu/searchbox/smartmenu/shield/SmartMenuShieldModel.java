package com.baidu.searchbox.smartmenu.shield;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.history.api.data.HistoryFeature;
import com.baidu.searchbox.history.api.data.HistoryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020\nH\u0016J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldModel;", "", "()V", "logLastModifiedTime", "", "getLogLastModifiedTime", "()J", "setLogLastModifiedTime", "(J)V", "showCount", "", "getShowCount", "()I", "setShowCount", "(I)V", "timeStamp", "getTimeStamp", "setTimeStamp", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldType;", "getType", "()Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldType;", "setType", "(Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldType;)V", "uKey", "getUKey", "setUKey", "videoDownloadUrl", "getVideoDownloadUrl", "setVideoDownloadUrl", "equals", "", "other", "hashCode", "processTitleString", "input", "processUKeyAndUrlString", "Companion", "lib-smart-menu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuShieldModel.kt */
public final class SmartMenuShieldModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SEPARATOR = "|#|#|";
    private long logLastModifiedTime;
    private int showCount;
    private long timeStamp;
    private String title = "";
    private SmartMenuShieldType type = SmartMenuShieldType.HISTORY;
    private String uKey = "";
    private String videoDownloadUrl = "";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldModel$Companion;", "", "()V", "SEPARATOR", "", "createModelFromDownload", "Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldModel;", "downloadItem", "Lcom/baidu/searchbox/downloadcenter/service/models/SmartMenuDownloadItem;", "createModelFromFavor", "favorMode", "Lcom/baidu/searchbox/favor/data/FavorModel;", "createModelFromHistory", "historyModel", "Lcom/baidu/searchbox/history/api/data/HistoryModel;", "fromCombinedString", "data", "toCombinedString", "item", "lib-smart-menu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SmartMenuShieldModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toCombinedString(SmartMenuShieldModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(item.getType(), String.valueOf(item.getTimeStamp()), item.getUKey(), item.getTitle(), item.getVideoDownloadUrl(), String.valueOf(item.getShowCount()), String.valueOf(item.getLogLastModifiedTime())), SmartMenuShieldModel.SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        public final SmartMenuShieldModel fromCombinedString(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                List parts = StringsKt.split$default((CharSequence) data, new String[]{SmartMenuShieldModel.SEPARATOR}, false, 0, 6, (Object) null);
                if (parts.size() != 7) {
                    return null;
                }
                SmartMenuShieldModel smartMenuShieldModel = new SmartMenuShieldModel();
                SmartMenuShieldModel $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0 = smartMenuShieldModel;
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setType(SmartMenuShieldType.valueOf((String) parts.get(0)));
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setTimeStamp(Long.parseLong((String) parts.get(1)));
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setUKey((String) parts.get(2));
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setTitle((String) parts.get(3));
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setVideoDownloadUrl((String) parts.get(4));
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setShowCount(Integer.parseInt((String) parts.get(5)));
                $this$fromCombinedString_u24lambda_u2d1_u24lambda_u2d0.setLogLastModifiedTime(Long.parseLong((String) parts.get(6)));
                return smartMenuShieldModel;
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
                return null;
            }
        }

        public final SmartMenuShieldModel createModelFromHistory(HistoryModel historyModel) {
            HistoryFeature feature;
            String it;
            if (historyModel == null) {
                return null;
            }
            String str = "";
            String tplId = historyModel.getTplId();
            CharSequence charSequence = tplId;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0) && !((!Intrinsics.areEqual((Object) tplId, (Object) "search_web_video") && !Intrinsics.areEqual((Object) tplId, (Object) "search_web_film")) || (feature = historyModel.getFeature()) == null || (it = feature.getSmoothVideoParameterJson()) == null)) {
                try {
                    String url = new JSONObject(it).optString("videoUrl");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    if (url.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        str = url;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            SmartMenuShieldModel smartMenuShieldModel = new SmartMenuShieldModel();
            SmartMenuShieldModel $this$createModelFromHistory_u24lambda_u2d3 = smartMenuShieldModel;
            $this$createModelFromHistory_u24lambda_u2d3.setType(SmartMenuShieldType.HISTORY);
            $this$createModelFromHistory_u24lambda_u2d3.setTimeStamp(historyModel.getCreateTime());
            String ukey = historyModel.getUkey();
            String str2 = "";
            if (ukey == null) {
                ukey = str2;
            }
            $this$createModelFromHistory_u24lambda_u2d3.setUKey($this$createModelFromHistory_u24lambda_u2d3.processUKeyAndUrlString(ukey));
            String title = historyModel.getTitle();
            if (title != null) {
                str2 = title;
            }
            $this$createModelFromHistory_u24lambda_u2d3.setTitle($this$createModelFromHistory_u24lambda_u2d3.processTitleString(str2));
            $this$createModelFromHistory_u24lambda_u2d3.setVideoDownloadUrl($this$createModelFromHistory_u24lambda_u2d3.processUKeyAndUrlString(str));
            return smartMenuShieldModel;
        }

        public final SmartMenuShieldModel createModelFromDownload(SmartMenuDownloadItem downloadItem) {
            if (downloadItem == null) {
                return null;
            }
            SmartMenuShieldModel smartMenuShieldModel = new SmartMenuShieldModel();
            SmartMenuShieldModel $this$createModelFromDownload_u24lambda_u2d4 = smartMenuShieldModel;
            $this$createModelFromDownload_u24lambda_u2d4.setType(SmartMenuShieldType.DOWNLOAD);
            $this$createModelFromDownload_u24lambda_u2d4.setTimeStamp(downloadItem.getDownloadTime());
            $this$createModelFromDownload_u24lambda_u2d4.setUKey($this$createModelFromDownload_u24lambda_u2d4.processUKeyAndUrlString(String.valueOf(downloadItem.getId())));
            $this$createModelFromDownload_u24lambda_u2d4.setTitle($this$createModelFromDownload_u24lambda_u2d4.processTitleString(downloadItem.getFileName()));
            $this$createModelFromDownload_u24lambda_u2d4.setVideoDownloadUrl($this$createModelFromDownload_u24lambda_u2d4.processUKeyAndUrlString(downloadItem.getOrginalUrl()));
            return smartMenuShieldModel;
        }

        public final SmartMenuShieldModel createModelFromFavor(FavorModel favorMode) {
            FavorModel.Feature feature;
            String it;
            if (favorMode == null) {
                return null;
            }
            String str = "";
            String tplId = favorMode.tplId;
            CharSequence charSequence = tplId;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0) && !((!Intrinsics.areEqual((Object) tplId, (Object) "search_web_video") && !Intrinsics.areEqual((Object) tplId, (Object) "search_web_film")) || (feature = favorMode.feature) == null || (it = feature.smoothVideoParameterJson) == null)) {
                try {
                    String url = new JSONObject(it).optString("videoUrl");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    if (url.length() > 0) {
                        z = true;
                    }
                    if (z) {
                        str = url;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            SmartMenuShieldModel smartMenuShieldModel = new SmartMenuShieldModel();
            SmartMenuShieldModel $this$createModelFromFavor_u24lambda_u2d6 = smartMenuShieldModel;
            $this$createModelFromFavor_u24lambda_u2d6.setType(SmartMenuShieldType.FAVOR);
            String str2 = favorMode.createTime;
            Intrinsics.checkNotNullExpressionValue(str2, "favorMode.createTime");
            Long longOrNull = StringsKt.toLongOrNull(str2);
            $this$createModelFromFavor_u24lambda_u2d6.setTimeStamp(longOrNull != null ? longOrNull.longValue() : 0);
            String str3 = "";
            $this$createModelFromFavor_u24lambda_u2d6.setUKey(str3);
            String str4 = favorMode.title;
            if (str4 != null) {
                Intrinsics.checkNotNullExpressionValue(str4, "favorMode.title ?: \"\"");
                str3 = str4;
            }
            $this$createModelFromFavor_u24lambda_u2d6.setTitle($this$createModelFromFavor_u24lambda_u2d6.processTitleString(str3));
            $this$createModelFromFavor_u24lambda_u2d6.setVideoDownloadUrl($this$createModelFromFavor_u24lambda_u2d6.processUKeyAndUrlString(str));
            return smartMenuShieldModel;
        }
    }

    public final SmartMenuShieldType getType() {
        return this.type;
    }

    public final void setType(SmartMenuShieldType smartMenuShieldType) {
        Intrinsics.checkNotNullParameter(smartMenuShieldType, "<set-?>");
        this.type = smartMenuShieldType;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final void setTimeStamp(long j2) {
        this.timeStamp = j2;
    }

    public final String getUKey() {
        return this.uKey;
    }

    public final void setUKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uKey = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getVideoDownloadUrl() {
        return this.videoDownloadUrl;
    }

    public final void setVideoDownloadUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoDownloadUrl = str;
    }

    public final int getShowCount() {
        return this.showCount;
    }

    public final void setShowCount(int i2) {
        this.showCount = i2;
    }

    public final long getLogLastModifiedTime() {
        return this.logLastModifiedTime;
    }

    public final void setLogLastModifiedTime(long j2) {
        this.logLastModifiedTime = j2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmartMenuShieldModel)) {
            return false;
        }
        if ((this.uKey.length() > 0) && Intrinsics.areEqual((Object) this.uKey, (Object) ((SmartMenuShieldModel) other).uKey)) {
            return true;
        }
        if ((this.title.length() > 0) && Intrinsics.areEqual((Object) this.title, (Object) ((SmartMenuShieldModel) other).title)) {
            return true;
        }
        if (!(this.videoDownloadUrl.length() > 0) || !Intrinsics.areEqual((Object) this.videoDownloadUrl, (Object) ((SmartMenuShieldModel) other).videoDownloadUrl)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((this.type.hashCode() * 31) + Long.hashCode(this.timeStamp)) * 31) + this.uKey.hashCode()) * 31) + this.title.hashCode()) * 31) + this.videoDownloadUrl.hashCode()) * 31) + this.showCount) * 31) + Long.hashCode(this.logLastModifiedTime);
    }

    public final String processTitleString(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() <= 50) {
            return input;
        }
        String substring = input.substring(0, 50);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String processUKeyAndUrlString(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() <= 2048) {
            return input;
        }
        String substring = input.substring(0, 2048);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
