package com.baidu.searchbox.widget.quickbox;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import com.baidu.searchbox.widget.aiwidget.model.AiWidgetModel;
import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "model", "Lcom/baidu/searchbox/widget/aiwidget/model/AiWidgetModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickSearchAiWidget.kt */
final class QuickSearchAiWidget$updateWidget$2 extends Lambda implements Function1<AiWidgetModel, Unit> {
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $needUpdateSkin;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function0<Unit> $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickSearchAiWidget$updateWidget$2(Context context, AppWidgetManager appWidgetManager, int[] iArr, boolean z, Function0<Unit> function0, Function0<Unit> function02) {
        super(1);
        this.$context = context;
        this.$appWidgetManager = appWidgetManager;
        this.$appWidgetIds = iArr;
        this.$needUpdateSkin = z;
        this.$onSuccess = function0;
        this.$onFailure = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AiWidgetModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(final AiWidgetModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        WidgetDebugKt.printLog("QuickSearchAiWidget", (Function0<String>) new Function0<String>() {
            public final String invoke() {
                return "QuickSearchAiWidget update widget remote success, model = " + model;
            }
        });
        QuickSearchAiWidget quickSearchAiWidget = QuickSearchAiWidget.INSTANCE;
        Context context = this.$context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AppWidgetManager appWidgetManager = this.$appWidgetManager;
        int[] iArr = this.$appWidgetIds;
        Intrinsics.checkNotNullExpressionValue(iArr, "appWidgetIds");
        quickSearchAiWidget.updateSkinAndTemplateView(model, context, appWidgetManager, iArr, this.$needUpdateSkin, this.$onSuccess, this.$onFailure);
    }
}
