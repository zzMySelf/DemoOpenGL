package com.baidu.searchbox.widget.template;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.searchbox.oem.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/widget/template/DefaultTemplate;", "Lcom/baidu/searchbox/widget/template/BaseTemplate;", "()V", "inflateView", "Landroid/view/View;", "refreshResource", "", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultTemplate.kt */
public final class DefaultTemplate extends BaseTemplate {
    public void refreshResource() {
    }

    public View inflateView() {
        View inflate = LayoutInflater.from(getMContext()).inflate(R.layout.item_default_template, getMRootView());
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R…ault_template, mRootView)");
        return inflate;
    }
}
