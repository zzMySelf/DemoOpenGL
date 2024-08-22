package com.mars.kotlin.extension;

import android.util.LruCache;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/mars/kotlin/extension/Logger;", "", "()V", "cache", "Landroid/util/LruCache;", "", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "tag", "tag$logger_release", "logger_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Logger {
    @NotNull
    public static final Logger INSTANCE = new Logger();
    @NotNull
    public static final LruCache<String, String> cache = new LruCache<>(10000);
    public static boolean enable;

    public final boolean getEnable() {
        return enable;
    }

    public final void setEnable(boolean z) {
        enable = z;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0113 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0121 A[Catch:{ all -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a7 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String tag$logger_release() {
        /*
            r13 = this;
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r1 = "Exception().stackTrace"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.sequences.Sequence r0 = kotlin.collections.ArraysKt___ArraysKt.asSequence((T[]) r0)
            com.mars.kotlin.extension.Logger$tag$1 r1 = com.mars.kotlin.extension.Logger$tag$1.INSTANCE
            kotlin.sequences.Sequence r0 = kotlin.sequences.SequencesKt___SequencesKt.filterNot(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01e1
            java.lang.Object r1 = r0.next()
            java.lang.StackTraceElement r1 = (java.lang.StackTraceElement) r1
            java.lang.String r8 = r1.getClassName()
            android.util.LruCache<java.lang.String, java.lang.String> r2 = cache
            java.lang.Object r2 = r2.get(r8)
            java.lang.String r2 = (java.lang.String) r2
            r9 = 58
            if (r2 != 0) goto L_0x01ca
            java.lang.String r2 = "className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            r2 = 2
            r3 = 0
            java.lang.String r4 = "$"
            r10 = 0
            boolean r2 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r4, (boolean) r10, (int) r2, (java.lang.Object) r3)
            r11 = 95
            java.lang.String r12 = "callerClass.declaredMethods"
            if (r2 == 0) goto L_0x0113
            java.lang.String[] r3 = new java.lang.String[]{r4}
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r8
            java.util.List r2 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, (java.lang.String[]) r3, (boolean) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Object r2 = r2.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0113 }
            java.lang.Class<com.mars.kotlin.extension.Tag> r3 = com.mars.kotlin.extension.Tag.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)     // Catch:{ all -> 0x0113 }
            com.mars.kotlin.extension.Tag r3 = (com.mars.kotlin.extension.Tag) r3     // Catch:{ all -> 0x0113 }
            if (r3 != 0) goto L_0x00f3
            java.lang.String r3 = r1.getMethodName()     // Catch:{ all -> 0x0113 }
            java.lang.reflect.Method[] r2 = r2.getDeclaredMethods()     // Catch:{ all -> 0x0113 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r12)     // Catch:{ all -> 0x0113 }
            kotlin.sequences.Sequence r2 = kotlin.collections.ArraysKt___ArraysKt.asSequence((T[]) r2)     // Catch:{ all -> 0x0113 }
            com.mars.kotlin.extension.Logger$tag$2$3 r4 = new com.mars.kotlin.extension.Logger$tag$2$3     // Catch:{ all -> 0x0113 }
            r4.<init>(r3)     // Catch:{ all -> 0x0113 }
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt___SequencesKt.filter(r2, r4)     // Catch:{ all -> 0x0113 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0113 }
        L_0x0089:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x0113
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0113 }
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r5.<init>()     // Catch:{ all -> 0x0113 }
            r5.append(r8)     // Catch:{ all -> 0x0113 }
            r5.append(r11)     // Catch:{ all -> 0x0113 }
            r5.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0113 }
            android.util.LruCache<java.lang.String, java.lang.String> r6 = cache     // Catch:{ all -> 0x0113 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x0113 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0113 }
            if (r6 == 0) goto L_0x00c8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r2.<init>()     // Catch:{ all -> 0x0113 }
            r2.append(r6)     // Catch:{ all -> 0x0113 }
            r2.append(r9)     // Catch:{ all -> 0x0113 }
            int r3 = r1.getLineNumber()     // Catch:{ all -> 0x0113 }
            r2.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0113 }
            return r0
        L_0x00c8:
            java.lang.Class<com.mars.kotlin.extension.Tag> r6 = com.mars.kotlin.extension.Tag.class
            java.lang.annotation.Annotation r4 = r4.getAnnotation(r6)     // Catch:{ all -> 0x0113 }
            com.mars.kotlin.extension.Tag r4 = (com.mars.kotlin.extension.Tag) r4     // Catch:{ all -> 0x0113 }
            if (r4 != 0) goto L_0x00d3
            goto L_0x0089
        L_0x00d3:
            java.lang.String r2 = r4.value()     // Catch:{ all -> 0x0113 }
            android.util.LruCache<java.lang.String, java.lang.String> r3 = cache     // Catch:{ all -> 0x0113 }
            r3.put(r5, r2)     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r3.<init>()     // Catch:{ all -> 0x0113 }
            r3.append(r2)     // Catch:{ all -> 0x0113 }
            r3.append(r9)     // Catch:{ all -> 0x0113 }
            int r2 = r1.getLineNumber()     // Catch:{ all -> 0x0113 }
            r3.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0113 }
            return r0
        L_0x00f3:
            java.lang.String r2 = r3.value()     // Catch:{ all -> 0x0113 }
            android.util.LruCache<java.lang.String, java.lang.String> r3 = cache     // Catch:{ all -> 0x0113 }
            r3.put(r8, r2)     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r3.<init>()     // Catch:{ all -> 0x0113 }
            r3.append(r2)     // Catch:{ all -> 0x0113 }
            r3.append(r9)     // Catch:{ all -> 0x0113 }
            int r2 = r1.getLineNumber()     // Catch:{ all -> 0x0113 }
            r3.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0113 }
            return r0
        L_0x0113:
            java.lang.Class r2 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x01c7 }
            java.lang.Class<com.mars.kotlin.extension.Tag> r3 = com.mars.kotlin.extension.Tag.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)     // Catch:{ all -> 0x01c7 }
            com.mars.kotlin.extension.Tag r3 = (com.mars.kotlin.extension.Tag) r3     // Catch:{ all -> 0x01c7 }
            if (r3 != 0) goto L_0x01a7
            java.lang.String r3 = r1.getMethodName()     // Catch:{ all -> 0x01c7 }
            java.lang.reflect.Method[] r2 = r2.getDeclaredMethods()     // Catch:{ all -> 0x01c7 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r12)     // Catch:{ all -> 0x01c7 }
            kotlin.sequences.Sequence r2 = kotlin.collections.ArraysKt___ArraysKt.asSequence((T[]) r2)     // Catch:{ all -> 0x01c7 }
            com.mars.kotlin.extension.Logger$tag$2$6 r4 = new com.mars.kotlin.extension.Logger$tag$2$6     // Catch:{ all -> 0x01c7 }
            r4.<init>(r3)     // Catch:{ all -> 0x01c7 }
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt___SequencesKt.filter(r2, r4)     // Catch:{ all -> 0x01c7 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x01c7 }
        L_0x013d:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x01c7 }
            if (r4 == 0) goto L_0x001c
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x01c7 }
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4     // Catch:{ all -> 0x01c7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r5.<init>()     // Catch:{ all -> 0x01c7 }
            r5.append(r8)     // Catch:{ all -> 0x01c7 }
            r5.append(r11)     // Catch:{ all -> 0x01c7 }
            r5.append(r3)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01c7 }
            android.util.LruCache<java.lang.String, java.lang.String> r6 = cache     // Catch:{ all -> 0x01c7 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x01c7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01c7 }
            if (r6 == 0) goto L_0x017c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r2.<init>()     // Catch:{ all -> 0x01c7 }
            r2.append(r6)     // Catch:{ all -> 0x01c7 }
            r2.append(r9)     // Catch:{ all -> 0x01c7 }
            int r1 = r1.getLineNumber()     // Catch:{ all -> 0x01c7 }
            r2.append(r1)     // Catch:{ all -> 0x01c7 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01c7 }
            return r0
        L_0x017c:
            java.lang.Class<com.mars.kotlin.extension.Tag> r6 = com.mars.kotlin.extension.Tag.class
            java.lang.annotation.Annotation r4 = r4.getAnnotation(r6)     // Catch:{ all -> 0x01c7 }
            com.mars.kotlin.extension.Tag r4 = (com.mars.kotlin.extension.Tag) r4     // Catch:{ all -> 0x01c7 }
            if (r4 != 0) goto L_0x0187
            goto L_0x013d
        L_0x0187:
            java.lang.String r2 = r4.value()     // Catch:{ all -> 0x01c7 }
            android.util.LruCache<java.lang.String, java.lang.String> r3 = cache     // Catch:{ all -> 0x01c7 }
            r3.put(r5, r2)     // Catch:{ all -> 0x01c7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r3.<init>()     // Catch:{ all -> 0x01c7 }
            r3.append(r2)     // Catch:{ all -> 0x01c7 }
            r3.append(r9)     // Catch:{ all -> 0x01c7 }
            int r1 = r1.getLineNumber()     // Catch:{ all -> 0x01c7 }
            r3.append(r1)     // Catch:{ all -> 0x01c7 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01c7 }
            return r0
        L_0x01a7:
            java.lang.String r2 = r3.value()     // Catch:{ all -> 0x01c7 }
            android.util.LruCache<java.lang.String, java.lang.String> r3 = cache     // Catch:{ all -> 0x01c7 }
            r3.put(r8, r2)     // Catch:{ all -> 0x01c7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r3.<init>()     // Catch:{ all -> 0x01c7 }
            r3.append(r2)     // Catch:{ all -> 0x01c7 }
            r3.append(r9)     // Catch:{ all -> 0x01c7 }
            int r1 = r1.getLineNumber()     // Catch:{ all -> 0x01c7 }
            r3.append(r1)     // Catch:{ all -> 0x01c7 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01c7 }
            return r0
        L_0x01c7:
            goto L_0x001c
        L_0x01ca:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r9)
            int r1 = r1.getLineNumber()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x01e1:
            java.lang.String r0 = r13.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.kotlin.extension.Logger.tag$logger_release():java.lang.String");
    }
}
