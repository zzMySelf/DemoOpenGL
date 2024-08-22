package com.baidu.searchbox.video.detail.plugin.component.author.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.follow.FollowActionRequest;
import com.baidu.searchbox.follow.FollowActionResult;
import com.baidu.searchbox.follow.FollowConstant;
import com.baidu.searchbox.follow.FollowUtils;
import com.baidu.searchbox.follow.StatisticConstants;
import com.baidu.searchbox.follow.dialog.RedPacketDialog;
import com.baidu.searchbox.follow.net.Callback;
import com.baidu.searchbox.follow.recommend.RelatedRecommendDataManager;
import com.baidu.searchbox.follow.recommend.RelatedRecommendRequest;
import com.baidu.searchbox.follow.recommend.data.IFollowRecommendItem;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import com.baidu.searchbox.follow.view.FollowEvent;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper;
import com.baidu.searchbox.video.detail.export.IVideoRouter;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.detail.plugin.component.author.ui.RelatedRecommendFloatContainer;
import com.baidu.searchbox.video.detail.utils.VideoLiveBreatheAnimHelper;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Action1;

public class AccountAndFollowView extends LinearLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public static final int ACTION_BUTTON_SHIFT_LENGTH = IVideoScreenInfoUtils.Impl.get().dp2px(33.0f);
    private static final int MAX_FOLLOW_RECOMMEND_LIST_SIZE = 100;
    private static final int MSG_BEYOND_VALID_TIME_AFTER_FOLLOW = 0;
    private static final int MSG_FETCH_RECOMMEND_DATA_OVER = 1;
    private static final String RED_PACKET_SOURCE = "media_videoredpacket";
    private static final String TAG = "AccountAndFollowView";
    public static final String TAG_FOLLOW = "sFakeAccountInfoView";
    private static final int VALID_TIME_AFTER_FOLLOW = 1000;
    private static LruCache<String, Boolean> sRecommendDataContainer = new LruCache<>(100);
    /* access modifiers changed from: private */
    public AccountInfo mAccountInfo;
    /* access modifiers changed from: private */
    public TextView mActionBtn;
    /* access modifiers changed from: private */
    public View mActionContainer;
    /* access modifiers changed from: private */
    public ImageView mArrow;
    /* access modifiers changed from: private */
    public View mArrowContainer;
    private LottieAnimationView mAuthorLiveAni;
    private TextView mAuthorLiveTag;
    private AnimatorSet mAuthorScaleAnimSet;
    private boolean mClickFollow;
    private boolean mClickIntercept = false;
    private String mExt = null;
    private boolean mFollowBtnGone = false;
    private View mFollowContainer;
    /* access modifiers changed from: private */
    public ProgressBar mFollowProgressBar;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    boolean unused = AccountAndFollowView.this.mWithinValidTimeAfterFollow = false;
                    return;
                case 1:
                    if (AccountAndFollowView.this.mWithinValidTimeAfterFollow) {
                        if (AccountAndFollowView.this.mAccountInfo != null && !TextUtils.isEmpty(AccountAndFollowView.this.mAccountInfo.thirdId) && AccountAndFollowView.this.mRecommendListView.hasRecommendData(AccountAndFollowView.this.mAccountInfo.thirdId)) {
                            if (AccountAndFollowView.this.mShowRecommendListOnly) {
                                AccountAndFollowView.this.mRecommendListView.unfoldWithAnimation((ValueAnimator) null);
                            } else {
                                AccountAndFollowView.this.unfoldRecommendList();
                            }
                        }
                        boolean unused2 = AccountAndFollowView.this.mWithinValidTimeAfterFollow = false;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private TextView mIntro;
    /* access modifiers changed from: private */
    public boolean mIsAnimationRunning = false;
    /* access modifiers changed from: private */
    public boolean mIsFetchingRecommendData = false;
    private boolean mIsRedPacketFollow = false;
    private EventListener mListener;
    private TextView mName;
    private String mNid;
    private SimpleDraweeView mPortrait;
    private View mPortraitContainer;
    private RelatedRecommendFloatContainer mRecommendFloatingView;
    private boolean mRecommendListIsEmpty = false;
    /* access modifiers changed from: private */
    public RecommendListListener mRecommendListListener;
    /* access modifiers changed from: private */
    public RelatedRecommendFloatListView mRecommendListView;
    private View mRedPacketLayout;
    private ViewStub mRedPacketStub;
    private OnScrollOffsetListener mScrollOffsetListener;
    private String mSfrom = null;
    private boolean mShowRecommendList = true;
    /* access modifiers changed from: private */
    public boolean mShowRecommendListOnly = false;
    private boolean mShowRedPacket = true;
    private String mSource;
    private View mTopView;
    private final Map<String, String> mUBCExtInfo = new HashMap();
    private boolean mUBCIconShow = false;
    private String mUbcValue;
    /* access modifiers changed from: private */
    public ProgressBar mUnFollowProgressBar;
    private ImageView mVipIcon;
    /* access modifiers changed from: private */
    public boolean mWithinValidTimeAfterFollow = false;

    public interface EventListener {
        void onAuthorHeadClick(boolean z);

        void onRedPacketShow();

        void recordBeginTime();
    }

    public interface OnScrollOffsetListener {
        void scrollYOffset(int i2);
    }

    public interface RecommendListListener {
        void onDataEmpty();

        void onDataShow();
    }

    private static class SyncFollowEvent {
        public static final int EVENT_ARROW = 2;
        public static final int EVENT_BUTTON = 1;
        public static final int EVENT_NONE = 0;
        public int followOrArrow;
        public boolean isFollow;
        public Object tag;
    }

    public AccountAndFollowView(Context context) {
        super(context);
        init(context);
    }

    public AccountAndFollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AccountAndFollowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.video_detail_account_and_follow_layout, this, true);
        setOrientation(1);
        setOnClickListener(this);
        this.mTopView = findViewById(R.id.top_view);
        View findViewById = findViewById(R.id.portrait_container);
        this.mPortraitContainer = findViewById;
        findViewById.setOnClickListener(this);
        this.mPortrait = (SimpleDraweeView) findViewById(R.id.portrait);
        this.mAuthorLiveAni = (LottieAnimationView) findViewById(R.id.author_image_live_ani);
        this.mAuthorLiveTag = (TextView) findViewById(R.id.author_image_live_tag);
        this.mVipIcon = (ImageView) findViewById(R.id.vip_icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.mIntro = (TextView) findViewById(R.id.intro);
        this.mFollowContainer = findViewById(R.id.follow_container);
        View findViewById2 = findViewById(R.id.action_container);
        this.mActionContainer = findViewById2;
        findViewById2.setOnTouchListener(new TouchStateListener());
        this.mActionContainer.setOnClickListener(this);
        this.mActionBtn = (TextView) findViewById(R.id.action_btn);
        this.mFollowProgressBar = (ProgressBar) findViewById(R.id.follow_progress_bar);
        this.mUnFollowProgressBar = (ProgressBar) findViewById(R.id.unfollow_progress_bar);
        View findViewById3 = findViewById(R.id.arrow_container);
        this.mArrowContainer = findViewById3;
        findViewById3.setOnTouchListener(new TouchStateListener());
        this.mArrowContainer.setOnClickListener(this);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        this.mRedPacketStub = (ViewStub) findViewById(R.id.red_packet_icon_stub);
    }

    public void setRecommendViewContainer(RelatedRecommendFloatContainer floatContainer) {
        this.mRecommendFloatingView = floatContainer;
        this.mRecommendListView = floatContainer.getRecommendListView();
        updateNightModeUI();
        registerFollowEvent();
    }

    public void setFollowBtnVisible(boolean visible) {
        this.mFollowBtnGone = !visible;
        this.mFollowContainer.setVisibility(visible ? 0 : 8);
    }

    public void setClickIntercept(boolean clickIntercept) {
        this.mClickIntercept = clickIntercept;
    }

    public void updateTeenModeUI() {
        setFollowBtnVisible(false);
        setClickIntercept(true);
    }

    private void registerFollowEvent() {
        IVideoEventBusWrapper.Impl.get().registerOnMainThread((Object) this, SyncFollowEvent.class, new Action1<SyncFollowEvent>() {
            public void call(SyncFollowEvent followEvent) {
                if (followEvent != null) {
                    switch (followEvent.followOrArrow) {
                        case 0:
                            if (followEvent.isFollow) {
                                AccountAndFollowView.this.updateFollowSuccess(followEvent.tag);
                                return;
                            } else {
                                AccountAndFollowView.this.updateUnFollowSuccess(followEvent.tag);
                                return;
                            }
                        case 2:
                            AccountAndFollowView.this.updateUnfoldRecommendList(followEvent.tag);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    public void unRegisterFollowEvent() {
        IVideoEventBusWrapper.Impl.get().unregister(this);
    }

    public void showRecommendListWithAnimation() {
        showRecommendListWithAnimation((ValueAnimator) null);
    }

    public void showRecommendListWithAnimation(ValueAnimator animator) {
        AccountInfo accountInfo;
        if (this.mRecommendListView != null && this.mShowRecommendListOnly && (accountInfo = this.mAccountInfo) != null && !TextUtils.isEmpty(accountInfo.thirdId) && this.mRecommendListView.hasRecommendData(this.mAccountInfo.thirdId)) {
            this.mRecommendListView.unfoldWithAnimation(animator);
        }
    }

    public void hideRecommendListWithAnimation() {
        hideRecommendListWithAnimation((ValueAnimator) null);
    }

    public void hideRecommendListWithAnimation(ValueAnimator animator) {
        RelatedRecommendFloatListView relatedRecommendFloatListView = this.mRecommendListView;
        if (relatedRecommendFloatListView != null && this.mShowRecommendListOnly) {
            relatedRecommendFloatListView.foldWithAnimation(animator);
        }
    }

    public void showRecommendListOnly(boolean showListOnly) {
        View view2 = this.mTopView;
        if (view2 != null && this.mRecommendListView != null) {
            this.mShowRecommendListOnly = showListOnly;
            int i2 = 8;
            view2.setVisibility(showListOnly ? 8 : 0);
            RelatedRecommendFloatListView relatedRecommendFloatListView = this.mRecommendListView;
            if (showListOnly) {
                i2 = 0;
            }
            relatedRecommendFloatListView.setVisibility(i2);
            this.mRecommendListView.showBackgroundBubble(!showListOnly);
            if (showListOnly) {
                AccountInfo accountInfo = this.mAccountInfo;
                if (accountInfo == null || TextUtils.isEmpty(accountInfo.thirdId) || !this.mRecommendListView.hasRecommendData(this.mAccountInfo.thirdId)) {
                    fetchRecommendData();
                    return;
                }
                this.mRecommendListView.unfoldWithAnimation((ValueAnimator) null);
                RecommendListListener recommendListListener = this.mRecommendListListener;
                if (recommendListListener != null) {
                    recommendListListener.onDataShow();
                    return;
                }
                return;
            }
            resetStatus();
        }
    }

    public void setRecommendListTitle(String title) {
        if (this.mRecommendListView != null && !TextUtils.isEmpty(title)) {
            this.mRecommendListView.setTitle(title);
        }
    }

    public void updateNightModeUI() {
        Resources resources = getContext().getResources();
        setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.follow_wrapper_bg));
        this.mTopView.setBackgroundColor(0);
        this.mName.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC1));
        this.mIntro.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC4));
        this.mArrowContainer.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.followed_text_bg));
        this.mRecommendListView.updateNightModeUI();
        this.mFollowProgressBar.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.follow_progress_drawable));
        this.mUnFollowProgressBar.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.unfollow_progress_drawable));
        this.mAuthorLiveTag.setTextColor(resources.getColor(com.baidu.searchbox.follow.R.color.author_image_live_tag_text_color));
        this.mAuthorLiveTag.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.author_image_live_tag_bg));
        VideoLiveBreatheAnimHelper.updateNightLiveBreatheAnim(this.mAuthorScaleAnimSet, this.mAuthorLiveAni);
    }

    public void setAccountInfoAndSource(AccountInfo accountInfo, String source, String recommendListSource) {
        setAccountInfoAndSource(accountInfo, source, recommendListSource, true);
    }

    public void setAccountInfoAndSource(AccountInfo accountInfo, String source, String recommendListSource, boolean needUbc) {
        if (accountInfo != null) {
            if (TextUtils.isEmpty(accountInfo.type) || TextUtils.isEmpty(accountInfo.thirdId) || !this.mFollowBtnGone) {
                this.mFollowContainer.setVisibility(8);
            } else {
                this.mFollowContainer.setVisibility(0);
            }
            this.mAccountInfo = accountInfo;
            if (accountInfo != null) {
                RelatedRecommendDataManager.setInitParam(new RelatedRecommendDataManager.InitParam(this.mAccountInfo.type, this.mAccountInfo.thirdId, this.mNid));
            }
            AccountInfo accountInfo2 = this.mAccountInfo;
            if (accountInfo2 != null) {
                try {
                    this.mPortrait.setImageURI(Uri.parse(accountInfo2.logo));
                } catch (Exception e2) {
                }
                FollowUtils.setVipIcon(getContext(), this.mVipIcon, this.mAccountInfo.vipType);
                this.mName.setText(this.mAccountInfo.name);
                this.mIntro.setText(this.mAccountInfo.intro);
            }
            if (accountInfo.isAuthorLive) {
                AnimatorSet animatorSet = this.mAuthorScaleAnimSet;
                if (animatorSet == null) {
                    this.mAuthorScaleAnimSet = VideoLiveBreatheAnimHelper.createAndStartLiveBreatheAnim(this.mPortrait, this.mAuthorLiveAni);
                } else {
                    VideoLiveBreatheAnimHelper.restartLiveBreatheAnim(this.mPortrait, animatorSet, this.mAuthorLiveAni);
                }
                this.mAuthorLiveTag.setVisibility(0);
                if (this.mVipIcon.getVisibility() == 0) {
                    this.mVipIcon.setVisibility(8);
                }
            } else {
                VideoLiveBreatheAnimHelper.cancelLiveBreatheAnim(this.mAuthorScaleAnimSet, this.mAuthorLiveAni);
                this.mAuthorLiveTag.setVisibility(8);
            }
            this.mSource = source;
            this.mRecommendListView.setSource(recommendListSource);
            this.mUBCExtInfo.put("type", accountInfo.type);
            this.mUBCExtInfo.put(FollowConstant.UBC_EXT_KEY_TYPE_ID, accountInfo.typeId);
            this.mUBCExtInfo.put("third_id", accountInfo.thirdId);
            AccountInfo accountInfo3 = this.mAccountInfo;
            if (accountInfo3 != null) {
                updateFollowStatus(accountInfo3.isFollowed, needUbc);
            }
            updateHaveRecommendList(false);
        }
    }

    public void setSfrom(String sfrom) {
        this.mSfrom = sfrom;
    }

    public void setExt(String ext) {
        this.mExt = ext;
    }

    public void updateFollowStatus() {
        AccountInfo accountInfo = this.mAccountInfo;
        if (accountInfo != null) {
            try {
                this.mPortrait.setImageURI(Uri.parse(accountInfo.logo));
            } catch (Exception e2) {
            }
            FollowUtils.setVipIcon(getContext(), this.mVipIcon, this.mAccountInfo.vipType);
            updateFollowStatus(this.mAccountInfo.isFollowed);
        }
    }

    public void updateFollowStatus(boolean isFollow) {
        updateFollowStatus(isFollow, true);
    }

    public void updateFollowStatus(boolean isFollow, boolean needUbc) {
        AccountInfo accountInfo = this.mAccountInfo;
        if (accountInfo != null) {
            boolean unused = accountInfo.isFollowed = isFollow;
            Resources resources = getResources();
            this.mActionBtn.setVisibility(0);
            if (this.mAccountInfo.isFollowed) {
                this.mActionBtn.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC69));
                this.mActionContainer.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.followed_text_bg));
                this.mActionBtn.setText(com.baidu.searchbox.follow.R.string.followed);
                View view2 = this.mRedPacketLayout;
                if (view2 != null && view2.getVisibility() == 0) {
                    this.mRedPacketLayout.setVisibility(8);
                }
                this.mIsRedPacketFollow = false;
            } else {
                this.mActionBtn.setText(com.baidu.searchbox.follow.R.string.follow);
                if (1 != this.mAccountInfo.mRedPacketClass || !this.mShowRedPacket) {
                    this.mIsRedPacketFollow = false;
                    View view3 = this.mRedPacketLayout;
                    if (view3 != null && view3.getVisibility() == 0) {
                        this.mRedPacketLayout.setVisibility(8);
                    }
                    this.mActionBtn.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC67));
                    this.mActionContainer.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.follow_btn_bg));
                } else {
                    this.mIsRedPacketFollow = true;
                    if (this.mRedPacketLayout == null) {
                        this.mRedPacketLayout = this.mRedPacketStub.inflate();
                    }
                    this.mRedPacketLayout.setVisibility(0);
                    View redPacketIconBg = this.mRedPacketLayout.findViewById(com.baidu.searchbox.follow.R.id.follow_red_packet_icon_bg);
                    ((ImageView) this.mRedPacketLayout.findViewById(com.baidu.searchbox.follow.R.id.follow_red_packet_icon)).setImageResource(com.baidu.searchbox.follow.R.drawable.follow_red_packet_icon);
                    redPacketIconBg.setBackgroundColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC8));
                    this.mActionContainer.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.follow_btn_red_bg));
                    this.mActionBtn.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.GC67));
                }
            }
            if (needUbc) {
                ubcFollowShow();
            }
        }
    }

    public void syncFollowStatus(boolean isFollow) {
        AccountInfo accountInfo = this.mAccountInfo;
        if (accountInfo != null) {
            boolean oldFollowStatus = accountInfo.isFollowed;
            if (getTag() != null && !isFollow && oldFollowStatus) {
                this.mShowRedPacket = false;
                this.mIsRedPacketFollow = false;
            }
            updateFollowStatus(isFollow);
            if (!isFollow) {
                this.mActionContainer.setTranslationX(0.0f);
                this.mArrowContainer.setVisibility(8);
                onDismissRecommendView();
                this.mRecommendListView.setVisibility(8);
            }
        }
    }

    public void resetStatus() {
        if (this.mRecommendListView != null) {
            this.mAccountInfo = null;
            this.mSource = null;
            this.mNid = null;
            this.mUBCExtInfo.clear();
            this.mActionContainer.setTranslationX(0.0f);
            this.mArrowContainer.setVisibility(8);
            if (!this.mShowRecommendListOnly) {
                onDismissRecommendView();
                this.mRecommendListView.setVisibility(8);
            }
            this.mRecommendListView.clearData();
            this.mShowRedPacket = true;
            this.mIsRedPacketFollow = false;
            this.mUBCIconShow = false;
            this.mIsAnimationRunning = false;
            VideoLiveBreatheAnimHelper.cancelLiveBreatheAnim(this.mAuthorScaleAnimSet, this.mAuthorLiveAni);
        }
    }

    public void setNid(String nid) {
        this.mNid = nid;
        this.mUBCExtInfo.put("nid", nid);
    }

    public void setUbcParams(String ubcValue, Map<String, String> ubcExtInfo) {
        this.mUbcValue = ubcValue;
        this.mRecommendListView.setUbcValue(ubcValue);
        if (ubcExtInfo != null && !ubcExtInfo.isEmpty()) {
            this.mUBCExtInfo.putAll(ubcExtInfo);
        }
    }

    private void rotateArrow(boolean isUp) {
        float[] fArr = new float[2];
        float f2 = 180.0f;
        fArr[0] = isUp ? 180.0f : 0.0f;
        if (isUp) {
            f2 = 0.0f;
        }
        fArr[1] = f2;
        ValueAnimator animator = ValueAnimator.ofFloat(fArr);
        animator.setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                AccountAndFollowView.this.mArrow.setRotation(((Float) animation.getAnimatedValue()).floatValue());
            }
        });
        animator.start();
        FollowUtils.followEvent(StatisticConstants.UBC_FOLLOW_EVENT_ID, isUp ? "spread" : FollowConstant.UBC_TYPE_PACK_UP, (String) null, this.mUbcValue);
    }

    private void foldRecommendList() {
        if (!this.mIsAnimationRunning) {
            ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    AccountAndFollowView.this.mArrowContainer.setVisibility(8);
                    boolean unused = AccountAndFollowView.this.mIsAnimationRunning = false;
                }

                public void onAnimationStart(Animator animation) {
                    boolean unused = AccountAndFollowView.this.mIsAnimationRunning = true;
                }
            });
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animValue = ((Float) animation.getAnimatedValue()).floatValue();
                    AccountAndFollowView.this.mActionContainer.setTranslationX(((float) AccountAndFollowView.ACTION_BUTTON_SHIFT_LENGTH) * (animValue - 1.0f));
                    AccountAndFollowView.this.mArrow.setAlpha(1.0f - animValue);
                }
            });
            onDismissRecommendView();
            this.mRecommendListView.foldWithAnimation(animator);
            animator.start();
        }
    }

    /* access modifiers changed from: private */
    public void unfoldRecommendList() {
        if (!this.mIsAnimationRunning && getResources().getConfiguration().orientation == 1) {
            ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animation) {
                    AccountAndFollowView.this.mArrowContainer.setVisibility(0);
                    AccountAndFollowView.this.mArrow.setRotation(0.0f);
                    AccountAndFollowView.this.onShowRecommendView();
                    boolean unused = AccountAndFollowView.this.mIsAnimationRunning = true;
                }

                public void onAnimationEnd(Animator animation) {
                    boolean unused = AccountAndFollowView.this.mIsAnimationRunning = false;
                }
            });
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animValue = ((Float) animation.getAnimatedValue()).floatValue();
                    AccountAndFollowView.this.mActionContainer.setTranslationX(((float) (-AccountAndFollowView.ACTION_BUTTON_SHIFT_LENGTH)) * animValue);
                    AccountAndFollowView.this.mArrow.setAlpha(animValue);
                }
            });
            this.mRecommendListView.unfoldWithAnimation(animator);
            animator.start();
            SyncFollowEvent followEvent = new SyncFollowEvent();
            followEvent.tag = getTag();
            followEvent.followOrArrow = 2;
            IVideoEventBusWrapper.Impl.get().post(followEvent);
        }
    }

    public void onClick(View v) {
        AccountInfo accountInfo;
        if (!this.mClickIntercept) {
            this.mClickFollow = false;
            if (v == this.mActionContainer) {
                AccountInfo accountInfo2 = this.mAccountInfo;
                if (accountInfo2 != null && !accountInfo2.isFollowing && !this.mAccountInfo.isUnFollowing && !this.mIsAnimationRunning) {
                    this.mActionBtn.setVisibility(8);
                    boolean access$1600 = this.mAccountInfo.isFollowed;
                    String str = FollowConstant.UBC_TYPE_REDFOLLOWCLICK_UP;
                    if (access$1600) {
                        showUnFollowProgressBar();
                        unFollow();
                        HashMap<String, String> extInfo = new HashMap<>();
                        extInfo.putAll(this.mUBCExtInfo);
                        extInfo.put("action_type", "0");
                        if (!this.mIsRedPacketFollow) {
                            str = FollowConstant.UBC_TYPE_FOLLOWCLICK_UP;
                        }
                        FollowUtils.followEvent(StatisticConstants.UBC_FOLLOW_EVENT_ID, str, (String) null, this.mUbcValue, (Map<String, String>) extInfo);
                    } else if (isNeedScrollUp()) {
                        invokeFloatFollowClick(true);
                    } else {
                        this.mClickFollow = true;
                        this.mRecommendFloatingView.setClickTag(getTag());
                        showFollowProgressBar();
                        addFollow();
                        if (this.mShowRecommendList && !this.mIsRedPacketFollow) {
                            fetchRecommendData();
                        }
                        HashMap<String, String> extInfo2 = new HashMap<>();
                        extInfo2.putAll(this.mUBCExtInfo);
                        extInfo2.put("action_type", "1");
                        if (!this.mIsRedPacketFollow) {
                            str = FollowConstant.UBC_TYPE_FOLLOWCLICK_UP;
                        }
                        FollowUtils.followEvent(StatisticConstants.UBC_FOLLOW_EVENT_ID, str, (String) null, this.mUbcValue, (Map<String, String>) extInfo2);
                    }
                }
            } else if (v == this.mArrowContainer) {
                if (this.mRecommendFloatingView.isShowing()) {
                    onDismissRecommendView();
                } else if (isNeedScrollUp()) {
                    invokeFloatFollowClick(false);
                } else {
                    rotateArrow(true);
                    onShowRecommendView();
                    this.mRecommendListView.unfoldWithAnimation((ValueAnimator) null);
                }
            } else if (v == this.mTopView || v == this) {
                String str2 = null;
                FollowUtils.followEvent(StatisticConstants.UBC_FOLLOW_EVENT_ID, FollowConstant.UBC_TYPE_HEAD_CLICK, (String) null, this.mUbcValue, (String) null);
                if (this.mAccountInfo != null) {
                    EventListener eventListener = this.mListener;
                    if (eventListener != null) {
                        eventListener.recordBeginTime();
                    }
                    IVideoRouter.Impl.get().invoke(getContext(), this.mAccountInfo.cmd);
                }
            } else if (v == this.mPortraitContainer && (accountInfo = this.mAccountInfo) != null) {
                if (accountInfo.isAuthorLive) {
                    IVideoRouter.Impl.get().invoke(getContext(), this.mAccountInfo.mLiveCmd);
                } else {
                    IVideoRouter.Impl.get().invoke(getContext(), this.mAccountInfo.cmd);
                }
                String str3 = null;
                FollowUtils.followEvent(StatisticConstants.UBC_FOLLOW_EVENT_ID, FollowConstant.UBC_TYPE_HEAD_CLICK, (String) null, this.mUbcValue, (String) null);
                EventListener eventListener2 = this.mListener;
                if (eventListener2 != null) {
                    eventListener2.recordBeginTime();
                    this.mListener.onAuthorHeadClick(this.mAccountInfo.isAuthorLive);
                }
            }
        }
    }

    private void showFollowProgressBar() {
        if (getTag() == null) {
            ProgressBar progressBar = this.mFollowProgressBar;
            if (progressBar != null) {
                ((ViewGroup) this.mActionContainer).removeView(progressBar);
                this.mFollowProgressBar = null;
            }
            this.mFollowProgressBar = createProgressBar(com.baidu.searchbox.follow.R.drawable.follow_progress_drawable);
        }
        this.mFollowProgressBar.setVisibility(0);
    }

    private void showUnFollowProgressBar() {
        if (getTag() == null) {
            if (this.mUnFollowProgressBar != null) {
                ((ViewGroup) this.mActionContainer).removeView(this.mFollowProgressBar);
                this.mUnFollowProgressBar = null;
            }
            this.mUnFollowProgressBar = createProgressBar(com.baidu.searchbox.follow.R.drawable.unfollow_progress_drawable);
        }
        this.mUnFollowProgressBar.setVisibility(0);
    }

    private ProgressBar createProgressBar(int drawable) {
        ProgressBar progressBar = new ProgressBar(getContext());
        int size = IVideoScreenInfoUtils.Impl.get().dp2px(15.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size, size);
        layoutParams.gravity = 17;
        progressBar.setLayoutParams(layoutParams);
        progressBar.setIndeterminateDrawable(ContextCompat.getDrawable(getContext(), drawable));
        ((ViewGroup) this.mActionContainer).addView(progressBar);
        return progressBar;
    }

    private void addFollow() {
        boolean unused = this.mAccountInfo.isFollowing = true;
        final String type = this.mAccountInfo.type;
        final String thirdId = this.mAccountInfo.thirdId;
        String str = this.mSfrom;
        if (str == null) {
            str = "sbox";
        }
        String sFrom = str;
        String ext = this.mExt;
        if (ext == null) {
            ext = null;
        }
        FollowActionRequest.getFollowAction(FollowRuntime.getAppContext(), type, thirdId, true, sFrom, this.mIsRedPacketFollow ? RED_PACKET_SOURCE : this.mSource, ext, new FollowActionRequest.FollowActionCallBack() {
            public void onSuccess(FollowActionResult result, int errno) {
                if (AccountAndFollowView.this.mAccountInfo != null && TextUtils.equals(type, AccountAndFollowView.this.mAccountInfo.type) && TextUtils.equals(thirdId, AccountAndFollowView.this.mAccountInfo.thirdId)) {
                    SyncFollowEvent followEvent = new SyncFollowEvent();
                    followEvent.tag = AccountAndFollowView.this.getTag();
                    followEvent.isFollow = true;
                    IVideoEventBusWrapper.Impl.get().post(followEvent);
                }
            }

            public void onFailure(FollowActionResult result) {
                if (AccountAndFollowView.this.mAccountInfo != null && TextUtils.equals(type, AccountAndFollowView.this.mAccountInfo.type) && TextUtils.equals(thirdId, AccountAndFollowView.this.mAccountInfo.thirdId)) {
                    boolean unused = AccountAndFollowView.this.mAccountInfo.isFollowing = false;
                    AccountAndFollowView.this.mFollowProgressBar.setVisibility(8);
                    AccountAndFollowView.this.mActionBtn.setVisibility(0);
                    if (result == null || result.getErrno() != 800200 || TextUtils.isEmpty(result.getErrmsg())) {
                        FollowUtils.showToast(com.baidu.searchbox.follow.R.string.follow_add_failure);
                    } else {
                        FollowUtils.showToast(result.getErrmsg());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateFollowSuccess(Object tag) {
        boolean unused = this.mAccountInfo.isFollowing = false;
        boolean unused2 = this.mAccountInfo.isFollowed = true;
        this.mFollowProgressBar.setVisibility(8);
        this.mActionBtn.setVisibility(0);
        this.mActionBtn.setText(com.baidu.searchbox.follow.R.string.followed);
        this.mActionBtn.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC69));
        this.mActionContainer.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.followed_text_bg));
        if (this.mShowRecommendList && !this.mIsRedPacketFollow) {
            if (this.mRecommendListView.hasRecommendData(this.mAccountInfo.thirdId)) {
                if (getTag() == tag) {
                    if (tag == null) {
                        SyncFollowEvent followEvent = new SyncFollowEvent();
                        followEvent.tag = getTag();
                        followEvent.followOrArrow = 2;
                        IVideoEventBusWrapper.Impl.get().post(followEvent);
                    } else {
                        unfoldRecommendList();
                    }
                }
            } else if (this.mIsFetchingRecommendData) {
                this.mWithinValidTimeAfterFollow = true;
                this.mHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
        this.mShowRedPacket = false;
        if (this.mIsRedPacketFollow) {
            View view2 = this.mRedPacketLayout;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (getTag() == tag) {
                showRedPacketDialog();
            }
        } else if (getTag() == tag) {
            FollowUtils.showToast(com.baidu.searchbox.follow.R.string.follow_add_success);
        }
        FollowEvent followEvent2 = new FollowEvent();
        followEvent2.authorType = this.mAccountInfo.type;
        followEvent2.thirdId = this.mAccountInfo.thirdId;
        followEvent2.isFollow = true;
        IVideoEventBusWrapper.Impl.get().post(followEvent2);
    }

    /* access modifiers changed from: private */
    public void updateUnFollowSuccess(Object tag) {
        boolean unused = this.mAccountInfo.isUnFollowing = false;
        boolean unused2 = this.mAccountInfo.isFollowed = false;
        this.mUnFollowProgressBar.setVisibility(8);
        this.mActionBtn.setVisibility(0);
        this.mActionBtn.setText(com.baidu.searchbox.follow.R.string.follow);
        this.mActionBtn.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC67));
        this.mActionContainer.setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.follow.R.drawable.follow_btn_bg));
        if (this.mArrowContainer.getVisibility() == 0 && tag == getTag()) {
            foldRecommendList();
        }
        this.mShowRedPacket = false;
        this.mIsRedPacketFollow = false;
        FollowEvent followEvent = new FollowEvent();
        followEvent.authorType = this.mAccountInfo.type;
        followEvent.thirdId = this.mAccountInfo.thirdId;
        followEvent.isFollow = false;
        IVideoEventBusWrapper.Impl.get().post(followEvent);
        updateFoldRecommendList(tag);
    }

    /* access modifiers changed from: private */
    public void updateUnfoldRecommendList(Object tag) {
        if (getTag() != tag) {
            this.mArrowContainer.setVisibility(0);
            this.mActionContainer.setTranslationX((float) (-ACTION_BUTTON_SHIFT_LENGTH));
            this.mArrow.setRotation(180.0f);
            this.mArrow.setAlpha(1.0f);
        }
    }

    private void updateFoldRecommendList(Object tag) {
        if (getTag() != tag) {
            this.mArrowContainer.setVisibility(8);
            this.mActionContainer.setTranslationX(0.0f);
            this.mArrow.setRotation(0.0f);
            this.mArrow.setAlpha(0.0f);
        }
    }

    private void showRedPacketDialog() {
        if (this.mAccountInfo != null) {
            RedPacketDialog.showRedPacketDialog(getContext(), this.mAccountInfo.logo, this.mAccountInfo.name, getContext().getResources().getString(com.baidu.searchbox.follow.R.string.follow_red_packet_title), getContext().getResources().getString(com.baidu.searchbox.follow.R.string.follow_redbag_content), this.mAccountInfo.mRedPacketID, this.mAccountInfo.mRedPacketExt, true);
            EventListener eventListener = this.mListener;
            if (eventListener != null) {
                eventListener.onRedPacketShow();
            }
        }
    }

    private void unFollow() {
        boolean unused = this.mAccountInfo.isUnFollowing = true;
        final String type = this.mAccountInfo.type;
        final String thirdId = this.mAccountInfo.thirdId;
        String str = this.mSfrom;
        if (str == null) {
            str = "sbox";
        }
        String sFrom = str;
        String ext = this.mExt;
        if (ext == null) {
            ext = null;
        }
        FollowActionRequest.getFollowAction(FollowRuntime.getAppContext(), type, thirdId, false, sFrom, this.mIsRedPacketFollow ? RED_PACKET_SOURCE : this.mSource, ext, new FollowActionRequest.FollowActionCallBack() {
            public void onSuccess(FollowActionResult result, int errno) {
                if (AccountAndFollowView.this.mAccountInfo != null && TextUtils.equals(type, AccountAndFollowView.this.mAccountInfo.type) && TextUtils.equals(thirdId, AccountAndFollowView.this.mAccountInfo.thirdId)) {
                    UniversalToast.makeText(AccountAndFollowView.this.getContext(), com.baidu.searchbox.follow.R.string.follow_remove_success).showToast();
                    SyncFollowEvent followEvent = new SyncFollowEvent();
                    followEvent.tag = AccountAndFollowView.this.getTag();
                    followEvent.isFollow = false;
                    IVideoEventBusWrapper.Impl.get().post(followEvent);
                }
            }

            public void onFailure(FollowActionResult result) {
                if (AccountAndFollowView.this.mAccountInfo != null && TextUtils.equals(type, AccountAndFollowView.this.mAccountInfo.type) && TextUtils.equals(thirdId, AccountAndFollowView.this.mAccountInfo.thirdId)) {
                    boolean unused = AccountAndFollowView.this.mAccountInfo.isUnFollowing = false;
                    AccountAndFollowView.this.mUnFollowProgressBar.setVisibility(8);
                    AccountAndFollowView.this.mActionBtn.setVisibility(0);
                }
            }
        });
    }

    private void fetchRecommendData() {
        AccountInfo accountInfo;
        if (!this.mIsFetchingRecommendData && (accountInfo = this.mAccountInfo) != null && !this.mRecommendListView.hasRecommendData(accountInfo.thirdId)) {
            this.mIsFetchingRecommendData = true;
            this.mWithinValidTimeAfterFollow = true;
            this.mHandler.sendEmptyMessageDelayed(0, 1000);
            new RelatedRecommendRequest().requestRelatedRecommendList(FollowRuntime.getAppContext(), this.mAccountInfo.type, this.mAccountInfo.thirdId, this.mNid, new RequestRecommendCallback());
        }
    }

    public void setShowRecommendList(boolean showRecommendList) {
        if (this.mShowRecommendListOnly) {
            this.mShowRecommendList = true;
        } else {
            this.mShowRecommendList = showRecommendList;
        }
    }

    public void ubcFollowShow() {
        String str;
        if (!this.mUBCIconShow) {
            HashMap<String, String> extInfo = new HashMap<>();
            extInfo.putAll(this.mUBCExtInfo);
            AccountInfo accountInfo = this.mAccountInfo;
            if (accountInfo != null) {
                if (accountInfo.isFollowed) {
                    str = "1";
                } else {
                    str = "0";
                }
                extInfo.put("btn_type", str);
            }
            FollowUtils.followEvent(StatisticConstants.UBC_FOLLOW_EVENT_ID, this.mIsRedPacketFollow ? FollowConstant.UBC_TYPE_PAGESHOW_REDFOLLOW : FollowConstant.UBC_TYPE_PAGESHOW_FOLLOWBTN, (String) null, this.mUbcValue, (Map<String, String>) extInfo);
            this.mUBCIconShow = true;
        }
    }

    public static class AccountInfo {
        /* access modifiers changed from: private */
        public String cmd;
        /* access modifiers changed from: private */
        public String intro;
        /* access modifiers changed from: private */
        public boolean isAuthorLive;
        /* access modifiers changed from: private */
        public boolean isFollowed;
        /* access modifiers changed from: private */
        public boolean isFollowing = false;
        /* access modifiers changed from: private */
        public boolean isUnFollowing = false;
        /* access modifiers changed from: private */
        public String logo;
        /* access modifiers changed from: private */
        public String mLiveCmd;
        /* access modifiers changed from: private */
        public int mRedPacketClass;
        /* access modifiers changed from: private */
        public String mRedPacketExt;
        /* access modifiers changed from: private */
        public String mRedPacketID;
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public String thirdId;
        /* access modifiers changed from: private */
        public String type;
        /* access modifiers changed from: private */
        public String typeId;
        /* access modifiers changed from: private */
        public String vipType;

        public void setRedPacketClass(int redPacketClass) {
            this.mRedPacketClass = redPacketClass;
        }

        public void setRedPacketID(String redPacketID) {
            this.mRedPacketID = redPacketID;
        }

        public void setRedPacketExt(String redPacketExt) {
            this.mRedPacketExt = redPacketExt;
        }

        public AccountInfo(String type2, String typeId2, String thirdId2, String logo2, String vipType2, String name2, String intro2, String cmd2, boolean isFollowed2, boolean isAuthorLive2, String liveCmd) {
            this.type = type2;
            this.typeId = typeId2;
            this.thirdId = thirdId2;
            this.logo = logo2;
            this.vipType = vipType2;
            this.name = name2;
            this.intro = intro2;
            this.cmd = cmd2;
            this.isFollowed = isFollowed2;
            this.isAuthorLive = isAuthorLive2;
            this.mLiveCmd = liveCmd;
        }
    }

    public void setListener(EventListener listener) {
        this.mListener = listener;
    }

    public void setRecommendListListener(RecommendListListener listener) {
        this.mRecommendListListener = listener;
    }

    public static void saveRecommendData(String key) {
        sRecommendDataContainer.put(key, true);
    }

    public static boolean hasRecommendData(String key) {
        return sRecommendDataContainer.get(key) != null && sRecommendDataContainer.get(key).booleanValue();
    }

    /* access modifiers changed from: private */
    public void onShowRecommendView() {
        if (isNeedScrollUp()) {
            invokeFloatFollowClick(false);
        } else {
            onTriggerFloatDialog();
        }
    }

    private boolean isNeedScrollUp() {
        if (getTag() != null || this.mRecommendListIsEmpty) {
            return false;
        }
        return true;
    }

    private void invokeFloatFollowClick(boolean isFollow) {
        if (this.mScrollOffsetListener != null) {
            this.mScrollOffsetListener.scrollYOffset(getBottom());
        }
    }

    public void onTriggerFloatDialog() {
        this.mRecommendFloatingView.addFloatingClickListener((RelatedRecommendFloatContainer.OnFloatingClickListener) null);
        this.mRecommendFloatingView.addFloatingClickListener(new RelatedRecommendFloatContainer.OnFloatingClickListener() {
            public void onDismiss() {
                AccountAndFollowView.this.onDismissRecommendView();
            }
        });
        if (this.mRecommendFloatingView.isShowing()) {
            this.mRecommendFloatingView.dismiss();
        }
        this.mRecommendFloatingView.showAsDropDown(this.mTopView);
        if (this.mClickFollow) {
            this.mRecommendFloatingView.resetRecommendStatus();
        }
        this.mRecommendFloatingView.updateNightUi();
    }

    public void onDismissRecommendView() {
        if (this.mRecommendFloatingView != null) {
            if (isFollowed()) {
                resetArrowRotation();
            } else {
                this.mArrowContainer.setVisibility(8);
            }
            if (this.mRecommendFloatingView.isShowing()) {
                hideRecommendListWithAnimation();
                this.mRecommendFloatingView.dismiss();
            }
        }
    }

    public void resetArrowRotation() {
        if (((double) this.mArrow.getRotation()) != 180.0d) {
            rotateArrow(false);
        }
    }

    public void setArrowUp() {
        if (this.mArrow.getRotation() != 0.0f) {
            this.mArrow.setRotation(0.0f);
        }
    }

    public void performClickByView() {
        if (getAccountInfo() != null && getAccountInfo().isFollowed) {
            this.mArrowContainer.performClick();
        } else {
            this.mActionContainer.performClick();
        }
    }

    public AccountInfo getAccountInfo() {
        return this.mAccountInfo;
    }

    private boolean getShowRedPacket() {
        return this.mShowRedPacket;
    }

    public boolean isFollowed() {
        TextView textView = this.mActionBtn;
        if (textView == null || textView.getVisibility() != 0 || !TextUtils.equals(this.mActionBtn.getText().toString(), getContext().getString(com.baidu.searchbox.follow.R.string.followed))) {
            return false;
        }
        return true;
    }

    public void addOnScrollOffsetListener(OnScrollOffsetListener scrollOffsetListener) {
        this.mScrollOffsetListener = scrollOffsetListener;
    }

    public void invalidateImage() {
        SimpleDraweeView simpleDraweeView = this.mPortrait;
        if (simpleDraweeView != null) {
            simpleDraweeView.invalidate();
        }
    }

    public void updateHaveRecommendList(boolean empty) {
        this.mRecommendListIsEmpty = empty;
    }

    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
        resetStatus();
    }

    private static class RequestRecommendCallback implements Callback<List<IFollowRecommendItem>> {
        private WeakReference<AccountAndFollowView> mFollowViewWeakReference;

        private RequestRecommendCallback(AccountAndFollowView followView) {
            this.mFollowViewWeakReference = new WeakReference<>(followView);
        }

        public void onSuccess(List<IFollowRecommendItem> response) {
            final AccountAndFollowView followView = (AccountAndFollowView) this.mFollowViewWeakReference.get();
            if (followView != null && response != null && followView.mHandler != null && followView.mRecommendListView != null) {
                AccountAndFollowView.saveRecommendData(followView.mAccountInfo == null ? "" : followView.mAccountInfo.thirdId);
                RelatedRecommendDataManager.setInitItemList(response);
                RelatedRecommendDataManager.getNextRelatedRecommends(10, new RelatedRecommendDataManager.IFetchCallback() {
                    public void handleData(List<IFollowRecommendItem> itemList) {
                        followView.mRecommendListView.setData(itemList);
                        if (followView.mRecommendListListener != null) {
                            String thirdId = "";
                            if (followView.mAccountInfo != null) {
                                thirdId = followView.mAccountInfo.thirdId;
                            }
                            if (followView.mRecommendListView.hasRecommendData(thirdId)) {
                                followView.mRecommendListListener.onDataShow();
                            } else {
                                followView.mRecommendListListener.onDataEmpty();
                            }
                        }
                        followView.mHandler.sendEmptyMessage(1);
                        boolean unused = followView.mIsFetchingRecommendData = false;
                    }
                });
            } else if (followView != null && followView.mHandler != null) {
                followView.mHandler.sendEmptyMessage(1);
                boolean unused = followView.mIsFetchingRecommendData = false;
            }
        }

        public void onFailure() {
            AccountAndFollowView followView = (AccountAndFollowView) this.mFollowViewWeakReference.get();
            if (followView != null && followView.mHandler != null) {
                followView.mHandler.sendEmptyMessage(1);
                boolean unused = followView.mIsFetchingRecommendData = false;
                String third = "";
                if (followView.mAccountInfo != null) {
                    third = followView.mAccountInfo.thirdId;
                }
                if (followView.mRecommendListListener != null && followView.mRecommendListView != null && !followView.mRecommendListView.hasRecommendData(third)) {
                    followView.mRecommendListListener.onDataEmpty();
                }
            }
        }

        public void onNetworkException() {
            AccountAndFollowView followView = (AccountAndFollowView) this.mFollowViewWeakReference.get();
            if (followView != null && followView.mHandler != null) {
                followView.mHandler.sendEmptyMessage(1);
                boolean unused = followView.mIsFetchingRecommendData = false;
                if (followView.mRecommendListListener != null && followView.mRecommendListView != null) {
                    if (!followView.mRecommendListView.hasRecommendData(followView.mAccountInfo == null ? "" : followView.mAccountInfo.thirdId)) {
                        followView.mRecommendListListener.onDataEmpty();
                    }
                }
            }
        }
    }
}
