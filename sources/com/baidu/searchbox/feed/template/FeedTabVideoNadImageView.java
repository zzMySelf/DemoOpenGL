package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.template.ad.normandy.operate.AdNormandyOperateView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J(\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedTabVideoNadImageView;", "Lcom/baidu/searchbox/feed/template/FeedTabVideoNadBaseView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageView", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "initInflate", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onAttachedToWindow", "", "update", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "", "updateVideoImageParams", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabVideoNadImageView.kt */
public final class FeedTabVideoNadImageView extends FeedTabVideoNadBaseView {
    private FeedDraweeView imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTabVideoNadImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public View initInflate(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View v = inflater.inflate(R.layout.feed_tpl_tab_video_nad_image_view, this);
        FeedDraweeView it = (FeedDraweeView) findViewById(R.id.feed_template_big_image_id);
        this.imageView = it;
        if (it != null) {
            it.setTemplateFlag(4);
        }
        setNormandyOperate((AdNormandyOperateView) findViewById(R.id.feed_ad_normandy_operate));
        updateVideoImageParams();
        Intrinsics.checkNotNullExpressionValue(v, "v");
        return v;
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        FeedDraweeView itImageView;
        super.update(feedModel, options);
        String url = null;
        FeedItemData feedItemData = feedModel != null ? feedModel.data : null;
        FeedItemDataTabVideo it = feedItemData instanceof FeedItemDataTabVideo ? (FeedItemDataTabVideo) feedItemData : null;
        if (it != null && it.isValidBigImg()) {
            FeedItemDataNews.Image image = (FeedItemDataNews.Image) it.images.get(0);
            if (image != null) {
                url = image.image;
            }
            if (!TextUtils.isEmpty(url) && (itImageView = this.imageView) != null) {
                itImageView.setPlaceHolderWithSelfFlag().loadImage(url, feedModel);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r5.getFeedModel()
            r1 = 0
            if (r0 == 0) goto L_0x0011
            com.baidu.searchbox.feed.model.FeedItemData r0 = r0.data
            if (r0 == 0) goto L_0x0011
            com.baidu.searchbox.feed.ad.model.AdModuleData r0 = r0.ad
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            boolean r2 = r0 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 == 0) goto L_0x0022
            com.baidu.searchbox.ad.model.AdNormandyModel r0 = r0.normandy
            if (r0 == 0) goto L_0x0022
            java.util.List r1 = r0.getTransition()
        L_0x0022:
            r0 = 0
            java.lang.Object r1 = com.baidu.searchbox.ad.util.CollectionUtils.get(r1, (int) r0)
            com.baidu.searchbox.ad.model.TransitionItem r1 = (com.baidu.searchbox.ad.model.TransitionItem) r1
            if (r1 == 0) goto L_0x0036
            long r1 = r1.delay
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            int r1 = (int) r1
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r0)
            goto L_0x0037
        L_0x0036:
            r0 = 2
        L_0x0037:
            com.baidu.searchbox.feed.template.ad.normandy.operate.AdNormandyOperateView r1 = r5.getNormandyOperate()
            if (r1 == 0) goto L_0x0041
            r1.emerge(r0)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedTabVideoNadImageView.onAttachedToWindow():void");
    }

    private final void updateVideoImageParams() {
        int videoImageWidth = FeedTemplateUtil.getCalculateWidth(getContext());
        FeedDraweeView feedDraweeView = this.imageView;
        RelativeLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = feedDraweeView != null ? feedDraweeView.getLayoutParams() : null;
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        }
        RelativeLayout.LayoutParams imageLP = layoutParams;
        if (imageLP != null) {
            imageLP.width = videoImageWidth;
        }
        if (imageLP != null) {
            imageLP.height = MathKt.roundToInt((((float) videoImageWidth) * 9.0f) / 16.0f);
        }
        FeedDraweeView feedDraweeView2 = this.imageView;
        if (feedDraweeView2 != null) {
            feedDraweeView2.setLayoutParams(imageLP);
        }
    }
}
