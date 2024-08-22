package com.baidu.searchbox.bigimage.monetize;

import android.view.View;
import com.baidu.searchbox.nacomp.extension.widget.ThrottleClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/bigimage/monetize/BaseBigImageAdComp$onBindViewModel$8", "Lcom/baidu/searchbox/nacomp/extension/widget/ThrottleClickListener;", "doOnClick", "", "v", "Landroid/view/View;", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseBigImageAdComp.kt */
public final class BaseBigImageAdComp$onBindViewModel$8 extends ThrottleClickListener {
    final /* synthetic */ VM $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseBigImageAdComp$onBindViewModel$8(VM $viewModel2) {
        super(1500);
        this.$viewModel = $viewModel2;
    }

    public void doOnClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.$viewModel.clickAdButton();
    }
}
