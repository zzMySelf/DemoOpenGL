package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.video.detail.utils.JsonToolsKt;
import com.baidu.searchbox.video.feedflow.detail.banner.freq.BannerFreqControlConfigModel;
import com.baidu.searchbox.video.feedflow.detail.banner.freq.BannerFreqControlItemConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"KEY_FREQ_CONTROL", "", "TAG", "parseFreqControlConfig", "Lcom/baidu/searchbox/video/feedflow/detail/banner/freq/BannerFreqControlConfigModel;", "updateValue", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerFreqControlConfig.kt */
public final class BannerFreqControlConfigKt {
    private static final String KEY_FREQ_CONTROL = "freqcontrol_conf";
    private static final String TAG = "Logger: banner_freqControl_conf";

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* access modifiers changed from: private */
    public static final BannerFreqControlConfigModel parseFreqControlConfig(String updateValue) {
        Object obj;
        int i2;
        String str = updateValue;
        CharSequence charSequence = str;
        ? r3 = 0;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            int i3 = 0;
            JSONObject json = new JSONObject(str);
            BannerFreqControlConfigModel model = new BannerFreqControlConfigModel((List) null, 1, (DefaultConstructorMarker) null);
            Iterator $this$forEach$iv = json.keys();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "json.keys()");
            while ($this$forEach$iv.hasNext()) {
                String key = $this$forEach$iv.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                BannerFreqControlItemConfig itemConfig = new BannerFreqControlItemConfig(key, r3, 2, r3);
                JSONObject optJSONObject = json.optJSONObject(key);
                JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("pages") : r3;
                Collection destination$iv$iv = new ArrayList();
                for (Object page : JsonToolsKt.toSimpleArray(optJSONArray)) {
                    int i4 = i2;
                    Object it$iv$iv = (page instanceof String) != 0 ? ((String) page).toString() : null;
                    if (it$iv$iv != null) {
                        destination$iv$iv.add(it$iv$iv);
                        i2 = i4;
                    } else {
                        i2 = i4;
                    }
                }
                int i5 = i2;
                itemConfig.getPages().addAll((List) destination$iv$iv);
                if (itemConfig.isValid()) {
                    model.getBanners().add(itemConfig);
                }
                i3 = i5;
                r3 = 0;
            }
            int i6 = i2;
            if (model.isValid() != 0) {
                return model;
            }
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
            Throwable r0 = Result.m8974exceptionOrNullimpl(obj);
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
