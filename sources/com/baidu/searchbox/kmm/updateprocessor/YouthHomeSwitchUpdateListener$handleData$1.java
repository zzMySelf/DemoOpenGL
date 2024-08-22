package com.baidu.searchbox.kmm.updateprocessor;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeSwitchUpdateListener.kt */
final class YouthHomeSwitchUpdateListener$handleData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $data;
    final /* synthetic */ String $version;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    YouthHomeSwitchUpdateListener$handleData$1(String str, JsonObject jsonObject) {
        super(0);
        this.$version = str;
        this.$data = jsonObject;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        if (r1.equals("0") == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString("youth_home_switch_value", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        if (r1.equals("-1") != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (r1.equals("1") == false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = r0.$version
            java.lang.String r2 = "-1"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.String r3 = "youth_home_switch_value"
            if (r1 == 0) goto L_0x0014
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.removeQuickConfig(r3)
            goto L_0x0145
        L_0x0014:
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r1 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r1 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r1
            java.lang.String r4 = "modeSwitch"
            r5 = 0
            r6 = 2
            java.lang.String r1 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r1, r4, r5, r6, r5)
            int r4 = r1.hashCode()
            switch(r4) {
                case 48: goto L_0x0039;
                case 49: goto L_0x0030;
                case 1444: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0045
        L_0x0029:
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0028
            goto L_0x0042
        L_0x0030:
            java.lang.String r2 = "1"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0042
            goto L_0x0028
        L_0x0039:
            java.lang.String r2 = "0"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0042
            goto L_0x0028
        L_0x0042:
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r3, r1)
        L_0x0045:
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r2 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r2 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r2
            java.lang.String r3 = "hisFeedTab"
            java.lang.String r2 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r2, r3, r5, r6, r5)
            java.lang.String r3 = "youth_home_his_feed_tab"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r3, r2)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r3 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r3 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r3
            java.lang.String r4 = "isDisplayWeather"
            java.lang.String r3 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r3, r4, r5, r6, r5)
            java.lang.String r4 = "youth_home_is_display_weather"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r4, r3)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r4 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r4 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r4
            java.lang.String r7 = "weatherDisplayLocation"
            java.lang.String r4 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r4, r7, r5, r6, r5)
            java.lang.String r7 = "persist_key_weatherdisplay_location"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r7, r4)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r7 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r7 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r7
            java.lang.String r8 = "isDisplayTab"
            java.lang.String r7 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r7, r8, r5, r6, r5)
            java.lang.String r8 = "youth_home_is_display_tab"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r8, r7)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r8 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r8 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r8
            java.lang.String r9 = "barStyle"
            java.lang.String r8 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r8, r9, r5, r6, r5)
            java.lang.Integer r9 = kotlin.text.StringsKt.toIntOrNull(r8)
            r10 = 1
            if (r9 == 0) goto L_0x009e
            int r9 = r9.intValue()
            goto L_0x009f
        L_0x009e:
            r9 = r10
        L_0x009f:
            java.lang.String r11 = "youth_home_bar_style"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigInt(r11, r9)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r9 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r9 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r9
            java.lang.String r11 = "floatingBarStyle"
            java.lang.String r9 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r9, r11, r5, r6, r5)
            java.lang.Integer r11 = kotlin.text.StringsKt.toIntOrNull(r9)
            if (r11 == 0) goto L_0x00ba
            int r11 = r11.intValue()
            goto L_0x00bb
        L_0x00ba:
            r11 = r6
        L_0x00bb:
            java.lang.String r12 = "youth_float_Bar_Enhanced"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigInt(r12, r11)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r11 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r11 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r11
            java.lang.String r12 = "searchboxStyle"
            java.lang.String r11 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r11, r12, r5, r6, r5)
            java.lang.Integer r12 = kotlin.text.StringsKt.toIntOrNull(r11)
            if (r12 == 0) goto L_0x00d6
            int r10 = r12.intValue()
        L_0x00d6:
            java.lang.String r12 = "youth_home_search_box_style"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigInt(r12, r10)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r10 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r10 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r10
            java.lang.String r12 = "isDisplayBar"
            java.lang.String r10 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r10, r12, r5, r6, r5)
            java.lang.String r12 = "youth_home_is_display_bar"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r12, r10)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r12 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r12 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r12
            java.lang.String r13 = "barAlpha"
            java.lang.String r12 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r12, r13, r5, r6, r5)
            java.lang.String r13 = "youth_home_bottom_bar_alpha"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r13, r12)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r13 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r13 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r13
            java.lang.String r14 = "isDisplayFontSize"
            java.lang.String r13 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r13, r14, r5, r6, r5)
            java.lang.String r14 = "youth_home_is_display_font_size"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r14, r13)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r14 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r14 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r14
            java.lang.String r15 = "isDisplayDayNight"
            java.lang.String r14 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r14, r15, r5, r6, r5)
            java.lang.String r15 = "youth_home_is_display_day_night"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r15, r14)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r15 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r15 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r15
            r16 = r1
            java.lang.String r1 = "isDisplayOptionSettings"
            java.lang.String r1 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r15, r1, r5, r6, r5)
            java.lang.String r15 = "youth_home_option_settings"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r15, r1)
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r15 = r0.$data
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r15 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r15
            r17 = r1
            java.lang.String r1 = "isDisplayAIPersonal"
            java.lang.String r1 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r15, r1, r5, r6, r5)
            java.lang.String r5 = "youth_home_use_ai_personal_center"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r5, r1)
        L_0x0145:
            java.lang.String r1 = r0.$version
            java.lang.String r2 = "youth_home_switch_version"
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.kmm.updateprocessor.YouthHomeSwitchUpdateListener$handleData$1.invoke():void");
    }
}
