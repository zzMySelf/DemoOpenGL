package com.tera.scan.main.viewmodel;

import androidx.lifecycle.MutableLiveData;
import fe.mmm.qw.h.fe.de;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.viewmodel.ToolsBoxViewModel$mergeImages$1", f = "ToolsBoxViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ToolsBoxViewModel$mergeImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<String> $imageList;
    public final /* synthetic */ MutableLiveData<String> $liveData;
    public final /* synthetic */ String $savePath;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToolsBoxViewModel$mergeImages$1(MutableLiveData<String> mutableLiveData, List<String> list, String str, Continuation<? super ToolsBoxViewModel$mergeImages$1> continuation) {
        super(2, continuation);
        this.$liveData = mutableLiveData;
        this.$imageList = list;
        this.$savePath = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ToolsBoxViewModel$mergeImages$1(this.$liveData, this.$imageList, this.$savePath, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ToolsBoxViewModel$mergeImages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$imageList;
            String str = this.$savePath;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.m1155constructorimpl(new de().de(list, str));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj2)) {
                obj2 = null;
            }
            String str2 = (String) obj2;
            if (str2 == null) {
                str2 = "";
            }
            this.$liveData.postValue(str2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
