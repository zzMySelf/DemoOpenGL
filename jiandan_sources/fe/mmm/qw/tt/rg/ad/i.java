package fe.mmm.qw.tt.rg.ad;

import com.otaliastudios.cameraview.size.SizeSelector;
import fe.vvv.qw.xxx.ad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i implements SizeSelector {

    /* renamed from: ad  reason: collision with root package name */
    public int f8470ad;

    /* renamed from: de  reason: collision with root package name */
    public int f8471de;

    /* renamed from: fe  reason: collision with root package name */
    public float f8472fe;
    @Nullable
    public ad qw;

    public static final class qw<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((ad) t2).fe()), Integer.valueOf(((ad) t).fe()));
        }
    }

    public i(@Nullable ad adVar) {
        this.qw = adVar;
        this.f8470ad = 5000;
        this.f8471de = 1000;
        this.f8472fe = 0.75f;
    }

    @Nullable
    public final ad ad() {
        return this.qw;
    }

    public final boolean de() {
        return this.qw == null;
    }

    public final void fe() {
        this.qw = null;
    }

    @NotNull
    public List<ad> qw(@NotNull List<ad> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ad adVar = this.qw;
        if (adVar != null) {
            if (list.contains(adVar)) {
                return CollectionsKt__CollectionsKt.mutableListOf(adVar);
            }
            int max = (Math.max(adVar.rg(), adVar.fe()) / 1000) * 1000;
            ad rg2 = rg(list, max, max + 1000, this.f8472fe);
            if (rg2 != null) {
                return CollectionsKt__CollectionsKt.mutableListOf(rg2);
            }
        }
        int i2 = this.f8471de;
        ArrayList arrayList = new ArrayList();
        while (i2 < this.f8470ad) {
            int i3 = i2 + 1000;
            ad rg3 = rg(list, i2, i3, this.f8472fe);
            if (rg3 != null) {
                arrayList.add(rg3);
            }
            i2 = i3;
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new qw());
        }
        return arrayList;
    }

    public final ad rg(List<ad> list, int i2, int i3, float f) {
        ad adVar = null;
        float f2 = Float.MAX_VALUE;
        for (ad adVar2 : list) {
            if (adVar2.fe() > adVar2.rg()) {
                int fe2 = adVar2.fe();
                boolean z = false;
                if (i2 <= fe2 && fe2 < i3) {
                    z = true;
                }
                if (z) {
                    float abs = Math.abs(((((float) adVar2.fe()) * 1.0f) / ((float) adVar2.rg())) - f);
                    if (abs <= f2) {
                        adVar = adVar2;
                        f2 = abs;
                    }
                }
            }
        }
        return adVar;
    }

    public final void th(@Nullable ad adVar) {
        this.qw = adVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(ad adVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : adVar);
    }
}
