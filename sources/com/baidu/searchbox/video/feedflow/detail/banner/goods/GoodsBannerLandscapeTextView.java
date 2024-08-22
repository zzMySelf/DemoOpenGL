package com.baidu.searchbox.video.feedflow.detail.banner.goods;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBannerLandscapeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoTruncationTextHelper", "Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/AutoTruncationTextHelper;", "getTextCallback", "Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBannerLandscapeTextView$GetTextCallback;", "getGetTextCallback", "()Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBannerLandscapeTextView$GetTextCallback;", "setGetTextCallback", "(Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBannerLandscapeTextView$GetTextCallback;)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "GetTextCallback", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsBannerLandscapeTextView.kt */
public final class GoodsBannerLandscapeTextView extends AppCompatTextView {
    private AutoTruncationTextHelper autoTruncationTextHelper;
    private GetTextCallback getTextCallback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBannerLandscapeTextView$GetTextCallback;", "", "getText", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GoodsBannerLandscapeTextView.kt */
    public interface GetTextCallback {
        String getText();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoodsBannerLandscapeTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoodsBannerLandscapeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoodsBannerLandscapeTextView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsBannerLandscapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoTruncationTextHelper = new AutoTruncationTextHelper(context, this, "...");
    }

    public final GetTextCallback getGetTextCallback() {
        return this.getTextCallback;
    }

    public final void setGetTextCallback(GetTextCallback getTextCallback2) {
        this.getTextCallback = getTextCallback2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredWidth() > 0) {
            AutoTruncationTextHelper autoTruncationTextHelper2 = this.autoTruncationTextHelper;
            int measuredWidth = getMeasuredWidth();
            GetTextCallback getTextCallback2 = this.getTextCallback;
            autoTruncationTextHelper2.initTextView(measuredWidth, 6, String.valueOf(getTextCallback2 != null ? getTextCallback2.getText() : null));
        }
    }
}
