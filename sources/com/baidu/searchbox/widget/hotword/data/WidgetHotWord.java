package com.baidu.searchbox.widget.hotword.data;

import com.baidu.searchbox.widget.searchwidget.model.BoxFuncModelKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB)\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0018\u001a\u00020\u0007J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/widget/hotword/data/WidgetHotWord;", "", "hotWordList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/widget/hotword/data/WidgetHotWord$HotWordUnion;", "Lkotlin/collections/ArrayList;", "index", "", "(Ljava/util/ArrayList;I)V", "getHotWordList", "()Ljava/util/ArrayList;", "setHotWordList", "(Ljava/util/ArrayList;)V", "getIndex", "()I", "setIndex", "(I)V", "component1", "component2", "copy", "equals", "", "other", "getHotWordUnion", "getSize", "hashCode", "toString", "", "HotWordUnion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetHotWord.kt */
public final class WidgetHotWord {
    private ArrayList<HotWordUnion> hotWordList;
    private int index;

    public static /* synthetic */ WidgetHotWord copy$default(WidgetHotWord widgetHotWord, ArrayList<HotWordUnion> arrayList, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = widgetHotWord.hotWordList;
        }
        if ((i3 & 2) != 0) {
            i2 = widgetHotWord.index;
        }
        return widgetHotWord.copy(arrayList, i2);
    }

    public final ArrayList<HotWordUnion> component1() {
        return this.hotWordList;
    }

    public final int component2() {
        return this.index;
    }

    public final WidgetHotWord copy(ArrayList<HotWordUnion> arrayList, int i2) {
        return new WidgetHotWord(arrayList, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WidgetHotWord)) {
            return false;
        }
        WidgetHotWord widgetHotWord = (WidgetHotWord) obj;
        return Intrinsics.areEqual((Object) this.hotWordList, (Object) widgetHotWord.hotWordList) && this.index == widgetHotWord.index;
    }

    public int hashCode() {
        ArrayList<HotWordUnion> arrayList = this.hotWordList;
        return ((arrayList == null ? 0 : arrayList.hashCode()) * 31) + Integer.hashCode(this.index);
    }

    public String toString() {
        return "WidgetHotWord(hotWordList=" + this.hotWordList + ", index=" + this.index + ')';
    }

    public WidgetHotWord(ArrayList<HotWordUnion> hotWordList2, int index2) {
        this.hotWordList = hotWordList2;
        this.index = index2;
    }

    public final ArrayList<HotWordUnion> getHotWordList() {
        return this.hotWordList;
    }

    public final void setHotWordList(ArrayList<HotWordUnion> arrayList) {
        this.hotWordList = arrayList;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/widget/hotword/data/WidgetHotWord$HotWordUnion;", "", "hotWord", "", "scheme", "(Ljava/lang/String;Ljava/lang/String;)V", "getHotWord", "()Ljava/lang/String;", "setHotWord", "(Ljava/lang/String;)V", "getScheme", "setScheme", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WidgetHotWord.kt */
    public static final class HotWordUnion {
        private String hotWord;
        private String scheme;

        public static /* synthetic */ HotWordUnion copy$default(HotWordUnion hotWordUnion, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = hotWordUnion.hotWord;
            }
            if ((i2 & 2) != 0) {
                str2 = hotWordUnion.scheme;
            }
            return hotWordUnion.copy(str, str2);
        }

        public final String component1() {
            return this.hotWord;
        }

        public final String component2() {
            return this.scheme;
        }

        public final HotWordUnion copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, BoxFuncModelKt.BOX_FUNC_ID_HOT_WORD);
            Intrinsics.checkNotNullParameter(str2, "scheme");
            return new HotWordUnion(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HotWordUnion)) {
                return false;
            }
            HotWordUnion hotWordUnion = (HotWordUnion) obj;
            return Intrinsics.areEqual((Object) this.hotWord, (Object) hotWordUnion.hotWord) && Intrinsics.areEqual((Object) this.scheme, (Object) hotWordUnion.scheme);
        }

        public int hashCode() {
            return (this.hotWord.hashCode() * 31) + this.scheme.hashCode();
        }

        public String toString() {
            return "HotWordUnion(hotWord=" + this.hotWord + ", scheme=" + this.scheme + ')';
        }

        public HotWordUnion(String hotWord2, String scheme2) {
            Intrinsics.checkNotNullParameter(hotWord2, BoxFuncModelKt.BOX_FUNC_ID_HOT_WORD);
            Intrinsics.checkNotNullParameter(scheme2, "scheme");
            this.hotWord = hotWord2;
            this.scheme = scheme2;
        }

        public final String getHotWord() {
            return this.hotWord;
        }

        public final void setHotWord(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.hotWord = str;
        }

        public final String getScheme() {
            return this.scheme;
        }

        public final void setScheme(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.scheme = str;
        }
    }

    public final HotWordUnion getHotWordUnion() {
        ArrayList<HotWordUnion> arrayList;
        ArrayList<HotWordUnion> arrayList2 = this.hotWordList;
        if (arrayList2 != null) {
            int i2 = this.index;
            Intrinsics.checkNotNull(arrayList2);
            if (i2 >= arrayList2.size() || (arrayList = this.hotWordList) == null) {
                return null;
            }
            return arrayList.get(this.index);
        }
        return null;
    }

    public final int getSize() {
        ArrayList<HotWordUnion> arrayList = this.hotWordList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
