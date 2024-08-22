package fe.rg.qw;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.target.Target;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.when.ad;
import fe.rg.qw.when.de;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class rg<TranscodeType> implements Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public final Context f5022ad;
    public boolean ddd;
    @Nullable
    public Float ggg;

    /* renamed from: i  reason: collision with root package name */
    public final fe f5023i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public Object f190if;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    public ad f5024o;
    @NonNull

    /* renamed from: pf  reason: collision with root package name */
    public yj<?, ? super TranscodeType> f5025pf;
    @Nullable
    public rg<TranscodeType> ppp;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public List<RequestListener<TranscodeType>> f191switch;

    /* renamed from: th  reason: collision with root package name */
    public final th f5026th;

    /* renamed from: uk  reason: collision with root package name */
    public final ad f5027uk;
    public boolean vvv = true;
    @Nullable
    public rg<TranscodeType> when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Class<TranscodeType> f5028yj;

    public static /* synthetic */ class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f5029ad;
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5029ad = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5029ad     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5029ad     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f5029ad     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                qw = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = qw     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.rg.qw.<clinit>():void");
        }
    }

    static {
        new ad().yj(yj.f4914ad).x(Priority.LOW).E(true);
    }

    public rg(ad adVar, th thVar, Class<TranscodeType> cls, Context context) {
        this.f5026th = thVar;
        this.f5028yj = cls;
        this.f5027uk = thVar.m318if();
        this.f5022ad = context;
        this.f5025pf = thVar.m319switch(cls);
        this.f5024o = this.f5027uk;
        this.f5023i = adVar.i();
    }

    public final Request aaa(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, ad adVar, RequestCoordinator requestCoordinator, yj<?, ? super TranscodeType> yjVar, Priority priority, int i2, int i3) {
        Context context = this.f5022ad;
        fe feVar = this.f5023i;
        return SingleRequest.rrr(context, feVar, this.f190if, this.f5028yj, adVar, i2, i3, priority, target, requestListener, this.f191switch, requestCoordinator, feVar.rg(), yjVar.de());
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> ad(@Nullable RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.f191switch == null) {
                this.f191switch = new ArrayList();
            }
            this.f191switch.add(requestListener);
        }
        return this;
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> ddd(@Nullable Object obj) {
        mmm(obj);
        return this;
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> de(@NonNull ad adVar) {
        uk.fe(adVar);
        this.f5024o = uk().ad(adVar);
        return this;
    }

    public final Request fe(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, ad adVar) {
        return rg(target, requestListener, (RequestCoordinator) null, this.f5025pf, adVar.qqq(), adVar.nn(), adVar.ddd(), adVar);
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> ggg(@Nullable Uri uri) {
        mmm(uri);
        return this;
    }

    @NonNull
    public final Priority i(@NonNull Priority priority) {
        int i2 = qw.f5029ad[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.f5024o.qqq());
    }

    /* renamed from: if  reason: not valid java name */
    public final <Y extends Target<TranscodeType>> Y m316if(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, @NonNull ad adVar) {
        i.qw();
        uk.fe(y);
        if (this.xxx) {
            adVar.de();
            Request fe2 = fe(y, requestListener, adVar);
            Request request = y.getRequest();
            if (!fe2.uk(request) || when(adVar, request)) {
                this.f5026th.pf(y);
                y.th(fe2);
                this.f5026th.mmm(y, fe2);
                return y;
            }
            fe2.recycle();
            uk.fe(request);
            if (!request.isRunning()) {
                request.begin();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    public final rg<TranscodeType> mmm(@Nullable Object obj) {
        this.f190if = obj;
        this.xxx = true;
        return this;
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> nn(@Nullable String str) {
        mmm(str);
        return this;
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y o(@NonNull Y y) {
        pf(y, (RequestListener) null);
        return y;
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y pf(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener) {
        m316if(y, requestListener, uk());
        return y;
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> ppp(@Nullable RequestListener<TranscodeType> requestListener) {
        this.f191switch = null;
        ad(requestListener);
        return this;
    }

    public final Request rg(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, yj<?, ? super TranscodeType> yjVar, Priority priority, int i2, int i3, ad adVar) {
        fe.rg.qw.when.qw qwVar;
        fe.rg.qw.when.qw qwVar2;
        if (this.ppp != null) {
            qwVar2 = new fe.rg.qw.when.qw(requestCoordinator);
            qwVar = qwVar2;
        } else {
            qwVar = null;
            qwVar2 = requestCoordinator;
        }
        Request th2 = th(target, requestListener, qwVar2, yjVar, priority, i2, i3, adVar);
        if (qwVar == null) {
            return th2;
        }
        int nn = this.ppp.f5024o.nn();
        int ddd2 = this.ppp.f5024o.ddd();
        if (i.xxx(i2, i3) && !this.ppp.f5024o.n()) {
            nn = adVar.nn();
            ddd2 = adVar.ddd();
        }
        rg<TranscodeType> rgVar = this.ppp;
        fe.rg.qw.when.qw qwVar3 = qwVar;
        qwVar3.ggg(th2, rgVar.rg(target, requestListener, qwVar, rgVar.f5025pf, rgVar.f5024o.qqq(), nn, ddd2, this.ppp.f5024o));
        return qwVar3;
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public fe.rg.qw.when.fe.yj<ImageView, TranscodeType> m317switch(@NonNull ImageView imageView) {
        i.qw();
        uk.fe(imageView);
        ad adVar = this.f5024o;
        if (!adVar.m() && adVar.k() && imageView.getScaleType() != null) {
            switch (qw.qw[imageView.getScaleType().ordinal()]) {
                case 1:
                    adVar = adVar.clone().q();
                    break;
                case 2:
                    adVar = adVar.clone().r();
                    break;
                case 3:
                case 4:
                case 5:
                    adVar = adVar.clone().s();
                    break;
                case 6:
                    adVar = adVar.clone().r();
                    break;
            }
        }
        fe.rg.qw.when.fe.yj<ImageView, TranscodeType> qw2 = this.f5023i.qw(imageView, this.f5028yj);
        m316if(qw2, (RequestListener) null, adVar);
        return qw2;
    }

    public final Request th(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, yj<?, ? super TranscodeType> yjVar, Priority priority, int i2, int i3, ad adVar) {
        RequestCoordinator requestCoordinator2 = requestCoordinator;
        Priority priority2 = priority;
        rg<TranscodeType> rgVar = this.when;
        if (rgVar != null) {
            if (!this.ddd) {
                yj<?, ? super TranscodeType> yjVar2 = rgVar.vvv ? yjVar : rgVar.f5025pf;
                Priority qqq = this.when.f5024o.f() ? this.when.f5024o.qqq() : i(priority2);
                int nn = this.when.f5024o.nn();
                int ddd2 = this.when.f5024o.ddd();
                if (i.xxx(i2, i3) && !this.when.f5024o.n()) {
                    nn = adVar.nn();
                    ddd2 = adVar.ddd();
                }
                de deVar = new de(requestCoordinator2);
                Request aaa = aaa(target, requestListener, adVar, deVar, yjVar, priority, i2, i3);
                this.ddd = true;
                rg<TranscodeType> rgVar2 = this.when;
                de deVar2 = deVar;
                Request rg2 = rgVar2.rg(target, requestListener, deVar, yjVar2, qqq, nn, ddd2, rgVar2.f5024o);
                this.ddd = false;
                deVar2.ppp(aaa, rg2);
                return deVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.ggg == null) {
            return aaa(target, requestListener, adVar, requestCoordinator, yjVar, priority, i2, i3);
        } else {
            de deVar3 = new de(requestCoordinator2);
            RequestListener<TranscodeType> requestListener2 = requestListener;
            de deVar4 = deVar3;
            yj<?, ? super TranscodeType> yjVar3 = yjVar;
            int i4 = i2;
            int i5 = i3;
            deVar3.ppp(aaa(target, requestListener2, adVar, deVar4, yjVar3, priority, i4, i5), aaa(target, requestListener2, adVar.clone().D(this.ggg.floatValue()), deVar4, yjVar3, i(priority2), i4, i5));
            return deVar3;
        }
    }

    @NonNull
    public ad uk() {
        ad adVar = this.f5027uk;
        ad adVar2 = this.f5024o;
        return adVar == adVar2 ? adVar2.clone() : adVar2;
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> vvv(@Nullable File file) {
        mmm(file);
        return this;
    }

    public final boolean when(ad adVar, Request request) {
        return !adVar.e() && request.isComplete();
    }

    @CheckResult
    @NonNull
    public rg<TranscodeType> xxx(@RawRes @DrawableRes @Nullable Integer num) {
        mmm(num);
        de(ad.C(fe.rg.qw.ppp.qw.de(this.f5022ad)));
        return this;
    }

    @CheckResult
    /* renamed from: yj */
    public rg<TranscodeType> clone() {
        try {
            rg<TranscodeType> rgVar = (rg) super.clone();
            rgVar.f5024o = rgVar.f5024o.clone();
            rgVar.f5025pf = rgVar.f5025pf.clone();
            return rgVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
