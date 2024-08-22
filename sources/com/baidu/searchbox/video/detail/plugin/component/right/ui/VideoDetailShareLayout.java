package com.baidu.searchbox.video.detail.plugin.component.right.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.event.LandScapeVideoLikeEvent;
import com.baidu.searchbox.feed.event.VideoContinuePlayEvent;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.searchbox.screenshot.SystemScreenshotShareUBC;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.core.model.VideoDetailModel;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.detail.export.IVideoSender;
import com.baidu.searchbox.video.detail.model.ShareSource;
import com.baidu.searchbox.video.detail.plugin.component.right.model.VideoDetailInfoModel;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.detail.utils.VideoDetailUbcExtUtils;
import com.baidu.searchbox.video.detail.utils.VideoLikeUtils;
import com.baidu.searchbox.video.detail.utils.VideoUiUtilsKt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.Action1;

public abstract class VideoDetailShareLayout {
    private static final boolean DEBUG = IVideoAppConfig.Impl.get().isDebug();
    private static final int STAR = 2;
    private static final String TAG = "VideoDetailShareLayout";
    private static final String TYPE_WECAHT_FRI = "weixin_friend";
    private static final String TYPE_WECAHT_TIMELINE = "weixin_timeline";
    protected View container;
    /* access modifiers changed from: private */
    public boolean mHasShowGuidePlay = false;
    protected VideoDetailInfoModel mInfo;
    /* access modifiers changed from: private */
    public CoolPraiseView mLikeLayout;
    /* access modifiers changed from: private */
    public LikeStateListener mLikeStateListener;
    private ShareLayoutClickListener mShareLayoutClickListener;
    private ShareListener mShareListener;
    protected ImageView mShareToWXFriendCircleImg;
    protected ImageView mShareToWXFriendImg;
    private LinearLayout mUnLikeLayout;
    /* access modifiers changed from: private */
    public ImageView mUnlikeIcon;
    /* access modifiers changed from: private */
    public TextView mUnlikeText;
    protected String videoInfo;

    public interface LikeStateListener {
        void processLike(Map<String, Object> map);

        void processReport(String str);
    }

    public interface ShareLayoutClickListener {
        void onClick(View view2, int i2, boolean z);
    }

    public interface ShareListener {
        void share(String str, ShareSource shareSource);
    }

    /* access modifiers changed from: package-private */
    public abstract void initInternal();

    /* access modifiers changed from: package-private */
    public abstract void setShareIconVisibility(int i2);

    /* access modifiers changed from: package-private */
    public abstract void setupLayoutParams();

    public abstract void updateNightMode();

    public static VideoDetailShareLayout build(ViewStub viewStub) {
        return new B(viewStub.inflate());
    }

    public VideoDetailShareLayout(View container2) {
        this.container = container2;
        init();
        initInternal();
    }

    private void init() {
        this.mUnlikeIcon = (ImageView) this.container.findViewById(R.id.video_detail_unlike_icon);
        this.mUnlikeText = (TextView) this.container.findViewById(R.id.video_detail_unlike_text);
        CoolPraiseView coolPraiseView = (CoolPraiseView) this.container.findViewById(R.id.custom_praise);
        this.mLikeLayout = coolPraiseView;
        coolPraiseView.setPraiseStateIconRes(R.drawable.video_detail_like_up_normal, R.drawable.video_detail_like_up_clicked);
        this.mLikeLayout.setPraiseStateTextRes(R.color.video_detail_bdcomment_like, R.color.video_detail_bdcomment_like_click);
        this.mUnLikeLayout = (LinearLayout) this.container.findViewById(R.id.video_detail_unlike);
        this.mShareToWXFriendImg = (ImageView) this.container.findViewById(R.id.share_to_weixin_pengyou);
        this.mShareToWXFriendCircleImg = (ImageView) this.container.findViewById(R.id.share_to_weixin_pengyouquan);
    }

    public void update(final VideoDetailInfoModel info, final String videoInfo2) {
        this.videoInfo = videoInfo2;
        this.mInfo = info;
        if (info.mIsShowShareSwitch == 1) {
            this.mShareToWXFriendImg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    VideoDetailShareLayout.this.showShare("weixin_friend", videoInfo2);
                }
            });
            this.mShareToWXFriendImg.setImageDrawable(ContextCompat.getDrawable(this.container.getContext(), R.drawable.video_feed_share_wx_friend));
            this.mShareToWXFriendCircleImg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    VideoDetailShareLayout.this.showShare("weixin_timeline", videoInfo2);
                }
            });
            this.mShareToWXFriendCircleImg.setImageDrawable(ContextCompat.getDrawable(this.container.getContext(), R.drawable.video_feed_share_wx_pengyouquan));
            setShareIconVisibility(0);
            if (!info.mIsUploadShareShow) {
                info.mIsUploadShareShow = true;
                VideoDetailUbcExtUtils.uploadIconClickUBC(SystemScreenshotShareUBC.SCREENSHOT_TYPE_FLOAT_SHARE_SHOW, videoInfo2, (String[]) null, (String) null, "videoChannel", "");
            }
        } else {
            setShareIconVisibility(8);
        }
        CoolPraiseView coolPraiseView = this.mLikeLayout;
        if (!(coolPraiseView == null || this.mUnlikeText == null)) {
            coolPraiseView.disablePraiseAnimation(info.isUnlike);
            CoolPraiseView.OnClickPraiseListener likeListener = new CoolPraiseView.OnClickPraiseListener() {
                public void onClick(boolean isPraised, int praiseCount) {
                    String str;
                    if (info.isUnlike) {
                        UniversalToast.makeText(VideoDetailShareLayout.this.container.getContext(), com.baidu.searchbox.feed.core.R.string.feed_disliked_tip).showToast();
                        return;
                    }
                    VideoDetailShareLayout videoDetailShareLayout = VideoDetailShareLayout.this;
                    videoDetailShareLayout.processLike(videoDetailShareLayout.mLikeLayout, info);
                    if (VideoDetailShareLayout.this.mLikeStateListener != null) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("nid", info.mNid);
                        if (VideoDetailShareLayout.this.mLikeLayout.getIsPraisedState()) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        params.put("type", str);
                        params.put("ext", info.mLikeExt);
                        VideoDetailShareLayout.this.mLikeStateListener.processLike(params);
                    }
                    IVideoEventBusWrapper.Impl.get().post(new VideoContinuePlayEvent(false));
                    VideoDetailUbcExtUtils.uploadIconClickUBC(FeedStatisticConstants.UBC_TYPE_VALUE_LIKE, videoInfo2, new String[]{"0"}, VideoDetailShareLayout.this.getUBCPage(info));
                    VideoDetailShareLayout videoDetailShareLayout2 = VideoDetailShareLayout.this;
                    videoDetailShareLayout2.fireShareLayoutClickListener(videoDetailShareLayout2.mLikeLayout, 0, isPraised);
                    if (VideoDetailShareLayout.this.mHasShowGuidePlay) {
                        VideoDetailShareLayout.this.mLikeLayout.cancelGuidePlay();
                        ControlShowManager.getInstance().setCycleTimeNoShow();
                    }
                }
            };
            this.mLikeLayout.setPraise(info.isLike);
            sendLikeDataToDataChannel(this.container.getContext(), isStar(info) ? info.mFeedId : info.mNid, String.valueOf(info.mLikeNum), info.isLike);
            this.mLikeLayout.setPraiseCount(info.mLikeNum);
            this.mLikeLayout.setOnClickPraiseListener(likeListener);
            if (info.isUnlike) {
                this.mLikeLayout.setPraiseable(false);
            }
            this.mLikeLayout.setUBC(PraiseUBCHelper.SOURCE_FEEDVIDEO_LP).setPraiseSource(PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO);
            this.mLikeLayout.setPraiseId(info.mNid);
            updateDisLikeStatus(info, videoInfo2);
            syncLikeNum(info);
            unregisterEvent();
            IVideoEventBusWrapper.Impl.get().lazyRegisterOnMainThread((Object) this, LandScapeVideoLikeEvent.class, new Action1<LandScapeVideoLikeEvent>() {
                public void call(LandScapeVideoLikeEvent landScapeVideoLikeEvent) {
                    VideoDetailInfoModel videoDetailInfoModel = info;
                    if (videoDetailInfoModel != null && VideoLikeUtils.isCurrentVideoLike(videoDetailInfoModel.mNid, landScapeVideoLikeEvent)) {
                        VideoDetailShareLayout videoDetailShareLayout = VideoDetailShareLayout.this;
                        videoDetailShareLayout.processLikeData(videoDetailShareLayout.mLikeLayout, info, landScapeVideoLikeEvent.isPraised);
                    }
                }
            });
        }
        updateNightMode();
    }

    public void updateLikeUi(VideoDetailInfoModel info) {
        if (info != null) {
            this.mLikeLayout.setPraise(info.isLike);
            this.mLikeLayout.setPraiseCount(info.mLikeNum);
        }
    }

    public void showPraiseGuidePlay() {
        if (this.mLikeLayout.isShown() && canShowPraiseGuide()) {
            this.mHasShowGuidePlay = this.mLikeLayout.guidePlay((ViewGroup) null, true, false, false);
        }
    }

    public void cancelPraiseGuidePlay() {
        this.mLikeLayout.cancelGuidePlay();
    }

    public void resetPraiseGuidePlayStatus() {
        this.mHasShowGuidePlay = false;
        cancelPraiseGuidePlay();
    }

    public void unregisterEvent() {
        IVideoEventBusWrapper.Impl.get().unregister(this);
    }

    private void updateDisLikeStatus(final VideoDetailInfoModel info, final String videoInfo2) {
        int i2;
        if (info != null) {
            if (info.isShowReport()) {
                View.OnClickListener reportListener = new View.OnClickListener() {
                    public void onClick(View v) {
                        if (VideoDetailShareLayout.this.mLikeStateListener != null) {
                            VideoDetailShareLayout.this.mLikeStateListener.processReport("video_landing");
                        }
                        VideoDetailUbcExtUtils.uploadIconClickUBC(FeedStatisticConstants.UBC_FEED_VIDEO_IMMERSIVE_MORE_REPORT_VALUE, videoInfo2, (String[]) null, VideoDetailShareLayout.this.getUBCPage(info));
                    }
                };
                showIcon(this.mUnlikeIcon, R.drawable.video_bd_comment_video_report_normal);
                adjustUnLikeTextMargin(5);
                updateLikeStatus(this.mUnlikeText, 0, this.container.getResources().getString(R.string.video_comment_report), false);
                this.mUnLikeLayout.setOnClickListener(reportListener);
                return;
            }
            View.OnClickListener unLikeListener = new View.OnClickListener() {
                public void onClick(View v) {
                    if (info.isUnlike) {
                        UniversalToast.makeText(VideoDetailShareLayout.this.container.getContext(), com.baidu.searchbox.feed.core.R.string.feed_disliked_tip).showToast();
                    } else if (info.isLike) {
                        UniversalToast.makeText(VideoDetailShareLayout.this.container.getContext(), com.baidu.searchbox.feed.core.R.string.feed_liked_tip).showToast();
                    } else {
                        UniversalToast.makeText(VideoDetailShareLayout.this.container.getContext(), com.baidu.searchbox.feed.core.R.string.feed_disliked_success).showToast();
                        VideoDetailShareLayout videoDetailShareLayout = VideoDetailShareLayout.this;
                        videoDetailShareLayout.processDisLike(videoDetailShareLayout.mUnlikeIcon, VideoDetailShareLayout.this.mUnlikeText, info);
                        if (VideoDetailShareLayout.this.mLikeStateListener != null) {
                            Map<String, Object> params = new HashMap<>();
                            params.put("nid", info.mNid);
                            params.put("type", "1");
                            params.put("ext", info.mUnlikeExt);
                            VideoDetailShareLayout.this.mLikeStateListener.processLike(params);
                        }
                        if (VideoDetailShareLayout.this.mUnlikeIcon != null) {
                            VideoDetailShareLayout videoDetailShareLayout2 = VideoDetailShareLayout.this;
                            videoDetailShareLayout2.applyAnimation(videoDetailShareLayout2.mUnlikeIcon, (float) (VideoDetailShareLayout.this.mUnlikeIcon.getMeasuredHeight() / 2));
                        }
                        VideoDetailUbcExtUtils.uploadIconClickUBC(FeedStatisticConstants.UBC_FEED_VIDEO_IMMERSIVE_MORE_DOWNVOTE_VALUE, videoInfo2, new String[]{"0"}, VideoDetailShareLayout.this.getUBCPage(info));
                    }
                }
            };
            ImageView imageView = this.mUnlikeIcon;
            if (info.isUnlike) {
                i2 = R.drawable.video_detail_vote_down_clicked;
            } else {
                i2 = R.drawable.video_detail_vote_down_normal;
            }
            showIcon(imageView, i2);
            adjustUnLikeTextMargin(4);
            updateLikeStatus(this.mUnlikeText, info.mUnlikeNum, this.container.getResources().getString(R.string.video_detail_unlike_default), info.isUnlike);
            this.mUnLikeLayout.setOnClickListener(unLikeListener);
        }
    }

    /* access modifiers changed from: private */
    public String getUBCPage(VideoDetailInfoModel info) {
        if (info == null || 2 != info.type) {
            return null;
        }
        return VideoDetailModel.DETAIL_PAGE_STAR;
    }

    /* access modifiers changed from: private */
    public void processLike(CoolPraiseView praiseView, VideoDetailInfoModel info) {
        if (info != null && praiseView != null) {
            processLikeData(praiseView, info, praiseView.getIsPraisedState());
        }
    }

    /* access modifiers changed from: private */
    public void processDisLike(ImageView icon, TextView text, VideoDetailInfoModel info) {
        if (info != null) {
            info.isUnlike = true;
            if (!(icon == null || text == null)) {
                Drawable drawable = ContextCompat.getDrawable(text.getContext(), R.drawable.video_detail_vote_down_clicked);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                icon.setImageDrawable(drawable);
                info.mUnlikeNum++;
                text.setText(FeedUtil.convertNumber(text.getContext(), (long) info.mUnlikeNum));
                text.setTextColor(ResourceUtils.getColorStateList(text.getContext(), R.color.video_detail_bdcomment_like_click));
            }
            processDisLikeDate(icon, text, info);
        }
    }

    /* access modifiers changed from: private */
    public void processLikeData(CoolPraiseView praiseView, VideoDetailInfoModel info, boolean isPraised) {
        if (info != null && praiseView != null) {
            info.isLike = isPraised;
            praiseView.setPraise(isPraised);
            if (isPraised) {
                info.mLikeNum++;
            } else {
                info.mLikeNum--;
            }
            praiseView.setPraiseCount(info.mLikeNum);
            BdVideoLog.d(TAG, "processLikeData isPraised : " + isPraised + ", mLikeNum : " + info.mLikeNum);
            syncLikeNum(info);
        }
    }

    private void syncLikeNum(VideoDetailInfoModel info) {
        if (info != null && this.mLikeLayout != null) {
            LinkageData linkageData = new LinkageData();
            linkageData.nid = isStar(info) ? info.mFeedId : info.mNid;
            linkageData.status = info.isLike ? "1" : "0";
            linkageData.count = String.valueOf(info.mLikeNum);
            linkageData.type = "pro";
            linkageData.isUsed = false;
            FeedLinkageManager.getInstance(isStar(info) ? "feed" : "video").addLinkage(linkageData);
            IVideoEventBusWrapper.Impl.get().post(linkageData);
            sendLikeDataToDataChannel(this.mLikeLayout.getContext(), isStar(info) ? info.mFeedId : info.mNid, linkageData.count, info.isLike);
        }
    }

    private boolean isStar(VideoDetailInfoModel info) {
        return info != null && info.type == 2;
    }

    private void showIcon(ImageView icon, int drawableId) {
        if (drawableId != 0) {
            Drawable drawable = ContextCompat.getDrawable(icon.getContext(), drawableId);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            icon.setImageDrawable(drawable);
        }
    }

    private void adjustUnLikeTextMargin(int leftMargin) {
        if (this.mUnlikeText.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mUnlikeText.getLayoutParams();
            lp.leftMargin = IVideoScreenInfoUtils.Impl.get().dp2px((float) leftMargin);
            this.mUnlikeText.setLayoutParams(lp);
        }
    }

    private void updateLikeStatus(TextView text, int number, String defaultStr, boolean isClick) {
        text.setText(number > 0 ? FeedUtil.convertNumber(text.getContext(), (long) number) : defaultStr);
        if (isClick) {
            text.setTextColor(ResourceUtils.getColorStateList(text.getContext(), R.color.video_detail_bdcomment_like_click));
        } else {
            text.setTextColor(ResourceUtils.getColorStateList(text.getContext(), R.color.video_detail_bdcomment_like));
        }
    }

    private void processDisLikeDate(ImageView icon, TextView text, VideoDetailInfoModel info) {
        if (info != null) {
            LinkageData linkageData = new LinkageData();
            linkageData.nid = isStar(info) ? info.mFeedId : info.mNid;
            linkageData.status = "1";
            linkageData.count = String.valueOf(info.mUnlikeNum);
            linkageData.type = "dislike";
            linkageData.isUsed = true;
            FeedLinkageManager.getInstance(isStar(info) ? "feed" : "video").addLinkage(linkageData);
        }
    }

    /* access modifiers changed from: private */
    public void applyAnimation(View whichView, float pivotY) {
        if (whichView != null) {
            ScaleAnimation anim = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 0.0f, pivotY);
            anim.setDuration(200);
            anim.setRepeatMode(2);
            anim.setRepeatCount(1);
            anim.setFillAfter(false);
            whichView.startAnimation(anim);
        }
    }

    /* access modifiers changed from: protected */
    public void showShare(String type, String videoInfo2) {
        String source;
        if (type.equals("weixin_friend")) {
            source = "1";
        } else {
            type.equals("weixin_timeline");
            source = "0";
        }
        VideoDetailUbcExtUtils.uploadIconClickUBC("share_click", videoInfo2, (String[]) null, (String) null, (String) null, source);
        ShareListener shareListener = this.mShareListener;
        if (shareListener != null && this.mInfo != null) {
            shareListener.share(type, ShareSource.RIGHT_BUTTON);
        }
    }

    private static void sendLikeDataToDataChannel(Context context, String feedNid, String likeCount, boolean isLike) {
        String invalidContextId = IVideoDependConstManager.Impl.get().getStringConst("7");
        if (!TextUtils.isEmpty(feedNid) && !TextUtils.equals(feedNid, invalidContextId) && context != null) {
            try {
                JSONObject dataChannelObject = new JSONObject();
                JSONArray contentArray = new JSONArray();
                JSONObject contentObj = new JSONObject();
                contentObj.put("nid", feedNid);
                contentObj.put("type", "pro");
                contentObj.put("count", likeCount);
                contentObj.put("status", isLike ? "1" : "0");
                contentArray.put(contentObj);
                dataChannelObject.put(feedNid, contentArray);
                IVideoSender.Impl.get().sendBroadcastLocal(context, "com.baidu.channel.feed.assistmessage", dataChannelObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    static class A extends VideoDetailShareLayout {
        private RelativeLayout mShareContainer;
        private TextView mShareText;

        public A(View container) {
            super(container);
        }

        /* access modifiers changed from: package-private */
        public void initInternal() {
            this.mShareContainer = (RelativeLayout) this.container.findViewById(R.id.feed_video_detail_top_share_container);
            TextView textView = (TextView) this.container.findViewById(R.id.feed_video_na_share_tx);
            this.mShareText = textView;
            textView.setTextColor(this.container.getContext().getResources().getColor(R.color.video_detail_like_color));
        }

        /* access modifiers changed from: package-private */
        public void setupLayoutParams() {
            if (this.container != null) {
                this.container.setPadding(0, (int) this.container.getResources().getDimension(R.dimen.video_detail_share_layout_padding_top_a), 0, (int) this.container.getResources().getDimension(R.dimen.video_detail_share_layout_padding_btm_a));
            }
        }

        public void updateNightMode() {
            TextView textView = this.mShareText;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.video_detail_like_color));
        }

        /* access modifiers changed from: package-private */
        public void setShareIconVisibility(int visible) {
            this.mShareContainer.setVisibility(visible);
        }
    }

    static class B extends VideoDetailShareLayout {
        TextView mTimeline;
        TextView mWeixin;
        LinearLayout videoDetailPraise;
        LinearLayout videoDetailUnlike;
        LinearLayout videoShareFriend;
        LinearLayout videoShareTimeline;

        public B(View container) {
            super(container);
        }

        /* access modifiers changed from: package-private */
        public void setShareIconVisibility(int visible) {
            this.videoShareFriend.setVisibility(visible);
            this.videoShareTimeline.setVisibility(visible);
        }

        /* access modifiers changed from: package-private */
        public void initInternal() {
            this.videoDetailPraise = (LinearLayout) this.container.findViewById(R.id.video_detail_praise);
            this.videoDetailUnlike = (LinearLayout) this.container.findViewById(R.id.video_detail_unlike);
            this.videoShareFriend = (LinearLayout) this.container.findViewById(R.id.video_detail_share_friend);
            this.videoShareTimeline = (LinearLayout) this.container.findViewById(R.id.video_detail_share_timeline);
            this.mTimeline = (TextView) this.container.findViewById(R.id.feed_video_na_share_timeline);
            this.mWeixin = (TextView) this.container.findViewById(R.id.feed_video_na_share_weixin);
            this.videoShareFriend.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    B b2 = B.this;
                    b2.showShare("weixin_friend", b2.videoInfo);
                }
            });
            this.videoShareTimeline.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    B b2 = B.this;
                    b2.showShare("weixin_timeline", b2.videoInfo);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void setupLayoutParams() {
            if (this.container != null) {
                int left = (int) this.container.getResources().getDimension(R.dimen.video_detail_share_layout_padding_b);
                int top = (int) this.container.getResources().getDimension(R.dimen.video_detail_share_layout_padding_top_b);
                this.container.setPadding(left, top, left, (int) this.container.getResources().getDimension(R.dimen.video_detail_share_layout_padding_btm_b));
            }
        }

        public void updateNightMode() {
            TextView textView = this.mWeixin;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.video_detail_like_color));
            TextView textView2 = this.mTimeline;
            textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.video_detail_like_color));
            VideoUiUtilsKt.setDarkBackgroundResource(this.videoDetailPraise, R.drawable.video_detail_top_info_share_item_bg);
            VideoUiUtilsKt.setDarkBackgroundResource(this.videoDetailUnlike, R.drawable.video_detail_top_info_share_item_bg);
            VideoUiUtilsKt.setDarkBackgroundResource(this.videoShareFriend, R.drawable.video_detail_top_info_share_item_bg);
            VideoUiUtilsKt.setDarkBackgroundResource(this.videoShareTimeline, R.drawable.video_detail_top_info_share_item_bg);
            this.mShareToWXFriendImg.setImageDrawable(ContextCompat.getDrawable(this.container.getContext(), R.drawable.video_feed_share_wx_friend));
            this.mShareToWXFriendCircleImg.setImageDrawable(ContextCompat.getDrawable(this.container.getContext(), R.drawable.video_feed_share_wx_pengyouquan));
        }
    }

    public static void setTextColor(Button view2, boolean abTest) {
        if (abTest) {
            view2.setTextColor(ResourceUtils.getColorStateList(view2.getContext(), R.color.video_detail_tag_text_selector_b));
        } else {
            view2.setTextColor(ResourceUtils.getColorStateList(view2.getContext(), R.color.video_detail_tag_text_selector));
        }
    }

    public static void setPadding(View view2, boolean abTest) {
        if (abTest) {
            view2.setPadding(IVideoScreenInfoUtils.Impl.get().dp2px(14.0f), IVideoScreenInfoUtils.Impl.get().dp2px(5.0f), IVideoScreenInfoUtils.Impl.get().dp2px(14.0f), IVideoScreenInfoUtils.Impl.get().dp2px(5.0f));
        } else {
            view2.setPadding(IVideoScreenInfoUtils.Impl.get().dp2px(10.0f), IVideoScreenInfoUtils.Impl.get().dp2px(6.0f), IVideoScreenInfoUtils.Impl.get().dp2px(10.0f), IVideoScreenInfoUtils.Impl.get().dp2px(6.0f));
        }
    }

    public void setShareLayoutClickListener(ShareLayoutClickListener listener) {
        this.mShareLayoutClickListener = listener;
    }

    /* access modifiers changed from: protected */
    public void fireShareLayoutClickListener(View view2, int type, boolean isPraise) {
        ShareLayoutClickListener shareLayoutClickListener = this.mShareLayoutClickListener;
        if (shareLayoutClickListener != null) {
            shareLayoutClickListener.onClick(view2, type, isPraise);
        }
    }

    public void setLikeStateListener(LikeStateListener likeStateListener) {
        this.mLikeStateListener = likeStateListener;
    }

    public void setShareListener(ShareListener shareListener) {
        this.mShareListener = shareListener;
    }

    private int getStatueBarHeight(Context context) {
        int resourceId;
        if (!(context instanceof Activity) || (((Activity) context).getWindow().getAttributes().flags & 1024) != 0 || (resourceId = context.getApplicationContext().getResources().getIdentifier("status_bar_height", ResUtils.DIMEN, "android")) <= 0) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDimensionPixelSize(resourceId);
    }

    private boolean canShowPraiseGuide() {
        int stateHeight = getStatueBarHeight(this.mLikeLayout.getContext());
        int[] location = new int[2];
        this.mLikeLayout.getLocationOnScreen(location);
        if (((Math.min(IVideoScreenInfoUtils.Impl.get().getDisplayWidth(), IVideoScreenInfoUtils.Impl.get().getDisplayHeight()) * 9) / 16) + 2 + stateHeight > location[1]) {
            return false;
        }
        return true;
    }
}
