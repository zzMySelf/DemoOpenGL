package com.baidu.searchbox.feed.biserialdetail.base.util;

import android.content.res.Resources;
import android.view.View;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0010\u001a\u00020\u0005*\u00020\u0003¨\u0006\u0011"}, d2 = {"getTextSize", "", "textSize", "", "defaultSize", "", "processExtraInfoParse", "", "params", "setCorner", "", "view", "Landroid/view/View;", "radius", "dp2px", "toFloatSafely", "toIntSafely", "lib-feed-biserial-detail_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicUtils.kt */
public final class DynamicUtilsKt {
    public static final float dp2px(int $this$dp2px) {
        return (((float) $this$dp2px) * Resources.getSystem().getDisplayMetrics().density) + 0.5f;
    }

    public static final int toIntSafely(String $this$toIntSafely) {
        Intrinsics.checkNotNullParameter($this$toIntSafely, "<this>");
        try {
            return Integer.parseInt($this$toIntSafely);
        } catch (Exception e2) {
            return 0;
        }
    }

    public static final float toFloatSafely(String $this$toFloatSafely) {
        Intrinsics.checkNotNullParameter($this$toFloatSafely, "<this>");
        try {
            return Float.parseFloat($this$toFloatSafely);
        } catch (Exception e2) {
            return 0.0f;
        }
    }

    public static final float getTextSize(String textSize, int defaultSize) {
        Intrinsics.checkNotNullParameter(textSize, "textSize");
        if (textSize.length() == 0) {
            return (float) defaultSize;
        }
        try {
            return Float.parseFloat(textSize);
        } catch (NumberFormatException e2) {
            return (float) defaultSize;
        }
    }

    public static final boolean processExtraInfoParse(String params) {
        if (params == null) {
            return false;
        }
        try {
            JSONObject objectData = new JSONObject(params);
            Iterator iterator = objectData.keys();
            while (iterator.hasNext()) {
                String data = objectData.getString(iterator.next());
                Intrinsics.checkNotNullExpressionValue(data, "data");
                if (!(data.length() == 0)) {
                    try {
                        JSONArray jsonArray = new JSONArray(data);
                        int length = jsonArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject itemJson = jsonArray.getJSONObject(i2);
                            String type = itemJson.optString("type");
                            String status = itemJson.optString("status");
                            if (Intrinsics.areEqual((Object) type, (Object) "live_result") && !Intrinsics.areEqual((Object) status, (Object) "1")) {
                                return true;
                            }
                        }
                        continue;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return false;
    }

    public static final void setCorner(View view2, float radius) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setOutlineProvider(new DynamicUtilsKt$setCorner$1(radius));
        view2.setClipToOutline(true);
    }
}
