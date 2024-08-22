package com.baidu.searchbox.openwidget.states;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.nacomp.fsm.EmptyState;
import com.baidu.searchbox.nacomp.fsm.StateMachine;
import com.baidu.searchbox.openwidget.IRemoteViewsProvider;
import com.baidu.searchbox.openwidget.OpenWidgetRenderService;
import com.baidu.searchbox.openwidget.R;
import com.baidu.searchbox.openwidget.StatefulWidget;
import com.baidu.searchbox.openwidget.config.CommonConfig;
import com.baidu.searchbox.openwidget.config.CompatConfig;
import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import com.baidu.searchbox.openwidget.states.loadingsub.WaitingRemoteViewsService;
import com.baidu.searchbox.openwidget.statistic.StatisticManager;
import com.baidu.searchbox.openwidget.utils.OpenWidgetProcess;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\b\u0010\u0016\u001a\u00020\u0017H\u0003J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/openwidget/states/LoadingState;", "Lcom/baidu/searchbox/openwidget/states/BaseState;", "Lcom/baidu/searchbox/openwidget/IRemoteViewsProvider;", "widget", "Lcom/baidu/searchbox/openwidget/StatefulWidget;", "skipLoading", "", "(Lcom/baidu/searchbox/openwidget/StatefulWidget;Z)V", "enterTimeMillis", "", "fsm", "Lcom/baidu/searchbox/nacomp/fsm/StateMachine;", "getFsm$lib_openwidget_release", "()Lcom/baidu/searchbox/nacomp/fsm/StateMachine;", "enter", "", "owner", "exit", "getRemoteViews", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "loadingLayoutId", "", "onMessage", "msg", "", "onUpdate", "widgetManager", "Landroid/appwidget/AppWidgetManager;", "widgetId", "updateAppWidgetOnEnter", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@OpenWidgetProcess
/* compiled from: LoadingState.kt */
public final class LoadingState extends BaseState implements IRemoteViewsProvider {
    private long enterTimeMillis;
    private final StateMachine<StatefulWidget> fsm;
    private final boolean skipLoading;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LoadingState.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OpenWidgetSize.values().length];
            iArr[OpenWidgetSize.SIZE_MEDIUM.ordinal()] = 1;
            iArr[OpenWidgetSize.SIZE_WIDE.ordinal()] = 2;
            iArr[OpenWidgetSize.SIZE_SMALL.ordinal()] = 3;
            iArr[OpenWidgetSize.SIZE_TINY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoadingState(StatefulWidget statefulWidget, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(statefulWidget, (i2 & 2) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingState(StatefulWidget widget, boolean skipLoading2) {
        super(widget);
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.skipLoading = skipLoading2;
        this.fsm = new StateMachine<>(widget);
    }

    public final StateMachine<StatefulWidget> getFsm$lib_openwidget_release() {
        return this.fsm;
    }

    public void enter(StatefulWidget owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.enterTimeMillis = SystemClock.elapsedRealtime();
        super.enter(owner);
        StatisticManager.INSTANCE.onWidgetUpdate(getWidget().getId(), getWidget().getInstance());
    }

    public void exit(StatefulWidget owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.exit(owner);
        this.fsm.changeState(new EmptyState());
    }

    /* access modifiers changed from: protected */
    public void updateAppWidgetOnEnter(Context context, AppWidgetManager widgetManager, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetManager, "widgetManager");
        if (!this.skipLoading) {
            super.updateAppWidgetOnEnter(context, widgetManager, widgetId);
            if (BaseStateKt.getDEBUG()) {
                Log.i("OpenWidgetState", "before notifyAppWidgetViewDataChanged");
            }
            this.fsm.changeState(new WaitingRemoteViewsService(getWidget(), this));
            widgetManager.notifyAppWidgetViewDataChanged(widgetId, R.id.grid_view);
            if (BaseStateKt.getDEBUG()) {
                Log.i("OpenWidgetState", "after notifyAppWidgetViewDataChanged");
            }
        } else if (BaseStateKt.getDEBUG()) {
            Log.i("OpenWidgetState", "skip loading as requested");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0059, code lost:
        r6 = r6.getTouch();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.RemoteViews getRemoteViews(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.baidu.searchbox.openwidget.StatefulWidget r0 = r11.getWidget()
            android.content.Intent r0 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildServiceIntent(r12, r0)
            android.widget.RemoteViews r1 = new android.widget.RemoteViews
            java.lang.String r2 = r12.getPackageName()
            int r3 = r11.defaultLayoutId()
            r1.<init>(r2, r3)
            r2 = r1
            r3 = 0
            r11.setupEmptyGridCompensate(r12, r2)
            int r4 = com.baidu.searchbox.openwidget.R.id.grid_view
            r2.setRemoteAdapter(r4, r0)
            int r4 = com.baidu.searchbox.openwidget.R.id.loading_error_parent
            r2.removeAllViews(r4)
            int r4 = com.baidu.searchbox.openwidget.R.id.refresh_btn
            r5 = 0
            r2.setViewVisibility(r4, r5)
            android.graphics.Bitmap r2 = r11.getCacheFrameBitmap(r12)
            r3 = 1
            if (r2 == 0) goto L_0x00a4
            int r4 = com.baidu.searchbox.openwidget.R.id.canvas
            r1.setImageViewBitmap(r4, r2)
            com.baidu.searchbox.openwidget.StatefulWidget r4 = r11.getWidget()
            android.app.PendingIntent r4 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildGridClickPendingIntentTemplate(r12, r4)
            int r6 = com.baidu.searchbox.openwidget.R.id.grid_view
            r1.setPendingIntentTemplate(r6, r4)
            int r6 = com.baidu.searchbox.openwidget.R.id.canvas
            r1.setViewVisibility(r6, r5)
            com.baidu.searchbox.openwidget.StatefulWidget r6 = r11.getWidget()
            com.baidu.searchbox.openwidget.model.OpenWidgetInstance r6 = r6.getInstance()
            if (r6 == 0) goto L_0x0067
            com.baidu.searchbox.openwidget.model.OpenWidgetTouch r6 = r6.getTouch()
            if (r6 == 0) goto L_0x0067
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0067
            r6 = r3
            goto L_0x0068
        L_0x0067:
            r6 = r5
        L_0x0068:
            if (r6 != 0) goto L_0x008d
            int r6 = com.baidu.searchbox.openwidget.R.id.refresh_btn
            r1.setViewVisibility(r6, r5)
            int r5 = com.baidu.searchbox.openwidget.R.id.refresh_btn
            com.baidu.searchbox.openwidget.StatefulWidget r6 = r11.getWidget()
            android.app.PendingIntent r6 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildRefreshPendingIntent(r12, r6)
            r1.setOnClickPendingIntent(r5, r6)
            int r5 = r11.containerViewId()
            com.baidu.searchbox.openwidget.StatefulWidget r6 = r11.getWidget()
            android.app.PendingIntent r6 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildRefreshPendingIntent(r12, r6)
            r1.setOnClickPendingIntent(r5, r6)
            goto L_0x0105
        L_0x008d:
            int r5 = com.baidu.searchbox.openwidget.R.id.refresh_btn
            r6 = 8
            r1.setViewVisibility(r5, r6)
            int r5 = r11.containerViewId()
            com.baidu.searchbox.openwidget.StatefulWidget r6 = r11.getWidget()
            android.app.PendingIntent r6 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildDefaultClickRouterPendingIntent(r12, r6)
            r1.setOnClickPendingIntent(r5, r6)
            goto L_0x0105
        L_0x00a4:
            android.widget.RemoteViews r4 = new android.widget.RemoteViews
            java.lang.String r6 = r12.getPackageName()
            int r7 = r11.loadingLayoutId()
            r4.<init>(r6, r7)
            r6 = r4
            r7 = 0
            com.baidu.searchbox.openwidget.StatefulWidget r8 = r11.getWidget()
            com.baidu.searchbox.openwidget.model.OpenWidgetInstance r8 = r8.getInstance()
            if (r8 == 0) goto L_0x00c8
            com.baidu.searchbox.openwidget.model.OpenWidgetInfo r8 = r8.getInfo()
            if (r8 == 0) goto L_0x00c8
            int r8 = r8.getThemeColorInt()
            goto L_0x00c9
        L_0x00c8:
            r8 = -1
        L_0x00c9:
            int r9 = android.graphics.Color.alpha(r8)
            int r10 = com.baidu.searchbox.openwidget.R.id.loading_background
            com.baidu.searchbox.openwidget.utils.RemoteViewsKt.setImageViewColorFilter(r6, r10, r8)
            int r10 = com.baidu.searchbox.openwidget.R.id.loading_background
            com.baidu.searchbox.openwidget.utils.RemoteViewsKt.setImageViewAlpha(r6, r10, r9)
            int r6 = com.baidu.searchbox.openwidget.R.id.loading_error_parent
            r1.addView(r6, r4)
            int r6 = com.baidu.searchbox.openwidget.R.id.refresh_btn
            r1.setViewVisibility(r6, r5)
            int r5 = com.baidu.searchbox.openwidget.R.id.refresh_btn
            com.baidu.searchbox.openwidget.StatefulWidget r6 = r11.getWidget()
            android.app.PendingIntent r6 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildLoadingClickPendingIntent(r12, r6)
            r1.setOnClickPendingIntent(r5, r6)
            int r5 = r11.containerViewId()
            com.baidu.searchbox.openwidget.StatefulWidget r6 = r11.getWidget()
            android.app.PendingIntent r6 = com.baidu.searchbox.openwidget.utils.IntentsKt.buildLoadingClickPendingIntent(r12, r6)
            r1.setOnClickPendingIntent(r5, r6)
            int r5 = com.baidu.searchbox.openwidget.R.id.canvas
            r6 = 4
            r1.setViewVisibility(r5, r6)
        L_0x0105:
            java.lang.String r3 = r0.toUri(r3)
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r0.setData(r3)
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r3 == 0) goto L_0x0127
            com.baidu.searchbox.openwidget.debug.OpenWidgetDebugConfig r3 = com.baidu.searchbox.openwidget.debug.OpenWidgetDebugConfig.INSTANCE
            boolean r3 = r3.getShowDebugConsole()
            if (r3 == 0) goto L_0x0127
            int r3 = com.baidu.searchbox.openwidget.R.id.loading_error_parent
            android.widget.RemoteViews r4 = r11.buildDebugConsole(r12)
            r1.addView(r3, r4)
        L_0x0127:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.openwidget.states.LoadingState.getRemoteViews(android.content.Context):android.widget.RemoteViews");
    }

    private final int loadingLayoutId() {
        switch (WhenMappings.$EnumSwitchMapping$0[getWidget().getSize().ordinal()]) {
            case 1:
                return R.layout.open_widget_4x2_loading;
            case 2:
                return R.layout.open_widget_4x1_loading;
            case 3:
                return R.layout.open_widget_2x2_loading;
            case 4:
                return R.layout.open_widget_1x1_loading;
            default:
                return R.layout.open_widget_4x2_loading;
        }
    }

    public void onUpdate(Context context, AppWidgetManager widgetManager, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetManager, "widgetManager");
        super.onUpdate(context, widgetManager, widgetId);
        if (CompatConfig.INSTANCE.getShowNotSupport()) {
            getWidget().getFsm$lib_openwidget_release().changeState(new CompatState(getWidget()));
        } else if (getWidget().getInstance() == null) {
            getWidget().getFsm$lib_openwidget_release().changeState(new EmptyState(getWidget()));
        } else {
            long elapseTime = SystemClock.elapsedRealtime() - this.enterTimeMillis;
            if (!OpenWidgetRenderService.Companion.getHasAliveRenderService() && elapseTime > 10000) {
                if (BaseStateKt.getDEBUG()) {
                    Log.w("OpenWidgetState", "render service has gone and elapsed " + elapseTime + "ms");
                }
                getWidget().getFsm$lib_openwidget_release().changeState(new InitialState(getWidget(), false, 2, (DefaultConstructorMarker) null));
                getWidget().onUpdate(context, widgetManager, widgetId);
            } else if (elapseTime > 120000) {
                if (BaseStateKt.getDEBUG()) {
                    Log.w("OpenWidgetState", "stay in loading state for too long: " + elapseTime + "ms");
                }
                getWidget().getFsm$lib_openwidget_release().changeState(new InitialState(getWidget(), false, 2, (DefaultConstructorMarker) null));
                getWidget().onUpdate(context, widgetManager, widgetId);
            } else if (BaseStateKt.getDEBUG()) {
                Log.d("OpenWidgetState", "already loading, skip onUpdate");
            }
        }
    }

    public boolean onMessage(StatefulWidget owner, Object msg) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (msg instanceof RenderSuccessMessage) {
            if (BaseStateKt.getDEBUG()) {
                Log.d("OpenWidgetState", "id=" + owner.getId() + ", receive " + msg + " on " + getClass().getSimpleName());
            }
            if (!CommonConfig.INSTANCE.getEnableAnim() || ((RenderSuccessMessage) msg).getAnimation() == null) {
                owner.getFsm$lib_openwidget_release().changeState(new LoadedState(owner, ((RenderSuccessMessage) msg).getBitmap(), ((RenderSuccessMessage) msg).getTraceInfo()));
            } else {
                owner.getFsm$lib_openwidget_release().changeState(new AnimationState(owner, ((RenderSuccessMessage) msg).getBitmap(), ((RenderSuccessMessage) msg).getAnimation(), ((RenderSuccessMessage) msg).getTraceInfo()));
            }
            return true;
        } else if (!(msg instanceof RenderFailMessage)) {
            return super.onMessage(owner, msg);
        } else {
            if (BaseStateKt.getDEBUG()) {
                Log.d("OpenWidgetState", "id=" + owner.getId() + ", receive " + msg + " on " + getClass().getSimpleName());
            }
            owner.getFsm$lib_openwidget_release().changeState(new ErrorState(owner, ((RenderFailMessage) msg).getThrowable(), ((RenderFailMessage) msg).getTraceInfo()));
            return true;
        }
    }
}
