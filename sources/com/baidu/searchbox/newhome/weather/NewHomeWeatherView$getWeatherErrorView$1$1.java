package com.baidu.searchbox.newhome.weather;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeWeatherView.kt */
final class NewHomeWeatherView$getWeatherErrorView$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ NewHomeWeatherView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewHomeWeatherView$getWeatherErrorView$1$1(NewHomeWeatherView newHomeWeatherView) {
        super(1);
        this.this$0 = newHomeWeatherView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int it) {
        if (this.this$0.contentRealWidth != it) {
            this.this$0.contentRealWidth = it;
            Function1<Integer, Unit> contentWidthCallback$new_home_top_release = this.this$0.getContentWidthCallback$new_home_top_release();
            if (contentWidthCallback$new_home_top_release != null) {
                contentWidthCallback$new_home_top_release.invoke(Integer.valueOf(it));
            }
        }
    }
}
