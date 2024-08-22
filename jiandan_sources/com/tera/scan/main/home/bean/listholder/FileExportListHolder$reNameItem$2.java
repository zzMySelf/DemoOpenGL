package com.tera.scan.main.home.bean.listholder;

import android.content.Context;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.xxx.yj.g.qw.ad;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.home.bean.listholder.FileExportListHolder$reNameItem$2", f = "FileExportListHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileExportListHolder$reNameItem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $position;
    public int label;
    public final /* synthetic */ ad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileExportListHolder$reNameItem$2(ad adVar, int i2, String str, Context context, Continuation<? super FileExportListHolder$reNameItem$2> continuation) {
        super(2, continuation);
        this.this$0 = adVar;
        this.$position = i2;
        this.$name = str;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileExportListHolder$reNameItem$2(this.this$0, this.$position, this.$name, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((FileExportListHolder$reNameItem$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ScanRecordExportFile de2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            fe.mmm.qw.xxx.yj.g.ad.ad adVar = (fe.mmm.qw.xxx.yj.g.ad.ad) CollectionsKt___CollectionsKt.getOrNull(this.this$0.de(), this.$position);
            boolean z = false;
            if (adVar == null || (de2 = adVar.getData()) == null) {
                return Boxing.boxBoolean(false);
            }
            String localPath = de2.getLocalPath();
            if (localPath == null) {
                return Boxing.boxBoolean(false);
            }
            String vvv = this.this$0.nn(localPath, this.$name);
            String xxx = this.this$0.mmm(vvv);
            if (this.this$0.aaa(localPath, vvv)) {
                if (!fe.mmm.qw.rrr.qw.ad.qw.qw().mmm(this.$context, de2, xxx, vvv)) {
                    boolean unused = this.this$0.aaa(vvv, localPath);
                } else {
                    z = true;
                }
            }
            return Boxing.boxBoolean(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
