package com.baidu.searchbox.video.feedflow.detail.bottombar;

import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/bottombar/BottomBarNextStringModel;", "", "txt", "", "isDefault", "", "(Ljava/lang/String;Z)V", "()Z", "getTxt", "()Ljava/lang/String;", "setTxt", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "genShowText", "hashCode", "", "toString", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarUntils.kt */
public final class BottomBarNextStringModel {
    private final boolean isDefault;
    private String txt;

    public BottomBarNextStringModel() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BottomBarNextStringModel copy$default(BottomBarNextStringModel bottomBarNextStringModel, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bottomBarNextStringModel.txt;
        }
        if ((i2 & 2) != 0) {
            z = bottomBarNextStringModel.isDefault;
        }
        return bottomBarNextStringModel.copy(str, z);
    }

    public final String component1() {
        return this.txt;
    }

    public final boolean component2() {
        return this.isDefault;
    }

    public final BottomBarNextStringModel copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "txt");
        return new BottomBarNextStringModel(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomBarNextStringModel)) {
            return false;
        }
        BottomBarNextStringModel bottomBarNextStringModel = (BottomBarNextStringModel) obj;
        return Intrinsics.areEqual((Object) this.txt, (Object) bottomBarNextStringModel.txt) && this.isDefault == bottomBarNextStringModel.isDefault;
    }

    public int hashCode() {
        int hashCode = this.txt.hashCode() * 31;
        boolean z = this.isDefault;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "BottomBarNextStringModel(txt=" + this.txt + ", isDefault=" + this.isDefault + ')';
    }

    public BottomBarNextStringModel(String txt2, boolean isDefault2) {
        Intrinsics.checkNotNullParameter(txt2, "txt");
        this.txt = txt2;
        this.isDefault = isDefault2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomBarNextStringModel(String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? false : z);
    }

    public final String getTxt() {
        return this.txt;
    }

    public final void setTxt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.txt = str;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final String genShowText() {
        if (!this.isDefault) {
            return this.txt;
        }
        if (this.txt.length() > 5) {
            String substring = this.txt.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            this.txt = substring;
            this.txt += DIFactory.INSTANCE.getAppContext().getString(R.string.video_flow_recommend_show_next_title_of_bottom_bar_suffix);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = DIFactory.INSTANCE.getAppContext().getString(R.string.video_flow_bottom_bar_recommend_show_text);
        Intrinsics.checkNotNullExpressionValue(string, "DIFactory.getAppContext(…_bar_recommend_show_text)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.txt}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
