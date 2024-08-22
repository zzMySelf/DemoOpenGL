package fe.ggg.ad.ad.qw;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7569ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f7570de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final String f7571fe;
    @NotNull
    public final WeakReference<Activity> qw;

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f7572rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final String f7573th;

    public de(@NotNull WeakReference<Activity> weakReference, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(weakReference, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "accountId");
        Intrinsics.checkNotNullParameter(str2, "productId");
        Intrinsics.checkNotNullParameter(str3, "serverOrderId");
        this.qw = weakReference;
        this.f7569ad = str;
        this.f7570de = str2;
        this.f7571fe = str3;
        this.f7572rg = z;
        this.f7573th = z ? "subs" : "inapp";
    }

    @NotNull
    public final WeakReference<Activity> ad() {
        return this.qw;
    }

    @NotNull
    public final String de() {
        return this.f7570de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) deVar.qw) && Intrinsics.areEqual((Object) this.f7569ad, (Object) deVar.f7569ad) && Intrinsics.areEqual((Object) this.f7570de, (Object) deVar.f7570de) && Intrinsics.areEqual((Object) this.f7571fe, (Object) deVar.f7571fe) && this.f7572rg == deVar.f7572rg;
    }

    @NotNull
    public final String fe() {
        return this.f7573th;
    }

    public int hashCode() {
        int hashCode = ((((((this.qw.hashCode() * 31) + this.f7569ad.hashCode()) * 31) + this.f7570de.hashCode()) * 31) + this.f7571fe.hashCode()) * 31;
        boolean z = this.f7572rg;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public final String qw() {
        return this.f7569ad;
    }

    @NotNull
    public final String rg() {
        return this.f7571fe;
    }

    @NotNull
    public String toString() {
        return "PayParams(activity=" + this.qw + ", accountId=" + this.f7569ad + ", productId=" + this.f7570de + ", serverOrderId=" + this.f7571fe + ", isSubs=" + this.f7572rg + ')';
    }
}
