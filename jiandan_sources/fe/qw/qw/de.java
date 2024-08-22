package fe.qw.qw;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.p009switch.th;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public final HashSet<String> f3234ad = new HashSet<>();

    /* renamed from: de  reason: collision with root package name */
    public Map<String, List<Layer>> f3235de;

    /* renamed from: fe  reason: collision with root package name */
    public Map<String, th> f3236fe;

    /* renamed from: i  reason: collision with root package name */
    public List<Layer> f3237i;

    /* renamed from: if  reason: not valid java name */
    public float f100if;

    /* renamed from: o  reason: collision with root package name */
    public Rect f3238o;

    /* renamed from: pf  reason: collision with root package name */
    public float f3239pf;
    public int ppp = 0;
    public final PerformanceTracker qw = new PerformanceTracker();

    /* renamed from: rg  reason: collision with root package name */
    public Map<String, fe.qw.qw.p009switch.ad> f3240rg;

    /* renamed from: switch  reason: not valid java name */
    public float f101switch;

    /* renamed from: th  reason: collision with root package name */
    public List<th> f3241th;

    /* renamed from: uk  reason: collision with root package name */
    public LongSparseArray<Layer> f3242uk;
    public boolean when;

    /* renamed from: yj  reason: collision with root package name */
    public SparseArrayCompat<fe.qw.qw.p009switch.de> f3243yj;

    @Deprecated
    public static class ad {

        public static final class qw implements LottieListener<de>, Cancellable {

            /* renamed from: ad  reason: collision with root package name */
            public boolean f3244ad;
            public final OnCompositionLoadedListener qw;

            /* renamed from: qw */
            public void onResult(de deVar) {
                if (!this.f3244ad) {
                    this.qw.qw(deVar);
                }
            }

            public qw(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.f3244ad = false;
                this.qw = onCompositionLoadedListener;
            }
        }

        @Deprecated
        public static Cancellable qw(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            qw qwVar = new qw(onCompositionLoadedListener);
            fe.fe(context, str).th(qwVar);
            return qwVar;
        }
    }

    public Rect ad() {
        return this.f3238o;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer ddd(long j) {
        return this.f3242uk.get(j);
    }

    public SparseArrayCompat<fe.qw.qw.p009switch.de> de() {
        return this.f3243yj;
    }

    public float fe() {
        return (float) ((long) ((rg() / this.f101switch) * 1000.0f));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean ggg() {
        return this.when;
    }

    public Map<String, th> i() {
        return this.f3236fe;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: if  reason: not valid java name */
    public int m226if() {
        return this.ppp;
    }

    public void mmm(boolean z) {
        this.qw.ad(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void nn(boolean z) {
        this.when = z;
    }

    public List<Layer> o() {
        return this.f3237i;
    }

    @Nullable
    public th pf(String str) {
        this.f3241th.size();
        for (int i2 = 0; i2 < this.f3241th.size(); i2++) {
            th thVar = this.f3241th.get(i2);
            if (thVar.qw(str)) {
                return thVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float ppp() {
        return this.f3239pf;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void qw(String str) {
        fe.de(str);
        this.f3234ad.add(str);
    }

    public float rg() {
        return this.f100if - this.f3239pf;
    }

    /* renamed from: switch  reason: not valid java name */
    public PerformanceTracker m227switch() {
        return this.qw;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float th() {
        return this.f100if;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer qqq : this.f3237i) {
            sb.append(qqq.qqq("\t"));
        }
        return sb.toString();
    }

    public float uk() {
        return this.f101switch;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void vvv(int i2) {
        this.ppp += i2;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> when(String str) {
        return this.f3235de.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xxx(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, th> map2, SparseArrayCompat<fe.qw.qw.p009switch.de> sparseArrayCompat, Map<String, fe.qw.qw.p009switch.ad> map3, List<th> list2) {
        this.f3238o = rect;
        this.f3239pf = f;
        this.f100if = f2;
        this.f101switch = f3;
        this.f3237i = list;
        this.f3242uk = longSparseArray;
        this.f3235de = map;
        this.f3236fe = map2;
        this.f3243yj = sparseArrayCompat;
        this.f3240rg = map3;
        this.f3241th = list2;
    }

    public Map<String, fe.qw.qw.p009switch.ad> yj() {
        return this.f3240rg;
    }
}
