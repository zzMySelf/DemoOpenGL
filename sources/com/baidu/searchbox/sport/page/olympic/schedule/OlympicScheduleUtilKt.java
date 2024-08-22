package com.baidu.searchbox.sport.page.olympic.schedule;

import com.baidu.searchbox.nacomp.extension.util.Size;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a9\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\tH\u0000¨\u0006\r"}, d2 = {"isValid", "", "Lcom/baidu/searchbox/nacomp/extension/util/Size;", "setImageURIWithCallback", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "url", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "size", "lib-search-sport_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicScheduleUtil.kt */
public final class OlympicScheduleUtilKt {
    public static final void setImageURIWithCallback(SimpleDraweeView $this$setImageURIWithCallback, String url, Function1<? super Size, Unit> callback) {
        Intrinsics.checkNotNullParameter($this$setImageURIWithCallback, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        PipelineDraweeControllerBuilder $this$setImageURIWithCallback_u24lambda_u2d0 = newDraweeControllerBuilder;
        $this$setImageURIWithCallback_u24lambda_u2d0.setOldController($this$setImageURIWithCallback.getController());
        $this$setImageURIWithCallback_u24lambda_u2d0.setControllerListener(new OlympicScheduleUtilKt$setImageURIWithCallback$1$1(callback));
        $this$setImageURIWithCallback_u24lambda_u2d0.setUri(url);
        $this$setImageURIWithCallback.setController(newDraweeControllerBuilder.build());
    }

    public static final boolean isValid(Size $this$isValid) {
        Intrinsics.checkNotNullParameter($this$isValid, "<this>");
        return $this$isValid.getWidth() > 0 && $this$isValid.getHeight() > 0;
    }
}
