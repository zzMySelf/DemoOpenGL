package com.baidu.searchbox.video.template.utils;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataAdCarousel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.history.api.IHistoryManager;
import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.data.HistoryFeature;
import com.baidu.searchbox.history.api.data.HistoryModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"addAdHistory", "", "feedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "cmd", "", "lib-template_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HistoryUtils.kt */
public final class HistoryUtilsKt {
    public static final void addAdHistory(FeedBaseModel feedBaseModel, String cmd) {
        String source;
        if ((feedBaseModel != null ? feedBaseModel.data : null) != null) {
            HistoryModel model = new HistoryModel();
            HistoryFeature feature = new HistoryFeature();
            if (feedBaseModel.data instanceof FeedItemDataNews) {
                FeedItemData feedItemData = feedBaseModel.data;
                if (feedItemData != null) {
                    FeedItemDataNews itemData = (FeedItemDataNews) feedItemData;
                    String imageUrl = "";
                    if (itemData instanceof FeedItemDataAdCarousel) {
                        FeedItemData feedItemData2 = feedBaseModel.data;
                        if (feedItemData2 != null) {
                            imageUrl = ((FeedItemDataAdCarousel) feedItemData2).mAdCarouselList.get(0).image.url;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemDataAdCarousel");
                        }
                    } else if (itemData.images != null && itemData.images.size() >= 1) {
                        imageUrl = itemData.images.get(0).image;
                    }
                    model.setImg(imageUrl);
                    if (itemData instanceof FeedItemDataTabVideo) {
                        source = ((FeedItemDataTabVideo) itemData).mAuthor;
                    } else {
                        source = feedBaseModel.data.source;
                    }
                    feature.setSource(source);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedItemDataNews");
                }
            }
            try {
                model.setUkey(feedBaseModel.id);
                model.setTplId("feed_ad");
                model.setTitle(feedBaseModel.data.title);
                model.setCmd(cmd);
                model.setFeature(feature);
                model.setCreateTime(System.currentTimeMillis());
                JSONObject extra = new JSONObject();
                JSONObject ubcJson = new JSONObject();
                ubcJson.putOpt("source", "read_adfeed");
                extra.putOpt("ubcjson", ubcJson);
                model.setExtra(extra.toString());
                Object service = ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE);
                Intrinsics.checkNotNullExpressionValue(service, "getService<IHistoryManag…anager.SERVICE_REFERENCE)");
                ((IHistoryManager) service).addHistory(model, (HistoryDataCallback<Boolean>) null);
            } catch (Exception e2) {
                if (FeedRuntime.GLOBAL_DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
