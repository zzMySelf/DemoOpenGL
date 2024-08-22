package i.qw.x1;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class qw<T> {

    /* renamed from: ad  reason: collision with root package name */
    public int f6285ad;

    /* renamed from: de  reason: collision with root package name */
    public int f6286de;
    @NotNull
    public Object[] qw = new Object[16];

    public final void ad() {
        Object[] objArr = this.qw;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr3, 0, this.f6285ad, 0, 10, (Object) null);
        Object[] objArr4 = this.qw;
        int length2 = objArr4.length;
        int i2 = this.f6285ad;
        ArraysKt___ArraysJvmKt.copyInto$default(objArr4, objArr2, length2 - i2, 0, i2, 4, (Object) null);
        this.qw = objArr3;
        this.f6285ad = 0;
        this.f6286de = length;
    }

    public final boolean de() {
        return this.f6285ad == this.f6286de;
    }

    @Nullable
    public final T fe() {
        int i2 = this.f6285ad;
        if (i2 == this.f6286de) {
            return null;
        }
        T[] tArr = this.qw;
        T t = tArr[i2];
        tArr[i2] = null;
        this.f6285ad = (i2 + 1) & (tArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }

    public final void qw(@NotNull T t) {
        Object[] objArr = this.qw;
        int i2 = this.f6286de;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.f6286de = length;
        if (length == this.f6285ad) {
            ad();
        }
    }
}
