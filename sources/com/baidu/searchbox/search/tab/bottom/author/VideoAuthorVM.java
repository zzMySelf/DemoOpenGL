package com.baidu.searchbox.search.tab.bottom.author;

import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonBottomViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/search/tab/bottom/author/VideoAuthorVM;", "", "()V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "model", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonBottomViewModel;", "name", "getName", "setName", "time", "getTime", "setTime", "getJumpCmd", "setModel", "", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoAuthorVM.kt */
public final class VideoAuthorVM {
    private String iconUrl = "";
    private VideoCommonBottomViewModel model;
    private String name = "";
    private String time = "";

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.time = str;
    }

    public final void setModel(VideoCommonBottomViewModel model2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        this.model = model2;
        this.iconUrl = model2.getAuthorIcon();
        this.name = StringsKt.trimStart((CharSequence) StringsKt.trimEnd((CharSequence) model2.getAuthor()).toString()).toString();
        this.time = model2.getPubtimeText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getAuthorCmd();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getJumpCmd() {
        /*
            r1 = this;
            com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonBottomViewModel r0 = r1.model
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getAuthorCmd()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.bottom.author.VideoAuthorVM.getJumpCmd():java.lang.String");
    }
}
