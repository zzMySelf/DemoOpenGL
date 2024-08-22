package com.baidu.searchbox.music.ext.mymusic.style;

import com.baidu.searchbox.music.ext.tpls.model.AlbumListTplData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0003\u0010\f\u001a\u00020\u0005\u0012\b\b\u0003\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/style/AlbumListTplStyle;", "", "supportHorizontalSlip", "", "coverBgResId", "", "titleMarginStart", "showArrow", "params", "Lcom/baidu/searchbox/music/ext/tpls/model/AlbumListTplData$Params;", "titleColorResId", "subtitleColorResId", "activeTitleColorResId", "activeSubtitleColorResId", "(ZIIZLcom/baidu/searchbox/music/ext/tpls/model/AlbumListTplData$Params;IIII)V", "getActiveSubtitleColorResId", "()I", "setActiveSubtitleColorResId", "(I)V", "getActiveTitleColorResId", "setActiveTitleColorResId", "getCoverBgResId", "setCoverBgResId", "getParams", "()Lcom/baidu/searchbox/music/ext/tpls/model/AlbumListTplData$Params;", "setParams", "(Lcom/baidu/searchbox/music/ext/tpls/model/AlbumListTplData$Params;)V", "getShowArrow", "()Z", "setShowArrow", "(Z)V", "getSubtitleColorResId", "setSubtitleColorResId", "getSupportHorizontalSlip", "setSupportHorizontalSlip", "getTitleColorResId", "setTitleColorResId", "getTitleMarginStart", "setTitleMarginStart", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumListTplStyle.kt */
public final class AlbumListTplStyle {
    private int activeSubtitleColorResId;
    private int activeTitleColorResId;
    private int coverBgResId;
    private AlbumListTplData.Params params;
    private boolean showArrow;
    private int subtitleColorResId;
    private boolean supportHorizontalSlip;
    private int titleColorResId;
    private int titleMarginStart;

    public AlbumListTplStyle() {
        this(false, 0, 0, false, (AlbumListTplData.Params) null, 0, 0, 0, 0, 511, (DefaultConstructorMarker) null);
    }

    public AlbumListTplStyle(boolean supportHorizontalSlip2, int coverBgResId2, int titleMarginStart2, boolean showArrow2, AlbumListTplData.Params params2, int titleColorResId2, int subtitleColorResId2, int activeTitleColorResId2, int activeSubtitleColorResId2) {
        Intrinsics.checkNotNullParameter(params2, "params");
        this.supportHorizontalSlip = supportHorizontalSlip2;
        this.coverBgResId = coverBgResId2;
        this.titleMarginStart = titleMarginStart2;
        this.showArrow = showArrow2;
        this.params = params2;
        this.titleColorResId = titleColorResId2;
        this.subtitleColorResId = subtitleColorResId2;
        this.activeTitleColorResId = activeTitleColorResId2;
        this.activeSubtitleColorResId = activeSubtitleColorResId2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AlbumListTplStyle(boolean r10, int r11, int r12, boolean r13, com.baidu.searchbox.music.ext.tpls.model.AlbumListTplData.Params r14, int r15, int r16, int r17, int r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = r10
        L_0x0009:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0010
            int r2 = com.baidu.searchbox.music.ext.R.drawable.search_music_album_background
            goto L_0x0011
        L_0x0010:
            r2 = r11
        L_0x0011:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001b
            r3 = 7
            int r3 = com.baidu.searchbox.nacomp.extension.util.ViewExKt.getDp((int) r3)
            goto L_0x001c
        L_0x001b:
            r3 = r12
        L_0x001c:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0022
            r4 = 0
            goto L_0x0023
        L_0x0022:
            r4 = r13
        L_0x0023:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x002d
            com.baidu.searchbox.music.ext.tpls.model.AlbumListTplData$Params r5 = new com.baidu.searchbox.music.ext.tpls.model.AlbumListTplData$Params
            r5.<init>()
            goto L_0x002e
        L_0x002d:
            r5 = r14
        L_0x002e:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0035
            int r6 = com.baidu.android.common.ui.style.R.color.GC1
            goto L_0x0036
        L_0x0035:
            r6 = r15
        L_0x0036:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x003d
            int r7 = com.baidu.android.common.ui.style.R.color.GC4
            goto L_0x003f
        L_0x003d:
            r7 = r16
        L_0x003f:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0046
            int r8 = com.baidu.android.common.ui.style.R.color.GC7
            goto L_0x0048
        L_0x0046:
            r8 = r17
        L_0x0048:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004f
            int r0 = com.baidu.android.common.ui.style.R.color.GC7
            goto L_0x0051
        L_0x004f:
            r0 = r18
        L_0x0051:
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.ext.mymusic.style.AlbumListTplStyle.<init>(boolean, int, int, boolean, com.baidu.searchbox.music.ext.tpls.model.AlbumListTplData$Params, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getSupportHorizontalSlip() {
        return this.supportHorizontalSlip;
    }

    public final void setSupportHorizontalSlip(boolean z) {
        this.supportHorizontalSlip = z;
    }

    public final int getCoverBgResId() {
        return this.coverBgResId;
    }

    public final void setCoverBgResId(int i2) {
        this.coverBgResId = i2;
    }

    public final int getTitleMarginStart() {
        return this.titleMarginStart;
    }

    public final void setTitleMarginStart(int i2) {
        this.titleMarginStart = i2;
    }

    public final boolean getShowArrow() {
        return this.showArrow;
    }

    public final void setShowArrow(boolean z) {
        this.showArrow = z;
    }

    public final AlbumListTplData.Params getParams() {
        return this.params;
    }

    public final void setParams(AlbumListTplData.Params params2) {
        Intrinsics.checkNotNullParameter(params2, "<set-?>");
        this.params = params2;
    }

    public final int getTitleColorResId() {
        return this.titleColorResId;
    }

    public final void setTitleColorResId(int i2) {
        this.titleColorResId = i2;
    }

    public final int getSubtitleColorResId() {
        return this.subtitleColorResId;
    }

    public final void setSubtitleColorResId(int i2) {
        this.subtitleColorResId = i2;
    }

    public final int getActiveTitleColorResId() {
        return this.activeTitleColorResId;
    }

    public final void setActiveTitleColorResId(int i2) {
        this.activeTitleColorResId = i2;
    }

    public final int getActiveSubtitleColorResId() {
        return this.activeSubtitleColorResId;
    }

    public final void setActiveSubtitleColorResId(int i2) {
        this.activeSubtitleColorResId = i2;
    }
}
