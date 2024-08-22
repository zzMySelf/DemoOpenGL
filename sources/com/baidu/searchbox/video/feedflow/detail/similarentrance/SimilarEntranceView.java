package com.baidu.searchbox.video.feedflow.detail.similarentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.flowvideo.detail.repos.SimilarEntranceModel;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarEntranceView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "entranceSeparateLine", "Landroid/widget/ImageView;", "entranceTvLeft", "Landroid/widget/TextView;", "entranceTvRight", "viewCallback", "Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarEntranceView$OnViewCallback;", "getViewCallback", "()Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarEntranceView$OnViewCallback;", "setViewCallback", "(Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarEntranceView$OnViewCallback;)V", "bindModel", "", "model", "Lcom/baidu/searchbox/flowvideo/detail/repos/SimilarEntranceModel;", "setFontAndPictureSize", "OnViewCallback", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimilarEntranceView.kt */
public final class SimilarEntranceView extends LinearLayout {
    private final ImageView entranceSeparateLine;
    private final TextView entranceTvLeft;
    private final TextView entranceTvRight;
    private OnViewCallback viewCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimilarEntranceView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimilarEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimilarEntranceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_similar_collection_entrance_layout, this);
        View findViewById = findViewById(R.id.similar_entrance_text_right);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.similar_entrance_text_right)");
        this.entranceTvRight = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.similar_entrance_text_left);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.similar_entrance_text_left)");
        this.entranceTvLeft = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.similar_entrance_separate_middle);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.simila…entrance_separate_middle)");
        this.entranceSeparateLine = (ImageView) findViewById3;
        setFontAndPictureSize();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimilarEntranceView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final OnViewCallback getViewCallback() {
        return this.viewCallback;
    }

    public final void setViewCallback(OnViewCallback onViewCallback) {
        this.viewCallback = onViewCallback;
    }

    public final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.entranceTvRight, R.dimen.video_flow_dimens_15dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.entranceTvLeft, R.dimen.video_flow_dimens_15dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.entranceSeparateLine, R.dimen.video_flow_similar_collection_entrance_width, R.dimen.video_flow_dimens_11dp, 0, 0, 12, (Object) null);
    }

    public final void bindModel(SimilarEntranceModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.entranceTvLeft.setText(model.getText());
        this.entranceTvRight.setText(model.getSubText());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarEntranceView$OnViewCallback;", "", "onClickEntrance", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SimilarEntranceView.kt */
    public interface OnViewCallback {
        void onClickEntrance();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SimilarEntranceView.kt */
        public static final class DefaultImpls {
            public static void onClickEntrance(OnViewCallback onViewCallback) {
            }
        }
    }
}
