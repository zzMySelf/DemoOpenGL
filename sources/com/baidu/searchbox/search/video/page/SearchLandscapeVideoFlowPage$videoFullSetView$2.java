package com.baidu.searchbox.search.video.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.baidu.searchbox.video.R;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.widget.fulllist.VideoFullRecommendView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/widget/fulllist/VideoFullRecommendView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchLandscapeVideoFlowPage.kt */
final class SearchLandscapeVideoFlowPage$videoFullSetView$2 extends Lambda implements Function0<VideoFullRecommendView> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ SearchLandscapeVideoFlowPage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchLandscapeVideoFlowPage$videoFullSetView$2(Activity activity, SearchLandscapeVideoFlowPage searchLandscapeVideoFlowPage) {
        super(0);
        this.$activity = activity;
        this.this$0 = searchLandscapeVideoFlowPage;
    }

    public final VideoFullRecommendView invoke() {
        VideoFullRecommendView videoFullRecommendView = new VideoFullRecommendView(this.$activity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Activity activity = this.$activity;
        SearchLandscapeVideoFlowPage searchLandscapeVideoFlowPage = this.this$0;
        VideoFullRecommendView $this$invoke_u24lambda_u2d0 = videoFullRecommendView;
        Context context = activity;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(new int[]{ResourceUtils.getColor(context, R.color.video_landscape_full_set_view_shadow1), ResourceUtils.getColor(context, R.color.video_landscape_full_set_view_shadow2), ResourceUtils.getColor(context, R.color.video_landscape_full_set_view_shadow3), ResourceUtils.getColor(context, R.color.video_landscape_full_set_view_shadow4), ResourceUtils.getColor(context, R.color.video_landscape_full_set_view_shadow5)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        $this$invoke_u24lambda_u2d0.setBackground(gradientDrawable);
        float containerWidth = $this$invoke_u24lambda_u2d0.getResources().getDimension(R.dimen.video_full_set_view_width);
        float rootViewWidth = $this$invoke_u24lambda_u2d0.getResources().getDimension(R.dimen.video_full_set_view_list_width);
        float paddingRight = $this$invoke_u24lambda_u2d0.getResources().getDimension(R.dimen.video_full_set_view_padding_right);
        $this$invoke_u24lambda_u2d0.setWidth((int) containerWidth, (int) rootViewWidth);
        $this$invoke_u24lambda_u2d0.setMargin(0, 0, (int) paddingRight, 0);
        $this$invoke_u24lambda_u2d0.setCanceledOnTouchOutside(true);
        $this$invoke_u24lambda_u2d0.setOnAttachListener(new SearchLandscapeVideoFlowPage$videoFullSetView$2$1$1(searchLandscapeVideoFlowPage));
        return videoFullRecommendView;
    }
}
