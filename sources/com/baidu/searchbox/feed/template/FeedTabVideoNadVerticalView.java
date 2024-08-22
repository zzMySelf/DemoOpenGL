package com.baidu.searchbox.feed.template;

import android.content.Context;
import com.baidu.searchbox.feed.ad.model.AdModuleData;
import com.baidu.searchbox.feed.ad.model.VideoAdItemVerticalStyleModel;
import com.baidu.searchbox.feed.model.FeedAdData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.video.detail.autoplay.base.VideoAutoPlayModel;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.invoker.BdVideoNewParser;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedTabVideoNadVerticalView;", "Lcom/baidu/searchbox/feed/template/FeedTabVideoNadVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getVerticalVideoStyleModel", "Lcom/baidu/searchbox/feed/ad/model/VideoAdItemVerticalStyleModel;", "model", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "prepareAutoPlayModel", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabVideoNadVerticalView.kt */
public final class FeedTabVideoNadVerticalView extends FeedTabVideoNadVideoView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTabVideoNadVerticalView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void prepareAutoPlayModel(FeedBaseModel model) {
        VideoAdItemVerticalStyleModel styleModel;
        BdVideoSeries videoSeries;
        if (model != null && (styleModel = getVerticalVideoStyleModel(model)) != null && (videoSeries = BdVideoNewParser.parseToVideoSeriesSafely(getVideoInfo())) != null) {
            videoSeries.setTag(styleModel);
            FeedBaseModel it = model;
            String str = it.layout;
            Intrinsics.checkNotNullExpressionValue(str, "it.layout");
            String str2 = it.id;
            Intrinsics.checkNotNullExpressionValue(str2, "it.id");
            VideoAutoPlayModel $this$prepareAutoPlayModel_u24lambda_u2d1_u24lambda_u2d0 = new VideoAutoPlayModel(str, str2, "", videoSeries, (HashMap) null, 16, (DefaultConstructorMarker) null);
            $this$prepareAutoPlayModel_u24lambda_u2d1_u24lambda_u2d0.getExternal().put("extends_data_key", it);
            setCurAutoPlayerModel($this$prepareAutoPlayModel_u24lambda_u2d1_u24lambda_u2d0);
        }
    }

    private final VideoAdItemVerticalStyleModel getVerticalVideoStyleModel(FeedBaseModel model) {
        FeedAdData feedAdData;
        FeedItemData feedItemData = model.data;
        AdModuleData adModuleData = feedItemData != null ? feedItemData.ad : null;
        if (!(adModuleData instanceof AdModuleData)) {
            adModuleData = null;
        }
        if (adModuleData == null || (feedAdData = adModuleData.feed) == null) {
            return null;
        }
        return feedAdData.mVideoAdItemVerticalStyleModel;
    }
}
