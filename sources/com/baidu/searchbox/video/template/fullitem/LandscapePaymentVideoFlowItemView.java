package com.baidu.searchbox.video.template.fullitem;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.video.model.VideoFullItemModel;
import com.baidu.searchbox.player.ui.VideoTitlePrefixSpan;
import com.baidu.searchbox.video.template.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/template/fullitem/LandscapePaymentVideoFlowItemView;", "Lcom/baidu/searchbox/video/template/fullitem/LandscapeVideoFlowItemBaseView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindData", "", "feedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "position", "getLayoutId", "setPaymentTitlePrefixSpan", "data", "Lcom/baidu/searchbox/video/template/fullitem/PaymentVideoFullItemModel;", "updateTitleLayerData", "model", "Lcom/baidu/searchbox/feed/video/model/VideoFullItemModel;", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapePaymentVideoFlowItemView.kt */
public class LandscapePaymentVideoFlowItemView extends LandscapeVideoFlowItemBaseView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandscapePaymentVideoFlowItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LandscapePaymentVideoFlowItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LandscapePaymentVideoFlowItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandscapePaymentVideoFlowItemView(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getLayoutId() {
        return R.layout.video_landscape_flow_payment_item_view;
    }

    public void bindData(FeedBaseModel feedBaseModel, int position) {
        Intrinsics.checkNotNullParameter(feedBaseModel, "feedBaseModel");
        if (feedBaseModel.data instanceof PaymentVideoFullItemModel) {
            FeedItemData feedItemData = feedBaseModel.data;
            if (feedItemData != null) {
                PaymentVideoFullItemModel model = (PaymentVideoFullItemModel) feedItemData;
                String str = model.mPoster;
                Intrinsics.checkNotNullExpressionValue(str, "model.mPoster");
                setPosterView(str);
                setTitleLayerUi();
                VideoFullItemTitleWrapper titleLayer = getTitleLayer();
                if (titleLayer != null) {
                    titleLayer.updateData(model);
                }
                setPaymentTitlePrefixSpan(model);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.video.template.fullitem.PaymentVideoFullItemModel");
        }
    }

    public void updateTitleLayerData(VideoFullItemModel model) {
        super.updateTitleLayerData(model);
        PaymentVideoFullItemModel $this$updateTitleLayerData_u24lambda_u2d0 = model instanceof PaymentVideoFullItemModel ? (PaymentVideoFullItemModel) model : null;
        if ($this$updateTitleLayerData_u24lambda_u2d0 != null) {
            setPaymentTitlePrefixSpan($this$updateTitleLayerData_u24lambda_u2d0);
        }
    }

    private final void setPaymentTitlePrefixSpan(PaymentVideoFullItemModel data) {
        TextView $this$setPaymentTitlePrefixSpan_u24lambda_u2d2_u24lambda_u2d1;
        PaymentVideoFullItemModel $this$setPaymentTitlePrefixSpan_u24lambda_u2d2 = data;
        FeedItemData.PrefixRichTitle prefixRichTitle = $this$setPaymentTitlePrefixSpan_u24lambda_u2d2.prefixRich;
        boolean z = true;
        if (prefixRichTitle == null || !prefixRichTitle.isDataValid()) {
            z = false;
        }
        if (z) {
            SpannableString spannableString = new SpannableString("prefix" + $this$setPaymentTitlePrefixSpan_u24lambda_u2d2.mTitle);
            Context context = getContext();
            FeedItemData.PrefixRichTitle prefixRichTitle2 = $this$setPaymentTitlePrefixSpan_u24lambda_u2d2.prefixRich;
            spannableString.setSpan(new VideoTitlePrefixSpan(context, prefixRichTitle2 != null ? prefixRichTitle2.content : null, 12.0f, 5.5f, 3.5f), 0, 6, 17);
            VideoFullItemTitleWrapper titleLayer = getTitleLayer();
            if (titleLayer != null && ($this$setPaymentTitlePrefixSpan_u24lambda_u2d2_u24lambda_u2d1 = titleLayer.getTitleView()) != null) {
                $this$setPaymentTitlePrefixSpan_u24lambda_u2d2_u24lambda_u2d1.setText(spannableString);
                $this$setPaymentTitlePrefixSpan_u24lambda_u2d2_u24lambda_u2d1.requestLayout();
            }
        }
    }
}
