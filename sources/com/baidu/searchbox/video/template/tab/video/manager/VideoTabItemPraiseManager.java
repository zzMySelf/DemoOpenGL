package com.baidu.searchbox.video.template.tab.video.manager;

import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.video.template.tab.video.praise.IVideoTabPraiseManager;
import com.baidu.searchbox.video.template.tab.video.praise.IVideoTabUploadPraise;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/template/tab/video/manager/VideoTabItemPraiseManager;", "", "()V", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getFeedModel", "()Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "setFeedModel", "(Lcom/baidu/searchbox/feed/model/FeedBaseModel;)V", "processLikeData", "", "updatePraiseDb", "isPraised", "", "count", "", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabItemPraiseManager.kt */
public final class VideoTabItemPraiseManager {
    private FeedBaseModel feedModel;

    public final FeedBaseModel getFeedModel() {
        return this.feedModel;
    }

    public final void setFeedModel(FeedBaseModel feedBaseModel) {
        this.feedModel = feedBaseModel;
    }

    public final void processLikeData() {
        FeedBar.Like like;
        FeedBar.Like like2;
        FeedBaseModel feedBaseModel = this.feedModel;
        String str = null;
        FeedItemData feedItemData = feedBaseModel != null ? feedBaseModel.data : null;
        FeedItemDataTabVideo data = feedItemData instanceof FeedItemDataTabVideo ? (FeedItemDataTabVideo) feedItemData : null;
        if (data != null) {
            String url = IVideoTabPraiseManager.Impl.INSTANCE.get().getPraiseUrl();
            boolean z = true;
            if (!StringsKt.isBlank(url)) {
                JSONObject json = new JSONObject();
                FeedBaseModel feedBaseModel2 = this.feedModel;
                String str2 = feedBaseModel2 != null ? feedBaseModel2.id : null;
                String str3 = "";
                if (str2 == null) {
                    str2 = str3;
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "feedModel?.id ?: \"\"");
                }
                json.putOpt("nid", str2);
                FeedBar feedBar = data.feedBar;
                if (feedBar == null || (like2 = feedBar.like) == null || !like2.status) {
                    z = false;
                }
                json.putOpt("type", z ? "1" : "0");
                FeedBar feedBar2 = data.feedBar;
                if (!(feedBar2 == null || (like = feedBar2.like) == null)) {
                    str = like.ext;
                }
                if (str != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "data.feedBar?.like?.ext ?: \"\"");
                    str3 = str;
                }
                json.putOpt("ext", str3);
                Map params = new HashMap();
                params.put("data", json.toString());
                IVideoTabUploadPraise.Impl.INSTANCE.get().uploadLikeDataToServer(url, params);
            }
        }
    }

    public final void updatePraiseDb(boolean isPraised, int count) {
        FeedBaseModel model = this.feedModel;
        if (model != null) {
            LinkageData linkageData = new LinkageData();
            linkageData.nid = model.id;
            linkageData.status = isPraised ? "1" : "0";
            linkageData.count = String.valueOf(count);
            linkageData.type = "pro";
            linkageData.isUsed = true;
            String business = model.runtimeStatus.business;
            Intrinsics.checkNotNullExpressionValue(business, "model.runtimeStatus.business");
            FeedLinkageManager.getInstance(business).addLinkage(linkageData);
        }
    }
}
