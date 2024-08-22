package com.baidu.searchbox.video.detail.plugin.component.right.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.event.LandScapeVideoLikeEvent;
import com.baidu.searchbox.feed.event.VideoContinuePlayEvent;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.follow.button.FollowStatusManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.minivideo.util.MiniVideoStaisticUtils;
import com.baidu.searchbox.praise.triplepraiseinterface.TripleConstantsKt;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseCallBackHandler;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseData;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseInterface;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseRuntime;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.searchbox.reward.BoxRewardManager;
import com.baidu.searchbox.reward.model.RewardModel;
import com.baidu.searchbox.screenshot.SystemScreenshotShareUBC;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.controller.TriplePraiseGuidanceManager;
import com.baidu.searchbox.video.detail.controller.TriplePraiseGuidanceManagerKt;
import com.baidu.searchbox.video.detail.core.model.VideoDetailModel;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.export.IVideoBaiduIdentityManager;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper;
import com.baidu.searchbox.video.detail.export.IVideoRouter;
import com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils;
import com.baidu.searchbox.video.detail.export.IVideoSender;
import com.baidu.searchbox.video.detail.model.ShareSource;
import com.baidu.searchbox.video.detail.plugin.component.author.model.AuthorModel;
import com.baidu.searchbox.video.detail.plugin.component.reward.api.IRewardAbilityProvider;
import com.baidu.searchbox.video.detail.plugin.component.reward.api.IRewardButtonContainer;
import com.baidu.searchbox.video.detail.plugin.component.reward.listener.RewardListener;
import com.baidu.searchbox.video.detail.plugin.component.right.model.ButtonType;
import com.baidu.searchbox.video.detail.plugin.component.right.model.VideoDetailInfoModel;
import com.baidu.searchbox.video.detail.service.IFavorService;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.detail.utils.VideoDetailUbcExtUtils;
import com.baidu.searchbox.video.detail.utils.VideoLikeUtils;
import com.baidu.searchbox.video.detail.utils.VideoUrlConfig;
import com.baidu.searchbox.video.utils.VideoLoginUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.Action1;

public class TopInfoShareConfigLayout extends ConstraintLayout implements IRewardButtonContainer {
    private static final int BOTTOM_MARGIN = IVideoScreenInfoUtils.Impl.get().dp2px(3.0f);
    private static final int HORIZONTAL_MARGIN = IVideoScreenInfoUtils.Impl.get().dp2px(15.0f);
    private static final String LOGIN_SOURCE = "FEED_VIDEO_LANDING_PAGE";
    private static final String POSITION_SPLIT = "-";
    private static final String SOURCE_FROM = "feedsvideo";
    private static final int STAR = 2;
    private static final int TOP_MARGIN = IVideoScreenInfoUtils.Impl.get().dp2px(12.0f);
    private static final String TRIPLE_PRAISE_ALIGN = "LEFT";
    private static final String TRIPLE_PRAISE_SOURCE = "sv_onekeytriple";
    private static final int TRIPLE_PRAISE_TYPE = 1;
    private static final String TYPE_WECAHT_FRI = "weixin_friend";
    private static final String TYPE_WECAHT_TIMELINE = "weixin_timeline";
    private ViewGroup mBubbleViewParent;
    private CommentListener mCommentListener;
    private HashMap<VideoDetailInfoModel.TopInfoInteractBtn, LinearLayout> mCustomContainerMap;
    /* access modifiers changed from: private */
    public FavorListener mFavorListener;
    private LinearLayout mFriendContainer;
    protected SimpleDraweeView mFriendIcon;
    private VideoDetailInfoModel.TopInfoInteractBtn mFriendModel;
    private TextView mFriendText;
    private boolean mHasComment;
    private boolean mHasRewardButtonShown;
    /* access modifiers changed from: private */
    public boolean mHasShowGuidePlay;
    private boolean mIsRewardButtonClicked;
    private boolean mIsRewardButtonShowing;
    /* access modifiers changed from: private */
    public LinearLayout mLikeContainer;
    /* access modifiers changed from: private */
    public CoolPraiseView mLikeLayout;
    /* access modifiers changed from: private */
    public LikeStateListener mLikeStateListener;
    private Handler mMainHandler;
    private IRewardAbilityProvider mRewardAbilityProvider;
    private RewardListener mRewardListener;
    private ShareListener mShareListener;
    /* access modifiers changed from: private */
    public boolean mTripleFollowSuccess;
    TriplePraiseData mTriplePraiseData;
    /* access modifiers changed from: private */
    public TriplePraiseInterface mTriplePraiseManager;
    Runnable mTriplePraiseRunnable;
    /* access modifiers changed from: private */
    public boolean mTriplePraiseSuccess;
    private LinearLayout mUnLikeContainer;
    /* access modifiers changed from: private */
    public ImageView mUnlikeIcon;
    /* access modifiers changed from: private */
    public TextView mUnlikeText;
    /* access modifiers changed from: private */
    public VideoDetailInfoModel mVideoDetailInfoModel;
    protected String mVideoInfo;
    private LinearLayout mWeiXinContainer;
    protected SimpleDraweeView mWeiXinIcon;
    private VideoDetailInfoModel.TopInfoInteractBtn mWeiXinModel;
    private TextView mWeiXinText;

    public interface CommentListener {
        void addComment(CommentModel commentModel);
    }

    public interface FavorListener {
        void addFavor(String str, IFavorService.IFavorResultCallback iFavorResultCallback);

        void queryFavor(IFavorService.IFavorResultCallback iFavorResultCallback);
    }

    public interface FavorResultCallback {
        void onResult(boolean z);
    }

    public interface LikeStateListener {
        void processLike(Map<String, Object> map);

        void processReport();
    }

    public interface ShareLayoutClickListener {
        void onClick(View view2, int i2, boolean z);
    }

    public interface ShareListener {
        void share(String str, ShareSource shareSource);
    }

    public TopInfoShareConfigLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TopInfoShareConfigLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopInfoShareConfigLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mHasShowGuidePlay = false;
        this.mTriplePraiseManager = TriplePraiseRuntime.get();
        this.mHasComment = false;
        this.mTriplePraiseRunnable = new Runnable() {
            public void run() {
                if (TopInfoShareConfigLayout.this.mTriplePraiseData != null) {
                    TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                    topInfoShareConfigLayout.updateTriplePraiseUIByType(topInfoShareConfigLayout.mTriplePraiseData);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 17) {
            generateViewId();
        }
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public void setRewardAbilityProvider(IRewardAbilityProvider provider) {
        this.mRewardAbilityProvider = provider;
    }

    public void setData(VideoDetailInfoModel videoDetailInfoModel, String videoInfo) {
        if (IVideoAppConfig.Impl.get().isTeenager()) {
            setVisibility(8);
            return;
        }
        resetButtonStatus();
        this.mVideoDetailInfoModel = videoDetailInfoModel;
        this.mVideoInfo = videoInfo;
        removeAllViews();
        if (this.mVideoDetailInfoModel.mInteractBtnList == null || this.mVideoDetailInfoModel.mInteractBtnList.size() == 0) {
            setPadding(0, BOTTOM_MARGIN, 0, 0);
            return;
        }
        createInteractBtn(this.mVideoDetailInfoModel.mInteractBtnList);
        if (getChildCount() > 0) {
            layoutViews();
            updateNightMode(NightModeHelper.getNightModeSwitcherState());
        }
    }

    private void createInteractBtn(ArrayList<VideoDetailInfoModel.TopInfoInteractBtn> interactBtnList) {
        Iterator<VideoDetailInfoModel.TopInfoInteractBtn> it = interactBtnList.iterator();
        while (it.hasNext()) {
            VideoDetailInfoModel.TopInfoInteractBtn model = it.next();
            if (model != null && !TextUtils.isEmpty(model.mType)) {
                switch (AnonymousClass17.$SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType[ButtonType.getType(model.mType.toUpperCase(Locale.US)).ordinal()]) {
                    case 1:
                        createLikeView();
                        setLikeViewData();
                        break;
                    case 2:
                        createUnlikeView();
                        setUnLikeViewData(model);
                        break;
                    case 3:
                        createWeiXinView(model);
                        break;
                    case 4:
                        createWxFriendView(model);
                        break;
                    case 5:
                        if (TextUtils.isEmpty(model.mText)) {
                            break;
                        } else {
                            this.mIsRewardButtonShowing = true;
                            onRewardVideoUBC("article_show");
                            createCustomView(model);
                            break;
                        }
                    default:
                        if (TextUtils.isEmpty(model.mText)) {
                            break;
                        } else {
                            createCustomView(model);
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: com.baidu.searchbox.video.detail.plugin.component.right.ui.TopInfoShareConfigLayout$17  reason: invalid class name */
    static /* synthetic */ class AnonymousClass17 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType;

        static {
            int[] iArr = new int[ButtonType.values().length];
            $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType = iArr;
            try {
                iArr[ButtonType.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType[ButtonType.FEEDBACK.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType[ButtonType.WECHAT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType[ButtonType.MOMENTS.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType[ButtonType.REWARD.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$video$detail$plugin$component$right$model$ButtonType[ButtonType.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private void createLikeView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.video_detail_top_info_like, this, false);
        this.mLikeContainer = linearLayout;
        addView(linearLayout);
        CoolPraiseView coolPraiseView = (CoolPraiseView) this.mLikeContainer.findViewById(R.id.custom_praise);
        this.mLikeLayout = coolPraiseView;
        coolPraiseView.setPraiseStateIconRes(R.drawable.video_detail_like_up_normal, R.drawable.video_detail_like_up_clicked);
        this.mLikeLayout.setPraiseStateTextRes(com.baidu.android.common.ui.style.R.color.GC1, com.baidu.android.common.ui.style.R.color.GC8);
        if (this.mVideoDetailInfoModel.mTriplePraiseSwitchEnabled) {
            this.mLikeLayout.setLongPressListener(new CoolPraiseView.LongPressListener() {
                public void onLongPressStart() {
                    if (TopInfoShareConfigLayout.this.mFavorListener != null) {
                        TopInfoShareConfigLayout.this.mFavorListener.queryFavor(new IFavorService.IFavorResultCallback() {
                            public void onResult(boolean result) {
                                int toast;
                                if (!result || !TopInfoShareConfigLayout.this.mVideoDetailInfoModel.isLike || !TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mIsFollow) {
                                    TopInfoShareConfigLayout.this.requestTriplePraise();
                                    return;
                                }
                                if (new Random().nextBoolean()) {
                                    toast = com.baidu.searchbox.praise.triplepraiseinterface.R.string.triplePraise_trigger_again_first;
                                } else {
                                    toast = com.baidu.searchbox.praise.triplepraiseinterface.R.string.triplePraise_trigger_again_second;
                                }
                                UniversalToast.makeText(TopInfoShareConfigLayout.this.getContext(), (CharSequence) TopInfoShareConfigLayout.this.getResources().getString(toast)).show();
                            }
                        });
                    }
                }

                public void onLongPressCancel() {
                    TopInfoShareConfigLayout.this.mTriplePraiseManager.handleLongPressCancel();
                }
            });
            registerFollowEvent();
            registerTriplePraiseGuidanceScrollEvent();
        }
    }

    /* access modifiers changed from: private */
    public void requestTriplePraise() {
        this.mTriplePraiseManager.play(getContext(), getTriplePraiseParams(), new TriplePraiseCallBackHandler() {
            public void handleResponse(TriplePraiseData data) {
                VideoDetailUbcExtUtils.uploadTriplePraiseUbc(false, 0, TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mNid);
                TriplePraiseGuidanceManager.INSTANCE.updateUserTriplePraiseStatus(TriplePraiseGuidanceManagerKt.VIDEO_LANDING_PAGE, true);
                TopInfoShareConfigLayout.this.mTriplePraiseData = data;
                TopInfoShareConfigLayout.this.updateTriplePraiseUI();
            }

            public void handleTriplePraiseAnimReverse() {
                VideoDetailUbcExtUtils.uploadTriplePraiseUbc(true, 0, TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mNid);
            }

            public void handleTriplePraiseAnimEnd() {
            }
        });
    }

    private void registerTriplePraiseGuidanceScrollEvent() {
        RecyclerView recyclerView = getRecyclerView();
        this.mBubbleViewParent = getBubbleViewParent(recyclerView);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    TriplePraiseGuidanceManager.INSTANCE.updateBubblePosIfNeeded(TopInfoShareConfigLayout.this.mLikeContainer);
                }
            });
        }
        this.mLikeContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                TriplePraiseGuidanceManager.INSTANCE.updateBubblePosIfNeeded(TopInfoShareConfigLayout.this.mLikeContainer);
            }
        });
    }

    private ViewGroup getBubbleViewParent(RecyclerView recyclerView) {
        ViewGroup recyclerViewParent;
        if (recyclerView == null || (recyclerViewParent = (ViewGroup) recyclerView.getParent()) == null) {
            return null;
        }
        return (ViewGroup) recyclerViewParent.getParent();
    }

    private RecyclerView getRecyclerView() {
        ViewParent parent = getParent();
        while (parent != null && !(parent.getParent() instanceof RecyclerView)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            return (RecyclerView) parent.getParent();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void updateTriplePraiseUI() {
        this.mMainHandler.post(this.mTriplePraiseRunnable);
    }

    /* access modifiers changed from: private */
    public void updateTriplePraiseUIByType(TriplePraiseData data) {
        TriplePraiseInterface triplePraiseInterface;
        this.mTripleFollowSuccess = data.isFollow();
        this.mTriplePraiseSuccess = data.isPraise();
        if (data.isPraise()) {
            updateLikeUIAfterTriplePraise();
        }
        if (data.isFollow()) {
            updateFollowUIAfterTriplePraise();
        }
        if (VideoLoginUtils.isLogin() || (triplePraiseInterface = this.mTriplePraiseManager) == null) {
            FavorListener favorListener = this.mFavorListener;
            if (favorListener != null) {
                favorListener.queryFavor(new IFavorService.IFavorResultCallback() {
                    public void onResult(boolean result) {
                        if (!result) {
                            TopInfoShareConfigLayout.this.updateFavorUIAfterTriplePraise();
                        } else if (TopInfoShareConfigLayout.this.mTriplePraiseManager != null) {
                            TopInfoShareConfigLayout.this.mTriplePraiseManager.showTriplePraiseToast(TopInfoShareConfigLayout.this.mTriplePraiseSuccess, true, TopInfoShareConfigLayout.this.mTripleFollowSuccess);
                        }
                    }
                });
                return;
            }
            return;
        }
        triplePraiseInterface.showTriplePraiseToast(this.mTriplePraiseSuccess, false, this.mTripleFollowSuccess);
    }

    /* access modifiers changed from: private */
    public void updateFavorUIAfterTriplePraise() {
        FavorListener favorListener = this.mFavorListener;
        if (favorListener != null) {
            favorListener.addFavor(TripleConstantsKt.TRIPLE_FAVOR_UBC_SOURCE, new IFavorService.IFavorResultCallback() {
                public void onResult(boolean result) {
                    if (TopInfoShareConfigLayout.this.mTriplePraiseManager != null) {
                        TopInfoShareConfigLayout.this.mTriplePraiseManager.showTriplePraiseToast(TopInfoShareConfigLayout.this.mTriplePraiseSuccess, result, TopInfoShareConfigLayout.this.mTripleFollowSuccess);
                    }
                }
            });
        }
    }

    private void updateLikeUIAfterTriplePraise() {
        VideoDetailInfoModel videoDetailInfoModel = this.mVideoDetailInfoModel;
        if (videoDetailInfoModel != null && !videoDetailInfoModel.isLike) {
            this.mLikeLayout.performClick();
        }
    }

    private void updateFollowUIAfterTriplePraise() {
        String thirdId = this.mVideoDetailInfoModel.mFollowObj.optString("third_id");
        String type = this.mVideoDetailInfoModel.mFollowObj.optString("type");
        if (!TextUtils.isEmpty(thirdId) && !TextUtils.isEmpty(type)) {
            this.mVideoDetailInfoModel.mIsFollow = true;
            FollowStatusManager.INSTANCE.postFollowStatus(getContext(), type, thirdId, this.mVideoDetailInfoModel.mIsFollow);
        }
    }

    private void registerFollowEvent() {
        DataChannel.Registry.registerNAReceiver("", "", "com.baidu.channel.foundation.followchanged", new NAReceiverCallback() {
            public void onReceive(String action, String params) {
                try {
                    JSONArray array = new JSONObject(params).optJSONArray("data");
                    if (array != null) {
                        int length = array.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jsonObject = array.optJSONObject(i2);
                            if (jsonObject != null) {
                                String isFollow = jsonObject.optString("is_follow");
                                if (!TextUtils.isEmpty(isFollow)) {
                                    TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mIsFollow = TextUtils.equals(isFollow, "1");
                                }
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private HashMap<String, String> getTriplePraiseParams() {
        String positions = getTriplePraisePopPositions();
        String extParams = parseExtParams();
        HashMap<String, String> params = new HashMap<>();
        if (TextUtils.isEmpty(positions) || TextUtils.isEmpty(extParams)) {
            return params;
        }
        params.put("positions", positions);
        params.put("type", "4");
        params.put(ConstPath.KEY_ALIGN, "LEFT");
        params.put("loginSource", LOGIN_SOURCE);
        params.put("ext", extParams);
        return params;
    }

    private String getTriplePraisePopPositions() {
        int[] locations = new int[2];
        this.mLikeContainer.getLocationOnScreen(locations);
        return "" + locations[0] + "-" + locations[1] + "-" + this.mLikeContainer.getWidth() + "-" + this.mLikeContainer.getHeight();
    }

    private String parseExtParams() {
        try {
            JSONObject extParams = new JSONObject();
            JSONObject metaObj = new JSONObject();
            JSONObject praiseObj = new JSONObject();
            new JSONObject(this.mVideoDetailInfoModel.mLikeExt);
            praiseObj.put("id", this.mVideoDetailInfoModel.mNid);
            praiseObj.put("sfrom", SOURCE_FROM);
            int i2 = 0;
            praiseObj.put("status", this.mVideoDetailInfoModel.isLike ? 1 : 0);
            praiseObj.put("source", TRIPLE_PRAISE_SOURCE);
            metaObj.put("praise", praiseObj);
            JSONObject followObj = this.mVideoDetailInfoModel.mFollowObj;
            followObj.put("sfrom", SOURCE_FROM);
            if (this.mVideoDetailInfoModel.mIsFollow) {
                i2 = 1;
            }
            followObj.put("status", i2);
            followObj.put("source", TRIPLE_PRAISE_SOURCE);
            metaObj.put("follow", followObj);
            String cuid = BaiduIdentityManager.getInstance().getUid();
            extParams.put("meta", metaObj);
            extParams.put("id", this.mVideoDetailInfoModel.mNid);
            extParams.put("cuid", cuid);
            extParams.put("type", 1);
            return extParams.toString();
        } catch (Exception e2) {
            if (!IVideoAppConfig.Impl.get().isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    private void createUnlikeView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.video_detail_top_info_unlike, this, false);
        this.mUnLikeContainer = linearLayout;
        addView(linearLayout);
        this.mUnlikeIcon = (ImageView) this.mUnLikeContainer.findViewById(R.id.video_detail_unlike_icon);
        this.mUnlikeText = (TextView) this.mUnLikeContainer.findViewById(R.id.video_detail_unlike_text);
    }

    private void createWeiXinView(VideoDetailInfoModel.TopInfoInteractBtn model) {
        this.mWeiXinModel = model;
        this.mWeiXinContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.video_detail_top_info_common, this, false);
        if (Build.VERSION.SDK_INT >= 17) {
            this.mWeiXinContainer.setId(generateViewId());
        }
        addView(this.mWeiXinContainer);
        this.mWeiXinText = (TextView) this.mWeiXinContainer.findViewById(R.id.video_detail_share_text);
        this.mWeiXinText.setText(TextUtils.isEmpty(model.mText) ? getResources().getString(R.string.feed_video_detail_top_share_weixin) : model.mText);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) this.mWeiXinContainer.findViewById(R.id.video_detail_share_icon);
        this.mWeiXinIcon = simpleDraweeView;
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setUseGlobalColorFilter(false);
        this.mWeiXinContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                topInfoShareConfigLayout.showShare("weixin_friend", topInfoShareConfigLayout.mVideoInfo);
            }
        });
        this.mWeiXinContainer.setVisibility(0);
        if (!TextUtils.isEmpty(model.mIcon)) {
            this.mWeiXinIcon.setImageURI(model.mIcon);
        } else {
            this.mWeiXinIcon.setImageResource(R.drawable.video_detail_share_weixin_img_selector);
        }
        if (!this.mVideoDetailInfoModel.mIsUploadShareShow) {
            this.mVideoDetailInfoModel.mIsUploadShareShow = true;
            VideoDetailUbcExtUtils.uploadIconClickUBC(SystemScreenshotShareUBC.SCREENSHOT_TYPE_FLOAT_SHARE_SHOW, this.mVideoInfo, (String[]) null, (String) null, "videoChannel", "");
        }
    }

    private void createWxFriendView(VideoDetailInfoModel.TopInfoInteractBtn model) {
        this.mFriendModel = model;
        this.mFriendContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.video_detail_top_info_common, this, false);
        if (Build.VERSION.SDK_INT >= 17) {
            this.mFriendContainer.setId(generateViewId());
        }
        addView(this.mFriendContainer);
        this.mFriendText = (TextView) this.mFriendContainer.findViewById(R.id.video_detail_share_text);
        this.mFriendText.setText(TextUtils.isEmpty(model.mText) ? getResources().getString(R.string.feed_video_detail_top_share_timeline) : model.mText);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) this.mFriendContainer.findViewById(R.id.video_detail_share_icon);
        this.mFriendIcon = simpleDraweeView;
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setUseGlobalColorFilter(false);
        this.mFriendContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                topInfoShareConfigLayout.showShare("weixin_timeline", topInfoShareConfigLayout.mVideoInfo);
            }
        });
        if (!TextUtils.isEmpty(model.mIcon)) {
            this.mFriendIcon.setImageURI(model.mIcon);
        } else {
            this.mFriendIcon.setImageResource(R.drawable.video_detail_share_friend_img_selector);
        }
        this.mFriendContainer.setVisibility(0);
        if (!this.mVideoDetailInfoModel.mIsUploadShareShow) {
            this.mVideoDetailInfoModel.mIsUploadShareShow = true;
            VideoDetailUbcExtUtils.uploadIconClickUBC(SystemScreenshotShareUBC.SCREENSHOT_TYPE_FLOAT_SHARE_SHOW, this.mVideoInfo, (String[]) null, (String) null, "videoChannel", "");
        }
    }

    private void createCustomView(final VideoDetailInfoModel.TopInfoInteractBtn model) {
        LinearLayout customContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.video_detail_top_info_common, this, false);
        if (Build.VERSION.SDK_INT >= 17) {
            customContainer.setId(generateViewId());
        }
        addView(customContainer);
        if (this.mCustomContainerMap == null) {
            this.mCustomContainerMap = new HashMap<>();
        }
        this.mCustomContainerMap.put(model, customContainer);
        SimpleDraweeView customImageView = (SimpleDraweeView) customContainer.findViewById(R.id.video_detail_share_icon);
        ((GenericDraweeHierarchy) customImageView.getHierarchy()).setUseGlobalColorFilter(false);
        ((TextView) customContainer.findViewById(R.id.video_detail_share_text)).setText(model.mText);
        customImageView.setImageURI(model.mIcon);
        customContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.equals(model.mType, ButtonType.REWARD.getName())) {
                    TopInfoShareConfigLayout.this.showRewardPanel();
                } else {
                    IVideoRouter.Impl.get().invoke(TopInfoShareConfigLayout.this.getContext(), model.mCmd);
                }
                String str = TopInfoShareConfigLayout.this.mVideoInfo;
                TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                VideoDetailUbcExtUtils.uploadIconClickUBC(model.mIconName + "_clk", str, (String[]) null, topInfoShareConfigLayout.getUBCPage(topInfoShareConfigLayout.mVideoDetailInfoModel));
            }
        });
        VideoDetailUbcExtUtils.uploadIconClickUBC(model.mIconName + MiniVideoStaisticUtils.MINI_VIDEO_TYPE_SHOW, this.mVideoInfo, (String[]) null, getUBCPage(this.mVideoDetailInfoModel));
    }

    private void setLikeViewData() {
        CoolPraiseView coolPraiseView = this.mLikeLayout;
        if (coolPraiseView != null) {
            coolPraiseView.disablePraiseAnimation(this.mVideoDetailInfoModel.isUnlike);
            CoolPraiseView.OnClickPraiseListener likeListener = new CoolPraiseView.OnClickPraiseListener() {
                public void onClick(boolean isPraised, int praiseCount) {
                    String str;
                    if (TopInfoShareConfigLayout.this.mVideoDetailInfoModel.isUnlike) {
                        UniversalToast.makeText(TopInfoShareConfigLayout.this.getContext(), com.baidu.searchbox.feed.core.R.string.feed_disliked_tip).showToast();
                    } else {
                        TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                        topInfoShareConfigLayout.processLike(topInfoShareConfigLayout.mLikeLayout, TopInfoShareConfigLayout.this.mVideoDetailInfoModel);
                        if (TopInfoShareConfigLayout.this.mLikeStateListener != null) {
                            Map<String, Object> params = new HashMap<>();
                            params.put("nid", TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mNid);
                            if (TopInfoShareConfigLayout.this.mLikeLayout.getIsPraisedState()) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            params.put("type", str);
                            params.put("ext", TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mLikeExt);
                            TopInfoShareConfigLayout.this.mLikeStateListener.processLike(params);
                        }
                        IVideoEventBusWrapper.Impl.get().post(new VideoContinuePlayEvent(false));
                        TopInfoShareConfigLayout topInfoShareConfigLayout2 = TopInfoShareConfigLayout.this;
                        VideoDetailUbcExtUtils.uploadIconClickUBC(FeedStatisticConstants.UBC_TYPE_VALUE_LIKE, TopInfoShareConfigLayout.this.mVideoInfo, new String[]{"0"}, topInfoShareConfigLayout2.getUBCPage(topInfoShareConfigLayout2.mVideoDetailInfoModel));
                        if (TopInfoShareConfigLayout.this.mHasShowGuidePlay) {
                            TopInfoShareConfigLayout.this.mLikeLayout.cancelGuidePlay();
                            ControlShowManager.getInstance().setCycleTimeNoShow();
                        }
                    }
                    TopInfoShareConfigLayout.this.updateLikeUi();
                }
            };
            this.mLikeLayout.setPraise(this.mVideoDetailInfoModel.isLike);
            sendLikeDataToDataChannel(getContext(), isStar(this.mVideoDetailInfoModel) ? this.mVideoDetailInfoModel.mFeedId : this.mVideoDetailInfoModel.mNid, String.valueOf(this.mVideoDetailInfoModel.mLikeNum), this.mVideoDetailInfoModel.isLike);
            this.mLikeLayout.setPraiseCount(this.mVideoDetailInfoModel.mLikeNum);
            this.mLikeLayout.setOnClickPraiseListener(likeListener);
            if (this.mVideoDetailInfoModel.isUnlike) {
                this.mLikeLayout.setPraiseable(false);
            }
            this.mLikeLayout.setUBC(PraiseUBCHelper.SOURCE_FEEDVIDEO_LP).setPraiseSource(PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO);
            this.mLikeLayout.setPraiseId(this.mVideoDetailInfoModel.mNid);
            syncLikeNum(this.mVideoDetailInfoModel);
            unregisterEvent(false);
            IVideoEventBusWrapper.Impl.get().lazyRegisterOnMainThread((Object) this, LandScapeVideoLikeEvent.class, new Action1<LandScapeVideoLikeEvent>() {
                public void call(LandScapeVideoLikeEvent landScapeVideoLikeEvent) {
                    if (TopInfoShareConfigLayout.this.mVideoDetailInfoModel != null && VideoLikeUtils.isCurrentVideoLike(TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mNid, landScapeVideoLikeEvent)) {
                        TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                        topInfoShareConfigLayout.processLikeData(topInfoShareConfigLayout.mLikeLayout, TopInfoShareConfigLayout.this.mVideoDetailInfoModel, landScapeVideoLikeEvent.isPraised);
                    }
                }
            });
        }
    }

    private void setUnLikeViewData(VideoDetailInfoModel.TopInfoInteractBtn model) {
        int i2;
        VideoDetailInfoModel videoDetailInfoModel = this.mVideoDetailInfoModel;
        if (videoDetailInfoModel != null) {
            if (videoDetailInfoModel.isShowReport()) {
                View.OnClickListener reportListener = new View.OnClickListener() {
                    public void onClick(View v) {
                        if (TopInfoShareConfigLayout.this.mLikeStateListener != null) {
                            TopInfoShareConfigLayout.this.mLikeStateListener.processReport();
                        }
                        String str = TopInfoShareConfigLayout.this.mVideoInfo;
                        TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                        VideoDetailUbcExtUtils.uploadIconClickUBC(FeedStatisticConstants.UBC_FEED_VIDEO_IMMERSIVE_MORE_REPORT_VALUE, str, (String[]) null, topInfoShareConfigLayout.getUBCPage(topInfoShareConfigLayout.mVideoDetailInfoModel));
                    }
                };
                showIcon(this.mUnlikeIcon, R.drawable.video_detail_report_img);
                adjustUnLikeTextMargin(5);
                updateLikeStatus(this.mUnlikeText, 0, getResources().getString(R.string.video_comment_report), false);
                this.mUnLikeContainer.setOnClickListener(reportListener);
                return;
            }
            View.OnClickListener unLikeListener = new View.OnClickListener() {
                public void onClick(View v) {
                    if (TopInfoShareConfigLayout.this.mVideoDetailInfoModel.isUnlike) {
                        UniversalToast.makeText(TopInfoShareConfigLayout.this.getContext(), com.baidu.searchbox.feed.core.R.string.feed_disliked_tip).showToast();
                    } else if (TopInfoShareConfigLayout.this.mVideoDetailInfoModel.isLike) {
                        UniversalToast.makeText(TopInfoShareConfigLayout.this.getContext(), com.baidu.searchbox.feed.core.R.string.feed_liked_tip).showToast();
                    } else {
                        UniversalToast.makeText(TopInfoShareConfigLayout.this.getContext(), com.baidu.searchbox.feed.core.R.string.feed_disliked_success).showToast();
                        TopInfoShareConfigLayout topInfoShareConfigLayout = TopInfoShareConfigLayout.this;
                        topInfoShareConfigLayout.processDisLike(topInfoShareConfigLayout.mUnlikeIcon, TopInfoShareConfigLayout.this.mUnlikeText, TopInfoShareConfigLayout.this.mVideoDetailInfoModel);
                        if (TopInfoShareConfigLayout.this.mLikeStateListener != null) {
                            Map<String, Object> params = new HashMap<>();
                            params.put("nid", TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mNid);
                            params.put("type", "1");
                            params.put("ext", TopInfoShareConfigLayout.this.mVideoDetailInfoModel.mUnlikeExt);
                            TopInfoShareConfigLayout.this.mLikeStateListener.processLike(params);
                        }
                        if (TopInfoShareConfigLayout.this.mUnlikeIcon != null) {
                            TopInfoShareConfigLayout topInfoShareConfigLayout2 = TopInfoShareConfigLayout.this;
                            topInfoShareConfigLayout2.applyAnimation(topInfoShareConfigLayout2.mUnlikeIcon, (float) (TopInfoShareConfigLayout.this.mUnlikeIcon.getMeasuredHeight() / 2));
                        }
                        TopInfoShareConfigLayout topInfoShareConfigLayout3 = TopInfoShareConfigLayout.this;
                        VideoDetailUbcExtUtils.uploadIconClickUBC(FeedStatisticConstants.UBC_FEED_VIDEO_IMMERSIVE_MORE_DOWNVOTE_VALUE, TopInfoShareConfigLayout.this.mVideoInfo, new String[]{"0"}, topInfoShareConfigLayout3.getUBCPage(topInfoShareConfigLayout3.mVideoDetailInfoModel));
                    }
                }
            };
            ImageView imageView = this.mUnlikeIcon;
            if (this.mVideoDetailInfoModel.isUnlike) {
                i2 = R.drawable.video_detail_vote_down_clicked;
            } else {
                i2 = R.drawable.video_detail_vote_down_normal;
            }
            showIcon(imageView, i2);
            adjustUnLikeTextMargin(4);
            updateLikeStatus(this.mUnlikeText, this.mVideoDetailInfoModel.mUnlikeNum, getResources().getString(R.string.video_detail_unlike_default), this.mVideoDetailInfoModel.isUnlike);
            this.mUnLikeContainer.setOnClickListener(unLikeListener);
        }
    }

    /* access modifiers changed from: private */
    public void updateLikeUi() {
        if (this.mLikeContainer != null && this.mLikeLayout != null && getContext() != null && getContext().getResources() != null) {
            this.mLikeLayout.setPraiseStateIconRes(R.drawable.video_detail_like_up_normal, R.drawable.video_detail_like_up_clicked);
            this.mLikeLayout.setPraiseStateTextRes(com.baidu.android.common.ui.style.R.color.GC1, com.baidu.android.common.ui.style.R.color.GC8);
            if (this.mLikeLayout.getIsPraisedState()) {
                this.mLikeContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_detail_top_info_share_item_red_bg));
            } else {
                this.mLikeContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_detail_top_info_share_item_bg));
            }
        }
    }

    public void updateLikeUi(VideoDetailInfoModel mVideoDetailInfoModel2) {
        CoolPraiseView coolPraiseView;
        if (mVideoDetailInfoModel2 != null && (coolPraiseView = this.mLikeLayout) != null) {
            coolPraiseView.setPraise(mVideoDetailInfoModel2.isLike);
            this.mLikeLayout.setPraiseCount(mVideoDetailInfoModel2.mLikeNum);
        }
    }

    public void showPraiseGuidePlay() {
        CoolPraiseView coolPraiseView = this.mLikeLayout;
        if (coolPraiseView != null && coolPraiseView.isShown() && canShowPraiseGuide()) {
            this.mHasShowGuidePlay = this.mLikeLayout.guidePlay((ViewGroup) null, true, false, false);
        }
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

    private int getStatueBarHeight(Context context) {
        int resourceId;
        if (!(context instanceof Activity) || (((Activity) context).getWindow().getAttributes().flags & 1024) != 0 || (resourceId = context.getApplicationContext().getResources().getIdentifier("status_bar_height", ResUtils.DIMEN, "android")) <= 0) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDimensionPixelSize(resourceId);
    }

    public void cancelPraiseGuidePlay() {
        CoolPraiseView coolPraiseView = this.mLikeLayout;
        if (coolPraiseView != null) {
            coolPraiseView.cancelGuidePlay();
        }
    }

    public void resetPraiseGuidePlayStatus() {
        this.mHasShowGuidePlay = false;
        cancelPraiseGuidePlay();
    }

    /* access modifiers changed from: private */
    public void processLike(CoolPraiseView praiseView, VideoDetailInfoModel mVideoDetailInfoModel2) {
        if (mVideoDetailInfoModel2 != null && praiseView != null) {
            processLikeData(praiseView, mVideoDetailInfoModel2, praiseView.getIsPraisedState());
        }
    }

    /* access modifiers changed from: private */
    public void processLikeData(CoolPraiseView praiseView, VideoDetailInfoModel mVideoDetailInfoModel2, boolean isPraised) {
        if (mVideoDetailInfoModel2 != null && praiseView != null) {
            mVideoDetailInfoModel2.isLike = isPraised;
            praiseView.setPraise(isPraised);
            if (isPraised) {
                mVideoDetailInfoModel2.mLikeNum++;
            } else {
                mVideoDetailInfoModel2.mLikeNum--;
            }
            praiseView.setPraiseCount(mVideoDetailInfoModel2.mLikeNum);
            syncLikeNum(mVideoDetailInfoModel2);
        }
    }

    private void syncLikeNum(VideoDetailInfoModel mVideoDetailInfoModel2) {
        String business;
        if (mVideoDetailInfoModel2 != null && this.mLikeLayout != null) {
            LinkageData linkageData = new LinkageData();
            if (!TextUtils.isEmpty(mVideoDetailInfoModel2.mOriginId)) {
                linkageData.nid = mVideoDetailInfoModel2.mOriginId;
            } else if (!isStar(mVideoDetailInfoModel2) || TextUtils.isEmpty(mVideoDetailInfoModel2.mFeedId)) {
                linkageData.nid = mVideoDetailInfoModel2.mNid;
            } else {
                linkageData.nid = mVideoDetailInfoModel2.mFeedId;
            }
            linkageData.status = mVideoDetailInfoModel2.isLike ? "1" : "0";
            linkageData.count = String.valueOf(mVideoDetailInfoModel2.mLikeNum);
            linkageData.type = "pro";
            linkageData.isUsed = false;
            if (isStar(mVideoDetailInfoModel2)) {
                business = "feed";
            } else {
                business = "video";
            }
            FeedLinkageManager.getInstance(business).addLinkage(linkageData);
            IVideoEventBusWrapper.Impl.get().post(linkageData);
            sendLikeDataToDataChannel(this.mLikeLayout.getContext(), linkageData.nid, linkageData.count, mVideoDetailInfoModel2.isLike);
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

    private boolean isStar(VideoDetailInfoModel mVideoDetailInfoModel2) {
        return mVideoDetailInfoModel2 != null && mVideoDetailInfoModel2.type == 2;
    }

    /* access modifiers changed from: private */
    public String getUBCPage(VideoDetailInfoModel mVideoDetailInfoModel2) {
        if (mVideoDetailInfoModel2 == null || 2 != mVideoDetailInfoModel2.type) {
            return null;
        }
        return VideoDetailModel.DETAIL_PAGE_STAR;
    }

    private void showIcon(ImageView icon, int drawableId) {
        if (drawableId != 0) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), drawableId);
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
            text.setTextColor(ResourceUtils.getColorStateList(getContext(), R.color.video_detail_bdcomment_like_click));
        } else {
            text.setTextColor(ResourceUtils.getColorStateList(getContext(), R.color.video_detail_interact_text_color_selector));
        }
    }

    /* access modifiers changed from: private */
    public void processDisLike(ImageView icon, TextView text, VideoDetailInfoModel mVideoDetailInfoModel2) {
        if (mVideoDetailInfoModel2 != null) {
            processDisLikeDate(icon, text, mVideoDetailInfoModel2);
            String url = IVideoBaiduIdentityManager.Impl.get().processUrl(VideoUrlConfig.getLikeUrl());
            JSONObject json = new JSONObject();
            try {
                json.put("nid", mVideoDetailInfoModel2.mNid);
                json.put("type", "1");
                json.put("ext", mVideoDetailInfoModel2.mUnlikeExt);
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
            boolean isUseHttps = url.startsWith("https://");
            if (text != null) {
                if (isUseHttps) {
                    ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(text.getContext().getApplicationContext()).postFormRequest().url(url)).cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(false, false))).params(params)).build().executeAsyncOnUIBack(callback);
                    return;
                }
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(text.getContext().getApplicationContext()).postFormRequest().url(url)).params(params)).build().executeAsyncOnUIBack(callback);
            }
        }
    }

    private void processDisLikeDate(ImageView icon, TextView text, VideoDetailInfoModel mVideoDetailInfoModel2) {
        String business;
        if (mVideoDetailInfoModel2 != null) {
            mVideoDetailInfoModel2.isUnlike = true;
            if (!(icon == null || text == null)) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.video_detail_vote_down_clicked);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                icon.setImageDrawable(drawable);
                mVideoDetailInfoModel2.mUnlikeNum++;
                text.setText(FeedUtil.convertNumber(text.getContext(), (long) mVideoDetailInfoModel2.mUnlikeNum));
                text.setTextColor(ResourceUtils.getColorStateList(getContext(), R.color.video_detail_bdcomment_like_click));
            }
            LinkageData linkageData = new LinkageData();
            linkageData.nid = isStar(mVideoDetailInfoModel2) ? mVideoDetailInfoModel2.mFeedId : mVideoDetailInfoModel2.mNid;
            linkageData.status = "1";
            linkageData.count = String.valueOf(mVideoDetailInfoModel2.mUnlikeNum);
            linkageData.type = "dislike";
            linkageData.isUsed = true;
            if (isStar(mVideoDetailInfoModel2)) {
                business = "feed";
            } else {
                business = "video";
            }
            FeedLinkageManager.getInstance(business).addLinkage(linkageData);
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
    public void showShare(String type, String videoInfo) {
        String source;
        if (type.equals("weixin_friend")) {
            source = "1";
        } else {
            type.equals("weixin_timeline");
            source = "0";
        }
        VideoDetailUbcExtUtils.uploadIconClickUBC("share_click", videoInfo, (String[]) null, (String) null, (String) null, source);
        ShareListener shareListener = this.mShareListener;
        if (shareListener != null && this.mVideoDetailInfoModel != null) {
            shareListener.share(type, ShareSource.RIGHT_BUTTON);
        }
    }

    public void updateNightMode(boolean isNightMode) {
        updateLikeUi();
        updateUnLikeUi();
        updateWeiXinUi();
        updateFriendUi();
        updateCustomUi(isNightMode);
    }

    private void updateCustomUi(boolean isNightMode) {
        LinearLayout customContainer;
        HashMap<VideoDetailInfoModel.TopInfoInteractBtn, LinearLayout> hashMap = this.mCustomContainerMap;
        if (hashMap != null && hashMap.size() > 0 && getContext() != null && getContext().getResources() != null) {
            for (VideoDetailInfoModel.TopInfoInteractBtn model : this.mCustomContainerMap.keySet()) {
                if (!(model == null || (customContainer = this.mCustomContainerMap.get(model)) == null)) {
                    customContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_detail_top_info_share_item_bg));
                    if (customContainer.getChildAt(0) instanceof SimpleDraweeView) {
                        SimpleDraweeView customIcon = (SimpleDraweeView) customContainer.getChildAt(0);
                        if (!isNightMode && !TextUtils.isEmpty(model.mIcon)) {
                            customIcon.setImageURI(model.mIcon);
                        } else if (!TextUtils.isEmpty(model.mNightIcon)) {
                            customIcon.setImageURI(model.mNightIcon);
                        }
                    }
                    if (customContainer.getChildAt(1) instanceof TextView) {
                        ((TextView) customContainer.getChildAt(1)).setTextColor(ResourceUtils.getColorStateList(getContext(), R.color.video_detail_interact_text_color_selector));
                    }
                }
            }
        }
    }

    private void updateFriendUi() {
        if (!(this.mFriendContainer == null || getContext() == null || getContext().getResources() == null)) {
            this.mFriendContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_detail_top_info_share_item_bg));
        }
        TextView textView = this.mFriendText;
        if (textView != null) {
            textView.setTextColor(ResourceUtils.getColorStateList(getContext(), R.color.video_detail_interact_text_color_selector));
        }
        if (this.mFriendIcon != null) {
            VideoDetailInfoModel.TopInfoInteractBtn topInfoInteractBtn = this.mFriendModel;
            if (topInfoInteractBtn != null && !TextUtils.isEmpty(topInfoInteractBtn.mIcon)) {
                this.mFriendIcon.setImageURI(this.mFriendModel.mIcon);
            } else if (getContext() == null || getContext().getResources() == null) {
                this.mFriendIcon.setImageResource(R.drawable.video_detail_share_friend_img_selector);
            } else {
                this.mFriendIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.video_detail_share_friend_img_selector));
            }
        }
    }

    private void updateWeiXinUi() {
        if (!(this.mWeiXinContainer == null || getContext() == null || getContext().getResources() == null)) {
            this.mWeiXinContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_detail_top_info_share_item_bg));
        }
        TextView textView = this.mWeiXinText;
        if (textView != null) {
            textView.setTextColor(ResourceUtils.getColorStateList(getContext(), R.color.video_detail_interact_text_color_selector));
        }
        if (this.mWeiXinIcon != null) {
            VideoDetailInfoModel.TopInfoInteractBtn topInfoInteractBtn = this.mWeiXinModel;
            if (topInfoInteractBtn != null && !TextUtils.isEmpty(topInfoInteractBtn.mIcon)) {
                this.mWeiXinIcon.setImageURI(this.mWeiXinModel.mIcon);
            }
            if (getContext() == null || getContext().getResources() == null) {
                this.mWeiXinIcon.setImageResource(R.drawable.video_detail_share_weixin_img_selector);
            } else {
                this.mWeiXinIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.video_detail_share_weixin_img_selector));
            }
        }
    }

    private void updateUnLikeUi() {
        int i2;
        if (!(this.mUnLikeContainer == null || getContext() == null || getContext().getResources() == null)) {
            this.mUnLikeContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_detail_top_info_share_item_bg));
        }
        VideoDetailInfoModel videoDetailInfoModel = this.mVideoDetailInfoModel;
        if (videoDetailInfoModel != null && this.mUnlikeIcon != null && this.mUnlikeText != null) {
            if (videoDetailInfoModel.isShowReport()) {
                showIcon(this.mUnlikeIcon, R.drawable.video_detail_report_img);
                updateLikeStatus(this.mUnlikeText, 0, getResources().getString(R.string.video_comment_report), false);
                return;
            }
            ImageView imageView = this.mUnlikeIcon;
            if (this.mVideoDetailInfoModel.isUnlike) {
                i2 = R.drawable.video_detail_vote_down_clicked;
            } else {
                i2 = R.drawable.video_detail_vote_down_normal;
            }
            showIcon(imageView, i2);
            updateLikeStatus(this.mUnlikeText, this.mVideoDetailInfoModel.mUnlikeNum, getResources().getString(R.string.video_detail_unlike_default), this.mVideoDetailInfoModel.isUnlike);
        }
    }

    public void unregisterEvent(boolean isDestroy) {
        IVideoEventBusWrapper.Impl.get().unregister(this);
        if (isDestroy) {
            unRegisterTriplePraiseAction();
            this.mRewardListener = null;
        }
    }

    private void unRegisterTriplePraiseAction() {
        DataChannel.Registry.unregisterReceiver("", "", "com.baidu.channel.foundation.followchanged");
        if (this.mCommentListener != null) {
            this.mCommentListener = null;
        }
        this.mMainHandler.removeCallbacks(this.mTriplePraiseRunnable);
    }

    public void release() {
        unregisterEvent(true);
        TriplePraiseInterface triplePraiseInterface = this.mTriplePraiseManager;
        if (triplePraiseInterface != null) {
            triplePraiseInterface.dismissTripleAnimation();
        }
    }

    private void layoutViews() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this);
        int childCount = getChildCount();
        View firstView = getChildAt(0);
        if (childCount == 4) {
            constraintSet.setHorizontalChainStyle(firstView.getId(), 1);
            int i2 = HORIZONTAL_MARGIN;
            setPadding(i2, TOP_MARGIN, i2, BOTTOM_MARGIN);
        } else {
            constraintSet.setHorizontalChainStyle(firstView.getId(), 0);
            setPadding(0, TOP_MARGIN, 0, BOTTOM_MARGIN);
        }
        constraintSet.connect(firstView.getId(), 1, getId(), 1);
        if (childCount > 1) {
            constraintSet.connect(firstView.getId(), 2, getChildAt(1).getId(), 1);
        } else {
            int i3 = HORIZONTAL_MARGIN;
            setPadding(i3, TOP_MARGIN, i3, BOTTOM_MARGIN);
        }
        View leftView = firstView;
        for (int i4 = 1; i4 < childCount; i4++) {
            View childView = getChildAt(i4);
            constraintSet.connect(childView.getId(), 1, leftView.getId(), 2);
            if (i4 < childCount - 1) {
                constraintSet.connect(childView.getId(), 2, getChildAt(i4 + 1).getId(), 1);
            } else {
                constraintSet.connect(childView.getId(), 2, getId(), 2);
            }
            leftView = childView;
        }
        constraintSet.applyTo(this);
    }

    public void showTriplePraiseBubbleGuidance() {
        if (this.mLikeContainer != null && this.mBubbleViewParent != null) {
            TriplePraiseGuidanceManager.INSTANCE.showBubble(this.mLikeContainer, this.mBubbleViewParent);
        }
    }

    public void dismissTripleAnimation() {
        TriplePraiseInterface triplePraiseInterface = this.mTriplePraiseManager;
        if (triplePraiseInterface != null && triplePraiseInterface.isTripleAnimShowing()) {
            VideoDetailInfoModel videoDetailInfoModel = this.mVideoDetailInfoModel;
            if (videoDetailInfoModel != null) {
                VideoDetailUbcExtUtils.uploadTriplePraiseUbc(true, 0, videoDetailInfoModel.mNid);
            }
            this.mTriplePraiseManager.dismissTripleAnimation();
        }
    }

    public LinearLayout getContainerByType(ButtonType type) {
        VideoDetailInfoModel videoDetailInfoModel = this.mVideoDetailInfoModel;
        if (videoDetailInfoModel == null || videoDetailInfoModel.mInteractBtnList == null) {
            return null;
        }
        int index = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mVideoDetailInfoModel.mInteractBtnList.size()) {
                break;
            } else if (TextUtils.equals(type.getName(), this.mVideoDetailInfoModel.mInteractBtnList.get(i2).mType)) {
                index = i2;
                break;
            } else {
                i2++;
            }
        }
        return (LinearLayout) getChildAt(index);
    }

    public boolean isRewardButtonShowing() {
        return this.mIsRewardButtonShowing;
    }

    public boolean isRewardButtonClicked() {
        return this.mIsRewardButtonClicked;
    }

    private RewardModel getRewardModel() {
        AuthorModel author;
        IRewardAbilityProvider iRewardAbilityProvider = this.mRewardAbilityProvider;
        if (iRewardAbilityProvider == null || (author = iRewardAbilityProvider.getAuthorModel()) == null || TextUtils.isEmpty(author.mIcon) || TextUtils.isEmpty(author.mName) || TextUtils.isEmpty(this.mVideoDetailInfoModel.mTitle) || TextUtils.isEmpty(this.mVideoDetailInfoModel.mNid) || TextUtils.isEmpty(author.mId)) {
            return null;
        }
        return new RewardModel(author.mIcon, author.mName, this.mVideoDetailInfoModel.mTitle, this.mVideoDetailInfoModel.mNid, "feedvideo_dashang", "feedvideo", author.mId);
    }

    /* access modifiers changed from: private */
    public void showRewardPanel() {
        if (this.mRewardListener == null) {
            this.mRewardListener = new RewardListener(this, this.mRewardAbilityProvider);
        }
        this.mIsRewardButtonClicked = true;
        BoxRewardManager service = (BoxRewardManager) ServiceManager.getService(BoxRewardManager.SERVICE_REFERENCE);
        Activity activity = BdBoxActivityManager.getTopActivity();
        RewardModel rewardModel = getRewardModel();
        if (service != null && activity != null && rewardModel != null) {
            onRewardVideoUBC("button_click");
            service.reward(activity, activity.getWindow().getDecorView(), rewardModel, this.mRewardListener);
        }
    }

    private void onRewardVideoUBC(String type) {
        VideoDetailInfoModel videoDetailInfoModel;
        BoxRewardManager service = (BoxRewardManager) ServiceManager.getService(BoxRewardManager.SERVICE_REFERENCE);
        if (service != null && (videoDetailInfoModel = this.mVideoDetailInfoModel) != null) {
            service.doRewardUBC("feedvideo", "", type, "", "", videoDetailInfoModel.mNid);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsRewardButtonShowing && !this.mHasRewardButtonShown && hasAutoGoToComment()) {
            this.mHasRewardButtonShown = true;
            onRewardVideoUBC("button_show");
        }
    }

    public void updateRewardButtonText(String rewardCount) {
        LinearLayout rewardContainer = getContainerByType(ButtonType.REWARD);
        if (rewardContainer != null) {
            ((TextView) rewardContainer.findViewById(R.id.video_detail_share_text)).setText(rewardCount);
        }
    }

    private void resetButtonStatus() {
        this.mIsRewardButtonShowing = false;
        this.mIsRewardButtonClicked = false;
        this.mHasRewardButtonShown = false;
    }

    private boolean hasAutoGoToComment() {
        IRewardAbilityProvider iRewardAbilityProvider = this.mRewardAbilityProvider;
        return iRewardAbilityProvider != null && iRewardAbilityProvider.hasAutoGoToComment();
    }

    public void setLikeStateListener(LikeStateListener likeStateListener) {
        this.mLikeStateListener = likeStateListener;
    }

    public void setShareListener(ShareListener shareListener) {
        this.mShareListener = shareListener;
    }

    public void setCommentListener(CommentListener commentListener) {
        this.mCommentListener = commentListener;
    }

    public void setFavorListener(FavorListener favorListener) {
        this.mFavorListener = favorListener;
    }
}
