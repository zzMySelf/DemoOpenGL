package com.baidu.searchbox.video.widget.fulllist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.video.detail.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/widget/fulllist/DefaultVideoFullRelateHeaderView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "headerTxt", "Landroid/widget/TextView;", "updateHeader", "", "title", "", "showCloseIcon", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultVideoFullRelateHeaderView.kt */
public final class DefaultVideoFullRelateHeaderView extends LinearLayout {
    private View closeView;
    private TextView headerTxt;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultVideoFullRelateHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultVideoFullRelateHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultVideoFullRelateHeaderView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultVideoFullRelateHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout.inflate(context, R.layout.video_default_full_relate_header_view, this);
        View findViewById = findViewById(R.id.video_landscape_full_header_txt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_landscape_full_header_txt)");
        this.headerTxt = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.video_landscape_full_header_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.video_…dscape_full_header_close)");
        this.closeView = findViewById2;
        updateHeader(getResources().getString(com.baidu.searchbox.video.template.R.string.video_landscape_video_relate), true);
    }

    public final void updateHeader(String title, boolean showCloseIcon) {
        this.headerTxt.setText(title);
        this.closeView.setVisibility(showCloseIcon ? 0 : 8);
    }
}
