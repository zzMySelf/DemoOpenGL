package com.baidu.apsaras.scheduler;

import com.baidu.apsaras.scheduler.ParticleContext;
import com.baidu.searchbox.lockscreen.config.BubbleConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0000\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J(\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\nH\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\t\u001a\u00020\u00012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/baidu/apsaras/scheduler/ParticleContextArray;", "Lcom/baidu/apsaras/scheduler/ParticleContext;", "base", "Lcom/baidu/apsaras/scheduler/ParticleContextElement;", "new", "(Lcom/baidu/apsaras/scheduler/ParticleContextElement;Lcom/baidu/apsaras/scheduler/ParticleContextElement;)V", "(Lcom/baidu/apsaras/scheduler/ParticleContextArray;Lcom/baidu/apsaras/scheduler/ParticleContextArray;)V", "(Lcom/baidu/apsaras/scheduler/ParticleContextArray;Lcom/baidu/apsaras/scheduler/ParticleContextElement;)V", "baseContextArray", "minusKey", "Lcom/baidu/apsaras/scheduler/ParticleContext$Key;", "(Lcom/baidu/apsaras/scheduler/ParticleContextArray;Lcom/baidu/apsaras/scheduler/ParticleContext$Key;)V", "arrays", "", "[Lcom/baidu/apsaras/scheduler/ParticleContextElement;", "equals", "", "other", "", "get", "E", "key", "(Lcom/baidu/apsaras/scheduler/ParticleContext$Key;)Lcom/baidu/apsaras/scheduler/ParticleContextElement;", "hashCode", "", "plus", "context", "toArrayString", "", "toString", "lib-apsaras_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParticleContextImpl.kt */
public final class ParticleContextArray implements ParticleContext {
    private final ParticleContextElement[] arrays;

    public ParticleContextArray(ParticleContextElement base, ParticleContextElement particleContextElement) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(particleContextElement, "new");
        ParticleContextElement[] particleContextElementArr = new ParticleContextElement[Math.max(base.getKey().getIndex$lib_apsaras_release() + 1, particleContextElement.getKey().getIndex$lib_apsaras_release() + 1)];
        this.arrays = particleContextElementArr;
        particleContextElementArr[base.getKey().getIndex$lib_apsaras_release()] = base;
        particleContextElementArr[particleContextElement.getKey().getIndex$lib_apsaras_release()] = particleContextElement;
    }

    public ParticleContextArray(ParticleContextArray base, ParticleContextArray particleContextArray) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(particleContextArray, "new");
        ParticleContextElement[] particleContextElementArr = new ParticleContextElement[Math.max(base.arrays.length, particleContextArray.arrays.length)];
        this.arrays = particleContextElementArr;
        ArraysKt.copyInto$default((Object[]) base.arrays, (Object[]) particleContextElementArr, 0, 0, 0, 14, (Object) null);
        int newSize = particleContextArray.arrays.length;
        for (int i2 = 0; i2 < newSize; i2++) {
            ParticleContextElement newElement = particleContextArray.arrays[i2];
            if (newElement != null) {
                this.arrays[i2] = newElement;
            }
        }
    }

    public ParticleContextArray(ParticleContextArray base, ParticleContextElement particleContextElement) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(particleContextElement, "new");
        ParticleContextElement[] particleContextElementArr = new ParticleContextElement[Math.max(base.arrays.length, particleContextElement.getKey().getIndex$lib_apsaras_release() + 1)];
        this.arrays = particleContextElementArr;
        ArraysKt.copyInto$default((Object[]) base.arrays, (Object[]) particleContextElementArr, 0, 0, 0, 14, (Object) null);
        particleContextElementArr[particleContextElement.getKey().getIndex$lib_apsaras_release()] = particleContextElement;
    }

    public ParticleContextArray(ParticleContextArray baseContextArray, ParticleContext.Key<?> minusKey) {
        Intrinsics.checkNotNullParameter(baseContextArray, "baseContextArray");
        Intrinsics.checkNotNullParameter(minusKey, "minusKey");
        int index$lib_apsaras_release = minusKey.getIndex$lib_apsaras_release() + 1;
        ParticleContextElement[] particleContextElementArr = baseContextArray.arrays;
        if (index$lib_apsaras_release > particleContextElementArr.length) {
            this.arrays = particleContextElementArr;
            return;
        }
        int index$lib_apsaras_release2 = minusKey.getIndex$lib_apsaras_release() + 1;
        ParticleContextElement[] particleContextElementArr2 = baseContextArray.arrays;
        if (index$lib_apsaras_release2 == particleContextElementArr2.length) {
            Object[] copyOf = Arrays.copyOf(particleContextElementArr2, minusKey.getIndex$lib_apsaras_release());
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.arrays = (ParticleContextElement[]) copyOf;
            return;
        }
        Object[] copyOf2 = Arrays.copyOf(particleContextElementArr2, particleContextElementArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        ParticleContextElement[] particleContextElementArr3 = (ParticleContextElement[]) copyOf2;
        this.arrays = particleContextElementArr3;
        particleContextElementArr3[minusKey.getIndex$lib_apsaras_release()] = null;
    }

    public <E extends ParticleContextElement> E get(ParticleContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index$lib_apsaras_release = key.getIndex$lib_apsaras_release();
        E[] eArr = this.arrays;
        if (index$lib_apsaras_release < eArr.length) {
            return eArr[key.getIndex$lib_apsaras_release()];
        }
        return null;
    }

    public ParticleContext plus(ParticleContext context) {
        ParticleContextArray particleContextArray;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context == EmptyParticleContext.INSTANCE) {
            return this;
        }
        if (context instanceof ParticleContextElement) {
            particleContextArray = new ParticleContextArray(this, (ParticleContextElement) context);
        } else if (context instanceof ParticleContextArray) {
            particleContextArray = new ParticleContextArray(this, (ParticleContextArray) context);
        } else {
            throw new IllegalArgumentException("Unsupported context: " + context);
        }
        return particleContextArray;
    }

    public ParticleContext minusKey(ParticleContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (get(key) == null) {
            return this;
        }
        return new ParticleContextArray(this, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            ParticleContextArray particleContextArray = (ParticleContextArray) other;
            if (!Arrays.equals(this.arrays, ((ParticleContextArray) other).arrays)) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.apsaras.scheduler.ParticleContextArray");
    }

    public int hashCode() {
        return Arrays.hashCode(this.arrays);
    }

    public String toString() {
        return "ParticleContextArray(arrays=" + toArrayString() + ')';
    }

    private final String toArrayString() {
        ParticleContextElement[] particleContextElementArr = this.arrays;
        if (particleContextElementArr == null) {
            return "null";
        }
        int iMax = particleContextElementArr.length - 1;
        if (iMax == -1) {
            return BubbleConfig.BUBBLE_EMPTY_DATA_STR;
        }
        StringBuilder b2 = new StringBuilder();
        b2.append(AbstractJsonLexerKt.BEGIN_LIST);
        int length = this.arrays.length;
        for (int i2 = 0; i2 < length; i2++) {
            ParticleContextElement element = this.arrays[i2];
            if (element == null) {
                b2.append("null");
            } else {
                b2.append("index: " + element.getKey().getIndex$lib_apsaras_release() + " ,value: " + element);
            }
            if (i2 == iMax) {
                String sb = b2.append(AbstractJsonLexerKt.END_LIST).toString();
                Intrinsics.checkNotNullExpressionValue(sb, "b.append(']').toString()");
                return sb;
            }
            b2.append(", ");
        }
        String sb2 = b2.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "b.toString()");
        return sb2;
    }
}
