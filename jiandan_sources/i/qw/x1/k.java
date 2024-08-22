package i.qw.x1;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class k {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Object[] f6278ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final ThreadContextElement<Object>[] f6279de;

    /* renamed from: fe  reason: collision with root package name */
    public int f6280fe;
    @NotNull
    @JvmField
    public final CoroutineContext qw;

    public k(@NotNull CoroutineContext coroutineContext, int i2) {
        this.qw = coroutineContext;
        this.f6278ad = new Object[i2];
        this.f6279de = new ThreadContextElement[i2];
    }

    public final void ad(@NotNull CoroutineContext coroutineContext) {
        int length = this.f6279de.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                ThreadContextElement<Object> threadContextElement = this.f6279de[length];
                Intrinsics.checkNotNull(threadContextElement);
                threadContextElement.m656switch(coroutineContext, this.f6278ad[length]);
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final void qw(@NotNull ThreadContextElement<?> threadContextElement, @Nullable Object obj) {
        Object[] objArr = this.f6278ad;
        int i2 = this.f6280fe;
        objArr[i2] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f6279de;
        this.f6280fe = i2 + 1;
        threadContextElementArr[i2] = threadContextElement;
    }
}
