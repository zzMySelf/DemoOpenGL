package com.tera.scan.main.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.xxx.yj.g.qw.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.main.viewmodel.MainActivityViewModel$updateRecordName$1", f = "MainActivityViewModel.kt", i = {}, l = {439}, m = "invokeSuspend", n = {}, s = {})
public final class MainActivityViewModel$updateRecordName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $it;
    public final /* synthetic */ qw<?> $listHolder;
    public final /* synthetic */ Function1<Boolean, Unit> $onResult;
    public final /* synthetic */ int $position;
    public int label;
    public final /* synthetic */ MainActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel$updateRecordName$1(qw<?> qwVar, MainActivityViewModel mainActivityViewModel, int i2, String str, Function1<? super Boolean, Unit> function1, Context context, Continuation<? super MainActivityViewModel$updateRecordName$1> continuation) {
        super(2, continuation);
        this.$listHolder = qwVar;
        this.this$0 = mainActivityViewModel;
        this.$position = i2;
        this.$it = str;
        this.$onResult = function1;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MainActivityViewModel$updateRecordName$1(this.$listHolder, this.this$0, this.$position, this.$it, this.$onResult, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MainActivityViewModel$updateRecordName$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            qw<?> qwVar = this.$listHolder;
            Application application = this.this$0.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            int i3 = this.$position;
            String str = this.$it;
            this.label = 1;
            obj = qwVar.pf(application, i3, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        this.$onResult.invoke(Boxing.boxBoolean(booleanValue));
        if (booleanValue) {
            Context context = this.$context;
            Toast.makeText(context, context.getString(R.string.name_changed), 0).show();
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "rename_succeessfully_toast_show", (List) null, 2, (Object) null);
        } else {
            Context context2 = this.$context;
            Toast.makeText(context2, context2.getString(R.string.error), 0).show();
        }
        return Unit.INSTANCE;
    }
}
