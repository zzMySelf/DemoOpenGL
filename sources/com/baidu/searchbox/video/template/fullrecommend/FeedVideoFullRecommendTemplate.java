package com.baidu.searchbox.video.template.fullrecommend;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.video.template.VideoTemplateManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/template/fullrecommend/FeedVideoFullRecommendTemplate;", "Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate;", "()V", "newItemModel", "Lcom/baidu/searchbox/video/template/fullrecommend/VideoFullRecommendItemModel;", "dataObj", "Lorg/json/JSONObject;", "newItemView", "Lcom/baidu/searchbox/feed/base/FeedTemplate;", "ctx", "Landroid/content/Context;", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedVideoFullRecommendTemplate.kt */
public final class FeedVideoFullRecommendTemplate extends SimpleFeedTemplate {
    public FeedVideoFullRecommendTemplate() {
        super(VideoTemplateManifest.VIDEO_FULL_RECOMMEND, FeedTabVideoFullRecommendTemplateView.class, VideoFullRecommendItemModel.class, SimpleFeedTemplate.Policy.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return new FeedTabVideoFullRecommendTemplateView(ctx);
    }

    /* access modifiers changed from: protected */
    public VideoFullRecommendItemModel newItemModel(JSONObject dataObj) {
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        return new VideoFullRecommendItemModel();
    }
}
