package com.baidu.searchbox.video.feedflow.detail.audit.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.LimbicView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0006\u0010\u001b\u001a\u00020\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/audit/adapter/AuditPanelFooterView;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/LimbicView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "auditFooterClickListener", "Lcom/baidu/searchbox/video/feedflow/detail/audit/adapter/IAuditFooterClickListener;", "getAuditFooterClickListener", "()Lcom/baidu/searchbox/video/feedflow/detail/audit/adapter/IAuditFooterClickListener;", "setAuditFooterClickListener", "(Lcom/baidu/searchbox/video/feedflow/detail/audit/adapter/IAuditFooterClickListener;)V", "ivFeedBack", "Landroid/widget/LinearLayout;", "ivFeedBackIcon", "Landroid/widget/ImageView;", "ivFeedBackTitle", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "changeStyle", "style", "setRespondFontSize", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuditPanelFooterView.kt */
public final class AuditPanelFooterView extends LimbicView {
    private IAuditFooterClickListener auditFooterClickListener;
    private LinearLayout ivFeedBack;
    private ImageView ivFeedBackIcon;
    private TextView ivFeedBackTitle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuditPanelFooterView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuditPanelFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuditPanelFooterView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuditPanelFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_audit_footer_view, this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.iv_feedback_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_feedback_btn)");
        this.ivFeedBack = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.iv_feedback_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_feedback_title)");
        this.ivFeedBackTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.iv_feedback_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_feedback_icon)");
        this.ivFeedBackIcon = (ImageView) findViewById3;
    }

    public final IAuditFooterClickListener getAuditFooterClickListener() {
        return this.auditFooterClickListener;
    }

    public final void setAuditFooterClickListener(IAuditFooterClickListener iAuditFooterClickListener) {
        this.auditFooterClickListener = iAuditFooterClickListener;
    }

    public void bindData(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (AuditPanelFooterViewKt.isAuditFooter(data)) {
            this.ivFeedBack.setOnClickListener(new AuditPanelFooterView$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m10605bindData$lambda0(AuditPanelFooterView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAuditFooterClickListener iAuditFooterClickListener = this$0.auditFooterClickListener;
        if (iAuditFooterClickListener != null) {
            iAuditFooterClickListener.feedbackClick();
        }
    }

    public void changeStyle(int style) {
    }

    public final void setRespondFontSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivFeedBackTitle, com.baidu.searchbox.feed.styles.R.dimen.F_T_X003, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivFeedBackIcon, R.dimen.video_flow_dimens_14dp, R.dimen.video_flow_dimens_14dp, 0, 0, 12, (Object) null);
    }
}
