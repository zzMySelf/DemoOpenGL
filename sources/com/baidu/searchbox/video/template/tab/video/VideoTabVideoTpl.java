package com.baidu.searchbox.video.template.tab.video;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.template.FeedTabVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/template/tab/video/VideoTabVideoTpl;", "Lcom/baidu/searchbox/feed/base/SimpleFeedTemplate;", "()V", "newItemModel", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "dataObj", "Lorg/json/JSONObject;", "newItemView", "Lcom/baidu/searchbox/feed/base/FeedTemplate;", "ctx", "Landroid/content/Context;", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabVideoTpl.kt */
public final class VideoTabVideoTpl extends SimpleFeedTemplate {
    public VideoTabVideoTpl() {
        super("video_tab_video", FeedTabVideoView.class, FeedItemDataTabVideo.class, SimpleFeedTemplate.Policy.NO_ORIGINAL_POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return new VideoTabVideoView(ctx);
    }

    /* access modifiers changed from: protected */
    public FeedItemData newItemModel(JSONObject dataObj) {
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        return new FeedItemDataTabVideo();
    }
}
