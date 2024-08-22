package com.tera.scan.main.viewmodel;

import android.app.Application;
import android.database.Cursor;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.rrr.qw.ad;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/database/Cursor;", "", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$records$1", f = "MainActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MainActivityViewModel$doInitFileExportData$records$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Cursor, ? extends List<? extends ScanRecordExportFile>>>, Object> {
    public int label;
    public final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel$doInitFileExportData$records$1(MainActivityViewModel mainActivityViewModel, Continuation<? super MainActivityViewModel$doInitFileExportData$records$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivityViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MainActivityViewModel$doInitFileExportData$records$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<? extends Cursor, ? extends List<ScanRecordExportFile>>> continuation) {
        return ((MainActivityViewModel$doInitFileExportData$records$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DocScanProviderHelper qw = ad.qw.qw();
            Application application = this.this$0.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            return qw.when(application);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
