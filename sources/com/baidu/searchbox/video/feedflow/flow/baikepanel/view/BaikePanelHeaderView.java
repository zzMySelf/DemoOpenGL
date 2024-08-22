package com.baidu.searchbox.video.feedflow.flow.baikepanel.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelHeaderModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.LimbicView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\nJ\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/baikepanel/view/BaikePanelHeaderView;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/LimbicView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeClickListener", "Landroid/view/View$OnClickListener;", "flClose", "Landroid/widget/FrameLayout;", "headerData", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelHeaderModel;", "ivClose", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "changeStyle", "style", "setFontAndPictureSize", "setOnCloseClickListener", "listener", "setTextStyle", "textView", "showLoadingUi", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaikePanelHeaderView.kt */
public final class BaikePanelHeaderView extends LimbicView {
    private View.OnClickListener closeClickListener;
    private final FrameLayout flClose;
    private CollectionPanelHeaderModel headerData;
    private final ImageView ivClose;
    private final TextView tvTitle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaikePanelHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaikePanelHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaikePanelHeaderView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaikePanelHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_baike_header_view, this);
        View findViewById = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_title)");
        TextView textView = (TextView) findViewById;
        this.tvTitle = textView;
        setTextStyle(textView);
        View findViewById2 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_close)");
        this.ivClose = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.fl_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fl_close)");
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        this.flClose = frameLayout;
        frameLayout.setOnClickListener(new BaikePanelHeaderView$$ExternalSyntheticLambda0(this));
        setFontAndPictureSize();
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m6058_init_$lambda0(BaikePanelHeaderView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.closeClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this$0.flClose);
        }
    }

    private final void setTextStyle(TextView textView) {
        TextPaint $this$setTextStyle_u24lambda_u2d1;
        if (textView != null && ($this$setTextStyle_u24lambda_u2d1 = textView.getPaint()) != null) {
            $this$setTextStyle_u24lambda_u2d1.setStyle(Paint.Style.FILL_AND_STROKE);
            $this$setTextStyle_u24lambda_u2d1.setStrokeWidth(0.5f);
        }
    }

    private final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivClose, com.baidu.searchbox.feed.styles.R.dimen.F_T_X00100003, com.baidu.searchbox.feed.styles.R.dimen.F_T_X00100003, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.tvTitle, com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X131, 0, 0, 6, (Object) null);
    }

    public final void setOnCloseClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.closeClickListener = listener;
    }

    public void bindData(CollectionCommonModel data) {
        Unit unit;
        Intrinsics.checkNotNullParameter(data, "data");
        if (BaikePanelHeaderViewKt.isBaikeHeader(data)) {
            CollectionPanelHeaderModel headerData2 = BaikePanelHeaderViewKt.getBaikePanelHeaderModel(data);
            this.headerData = headerData2;
            if (headerData2 != null) {
                setVisibility(0);
                this.tvTitle.setText(headerData2.getTitle() + ' ' + headerData2.getSubtitle());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                setVisibility(8);
            }
        }
    }

    public void showLoadingUi() {
        setVisibility(8);
    }

    public void changeStyle(int style) {
        setFontAndPictureSize();
    }
}
