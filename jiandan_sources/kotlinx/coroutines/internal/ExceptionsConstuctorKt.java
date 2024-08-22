package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ExceptionsConstuctorKt {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final ReentrantReadWriteLock f6441ad = new ReentrantReadWriteLock();
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f6442de = new WeakHashMap<>();
    public static final int qw = fe(Throwable.class, -1);

    public static final class qw<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }

    public static final int ad(Class<?> cls, int i2) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i3 = 0;
            Class<? super Object> cls2 = cls;
            for (int i4 = 0; i4 < length; i4++) {
                if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i2;
    }

    public static /* synthetic */ int de(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return ad(cls, i2);
    }

    public static final int fe(Class<?> cls, int i2) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m1155constructorimpl(Integer.valueOf(de(cls, 0, 1, (Object) null)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.m1161isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    public static final Function1<Throwable, Throwable> qw(Constructor<?> constructor) {
        Class<String> cls = String.class;
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class cls2 = parameterTypes[0];
            if (Intrinsics.areEqual((Object) cls2, (Object) Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.areEqual((Object) cls2, (Object) cls)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) cls) && Intrinsics.areEqual((Object) parameterTypes[1], (Object) Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.Nullable
    public static final <E extends java.lang.Throwable> E rg(@org.jetbrains.annotations.NotNull E r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.CopyableThrowable
            r1 = 0
            if (r0 == 0) goto L_0x0028
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0012 }
            kotlinx.coroutines.CopyableThrowable r9 = (kotlinx.coroutines.CopyableThrowable) r9     // Catch:{ all -> 0x0012 }
            java.lang.Throwable r9 = r9.createCopy()     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = kotlin.Result.m1155constructorimpl(r9)     // Catch:{ all -> 0x0012 }
            goto L_0x001d
        L_0x0012:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m1155constructorimpl(r9)
        L_0x001d:
            boolean r0 = kotlin.Result.m1161isFailureimpl(r9)
            if (r0 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = r9
        L_0x0025:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0028:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f6441ad
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r2 = f6442de     // Catch:{ all -> 0x011c }
            java.lang.Class r3 = r9.getClass()     // Catch:{ all -> 0x011c }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x011c }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x011c }
            r0.unlock()
            if (r2 != 0) goto L_0x0115
            int r0 = qw
            java.lang.Class r2 = r9.getClass()
            r3 = 0
            int r2 = fe(r2, r3)
            if (r0 == r2) goto L_0x0097
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f6441ad
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r4 = r0.getWriteHoldCount()
            if (r4 != 0) goto L_0x0060
            int r4 = r0.getReadHoldCount()
            goto L_0x0061
        L_0x0060:
            r4 = 0
        L_0x0061:
            r5 = 0
        L_0x0062:
            if (r5 >= r4) goto L_0x006a
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x0062
        L_0x006a:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r5 = f6442de     // Catch:{ all -> 0x008a }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x008a }
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1 r6 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x008a }
            r5.put(r9, r6)     // Catch:{ all -> 0x008a }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008a }
        L_0x007e:
            if (r3 >= r4) goto L_0x0086
            r2.lock()
            int r3 = r3 + 1
            goto L_0x007e
        L_0x0086:
            r0.unlock()
            return r1
        L_0x008a:
            r9 = move-exception
        L_0x008b:
            if (r3 >= r4) goto L_0x0093
            r2.lock()
            int r3 = r3 + 1
            goto L_0x008b
        L_0x0093:
            r0.unlock()
            throw r9
        L_0x0097:
            java.lang.Class r0 = r9.getClass()
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$qw r2 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$qw
            r2.<init>()
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysKt.sortedWith((T[]) r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x00ad:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00bf
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            kotlin.jvm.functions.Function1 r2 = qw(r2)
            if (r2 == 0) goto L_0x00ad
        L_0x00bf:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f6441ad
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r0.readLock()
            int r5 = r0.getWriteHoldCount()
            if (r5 != 0) goto L_0x00d0
            int r5 = r0.getReadHoldCount()
            goto L_0x00d1
        L_0x00d0:
            r5 = 0
        L_0x00d1:
            r6 = 0
        L_0x00d2:
            if (r6 >= r5) goto L_0x00da
            r4.unlock()
            int r6 = r6 + 1
            goto L_0x00d2
        L_0x00da:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r6 = f6442de     // Catch:{ all -> 0x0108 }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0108 }
            if (r2 != 0) goto L_0x00ec
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1 r8 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE     // Catch:{ all -> 0x0108 }
            goto L_0x00ed
        L_0x00ec:
            r8 = r2
        L_0x00ed:
            r6.put(r7, r8)     // Catch:{ all -> 0x0108 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0108 }
        L_0x00f2:
            if (r3 >= r5) goto L_0x00fa
            r4.lock()
            int r3 = r3 + 1
            goto L_0x00f2
        L_0x00fa:
            r0.unlock()
            if (r2 != 0) goto L_0x0100
            goto L_0x0107
        L_0x0100:
            java.lang.Object r9 = r2.invoke(r9)
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0107:
            return r1
        L_0x0108:
            r9 = move-exception
        L_0x0109:
            if (r3 >= r5) goto L_0x0111
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0109
        L_0x0111:
            r0.unlock()
            throw r9
        L_0x0115:
            java.lang.Object r9 = r2.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x011c:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.rg(java.lang.Throwable):java.lang.Throwable");
    }
}
