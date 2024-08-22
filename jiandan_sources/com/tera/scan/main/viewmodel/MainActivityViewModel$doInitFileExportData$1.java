package com.tera.scan.main.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.viewmodel.MainActivityViewModel", f = "MainActivityViewModel.kt", i = {0}, l = {481}, m = "doInitFileExportData", n = {"this"}, s = {"L$0"})
public final class MainActivityViewModel$doInitFileExportData$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel$doInitFileExportData$1(MainActivityViewModel mainActivityViewModel, Continuation<? super MainActivityViewModel$doInitFileExportData$1> continuation) {
        super(continuation);
        this.this$0 = mainActivityViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rg(this);
    }
}
