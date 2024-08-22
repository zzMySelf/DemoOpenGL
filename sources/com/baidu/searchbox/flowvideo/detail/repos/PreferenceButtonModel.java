package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/PreferenceButtonModel;", "Lcom/baidu/searchbox/NoProGuard;", "text", "", "icon", "selected", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getIcon", "()Ljava/lang/String;", "getSelected", "()Z", "setSelected", "(Z)V", "getText", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class PreferenceButtonModel implements NoProGuard {
    private final String icon;
    private boolean selected;
    private final String text;

    public PreferenceButtonModel() {
        this((String) null, (String) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PreferenceButtonModel copy$default(PreferenceButtonModel preferenceButtonModel, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preferenceButtonModel.text;
        }
        if ((i2 & 2) != 0) {
            str2 = preferenceButtonModel.icon;
        }
        if ((i2 & 4) != 0) {
            z = preferenceButtonModel.selected;
        }
        return preferenceButtonModel.copy(str, str2, z);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.icon;
    }

    public final boolean component3() {
        return this.selected;
    }

    public final PreferenceButtonModel copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "icon");
        return new PreferenceButtonModel(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreferenceButtonModel)) {
            return false;
        }
        PreferenceButtonModel preferenceButtonModel = (PreferenceButtonModel) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) preferenceButtonModel.text) && Intrinsics.areEqual((Object) this.icon, (Object) preferenceButtonModel.icon) && this.selected == preferenceButtonModel.selected;
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.icon.hashCode()) * 31;
        boolean z = this.selected;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "PreferenceButtonModel(text=" + this.text + ", icon=" + this.icon + ", selected=" + this.selected + ')';
    }

    public PreferenceButtonModel(String text2, String icon2, boolean selected2) {
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(icon2, "icon");
        this.text = text2;
        this.icon = icon2;
        this.selected = selected2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreferenceButtonModel(String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? false : z);
    }

    public final String getText() {
        return this.text;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }
}
