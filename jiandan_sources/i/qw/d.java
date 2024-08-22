package i.qw;

import i.qw.z1.qw;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d {
    public static final boolean qw;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r0.equals("on") != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r0.equals("") != false) goto L_0x0053;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = i.qw.x1.d.fe(r0)
            if (r0 == 0) goto L_0x0053
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x002a
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x0021
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L_0x0033
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0054
        L_0x0021:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0033
            goto L_0x0053
        L_0x002a:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0053:
            r0 = 1
        L_0x0054:
            qw = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.d.<clinit>():void");
    }

    @Nullable
    public static final String ad(@NotNull CoroutineContext coroutineContext) {
        g gVar;
        String xxx;
        if (!k.de() || (gVar = (g) coroutineContext.get(g.f6124th)) == null) {
            return null;
        }
        h hVar = (h) coroutineContext.get(h.f6133th);
        String str = "coroutine";
        if (!(hVar == null || (xxx = hVar.xxx()) == null)) {
            str = xxx;
        }
        return str + '#' + gVar.xxx();
    }

    @NotNull
    public static final CoroutineContext de(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = k.de() ? plus.plus(new g(k.ad().incrementAndGet())) : plus;
        u uVar = u.qw;
        if (plus == u.qw() || plus.get(ContinuationInterceptor.Key) != null) {
            return plus2;
        }
        u uVar2 = u.qw;
        return plus2.plus(u.qw());
    }

    @Nullable
    public static final p1<?> fe(@NotNull CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof q) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof p1) {
                return (p1) coroutineStackFrame;
            }
        }
        return null;
    }

    @NotNull
    public static final CoroutineDispatcher qw() {
        return qw ? qw.f6317o : aaa.f6101ad;
    }

    @Nullable
    public static final p1<?> rg(@NotNull Continuation<?> continuation, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (!(coroutineContext.get(q1.f6160ad) != null)) {
            return null;
        }
        p1<?> fe2 = fe((CoroutineStackFrame) continuation);
        if (fe2 != null) {
            fe2.w0(coroutineContext, obj);
        }
        return fe2;
    }
}
