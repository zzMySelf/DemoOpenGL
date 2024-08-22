package com.baidu.searchbox.openwidget.states;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.openwidget.StatefulWidget;
import com.baidu.searchbox.openwidget.config.CompatConfig;
import com.baidu.searchbox.openwidget.transform.OpenWidgetTransformCandidate;
import com.baidu.searchbox.openwidget.utils.OpenWidgetProcess;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0003J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/openwidget/states/TransformState;", "Lcom/baidu/searchbox/openwidget/states/BaseState;", "widget", "Lcom/baidu/searchbox/openwidget/StatefulWidget;", "candidates", "", "Lcom/baidu/searchbox/openwidget/transform/OpenWidgetTransformCandidate;", "(Lcom/baidu/searchbox/openwidget/StatefulWidget;Ljava/util/List;)V", "enterTimeMillis", "", "applyQualifiedCandidate", "", "enter", "owner", "onMessage", "", "msg", "", "onTransformFail", "candidate", "error", "", "onTransformSuccess", "onUpdate", "context", "Landroid/content/Context;", "widgetManager", "Landroid/appwidget/AppWidgetManager;", "widgetId", "", "updateStateAfterTransform", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@OpenWidgetProcess
/* compiled from: TransformState.kt */
public final class TransformState extends BaseState {
    /* access modifiers changed from: private */
    public final List<OpenWidgetTransformCandidate> candidates;
    private long enterTimeMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformState(StatefulWidget widget, List<OpenWidgetTransformCandidate> candidates2) {
        super(widget);
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(candidates2, "candidates");
        this.candidates = candidates2;
    }

    public void enter(StatefulWidget owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.enterTimeMillis = SystemClock.elapsedRealtime();
        getWidget().getTracker().trackTransformStart();
        super.enter(owner);
        applyQualifiedCandidate();
    }

    private final void applyQualifiedCandidate() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(getScope(), Dispatchers.getMain(), (CoroutineStart) null, new TransformState$applyQualifiedCandidate$1(this, (Continuation<? super TransformState$applyQualifiedCandidate$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onTransformSuccess(OpenWidgetTransformCandidate candidate) {
        getWidget().getTracker().trackTransformSuccess(candidate);
        updateStateAfterTransform();
    }

    /* access modifiers changed from: private */
    public final void onTransformFail(OpenWidgetTransformCandidate candidate, String error) {
        getWidget().getTracker().trackTransformFail(candidate, error);
        updateStateAfterTransform();
    }

    private final void updateStateAfterTransform() {
        if (CompatConfig.INSTANCE.getShowNotSupport()) {
            getWidget().getFsm$lib_openwidget_release().changeState(new CompatState(getWidget()));
        } else if (getWidget().getInstance() == null) {
            getWidget().getFsm$lib_openwidget_release().changeState(new EmptyState(getWidget()));
        } else {
            getWidget().getFsm$lib_openwidget_release().changeState(new LoadingState(getWidget(), false, 2, (DefaultConstructorMarker) null));
        }
    }

    public void onUpdate(Context context, AppWidgetManager widgetManager, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetManager, "widgetManager");
        long elapseTime = SystemClock.elapsedRealtime() - this.enterTimeMillis;
        if (elapseTime > 5000) {
            if (BaseStateKt.getDEBUG()) {
                Log.w("OpenWidgetState", "transform timeout, elapsed " + elapseTime + "ms");
            }
            getWidget().getFsm$lib_openwidget_release().changeState(new InitialState(getWidget(), true));
            getWidget().onUpdate(context, widgetManager, widgetId);
        } else if (BaseStateKt.getDEBUG()) {
            Log.d("OpenWidgetState", "transform ongoing, skip onUpdate");
        }
    }

    public boolean onMessage(StatefulWidget owner, Object msg) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (!(msg instanceof RenderSuccessMessage) && !(msg instanceof RenderFailMessage)) {
            return super.onMessage(owner, msg);
        }
        if (BaseStateKt.getDEBUG()) {
            Log.d("OpenWidgetState", "id=" + owner.getId() + ", receive " + msg + " on " + getClass().getSimpleName());
        }
        owner.getFsm$lib_openwidget_release().changeState(new LoadingState(getWidget(), true));
        owner.getFsm$lib_openwidget_release().handleMessage(msg);
        return true;
    }
}
