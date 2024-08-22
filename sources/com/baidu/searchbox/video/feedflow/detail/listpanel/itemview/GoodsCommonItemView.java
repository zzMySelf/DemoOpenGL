package com.baidu.searchbox.video.feedflow.detail.listpanel.itemview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.ui.UnifyTextView;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.banner.model.GoodsCommonBannerModel;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/listpanel/itemview/GoodsCommonItemView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/itemview/IGoodsPanelItemView;", "Lcom/baidu/searchbox/video/feedflow/detail/banner/model/GoodsCommonBannerModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detailsBtn", "Landroid/widget/TextView;", "iconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "subTitleView", "Lcom/baidu/searchbox/ui/UnifyTextView;", "titleView", "adjustStyle", "", "bindData", "model", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsCommonItemView.kt */
public final class GoodsCommonItemView extends LinearLayout implements IGoodsPanelItemView<GoodsCommonBannerModel> {
    private TextView detailsBtn;
    private SimpleDraweeView iconView;
    private UnifyTextView subTitleView;
    private UnifyTextView titleView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoodsCommonItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoodsCommonItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoodsCommonItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsCommonItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_goods_item_common, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int leftRightPadding = context.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_15dp);
        int topBottomPadding = context.getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_10dp);
        setPadding(leftRightPadding, topBottomPadding, leftRightPadding, topBottomPadding);
        this.iconView = (SimpleDraweeView) findViewById(R.id.goods_common_drawee);
        this.titleView = (UnifyTextView) findViewById(R.id.goods_common_title_tv);
        this.subTitleView = (UnifyTextView) findViewById(R.id.goods_common_subtitle_tv);
        this.detailsBtn = (TextView) findViewById(R.id.goods_common_details_btn);
    }

    public void bindData(GoodsCommonBannerModel model) {
        GenericDraweeHierarchy $this$bindData_u24lambda_u2d0;
        if (model != null) {
            SimpleDraweeView simpleDraweeView = this.iconView;
            if (!(simpleDraweeView == null || ($this$bindData_u24lambda_u2d0 = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy()) == null)) {
                $this$bindData_u24lambda_u2d0.setPlaceholderImage(R.drawable.video_flow_goods_img_placeholder, ScalingUtils.ScaleType.CENTER_INSIDE);
            }
            SimpleDraweeView simpleDraweeView2 = this.iconView;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.setImageURI(model.getIcon());
            }
            UnifyTextView unifyTextView = this.titleView;
            if (unifyTextView != null) {
                unifyTextView.setText(model.getTitle());
            }
            UnifyTextView unifyTextView2 = this.subTitleView;
            if (unifyTextView2 != null) {
                unifyTextView2.setText(model.getSubTitle());
            }
            TextView $this$bindData_u24lambda_u2d1 = this.detailsBtn;
            if ($this$bindData_u24lambda_u2d1 != null) {
                $this$bindData_u24lambda_u2d1.setText(model.getButtonText());
                $this$bindData_u24lambda_u2d1.setBackground(ResourceUtils.getDrawable($this$bindData_u24lambda_u2d1.getContext(), R.drawable.video_flow_goods_item_common_details_bg));
                if (StringsKt.isBlank(model.getButtonText())) {
                    TextView textView = this.detailsBtn;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                } else {
                    TextView textView2 = this.detailsBtn;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                }
            }
            if (model.isDoubleLineTitle()) {
                UnifyTextView unifyTextView3 = this.titleView;
                if (unifyTextView3 != null) {
                    unifyTextView3.setMaxLines(2);
                }
                UnifyTextView unifyTextView4 = this.subTitleView;
                if (unifyTextView4 != null) {
                    unifyTextView4.setMaxLines(1);
                }
            } else if (model.isDoubleLineSubTitle()) {
                UnifyTextView unifyTextView5 = this.titleView;
                if (unifyTextView5 != null) {
                    unifyTextView5.setMaxLines(1);
                }
                UnifyTextView unifyTextView6 = this.subTitleView;
                if (unifyTextView6 != null) {
                    unifyTextView6.setMaxLines(2);
                }
            } else {
                UnifyTextView unifyTextView7 = this.titleView;
                if (unifyTextView7 != null) {
                    unifyTextView7.setMaxLines(1);
                }
                UnifyTextView unifyTextView8 = this.subTitleView;
                if (unifyTextView8 != null) {
                    unifyTextView8.setMaxLines(1);
                }
            }
            adjustStyle();
        }
    }

    private final void adjustStyle() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.iconView, R.dimen.video_flow_dimens_49dp, R.dimen.video_flow_dimens_49dp, 0, 0, 12, (Object) null);
        UnifyTextView $this$adjustStyle_u24lambda_u2d2 = this.titleView;
        if ($this$adjustStyle_u24lambda_u2d2 != null) {
            FontSizeHelperKt.setVideoScaledSizeRes$default($this$adjustStyle_u24lambda_u2d2, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
            $this$adjustStyle_u24lambda_u2d2.setTextColor(ResourceUtils.getColor($this$adjustStyle_u24lambda_u2d2.getContext(), com.baidu.android.common.ui.style.R.color.GC1));
        }
        UnifyTextView $this$adjustStyle_u24lambda_u2d3 = this.subTitleView;
        if ($this$adjustStyle_u24lambda_u2d3 != null) {
            FontSizeHelperKt.setVideoScaledSizeRes$default($this$adjustStyle_u24lambda_u2d3, R.dimen.video_flow_dimens_10dp, 0, 0, 6, (Object) null);
            $this$adjustStyle_u24lambda_u2d3.setTextColor(ResourceUtils.getColor($this$adjustStyle_u24lambda_u2d3.getContext(), com.baidu.android.common.ui.style.R.color.GC4));
        }
        TextView $this$adjustStyle_u24lambda_u2d6 = this.detailsBtn;
        if ($this$adjustStyle_u24lambda_u2d6 != null) {
            $this$adjustStyle_u24lambda_u2d6.setTextColor(ResourceUtils.getColor($this$adjustStyle_u24lambda_u2d6.getContext(), com.baidu.android.common.ui.style.R.color.GC51));
            ViewGroup.LayoutParams lp = $this$adjustStyle_u24lambda_u2d6.getLayoutParams();
            if (lp != null) {
                Intrinsics.checkNotNullExpressionValue(lp, "layoutParams");
                lp.width = (int) FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_61dp, 0, 2, (Object) null);
                lp.height = (int) FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_24dp, 0, 2, (Object) null);
            }
            FontSizeHelperKt.setVideoScaledSizeRes$default($this$adjustStyle_u24lambda_u2d6, R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
            Drawable background = $this$adjustStyle_u24lambda_u2d6.getBackground();
            GradientDrawable drawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            if (drawable != null) {
                drawable.setCornerRadius(FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_12dp, 0, 2, (Object) null));
                $this$adjustStyle_u24lambda_u2d6.setBackground(drawable);
            }
        }
    }
}
