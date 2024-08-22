package com.baidu.searchbox.lightbrowser.container.presenter;

import com.baidu.searchbox.lightbrowser.container.model.TopBarButtonType;
import com.baidu.searchbox.lightbrowser.container.presenter.TopBarPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopBarViewFactory.kt */
final class TopBarViewFactory$createDefaultBt$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TopBarPresenter.TopBarClickListener $listener;
    final /* synthetic */ TopBarButtonType $this_createDefaultBt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopBarViewFactory$createDefaultBt$2(TopBarPresenter.TopBarClickListener topBarClickListener, TopBarButtonType topBarButtonType) {
        super(0);
        this.$listener = topBarClickListener;
        this.$this_createDefaultBt = topBarButtonType;
    }

    public final void invoke() {
        TopBarPresenter.TopBarClickListener topBarClickListener = this.$listener;
        if (topBarClickListener != null) {
            topBarClickListener.onClick(this.$this_createDefaultBt);
        }
    }
}
