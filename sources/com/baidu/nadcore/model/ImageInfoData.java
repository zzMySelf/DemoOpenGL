package com.baidu.nadcore.model;

import com.baidu.searchbox.feed.model.FeedItemDataHotSearchFooter;
import com.baidu.swan.game.ad.downloader.db.DownloadDBOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\b\u0018\u0000 12\u00020\u0001:\u00011B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÂ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jk\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\u0006\u0010,\u001a\u00020&J\u0006\u0010-\u001a\u00020&J\u0006\u0010.\u001a\u00020&J\u0006\u0010/\u001a\u00020&J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u00062"}, d2 = {"Lcom/baidu/nadcore/model/ImageInfoData;", "", "imageStyle", "", "url", "chargeDuration", "", "scrollChargeSwitch", "downloadData", "Lcom/baidu/nadcore/model/AdDownloadInfo;", "imageList", "", "Lcom/baidu/nadcore/model/ImageItem;", "imageBg", "title", "titleColor", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/baidu/nadcore/model/AdDownloadInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDownloadData", "()Lcom/baidu/nadcore/model/AdDownloadInfo;", "getImageBg", "()Ljava/lang/String;", "getImageList", "()Ljava/util/List;", "getImageStyle", "getTitle", "getTitleColor", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getChargeDuration", "", "getImageStyleChargeModify", "hashCode", "isNewImageStyle", "isOldImageStyle", "isVerticalImageStyle", "supportScrollCharge", "toString", "Companion", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdRewardVideoLpModel.kt */
public final class ImageInfoData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int chargeDuration;
    private final AdDownloadInfo downloadData;
    private final String imageBg;
    private final List<ImageItem> imageList;
    private final String imageStyle;
    private final String scrollChargeSwitch;
    private final String title;
    private final String titleColor;
    private final String url;

    private final int component3() {
        return this.chargeDuration;
    }

    private final String component4() {
        return this.scrollChargeSwitch;
    }

    public static /* synthetic */ ImageInfoData copy$default(ImageInfoData imageInfoData, String str, String str2, int i2, String str3, AdDownloadInfo adDownloadInfo, List list, String str4, String str5, String str6, int i3, Object obj) {
        ImageInfoData imageInfoData2 = imageInfoData;
        int i4 = i3;
        return imageInfoData.copy((i4 & 1) != 0 ? imageInfoData2.imageStyle : str, (i4 & 2) != 0 ? imageInfoData2.url : str2, (i4 & 4) != 0 ? imageInfoData2.chargeDuration : i2, (i4 & 8) != 0 ? imageInfoData2.scrollChargeSwitch : str3, (i4 & 16) != 0 ? imageInfoData2.downloadData : adDownloadInfo, (i4 & 32) != 0 ? imageInfoData2.imageList : list, (i4 & 64) != 0 ? imageInfoData2.imageBg : str4, (i4 & 128) != 0 ? imageInfoData2.title : str5, (i4 & 256) != 0 ? imageInfoData2.titleColor : str6);
    }

    @JvmStatic
    public static final ImageInfoData fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final String component1() {
        return this.imageStyle;
    }

    public final String component2() {
        return this.url;
    }

    public final AdDownloadInfo component5() {
        return this.downloadData;
    }

    public final List<ImageItem> component6() {
        return this.imageList;
    }

    public final String component7() {
        return this.imageBg;
    }

    public final String component8() {
        return this.title;
    }

    public final String component9() {
        return this.titleColor;
    }

    public final ImageInfoData copy(String str, String str2, int i2, String str3, AdDownloadInfo adDownloadInfo, List<ImageItem> list, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "imageStyle");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "scrollChargeSwitch");
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(str4, "imageBg");
        Intrinsics.checkNotNullParameter(str5, "title");
        Intrinsics.checkNotNullParameter(str6, "titleColor");
        return new ImageInfoData(str, str2, i2, str3, adDownloadInfo, list, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageInfoData)) {
            return false;
        }
        ImageInfoData imageInfoData = (ImageInfoData) obj;
        return Intrinsics.areEqual((Object) this.imageStyle, (Object) imageInfoData.imageStyle) && Intrinsics.areEqual((Object) this.url, (Object) imageInfoData.url) && this.chargeDuration == imageInfoData.chargeDuration && Intrinsics.areEqual((Object) this.scrollChargeSwitch, (Object) imageInfoData.scrollChargeSwitch) && Intrinsics.areEqual((Object) this.downloadData, (Object) imageInfoData.downloadData) && Intrinsics.areEqual((Object) this.imageList, (Object) imageInfoData.imageList) && Intrinsics.areEqual((Object) this.imageBg, (Object) imageInfoData.imageBg) && Intrinsics.areEqual((Object) this.title, (Object) imageInfoData.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) imageInfoData.titleColor);
    }

    public int hashCode() {
        int hashCode = ((((((this.imageStyle.hashCode() * 31) + this.url.hashCode()) * 31) + Integer.hashCode(this.chargeDuration)) * 31) + this.scrollChargeSwitch.hashCode()) * 31;
        AdDownloadInfo adDownloadInfo = this.downloadData;
        return ((((((((hashCode + (adDownloadInfo == null ? 0 : adDownloadInfo.hashCode())) * 31) + this.imageList.hashCode()) * 31) + this.imageBg.hashCode()) * 31) + this.title.hashCode()) * 31) + this.titleColor.hashCode();
    }

    public String toString() {
        return "ImageInfoData(imageStyle=" + this.imageStyle + ", url=" + this.url + ", chargeDuration=" + this.chargeDuration + ", scrollChargeSwitch=" + this.scrollChargeSwitch + ", downloadData=" + this.downloadData + ", imageList=" + this.imageList + ", imageBg=" + this.imageBg + ", title=" + this.title + ", titleColor=" + this.titleColor + ')';
    }

    public ImageInfoData(String imageStyle2, String url2, int chargeDuration2, String scrollChargeSwitch2, AdDownloadInfo downloadData2, List<ImageItem> imageList2, String imageBg2, String title2, String titleColor2) {
        Intrinsics.checkNotNullParameter(imageStyle2, "imageStyle");
        Intrinsics.checkNotNullParameter(url2, "url");
        Intrinsics.checkNotNullParameter(scrollChargeSwitch2, "scrollChargeSwitch");
        Intrinsics.checkNotNullParameter(imageList2, "imageList");
        Intrinsics.checkNotNullParameter(imageBg2, "imageBg");
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(titleColor2, "titleColor");
        this.imageStyle = imageStyle2;
        this.url = url2;
        this.chargeDuration = chargeDuration2;
        this.scrollChargeSwitch = scrollChargeSwitch2;
        this.downloadData = downloadData2;
        this.imageList = imageList2;
        this.imageBg = imageBg2;
        this.title = title2;
        this.titleColor = titleColor2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageInfoData(String str, String str2, int i2, String str3, AdDownloadInfo adDownloadInfo, List list, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? 0 : i2, str3, (i3 & 16) != 0 ? null : adDownloadInfo, (i3 & 32) != 0 ? new ArrayList() : list, str4, str5, str6);
    }

    public final String getImageStyle() {
        return this.imageStyle;
    }

    public final String getUrl() {
        return this.url;
    }

    public final AdDownloadInfo getDownloadData() {
        return this.downloadData;
    }

    public final List<ImageItem> getImageList() {
        return this.imageList;
    }

    public final String getImageBg() {
        return this.imageBg;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/baidu/nadcore/model/ImageInfoData$Companion;", "", "()V", "fromJson", "Lcom/baidu/nadcore/model/ImageInfoData;", "jsonObject", "Lorg/json/JSONObject;", "imageListFromJsonArray", "", "Lcom/baidu/nadcore/model/ImageItem;", "jsonArray", "Lorg/json/JSONArray;", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdRewardVideoLpModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageInfoData fromJson(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            JSONObject $this$fromJson_u24lambda_u2d0 = jsonObject;
            String optString = $this$fromJson_u24lambda_u2d0.optString("image_info_style", "0");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"image_info_style\", \"0\")");
            String optString2 = $this$fromJson_u24lambda_u2d0.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"url\")");
            int optInt = $this$fromJson_u24lambda_u2d0.optInt("image_style_charge_duration");
            String optString3 = $this$fromJson_u24lambda_u2d0.optString("image_style_scroll_charge_switch");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"image_style_scroll_charge_switch\")");
            AdDownloadInfo createWithNewDataStruct = AdDownloadInfo.createWithNewDataStruct($this$fromJson_u24lambda_u2d0.optJSONObject(DownloadDBOpenHelper.TABLE_NAME_DOWNLOAD_INFO));
            List<ImageItem> imageListFromJsonArray = ImageInfoData.Companion.imageListFromJsonArray($this$fromJson_u24lambda_u2d0.optJSONArray("images"));
            String optString4 = $this$fromJson_u24lambda_u2d0.optString("image_bg");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"image_bg\")");
            String optString5 = $this$fromJson_u24lambda_u2d0.optString("title");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"title\")");
            String optString6 = $this$fromJson_u24lambda_u2d0.optString(FeedItemDataHotSearchFooter.TITLE_COLOR);
            Intrinsics.checkNotNullExpressionValue(optString6, "optString(\"title_color\")");
            return new ImageInfoData(optString, optString2, optInt, optString3, createWithNewDataStruct, imageListFromJsonArray, optString4, optString5, optString6);
        }

        private final List<ImageItem> imageListFromJsonArray(JSONArray jsonArray) {
            if (jsonArray == null || jsonArray.length() <= 0) {
                return new ArrayList<>();
            }
            List arrayList = new ArrayList();
            List $this$imageListFromJsonArray_u24lambda_u2d2 = arrayList;
            int length = jsonArray.length();
            for (int idx = 0; idx < length; idx++) {
                ImageItem it = ImageItem.Companion.fromJson(jsonArray.optJSONObject(idx));
                if (it != null) {
                    $this$imageListFromJsonArray_u24lambda_u2d2.add(it);
                }
            }
            return arrayList;
        }
    }

    public final long getChargeDuration() {
        if (this.chargeDuration <= 0) {
            return 0;
        }
        return TimeUnit.SECONDS.toMillis((long) this.chargeDuration);
    }

    public final boolean supportScrollCharge() {
        return Intrinsics.areEqual((Object) this.scrollChargeSwitch, (Object) "1");
    }

    public final String getImageStyleChargeModify() {
        return supportScrollCharge() ? "2" : "1";
    }

    public final boolean isVerticalImageStyle() {
        return Intrinsics.areEqual((Object) this.imageStyle, (Object) "2");
    }

    public final boolean isNewImageStyle() {
        return Intrinsics.areEqual((Object) this.imageStyle, (Object) "1");
    }

    public final boolean isOldImageStyle() {
        return Intrinsics.areEqual((Object) this.imageStyle, (Object) "0");
    }
}
