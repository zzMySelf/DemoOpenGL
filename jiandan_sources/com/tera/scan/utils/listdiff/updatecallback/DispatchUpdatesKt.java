package com.tera.scan.utils.listdiff.updatecallback;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"dispatchUpdatesRecursive", "", "T", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEventDispatcher;", "old", "", "new", "listUpdateFlow", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEventFlowLatest;", "(Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEventDispatcher;Ljava/util/List;Ljava/util/List;Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEventFlowLatest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "x-util_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DispatchUpdatesKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: fe.mmm.qw.j.nn.de.fe} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object qw(@org.jetbrains.annotations.NotNull com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher<T> r8, @org.jetbrains.annotations.NotNull java.util.List<? extends T> r9, @org.jetbrains.annotations.NotNull java.util.List<? extends T> r10, @org.jetbrains.annotations.NotNull fe.mmm.qw.j.nn.de.fe r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            boolean r0 = r12 instanceof com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt$dispatchUpdatesRecursive$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt$dispatchUpdatesRecursive$1 r0 = (com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt$dispatchUpdatesRecursive$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt$dispatchUpdatesRecursive$1 r0 = new com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt$dispatchUpdatesRecursive$1
            r0.<init>(r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0050
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r8 = r0.L$0
            fe.mmm.qw.j.nn.de.fe r8 = (fe.mmm.qw.j.nn.de.fe) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00e1
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$1
            r11 = r9
            fe.mmm.qw.j.nn.de.fe r11 = (fe.mmm.qw.j.nn.de.fe) r11
            java.lang.Object r9 = r0.L$0
            com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher r9 = (com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher) r9
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00c8
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r11.ad()
            if (r12 == 0) goto L_0x0086
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r10, r9)
            r8.<init>(r9)
            java.util.Iterator r9 = r10.iterator()
        L_0x0068:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0080
            java.lang.Object r10 = r9.next()
            if (r10 == 0) goto L_0x0078
            r8.add(r10)
            goto L_0x0068
        L_0x0078:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Any"
            r8.<init>(r9)
            throw r8
        L_0x0080:
            r11.de(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0086:
            r11.fe(r5)
            com.mars.kotlin.extension.fp.Either r9 = fe.mmm.qw.j.nn.qw.qw(r9, r10, r8)
            boolean r10 = r9 instanceof com.mars.kotlin.extension.fp.Either.Left
            if (r10 == 0) goto L_0x00a5
            com.mars.kotlin.extension.fp.Either$Left r9 = (com.mars.kotlin.extension.fp.Either.Left) r9
            java.lang.Object r9 = r9.getValue()
            java.lang.Void r9 = (java.lang.Void) r9
            r11.fe(r3)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            com.mars.kotlin.extension.fp.Either$Left r10 = new com.mars.kotlin.extension.fp.Either$Left
            r10.<init>(r9)
            r9 = r10
            goto L_0x00a9
        L_0x00a5:
            boolean r10 = r9 instanceof com.mars.kotlin.extension.fp.Either.Right
            if (r10 == 0) goto L_0x00f5
        L_0x00a9:
            boolean r10 = r9 instanceof com.mars.kotlin.extension.fp.Either.Left
            if (r10 != 0) goto L_0x00f2
            boolean r10 = r9 instanceof com.mars.kotlin.extension.fp.Either.Right
            if (r10 == 0) goto L_0x00ec
            com.mars.kotlin.extension.fp.Either$Right r9 = (com.mars.kotlin.extension.fp.Either.Right) r9
            java.lang.Object r9 = r9.getValue()
            java.util.List r9 = (java.util.List) r9
            r0.L$0 = r8
            r0.L$1 = r11
            r0.L$2 = r9
            r0.label = r5
            java.lang.Object r10 = r8.ad(r0)
            if (r10 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r11.fe(r3)
            java.util.List r10 = r11.qw()
            if (r10 == 0) goto L_0x00e6
            r0.L$0 = r11
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r8 = qw(r8, r9, r10, r11, r0)
            if (r8 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            r8 = r11
        L_0x00e1:
            r8.de(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x00e6:
            com.mars.kotlin.extension.fp.Either$Right r8 = new com.mars.kotlin.extension.fp.Either$Right
            r8.<init>(r6)
            goto L_0x00f2
        L_0x00ec:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x00f2:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00f5:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt.qw(com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher, java.util.List, java.util.List, fe.mmm.qw.j.nn.de.fe, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
