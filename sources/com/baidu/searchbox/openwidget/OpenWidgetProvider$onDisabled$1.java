package com.baidu.searchbox.openwidget;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.openwidget.model.OpenWidgetExtsKt;
import com.baidu.searchbox.openwidget.model.OpenWidgetInstance;
import com.baidu.searchbox.openwidget.scheduler.OpenWidgetScheduler;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.openwidget.OpenWidgetProvider$onDisabled$1", f = "OpenWidgetProvider.kt", i = {}, l = {303, 306}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OpenWidgetProvider.kt */
final class OpenWidgetProvider$onDisabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ OpenWidgetProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenWidgetProvider$onDisabled$1(Context context, OpenWidgetProvider openWidgetProvider, Continuation<? super OpenWidgetProvider$onDisabled$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = openWidgetProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpenWidgetProvider$onDisabled$1(this.$context, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OpenWidgetProvider$onDisabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OpenWidgetProvider$onDisabled$1 openWidgetProvider$onDisabled$1;
        OpenWidgetInstance it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                openWidgetProvider$onDisabled$1 = this;
                if (OpenWidgetProviderKt.DEBUG) {
                    Log.i("OpenWidgetProvider", "waiting " + OpenWidgetProvider.deleteJobs.size() + " delete jobs to finish");
                }
                openWidgetProvider$onDisabled$1.label = 1;
                if (AwaitKt.joinAll((Collection<? extends Job>) OpenWidgetProvider.deleteJobs, (Continuation<? super Unit>) openWidgetProvider$onDisabled$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                openWidgetProvider$onDisabled$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                openWidgetProvider$onDisabled$1 = this;
                Object obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OpenWidgetProvider.deleteJobs.clear();
        if (OpenWidgetProviderKt.DEBUG) {
            Log.i("OpenWidgetProvider", "delete jobs all finish, can disable now");
        }
        openWidgetProvider$onDisabled$1.label = 2;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new OpenWidgetProvider$onDisabled$1$remainWidgets$1((Continuation<? super OpenWidgetProvider$onDisabled$1$remainWidgets$1>) null), openWidgetProvider$onDisabled$1);
        if (withContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        Object obj2 = $result;
        $result = withContext;
        Iterable $this$none$iv = (List) $result;
        OpenWidgetProvider openWidgetProvider = openWidgetProvider$onDisabled$1.this$0;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator it2 = $this$none$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (OpenWidgetExtsKt.getSize(((OpenWidgetInstance) it2.next()).getInfo()) == openWidgetProvider.getSize()) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        z = false;
                    }
                }
            }
        }
        if (z) {
            OpenWidgetScheduler.INSTANCE.unscheduleUpdate(openWidgetProvider$onDisabled$1.$context, openWidgetProvider$onDisabled$1.this$0.getSize());
        }
        openWidgetProvider$onDisabled$1.this$0.setDisableJobOfClass((Job) null);
        return Unit.INSTANCE;
    }
}
