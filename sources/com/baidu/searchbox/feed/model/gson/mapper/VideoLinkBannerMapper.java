package com.baidu.searchbox.feed.model.gson.mapper;

import android.text.TextUtils;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.gson.bean.VideoLinkBannerBean;
import com.baidu.searchbox.feed.model.gson.bean.VideoLinkBannerExactPlayBean;
import com.baidu.searchbox.feed.model.gson.bean.VideoLinkBannerShowTimeBean;
import com.baidu.searchbox.feed.video.banner.model.VideoLinkBannerModel;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/mapper/VideoLinkBannerMapper;", "", "()V", "map", "", "input", "Lcom/baidu/searchbox/feed/model/gson/bean/VideoLinkBannerBean;", "output", "Lcom/baidu/searchbox/feed/model/FeedItemDataTabVideo;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoLinkBannerMapper.kt */
public final class VideoLinkBannerMapper {
    public static final VideoLinkBannerMapper INSTANCE = new VideoLinkBannerMapper();

    private VideoLinkBannerMapper() {
    }

    @JvmStatic
    public static final void map(VideoLinkBannerBean input, FeedItemDataTabVideo output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, BindingXConstants.KEY_INTERPOLATER_OUTPUT);
        if (output.mVideoLinkBannerModel == null) {
            output.mVideoLinkBannerModel = new VideoLinkBannerModel();
        }
        VideoLinkBannerModel other = output.mVideoLinkBannerModel;
        Intrinsics.checkNotNullExpressionValue(other, "output.mVideoLinkBannerModel");
        other.mVideoPostImgUrl = input.getIconUrl();
        other.mPosterRatio = input.getIconRatio();
        other.mVideoTitle = input.getTitleText();
        other.mShowVideoIcon = input.getShowPlayIcon();
        other.mVideoDesc = input.getDescText();
        other.mCmd = input.getCmd();
        other.setMode(input.getMode());
        other.setPreloadScheme(input.getPreloadScheme());
        other.mTemplate = input.getTemplate();
        other.mExt = input.getExt();
        VideoLinkBannerShowTimeBean bean = input.getShowTime();
        if (bean != null) {
            VideoLinkBannerShowTimeMapper.map(bean, other);
        }
        other.mIsYNCM = input.isYNCM();
        other.mGuideImg = input.getRightImg();
        VideoLinkBannerExactPlayBean bean2 = input.getExactPlay();
        if (bean2 != null) {
            VideoLinkBannerExactPlayMapper.map(bean2, other);
        }
        other.mShowH5Url = input.getShowH5Url();
        other.mTextButton = input.getTextButton();
        other.isShowClose = input.getShowClose();
        other.mTag = input.getTag();
        other.mInteractive = input.getInteractive();
        try {
            if (!TextUtils.isEmpty(input.getExt_form())) {
                other.mExtForm = new JSONObject(input.getExt_form());
            } else {
                other.mExtForm = null;
            }
        } catch (JSONException e2) {
            other.mExtForm = null;
        }
    }
}
