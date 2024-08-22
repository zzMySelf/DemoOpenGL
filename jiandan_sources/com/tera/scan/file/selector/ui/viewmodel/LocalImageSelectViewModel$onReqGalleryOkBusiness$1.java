package com.tera.scan.file.selector.ui.viewmodel;

import android.content.Intent;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import fe.mmm.qw.th.qw.th.i;
import i.qw.o;
import i.qw.u;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.file.selector.ui.viewmodel.LocalImageSelectViewModel$onReqGalleryOkBusiness$1", f = "LocalImageSelectViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class LocalImageSelectViewModel$onReqGalleryOkBusiness$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LocalImageSelectActivity $activity;
    public final /* synthetic */ i $dialogHelper;
    public final /* synthetic */ String $imgCompressDir;
    public final /* synthetic */ ArrayList<String> $list;
    public final /* synthetic */ String $ubcSource;
    public int label;
    public final /* synthetic */ LocalImageSelectViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectViewModel$onReqGalleryOkBusiness$1(LocalImageSelectActivity localImageSelectActivity, LocalImageSelectViewModel localImageSelectViewModel, String str, i iVar, ArrayList<String> arrayList, String str2, Continuation<? super LocalImageSelectViewModel$onReqGalleryOkBusiness$1> continuation) {
        super(2, continuation);
        this.$activity = localImageSelectActivity;
        this.this$0 = localImageSelectViewModel;
        this.$ubcSource = str;
        this.$dialogHelper = iVar;
        this.$list = arrayList;
        this.$imgCompressDir = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalImageSelectViewModel$onReqGalleryOkBusiness$1(this.$activity, this.this$0, this.$ubcSource, this.$dialogHelper, this.$list, this.$imgCompressDir, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LocalImageSelectViewModel$onReqGalleryOkBusiness$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher ad2 = u.ad();
            LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1 localImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1 = new LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1(this.$list, this.$imgCompressDir, (Continuation<? super LocalImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1>) null);
            this.label = 1;
            obj = o.yj(ad2, localImageSelectViewModel$onReqGalleryOkBusiness$1$selectedList$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ArrayList arrayList = (ArrayList) obj;
        if (this.$activity.jumpRouter.length() <= 0) {
            z = false;
        }
        if (z) {
            LocalImageSelectViewModel localImageSelectViewModel = this.this$0;
            LocalImageSelectActivity localImageSelectActivity = this.$activity;
            localImageSelectViewModel.qw(localImageSelectActivity, arrayList, localImageSelectActivity.jumpRouter);
        } else {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("extra_result_files", arrayList);
            intent.putExtra("extra_ubc_source", this.$ubcSource);
            this.$activity.setResult(-1, intent);
            this.$activity.finish();
        }
        this.$dialogHelper.fe();
        return Unit.INSTANCE;
    }
}
