package com.baidu.searchbox.search.mix.tplmodel.toptip;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/search/mix/tplmodel/toptip/HighLightInfo;", "", "word", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getWord", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HighLightInfo.kt */
public final class HighLightInfo {
    private final int type;
    private final String word;

    public static /* synthetic */ HighLightInfo copy$default(HighLightInfo highLightInfo, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = highLightInfo.word;
        }
        if ((i3 & 2) != 0) {
            i2 = highLightInfo.type;
        }
        return highLightInfo.copy(str, i2);
    }

    public final String component1() {
        return this.word;
    }

    public final int component2() {
        return this.type;
    }

    public final HighLightInfo copy(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "word");
        return new HighLightInfo(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighLightInfo)) {
            return false;
        }
        HighLightInfo highLightInfo = (HighLightInfo) obj;
        return Intrinsics.areEqual((Object) this.word, (Object) highLightInfo.word) && this.type == highLightInfo.type;
    }

    public int hashCode() {
        return (this.word.hashCode() * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        return "HighLightInfo(word=" + this.word + ", type=" + this.type + ')';
    }

    public HighLightInfo(String word2, int type2) {
        Intrinsics.checkNotNullParameter(word2, "word");
        this.word = word2;
        this.type = type2;
    }

    public final int getType() {
        return this.type;
    }

    public final String getWord() {
        return this.word;
    }
}
