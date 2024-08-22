package com.baidu.searchbox.video.template.search.fullitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.video.model.VideoFullItemListInfo;
import com.baidu.searchbox.feed.video.model.VideoFullItemModel;
import com.baidu.searchbox.video.template.R;
import com.baidu.searchbox.video.template.fullitem.ILandscapeVideoFlowTpl;
import com.baidu.searchbox.video.template.fullitem.LandscapeVideoFlowItemBaseView;
import com.baidu.searchbox.video.template.fullitem.LandscapeVideoFlowItemView;
import com.baidu.searchbox.video.template.fullitem.LandscapeVideoFlowTemplateBaseView;
import com.baidu.searchbox.video.template.fullitem.LandscapeVideoFlowTemplateBaseViewKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J(\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/template/search/fullitem/SearchLandscapeVideoFlowTemplateView;", "Lcom/baidu/searchbox/video/template/fullitem/LandscapeVideoFlowTemplateBaseView;", "Lcom/baidu/searchbox/video/template/fullitem/ILandscapeVideoFlowTpl;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "foldView", "Lcom/baidu/searchbox/video/template/search/fullitem/VideoSetFoldView;", "isPanelVisible", "", "initialize", "", "onPanelVisibilityChanged", "isVisible", "update", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchLandscapeVideoFlowTemplateView.kt */
public final class SearchLandscapeVideoFlowTemplateView extends LandscapeVideoFlowTemplateBaseView implements ILandscapeVideoFlowTpl {
    private VideoSetFoldView foldView;
    private boolean isPanelVisible;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchLandscapeVideoFlowTemplateView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchLandscapeVideoFlowTemplateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initialize(Context context) {
        super.initialize(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (context != null) {
            Context ctx = context;
            LandscapeVideoFlowItemView $this$initialize_u24lambda_u2d4_u24lambda_u2d0 = new LandscapeVideoFlowItemView(ctx, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            $this$initialize_u24lambda_u2d4_u24lambda_u2d0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            $this$initialize_u24lambda_u2d4_u24lambda_u2d0.setId(R.id.video_landscape_item_content_view_id_search);
            setItemView($this$initialize_u24lambda_u2d4_u24lambda_u2d0);
            addView(getItemView());
            VideoSetFoldView videoSetFoldView = new VideoSetFoldView(ctx);
            VideoSetFoldView $this$initialize_u24lambda_u2d4_u24lambda_u2d1 = videoSetFoldView;
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-2, -2);
            lp.addRule(15);
            lp.addRule(11);
            $this$initialize_u24lambda_u2d4_u24lambda_u2d1.setLayoutParams(lp);
            $this$initialize_u24lambda_u2d4_u24lambda_u2d1.setId(R.id.video_landscape_item_fold_view_id_search);
            this.foldView = videoSetFoldView;
            addView(videoSetFoldView);
            VideoSetFoldView videoSetFoldView2 = this.foldView;
            if (videoSetFoldView2 != null) {
                videoSetFoldView2.setOnClickCallBack(new SearchLandscapeVideoFlowTemplateView$$ExternalSyntheticLambda0(this));
            }
            LandscapeVideoFlowItemBaseView itemView = getItemView();
            if (itemView != null) {
                itemView.setBackClickListener(new SearchLandscapeVideoFlowTemplateView$$ExternalSyntheticLambda1(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-4$lambda-2  reason: not valid java name */
    public static final void m7175initialize$lambda4$lambda2(SearchLandscapeVideoFlowTemplateView this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClick(v);
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-4$lambda-3  reason: not valid java name */
    public static final void m7176initialize$lambda4$lambda3(SearchLandscapeVideoFlowTemplateView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClick(this$0.getItemView());
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        VideoSetFoldView videoSetFoldView;
        super.update(feedModel, options);
        List payload = null;
        if ((feedModel != null ? feedModel.data : null) instanceof VideoFullItemModel) {
            FeedItemData feedItemData = feedModel.data;
            if (feedItemData != null) {
                VideoFullItemModel itemModel = (VideoFullItemModel) feedItemData;
                Object obj = options != null ? options.get("position") : null;
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int position = num != null ? num.intValue() : 0;
                Object extData = options != null ? options.get("ext") : null;
                Object obj2 = options != null ? options.get(LandscapeVideoFlowTemplateBaseViewKt.KEY_PAY_LOADS) : null;
                if (obj2 instanceof List) {
                    payload = (List) obj2;
                }
                if (payload == null || extData == null || !(extData instanceof VideoFullItemListInfo)) {
                    LandscapeVideoFlowItemBaseView itemView = getItemView();
                    if (itemView != null) {
                        itemView.bindData(feedModel, position);
                    }
                    if ((extData instanceof VideoFullItemListInfo) && (videoSetFoldView = this.foldView) != null) {
                        String str = itemModel.mPoster;
                        Intrinsics.checkNotNullExpressionValue(str, "itemModel.mPoster");
                        videoSetFoldView.bindData((VideoFullItemListInfo) extData, str);
                    }
                    VideoSetFoldView videoSetFoldView2 = this.foldView;
                    if (videoSetFoldView2 != null) {
                        videoSetFoldView2.setVisibility(8);
                        return;
                    }
                    return;
                }
                VideoSetFoldView videoSetFoldView3 = this.foldView;
                if (videoSetFoldView3 != null) {
                    String str2 = itemModel.mPoster;
                    Intrinsics.checkNotNullExpressionValue(str2, "itemModel.mPoster");
                    videoSetFoldView3.bindData((VideoFullItemListInfo) extData, str2);
                }
                onPanelVisibilityChanged(this.isPanelVisible);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.video.model.VideoFullItemModel");
        }
    }

    public void onPanelVisibilityChanged(boolean isVisible) {
        this.isPanelVisible = isVisible;
        if (isVisible) {
            VideoSetFoldView videoSetFoldView = this.foldView;
            boolean z = true;
            if (videoSetFoldView == null || !videoSetFoldView.getHadBindData()) {
                z = false;
            }
            if (z) {
                VideoSetFoldView videoSetFoldView2 = this.foldView;
                if (videoSetFoldView2 != null) {
                    videoSetFoldView2.setVisibility(0);
                }
                VideoSetFoldView videoSetFoldView3 = this.foldView;
                if (videoSetFoldView3 != null) {
                    videoSetFoldView3.doGuideAnim();
                    return;
                }
                return;
            }
        }
        VideoSetFoldView videoSetFoldView4 = this.foldView;
        if (videoSetFoldView4 != null) {
            videoSetFoldView4.setVisibility(8);
        }
    }
}
