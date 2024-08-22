package com.baidu.searchbox.feed.payment.widget;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H&J&\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/feed/payment/widget/LabelsManager;", "", "context", "Landroid/content/Context;", "parentView", "Lcom/baidu/searchbox/feed/payment/widget/FlowLayout;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/widget/FlowLayout;)V", "getContext", "()Landroid/content/Context;", "labelViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "bindLabelViews", "", "tipsList", "", "", "defaultSelect", "getItems", "index", "", "labelStr", "handleDefaultSelect", "item", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LabelsManager.kt */
public abstract class LabelsManager {
    private final Context context;
    private ArrayList<View> labelViews = new ArrayList<>();
    private final FlowLayout parentView;

    public abstract View getItems(int i2, String str);

    public LabelsManager(Context context2, FlowLayout parentView2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(parentView2, "parentView");
        this.context = context2;
        this.parentView = parentView2;
    }

    public final Context getContext() {
        return this.context;
    }

    public static /* synthetic */ void bindLabelViews$default(LabelsManager labelsManager, List list, List list2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                list2 = new ArrayList();
            }
            labelsManager.bindLabelViews(list, list2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindLabelViews");
    }

    public void bindLabelViews(List<String> tipsList, List<String> defaultSelect) {
        int i2;
        Intrinsics.checkNotNullParameter(tipsList, "tipsList");
        Intrinsics.checkNotNullParameter(defaultSelect, "defaultSelect");
        this.labelViews.clear();
        this.parentView.removeAllViews();
        Collection destination$iv$iv = new ArrayList();
        Iterator it = tipsList.iterator();
        while (true) {
            boolean z = true;
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            if (((String) element$iv$iv).length() != 0) {
                z = false;
            }
            if (!z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List<String> legalList = (List) destination$iv$iv;
        if (!legalList.isEmpty()) {
            this.parentView.setVisibility(0);
            for (String label : legalList) {
                int index = i2;
                i2++;
                View item = getItems(index, label);
                handleDefaultSelect(item, label, defaultSelect);
                this.labelViews.add(item);
                this.parentView.addView(item);
            }
        }
    }

    private final void handleDefaultSelect(View item, String labelStr, List<String> defaultSelect) {
        for (String selectLabel : defaultSelect) {
            if (Intrinsics.areEqual((Object) labelStr, (Object) selectLabel)) {
                Object tag = item.getTag();
                LabelItem labelItem = tag instanceof LabelItem ? (LabelItem) tag : null;
                if (labelItem != null) {
                    labelItem.setDefaultSelect(true);
                }
                item.performClick();
            }
        }
    }
}
