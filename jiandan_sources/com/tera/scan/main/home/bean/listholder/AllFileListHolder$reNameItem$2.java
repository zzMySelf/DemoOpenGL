package com.tera.scan.main.home.bean.listholder;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.home.bean.listholder.AllFileListHolder$reNameItem$2", f = "AllFileListHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AllFileListHolder$reNameItem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $position;
    public int label;
    public final /* synthetic */ AllFileListHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllFileListHolder$reNameItem$2(AllFileListHolder allFileListHolder, int i2, String str, Context context, Continuation<? super AllFileListHolder$reNameItem$2> continuation) {
        super(2, continuation);
        this.this$0 = allFileListHolder;
        this.$position = i2;
        this.$name = str;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AllFileListHolder$reNameItem$2(this.this$0, this.$position, this.$name, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((AllFileListHolder$reNameItem$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0078, code lost:
        if (fe.mmm.qw.rrr.qw.ad.qw.qw().aaa(r7.$context, ((com.tera.scan.record.model.ScanRecord) r8).getRecordId(), r7.$name) > 0) goto L_0x007a;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            if (r0 != 0) goto L_0x0080
            kotlin.ResultKt.throwOnFailure(r8)
            com.tera.scan.main.home.bean.listholder.AllFileListHolder r8 = r7.this$0
            java.util.List r8 = r8.de()
            int r0 = r7.$position
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r8, r0)
            fe.mmm.qw.xxx.yj.g.ad.qw r8 = (fe.mmm.qw.xxx.yj.g.ad.qw) r8
            r0 = 0
            if (r8 != 0) goto L_0x0020
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r8
        L_0x0020:
            java.lang.Object r8 = r8.getData()
            boolean r1 = r8 instanceof com.tera.scan.record.model.ScanRecordExportFile
            r2 = 1
            if (r1 == 0) goto L_0x0060
            com.tera.scan.record.model.ScanRecordExportFile r8 = (com.tera.scan.record.model.ScanRecordExportFile) r8
            java.lang.String r1 = r8.getLocalPath()
            if (r1 != 0) goto L_0x0036
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r8
        L_0x0036:
            com.tera.scan.main.home.bean.listholder.AllFileListHolder r3 = r7.this$0
            java.lang.String r4 = r7.$name
            java.lang.String r3 = r3.nn(r1, r4)
            com.tera.scan.main.home.bean.listholder.AllFileListHolder r4 = r7.this$0
            java.lang.String r4 = r4.aaa(r3)
            com.tera.scan.main.home.bean.listholder.AllFileListHolder r5 = r7.this$0
            boolean r5 = r5.tt(r1, r3)
            if (r5 == 0) goto L_0x007b
            fe.mmm.qw.rrr.qw.ad r5 = fe.mmm.qw.rrr.qw.ad.qw
            com.tera.scan.record.database.DocScanProviderHelper r5 = r5.qw()
            android.content.Context r6 = r7.$context
            boolean r8 = r5.mmm(r6, r8, r4, r3)
            if (r8 != 0) goto L_0x007a
            com.tera.scan.main.home.bean.listholder.AllFileListHolder r8 = r7.this$0
            boolean unused = r8.tt(r3, r1)
            goto L_0x007b
        L_0x0060:
            boolean r1 = r8 instanceof com.tera.scan.record.model.ScanRecord
            if (r1 == 0) goto L_0x007b
            fe.mmm.qw.rrr.qw.ad r1 = fe.mmm.qw.rrr.qw.ad.qw
            com.tera.scan.record.database.DocScanProviderHelper r1 = r1.qw()
            android.content.Context r3 = r7.$context
            com.tera.scan.record.model.ScanRecord r8 = (com.tera.scan.record.model.ScanRecord) r8
            java.lang.String r8 = r8.getRecordId()
            java.lang.String r4 = r7.$name
            int r8 = r1.aaa(r3, r8, r4)
            if (r8 <= 0) goto L_0x007b
        L_0x007a:
            r0 = 1
        L_0x007b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r8
        L_0x0080:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.home.bean.listholder.AllFileListHolder$reNameItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
