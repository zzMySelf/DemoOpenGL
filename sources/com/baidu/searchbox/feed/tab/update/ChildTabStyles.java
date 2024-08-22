package com.baidu.searchbox.feed.tab.update;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/baidu/searchbox/feed/tab/update/ChildTabStyles;", "", "()V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "fontColor", "getFontColor", "setFontColor", "nightBgColor", "getNightBgColor", "setNightBgColor", "nightFontColor", "getNightFontColor", "setNightFontColor", "nightSelectedBgColor", "getNightSelectedBgColor", "setNightSelectedBgColor", "nightSelectedColor", "getNightSelectedColor", "setNightSelectedColor", "selectedBgColor", "getSelectedBgColor", "setSelectedBgColor", "selectedColor", "getSelectedColor", "setSelectedColor", "subBoardStyle", "", "getSubBoardStyle", "()Ljava/lang/String;", "setSubBoardStyle", "(Ljava/lang/String;)V", "isValid", "", "parseFromJson", "jsonString", "lib-feed-tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChildTabInfo.kt */
public final class ChildTabStyles {
    private int bgColor = -1;
    private int fontColor = -1;
    private int nightBgColor = -1;
    private int nightFontColor = -1;
    private int nightSelectedBgColor = -1;
    private int nightSelectedColor = -1;
    private int selectedBgColor = -1;
    private int selectedColor = -1;
    private String subBoardStyle = "";

    public final int getFontColor() {
        return this.fontColor;
    }

    public final void setFontColor(int i2) {
        this.fontColor = i2;
    }

    public final int getNightFontColor() {
        return this.nightFontColor;
    }

    public final void setNightFontColor(int i2) {
        this.nightFontColor = i2;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int i2) {
        this.bgColor = i2;
    }

    public final int getNightBgColor() {
        return this.nightBgColor;
    }

    public final void setNightBgColor(int i2) {
        this.nightBgColor = i2;
    }

    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public final void setSelectedColor(int i2) {
        this.selectedColor = i2;
    }

    public final int getNightSelectedColor() {
        return this.nightSelectedColor;
    }

    public final void setNightSelectedColor(int i2) {
        this.nightSelectedColor = i2;
    }

    public final int getSelectedBgColor() {
        return this.selectedBgColor;
    }

    public final void setSelectedBgColor(int i2) {
        this.selectedBgColor = i2;
    }

    public final int getNightSelectedBgColor() {
        return this.nightSelectedBgColor;
    }

    public final void setNightSelectedBgColor(int i2) {
        this.nightSelectedBgColor = i2;
    }

    public final String getSubBoardStyle() {
        return this.subBoardStyle;
    }

    public final void setSubBoardStyle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subBoardStyle = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012 A[Catch:{ JSONException -> 0x009f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.feed.tab.update.ChildTabStyles parseFromJson(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x009f }
            if (r0 == 0) goto L_0x000f
            int r0 = r0.length()     // Catch:{ JSONException -> 0x009f }
            if (r0 != 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            if (r0 != 0) goto L_0x00a0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009f }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "font_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC110     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.fontColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "night_font_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC110     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.nightFontColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "bg_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC162     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.bgColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "night_bg_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC162     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.nightBgColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "selected_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC171     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.selectedColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "night_selected_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC171     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.nightSelectedColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "selected_bg_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC172     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.selectedBgColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "night_selected_bg_color"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x009f }
            int r2 = com.baidu.searchbox.feed.styles.R.color.FC172     // Catch:{ JSONException -> 0x009f }
            int r1 = com.baidu.searchbox.kotlinx.ColorExtKt.toColorSafe(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.nightSelectedBgColor = r1     // Catch:{ JSONException -> 0x009f }
            java.lang.String r1 = "sub_board_style"
            java.lang.String r2 = ""
            java.lang.String r1 = r0.optString(r1, r2)     // Catch:{ JSONException -> 0x009f }
            java.lang.String r2 = "styleObject.optString(KEY_SUB_BOARD_STYLE, \"\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ JSONException -> 0x009f }
            r3.subBoardStyle = r1     // Catch:{ JSONException -> 0x009f }
            goto L_0x00a0
        L_0x009f:
            r0 = move-exception
        L_0x00a0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.update.ChildTabStyles.parseFromJson(java.lang.String):com.baidu.searchbox.feed.tab.update.ChildTabStyles");
    }

    public final boolean isValid() {
        return (this.fontColor == -1 || this.nightFontColor == -1 || this.bgColor == -1 || this.nightBgColor == -1 || this.selectedColor == -1 || this.nightSelectedColor == -1 || this.selectedBgColor == -1 || this.nightSelectedBgColor == -1) ? false : true;
    }
}
