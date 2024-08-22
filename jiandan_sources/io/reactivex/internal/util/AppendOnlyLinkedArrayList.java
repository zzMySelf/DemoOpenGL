package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.Predicate;

public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Object[] f10319ad;

    /* renamed from: de  reason: collision with root package name */
    public Object[] f10320de;

    /* renamed from: fe  reason: collision with root package name */
    public int f10321fe;
    public final int qw;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i2) {
        this.qw = i2;
        Object[] objArr = new Object[(i2 + 1)];
        this.f10319ad = objArr;
        this.f10320de = objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(T r4) {
        /*
            r3 = this;
            int r0 = r3.qw
            int r1 = r3.f10321fe
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f10320de
            r2[r0] = r1
            r3.f10320de = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f10320de
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f10321fe = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.ad(java.lang.Object):void");
    }

    public void de(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i2 = this.qw;
        for (Object[] objArr = this.f10319ad; objArr != null; objArr = objArr[i2]) {
            int i3 = 0;
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!nonThrowingPredicate.test(objArr2)) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void fe(T t) {
        this.f10319ad[0] = t;
    }

    public <U> boolean qw(Observer<? super U> observer) {
        Object[] objArr = this.f10319ad;
        int i2 = this.qw;
        while (true) {
            int i3 = 0;
            if (objArr == null) {
                return false;
            }
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, observer)) {
                    return true;
                } else {
                    i3++;
                }
            }
            objArr = objArr[i2];
        }
    }
}
