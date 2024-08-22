package com.baidu.searchbox.nacomp.extension.fontsize;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.config.FontSizeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "", "level", "", "(I)V", "getLevel", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "lib-nacomp-extension_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontSizeInfo.kt */
public final class FontSizeInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int level;

    public static /* synthetic */ FontSizeInfo copy$default(FontSizeInfo fontSizeInfo, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = fontSizeInfo.level;
        }
        return fontSizeInfo.copy(i2);
    }

    public final int component1() {
        return this.level;
    }

    public final FontSizeInfo copy(int i2) {
        return new FontSizeInfo(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FontSizeInfo) && this.level == ((FontSizeInfo) obj).level;
    }

    public int hashCode() {
        return Integer.hashCode(this.level);
    }

    public String toString() {
        return "FontSizeInfo(level=" + this.level + ')';
    }

    public FontSizeInfo(int level2) {
        this.level = level2;
    }

    public final int getLevel() {
        return this.level;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo$Companion;", "", "()V", "getInfo", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "lib-nacomp-extension_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FontSizeInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontSizeInfo getInfo() {
            return new FontSizeInfo(FontSizeHelper.getFontSizeType());
        }
    }
}
