package com.baidu.searchbox.video.feedflow.detail.audit.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.flowvideo.detail.repos.DibarEntryModel;
import com.baidu.searchbox.flowvideo.detail.repos.DibarPanelModel;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.PanelContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/audit/adapter/AuditPanelContentView;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/PanelContentView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivContent", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "changeStyle", "style", "setRespondFontSize", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuditPanelContentView.kt */
public final class AuditPanelContentView extends PanelContentView {
    private TextView ivContent;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuditPanelContentView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuditPanelContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuditPanelContentView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuditPanelContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_audit_content_view, this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.iv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_content)");
        this.ivContent = (TextView) findViewById;
    }

    public void bindData(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (AuditPanelContentViewKt.isAuditContent(data)) {
            Object obj = data.getExtData().get((Object) "audit_panel_content_view");
            String str = null;
            DibarEntryModel $this$bindData_u24lambda_u2d0 = obj instanceof DibarEntryModel ? (DibarEntryModel) obj : null;
            if ($this$bindData_u24lambda_u2d0 != null) {
                TextView textView = this.ivContent;
                DibarPanelModel panel = $this$bindData_u24lambda_u2d0.getPanel();
                if (panel != null) {
                    str = panel.getContent();
                }
                textView.setText(str);
            }
        }
    }

    public void changeStyle(int style) {
    }

    public final void setRespondFontSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.ivContent, com.baidu.searchbox.feed.styles.R.dimen.F_T_X00200001, 0, 0, 6, (Object) null);
    }
}
