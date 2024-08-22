package com.baidu.searchbox.video.component.share.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.video.component.share.ShareModel;
import com.baidu.searchbox.video.detail.export.IVideoShareUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/component/share/mapper/ShareModel2BeanMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/video/component/share/ShareModel;", "Lcom/baidu/searchbox/video/detail/export/IVideoShareUtils$ShareBean;", "()V", "map", "input", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareModel2BeanMapper.kt */
public final class ShareModel2BeanMapper implements Mapper<ShareModel, IVideoShareUtils.ShareBean> {
    public static final ShareModel2BeanMapper INSTANCE = new ShareModel2BeanMapper();

    private ShareModel2BeanMapper() {
    }

    public IVideoShareUtils.ShareBean map(ShareModel input) {
        Intrinsics.checkNotNullParameter(input, "input");
        IVideoShareUtils.ShareBean shareBean = new IVideoShareUtils.ShareBean();
        IVideoShareUtils.ShareBean $this$map_u24lambda_u2d0 = shareBean;
        $this$map_u24lambda_u2d0.mTitle = input.getTitle();
        $this$map_u24lambda_u2d0.mContent = input.getContent();
        $this$map_u24lambda_u2d0.mLinkUrl = input.getLinkUrl();
        $this$map_u24lambda_u2d0.mIconUrl = input.getIconUrl();
        $this$map_u24lambda_u2d0.mCategoryInfo = input.getCategoryInfo();
        $this$map_u24lambda_u2d0.mVideoUrl = input.getVideoUrl();
        $this$map_u24lambda_u2d0.mPage = input.getPage();
        $this$map_u24lambda_u2d0.mCollId = input.getCollId();
        $this$map_u24lambda_u2d0.mExtLog = input.getExtLog();
        $this$map_u24lambda_u2d0.mHotResourceShareAnimConfig = input.getHotShareAnimeConfig();
        $this$map_u24lambda_u2d0.hideSharePanelAnim = input.getHideSharePanelAnim();
        $this$map_u24lambda_u2d0.mThemeId = input.getThemeId();
        $this$map_u24lambda_u2d0.mType = input.getType();
        $this$map_u24lambda_u2d0.isCommentVideo = input.isCommentVideo();
        $this$map_u24lambda_u2d0.mForward = input.getDtShareCmd();
        $this$map_u24lambda_u2d0.panelXOffset = input.getPanelXOffset();
        return shareBean;
    }
}
