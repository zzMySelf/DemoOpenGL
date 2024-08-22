package com.baidu.searchbox.search.webvideo.transna;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/transna/TransNaPageItemData;", "", "type", "", "text", "", "isSelected", "", "url", "(ILjava/lang/String;ZLjava/lang/String;)V", "()Z", "getText", "()Ljava/lang/String;", "getType", "()I", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransPageRecyclerAdapter.kt */
public final class TransNaPageItemData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_EXIT_BTN = 3;
    public static final int TYPE_LIST = 2;
    public static final int TYPE_VIDEO_TITLE = 1;
    private final boolean isSelected;
    private final String text;
    private final int type;
    private final String url;

    public static /* synthetic */ TransNaPageItemData copy$default(TransNaPageItemData transNaPageItemData, int i2, String str, boolean z, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = transNaPageItemData.type;
        }
        if ((i3 & 2) != 0) {
            str = transNaPageItemData.text;
        }
        if ((i3 & 4) != 0) {
            z = transNaPageItemData.isSelected;
        }
        if ((i3 & 8) != 0) {
            str2 = transNaPageItemData.url;
        }
        return transNaPageItemData.copy(i2, str, z, str2);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    public final String component4() {
        return this.url;
    }

    public final TransNaPageItemData copy(int i2, String str, boolean z, String str2) {
        return new TransNaPageItemData(i2, str, z, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransNaPageItemData)) {
            return false;
        }
        TransNaPageItemData transNaPageItemData = (TransNaPageItemData) obj;
        return this.type == transNaPageItemData.type && Intrinsics.areEqual((Object) this.text, (Object) transNaPageItemData.text) && this.isSelected == transNaPageItemData.isSelected && Intrinsics.areEqual((Object) this.url, (Object) transNaPageItemData.url);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.type) * 31;
        String str = this.text;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        return "TransNaPageItemData(type=" + this.type + ", text=" + this.text + ", isSelected=" + this.isSelected + ", url=" + this.url + ')';
    }

    public TransNaPageItemData(int type2, String text2, boolean isSelected2, String url2) {
        this.type = type2;
        this.text = text2;
        this.isSelected = isSelected2;
        this.url = url2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransNaPageItemData(int i2, String str, boolean z, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? null : str2);
    }

    public final int getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/transna/TransNaPageItemData$Companion;", "", "()V", "TYPE_EXIT_BTN", "", "TYPE_LIST", "TYPE_VIDEO_TITLE", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransPageRecyclerAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
