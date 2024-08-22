package com.baidu.searchbox.landscape.component;

import android.text.TextUtils;
import com.baidu.searchbox.card.util.CardConstants;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.home.feed.videodetail.utils.VideoDetailUbcUtils;
import com.baidu.searchbox.video.detail.utils.BdVideoSeriesFactory;
import com.baidu.searchbox.video.player.landscape.ILandscapeVideoPlayer;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import com.baidu.searchbox.video.template.VideoTemplateManifest;
import com.baidu.searchbox.video.template.fullrecommend.VideoFullRecommendItemModel;
import com.baidu.searchbox.video.widget.fulllist.OnItemCallback;
import com.baidu.searchbox.video.widget.fulllist.VideoFullRecommendView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/landscape/component/LandscapeRecommendComponent$getItemCallback$1", "Lcom/baidu/searchbox/video/widget/fulllist/OnItemCallback;", "onItemClick", "", "position", "", "model", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "onItemShow", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeRecommendComponent.kt */
public final class LandscapeRecommendComponent$getItemCallback$1 implements OnItemCallback {
    final /* synthetic */ LandscapeRecommendComponent this$0;

    LandscapeRecommendComponent$getItemCallback$1(LandscapeRecommendComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemShow(int position, FeedBaseModel model) {
    }

    public void onItemClick(int position, FeedBaseModel model) {
        String info;
        if ((model != null ? model.data : null) != null) {
            FeedBaseModel newModel = this.this$0.transformFeedBaseModel(model);
            OnRecommendListener onRecommendListener = this.this$0.getOnRecommendListener();
            if (onRecommendListener != null) {
                onRecommendListener.onItemClick(position, newModel);
            }
            VideoDetailUbcUtils.uploadRecommendList("relate_video_click", String.valueOf(position + 1));
            VideoFullRecommendView access$getFullListView$p = this.this$0.fullListView;
            if (access$getFullListView$p != null) {
                access$getFullListView$p.detachFromParentNoAnim();
            }
            VideoFullRecommendView access$getFullListView$p2 = this.this$0.fullListView;
            if (access$getFullListView$p2 != null) {
                access$getFullListView$p2.updateListData((List<FeedBaseModel>) null);
            }
            VideoFullRecommendView access$getFullListView$p3 = this.this$0.fullListView;
            if (access$getFullListView$p3 != null) {
                access$getFullListView$p3.setOriginKey(newModel.id);
            }
            if (model.data instanceof VideoFullRecommendItemModel) {
                FeedItemData feedItemData = model.data;
                if (feedItemData != null) {
                    VideoFullRecommendItemModel.VideoFullRecommendItemDataModel data = ((VideoFullRecommendItemModel) feedItemData).getData();
                    if (data != null && (info = data.getVideoInfo()) != null) {
                        LandscapeRecommendComponent landscapeRecommendComponent = this.this$0;
                        String videoInfo = info;
                        try {
                            JSONObject jsonObject = new JSONObject(videoInfo);
                            if (!TextUtils.isEmpty(jsonObject.optString("ext_log"))) {
                                JSONObject extObject = new JSONObject(jsonObject.optString("ext_log"));
                                extObject.put("relate", VideoTemplateManifest.VIDEO_FULL_RECOMMEND);
                                extObject.put("loc", String.valueOf(position + 1));
                                jsonObject.put("ext_log", extObject.toString());
                            }
                            String jSONObject = jsonObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
                            videoInfo = jSONObject;
                        } catch (JSONException e2) {
                            if (VideoRuntime.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                        ILandscapeVideoPlayer player = landscapeRecommendComponent.getRecommendCallBack().fetchPlayer();
                        BdVideoSeries series = BdVideoSeriesFactory.createVideoSeries(videoInfo);
                        if (series != null) {
                            if (player != null) {
                                player.stop();
                            }
                            if (player != null) {
                                Intrinsics.checkNotNullExpressionValue(series, CardConstants.CARD_ITEM_FOLLOW_SERIES);
                                player.setVideoSeries(series);
                            }
                            if (player != null) {
                                player.start(true);
                            }
                            OnRecommendListener onRecommendListener2 = landscapeRecommendComponent.getOnRecommendListener();
                            if (onRecommendListener2 != null) {
                                onRecommendListener2.onPlayNewItem(position, newModel);
                            }
                        }
                        VideoDetailUbcUtils.reportFullVideo("landscapePage", videoInfo, false);
                        VideoDetailUbcUtils.reportFullVideoPv("landscapePage", videoInfo, position);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.video.template.fullrecommend.VideoFullRecommendItemModel");
            }
        }
    }
}
