package fe.uk.qw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.RequestCoordinator;
import com.dxmbumptech.glide.request.RequestListener;
import com.dxmbumptech.glide.request.SingleRequest;
import com.dxmbumptech.glide.request.target.Target;
import fe.uk.qw.pf.fe.yj;
import fe.uk.qw.ppp.ad;
import fe.uk.qw.ppp.de;
import fe.uk.qw.vvv.fe;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class th<TranscodeType> extends fe.uk.qw.ppp.qw<th<TranscodeType>> implements Cloneable {
    public final Context j;
    public final yj k;
    public final Class<TranscodeType> l;
    public final fe m;
    @NonNull
    public uk<?, ? super TranscodeType> n;
    @Nullable
    public Object p;
    @Nullable
    public List<RequestListener<TranscodeType>> q;
    @Nullable
    public th<TranscodeType> r;
    @Nullable
    public th<TranscodeType> s;
    @Nullable
    public Float t;
    public boolean u = true;
    public boolean v;
    public boolean w;

    public static /* synthetic */ class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f6040ad;
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
                com.dxmbumptech.glide.Priority[] r0 = com.dxmbumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6040ad = r0
                r1 = 1
                com.dxmbumptech.glide.Priority r2 = com.dxmbumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f6040ad     // Catch:{ NoSuchFieldError -> 0x001d }
                com.dxmbumptech.glide.Priority r3 = com.dxmbumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f6040ad     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.dxmbumptech.glide.Priority r4 = com.dxmbumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f6040ad     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.dxmbumptech.glide.Priority r5 = com.dxmbumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
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
            throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.th.qw.<clinit>():void");
        }
    }

    static {
        de deVar = (de) ((de) ((de) new de().th(yj.f5890ad)).u(Priority.LOW)).B(true);
    }

    @SuppressLint({"CheckResult"})
    public th(@NonNull Glide glide, yj yjVar, Class<TranscodeType> cls, Context context) {
        this.k = yjVar;
        this.l = cls;
        this.j = context;
        this.n = yjVar.when(cls);
        this.m = glide.i();
        O(yjVar.m394if());
        ad(yjVar.m395switch());
    }

    @CheckResult
    @NonNull
    public th<TranscodeType> H(@Nullable RequestListener<TranscodeType> requestListener) {
        if (a()) {
            return fe().H(requestListener);
        }
        if (requestListener != null) {
            if (this.q == null) {
                this.q = new ArrayList();
            }
            this.q.add(requestListener);
        }
        x();
        return this;
    }

    @CheckResult
    @NonNull
    /* renamed from: I */
    public th<TranscodeType> ad(@NonNull fe.uk.qw.ppp.qw<?> qwVar) {
        i.fe(qwVar);
        return (th) super.ad(qwVar);
    }

    public final Request J(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, fe.uk.qw.ppp.qw<?> qwVar, Executor executor) {
        return K(new Object(), target, requestListener, (RequestCoordinator) null, this.n, qwVar.ddd(), qwVar.ggg(), qwVar.ppp(), qwVar, executor);
    }

    public final Request K(Object obj, Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, uk<?, ? super TranscodeType> ukVar, Priority priority, int i2, int i3, fe.uk.qw.ppp.qw<?> qwVar, Executor executor) {
        ad adVar;
        ad adVar2;
        if (this.s != null) {
            adVar2 = new ad(obj, requestCoordinator);
            adVar = adVar2;
        } else {
            Object obj2 = obj;
            adVar = null;
            adVar2 = requestCoordinator;
        }
        Request L = L(obj, target, requestListener, adVar2, ukVar, priority, i2, i3, qwVar, executor);
        if (adVar == null) {
            return L;
        }
        int ggg = this.s.ggg();
        int ppp = this.s.ppp();
        if (o.ddd(i2, i3) && !this.s.k()) {
            ggg = qwVar.ggg();
            ppp = qwVar.ppp();
        }
        th<TranscodeType> thVar = this.s;
        ad adVar3 = adVar;
        adVar3.m384switch(L, thVar.K(obj, target, requestListener, adVar3, thVar.n, thVar.ddd(), ggg, ppp, this.s, executor));
        return adVar3;
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [fe.uk.qw.ppp.qw<?>, fe.uk.qw.ppp.qw] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.dxmbumptech.glide.request.Request L(java.lang.Object r19, com.dxmbumptech.glide.request.target.Target<TranscodeType> r20, com.dxmbumptech.glide.request.RequestListener<TranscodeType> r21, @androidx.annotation.Nullable com.dxmbumptech.glide.request.RequestCoordinator r22, fe.uk.qw.uk<?, ? super TranscodeType> r23, com.dxmbumptech.glide.Priority r24, int r25, int r26, fe.uk.qw.ppp.qw<?> r27, java.util.concurrent.Executor r28) {
        /*
            r18 = this;
            r11 = r18
            r12 = r19
            r5 = r22
            r13 = r24
            fe.uk.qw.th<TranscodeType> r0 = r11.r
            if (r0 == 0) goto L_0x0096
            boolean r1 = r11.w
            if (r1 != 0) goto L_0x008e
            fe.uk.qw.uk<?, ? super TranscodeType> r1 = r0.n
            boolean r0 = r0.u
            if (r0 == 0) goto L_0x0019
            r14 = r23
            goto L_0x001a
        L_0x0019:
            r14 = r1
        L_0x001a:
            fe.uk.qw.th<TranscodeType> r0 = r11.r
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0029
            fe.uk.qw.th<TranscodeType> r0 = r11.r
            com.dxmbumptech.glide.Priority r0 = r0.ddd()
            goto L_0x002d
        L_0x0029:
            com.dxmbumptech.glide.Priority r0 = r11.N(r13)
        L_0x002d:
            r15 = r0
            fe.uk.qw.th<TranscodeType> r0 = r11.r
            int r0 = r0.ggg()
            fe.uk.qw.th<TranscodeType> r1 = r11.r
            int r1 = r1.ppp()
            boolean r2 = fe.uk.qw.vvv.o.ddd(r25, r26)
            if (r2 == 0) goto L_0x0050
            fe.uk.qw.th<TranscodeType> r2 = r11.r
            boolean r2 = r2.k()
            if (r2 != 0) goto L_0x0050
            int r0 = r27.ggg()
            int r1 = r27.ppp()
        L_0x0050:
            r16 = r0
            r17 = r1
            fe.uk.qw.ppp.fe r10 = new fe.uk.qw.ppp.fe
            r10.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r10
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r13 = r10
            r10 = r28
            com.dxmbumptech.glide.request.Request r10 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 1
            r11.w = r0
            fe.uk.qw.th<TranscodeType> r9 = r11.r
            r0 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r12 = r10
            r10 = r28
            com.dxmbumptech.glide.request.Request r0 = r0.K(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 0
            r11.w = r1
            r13.m385if(r12, r0)
            return r13
        L_0x008e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x0096:
            java.lang.Float r0 = r11.t
            if (r0 == 0) goto L_0x00d6
            fe.uk.qw.ppp.fe r14 = new fe.uk.qw.ppp.fe
            r14.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r14
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.dxmbumptech.glide.request.Request r15 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            fe.uk.qw.ppp.qw r0 = r27.clone()
            java.lang.Float r1 = r11.t
            float r1 = r1.floatValue()
            fe.uk.qw.ppp.qw r4 = r0.A(r1)
            com.dxmbumptech.glide.Priority r7 = r11.N(r13)
            r0 = r18
            r1 = r19
            com.dxmbumptech.glide.request.Request r0 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.m385if(r15, r0)
            return r14
        L_0x00d6:
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            com.dxmbumptech.glide.request.Request r0 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.th.L(java.lang.Object, com.dxmbumptech.glide.request.target.Target, com.dxmbumptech.glide.request.RequestListener, com.dxmbumptech.glide.request.RequestCoordinator, fe.uk.qw.uk, com.dxmbumptech.glide.Priority, int, int, fe.uk.qw.ppp.qw, java.util.concurrent.Executor):com.dxmbumptech.glide.request.Request");
    }

    @CheckResult
    /* renamed from: M */
    public th<TranscodeType> fe() {
        th<TranscodeType> thVar = (th) super.clone();
        thVar.n = thVar.n.clone();
        if (thVar.q != null) {
            thVar.q = new ArrayList(thVar.q);
        }
        th<TranscodeType> thVar2 = thVar.r;
        if (thVar2 != null) {
            thVar.r = thVar2.fe();
        }
        th<TranscodeType> thVar3 = thVar.s;
        if (thVar3 != null) {
            thVar.s = thVar3.fe();
        }
        return thVar;
    }

    @NonNull
    public final Priority N(@NonNull Priority priority) {
        int i2 = qw.f6040ad[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + ddd());
    }

    @SuppressLint({"CheckResult"})
    public final void O(List<RequestListener<Object>> list) {
        for (RequestListener<Object> H : list) {
            H(H);
        }
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y P(@NonNull Y y) {
        R(y, (RequestListener) null, fe.ad());
        return y;
    }

    public final <Y extends Target<TranscodeType>> Y Q(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, fe.uk.qw.ppp.qw<?> qwVar, Executor executor) {
        i.fe(y);
        if (this.v) {
            Request J = J(y, requestListener, qwVar, executor);
            Request request = y.getRequest();
            if (!J.uk(request) || T(qwVar, request)) {
                this.k.pf(y);
                y.yj(J);
                this.k.mmm(y, J);
                return y;
            }
            i.fe(request);
            if (!request.isRunning()) {
                request.begin();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y R(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, Executor executor) {
        Q(y, requestListener, this, executor);
        return y;
    }

    @NonNull
    public fe.uk.qw.ppp.rg.yj<ImageView, TranscodeType> S(@NonNull ImageView imageView) {
        fe.uk.qw.ppp.qw qwVar;
        o.qw();
        i.fe(imageView);
        if (!j() && g() && imageView.getScaleType() != null) {
            switch (qw.qw[imageView.getScaleType().ordinal()]) {
                case 1:
                    qwVar = fe().m();
                    break;
                case 2:
                    qwVar = fe().n();
                    break;
                case 3:
                case 4:
                case 5:
                    qwVar = fe().p();
                    break;
                case 6:
                    qwVar = fe().n();
                    break;
            }
        }
        qwVar = this;
        fe.uk.qw.ppp.rg.yj<ImageView, TranscodeType> qw2 = this.m.qw(imageView, this.l);
        Q(qw2, (RequestListener) null, qwVar, fe.ad());
        return qw2;
    }

    public final boolean T(fe.uk.qw.ppp.qw<?> qwVar, Request request) {
        return !qwVar.b() && request.isComplete();
    }

    @CheckResult
    @NonNull
    public th<TranscodeType> U(@Nullable RequestListener<TranscodeType> requestListener) {
        if (a()) {
            return fe().U(requestListener);
        }
        this.q = null;
        return H(requestListener);
    }

    @CheckResult
    @NonNull
    public th<TranscodeType> V(@Nullable Object obj) {
        return X(obj);
    }

    @CheckResult
    @NonNull
    public th<TranscodeType> W(@Nullable String str) {
        return X(str);
    }

    @NonNull
    public final th<TranscodeType> X(@Nullable Object obj) {
        if (a()) {
            return fe().X(obj);
        }
        this.p = obj;
        this.v = true;
        x();
        return this;
    }

    public final Request Y(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, fe.uk.qw.ppp.qw<?> qwVar, RequestCoordinator requestCoordinator, uk<?, ? super TranscodeType> ukVar, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.j;
        fe feVar = this.m;
        return SingleRequest.aaa(context, feVar, obj, this.p, this.l, qwVar, i2, i3, priority, target, requestListener, this.q, requestCoordinator, feVar.th(), ukVar.de(), executor);
    }
}
