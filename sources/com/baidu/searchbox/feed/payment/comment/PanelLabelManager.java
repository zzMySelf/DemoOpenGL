package com.baidu.searchbox.feed.payment.comment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.model.PayStats1076;
import com.baidu.searchbox.feed.payment.widget.FlowLayout;
import com.baidu.searchbox.feed.payment.widget.LabelItem;
import com.baidu.searchbox.feed.payment.widget.LabelsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ$\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u000fj\b\u0012\u0004\u0012\u00020\u0016`\u0011J\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/payment/comment/PanelLabelManager;", "Lcom/baidu/searchbox/feed/payment/widget/LabelsManager;", "context", "Landroid/content/Context;", "parentView", "Lcom/baidu/searchbox/feed/payment/widget/FlowLayout;", "payStats1076", "Lcom/baidu/searchbox/feed/payment/model/PayStats1076;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/widget/FlowLayout;Lcom/baidu/searchbox/feed/payment/model/PayStats1076;)V", "labelHeight", "", "margin", "getPayStats1076", "()Lcom/baidu/searchbox/feed/payment/model/PayStats1076;", "selectLabelContainers", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/payment/widget/LabelItem;", "Lkotlin/collections/ArrayList;", "bindLabelViews", "", "tipsList", "", "", "defaultSelect", "clearSelectLabels", "getItems", "Landroid/view/View;", "index", "labelStr", "getLabels", "isSelectLabels", "", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedCommentLabelsManager.kt */
public final class PanelLabelManager extends LabelsManager {
    private final int labelHeight;
    private final int margin;
    private final PayStats1076 payStats1076;
    private ArrayList<LabelItem> selectLabelContainers;

    public final PayStats1076 getPayStats1076() {
        return this.payStats1076;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PanelLabelManager(Context context, FlowLayout parentView, PayStats1076 payStats10762) {
        super(context, parentView);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.payStats1076 = payStats10762;
        Resources resources = context.getResources();
        int i2 = 0;
        this.margin = resources != null ? resources.getDimensionPixelSize(R.dimen.feed_comment_panel_label_margin) : 0;
        Resources resources2 = context.getResources();
        this.labelHeight = resources2 != null ? resources2.getDimensionPixelSize(R.dimen.feed_comment_panel_label_height) : i2;
        this.selectLabelContainers = new ArrayList<>();
    }

    public void bindLabelViews(List<String> tipsList, List<String> defaultSelect) {
        Intrinsics.checkNotNullParameter(tipsList, "tipsList");
        Intrinsics.checkNotNullParameter(defaultSelect, "defaultSelect");
        this.selectLabelContainers.clear();
        super.bindLabelViews(tipsList, defaultSelect);
    }

    public View getItems(int index, String labelStr) {
        Intrinsics.checkNotNullParameter(labelStr, "labelStr");
        View inflate = LayoutInflater.from(getContext()).inflate(com.baidu.searchbox.feed.payment.column.R.layout.feed_comment_panel_label_item, (ViewGroup) null);
        if (inflate != null) {
            TextView item = (TextView) inflate;
            item.setText(labelStr);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(-2, this.labelHeight);
            lp.topMargin = this.margin;
            lp.leftMargin = this.margin;
            lp.rightMargin = this.margin;
            lp.bottomMargin = this.margin;
            item.setLayoutParams(lp);
            item.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.feed.payment.column.R.drawable.feed_comment_label_item_normal_bg));
            item.setTextColor(ContextCompat.getColor(getContext(), com.baidu.searchbox.feed.payment.column.R.color.feed_comment_label_normal_text));
            item.setTag(new LabelItem(labelStr, index));
            item.setOnClickListener(new PanelLabelManager$$ExternalSyntheticLambda0(this, item));
            return item;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: private */
    /* renamed from: getItems$lambda-0  reason: not valid java name */
    public static final void m19108getItems$lambda0(PanelLabelManager this$0, TextView $item, View it) {
        PayStats1076 payStats10762;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($item, "$item");
        if (it.getTag() instanceof LabelItem) {
            Object tag = it.getTag();
            if (tag != null) {
                LabelItem label = (LabelItem) tag;
                label.setSelectState(!label.getSelectState());
                if (label.getSelectState()) {
                    this$0.selectLabelContainers.add(label);
                    $item.setBackground(ContextCompat.getDrawable(this$0.getContext(), com.baidu.searchbox.feed.payment.column.R.drawable.feed_comment_label_item_select_bg));
                    $item.setTextColor(ContextCompat.getColor(this$0.getContext(), com.baidu.searchbox.feed.payment.column.R.color.feed_comment_label_select_text));
                    if (!label.isDefaultSelect() && (payStats10762 = this$0.payStats1076) != null) {
                        payStats10762.recordLabelClick();
                    }
                } else {
                    this$0.selectLabelContainers.remove(label);
                    $item.setBackground(ContextCompat.getDrawable(this$0.getContext(), com.baidu.searchbox.feed.payment.column.R.drawable.feed_comment_label_item_normal_bg));
                    $item.setTextColor(ContextCompat.getColor(this$0.getContext(), com.baidu.searchbox.feed.payment.column.R.color.feed_comment_label_normal_text));
                }
                label.setDefaultSelect(false);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.payment.widget.LabelItem");
        }
    }

    public final boolean isSelectLabels() {
        return !this.selectLabelContainers.isEmpty();
    }

    public final void clearSelectLabels() {
        this.selectLabelContainers.clear();
    }

    public final ArrayList<String> getLabels() {
        List $this$sortBy$iv = this.selectLabelContainers;
        if ($this$sortBy$iv.size() > 1) {
            CollectionsKt.sortWith($this$sortBy$iv, new PanelLabelManager$getLabels$$inlined$sortBy$1());
        }
        ArrayList labels = new ArrayList();
        for (LabelItem it : this.selectLabelContainers) {
            labels.add(it.getLabelStr());
        }
        return labels;
    }
}
