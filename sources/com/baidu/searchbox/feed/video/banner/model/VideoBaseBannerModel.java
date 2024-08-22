package com.baidu.searchbox.feed.video.banner.model;

import android.text.TextUtils;
import com.baidu.searchbox.feed.model.DynamicItemPostData;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/feed/video/banner/model/VideoBaseBannerModel;", "", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "preloadScheme", "getPreloadScheme", "setPreloadScheme", "parseCommonJson", "", "data", "Lorg/json/JSONObject;", "parseJson", "shouldInvokePreLoad", "", "toModel", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoBaseBannerModel.kt */
public abstract class VideoBaseBannerModel {
    private String mode;
    private String preloadScheme;

    public abstract void parseJson(JSONObject jSONObject);

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getPreloadScheme() {
        return this.preloadScheme;
    }

    public final void setPreloadScheme(String str) {
        this.preloadScheme = str;
    }

    public final VideoBaseBannerModel toModel(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        parseCommonJson(data);
        parseJson(data);
        return this;
    }

    private final void parseCommonJson(JSONObject data) {
        this.mode = data.optString("mode");
        this.preloadScheme = data.optString("preloadScheme");
    }

    public boolean shouldInvokePreLoad() {
        String str;
        String str2 = this.mode;
        if (str2 != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        } else {
            str = null;
        }
        return TextUtils.equals(str, DynamicItemPostData.MODE_SMART_APP);
    }
}
