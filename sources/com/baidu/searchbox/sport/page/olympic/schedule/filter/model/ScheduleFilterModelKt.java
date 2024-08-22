package com.baidu.searchbox.sport.page.olympic.schedule.filter.model;

import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\t*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DEBUG", "", "addSelectedFilterDataParams", "", "data", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/model/ScheduleFilterModel;", "selectedData", "Lorg/json/JSONArray;", "generateSelectedFilters", "", "generateSelectedText", "page", "lib-search-sport_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScheduleFilterModel.kt */
public final class ScheduleFilterModelKt {
    private static final boolean DEBUG = AppConfig.isDebug();

    public static final String generateSelectedFilters(ScheduleFilterModel $this$generateSelectedFilters) {
        Intrinsics.checkNotNullParameter($this$generateSelectedFilters, "<this>");
        JSONArray selectedPrams = new JSONArray();
        addSelectedFilterDataParams($this$generateSelectedFilters, selectedPrams);
        String jSONArray = selectedPrams.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "selectedPrams.toString()");
        return jSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if ((r6 != null && r6.isTab()) != false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String generateSelectedText(com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "page"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "discipline"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)
            r1 = 1
            r0 = r0 ^ r1
            r2 = r13
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
        L_0x0019:
            if (r2 == 0) goto L_0x0074
            boolean r4 = r2.isTab()
            if (r4 != 0) goto L_0x0074
            java.lang.String r4 = r2.getValue()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            r5 = 0
            if (r4 <= 0) goto L_0x0030
            r4 = r1
            goto L_0x0031
        L_0x0030:
            r4 = r5
        L_0x0031:
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = r2.getValue()
            java.lang.String r6 = "all"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x0041
            r4 = r1
            goto L_0x0042
        L_0x0041:
            r4 = r5
        L_0x0042:
            com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r6 = r2.getParentFilter()
            if (r6 == 0) goto L_0x0059
            com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r6 = r2.getParentFilter()
            if (r6 == 0) goto L_0x0056
            boolean r6 = r6.isTab()
            if (r6 != r1) goto L_0x0056
            r6 = r1
            goto L_0x0057
        L_0x0056:
            r6 = r5
        L_0x0057:
            if (r6 == 0) goto L_0x005a
        L_0x0059:
            r5 = r1
        L_0x005a:
            boolean r6 = r3.isEmpty()
            if (r6 == 0) goto L_0x0062
            if (r4 != 0) goto L_0x0068
        L_0x0062:
            if (r0 == 0) goto L_0x006f
            if (r5 == 0) goto L_0x006f
            if (r4 == 0) goto L_0x006f
        L_0x0068:
            java.lang.String r6 = r2.getName()
            r3.add(r6)
        L_0x006f:
            com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r2 = r2.getParentFilter()
            goto L_0x0019
        L_0x0074:
            r1 = r3
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.reversed(r1)
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r1 = ""
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 62
            r12 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModelKt.generateSelectedText(com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel, java.lang.String):java.lang.String");
    }

    private static final void addSelectedFilterDataParams(ScheduleFilterModel data, JSONArray selectedData) {
        ScheduleFilterModel $this$addSelectedFilterDataParams_u24lambda_u2d0 = data.getParentFilter();
        if ($this$addSelectedFilterDataParams_u24lambda_u2d0 != null) {
            addSelectedFilterDataParams($this$addSelectedFilterDataParams_u24lambda_u2d0, selectedData);
        }
        JSONObject json = new JSONObject();
        try {
            json.put("key", data.getKey());
            json.put("value", data.getValue());
            selectedData.put(json);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
