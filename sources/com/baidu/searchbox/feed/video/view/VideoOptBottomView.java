package com.baidu.searchbox.feed.video.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.config.FeedUrlConfig;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.ioc.IFeedShare;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataTabVideo;
import com.baidu.searchbox.feed.model.FeedItemImmersiveVideoModel;
import com.baidu.searchbox.feed.model.FeedProtocolEntity;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.statistic.FeedException;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.feed.statistic.ReliabilityStats;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.feed.util.FeedSessionManager;
import com.baidu.searchbox.feed.util.FeedShareWrapper;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.video.manager.VideoDataSimplifyProcessor;
import com.baidu.searchbox.feed.video.statistic.VideoStatisticUtil;
import com.baidu.searchbox.feed.video.view.IVideoOptBottomView;
import com.baidu.searchbox.feed.video.view.VideoAuthorComponentView;
import com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo;
import com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownPop;
import com.baidu.searchbox.feed.widget.dropdownpopup.view.DropdownPopupView;
import com.baidu.searchbox.follow.FollowConstant;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.lightbrowser.model.SubTagItem;
import com.baidu.searchbox.player.helper.VideoDownloadHelper;
import com.baidu.searchbox.privacy.FeedIdentityManager;
import com.baidu.searchbox.smartmenu.utils.ShareTypeKt;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.invoker.BdVideoNewParser;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoOptBottomView extends FrameLayout implements View.OnClickListener, IVideoOptBottomView {
    private static final int HIDE_AUTHOR_INFO_DURATION = 100;
    public static final int MODE_NEED_HIDE_PRAISE = 1;
    public static final int MODE_NORAML_PRAISE = 0;
    public static final int MODE_NOT_CALCULATE = -1;
    private static final int POP_DISLIKE_DELAY_DURATION = 500;
    private static final String SHARE_META_BAR = "light_feedvideo_bar";
    private static final int SHOW_SHARE_DELAY = 1000;
    private static final int SHOW_SHARE_DURATION = 250;
    private static final String TAG = "VideoOptBottomView";
    private static final String TYPE_COMMENT = "comment";
    private static final String TYPE_SHARE = "share";
    private static final String UBC_FEED_COMMENT_CLICK_ID = "299";
    private static final String UBC_FEED_ICON_CLICK_ID = "464";
    private static final String UBC_FEED_SHARE_CLICK_ID = "300";
    private static final String UBC_SHARE_META_FEED = "light_feedvideo";
    private static final String UBC_SHARE_META_FEED_OUT = "light_feedvideo_direct";
    private static final String UBC_VALUE_FROM_KEY = "from";
    private static final String UBC_VALUE_PAGE_KEY = "page";
    private static final String UBC_VALUE_SOURCE_KEY = "source";
    private static final String UBC_VALUE_TYPE_KEY = "type";
    private static final String UBC_VIDEO_TAB_ID = "tab_id";
    private static int sIconLayout = -1;
    private Animation.AnimationListener mAnimationListener;
    /* access modifiers changed from: private */
    public VideoAuthorComponentView mAuthorView;
    private List<FeedItemDataTabVideo.BarEntity> mBarList;
    private View mBottomRootView;
    /* access modifiers changed from: private */
    public IOptBottomClickItemCallBack mClickItemCallBack;
    private TextView mCommentTv;
    private Context mContext;
    /* access modifiers changed from: private */
    public FeedBar mFeedBar;
    /* access modifiers changed from: private */
    public FeedBaseModel mFeedBaseModel;
    /* access modifiers changed from: private */
    public boolean mHasShowGuidePlay;
    /* access modifiers changed from: private */
    public ValueAnimator mHideAuthorAnimator;
    private CoolPraiseView.OnClickPraiseListener mLikeClickListener;
    /* access modifiers changed from: private */
    public FeedDropdownPop mMenu;
    /* access modifiers changed from: private */
    public WeakReference<FeedDropdownPop> mMenuWeakReference;
    /* access modifiers changed from: private */
    public ImageView mMoreImage;
    private int mPosition;
    /* access modifiers changed from: private */
    public CoolPraiseView mPraiseView;
    List<String> mShareChannelList;
    /* access modifiers changed from: private */
    public ImageView mShareIcon;
    /* access modifiers changed from: private */
    public ValueAnimator mShowShareAnimator;
    /* access modifiers changed from: private */
    public IVideoOptBottomView.IStatus mStatus;
    private String mTabId;
    public int mVideoDownLoadStatus;

    /* access modifiers changed from: private */
    public FeedItemDataTabVideo.BarEntity getPraiseEntity() {
        for (int i2 = 0; i2 < this.mBarList.size(); i2++) {
            FeedItemDataTabVideo.BarEntity barEntity = this.mBarList.get(i2);
            if (TextUtils.equals("like", barEntity.mItem)) {
                return barEntity;
            }
        }
        return null;
    }

    public VideoOptBottomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoOptBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHasShowGuidePlay = false;
        this.mLikeClickListener = new CoolPraiseView.OnClickPraiseListener() {
            public void onClick(boolean isPraised, int praiseCount) {
                if (VideoOptBottomView.this.mFeedBar == null || VideoOptBottomView.this.mFeedBar.degrade == null || !VideoOptBottomView.this.mFeedBar.degrade.status) {
                    VideoOptBottomView videoOptBottomView = VideoOptBottomView.this;
                    videoOptBottomView.processLike(videoOptBottomView.mPraiseView);
                    if (VideoOptBottomView.this.mHasShowGuidePlay && VideoOptBottomView.this.mFeedBar != null && VideoOptBottomView.this.mFeedBar.like != null && VideoOptBottomView.this.mFeedBar.like.status) {
                        VideoOptBottomView.this.cancelPraiseGuidePlay();
                        ControlShowManager.getInstance().setCycleTimeNoShow();
                    }
                    FeedItemDataTabVideo.BarEntity praiseEntity = VideoOptBottomView.this.getPraiseEntity();
                    if (praiseEntity != null) {
                        VideoOptBottomView videoOptBottomView2 = VideoOptBottomView.this;
                        videoOptBottomView2.uploadIconClickUBC(FeedStatisticConstants.UBC_TYPE_VALUE_LIKE, videoOptBottomView2.getIconIndex(praiseEntity));
                        return;
                    }
                    return;
                }
                UniversalToast.makeText(VideoOptBottomView.this.getContext(), R.string.feed_disliked_tip).showToast();
            }
        };
        this.mContext = context;
        init();
    }

    public void setOptBottomClickItemCallBack(IOptBottomClickItemCallBack clickItemCallBack) {
        this.mClickItemCallBack = clickItemCallBack;
    }

    private void init() {
        this.mBottomRootView = LayoutInflater.from(getContext()).inflate(R.layout.video_opt_bottom_layout, this, true);
        VideoAuthorComponentView videoAuthorComponentView = (VideoAuthorComponentView) findViewById(R.id.author_view);
        this.mAuthorView = videoAuthorComponentView;
        videoAuthorComponentView.setListener(new VideoAuthorComponentView.ItemClickCallback() {
            public void clickItem(String type, int index, Object ext) {
                if (VideoOptBottomView.this.mFeedBaseModel != null && (VideoOptBottomView.this.mFeedBaseModel.data instanceof FeedItemDataTabVideo)) {
                    VideoOptBottomView videoOptBottomView = VideoOptBottomView.this;
                    videoOptBottomView.monitorCmdAvailability(videoOptBottomView.getContext(), VideoOptBottomView.this.mFeedBaseModel.id, ((FeedItemDataTabVideo) VideoOptBottomView.this.mFeedBaseModel.data).mAuthorCmd);
                }
                if (VideoOptBottomView.this.mClickItemCallBack != null) {
                    VideoOptBottomView.this.mClickItemCallBack.onClickAuthorItem(type, ext);
                }
                if ("arrow".equals(type) && (ext instanceof Boolean)) {
                    type = ((Boolean) ext).booleanValue() ? FollowConstant.UBC_TYPE_PACK_UP : "spread";
                }
                VideoOptBottomView.this.uploadIconClickUBC(type, index);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.tab_video_more_image);
        this.mMoreImage = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) this.mBottomRootView.findViewById(R.id.video_comment);
        this.mCommentTv = textView;
        textView.setOnClickListener(this);
        setupTextSizeAndDrawablePadding(this.mCommentTv);
        CoolPraiseView coolPraiseView = (CoolPraiseView) this.mBottomRootView.findViewById(R.id.video_like);
        this.mPraiseView = coolPraiseView;
        coolPraiseView.setOnClickPraiseListener(this.mLikeClickListener);
        this.mPraiseView.setPraiseTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.black));
        this.mPraiseView.setPraiseCntsLeftMargin((int) getResources().getDimension(R.dimen.feed_tab_video_middle_text_drawable_padding_b));
        this.mPraiseView.setPraiseCntsTopMargin(0);
        this.mPraiseView.setPraiseCntsTextSize(0, getResources().getDimension(R.dimen.feed_tab_video_label_view_text_size_b));
        this.mPraiseView.setPraiseStateIconRes(R.drawable.feed_tab_video_vote_up_normal, R.drawable.feed_tab_video_vote_up_clicked);
        ImageView imageView2 = (ImageView) findViewById(R.id.tab_video_share_image);
        this.mShareIcon = imageView2;
        imageView2.setOnClickListener(this);
        setOnClickListener(this);
        int expandTouchArea = this.mContext.getResources().getDimensionPixelSize(R.dimen.feed_template_immersive_video_bottom_expand_touch_size);
        ExpandTouchAreaHelper.expandTouchArea(this, this.mPraiseView, expandTouchArea);
        ExpandTouchAreaHelper.expandTouchArea(this, this.mCommentTv, expandTouchArea);
        ExpandTouchAreaHelper.expandTouchArea(this, this.mMoreImage, expandTouchArea);
        updateUI();
    }

    public void bindStatusChecker(IVideoOptBottomView.IStatus status) {
        this.mStatus = status;
    }

    private void setupTextSizeAndDrawablePadding(TextView tv) {
        if (tv != null) {
            tv.setTextSize(0, getResources().getDimension(R.dimen.feed_tab_video_label_view_text_size_b));
            tv.setCompoundDrawablePadding((int) getResources().getDimension(R.dimen.feed_tab_video_middle_text_drawable_padding_b));
        }
    }

    private void updateUI() {
        updateIconListData();
        showIcon(this.mCommentTv, 1, R.drawable.feed_tab_video_comment_black_icon);
        CoolPraiseView praiseSource = this.mPraiseView.setUBC(PraiseUBCHelper.SOURCE_FEEDVIDEO_LIST).setPraiseSource(PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST_OUT);
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        praiseSource.setPraiseId(feedBaseModel != null ? feedBaseModel.id : "");
    }

    public void update(FeedBaseModel feedModel, boolean isGlobalTTSMode) {
        if (feedModel != null && (feedModel.data instanceof FeedItemDataTabVideo)) {
            this.mTabId = feedModel.runtimeStatus.channelId;
            this.mPosition = feedModel.runtimeStatus.viewPosition;
            FeedItemDataTabVideo item = (FeedItemDataTabVideo) feedModel.data;
            this.mFeedBaseModel = feedModel;
            this.mFeedBar = item.feedBar;
            this.mBarList = item.mBarSortList;
            if (!TextUtils.isEmpty(item.mAuthorIcon)) {
                this.mAuthorView.loadImage(item.mAuthorIcon, feedModel);
            }
            this.mAuthorView.updateView(feedModel);
            FeedBar feedBar = this.mFeedBar;
            boolean z = false;
            if (!(feedBar == null || feedBar.degrade == null || !this.mFeedBar.degrade.status)) {
                this.mPraiseView.setPraiseable(false);
                this.mPraiseView.disablePraiseAnimation(true);
            }
            List<String> list = item.mShareChannelList;
            this.mShareChannelList = list;
            if (list != null && list.size() > 0) {
                this.mShareIcon.setImageDrawable(getContext().getResources().getDrawable(IFeedShare.Impl.get().getMediaTypeResId(this.mShareChannelList.get(0))));
            }
            if (sIconLayout == -1) {
                sIconLayout = this.mAuthorView.getMaxWidth() + getRightMaxWidth(true) > DeviceUtil.ScreenInfo.getDisplayWidth(getContext()) ? 1 : 0;
            }
            if (sIconLayout == 1) {
                this.mPraiseView.setVisibility(8);
                needSwapMorePosition(this.mBarList);
            }
            int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(getContext());
            if (sIconLayout != 1) {
                z = true;
            }
            this.mAuthorView.adjustNameWidth(displayWidth - getRightWidth(z, getCommentCount()));
            updateIconListData();
        }
    }

    private int getRightMaxWidth(boolean needShowPraise) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) this.mCommentTv.getLayoutParams();
        Paint paint1 = this.mCommentTv.getPaint();
        int width1 = params1.leftMargin + params1.rightMargin + (((int) paint1.measureText("1")) * 8);
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) this.mMoreImage.getLayoutParams();
        int width2 = params2.leftMargin + DeviceUtil.ScreenInfo.dp2px(getContext(), 16.0f) + params2.rightMargin;
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) this.mPraiseView.getLayoutParams();
        int width3 = params3.leftMargin + params3.rightMargin + ((int) (paint1.measureText("1") * 9.0f));
        if (needShowPraise) {
            return width1 + width2 + width3;
        }
        return width1 + width2;
    }

    private int getRightWidth(boolean needShowPraise, String commentCount) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) this.mCommentTv.getLayoutParams();
        Paint paint1 = this.mCommentTv.getPaint();
        int width1 = params1.leftMargin + params1.rightMargin + ((int) (paint1.measureText(commentCount + "") + ((float) DeviceUtil.ScreenInfo.dp2px(getContext(), 23.0f))));
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) this.mMoreImage.getLayoutParams();
        int width2 = params2.leftMargin + DeviceUtil.ScreenInfo.dp2px(getContext(), 16.0f) + params2.rightMargin;
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) this.mPraiseView.getLayoutParams();
        int width3 = params3.leftMargin + params3.rightMargin + ((int) (paint1.measureText("1") * 9.0f));
        if (needShowPraise) {
            return width1 + width2 + width3;
        }
        return width1 + width2;
    }

    private String getCommentCount() {
        List<FeedItemDataTabVideo.BarEntity> list = this.mBarList;
        if (list == null) {
            return "";
        }
        for (FeedItemDataTabVideo.BarEntity barEntity : list) {
            if (TextUtils.equals(FeedItemImmersiveVideoModel.BarEntity.ITEM_COMMENT, barEntity.mItem)) {
                if (this.mFeedBar.comment != null) {
                    return FeedUtil.convertNumber(getContext(), (long) this.mFeedBar.comment.count);
                }
                return "";
            }
        }
        return "";
    }

    private void needSwapMorePosition(List<FeedItemDataTabVideo.BarEntity> list) {
        int morePosition = getMorePosition(list);
        if (morePosition >= 3) {
            Collections.swap(list, morePosition, 2);
        }
    }

    public void updateMachineState() {
        this.mAuthorView.updateMachineState();
    }

    public void onFontSizeChanged(int fontSizeInPx) {
    }

    private void updateIconListData() {
        List<FeedItemDataTabVideo.BarEntity> list = this.mBarList;
        if (list != null && list.size() > 0) {
            for (FeedItemDataTabVideo.BarEntity barEntity : this.mBarList) {
                if (TextUtils.equals(FeedItemImmersiveVideoModel.BarEntity.ITEM_COMMENT, barEntity.mItem)) {
                    showIconContent(this.mCommentTv, barEntity.mShow, R.drawable.feed_tab_video_comment_black_icon, barEntity.mTitle, this.mFeedBar.comment != null ? FeedUtil.convertNumber(getContext(), (long) this.mFeedBar.comment.count) : "");
                } else if (TextUtils.equals(FeedItemImmersiveVideoModel.BarEntity.ITEM_LIKE, barEntity.mItem)) {
                    showLike();
                }
            }
            boolean hasComment = false;
            boolean hasPraise = false;
            for (FeedItemDataTabVideo.BarEntity barEntity2 : this.mBarList) {
                if (TextUtils.equals(FeedItemImmersiveVideoModel.BarEntity.ITEM_COMMENT, barEntity2.mItem)) {
                    hasComment = true;
                } else if (TextUtils.equals(FeedItemImmersiveVideoModel.BarEntity.ITEM_LIKE, barEntity2.mItem)) {
                    hasPraise = true;
                }
            }
            int i2 = 0;
            this.mCommentTv.setVisibility(hasComment ? 0 : 8);
            CoolPraiseView coolPraiseView = this.mPraiseView;
            if (!hasPraise) {
                i2 = 8;
            }
            coolPraiseView.setVisibility(i2);
        }
    }

    private void showLike() {
        this.mPraiseView.disablePraiseAnimation(false);
        boolean isLike = this.mFeedBar.like != null && this.mFeedBar.like.status;
        String likeCount = this.mFeedBar.like != null ? String.valueOf(this.mFeedBar.like.count) : "0";
        boolean isDefaultTextColor = this.mFeedBar.like == null || !this.mFeedBar.like.status;
        this.mPraiseView.setPraiseCount(likeCount);
        this.mPraiseView.setPraise(isLike);
        this.mPraiseView.setPraiseStateIconRes(R.drawable.feed_like_not_icon, R.drawable.feed_like_yes_icon);
        if (isDefaultTextColor) {
            this.mPraiseView.setPraiseTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.black));
        } else {
            this.mPraiseView.setPraiseTextColor(ContextCompat.getColor(getContext(), R.color.feed_bar_like_yes_color));
        }
        if (sIconLayout != 1) {
            this.mPraiseView.setVisibility(0);
        }
        CoolPraiseView praiseSource = this.mPraiseView.setUBC(PraiseUBCHelper.SOURCE_FEEDVIDEO_LIST).setPraiseSource(PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST_OUT);
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        praiseSource.setPraiseId(feedBaseModel != null ? feedBaseModel.id : "");
        if (this.mFeedBar.degrade != null && this.mFeedBar.degrade.status) {
            this.mPraiseView.disablePraiseAnimation(true);
        }
    }

    private void showIconContent(TextView textView, int show, int drawableId, String title, String num) {
        showIcon(textView, show, drawableId);
        showContent(textView, show, num, title);
    }

    private void showIcon(TextView textView, int show, int drawableId) {
        if ((show & 1) == 1 && drawableId != 0) {
            Drawable drawable = getResources().getDrawable(drawableId);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.feed_template_immersive_video_bottom_icon_text_padding));
            textView.setVisibility(0);
            textView.setClickable(true);
        }
    }

    private void showContent(TextView textView, int show, String num, String title) {
        textView.setText("");
        textView.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.black));
        if ((show & 2) == 2 && !TextUtils.isEmpty(title)) {
            textView.setText(title);
            textView.setVisibility(0);
        }
        if ((show & 4) == 4 && !TextUtils.isEmpty(num) && !TextUtils.equals("0", num)) {
            textView.setText(num);
            textView.setVisibility(0);
        }
    }

    public void onClick(View view2) {
        if (this.mFeedBar != null) {
            int viewId = view2.getId();
            if (viewId == R.id.video_comment) {
                handleComment();
            } else if (viewId == R.id.tab_video_more_image) {
                ArrayList<FeedDropdownItemInfo> mlist = new ArrayList<>();
                int morePosition = getMorePosition(this.mBarList);
                for (int i2 = morePosition + 1; i2 < this.mBarList.size(); i2++) {
                    FeedDropdownItemInfo info = getFeedDropdownItem(this.mBarList.get(i2));
                    if (info != null) {
                        mlist.add(info);
                    }
                }
                this.mMenu = FeedDropdownPop.makePopup(getContext(), mlist, this.mMoreImage).show();
                this.mMenuWeakReference = new WeakReference<>(this.mMenu);
                uploadIconClickUBC("more", morePosition);
            } else if (viewId == R.id.tab_video_share_image) {
                handleShare(0);
            }
        }
    }

    private void handleShare(int index) {
        List<String> list = this.mShareChannelList;
        if (list != null && index < list.size() && this.mFeedBaseModel != null) {
            String shareChannel = this.mShareChannelList.get(index);
            ubcShareEvent(shareChannel, false);
            if (this.mFeedBar.share != null && !TextUtils.isEmpty(this.mFeedBar.share.url) && this.mFeedBaseModel != null) {
                FeedShareWrapper.callVideoNativeShare(getContext(), this.mFeedBar.share.url, this.mFeedBar.share.iconUrl, this.mFeedBar.share.title, this.mFeedBar.share.content, UBC_SHARE_META_FEED_OUT, shareChannel, this.mFeedBaseModel.id, this.mFeedBaseModel.runtimeStatus.business);
            }
        }
    }

    private void ubcShareEvent(String share, boolean isPV) {
        HashMap<String, String> map = new HashMap<>();
        map.put("from", "video");
        if (TextUtils.equals(share, "weixin_timeline")) {
            map.put("type", isPV ? "pageshow_moments" : ShareTypeKt.MOMENTS);
            FeedUBCWrapper.ubcOnEvent("464", map, (String) null);
        } else if (TextUtils.equals(share, "weixin_friend")) {
            map.put("type", isPV ? "pageshow_WeChat_friend" : "WeChat_friend");
            FeedUBCWrapper.ubcOnEvent("464", map, (String) null);
        }
    }

    private int getMorePosition(List<FeedItemDataTabVideo.BarEntity> list) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).mItem.equals("split")) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo getFeedDropdownItem(final com.baidu.searchbox.feed.model.FeedItemDataTabVideo.BarEntity r11) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = r11.mItem
            int r2 = r1.hashCode()
            r3 = -1
            switch(r2) {
                case -1782210391: goto L_0x0054;
                case -934521548: goto L_0x0049;
                case 3321751: goto L_0x003f;
                case 109400031: goto L_0x0034;
                case 950398559: goto L_0x002a;
                case 1427818632: goto L_0x0020;
                case 1546214390: goto L_0x0016;
                case 1671642405: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x005e
        L_0x000c:
            java.lang.String r2 = "dislike"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 6
            goto L_0x005f
        L_0x0016:
            java.lang.String r2 = "degrade"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 4
            goto L_0x005f
        L_0x0020:
            java.lang.String r2 = "download"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 7
            goto L_0x005f
        L_0x002a:
            java.lang.String r2 = "comment"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 0
            goto L_0x005f
        L_0x0034:
            java.lang.String r2 = "share"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 2
            goto L_0x005f
        L_0x003f:
            java.lang.String r2 = "like"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 3
            goto L_0x005f
        L_0x0049:
            java.lang.String r2 = "report"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 5
            goto L_0x005f
        L_0x0054:
            java.lang.String r2 = "favourite"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x000b
            r2 = 1
            goto L_0x005f
        L_0x005e:
            r2 = r3
        L_0x005f:
            switch(r2) {
                case 0: goto L_0x0148;
                case 1: goto L_0x0127;
                case 2: goto L_0x0113;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00a5;
                case 6: goto L_0x0090;
                case 7: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x015e
        L_0x0064:
            r10.mVideoDownLoadStatus = r3
            com.baidu.searchbox.feed.model.FeedBaseModel r2 = r10.mFeedBaseModel
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r2 = r10.buildSeries(r2)
            boolean r2 = com.baidu.searchbox.player.helper.VideoDownloadHelper.checkVideoDownloadDisabled(r2)
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r9 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            if (r2 == 0) goto L_0x0078
            int r3 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_download_disabled_icon
            r4 = r3
            goto L_0x007b
        L_0x0078:
            int r3 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_download_enabled_icon
            r4 = r3
        L_0x007b:
            java.lang.String r5 = r11.mTitle
            r6 = 1
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$10 r8 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$10
            r8.<init>(r11)
            r3 = r9
            r7 = r2
            r3.<init>((int) r4, (java.lang.String) r5, (int) r6, (boolean) r7, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r8)
            r0 = r9
            if (r2 != 0) goto L_0x015e
            r10.updateDownloadItemIfNeed(r0)
            goto L_0x015e
        L_0x0090:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r2 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            int r4 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_dislike_icon
            java.lang.String r5 = r11.mTitle
            r6 = 1
            com.baidu.searchbox.feed.model.FeedBaseModel r7 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$9 r8 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$9
            r8.<init>(r11)
            r3 = r2
            r3.<init>((int) r4, (java.lang.String) r5, (int) r6, (com.baidu.searchbox.feed.model.FeedBaseModel) r7, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r8)
            r0 = r2
            goto L_0x015e
        L_0x00a5:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r8 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            int r3 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_report_icon
            java.lang.String r4 = r11.mTitle
            r5 = 1
            com.baidu.searchbox.feed.model.FeedBaseModel r6 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$8 r7 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$8
            r7.<init>(r11)
            r2 = r8
            r2.<init>((int) r3, (java.lang.String) r4, (int) r5, (com.baidu.searchbox.feed.model.FeedBaseModel) r6, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r7)
            r0 = r8
            goto L_0x015e
        L_0x00ba:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r8 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            com.baidu.searchbox.feed.model.FeedBar r2 = r10.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r2 = r2.degrade
            boolean r2 = r2.status
            if (r2 == 0) goto L_0x00c8
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_vote_down_clicked
            r3 = r2
            goto L_0x00cb
        L_0x00c8:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_vote_down_normal
            r3 = r2
        L_0x00cb:
            java.lang.String r4 = r10.getShowDesc(r11)
            r5 = 1
            com.baidu.searchbox.feed.model.FeedBaseModel r6 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$7 r7 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$7
            r7.<init>(r11)
            r2 = r8
            r2.<init>((int) r3, (java.lang.String) r4, (int) r5, (com.baidu.searchbox.feed.model.FeedBaseModel) r6, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r7)
            r0 = r8
            com.baidu.searchbox.feed.model.FeedBar r2 = r10.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r2 = r2.degrade
            boolean r2 = r2.status
            r0.setClicked(r2)
            goto L_0x015e
        L_0x00e7:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r2 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            com.baidu.searchbox.feed.model.FeedBar r3 = r10.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r3 = r3.like
            boolean r3 = r3.status
            if (r3 == 0) goto L_0x00f5
            int r3 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_vote_up_clicked
            r4 = r3
            goto L_0x00f8
        L_0x00f5:
            int r3 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_vote_up_normal
            r4 = r3
        L_0x00f8:
            java.lang.String r5 = r10.getShowDesc(r11)
            r6 = 0
            com.baidu.searchbox.feed.model.FeedBaseModel r7 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$6 r8 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$6
            r8.<init>(r11)
            r3 = r2
            r3.<init>((int) r4, (java.lang.String) r5, (int) r6, (com.baidu.searchbox.feed.model.FeedBaseModel) r7, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r8)
            r0 = r2
            com.baidu.searchbox.feed.model.FeedBar r2 = r10.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r2 = r2.like
            boolean r2 = r2.status
            r0.setClicked(r2)
            goto L_0x015e
        L_0x0113:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r2 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            int r4 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_share_arrow_icon
            java.lang.String r5 = r11.mTitle
            r6 = 1
            com.baidu.searchbox.feed.model.FeedBaseModel r7 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$5 r8 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$5
            r8.<init>(r11)
            r3 = r2
            r3.<init>((int) r4, (java.lang.String) r5, (int) r6, (com.baidu.searchbox.feed.model.FeedBaseModel) r7, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r8)
            r0 = r2
            goto L_0x015e
        L_0x0127:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r8 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            com.baidu.searchbox.feed.model.FeedBar r2 = r10.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Favor r2 = r2.favor
            boolean r2 = r2.isFavored
            if (r2 == 0) goto L_0x0135
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_favor_clicked
            r3 = r2
            goto L_0x0138
        L_0x0135:
            int r2 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_favor_normal
            r3 = r2
        L_0x0138:
            java.lang.String r4 = r11.mTitle
            r5 = 1
            com.baidu.searchbox.feed.model.FeedBaseModel r6 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$4 r7 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$4
            r7.<init>(r11)
            r2 = r8
            r2.<init>((int) r3, (java.lang.String) r4, (int) r5, (com.baidu.searchbox.feed.model.FeedBaseModel) r6, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r7)
            r0 = r8
            goto L_0x015e
        L_0x0148:
            com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo r8 = new com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo
            int r3 = com.baidu.searchbox.feed.core.R.drawable.feed_tab_video_comment_black_icon
            java.lang.String r4 = r10.getShowDesc(r11)
            r5 = 1
            com.baidu.searchbox.feed.model.FeedBaseModel r6 = r10.mFeedBaseModel
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$3 r7 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$3
            r7.<init>(r11)
            r2 = r8
            r2.<init>((int) r3, (java.lang.String) r4, (int) r5, (com.baidu.searchbox.feed.model.FeedBaseModel) r6, (com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo.ItemClickCallback) r7)
            r0 = r8
        L_0x015e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.video.view.VideoOptBottomView.getFeedDropdownItem(com.baidu.searchbox.feed.model.FeedItemDataTabVideo$BarEntity):com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo");
    }

    private BdVideoSeries buildSeries(FeedBaseModel feedBaseModel) {
        String ext;
        String page;
        if (feedBaseModel == null || !(feedBaseModel.data instanceof FeedItemDataTabVideo)) {
            return null;
        }
        FeedItemDataTabVideo item = (FeedItemDataTabVideo) feedBaseModel.data;
        String title = item.title;
        String videoUrl = item.mVideoUrl;
        String vid = item.mVideoInfo != null ? item.mVideoInfo.mVid : "";
        int duration = item.mVideoInfo != null ? item.mVideoInfo.mDuration : 0;
        if (item.mVideoInfo != null) {
            ext = item.mVideoInfo.mExt;
        } else {
            ext = "";
        }
        String webUrl = (item.mVideoInfo == null || TextUtils.isEmpty(item.mVideoInfo.mPageUrl)) ? videoUrl : item.mVideoInfo.mPageUrl;
        if (item.mVideoInfo != null) {
            page = item.mVideoInfo.mPage;
        } else {
            page = "";
        }
        HashMap<Integer, String> videoInfo = new HashMap<>();
        videoInfo.put(0, videoUrl);
        videoInfo.put(1, title);
        videoInfo.put(108, ext);
        videoInfo.put(5, webUrl);
        videoInfo.put(112, duration + "");
        videoInfo.put(113, vid);
        videoInfo.put(124, page);
        return BdVideoNewParser.parseToVideoSeriesSafely(videoInfo);
    }

    private void updateDownloadItemIfNeed(final FeedDropdownItemInfo itemInfo) {
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        if (feedBaseModel != null && !TextUtils.isEmpty(feedBaseModel.id)) {
            VideoDownloadHelper.queryDownloadStatusFromDb(this.mFeedBaseModel.id.replaceAll("sv_", ""), new VideoDownloadHelper.IQueryDownloadStatusListener() {
                public void onQueryResult(int downloadStatus) {
                    if (downloadStatus == 200) {
                        itemInfo.updateItemInfo(R.drawable.feed_tab_video_download_already_icon, VideoOptBottomView.this.getResources().getString(R.string.bd_video_download_already), false);
                        if (VideoOptBottomView.this.mMenuWeakReference.get() != null) {
                            ((FeedDropdownPop) VideoOptBottomView.this.mMenuWeakReference.get()).notifyDataChange();
                        }
                    }
                    VideoOptBottomView.this.mVideoDownLoadStatus = downloadStatus;
                }
            });
        }
    }

    private String getShowDesc(FeedItemDataTabVideo.BarEntity barEntity) {
        int num;
        StringBuilder descBuilder = new StringBuilder();
        String type = barEntity.mItem;
        if (!type.equals("like") && !type.equals("degrade")) {
            if ((barEntity.mShow & 2) == 2) {
                descBuilder.append(barEntity.mTitle);
            }
            if (type.equals("comment") && (barEntity.mShow & 4) == 4 && (num = this.mFeedBar.comment.count) != 0) {
                descBuilder.append(getResources().getString(R.string.feed_video_tab_popup_space, new Object[]{FeedUtil.convertNumber(getContext(), (long) num)}));
            }
        } else if (type.equals("like")) {
            descBuilder.append(String.valueOf(this.mFeedBar.like.count));
        } else if (type.equals("degrade") != 0) {
            int num2 = this.mFeedBar.degrade.count;
            if (num2 != 0) {
                descBuilder.append(getResources().getString(R.string.feed_video_tab_popup_space, new Object[]{FeedUtil.convertNumber(getContext(), (long) num2)}));
            } else {
                descBuilder.append(barEntity.mTitle);
            }
        }
        return descBuilder.toString();
    }

    public void dismissMenu() {
        FeedDropdownPop feedDropdownPop = this.mMenu;
        if (feedDropdownPop != null && feedDropdownPop.isShowing()) {
            this.mMenu.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performClick(com.baidu.searchbox.feed.model.FeedItemDataTabVideo.BarEntity r18, android.view.View r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            java.lang.String r4 = r2.mItem
            int r0 = r4.hashCode()
            r5 = 0
            r6 = 1
            java.lang.String r7 = "share"
            java.lang.String r8 = "report"
            r9 = 2
            switch(r0) {
                case -1782210391: goto L_0x005b;
                case -934521548: goto L_0x0053;
                case 3321751: goto L_0x0049;
                case 109400031: goto L_0x0041;
                case 950398559: goto L_0x0037;
                case 1427818632: goto L_0x002d;
                case 1546214390: goto L_0x0023;
                case 1671642405: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0065
        L_0x0019:
            java.lang.String r0 = "dislike"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 6
            goto L_0x0066
        L_0x0023:
            java.lang.String r0 = "degrade"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 4
            goto L_0x0066
        L_0x002d:
            java.lang.String r0 = "download"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 7
            goto L_0x0066
        L_0x0037:
            java.lang.String r0 = "comment"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = r5
            goto L_0x0066
        L_0x0041:
            boolean r0 = r4.equals(r7)
            if (r0 == 0) goto L_0x0018
            r0 = r9
            goto L_0x0066
        L_0x0049:
            java.lang.String r0 = "like"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 3
            goto L_0x0066
        L_0x0053:
            boolean r0 = r4.equals(r8)
            if (r0 == 0) goto L_0x0018
            r0 = 5
            goto L_0x0066
        L_0x005b:
            java.lang.String r0 = "favourite"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = r6
            goto L_0x0066
        L_0x0065:
            r0 = -1
        L_0x0066:
            r10 = 500(0x1f4, double:2.47E-321)
            switch(r0) {
                case 0: goto L_0x01e9;
                case 1: goto L_0x01b4;
                case 2: goto L_0x0170;
                case 3: goto L_0x013f;
                case 4: goto L_0x00be;
                case 5: goto L_0x00b5;
                case 6: goto L_0x00ab;
                case 7: goto L_0x006d;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x01ed
        L_0x006d:
            android.content.Context r0 = r17.getContext()
            com.baidu.searchbox.feed.model.FeedBaseModel r5 = r1.mFeedBaseModel
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r5 = r1.buildSeries(r5)
            int r6 = r1.mVideoDownLoadStatus
            com.baidu.searchbox.player.helper.VideoDownloadHelper.dispatchDownloadTask(r0, r5, r6)
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r1.mFeedBaseModel
            if (r0 == 0) goto L_0x01ed
            com.baidu.searchbox.feed.model.FeedItemData r0 = r0.data
            boolean r0 = r0 instanceof com.baidu.searchbox.feed.model.FeedItemDataTabVideo
            if (r0 == 0) goto L_0x01ed
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r1.mFeedBaseModel
            com.baidu.searchbox.feed.model.FeedItemData r0 = r0.data
            com.baidu.searchbox.feed.model.FeedItemDataTabVideo r0 = (com.baidu.searchbox.feed.model.FeedItemDataTabVideo) r0
            com.baidu.searchbox.feed.model.FeedItemDataTabVideo$VideoInfoEntity r5 = r0.mVideoInfo
            if (r5 == 0) goto L_0x00a9
            int r6 = r1.mVideoDownLoadStatus
            java.lang.String r6 = com.baidu.searchbox.player.helper.VideoDownloadHelper.getUbcDownloadStatus(r6)
            org.json.JSONObject r7 = com.baidu.searchbox.feed.model.FeedItemDataTabVideo.VideoInfoEntity.toJson(r5)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "download_clk"
            java.lang.String r9 = "video_channel"
            java.lang.String r10 = "na"
            com.baidu.searchbox.feed.video.ShortVideoBusinessUbc.upVideoFuncUBC(r8, r9, r10, r6, r7)
        L_0x00a9:
            goto L_0x01ed
        L_0x00ab:
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$15 r0 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$15
            r0.<init>(r2)
            r1.postDelayed(r0, r10)
            goto L_0x01ed
        L_0x00b5:
            int r0 = r17.getIconIndex(r18)
            r1.uploadIconClickUBC(r8, r0)
            goto L_0x01ed
        L_0x00be:
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r0 = r0.degrade
            boolean r0 = r0.status
            if (r0 == 0) goto L_0x00d8
            android.content.Context r0 = r17.getContext()
            int r5 = com.baidu.searchbox.feed.core.R.string.feed_disliked_tip
            com.baidu.android.ext.widget.toast.UniversalToast r0 = com.baidu.android.ext.widget.toast.UniversalToast.makeText((android.content.Context) r0, (int) r5)
            r0.showToast()
            r17.dismissMenu()
            goto L_0x01ed
        L_0x00d8:
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r0 = r0.like
            boolean r0 = r0.status
            if (r0 == 0) goto L_0x00f2
            android.content.Context r0 = r17.getContext()
            int r5 = com.baidu.searchbox.feed.core.R.string.feed_liked_tip
            com.baidu.android.ext.widget.toast.UniversalToast r0 = com.baidu.android.ext.widget.toast.UniversalToast.makeText((android.content.Context) r0, (int) r5)
            r0.showToast()
            r17.dismissMenu()
            goto L_0x01ed
        L_0x00f2:
            r1.processDisLike(r3)
            if (r3 == 0) goto L_0x0124
            boolean r0 = r3 instanceof android.widget.LinearLayout
            r7 = 0
            r8 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x011b
            java.lang.Object r0 = r19.getTag()
            boolean r0 = r0 instanceof com.baidu.searchbox.feed.widget.dropdownpopup.view.DropdownPopupView.DropdownNormalViewHolder
            if (r0 == 0) goto L_0x0124
            java.lang.Object r0 = r19.getTag()
            com.baidu.searchbox.feed.widget.dropdownpopup.view.DropdownPopupView$DropdownNormalViewHolder r0 = (com.baidu.searchbox.feed.widget.dropdownpopup.view.DropdownPopupView.DropdownNormalViewHolder) r0
            android.widget.ImageView r12 = r0.icon
            android.widget.ImageView r13 = r0.icon
            int r13 = r13.getMeasuredHeight()
            int r13 = r13 / r9
            float r9 = (float) r13
            r1.applyAnimation(r12, r8, r7, r9)
            goto L_0x0124
        L_0x011b:
            int r0 = r19.getMeasuredHeight()
            int r0 = r0 / r9
            float r0 = (float) r0
            r1.applyAnimation(r3, r8, r7, r0)
        L_0x0124:
            com.baidu.searchbox.ui.CoolPraiseView r0 = r1.mPraiseView
            r0.disablePraiseAnimation(r6)
            r1.setCoolPraiseWorkIfNeeded(r3, r5)
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$14 r0 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$14
            r0.<init>(r3)
            com.baidu.android.util.concurrent.UiThreadUtil.runOnUiThread(r0, r10)
            int r0 = r17.getIconIndex(r18)
            java.lang.String r5 = "downvote"
            r1.uploadIconClickUBC(r5, r0)
            goto L_0x01ed
        L_0x013f:
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Like r0 = r0.degrade
            boolean r0 = r0.status
            if (r0 == 0) goto L_0x0159
            android.content.Context r0 = r17.getContext()
            int r5 = com.baidu.searchbox.feed.core.R.string.feed_disliked_tip
            com.baidu.android.ext.widget.toast.UniversalToast r0 = com.baidu.android.ext.widget.toast.UniversalToast.makeText((android.content.Context) r0, (int) r5)
            r0.showToast()
            r17.dismissMenu()
            goto L_0x01ed
        L_0x0159:
            r1.processLike(r3)
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$13 r0 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$13
            r0.<init>()
            com.baidu.android.util.concurrent.UiThreadUtil.runOnUiThread(r0, r10)
            int r0 = r17.getIconIndex(r18)
            java.lang.String r5 = "upvote"
            r1.uploadIconClickUBC(r5, r0)
            goto L_0x01ed
        L_0x0170:
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Share r0 = r0.share
            if (r0 == 0) goto L_0x01ed
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Share r0 = r0.share
            java.lang.String r0 = r0.url
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ed
            android.content.Context r8 = r17.getContext()
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Share r0 = r0.share
            java.lang.String r9 = r0.url
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Share r0 = r0.share
            java.lang.String r10 = r0.iconUrl
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Share r0 = r0.share
            java.lang.String r11 = r0.title
            com.baidu.searchbox.feed.model.FeedBar r0 = r1.mFeedBar
            com.baidu.searchbox.feed.model.FeedBar$Share r0 = r0.share
            java.lang.String r12 = r0.content
            r14 = 0
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r1.mFeedBaseModel
            java.lang.String r15 = r0.id
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r1.mFeedBaseModel
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r0 = r0.runtimeStatus
            java.lang.String r0 = r0.business
            java.lang.String r13 = "light_feedvideo"
            r16 = r0
            com.baidu.searchbox.feed.util.FeedShareWrapper.callVideoNativeShare(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1.uploadIconUBC(r7)
            goto L_0x01ed
        L_0x01b4:
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r1.mFeedBaseModel
            com.baidu.searchbox.feed.video.manager.VideoDataSimplifyProcessor.needFillUpVideoInfo(r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r5 = r0
            java.lang.String r0 = "source"
            java.lang.String r6 = "read_video"
            r5.putOpt(r0, r6)     // Catch:{ JSONException -> 0x01d1 }
            java.lang.String r0 = "value"
            java.lang.String r6 = "feed"
            r5.putOpt(r0, r6)     // Catch:{ JSONException -> 0x01d1 }
            goto L_0x01d2
        L_0x01d1:
            r0 = move-exception
        L_0x01d2:
            com.baidu.searchbox.feed.ioc.IFeedFavor r0 = com.baidu.searchbox.feed.ioc.IFeedFavor.Impl.get()
            android.content.Context r6 = r17.getContext()
            com.baidu.searchbox.feed.model.FeedBaseModel r7 = r1.mFeedBaseModel
            com.baidu.searchbox.feed.ioc.IFeedFavor$FavorParams r7 = com.baidu.searchbox.feed.util.FeedUtil.favorParamsFrom(r7)
            com.baidu.searchbox.feed.video.view.VideoOptBottomView$12 r8 = new com.baidu.searchbox.feed.video.view.VideoOptBottomView$12
            r8.<init>(r3, r2)
            r0.favorFeed(r6, r7, r5, r8)
            goto L_0x01ed
        L_0x01e9:
            r17.handleComment()
        L_0x01ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.video.view.VideoOptBottomView.performClick(com.baidu.searchbox.feed.model.FeedItemDataTabVideo$BarEntity, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public void setCoolPraiseWorkIfNeeded(View view2, boolean enabled) {
        ViewGroup parent;
        if (view2 != null && (parent = (ViewGroup) view2.getParent()) != null) {
            int count = parent.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View child = parent.getChildAt(i2);
                if (child.getId() == R.id.cool_praise_item_container) {
                    View child2 = ((LinearLayout) child).getChildAt(0);
                    if (child2 instanceof CoolPraiseView) {
                        ((CoolPraiseView) child2).disablePraiseAnimation(!enabled);
                    }
                }
            }
        }
    }

    private void handleComment() {
        FeedBar feedBar;
        if (this.mFeedBaseModel != null && (feedBar = this.mFeedBar) != null && feedBar.comment != null) {
            VideoStatisticUtil.startClickVideoTemplate(this.mFeedBaseModel.id);
            VideoDataSimplifyProcessor.needFillUpVideoInfo(this.mFeedBaseModel);
            String commentCmd = this.mFeedBar.comment.cmd;
            if (!TextUtils.isEmpty(commentCmd)) {
                VideoStatisticUtil.startRouter(this.mFeedBaseModel.id);
                Router.invoke(getContext(), commentCmd);
                VideoStatisticUtil.endRouter(this.mFeedBaseModel.id);
                VideoStatisticUtil.startHandleClick(this.mFeedBaseModel.id);
                uploadIconUBC("comment");
            }
            VideoStatisticUtil.endHandleClick(this.mFeedBaseModel.id);
            monitorCmdAvailability(getContext(), this.mFeedBaseModel.id, commentCmd);
            FeedDataReportUtils.reportFeedbackAction(this.mFeedBaseModel, (HashMap<String, String>) null, "clk", this.mPosition, (List<SubTagItem>) null, FeedDataReportUtils.ACTION_ID_CLICK_STYLE, "comment");
        }
    }

    /* access modifiers changed from: private */
    public void monitorCmdAvailability(Context context, String id, String cmd) {
        if (!Router.isAvailable(context, cmd)) {
            FeedException exp = new FeedException();
            exp.type = 18;
            exp.description = id;
            exp.message = cmd;
            ReliabilityStats.getTempStatsImpl("feedflow").onException(exp).submitLastException("333").end();
        }
    }

    /* access modifiers changed from: private */
    public int getIconIndex(FeedItemDataTabVideo.BarEntity barEntity) {
        return this.mBarList.indexOf(barEntity);
    }

    /* access modifiers changed from: private */
    public void applyFavorAnimation(final View view2, final int duration, float pivotX, float pivotY, boolean isFavor) {
        if (isFavor) {
            if (view2 != null) {
                Drawable drawable = getResources().getDrawable(R.drawable.feed_tab_video_favor_clicked);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((TextView) view2).setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mFeedBar.favor.isFavored = true;
            startScaleAnimation(view2, duration, 1.3f, pivotX, pivotY);
            return;
        }
        startAlphaAnimation(view2, duration, 1.0f, 0.5f, new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                View view2 = view2;
                if (view2 != null) {
                    Drawable drawable = VideoOptBottomView.this.getResources().getDrawable(R.drawable.feed_tab_video_favor_normal);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    ((TextView) view2).setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                VideoOptBottomView.this.mFeedBar.favor.isFavored = false;
                VideoOptBottomView.this.startAlphaAnimation(view2, duration / 2, 0.5f, 1.0f, (Animation.AnimationListener) null);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void applyFavorAnimation(View view2, int duration, boolean isFavor, FeedItemDataTabVideo.BarEntity barEntity) {
        ImageView likeView = (ImageView) view2.findViewById(R.id.dropdown_item_icon);
        TextView textView = (TextView) view2.findViewById(R.id.dropdown_item_text);
        if (isFavor) {
            if (likeView != null) {
                Drawable drawable = getResources().getDrawable(R.drawable.feed_video_immersive_favor_clicked);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                likeView.setImageDrawable(drawable);
                startScaleAnimation(likeView, duration, 1.3f, (float) (likeView.getMeasuredWidth() / 2), (float) (likeView.getMeasuredHeight() / 2));
            }
            this.mFeedBar.favor.isFavored = true;
            return;
        }
        if (this.mAnimationListener == null) {
            final ImageView imageView = likeView;
            final TextView textView2 = textView;
            final FeedItemDataTabVideo.BarEntity barEntity2 = barEntity;
            final int i2 = duration;
            this.mAnimationListener = new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!(imageView == null || textView2 == null)) {
                        Drawable drawable = VideoOptBottomView.this.getResources().getDrawable(R.drawable.feed_video_immersive_favor_normal);
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                        imageView.setImageDrawable(drawable);
                        textView2.setText(barEntity2.mTitle);
                    }
                    VideoOptBottomView.this.mFeedBar.favor.isFavored = false;
                    VideoOptBottomView.this.startAlphaAnimation(imageView, i2 / 2, 0.5f, 1.0f, (Animation.AnimationListener) null);
                }

                public void onAnimationRepeat(Animation animation) {
                }
            };
        }
        startAlphaAnimation(likeView, duration, 1.0f, 0.5f, this.mAnimationListener);
    }

    /* access modifiers changed from: private */
    public void processFavor(boolean isFavor) {
        String business;
        FeedBar feedBar = this.mFeedBar;
        if (feedBar != null && feedBar.favor != null && this.mFeedBar.favor.isFavored != isFavor) {
            LinkageData linkageData = new LinkageData();
            linkageData.nid = this.mFeedBar.favor.ukey;
            linkageData.status = isFavor ? "1" : "0";
            linkageData.type = "favor";
            linkageData.isUsed = true;
            FeedBaseModel feedBaseModel = this.mFeedBaseModel;
            if (feedBaseModel == null) {
                business = "feed";
            } else {
                business = feedBaseModel.runtimeStatus.business;
            }
            FeedLinkageManager.getInstance(business).addLinkage(linkageData);
        }
    }

    private void uploadIconUBC(String type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("from", "feed");
        map.put("type", type);
        map.put("page", "list");
        map.put("source", "na");
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataTabVideo)) {
            FeedItemDataTabVideo itemData = (FeedItemDataTabVideo) this.mFeedBaseModel.data;
            try {
                JSONObject extLog = new JSONObject(itemData.mVideoInfo.mExtLog);
                addUbcPublicParams(extLog);
                extLog.put("vid", this.mFeedBaseModel.id);
                extLog.put(FeedProtocolEntity.FEED_REC_TYPE, itemData.mRecType);
                extLog.put("tags", itemData.mTags);
                extLog.put("authorID", itemData.mAuthorId);
                extLog.put("pos", String.valueOf(this.mPosition));
                map.put("ext", extLog.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String frameSrc = FeedUBCWrapper.getFrameSource(this.mFeedBaseModel);
        if (TextUtils.equals(type, "share")) {
            map.put("value", this.mTabId);
            FeedUBCWrapper.ubcOnEvent("300", map, frameSrc);
            return;
        }
        map.put("tab_id", this.mTabId);
        FeedUBCWrapper.ubcOnEvent(UBC_FEED_COMMENT_CLICK_ID, map, frameSrc);
    }

    /* access modifiers changed from: private */
    public void uploadIconClickUBC(String type, int index) {
        HashMap<String, String> map = new HashMap<>();
        map.put("from", "video");
        map.put("type", type);
        map.put("page", this.mTabId);
        map.put("source", "na");
        map.put("value", this.mTabId);
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataTabVideo)) {
            if (FeedTplNameCenter.VIDEO_COLLECTION.equals(this.mFeedBaseModel.layout)) {
                map.put("layout", FeedTplNameCenter.VIDEO_COLLECTION);
            }
            FeedItemDataTabVideo itemData = (FeedItemDataTabVideo) this.mFeedBaseModel.data;
            if (itemData != null) {
                try {
                    JSONObject extLog = new JSONObject(itemData.mVideoInfo != null ? itemData.mVideoInfo.mExtLog : "");
                    addUbcPublicParams(extLog);
                    if (index > -1) {
                        extLog.put("idx", String.valueOf(index));
                    }
                    extLog.put("vid", this.mFeedBaseModel.id);
                    extLog.put(FeedProtocolEntity.FEED_REC_TYPE, itemData.mRecType);
                    extLog.put("tags", itemData.mTags);
                    extLog.put("authorID", itemData.mAuthorId);
                    extLog.put("pos", String.valueOf(this.mPosition));
                    if (TextUtils.equals(type, "author")) {
                        extLog.put("title", itemData.title);
                        if (itemData.images != null && itemData.images.size() > 0) {
                            extLog.put("image", ((FeedItemDataNews.Image) itemData.images.get(0)).image);
                        }
                    }
                    map.put("ext", extLog.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        FeedUBCWrapper.ubcOnEvent("464", map, FeedUBCWrapper.getFrameSource(this.mFeedBaseModel));
    }

    /* access modifiers changed from: private */
    public void processLike(View view2) {
        if (this.mFeedBar.like != null) {
            processLikeData(view2);
            String url = FeedIdentityManager.processUrl(FeedUrlConfig.getLikeUrl());
            JSONObject json = new JSONObject();
            try {
                json.put("nid", this.mFeedBaseModel.id);
                json.put("type", this.mFeedBar.like.status ? "1" : "0");
                json.put("ext", this.mFeedBar.like.ext);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Map<String, String> params = new HashMap<>();
            params.put("data", json.toString());
            StringResponseCallback callback = new StringResponseCallback() {
                public void onSuccess(String response, int statusCode) {
                }

                public void onFail(Exception exception) {
                }
            };
            if (url.startsWith("https://")) {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(getContext().getApplicationContext()).postFormRequest().url(url)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(false, false))).params(params)).build().executeAsyncOnUIBack(callback);
            } else {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(getContext().getApplicationContext()).postFormRequest().url(url)).params(params)).build().executeAsyncOnUIBack(callback);
            }
        }
    }

    private void processLikeData(View view2) {
        boolean isPraised;
        Drawable drawable;
        if (this.mFeedBar.like != null && view2 != null) {
            if (view2 instanceof CoolPraiseView) {
                isPraised = ((CoolPraiseView) view2).getIsPraisedState();
                if (!isPraised) {
                    this.mPraiseView.setPraiseTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.black));
                } else {
                    this.mPraiseView.setPraiseTextColor(ContextCompat.getColor(getContext(), R.color.feed_bar_like_yes_color));
                }
                ((CoolPraiseView) view2).setPraiseCount(String.valueOf(isPraised ? this.mFeedBar.like.count + 1 : this.mFeedBar.like.count - 1));
                this.mFeedBar.like.status = isPraised;
            } else {
                isPraised = !this.mFeedBar.like.status;
                TextView likeView = (TextView) view2;
                if (isPraised) {
                    drawable = getResources().getDrawable(R.drawable.feed_tab_video_vote_up_clicked);
                } else {
                    drawable = getResources().getDrawable(R.drawable.feed_tab_video_vote_up_normal);
                }
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                likeView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                likeView.setText(FeedUtil.convertNumber(getContext(), (long) (this.mFeedBar.like.count + 1)));
                likeView.setTextColor(ContextCompat.getColor(getContext(), R.color.feed_bar_like_yes_color));
            }
            if (this.mFeedBaseModel != null) {
                LinkageData linkageData = new LinkageData();
                linkageData.nid = this.mFeedBaseModel.id;
                linkageData.status = isPraised ? "1" : "0";
                linkageData.count = String.valueOf(isPraised ? this.mFeedBar.like.count + 1 : this.mFeedBar.like.count - 1);
                linkageData.type = "pro";
                linkageData.isUsed = true;
                FeedLinkageManager.getInstance(this.mFeedBaseModel.runtimeStatus.business).addLinkage(linkageData);
            }
        }
    }

    private void addUbcPublicParams(JSONObject extLog) throws JSONException {
        if (extLog != null) {
            extLog.put("clickID", FeedSessionManager.getInstance().getClickId());
            extLog.put("network", FeedUtil.getNetType());
        }
    }

    /* access modifiers changed from: private */
    public void startAlphaAnimation(View view2, int duration, float fromAlpha, float toAlpha, Animation.AnimationListener listener) {
        if (view2 != null) {
            AlphaAnimation alpha = new AlphaAnimation(fromAlpha, toAlpha);
            alpha.setDuration((long) duration);
            alpha.setFillAfter(false);
            if (listener != null) {
                alpha.setAnimationListener(listener);
            }
            view2.startAnimation(alpha);
        }
    }

    private void startScaleAnimation(View whichView, int duration, float scale, float pivotX, float pivotY) {
        if (whichView != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, scale, 1.0f, scale, pivotX, pivotY);
            scaleAnimation.setDuration((long) duration);
            scaleAnimation.setRepeatMode(2);
            scaleAnimation.setRepeatCount(1);
            scaleAnimation.setFillAfter(false);
            whichView.startAnimation(scaleAnimation);
        }
    }

    private void processDisLike(View view2) {
        if (this.mFeedBar.degrade != null) {
            processDisLikeDate(view2);
            this.mPraiseView.setPraiseable(false);
            String url = FeedIdentityManager.processUrl(FeedUrlConfig.getLikeUrl());
            JSONObject json = null;
            try {
                json = new JSONObject();
                json.put("nid", this.mFeedBaseModel.id);
                json.put("type", "1");
                json.put("ext", this.mFeedBar.degrade.ext);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Map<String, String> params = new HashMap<>();
            if (json != null) {
                params.put("data", json.toString());
            }
            StringResponseCallback callback = new StringResponseCallback() {
                public void onSuccess(String response, int statusCode) {
                }

                public void onFail(Exception exception) {
                }
            };
            if (url.startsWith("https://")) {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(getContext().getApplicationContext()).postFormRequest().url(url)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(false, false))).params(params)).build().executeAsyncOnUIBack(callback);
                return;
            }
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(getContext().getApplicationContext()).postFormRequest().url(url)).params(params)).build().executeAsyncOnUIBack(callback);
        }
    }

    public void showShare() {
        List<String> list;
        if (this.mShareIcon.getVisibility() != 0 && this.mShowShareAnimator == null && (list = this.mShareChannelList) != null && list.size() > 0) {
            ubcShareEvent(this.mShareChannelList.get(0), true);
            this.mShareIcon.setImageDrawable(getResources().getDrawable(IFeedShare.Impl.get().getMediaTypeResId(this.mShareChannelList.get(0))));
            final int authorTranX = this.mAuthorView.authorTranX();
            final int originAuthorX = ((RelativeLayout.LayoutParams) this.mAuthorView.getLayoutParams()).leftMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.mHideAuthorAnimator = ofFloat;
            ofFloat.setInterpolator((TimeInterpolator) null);
            this.mHideAuthorAnimator.setDuration(250);
            this.mHideAuthorAnimator.setStartDelay(1000);
            this.mHideAuthorAnimator.start();
            this.mHideAuthorAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    VideoOptBottomView.this.mAuthorView.hideAuthorImage();
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) VideoOptBottomView.this.mAuthorView.getLayoutParams();
                    params.leftMargin = originAuthorX;
                    VideoOptBottomView.this.mAuthorView.setLayoutParams(params);
                    VideoOptBottomView.this.mAuthorView.adjustDescParams();
                    ValueAnimator unused = VideoOptBottomView.this.mHideAuthorAnimator = null;
                }
            });
            this.mHideAuthorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = ((Float) animation.getAnimatedValue()).floatValue();
                    VideoOptBottomView.this.mAuthorView.setAuthorImageAlpha(value);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) VideoOptBottomView.this.mAuthorView.getLayoutParams();
                    params.leftMargin = (int) (((float) originAuthorX) - (((float) authorTranX) * (1.0f - value)));
                    VideoOptBottomView.this.mAuthorView.setLayoutParams(params);
                }
            });
            final int originShareX = DeviceUtil.ScreenInfo.dp2px(getContext(), 14.0f);
            final int shareTranX = DeviceUtil.ScreenInfo.dp2px(getContext(), 35.0f);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.mShowShareAnimator = ofFloat2;
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mShowShareAnimator.setDuration(250);
            this.mShowShareAnimator.setStartDelay(1000);
            this.mShowShareAnimator.start();
            this.mShowShareAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animation) {
                    VideoOptBottomView.this.mShareIcon.setAlpha(0.0f);
                    VideoOptBottomView.this.mShareIcon.setVisibility(0);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) VideoOptBottomView.this.mShareIcon.getLayoutParams();
                    params.rightMargin = originShareX - shareTranX;
                    VideoOptBottomView.this.mShareIcon.setLayoutParams(params);
                }

                public void onAnimationEnd(Animator animation) {
                    ValueAnimator unused = VideoOptBottomView.this.mShowShareAnimator = null;
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) VideoOptBottomView.this.mShareIcon.getLayoutParams();
                    params.rightMargin = originShareX;
                    VideoOptBottomView.this.mShareIcon.setLayoutParams(params);
                }
            });
            this.mShowShareAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = ((Float) animation.getAnimatedValue()).floatValue();
                    VideoOptBottomView.this.mShareIcon.setAlpha(1.0f - value);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) VideoOptBottomView.this.mShareIcon.getLayoutParams();
                    params.rightMargin = (int) (((float) originShareX) - (((float) shareTranX) * value));
                    VideoOptBottomView.this.mShareIcon.setLayoutParams(params);
                }
            });
        }
    }

    private void processDisLikeDate(View view2) {
        this.mFeedBar.degrade.status = true;
        if (view2 != null && (view2 instanceof LinearLayout) && (view2.getTag() instanceof DropdownPopupView.DropdownNormalViewHolder)) {
            DropdownPopupView.DropdownNormalViewHolder holder = (DropdownPopupView.DropdownNormalViewHolder) view2.getTag();
            holder.icon.setImageDrawable(getResources().getDrawable(R.drawable.feed_tab_video_vote_down_clicked));
            TextView textView = holder.text;
            Context context = getContext();
            FeedBar.Like like = this.mFeedBar.degrade;
            int i2 = like.count + 1;
            like.count = i2;
            textView.setText(FeedUtil.convertNumber(context, (long) i2));
            holder.text.setTextColor(ContextCompat.getColor(getContext(), R.color.feed_bar_like_yes_color));
        }
    }

    private void applyAnimation(View whichView, int duration, float pivotX, float pivotY) {
        ScaleAnimation anim = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, pivotX, pivotY);
        anim.setDuration((long) duration);
        anim.setRepeatMode(2);
        anim.setRepeatCount(1);
        anim.setFillAfter(false);
        whichView.startAnimation(anim);
    }

    public void menuDismiss(int duration) {
        postDelayed(new Runnable() {
            public void run() {
                if (VideoOptBottomView.this.mMenu != null && VideoOptBottomView.this.mMenu.isShowing()) {
                    VideoOptBottomView.this.mMenu.dismiss();
                }
            }
        }, (long) duration);
    }

    public void hideShare() {
        cancelShowShareAnimator();
        this.mShareIcon.setVisibility(8);
        this.mAuthorView.reset();
    }

    private void cancelShowShareAnimator() {
        ValueAnimator valueAnimator = this.mHideAuthorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mHideAuthorAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mShowShareAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.mShowShareAnimator = null;
        }
    }

    public View getView() {
        return this;
    }

    public void updateVideoLabelView() {
        ImageView imageView = this.mMoreImage;
        if (imageView != null) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.feed_tab_video_more_icon));
        }
        List<FeedItemDataTabVideo.BarEntity> list = this.mBarList;
        if (list != null && list.size() > 0) {
            updateIconListData();
        }
        List<String> list2 = this.mShareChannelList;
        if (list2 != null && list2.size() > 0) {
            this.mShareIcon.setImageDrawable(getContext().getResources().getDrawable(IFeedShare.Impl.get().getMediaTypeResId(this.mShareChannelList.get(0))));
        }
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        if (videoAuthorComponentView != null) {
            videoAuthorComponentView.updateNightMode();
        }
    }

    public void showArrowIcon() {
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        if (videoAuthorComponentView != null) {
            videoAuthorComponentView.showArrowIcon();
        }
    }

    public void hideArrowIcon() {
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        if (videoAuthorComponentView != null) {
            videoAuthorComponentView.hideArrowIcon();
        }
    }

    public boolean isArrowIconShowing() {
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        return videoAuthorComponentView != null && videoAuthorComponentView.isArrowIconShowing();
    }

    public void updateArrowIcon(boolean arrowUp) {
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        if (videoAuthorComponentView != null) {
            videoAuthorComponentView.updateArrowIcon(arrowUp);
        }
    }

    public void hideFollowComponent() {
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        if (videoAuthorComponentView != null) {
            videoAuthorComponentView.hideFollowComponent();
        }
    }

    public void syncData(FeedBaseModel feedModel) {
        if (feedModel != null && (feedModel.data instanceof FeedItemDataTabVideo)) {
            this.mFeedBaseModel = feedModel;
            this.mTabId = feedModel.runtimeStatus.channelId;
            this.mPosition = feedModel.runtimeStatus.viewPosition;
            this.mBarList = ((FeedItemDataTabVideo) feedModel.data).mBarSortList;
            this.mFeedBar = feedModel.data.feedBar;
            List<FeedItemDataTabVideo.BarEntity> list = this.mBarList;
            if (list != null && list.size() > 0) {
                updateIconListData();
            }
            this.mAuthorView.updateView(feedModel);
            buildSeries(feedModel);
        }
    }

    public void showFollowTip(String tip) {
        VideoAuthorComponentView videoAuthorComponentView = this.mAuthorView;
        if (videoAuthorComponentView != null) {
            videoAuthorComponentView.showFollowTip(tip);
        }
    }

    public void updateCollectionState() {
        updateMachineState();
    }

    public void onUpdateProgress(int progress, int buffer, int max) {
    }

    public void showPraiseGuidePlay() {
        if (!this.mHasShowGuidePlay) {
            if (this.mShowShareAnimator == null) {
                this.mHasShowGuidePlay = this.mPraiseView.guidePlay((ViewGroup) null, true, true, true);
            } else {
                this.mPraiseView.postDelayed(new Runnable() {
                    public void run() {
                        if (!VideoOptBottomView.this.mHasShowGuidePlay) {
                            if (VideoOptBottomView.this.mStatus == null || VideoOptBottomView.this.mStatus.isPlaying()) {
                                VideoOptBottomView videoOptBottomView = VideoOptBottomView.this;
                                boolean unused = videoOptBottomView.mHasShowGuidePlay = videoOptBottomView.mPraiseView.guidePlay((ViewGroup) null, true, true, true);
                            }
                        }
                    }
                }, 1250);
            }
        }
    }

    public void cancelPraiseGuidePlay() {
        this.mPraiseView.post(new Runnable() {
            public void run() {
                VideoOptBottomView.this.mPraiseView.cancelGuidePlay();
            }
        });
    }

    public void resetShowGuidePlayStatus() {
        this.mHasShowGuidePlay = false;
    }

    public void syncCommentCount(int commentCount) {
        String business;
        FeedBaseModel feedBaseModel = this.mFeedBaseModel;
        if (feedBaseModel != null && (feedBaseModel.data instanceof FeedItemDataTabVideo)) {
            LinkageData linkageData = new LinkageData();
            linkageData.nid = this.mFeedBaseModel.id;
            linkageData.type = "comment";
            linkageData.isUsed = false;
            linkageData.count = commentCount + "";
            FeedBaseModel feedBaseModel2 = this.mFeedBaseModel;
            if (feedBaseModel2 == null) {
                business = "feed";
            } else {
                business = feedBaseModel2.runtimeStatus.business;
            }
            FeedLinkageManager.getInstance(business).addLinkage(linkageData);
            if (this.mFeedBar != null) {
                this.mBarList = ((FeedItemDataTabVideo) this.mFeedBaseModel.data).mBarSortList;
                updateIconListData();
            }
        }
    }
}
