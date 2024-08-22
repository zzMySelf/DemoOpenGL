package fe.mmm.qw.p024if.yj.qw;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.yj.qw.qw  reason: invalid package */
public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final int f7956ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f7957de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final ArrayList<String> f7958fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<HashMap<String, Object>> f7959i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final String f337if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final String f7960o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final String f7961pf;
    @NotNull
    public final ArrayList<String> qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f7962rg;

    /* renamed from: th  reason: collision with root package name */
    public final int f7963th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final String f7964uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final HashMap<String, String> f7965yj;

    public qw(@NotNull ArrayList<String> arrayList, int i2, int i3, @NotNull ArrayList<String> arrayList2, int i4, int i5, @NotNull HashMap<String, String> hashMap, @NotNull String str, @NotNull ArrayList<HashMap<String, Object>> arrayList3, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(arrayList, "images");
        Intrinsics.checkNotNullParameter(arrayList2, "dataList");
        Intrinsics.checkNotNullParameter(hashMap, "cloudFiles");
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(arrayList3, "aiScanImages");
        Intrinsics.checkNotNullParameter(str2, "savePath");
        Intrinsics.checkNotNullParameter(str3, "docResourceFrom");
        Intrinsics.checkNotNullParameter(str4, "ubcSource");
        this.qw = arrayList;
        this.f7956ad = i2;
        this.f7957de = i3;
        this.f7958fe = arrayList2;
        this.f7962rg = i4;
        this.f7963th = i5;
        this.f7965yj = hashMap;
        this.f7964uk = str;
        this.f7959i = arrayList3;
        this.f7960o = str2;
        this.f7961pf = str3;
        this.f337if = str4;
    }

    public final int ad() {
        return this.f7957de;
    }

    @NotNull
    public final HashMap<String, String> de() {
        return this.f7965yj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && this.f7956ad == qwVar.f7956ad && this.f7957de == qwVar.f7957de && Intrinsics.areEqual((Object) this.f7958fe, (Object) qwVar.f7958fe) && this.f7962rg == qwVar.f7962rg && this.f7963th == qwVar.f7963th && Intrinsics.areEqual((Object) this.f7965yj, (Object) qwVar.f7965yj) && Intrinsics.areEqual((Object) this.f7964uk, (Object) qwVar.f7964uk) && Intrinsics.areEqual((Object) this.f7959i, (Object) qwVar.f7959i) && Intrinsics.areEqual((Object) this.f7960o, (Object) qwVar.f7960o) && Intrinsics.areEqual((Object) this.f7961pf, (Object) qwVar.f7961pf) && Intrinsics.areEqual((Object) this.f337if, (Object) qwVar.f337if);
    }

    @NotNull
    public final ArrayList<String> fe() {
        return this.f7958fe;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.qw.hashCode() * 31) + this.f7956ad) * 31) + this.f7957de) * 31) + this.f7958fe.hashCode()) * 31) + this.f7962rg) * 31) + this.f7963th) * 31) + this.f7965yj.hashCode()) * 31) + this.f7964uk.hashCode()) * 31) + this.f7959i.hashCode()) * 31) + this.f7960o.hashCode()) * 31) + this.f7961pf.hashCode()) * 31) + this.f337if.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f7960o;
    }

    @NotNull
    /* renamed from: if  reason: not valid java name */
    public final String m977if() {
        return this.f337if;
    }

    public final int o() {
        return this.f7962rg;
    }

    public final int pf() {
        return this.f7956ad;
    }

    @NotNull
    public final ArrayList<HashMap<String, Object>> qw() {
        return this.f7959i;
    }

    @NotNull
    public final String rg() {
        return this.f7961pf;
    }

    public final int th() {
        return this.f7963th;
    }

    @NotNull
    public String toString() {
        return "OCRRectifyData(images=" + this.qw + ", source=" + this.f7956ad + ", category=" + this.f7957de + ", dataList=" + this.f7958fe + ", scanMode=" + this.f7962rg + ", docScanFilterIndex=" + this.f7963th + ", cloudFiles=" + this.f7965yj + ", from=" + this.f7964uk + ", aiScanImages=" + this.f7959i + ", savePath=" + this.f7960o + ", docResourceFrom=" + this.f7961pf + ", ubcSource=" + this.f337if + ')';
    }

    @NotNull
    public final ArrayList<String> uk() {
        return this.qw;
    }

    @NotNull
    public final String yj() {
        return this.f7964uk;
    }
}
