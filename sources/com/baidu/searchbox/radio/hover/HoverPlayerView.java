package com.baidu.searchbox.radio.hover;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.pad.PadCrossWidthAdaptUtilsKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdmediacore.MediaRuntime;
import com.baidu.searchbox.bdmediacore.R;
import com.baidu.searchbox.bdmediacore.controller.MediaEvents;
import com.baidu.searchbox.bdmediacore.interfaces.IHoverView;
import com.baidu.searchbox.bdmediacore.utils.NavigationBarUtils;
import com.baidu.searchbox.bdmediacore.widgets.VoiceBarWaveView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.exclusion.suspension.BarrierPool;
import com.baidu.searchbox.feed.purelisten.IPureListenContext;
import com.baidu.searchbox.feed.purelisten.PureListenRuntime;
import com.baidu.searchbox.feed.tab.interaction.tts.TTSPlayerEvent;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import com.baidu.searchbox.music.CoverComponent;
import com.baidu.searchbox.music.IMusicFactory;
import com.baidu.searchbox.music.IMusicUI;
import com.baidu.searchbox.music.MiniPlayerView;
import com.baidu.searchbox.music.MusicActivityPresenter;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.MusicUIDefaultImpl;
import com.baidu.searchbox.music.adapter.IMusic;
import com.baidu.searchbox.music.bean.PlayerExtInfo;
import com.baidu.searchbox.music.bean.PlayerExtInfoKt;
import com.baidu.searchbox.music.statistic.MusicUBCConstant;
import com.baidu.searchbox.music.ui.VoiceManagementBubbleManager;
import com.baidu.searchbox.music.utils.NovelHelper;
import com.baidu.searchbox.music.utils.PureListenUbcUtilsKt;
import com.baidu.searchbox.music.utils.TimeUtils;
import com.baidu.searchbox.radio.adapter.HoverToFloatingWindowAdapter;
import com.baidu.searchbox.radio.hover.dragger.Dragger;
import com.baidu.searchbox.radio.hover.dragger.HoverViewDragger;
import com.baidu.searchbox.radio.hover.pad.HoverPadExtKt;
import com.baidu.searchbox.radio.hover.utils.HoverUtils;
import com.baidu.searchbox.radio.ttsfloatingwindow.CreateStrategy;
import com.baidu.searchbox.radio.ttsfloatingwindow.IFloatingWindowListener;
import com.baidu.searchbox.radio.ttsfloatingwindow.TTSFloatingWindow;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.BdBaseLottieView;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

public class HoverPlayerView extends FrameLayout implements View.OnTouchListener, IHoverView, View.OnClickListener {
    private static final long BUBBLE_DELAY_TIME_IN_MILLIS = 500;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = MediaRuntime.DEBUG;
    private static final int EXTENTION = 1;
    private static final long EXT_ANIM_DURATION = 300;
    private static final long EXT_ANIM_DURATION2 = 320;
    private static final long EXT_ANIM_SECOND_DELAY = 200;
    private static final float LIMITED_HEIGHT = 0.333f;
    private static final int NORMAL = 0;
    private static final String NO_PROGRESS = "- - : - -";
    private static final String STATE_PLAY = "PLAY";
    private static final String TAG = "HoverView";
    private static final String VOICE_MANAGEMENT_GUIDE_ANIM = "lottie/tts_mini_voice_management_guide_anim.json";
    private Pair<Integer, Integer> anchorPair;
    /* access modifiers changed from: private */
    public Dragger dragger;
    public final HoverWindowController hoverWindowController;
    /* access modifiers changed from: private */
    public AnimatorSet longToNormalAnimSet;
    private String mArtist;
    private ImageButton mBtnPureListen;
    private ImageButton mBtnVoiceManagement;
    private BdBaseLottieView mClickTipsLottieView;
    private BdBaseImageView mClickTipsStaticView;
    private View mCloseView;
    /* access modifiers changed from: private */
    public WeakReference<Context> mContextWeakReference;
    protected CoverComponent mCoverComponent;
    /* access modifiers changed from: private */
    public boolean mCustomTouchForNovel = false;
    /* access modifiers changed from: private */
    public Dragger.DragListener mDragListener;
    /* access modifiers changed from: private */
    public boolean mDraggable = true;
    protected int mDuration = 0;
    /* access modifiers changed from: private */
    public View mExtContainer;
    private CreateStrategy mFloatingModel;
    /* access modifiers changed from: private */
    public FrameLayout mFlytVoiceManagement;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private int mGlobalLayoutWindowWidth = 0;
    /* access modifiers changed from: private */
    public IHoverView.HoverEventListener mHoverEventListener;
    private ViewGroup mHoverExtContainer;
    private SimpleDraweeView mHoverImg;
    /* access modifiers changed from: private */
    public HoverCardView mHoverOutsideCard;
    /* access modifiers changed from: private */
    public HoverPlayerClickGuide mHoverPlayerClickGuide;
    private IMusic mIMusic;
    protected boolean mIsPlaying;
    private ImageView mIvVoiceManagementDot;
    private ImageButton mLongCloseButton;
    /* access modifiers changed from: private */
    public ImageButton mLongNextButton;
    /* access modifiers changed from: private */
    public LottieAnimationView mLongPlayButton;
    private View mLongPlayContainer;
    private TextView mLongSubtitle;
    private View mLongSubtitleContainer;
    /* access modifiers changed from: private */
    public MusicPlayState mLonglottieState = MusicPlayState.STOP;
    private LottieAnimationView mLottieVoiceManagement;
    /* access modifiers changed from: private */
    public View mNextView;
    private View mNormalPauseView;
    private View mNormalPlayView;
    protected View.OnClickListener mOnTapListener;
    /* access modifiers changed from: private */
    public FrameLayout mOutContainer;
    /* access modifiers changed from: private */
    public MusicPlayState mPlayState;
    private FrameLayout mPureListenBtnLayout;
    /* access modifiers changed from: private */
    public String mStatisticPageState = "none";
    private String mTitle;
    protected View.OnClickListener mTitleClickListener;
    private View mTitleContainer;
    private TextView mTitleTextView;
    private AnimatorSet mToExtentionAnimSet;
    private AnimatorSet mToLongExtentionAnimSet;
    private IMusicUI mUICallback;
    /* access modifiers changed from: private */
    public int mViewState = 0;
    private boolean mVoiceManagementEnable = true;
    protected VoiceBarWaveView mVoiceWaveView;
    /* access modifiers changed from: private */
    public boolean needMultiViewState;
    /* access modifiers changed from: private */
    public IHoverView.OnDockListener onDockListener;
    private float positionByPercent = -1.0f;
    private AnimatorSet toDockerAnimSet;
    /* access modifiers changed from: private */
    public AnimatorSet toNormalAnimSet;

    public static HoverPlayerView createForWindow(Context context, HoverWindowController hoverWindowController2) {
        if (DEBUG) {
            Log.d(TAG, "createHover: ");
        }
        HoverPlayerView hoverPlayerView = new HoverPlayerView(context, hoverWindowController2);
        hoverPlayerView.initLayout();
        return hoverPlayerView;
    }

    public HoverPlayerView(Context context, HoverWindowController hoverWindowController2) {
        super(context);
        if (DEBUG) {
            Log.d(TAG, "HoverPlayerView: construct, context=" + context.getClass().getSimpleName());
        }
        setNeedMultiViewState(MediaRuntime.getContext().isNeedHoverExtention());
        this.hoverWindowController = hoverWindowController2;
        this.mContextWeakReference = new WeakReference<>(context);
        this.dragger = new HoverViewDragger((Context) this.mContextWeakReference.get(), hoverWindowController2, this);
        setFocusableInTouchMode(true);
        clearFocus();
        setDragListener(new DefaultDragListener(this));
        setOnTouchListener(this);
        this.anchorPair = HoverToFloatingWindowAdapter.INSTANCE.getDefaultAnchorPair();
    }

    public static int getHoverScreenHeight() {
        return (HoverUIUtils.getScreenSize(AppRuntime.getAppContext())[1] - DeviceUtils.ScreenInfo.getStatusBarHeight()) - NavigationBarUtils.getNavBarHeight(AppRuntime.getAppContext());
    }

    public static Point getDefaultHoverViewPosition() {
        if (DEBUG) {
            Log.d(TAG, "getDefaultHoverViewPosition:  -A- " + HoverUIUtils.getScreenSize(AppRuntime.getAppContext())[1] + " -B- " + DeviceUtils.ScreenInfo.getStatusBarHeight() + " -C- " + NavigationBarUtils.getNavBarHeight(AppRuntime.getAppContext()) + " -D- " + HoverUIUtils.getOutterCircleSize() + " -E- " + MediaRuntime.getContext().getHomeBottomTabHeight() + " -F- " + MediaRuntime.getContext().getBottomBarHeight());
        }
        return new Point(HoverLayout.HOVER_LEFT_MARGIN_DEFAULT, ((getHoverScreenHeight() - HoverUIUtils.getOutterCircleSize()) - MediaRuntime.getContext().getHomeBottomTabHeight()) - MediaRuntime.getContext().getBottomBarHeight());
    }

    /* access modifiers changed from: protected */
    public void initLayout() {
        if (DEBUG) {
            Log.d(TAG, "initLayout: " + this);
        }
        Context context = (Context) this.mContextWeakReference.get();
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.radio_hover_player, this);
            this.mOutContainer = (FrameLayout) findViewById(R.id.hover_out_container);
            this.mHoverOutsideCard = (HoverCardView) findViewById(R.id.hover_outter_card);
            this.mHoverExtContainer = (ViewGroup) findViewById(R.id.hover_ext_container);
            CoverComponent coverComponent = (CoverComponent) findViewById(R.id.radio_hover_img);
            this.mCoverComponent = coverComponent;
            this.mHoverImg = coverComponent.getDraweeView();
            this.mVoiceWaveView = (VoiceBarWaveView) findViewById(R.id.radio_hover_wave);
            this.mClickTipsLottieView = (BdBaseLottieView) findViewById(R.id.floating_button_click_tips);
            this.mClickTipsStaticView = (BdBaseImageView) findViewById(R.id.floating_button_click_tips_static);
            this.mHoverPlayerClickGuide = new HoverPlayerClickGuide(this.mVoiceWaveView, this, this.mClickTipsLottieView, this.mClickTipsStaticView);
            setVisibility(8);
            updateUI();
        }
    }

    public void changeHoverPosition(float x, float y) {
        if (DEBUG) {
            Log.d(TAG, "changeHoverPosition: " + x + " -- " + y);
        }
        this.mOutContainer.setX(x);
        this.mOutContainer.setY(y);
        IHoverView.HoverEventListener hoverEventListener = this.mHoverEventListener;
        if (hoverEventListener != null) {
            hoverEventListener.onHoverPositionChanged((int) x, (int) y);
        }
    }

    public void setHoverViewPositionByPercent(float percentOfScreen) {
        if (DEBUG) {
            Log.d(TAG, "setHoverViewPositionByPercent: " + percentOfScreen);
        }
        if (percentOfScreen >= 0.0f) {
            if (percentOfScreen > 1.0f) {
                percentOfScreen = 1.0f;
            }
            int navigationBarH = NavigationBarUtils.getNavBarHeight(AppRuntime.getAppContext());
            int statusBarH = DeviceUtils.ScreenInfo.getStatusBarHeight();
            int screenH = HoverUIUtils.getScreenSize(AppRuntime.getAppContext())[1];
            int limitedH = (int) (((float) ((screenH - navigationBarH) - statusBarH)) * LIMITED_HEIGHT);
            int anchorY = ((screenH - navigationBarH) - limitedH) + ((int) (((float) limitedH) * percentOfScreen));
            if (anchorY >= screenH - navigationBarH) {
                anchorY = screenH - navigationBarH;
            }
            this.anchorPair = new Pair<>(Integer.valueOf(getHoverLRMargin()), Integer.valueOf(anchorY));
        }
    }

    public void setPositionByMargin(int lastPointX, int lastPointY) {
        if (DEBUG) {
            Log.d(TAG, "setPosition: " + lastPointX + " -- " + lastPointY);
        }
        FrameLayout frameLayout = this.mOutContainer;
        if (frameLayout != null) {
            frameLayout.setX((float) lastPointX);
            this.mOutContainer.setY((float) lastPointY);
        }
    }

    public void showAtSpecifiedPosition(float percentOfScreen) {
        setHoverViewPositionByPercent(percentOfScreen);
        show();
    }

    public void sendToDock(final float x, final float y) {
        if (DEBUG) {
            Log.i(TAG, "sendToDock: " + x + " -- " + y);
        }
        Dragger dragger2 = this.dragger;
        if (dragger2 != null) {
            dragger2.setDragDropping(true);
        }
        deactivateDragger();
        ObjectAnimator xAnimation = ObjectAnimator.ofFloat(this.mOutContainer, "x", new float[]{x});
        xAnimation.setDuration(200);
        xAnimation.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator yAnimation = ObjectAnimator.ofFloat(this.mOutContainer, "y", new float[]{y});
        yAnimation.setDuration(200);
        yAnimation.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.toDockerAnimSet = animatorSet;
        animatorSet.play(xAnimation).with(yAnimation);
        this.toDockerAnimSet.start();
        this.toDockerAnimSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                HoverPlayerView.this.changeHoverPosition(x, y);
                HoverPlayerView.this.toActiveDragger();
                if (HoverPlayerView.this.onDockListener != null) {
                    HoverPlayerView.this.onDockListener.onDragToDock((int) x, (int) y);
                }
                if (HoverPlayerView.DEBUG) {
                    Log.i(HoverPlayerView.TAG, "sendToDock onAnimationEnd: ");
                }
            }

            public void onAnimationCancel(Animator animation) {
                if (HoverPlayerView.this.dragger != null) {
                    HoverPlayerView.this.dragger.setDragDropping(false);
                }
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    public void setOnDockListener(IHoverView.OnDockListener listener) {
        this.onDockListener = listener;
    }

    public void setHoverEventListener(IHoverView.HoverEventListener hoverEventListener) {
        this.mHoverEventListener = hoverEventListener;
    }

    public void setViewClickListener(View.OnClickListener onClickListener) {
        this.mOnTapListener = onClickListener;
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        this.mTitleClickListener = onClickListener;
    }

    public void onAttachedToWindow() {
        if (DEBUG) {
            Log.d(TAG, "onAttachedToWindow: " + this + ", context=" + getContext().getClass().getSimpleName());
        }
        super.onAttachedToWindow();
        IHoverView.HoverEventListener hoverEventListener = this.mHoverEventListener;
        if (hoverEventListener != null) {
            hoverEventListener.onAttachedToWindow();
        }
        if (isRunOnMainProcess()) {
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
                public void onNightModeChanged(boolean isNightMode) {
                    HoverPlayerView.this.updateUI();
                }
            });
        }
        registerMusicUICallback();
        addPadGlobalLayoutListener();
    }

    public void onDetachedFromWindow() {
        if (DEBUG) {
            Log.d(TAG, "onDetachedFromWindow: " + this + ", context=" + getContext().getClass().getSimpleName());
        }
        if (isRunOnMainProcess()) {
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
            BdEventBus.Companion.getDefault().unregister(this);
        }
        IHoverView.HoverEventListener hoverEventListener = this.mHoverEventListener;
        if (hoverEventListener != null) {
            hoverEventListener.onDetachedFromWindow();
        }
        unregisterMusicUICallback();
        removePadGlobalLayoutListener();
        super.onDetachedFromWindow();
    }

    private void removeFromWindow() {
        View view2;
        if (DEBUG) {
            Log.d(TAG, "removeFromWindow: " + this);
        }
        this.hoverWindowController.removeView(this);
        deactivateDragger();
        setDragListener((Dragger.DragListener) null);
        Dragger dragger2 = this.dragger;
        if ((dragger2 instanceof HoverViewDragger) && (view2 = ((HoverViewDragger) dragger2).dragView) != null) {
            this.hoverWindowController.removeView(view2);
        }
        if (this.mFloatingModel == CreateStrategy.APP_WINDOW) {
            TTSFloatingWindow.Companion.dismissAppFloating();
        }
    }

    public void show() {
        IFeedTTSModel speechingFeed;
        if (DEBUG) {
            Log.d(TAG, "show: ");
        }
        float f2 = this.positionByPercent;
        if (f2 >= 0.0f) {
            setHoverViewPositionByPercent(f2);
        } else {
            IFeedTTSModel speechingFeed2 = TTSRuntime.getInstance().getSpeechingFeed();
            float positionInTTSModel = -1.0f;
            if (speechingFeed2 != null) {
                positionInTTSModel = speechingFeed2.getHoverViewPosition();
            }
            if (positionInTTSModel >= 0.0f) {
                setHoverViewPositionByPercent(positionInTTSModel);
            }
        }
        setVisibility(0);
        startWaveAnim();
        syncDragViewStatus();
        if (!NovelHelper.shouldRemoveNovelHover() && (speechingFeed = TTSRuntime.getInstance().getSpeechingFeed()) != null) {
            setImage(speechingFeed.getTtsImageUrl());
        }
        autoExtensionIfNeeded();
    }

    /* access modifiers changed from: private */
    public void autoExtensionIfNeeded() {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "autoExtensionIfNeeded");
        }
        if (useNewHoverExt()) {
            boolean isMusic = 2 == MediaRuntime.getContext().getMode();
            boolean isMainFeedPage = MediaRuntime.getContext().isFeedTab();
            if ((isMusic && isMainFeedPage) || (this.needMultiViewState && FeedTTSPreferenceUtil.getInt(HoverPlayerClickGuideKt.HOVER_HAS_EXTENSION, 0) == 0)) {
                if (this.mViewState != 1) {
                    if (z) {
                        Log.d(TAG, "autoExtensionIfNeeded => true");
                    }
                    this.mViewState = 1;
                    this.hoverWindowController.addTouchAbility(this);
                    startMiniShowAnimToLongExtension();
                    hoverViewUBC(this.mStatisticPageState, MusicUBCConstant.UBC_TTS_FLOATING_TOBAR);
                } else {
                    return;
                }
            }
        } else {
            IFeedTTSModel ttsModel = TTSRuntime.getInstance().getSpeechingFeed();
            if (this.needMultiViewState && ttsModel != null && !ttsModel.isMocked() && FeedTTSPreferenceUtil.getInt(HoverPlayerClickGuideKt.HOVER_HAS_EXTENSION, 0) == 0) {
                if (z) {
                    Log.d(TAG, "autoExtensionIfNeeded => true");
                }
                changeViewToExtension(false);
            }
        }
        updateUI();
    }

    private void startMiniShowAnimToLongExtension() {
        if (DEBUG) {
            Log.d(TAG, "startMiniShowAnimToLongExtension: ");
        }
        AlphaAnimation showAlphaAnim = new AlphaAnimation(0.0f, 1.0f);
        showAlphaAnim.setDuration(320);
        AnimationSet showAnimation = new AnimationSet(true);
        showAnimation.addAnimation(showAlphaAnim);
        showAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                if (HoverPlayerView.this.mVoiceWaveView != null) {
                    HoverPlayerView.this.mVoiceWaveView.setVisibility(8);
                }
                HoverPlayerView hoverPlayerView = HoverPlayerView.this;
                hoverPlayerView.inflateExpansion((Context) hoverPlayerView.mContextWeakReference.get());
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) HoverPlayerView.this.mOutContainer.getLayoutParams();
                lp.width = HoverPlayerView.this.getScaledExtSize();
                HoverPlayerView.this.mOutContainer.setX((float) HoverPlayerView.this.getHoverLRMargin());
                HoverPlayerView.this.mOutContainer.setLayoutParams(lp);
                HoverPlayerView.this.activateExpansion();
            }

            public void onAnimationEnd(Animation animation) {
                Context context = (Context) HoverPlayerView.this.mContextWeakReference.get();
                if (context != null) {
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        HoverPlayerView.this.mHoverPlayerClickGuide.showGuideBubble(false);
                        FeedTTSPreferenceUtil.putInt(HoverPlayerClickGuideKt.HOVER_HAS_EXTENSION, 1);
                    }
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mOutContainer.startAnimation(showAnimation);
        preSetAppFloatingExpansionWidth();
    }

    private void syncDragViewStatus() {
        Dragger dragger2;
        if (DEBUG) {
            Log.d(TAG, "syncDragViewStatus");
        }
        if (this.mDragListener != null && (dragger2 = this.dragger) != null && !dragger2.isDragDropping()) {
            toActiveDragger();
        }
    }

    public void hide() {
        if (DEBUG) {
            Log.d(TAG, "hide: ");
        }
        deactivateDragger();
        VoiceBarWaveView voiceBarWaveView = this.mVoiceWaveView;
        if (voiceBarWaveView != null) {
            voiceBarWaveView.pauseWaveAnim();
        }
        setVisibility(8);
        if (this.mFloatingModel == CreateStrategy.APP_WINDOW) {
            TTSFloatingWindow.Companion.dismissAppFloating();
        }
    }

    /* access modifiers changed from: private */
    public void stopWaveAnim() {
        this.mVoiceWaveView.stopWaveAnim();
    }

    public void release() {
        if (DEBUG) {
            Log.d(TAG, "release: ");
        }
        AnimatorSet animatorSet = this.toNormalAnimSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.toNormalAnimSet.cancel();
        }
        AnimatorSet animatorSet2 = this.mToExtentionAnimSet;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.mToExtentionAnimSet.cancel();
        }
        AnimatorSet animatorSet3 = this.mToLongExtentionAnimSet;
        if (animatorSet3 != null) {
            animatorSet3.removeAllListeners();
            this.mToLongExtentionAnimSet.cancel();
        }
        AnimatorSet animatorSet4 = this.longToNormalAnimSet;
        if (animatorSet4 != null) {
            animatorSet4.removeAllListeners();
            this.longToNormalAnimSet.cancel();
        }
        AnimatorSet animatorSet5 = this.toDockerAnimSet;
        if (animatorSet5 != null) {
            animatorSet5.removeAllListeners();
            this.toDockerAnimSet.cancel();
        }
        VoiceBarWaveView voiceBarWaveView = this.mVoiceWaveView;
        if (voiceBarWaveView != null) {
            voiceBarWaveView.releaseWaveAnim();
        }
        FrameLayout frameLayout = this.mOutContainer;
        if (frameLayout != null) {
            frameLayout.clearAnimation();
        }
        removeFromWindow();
        if (this.mHoverEventListener != null) {
            this.mHoverEventListener = null;
        }
        BarrierPool.getInstance().clear();
    }

    public void pause() {
        if (DEBUG) {
            Log.d(TAG, "pause");
        }
        this.mVoiceWaveView.pauseWaveAnim();
    }

    public void updateUI() {
        if (DEBUG) {
            Log.d(TAG, "updateUI: ");
        }
        try {
            boolean isNight = NightModeHelper.getNightModeSwitcherState();
            boolean z = false;
            if (!useNewHoverExt()) {
                this.mOutContainer.setBackground((Drawable) null);
                changeCardBackground(isNight);
            } else if (this.mViewState == 1) {
                this.mHoverOutsideCard.setCardBackgroundColor(0);
                this.mHoverOutsideCard.setCardElevation(0.0f);
                this.mOutContainer.setBackground(getResources().getDrawable(R.drawable.radio_background));
            } else {
                this.mOutContainer.setBackground((Drawable) null);
                this.mHoverOutsideCard.setCardElevation(10.0f);
                changeCardBackground(isNight);
            }
            CoverComponent coverComponent = this.mCoverComponent;
            if (!useNewHoverExt() || this.mViewState != 1) {
                z = true;
            }
            coverComponent.updateProgressColorByDefault(isNight, z);
            this.mVoiceWaveView.updateUI();
            updateNormalFontScaled();
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void changeCardBackground(boolean isNight) {
        if (isNight) {
            this.mHoverOutsideCard.setCardBackgroundColor(getResources().getColor(R.color.media_radio_mini_hover_expansion_color_night));
        } else if (over11onMiAndIsNight()) {
            this.mHoverOutsideCard.setCardBackgroundColor(getResources().getColor(R.color.media_radio_mini_hover_expansion_color_night));
        } else {
            this.mHoverOutsideCard.setCardBackgroundColor(getResources().getColor(R.color.media_radio_mini_hover_expansion_color_light));
        }
    }

    private boolean over11onMiAndIsNight() {
        boolean over11onMi = Build.VERSION.SDK_INT >= 30 && Build.BRAND.toLowerCase(Locale.getDefault()).contains("xiaomi");
        boolean isSysNight = AppCompatDelegate.getDefaultNightMode() == 2;
        boolean isSysNight2 = ((UiModeManager) getContext().getSystemService("uimode")).getNightMode() == 2;
        if (!over11onMi || (!isSysNight && !isSysNight2)) {
            return false;
        }
        return true;
    }

    private void updateNormalFontScaled() {
        if (this.mViewState == 0) {
            int normalScaled = getScaledNormalSize();
            this.mHoverOutsideCard.setRadius(((float) normalScaled) * 0.5f);
            int outNormalScaled = getCardScaledNormalSize();
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mOutContainer.getLayoutParams();
            lp.width = outNormalScaled;
            lp.height = (dp2px(5.0f) * 2) + normalScaled;
            this.mOutContainer.setLayoutParams(lp);
            this.mCoverComponent.setImageSize(((float) normalScaled) - (((float) dp2px(3.0f)) * 2.0f));
            int scaledPix19 = FontSizeHelper.getScaledSize(0, (float) dp2px(19.0f), 2);
            resetViewSize(this.mClickTipsLottieView, scaledPix19);
            resetViewSize(this.mClickTipsStaticView, scaledPix19);
        }
    }

    private void updateExtFontScaled() {
        if (!useNewHoverExt()) {
            int extBtnSize = FontSizeHelper.getScaledSize(0, (float) dp2px(17.0f), 2);
            if (getmNormalPlayView() != null) {
                resetViewSize(this.mNormalPlayView, extBtnSize);
            }
            View view2 = this.mNormalPauseView;
            if (view2 != null) {
                resetViewSize(view2, extBtnSize);
            }
            View view3 = this.mNextView;
            if (view3 != null) {
                resetViewSize(view3, extBtnSize);
            }
            View view4 = this.mCloseView;
            if (view4 != null) {
                resetViewSize(view4, extBtnSize);
            }
            ImageButton imageButton = this.mLongCloseButton;
            if (imageButton != null) {
                resetViewSize(imageButton, extBtnSize);
            }
            ImageButton imageButton2 = this.mLongNextButton;
            if (imageButton2 != null) {
                resetViewSize(imageButton2, extBtnSize);
            }
            LottieAnimationView lottieAnimationView = this.mLongPlayButton;
            if (lottieAnimationView != null) {
                resetViewSize(lottieAnimationView, extBtnSize);
            }
            ImageButton imageButton3 = this.mBtnVoiceManagement;
            if (imageButton3 != null) {
                resetViewSize(imageButton3, extBtnSize);
            }
            ImageButton imageButton4 = this.mBtnPureListen;
            if (imageButton4 != null) {
                resetViewSize(imageButton4, extBtnSize);
            }
        }
    }

    private View getmNormalPlayView() {
        return this.mNormalPlayView;
    }

    private void resetViewSize(View view2, int newsize) {
        ViewGroup.LayoutParams lp = view2.getLayoutParams();
        lp.width = newsize;
        lp.height = newsize;
        view2.setLayoutParams(lp);
    }

    private int dp2px(float dpvalue) {
        return DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), dpvalue);
    }

    public void startWaveAnim() {
        if (this.mVoiceWaveView != null) {
            if (DEBUG) {
                Log.d(TAG, "startWaveAnim " + this.mPlayState);
            }
            this.mVoiceWaveView.startWaveAnim();
            if (!isPlayingState()) {
                this.mVoiceWaveView.pauseWaveAnim();
            }
        }
    }

    private boolean isPlayingState() {
        return this.mPlayState == MusicPlayState.PLAY;
    }

    public boolean addToWindow() {
        View view2;
        if (DEBUG) {
            Log.d(TAG, "addToWindow: ");
        }
        this.hoverWindowController.addHoverLayout(this);
        Dragger dragger2 = this.dragger;
        if (!(dragger2 instanceof HoverViewDragger) || (view2 = ((HoverViewDragger) dragger2).dragView) == null) {
            return true;
        }
        this.hoverWindowController.addHoverLayout(view2);
        return true;
    }

    public void addToWindowOverlays() {
        if (HoverUtils.hasPermission(getContext())) {
            TTSFloatingWindow.Companion.with(AppRuntime.getAppContext()).setAnchorPair(0, this.anchorPair.getSecond().intValue()).setContent(this).setStatusListener(new IFloatingWindowListener() {
                public void onCreated(boolean isCreated, String msg, View view2) {
                    if (isCreated && view2 != null) {
                        HoverPlayerView.this.mOutContainer.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (HoverPlayerView.this.mDragListener != null) {
                                    HoverPlayerView.this.mDragListener.onTap(v, (MotionEvent) null);
                                }
                            }
                        });
                    }
                }

                public void onShow(View view2) {
                    HoverPlayerView.this.autoExtensionIfNeeded();
                }

                public void onHide(View view2) {
                }

                public void onDismiss() {
                }

                public void onTouchEvent(View view2, MotionEvent event) {
                    if (event.getActionMasked() == 4) {
                        HoverPlayerView.this.changeViewToNormal(true);
                    }
                }

                public void onDrag(View view2, MotionEvent event) {
                }

                public void onDragEnd(View view2) {
                }
            }).show();
            this.dragger = null;
            this.mFloatingModel = CreateStrategy.APP_WINDOW;
        }
    }

    public void setDragListener(Dragger.DragListener dragListener) {
        this.mDragListener = dragListener;
    }

    public Point getStartCenterPosition(int x, int y) {
        int width = getCardScaledNormalSize();
        return new Point((width / 2) + x, (width / 2) + y);
    }

    /* access modifiers changed from: protected */
    public boolean isRunOnMainProcess() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchOnTap() {
        return false;
    }

    public void setPosition(int duration, int position) {
        CoverComponent coverComponent = this.mCoverComponent;
        if (coverComponent != null) {
            if (this.mDuration <= 0) {
                this.mDuration = duration;
                coverComponent.setMaxProgress((float) duration);
            }
            if (position >= 0) {
                this.mCoverComponent.setProgress((float) position);
            }
        }
        if (this.mLongSubtitleContainer != null && MiniPlayerView.getInstance().getMode() == 1) {
            if (this.mLongSubtitleContainer.getVisibility() == 8) {
                showDefaultTitleStyle(false);
            }
            if (this.mDuration <= 0) {
                this.mLongSubtitle.setText(NO_PROGRESS);
            } else if (position >= 0) {
                this.mLongSubtitle.setText(TimeUtils.formatTime((long) position) + "/" + TimeUtils.formatTime((long) this.mDuration));
            }
        }
    }

    public void setDuration(int duration) {
        CoverComponent coverComponent;
        if (this.mDuration >= 0) {
            if (duration > 0) {
                CoverComponent coverComponent2 = this.mCoverComponent;
                if (coverComponent2 != null) {
                    coverComponent2.setMaxProgress((float) duration);
                }
            } else if (duration == 0 && (coverComponent = this.mCoverComponent) != null) {
                coverComponent.setProgress(0.0f);
            }
            this.mDuration = duration;
        }
        if (this.mLongSubtitleContainer != null && MiniPlayerView.getInstance().getMode() == 1) {
            if (this.mLongSubtitleContainer.getVisibility() == 8) {
                showDefaultTitleStyle(false);
            }
            if (this.mDuration <= 0) {
                this.mLongSubtitle.setText(NO_PROGRESS);
            } else {
                this.mLongSubtitle.setText(TimeUtils.formatTime(0) + "/" + TimeUtils.formatTime((long) this.mDuration));
            }
        }
    }

    public void setImage(String imgUrl) {
        IFeedTTSModel ttsModel;
        String coverImg;
        if (this.mHoverImg != null && this.mVoiceWaveView != null) {
            if (MiniPlayerView.getInstance().getMode() == 1 && (ttsModel = TTSRuntime.getInstance().getSpeechingFeed()) != null) {
                String firstImg = ttsModel.getFirstImageUrl();
                if (!TextUtils.isEmpty(firstImg)) {
                    imgUrl = firstImg;
                } else {
                    if (ttsModel.isFeedSong()) {
                        coverImg = ttsModel.getSongProperty().imgUrl;
                    } else {
                        coverImg = ttsModel.getCoverImg();
                    }
                    if (!TextUtils.isEmpty(coverImg)) {
                        imgUrl = coverImg;
                    }
                }
            }
            setCoverImg(imgUrl);
            startWaveAnim();
        }
    }

    private void setCoverImg(String imgUrl) {
        if (DEBUG) {
            Log.d(TAG, "setCoverImg: " + imgUrl);
        }
        if (!TextUtils.isEmpty(imgUrl)) {
            Uri uri = Uri.parse(imgUrl);
            if (imgUrl.startsWith("/") && new File(imgUrl).exists()) {
                uri = Uri.parse("file://" + imgUrl);
            }
            if (this.mHoverImg.getTag() == null) {
                this.mHoverImg.setTag(uri);
                this.mHoverImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.mHoverImg.setImageURI(uri);
            } else if (!TextUtils.equals(uri.toString(), this.mHoverImg.getTag().toString())) {
                this.mHoverImg.setTag(uri);
                this.mHoverImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                this.mHoverImg.setImageURI(uri);
            }
        } else {
            try {
                ((GenericDraweeHierarchy) this.mHoverImg.getHierarchy()).setPlaceholderImage(getResources().getDrawable(R.drawable.mini_player_default_img), ScalingUtils.ScaleType.CENTER_INSIDE);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            this.mHoverImg.setTag((Object) null);
            this.mHoverImg.setImageURI(imgUrl);
        }
    }

    public View getHoverBarrir() {
        return this.mOutContainer;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (!handleClickCoverArea(v, event) && (getContext() instanceof Activity)) {
            event.offsetLocation(0.0f, (float) DeviceUtils.ScreenInfo.getStatusBarHeight());
            ((Activity) getContext()).dispatchTouchEvent(event);
        }
        changeViewToNormal(true);
        return false;
    }

    public void setPreNextEnabled(boolean pre, boolean next) {
        ImageButton imageButton;
        View view2;
        TTSRuntime.nextBtnEnabled = next;
        if (this.mViewState == 1 && (view2 = this.mNextView) != null) {
            view2.setEnabled(next);
        }
        if (!NovelHelper.isNovelSource() && (imageButton = this.mLongNextButton) != null) {
            imageButton.setEnabled(next);
        }
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.mIsPlaying = isPlaying;
        if (useNewHoverExt()) {
            setPlayButtonNoAnimation();
            return;
        }
        if (this.mIsPlaying) {
            startWaveAnim();
        } else {
            pause();
        }
        View view2 = this.mNormalPlayView;
        if (view2 != null && this.mNormalPauseView != null) {
            if (this.mViewState != 1 && !this.mCustomTouchForNovel) {
                return;
            }
            if (this.mIsPlaying) {
                view2.setVisibility(8);
                this.mNormalPauseView.setVisibility(0);
                return;
            }
            view2.setVisibility(0);
            this.mNormalPauseView.setVisibility(8);
        }
    }

    public void setStatisticPageState(String pageState) {
        this.mStatisticPageState = pageState;
    }

    private boolean handleClickCoverArea(View v, MotionEvent ev) {
        if (this.mOutContainer == null) {
            return false;
        }
        if (!isTouchPointInView(this.mOutContainer, (int) ev.getRawX(), (int) ev.getRawY())) {
            return false;
        }
        if (this.mViewState == 1 && NovelHelper.isNovelSource()) {
            BdEventBus.Companion.getDefault().post(new MediaEvents(1));
            return true;
        } else if (this.mViewState != 1 || MiniPlayerView.getInstance().getMode() != 9) {
            return false;
        } else {
            BdEventBus.Companion.getDefault().post(new MediaEvents(7));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean isTouchPointInView(View view2, int x, int y) {
        if (view2 == null) {
            return false;
        }
        int[] location = new int[2];
        view2.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = view2.getMeasuredWidth() + left;
        int bottom = view2.getMeasuredHeight() + top;
        if (y < top || y > bottom || x < left || x > right) {
            return false;
        }
        return true;
    }

    public void onClick(View v) {
        IFeedTTSModel model;
        int i2 = v.getId();
        if (i2 == R.id.radio_mini_play_next) {
            hoverViewUBC(this.mStatisticPageState, "next");
            MusicUBCConstant.musicUBCEventOfPreClick(MiniPlayerView.getInstance().getRealMode(), "floating", "next");
            this.mHoverEventListener.skipToNext();
        } else if (i2 == R.id.radio_mini_play_close) {
            this.mHoverPlayerClickGuide.hideGuideBubble();
            if (this.mHoverEventListener != null) {
                hoverViewUBC(this.mStatisticPageState, "close");
                this.mHoverEventListener.closePlayer();
            }
        } else if (i2 == R.id.radio_mini_play_pause_container) {
            if (this.mHoverEventListener != null) {
                hoverViewUBC(this.mStatisticPageState, this.mIsPlaying ? "pause" : "play");
                this.mHoverEventListener.switchPlayPause();
            }
        } else if (i2 == R.id.radio_mini_play_pure_listen || i2 == R.id.ll_radio_mini_play_pure_listen) {
            MusicUBCConstant.musicEvent(MusicUBCConstant.TTS_LISTEN_PURE_LISTEN_CLK, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR, (String) null, (String) null, (String) null);
            PureListenRuntime.getPureListenContext().showPureListenPage(AppRuntime.getAppContext(), 1, PureListenUbcUtilsKt.UBC_PURE_LISTEN_MINIBAR_LIST_ENTRANCE_SOURCE, -1, (PlayerExtInfo) null);
        } else if (i2 == R.id.radio_mini_title || i2 == R.id.radio_mini_title_container) {
            MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MUSIC_TYPE_TOGGLE_BTN_CLK, "", MusicUBCConstant.getSource(MiniPlayerView.getInstance().getRealMode()), "full", (String) null);
            MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MINI_BAR_TITLE_CLK, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR, (String) null, (String) null, (String) null);
            IPureListenContext pureListenContext = PureListenRuntime.getPureListenContext();
            int mode = MiniPlayerView.getInstance().getMode();
            if (!PureListenRuntime.isSupportPureListening(mode) || !pureListenContext.isPureListenABType1()) {
                View.OnClickListener onClickListener = this.mTitleClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                MusicActivityPresenter.fullScreenPlayerRouter(AppRuntime.getAppContext(), mode, (String) null, PlayerExtInfoKt.getNotFullPlayerExtInfo());
                return;
            }
            pureListenContext.showPureListenPage(AppRuntime.getAppContext(), 1, PureListenUbcUtilsKt.UBC_PURE_LISTEN_MINIBAR_TITLE_SOURCE, -1, (PlayerExtInfo) null);
        } else if (i2 == R.id.flyt_mini_voice_management || i2 == R.id.btn_mini_voice_management) {
            MediaRuntime.getContext().logOnline("HoverPlayerView voiceBtn click >> " + this.mVoiceManagementEnable);
            if (!this.mVoiceManagementEnable) {
                UniversalToast.cancelToast();
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.tts_video_notsupport_voiceset).show();
                return;
            }
            JSONObject ext = new JSONObject();
            if (MiniPlayerView.getInstance().getMode() == 1 && (model = TTSRuntime.getInstance().getSpeechingFeed()) != null) {
                try {
                    ext.put("category", model.getExtInfo("category", ""));
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            if (VoiceManagementBubbleManager.getInstance().isShowing()) {
                MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MUSIC_ALBUM_EVENT_ID, MusicUBCConstant.UBC_TYPE_MINI_PLAYER_VOICE_BUBBLE_BTN_CLK, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR_VOICE_MANAGEMENT, MusicUBCConstant.getPage(), (String) null, ext.toString());
            }
            MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MUSIC_ALBUM_EVENT_ID, MusicUBCConstant.UBC_TYPE_MINI_PLAYER_VOICE_BTN_CLK, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR, MusicUBCConstant.getPage(), (String) null, ext.toString());
            if (!TTSRuntime.hasClickVoiceManagementBtn) {
                TTSRuntime.hasClickVoiceManagementBtn = true;
                FeedTTSPreferenceUtil.putBoolean("has_click_voice_management_btn", true);
            }
            dismissVoiceGuideAnimAndDot();
            showVoiceManagementView();
        }
    }

    private void updateVoiceManagementBtnVisibility() {
        int mode = MiniPlayerView.getInstance().getMode();
        if (mode == 1 || mode == -1) {
            showVoiceManagementBtn();
        } else {
            hideVoiceManagementBtn();
        }
    }

    public void hideVoiceManagementBtn() {
        if (this.mFlytVoiceManagement.getVisibility() != 8) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mFlytVoiceManagement.getLayoutParams();
            lp.width = this.mLongCloseButton.getMeasuredWidth();
            this.mFlytVoiceManagement.setLayoutParams(lp);
            this.mFlytVoiceManagement.setVisibility(8);
        }
    }

    public void showVoiceManagementBtn() {
        IFeedTTSModel model;
        if (this.mFlytVoiceManagement.getVisibility() != 0) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mFlytVoiceManagement.getLayoutParams();
            lp.width = getResources().getDimensionPixelOffset(R.dimen.radio_mini_operate_btn_width);
            this.mFlytVoiceManagement.setLayoutParams(lp);
            this.mFlytVoiceManagement.setVisibility(0);
            IMusic iMusic = this.mIMusic;
            if (iMusic != null) {
                iMusic.onShowSettingButton();
            }
            JSONObject ext = new JSONObject();
            if (MiniPlayerView.getInstance().getMode() == 1 && (model = TTSRuntime.getInstance().getSpeechingFeed()) != null) {
                try {
                    ext.put("category", model.getExtInfo("category", ""));
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MUSIC_ALBUM_EVENT_ID, MusicUBCConstant.UBC_TYPE_MINI_PLAYER_VOICE_BTN_SHOWN, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR, "tts", (String) null, ext.toString());
        }
    }

    private void showVoiceManagementView() {
        if (this.mIMusic != null) {
            this.mIMusic.showVoiceManagementView(BdBoxActivityManager.getRealTopActivity().findViewById(16908290), MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR);
        }
    }

    public void setVoiceManagementEnabled(boolean enabled) {
        this.mVoiceManagementEnable = enabled;
        if (this.mFlytVoiceManagement != null) {
            if (enabled) {
                this.mBtnVoiceManagement.setAlpha(1.0f);
            } else {
                this.mBtnVoiceManagement.setAlpha(0.4f);
            }
            boolean isVoiceManagementVisible = this.mFlytVoiceManagement.getVisibility() == 0;
            if (!enabled || !isVoiceManagementVisible || FeedTTSPreferenceUtil.getBoolean("has_click_voice_management_btn", false) || NovelHelper.isNovelSource()) {
                this.mLottieVoiceManagement.setVisibility(8);
            } else {
                this.mLottieVoiceManagement.setAnimation(VOICE_MANAGEMENT_GUIDE_ANIM);
                this.mLottieVoiceManagement.playAnimation();
                this.mLottieVoiceManagement.setVisibility(0);
            }
            if (!enabled || !isVoiceManagementVisible || !TTSRuntime.getInstance().shouldShowVoiceManagementDot(true ^ hasForcedSpeaker())) {
                this.mIvVoiceManagementDot.setVisibility(8);
                return;
            }
            this.mIvVoiceManagementDot.setImageDrawable(getResources().getDrawable(com.baidu.searchbox.bdmedia.interfaces.R.drawable.minibar_setting_dot));
            this.mIvVoiceManagementDot.setVisibility(0);
        }
    }

    private boolean hasForcedSpeaker() {
        IFeedTTSModel speechingFeed = TTSRuntime.getInstance().getSpeechingFeed();
        if (speechingFeed != null) {
            return !TextUtils.isEmpty(speechingFeed.getForcedSpeakerId());
        }
        return false;
    }

    private void dismissVoiceGuideAnimAndDot() {
        LottieAnimationView lottieAnimationView = this.mLottieVoiceManagement;
        if (lottieAnimationView != null && lottieAnimationView.getVisibility() == 0 && this.mLottieVoiceManagement.isAnimating()) {
            this.mLottieVoiceManagement.cancelAnimation();
            this.mLottieVoiceManagement.setVisibility(8);
        }
        ImageView imageView = this.mIvVoiceManagementDot;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.mIvVoiceManagementDot.setVisibility(8);
        }
    }

    public void showPureListenBtn() {
        FrameLayout frameLayout = this.mPureListenBtnLayout;
        if (frameLayout != null && frameLayout.getVisibility() != 0) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mPureListenBtnLayout.getLayoutParams();
            lp.width = getResources().getDimensionPixelOffset(R.dimen.radio_mini_operate_btn_width);
            this.mPureListenBtnLayout.setLayoutParams(lp);
            this.mPureListenBtnLayout.setVisibility(0);
            MusicUBCConstant.musicEvent(MusicUBCConstant.TTS_LISTEN_PURE_LISTEN_SHOW, MusicUBCConstant.UBC_MUSIC_SOURCE_MINIBAR, (String) null, (String) null, (String) null);
        }
    }

    public void hidePureListenBtn() {
        FrameLayout frameLayout = this.mPureListenBtnLayout;
        if (frameLayout != null && frameLayout.getVisibility() != 8) {
            this.mPureListenBtnLayout.setLayoutParams((RelativeLayout.LayoutParams) this.mPureListenBtnLayout.getLayoutParams());
            this.mPureListenBtnLayout.setVisibility(8);
        }
    }

    public void setTitle(String title) {
        this.mTitle = title;
        TextView textView = this.mTitleTextView;
        if (textView != null && !TextUtils.equals(textView.getText(), this.mTitle)) {
            this.mTitleTextView.setText(title);
        }
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
        View view2 = this.mLongSubtitleContainer;
        if (view2 != null) {
            if (view2.getVisibility() == 8) {
                showDefaultTitleStyle(false);
            }
            int mode = MiniPlayerView.getInstance().getMode();
            TextView textView = this.mLongSubtitle;
            if (textView == null) {
                return;
            }
            if (mode == 2 || mode == 6 || mode == 9) {
                textView.setText(artist);
            }
        }
    }

    class DefaultDragListener implements Dragger.DragListener {
        private HoverPlayerView viewInDrag;

        public DefaultDragListener(HoverPlayerView hoverPlayerView) {
            this.viewInDrag = hoverPlayerView;
        }

        public void onPress(float centerX, float centerY) {
            HoverPlayerView.this.mHoverPlayerClickGuide.hideGuideBubble();
        }

        public void onDragStart(float centerX, float centerY) {
            boolean unused = HoverPlayerView.this.mDraggable;
        }

        public void onDragTo(float centerX, float centerY) {
            HoverPlayerView hoverPlayerView;
            if (HoverPlayerView.this.mDraggable && (hoverPlayerView = this.viewInDrag) != null && hoverPlayerView.getHoverBarrir() != null) {
                int w = HoverPlayerView.this.getScaledNormalSize();
                this.viewInDrag.getHoverBarrir().setX(centerX - ((float) (w >> 1)));
                this.viewInDrag.getHoverBarrir().setY(centerY - ((float) (w >> 1)));
            }
        }

        public void onReleasedAt(float centerX, float centerY) {
            if (HoverPlayerView.this.mDraggable && this.viewInDrag != null) {
                Rect rect = BarrierPool.getInstance().getDestinationRect(this.viewInDrag.getHoverBarrir());
                if (rect != null) {
                    rect.top = Math.min(rect.top, HoverPlayerView.getDefaultHoverViewPosition().y);
                    this.viewInDrag.sendToDock((float) rect.left, (float) rect.top);
                }
                if (this.viewInDrag.isRunOnMainProcess() && HoverPlayerView.this.mHoverEventListener != null) {
                    HoverPlayerView.this.mHoverEventListener.onDragEnd();
                }
            }
        }

        public void onTap(View v, MotionEvent event) {
            if (HoverPlayerView.DEBUG) {
                Log.d(HoverPlayerView.TAG, "onTap()");
            }
            if (this.viewInDrag != null) {
                if (HoverPlayerView.this.toNormalAnimSet != null) {
                    HoverPlayerView.this.toNormalAnimSet.cancel();
                }
                if (HoverPlayerView.this.longToNormalAnimSet != null) {
                    HoverPlayerView.this.longToNormalAnimSet.cancel();
                }
                if (this.viewInDrag.getContext() != null) {
                    if (HoverPlayerView.this.mCustomTouchForNovel) {
                        if (!handleClick(v, event)) {
                            doOnTap();
                        }
                    } else if (!HoverPlayerView.this.needMultiViewState) {
                        doOnTap();
                    } else if (HoverPlayerView.this.mViewState == 0) {
                        HoverPlayerView.this.changeViewToExtension(true);
                    } else if (HoverPlayerView.this.mViewState == 1) {
                        doOnTap();
                    }
                }
            }
        }

        private boolean handleClick(View v, MotionEvent ev) {
            if (HoverPlayerView.this.mExtContainer == null) {
                return false;
            }
            ViewGroup containerView = (ViewGroup) HoverPlayerView.this.mExtContainer;
            int viewCount = containerView.getChildCount();
            int x = (int) ev.getRawX();
            int y = (int) ev.getRawY();
            for (int i2 = 0; i2 < viewCount; i2++) {
                View view2 = containerView.getChildAt(i2);
                if (HoverPlayerView.this.isTouchPointInView(view2, x, y)) {
                    if (view2.getId() == R.id.hover_ext_img_play || view2.getId() == R.id.hover_ext_img_pause) {
                        HoverPlayerView.this.clickExpansionPlay();
                        return true;
                    } else if (view2.getId() == R.id.hover_ext_close) {
                        HoverPlayerView.this.clickExpansionClose();
                        return true;
                    } else if (view2.getId() == R.id.radio_mini_play_pause_container || view2.getId() == R.id.radio_mini_play_next || view2.getId() == R.id.btn_mini_voice_management || view2.getId() == R.id.flyt_mini_voice_management || view2.getId() == R.id.radio_mini_play_close) {
                        HoverPlayerView.this.onClick(view2);
                        return true;
                    }
                }
            }
            return false;
        }

        private void doOnTap() {
            HoverPlayerView hoverPlayerView = HoverPlayerView.this;
            hoverPlayerView.hoverViewUBC(hoverPlayerView.mStatisticPageState, MusicUBCConstant.UBC_TTS_FLOATING_CLICK);
            HoverPlayerView.this.changeViewToNormal(false);
            if (!this.viewInDrag.dispatchOnTap() && this.viewInDrag.isRunOnMainProcess() && HoverPlayerView.this.mHoverEventListener != null) {
                HoverPlayerView.this.mHoverEventListener.onHoverTap();
            }
        }
    }

    private void addPadGlobalLayoutListener() {
        removePadGlobalLayoutListener();
        if (isPadStyleOrInMagicWindow()) {
            this.mGlobalLayoutListener = new HoverPlayerView$$ExternalSyntheticLambda0(this);
            try {
                getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$addPadGlobalLayoutListener$1$com-baidu-searchbox-radio-hover-HoverPlayerView  reason: not valid java name */
    public /* synthetic */ void m1689lambda$addPadGlobalLayoutListener$1$combaidusearchboxradiohoverHoverPlayerView() {
        WeakReference<Context> weakReference;
        int windowWidth;
        if (isPadStyleOrInMagicWindow() && (weakReference = this.mContextWeakReference) != null) {
            Context context = (Context) weakReference.get();
            if ((context instanceof Activity) && this.mGlobalLayoutWindowWidth != (windowWidth = HoverPadExtKt.getWindowWidth((Activity) context))) {
                if (DEBUG) {
                    Log.d(TAG, "onGlobalLayout update windowWidth:" + this.mGlobalLayoutWindowWidth + " -> " + windowWidth + ", context=" + getContext().getClass().getSimpleName());
                }
                if (this.mGlobalLayoutWindowWidth != 0) {
                    post(new HoverPlayerView$$ExternalSyntheticLambda2(this));
                }
                this.mGlobalLayoutWindowWidth = windowWidth;
            }
        }
    }

    private void removePadGlobalLayoutListener() {
        if (this.mGlobalLayoutListener != null) {
            try {
                getViewTreeObserver().removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
            } catch (Exception e2) {
            }
        }
    }

    private boolean isPadStyleOrInMagicWindow() {
        Context context;
        WeakReference<Context> weakReference = this.mContextWeakReference;
        if (weakReference == null || (context = (Context) weakReference.get()) == null) {
            return false;
        }
        if (HoverPadExtKt.isLeftSideBarStyle() || HoverPadExtKt.isInMagicWindow(context)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: adaptPadWhenWindowWidthChanged */
    public void m1688lambda$addPadGlobalLayoutListener$0$combaidusearchboxradiohoverHoverPlayerView() {
        LinkedList<WeakReference<Activity>> activityStack;
        FrameLayout.LayoutParams lp;
        try {
            if (this.mDraggable) {
                WeakReference<Context> weakReference = this.mContextWeakReference;
                if (weakReference != null) {
                    Context context = (Context) weakReference.get();
                    if (context != null && isPadStyleOrInMagicWindow() && (activityStack = BdBoxActivityManager.getActivityStack()) != null) {
                        Iterator it = activityStack.iterator();
                        while (it.hasNext()) {
                            WeakReference<Activity> activityWeakReference = (WeakReference) it.next();
                            if (activityWeakReference != null) {
                                Activity activityRef = (Activity) activityWeakReference.get();
                                if (activityRef != null) {
                                    if (!activityRef.isFinishing()) {
                                        if (activityRef == context) {
                                            FrameLayout frameLayout = this.mOutContainer;
                                            if (!(frameLayout == null || this.mViewState != 1 || (lp = (FrameLayout.LayoutParams) frameLayout.getLayoutParams()) == null)) {
                                                lp.width = getScaledExtSize();
                                                this.mOutContainer.setLayoutParams(lp);
                                            }
                                            postDelayed(new HoverPlayerView$$ExternalSyntheticLambda1(this), 50);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$adaptPadWhenWindowWidthChanged$2$com-baidu-searchbox-radio-hover-HoverPlayerView  reason: not valid java name */
    public /* synthetic */ void m1687lambda$adaptPadWhenWindowWidthChanged$2$combaidusearchboxradiohoverHoverPlayerView() {
        BarrierPool.getInstance().setScreenSize(getScreenWidth(), getHoverScreenHeight());
        Rect rect = BarrierPool.getInstance().getDestinationRect(getHoverBarrir());
        if (rect != null) {
            rect.top = Math.min(rect.top, getDefaultHoverViewPosition().y);
            sendToDock((float) rect.left, (float) rect.top);
        }
    }

    /* access modifiers changed from: private */
    public void changeViewToExtension(boolean isOnTap) {
        if (DEBUG) {
            Log.d(TAG, "changeViewToExtension: ");
        }
        if (this.mViewState != 1) {
            this.mViewState = 1;
            this.hoverWindowController.addTouchAbility(this);
            if (useNewHoverExt()) {
                startAnimToLongExtension(isOnTap);
            } else {
                startAnimToExtension(isOnTap);
            }
            hoverViewUBC(this.mStatisticPageState, MusicUBCConstant.UBC_TTS_FLOATING_TOBAR);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /* access modifiers changed from: private */
    public void changeViewToNormal(boolean useAnimator) {
        if (DEBUG) {
            Log.d(TAG, "changeViewToNormal: " + useAnimator);
        }
        if (this.mViewState != 0) {
            this.mViewState = 0;
            this.hoverWindowController.removeTouchAbility(this);
            this.mHoverPlayerClickGuide.hide();
            if (!useAnimator) {
                viewToNormalReal();
            } else if (useNewHoverExt()) {
                startAnimLongExtToNormal();
            } else {
                startAnimToNormal();
            }
        }
    }

    public int getScreenWidth() {
        WeakReference<Context> weakReference = this.mContextWeakReference;
        if (weakReference != null) {
            Context context = (Context) weakReference.get();
            if (isPadStyleOrInMagicWindow() && (context instanceof Activity)) {
                int hoverPadScreenWidth = HoverPadExtKt.getWindowWidth((Activity) context);
                if (DEBUG) {
                    Log.d(TAG, "getScreenWidth-pad/magic:" + hoverPadScreenWidth);
                }
                return hoverPadScreenWidth;
            }
        }
        int defaultScreenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d(TAG, "getScreenWidth-online:" + defaultScreenWidth);
        }
        return defaultScreenWidth;
    }

    private int getPadAdaptedWindowWidth() {
        Context context = (Context) this.mContextWeakReference.get();
        if (!HoverPadExtKt.isLeftSideBarStyle() || !(context instanceof Activity)) {
            return DeviceUtils.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext());
        }
        return PadCrossWidthAdaptUtilsKt.getPadAdaptedCrossWidth((Activity) context);
    }

    /* access modifiers changed from: private */
    public void viewToNormalReal() {
        if (DEBUG) {
            Log.d(TAG, "viewToNormalReal: ");
        }
        this.mViewState = 0;
        if (useNewHoverExt()) {
            removeLongExtViews();
            sendPlayerVisibleEvent(false);
        } else {
            removeExtViews();
        }
        updateUI();
        if (isOnScreenRightSide()) {
            int screenWidth = getScreenWidth();
            if (MediaRuntime.isSwanForeground) {
                TTSFloatingWindow.Companion.setWindowWidth(getWindowScaledNormalSize(), (screenWidth - getWindowScaledNormalSize()) - getHoverLRMargin());
            } else {
                FrameLayout frameLayout = this.mOutContainer;
                frameLayout.setX((float) ((screenWidth - frameLayout.getMeasuredWidth()) - getHoverLRMargin()));
            }
        }
        deactivateDragger();
        toActiveDragger();
    }

    public int getDefaultBottomMargin() {
        int bottom;
        if (useNewHoverExt()) {
            bottom = AppRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.android.common.ui.style.R.dimen.common_tool_bar_height);
        } else {
            bottom = HoverLayout.HOVER_BOTTOM_MARGIN_DEFAULT;
        }
        return AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.radio_mini_container_margin_left) + bottom;
    }

    private void removeLongExtViews() {
        ViewGroup viewGroup = this.mHoverExtContainer;
        if (viewGroup != null && viewGroup.getChildCount() >= 2) {
            this.mHoverExtContainer.removeViewAt(1);
        }
        this.mExtContainer = null;
        ImageButton imageButton = this.mLongNextButton;
        if (imageButton != null) {
            imageButton.setOnClickListener((View.OnClickListener) null);
            this.mLongNextButton = null;
        }
        ImageButton imageButton2 = this.mLongCloseButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener((View.OnClickListener) null);
            this.mLongCloseButton = null;
        }
        View view2 = this.mLongPlayContainer;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
            this.mLongPlayContainer = null;
        }
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setOnClickListener((View.OnClickListener) null);
            this.mTitleTextView = null;
        }
        ImageButton imageButton3 = this.mBtnVoiceManagement;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener((View.OnClickListener) null);
            this.mBtnVoiceManagement = null;
        }
        FrameLayout frameLayout = this.mFlytVoiceManagement;
        if (frameLayout != null) {
            frameLayout.setOnClickListener((View.OnClickListener) null);
            this.mFlytVoiceManagement = null;
        }
        FrameLayout frameLayout2 = this.mPureListenBtnLayout;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener((View.OnClickListener) null);
            this.mPureListenBtnLayout = null;
        }
        ImageButton imageButton4 = this.mBtnPureListen;
        if (imageButton4 != null) {
            imageButton4.setOnClickListener((View.OnClickListener) null);
            this.mBtnPureListen = null;
        }
    }

    private void removeExtViews() {
        ViewGroup viewGroup = this.mHoverExtContainer;
        if (viewGroup != null && viewGroup.getChildCount() >= 2) {
            this.mHoverExtContainer.removeViewAt(1);
        }
        this.mExtContainer = null;
        View view2 = this.mNormalPlayView;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
        }
        View view3 = this.mNormalPauseView;
        if (view3 != null) {
            view3.setOnClickListener((View.OnClickListener) null);
        }
        View view4 = this.mNextView;
        if (view4 != null) {
            view4.setOnClickListener((View.OnClickListener) null);
        }
        View view5 = this.mCloseView;
        if (view5 != null) {
            view5.setOnClickListener((View.OnClickListener) null);
        }
        this.mNormalPlayView = null;
        this.mNormalPauseView = null;
        this.mNextView = null;
        this.mCloseView = null;
    }

    private ValueAnimator createRadiusAnimator(float from, float to, long delay, long duration) {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{from, to});
        animator.setDuration(duration);
        if (delay > 0) {
            animator.setStartDelay(delay);
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (HoverPlayerView.this.mOutContainer != null) {
                    Drawable drawable = HoverPlayerView.this.mOutContainer.getBackground();
                    if (drawable instanceof GradientDrawable) {
                        GradientDrawable d2 = (GradientDrawable) drawable;
                        d2.setCornerRadius(((Float) animation.getAnimatedValue()).floatValue());
                        HoverPlayerView.this.mOutContainer.setBackground(d2);
                    }
                }
            }
        });
        return animator;
    }

    private ValueAnimator createVoiceAlphaAnimator(float from, float to, long delay, long duration) {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{from, to});
        animator.setDuration(duration);
        if (delay > 0) {
            animator.setStartDelay(delay);
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (HoverPlayerView.this.mVoiceWaveView != null) {
                    float alpha = ((Float) animation.getAnimatedValue()).floatValue();
                    HoverPlayerView.this.mVoiceWaveView.setAlpha(alpha);
                    if (alpha <= 0.0f) {
                        HoverPlayerView.this.mVoiceWaveView.setVisibility(8);
                    } else {
                        HoverPlayerView.this.mVoiceWaveView.setVisibility(0);
                    }
                }
            }
        });
        return animator;
    }

    private ValueAnimator createHoverProgressColorAnimator(int from, int to, long delay, long duration) {
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{from, to});
        animator.setDuration(duration);
        if (delay > 0) {
            animator.setStartDelay(delay);
        }
        animator.setEvaluator(new ArgbEvaluator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (HoverPlayerView.this.mCoverComponent != null) {
                    HoverPlayerView.this.mCoverComponent.setSecondaryProgressColor(((Integer) animation.getAnimatedValue()).intValue());
                }
            }
        });
        return animator;
    }

    private ValueAnimator createHoverBgAnimator(float from, float to, long delay, long duration) {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{from, to});
        animator.setDuration(duration);
        if (delay > 0) {
            animator.setStartDelay(delay);
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (HoverPlayerView.this.mOutContainer != null) {
                    Drawable drawable = HoverPlayerView.this.mOutContainer.getBackground();
                    if (drawable instanceof GradientDrawable) {
                        GradientDrawable d2 = (GradientDrawable) drawable;
                        d2.setAlpha((int) (((Float) animation.getAnimatedValue()).floatValue() * 255.0f));
                        HoverPlayerView.this.mOutContainer.setBackground(d2);
                        return;
                    }
                    GradientDrawable d3 = new GradientDrawable();
                    d3.setShape(0);
                    d3.setColor(HoverPlayerView.this.getContext().getResources().getColor(R.color.radio_mini_container_background_color));
                    d3.setAlpha((int) (((Float) animation.getAnimatedValue()).floatValue() * 255.0f));
                    HoverPlayerView.this.mOutContainer.setBackground(d3);
                }
            }
        });
        return animator;
    }

    private ValueAnimator createWidthAnimator(final int widthFrom, final int widthTo, long startDelay) {
        ValueAnimator widthAnimator = ValueAnimator.ofInt(new int[]{widthFrom, widthTo});
        widthAnimator.setDuration(useNewHoverExt() ? 320 : 300);
        if (startDelay > 0) {
            widthAnimator.setStartDelay(startDelay);
        }
        final boolean isOnRight = isOnScreenRightSide();
        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (HoverPlayerView.this.mOutContainer != null) {
                    FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) HoverPlayerView.this.mOutContainer.getLayoutParams();
                    lp.width = ((Integer) animation.getAnimatedValue()).intValue();
                    HoverPlayerView.this.mOutContainer.setLayoutParams(lp);
                    if (isOnRight) {
                        int sw = HoverPlayerView.this.getScreenWidth();
                        if (!MediaRuntime.isSwanForeground) {
                            HoverPlayerView.this.mOutContainer.setX((float) ((sw - lp.width) - HoverPlayerView.this.getHoverLRMargin()));
                        } else if (widthFrom > widthTo) {
                            TTSFloatingWindow.Companion.setWindowWidth(HoverPlayerView.this.getWindowScaledExtSize(), (sw - lp.width) - HoverPlayerView.this.getHoverLRMargin());
                        } else {
                            TTSFloatingWindow.Companion.setWindowWidth(HoverPlayerView.this.getWindowScaledExtSize(), (sw - lp.width) - HoverPlayerView.this.getHoverLRMargin());
                        }
                    }
                }
            }
        });
        return widthAnimator;
    }

    private void setExpansionWidth(int value) {
        FrameLayout frameLayout = this.mOutContainer;
        if (frameLayout != null) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            lp.width = value;
            this.mOutContainer.setLayoutParams(lp);
            if (isOnScreenRightSide()) {
                int sw = getScreenWidth();
                if (MediaRuntime.isSwanForeground) {
                    TTSFloatingWindow.Companion.setWindowWidth(getWindowScaledExtSize(), (sw - lp.width) - HoverLayout.HOVER_MARGIN_SIDE);
                } else {
                    this.mOutContainer.setX((float) ((sw - lp.width) - HoverLayout.HOVER_MARGIN_SIDE));
                }
            }
        }
    }

    private int getXOnScreen(View view2) {
        int[] location = new int[2];
        view2.getLocationOnScreen(location);
        return location[0];
    }

    private ValueAnimator createLongExtAlphaAnimator(float alphaFrom, float alphaTo, long startDelay, long duration, ValueAnimator.AnimatorUpdateListener listener) {
        ValueAnimator alphaAnimator = ValueAnimator.ofFloat(new float[]{alphaFrom, alphaTo});
        if (startDelay > 0) {
            alphaAnimator.setStartDelay(startDelay);
        }
        alphaAnimator.setDuration(duration);
        alphaAnimator.addUpdateListener(listener);
        return alphaAnimator;
    }

    private ValueAnimator createAlphaAnimator(float alphaFrom, float alphaTo, long startDelay) {
        ValueAnimator alphaAnimator = ValueAnimator.ofFloat(new float[]{alphaFrom, alphaTo});
        if (startDelay > 0) {
            alphaAnimator.setStartDelay(startDelay);
        }
        alphaAnimator.setDuration(300);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if (HoverPlayerView.this.mExtContainer != null) {
                    HoverPlayerView.this.mExtContainer.setAlpha(((Float) animation.getAnimatedValue()).floatValue());
                }
            }
        });
        return alphaAnimator;
    }

    private void startAnimLongExtToNormal() {
        if (DEBUG) {
            Log.d(TAG, "startAnimLongExtToNormal: ");
        }
        ValueAnimator widthAnimator = createWidthAnimator(getScaledExtSize(), getCardScaledNormalSize(), 0);
        ValueAnimator bgAnimator = createHoverBgAnimator(1.0f, 0.0f, 200, 320);
        ValueAnimator progressAnimator = createHoverProgressColorAnimator(this.mCoverComponent.getSecondaryProgressColor(false), this.mCoverComponent.getSecondaryProgressColor(true), 0, 320);
        ValueAnimator voiceAnimator = createVoiceAlphaAnimator(0.0f, 1.0f, 280, 40);
        int toRadius = getContext().getResources().getDimensionPixelSize(R.dimen.radio_mini_container_background_corner);
        int i2 = toRadius;
        ValueAnimator radiusAnim = createRadiusAnimator((float) toRadius, this.mHoverOutsideCard.getRadius(), 0, 320);
        AnimatorSet animatorSet = new AnimatorSet();
        this.longToNormalAnimSet = animatorSet;
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                if (VoiceManagementBubbleManager.getInstance().isShowing()) {
                    VoiceManagementBubbleManager.getInstance().dismissBubble();
                }
                HoverPlayerView.this.deactivateDragger();
            }

            public void onAnimationEnd(Animator animation) {
                HoverPlayerView.this.viewToNormalReal();
                HoverPlayerView.this.setAppFloatingNormalWidth();
            }

            public void onAnimationCancel(Animator animation) {
                HoverPlayerView.this.setAppFloatingNormalWidth();
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        this.longToNormalAnimSet.playTogether(new Animator[]{widthAnimator, bgAnimator, progressAnimator, voiceAnimator, radiusAnim});
        this.longToNormalAnimSet.start();
    }

    private void startAnimToNormal() {
        if (DEBUG) {
            Log.d(TAG, "startAnimToNormal: ");
        }
        boolean isNovelSource = NovelHelper.isNovelSource() || MiniPlayerView.getInstance().getMode() == 9;
        int extWidth = getScaledExtSize();
        ValueAnimator widthAnimator = createWidthAnimator(isNovelSource ? getScaledNovelExtSize() : extWidth, getCardScaledNormalSize(), 200);
        ValueAnimator alphaAnimator = createAlphaAnimator(1.0f, 0.0f, 240);
        AnimatorSet animatorSet = new AnimatorSet();
        this.toNormalAnimSet = animatorSet;
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                HoverPlayerView.this.viewToNormalReal();
                HoverPlayerView.this.setAppFloatingNormalWidth();
            }

            public void onAnimationCancel(Animator animation) {
                HoverPlayerView.this.setAppFloatingNormalWidth();
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        this.toNormalAnimSet.playTogether(new Animator[]{widthAnimator, alphaAnimator});
        this.toNormalAnimSet.start();
    }

    /* access modifiers changed from: private */
    public void setAppFloatingNormalWidth() {
        if (this.mOutContainer != null && MediaRuntime.isSwanForeground && !isOnScreenRightSide()) {
            TTSFloatingWindow.Companion.setWindowWidth(getWindowScaledNormalSize(), 0);
        }
    }

    private void preSetAppFloatingExpansionWidth() {
        if (this.mOutContainer != null && MediaRuntime.isSwanForeground) {
            int windowExt = getWindowScaledExtSize();
            if (isOnScreenRightSide()) {
                TTSFloatingWindow.Companion.setWindowWidth(windowExt, (getScreenWidth() - windowExt) - getHoverLRMargin());
            } else {
                TTSFloatingWindow.Companion.setWindowWidth(getHoverLRMargin() + windowExt, 0);
            }
        }
    }

    public void layoutExpansion(Context context) {
        this.mViewState = 1;
        setExpansionWidth(getScaledNovelExtSize());
        inflateExpansion(context);
        activateExpansion();
    }

    public void customForNovel(boolean touchCustom) {
        this.mCustomTouchForNovel = touchCustom;
    }

    public void setDraggable(boolean draggable) {
        this.mDraggable = false;
        Dragger dragger2 = this.dragger;
        if (dragger2 != null) {
            dragger2.setDraggable(draggable);
        }
    }

    private void startAnimToLongExtension(boolean isOnTap) {
        if (DEBUG) {
            Log.d(TAG, "startAnimToLongExtension: ");
        }
        ValueAnimator widthAnimator = createWidthAnimator(getCardScaledNormalSize(), getScaledExtSize(), 0);
        ValueAnimator bgAnimator = createHoverBgAnimator(0.0f, 1.0f, 0, 120);
        ValueAnimator progressAnimator = createHoverProgressColorAnimator(this.mCoverComponent.getSecondaryProgressColor(true), this.mCoverComponent.getSecondaryProgressColor(false), 0, 320);
        ValueAnimator voiceAnimator = createVoiceAlphaAnimator(1.0f, 0.0f, 0, 40);
        int toRadius = getContext().getResources().getDimensionPixelSize(R.dimen.radio_mini_container_background_corner);
        int i2 = toRadius;
        ValueAnimator radiusAnim = createRadiusAnimator(this.mHoverOutsideCard.getRadius(), (float) toRadius, 0, 320);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mToLongExtentionAnimSet = animatorSet;
        final boolean z = isOnTap;
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                if (!HoverPlayerView.this.isOnScreenRightSide()) {
                    HoverPlayerView.this.mOutContainer.setX((float) HoverPlayerView.this.getHoverLRMargin());
                }
                HoverPlayerView.this.mHoverOutsideCard.setCardBackgroundColor(0);
                HoverPlayerView.this.mHoverOutsideCard.setCardElevation(0.0f);
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(0);
                drawable.setColor(HoverPlayerView.this.getContext().getResources().getColor(R.color.radio_mini_container_background_color));
                drawable.setAlpha(0);
                drawable.setCornerRadius(HoverPlayerView.this.mHoverOutsideCard.getRadius());
                HoverPlayerView.this.mOutContainer.setBackground(drawable);
                HoverPlayerView hoverPlayerView = HoverPlayerView.this;
                hoverPlayerView.inflateExpansion((Context) hoverPlayerView.mContextWeakReference.get());
            }

            public void onAnimationEnd(Animator animation) {
                if (HoverPlayerView.DEBUG) {
                    Log.d(HoverPlayerView.TAG, "startAnimToLongExtension: End");
                }
                Context context = (Context) HoverPlayerView.this.mContextWeakReference.get();
                if (context != null) {
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        HoverPlayerView.this.mHoverPlayerClickGuide.showGuideBubble(z);
                        HoverPlayerView.this.activateExpansion();
                        if (!z) {
                            FeedTTSPreferenceUtil.putInt(HoverPlayerClickGuideKt.HOVER_HAS_EXTENSION, 1);
                        }
                    }
                }
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        this.mToLongExtentionAnimSet.playTogether(new Animator[]{widthAnimator, bgAnimator, progressAnimator, voiceAnimator, radiusAnim});
        this.mToLongExtentionAnimSet.start();
        preSetAppFloatingExpansionWidth();
    }

    private void startAnimToExtension(final boolean isOnTap) {
        if (DEBUG) {
            Log.d(TAG, "startAnimToExtension: ");
        }
        ValueAnimator widthAnimator = createWidthAnimator(getCardScaledNormalSize(), NovelHelper.isNovelSource() || MiniPlayerView.getInstance().getMode() == 9 ? getScaledNovelExtSize() : getScaledExtSize(), 0);
        ValueAnimator alphaAnimator = createAlphaAnimator(0.0f, 1.0f, 200);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mToExtentionAnimSet = animatorSet;
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                HoverPlayerView.this.mHoverPlayerClickGuide.show(isOnTap);
                HoverPlayerView hoverPlayerView = HoverPlayerView.this;
                hoverPlayerView.inflateExpansion((Context) hoverPlayerView.mContextWeakReference.get());
                if (HoverPlayerView.this.mExtContainer != null) {
                    HoverPlayerView.this.mExtContainer.setAlpha(0.0f);
                }
            }

            public void onAnimationEnd(Animator animation) {
                if (HoverPlayerView.DEBUG) {
                    Log.d(HoverPlayerView.TAG, "viewToExt: onAnimationEnd");
                }
                Context context = (Context) HoverPlayerView.this.mContextWeakReference.get();
                if (context != null) {
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        HoverPlayerView.this.mHoverPlayerClickGuide.showGuideBubble(isOnTap);
                        HoverPlayerView.this.activateExpansion();
                        if (HoverPlayerView.this.mExtContainer != null) {
                            HoverPlayerView.this.mExtContainer.setAlpha(1.0f);
                        }
                        if (!isOnTap) {
                            FeedTTSPreferenceUtil.putInt(HoverPlayerClickGuideKt.HOVER_HAS_EXTENSION, 1);
                        }
                    }
                }
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        this.mToExtentionAnimSet.playTogether(new Animator[]{widthAnimator, alphaAnimator});
        this.mToExtentionAnimSet.start();
        preSetAppFloatingExpansionWidth();
    }

    /* access modifiers changed from: private */
    public void inflateExpansion(Context context) {
        if (DEBUG) {
            Log.d(TAG, "inflateExpansion");
        }
        if (context != null) {
            if (NovelHelper.isInNovelReaderActivity(BdBoxActivityManager.getRealTopActivity())) {
                context = AppRuntime.getAppContext();
            }
            try {
                if (useNewHoverExt()) {
                    LayoutInflater.from(context).inflate(R.layout.media_hover_player_ext_long, this.mHoverExtContainer, true);
                } else {
                    LayoutInflater.from(context).inflate(R.layout.media_hover_player_ext, this.mHoverExtContainer, true);
                }
            } catch (InflateException inflateException) {
                if (DEBUG) {
                    Log.e(TAG, "inflate -> media_hover_player_ext error : " + inflateException.getMessage());
                }
            }
            this.mExtContainer = this.mHoverExtContainer.findViewById(R.id.ext_container);
            if (useNewHoverExt()) {
                findViewsInExtLong();
                initPlayButtonAnimation();
                IPureListenContext pureListenContext = PureListenRuntime.getPureListenContext();
                if (!PureListenRuntime.isSupportPureListening(MiniPlayerView.getInstance().getMode()) || pureListenContext == null || (!pureListenContext.isPureListenABType2() && !pureListenContext.isPureListenABType3())) {
                    hidePureListenBtn();
                    updateVoiceManagementBtnVisibility();
                    return;
                }
                showPureListenBtn();
                hideVoiceManagementBtn();
                return;
            }
            findViewsInExt();
        }
    }

    private void updateExtImage(View view2, int drawableRes) {
        Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(drawableRes);
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            BitmapDrawable d2 = new BitmapDrawable(getResources(), bitmap);
            BitmapDrawable d04 = new BitmapDrawable(getResources(), bitmap);
            d04.setAlpha(102);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{-16842910}, d04);
            stateListDrawable.addState(new int[]{16842910, 16842919}, d04);
            stateListDrawable.addState(new int[]{16842910, -16842919}, d2);
            if (view2 != null) {
                view2.setBackground(stateListDrawable);
            }
        }
    }

    private void findViewsInExtLong() {
        IFeedTTSModel ttsModel;
        if (DEBUG) {
            Log.d(TAG, "findViewsInExtLong: ");
        }
        View view2 = this.mExtContainer;
        if (view2 != null) {
            this.mTitleContainer = view2.findViewById(R.id.radio_mini_title_container);
            this.mTitleTextView = (TextView) this.mExtContainer.findViewById(R.id.radio_mini_title);
            this.mLongPlayButton = (LottieAnimationView) this.mExtContainer.findViewById(R.id.radio_mini_play_pause);
            this.mLongPlayContainer = this.mExtContainer.findViewById(R.id.radio_mini_play_pause_container);
            this.mLongSubtitle = (TextView) this.mExtContainer.findViewById(R.id.radio_mini_subtitle);
            this.mLongSubtitleContainer = this.mExtContainer.findViewById(R.id.radio_mini_subtitle_container);
            this.mLongNextButton = (ImageButton) this.mExtContainer.findViewById(R.id.radio_mini_play_next);
            this.mFlytVoiceManagement = (FrameLayout) this.mExtContainer.findViewById(R.id.flyt_mini_voice_management);
            this.mLottieVoiceManagement = (LottieAnimationView) this.mExtContainer.findViewById(R.id.lottie_voice_management);
            this.mBtnVoiceManagement = (ImageButton) this.mExtContainer.findViewById(R.id.btn_mini_voice_management);
            this.mIvVoiceManagementDot = (ImageView) this.mExtContainer.findViewById(R.id.iv_mini_voice_management_dot);
            this.mPureListenBtnLayout = (FrameLayout) this.mExtContainer.findViewById(R.id.ll_radio_mini_play_pure_listen);
            this.mBtnPureListen = (ImageButton) this.mExtContainer.findViewById(R.id.radio_mini_play_pure_listen);
            this.mLongCloseButton = (ImageButton) this.mExtContainer.findViewById(R.id.radio_mini_play_close);
            showDefaultTitleStyle(true);
            setPlayButtonNoAnimation();
            TextView textView = this.mTitleTextView;
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.radio_mini_title_color));
                this.mLongSubtitle.setTextColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.radio_mini_subtitle_color));
                updateExtImage(this.mLongNextButton, R.drawable.radio_mini_next);
                if (!NovelHelper.isNovelSource()) {
                    this.mLongNextButton.setEnabled(TTSRuntime.nextBtnEnabled);
                }
                ExpandTouchAreaHelper.expandTouchArea(this.mExtContainer, this.mLongNextButton, DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 12.0f));
                updateExtImage(this.mBtnVoiceManagement, R.drawable.tts_mini_voice_management);
                updateExtImage(this.mBtnPureListen, R.drawable.tts_mini_pure_listen);
                updateExtImage(this.mLongCloseButton, R.drawable.radio_mini_close);
                ExpandTouchAreaHelper.expandTouchArea(this.mExtContainer, this.mLongCloseButton, DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 12.0f));
            }
            if (TextUtils.isEmpty(this.mTitle) && MiniPlayerView.getInstance().getMode() == 1 && (ttsModel = TTSRuntime.getInstance().getSpeechingFeed()) != null) {
                this.mTitle = ttsModel.getTTSShowTitle();
            }
            setTitle(this.mTitle);
            setArtist(this.mArtist);
            setPosition(this.mDuration, MiniPlayerView.getInstance().getPosition());
            setVoiceManagementEnabled(this.mVoiceManagementEnable);
            IPureListenContext pureListenContext = PureListenRuntime.getPureListenContext();
            if (!PureListenRuntime.isSupportPureListening(MiniPlayerView.getInstance().getMode()) || pureListenContext == null || (!pureListenContext.isPureListenABType2() && !pureListenContext.isPureListenABType3())) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.mLongNextButton.getLayoutParams();
                if (params != null) {
                    params.addRule(0, R.id.flyt_mini_voice_management);
                }
                tryToShowVoiceManagementBubble(this);
            } else {
                RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) this.mLongNextButton.getLayoutParams();
                if (params2 != null) {
                    params2.addRule(0, R.id.ll_radio_mini_play_pure_listen);
                }
            }
            deactivateDragger();
            updateExtFontScaled();
        }
    }

    public void tryToShowVoiceManagementBubble(final ViewGroup parent) {
        if (!isNovel()) {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Context context = (Context) HoverPlayerView.this.mContextWeakReference.get();
                    if (!(context instanceof Activity) || !ActivityUtils.isDestroyed((Activity) context)) {
                        IFeedTTSModel ttsModel = TTSRuntime.getInstance().getSpeechingFeed();
                        if (HoverPlayerView.this.mFlytVoiceManagement != null && HoverPlayerView.this.mFlytVoiceManagement.isShown() && ttsModel != null && TextUtils.isEmpty(ttsModel.getForcedSpeakerId()) && !ttsModel.isVideoTts() && !ttsModel.isFeedSong() && !ttsModel.isAigc()) {
                            VoiceManagementBubbleManager.getInstance().showBubble(HoverPlayerView.this.mFlytVoiceManagement, parent);
                        }
                    }
                }
            }, 500);
        }
    }

    private void initPlayButtonAnimation() {
        this.mLongPlayButton.addAnimatorListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
                HoverPlayerView.this.mLongPlayButton.setEnabled(false);
            }

            public void onAnimationEnd(Animator animation) {
                MusicPlayState unused = HoverPlayerView.this.mLonglottieState = MiniPlayerView.getInstance().getPlayState();
                HoverPlayerView.this.setPlayButtonNoAnimation();
                HoverPlayerView.this.mLongPlayButton.setEnabled(true);
            }

            public void onAnimationCancel(Animator animation) {
                HoverPlayerView.this.mLongPlayButton.setEnabled(true);
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    public void startPlayButtonAnimation() {
        if (this.mLongPlayButton != null && this.mLonglottieState != MiniPlayerView.getInstance().getPlayState()) {
            if (this.mLongPlayButton.isAnimating()) {
                this.mLongPlayButton.cancelAnimation();
            }
            loadLottieForPlayButton();
            this.mLongPlayButton.playAnimation();
        }
    }

    private void loadLottieForPlayButton() {
        String lottieJson;
        if (MiniPlayerView.getInstance().getPlayState() == MusicPlayState.PLAY) {
            if (MediaRuntime.getNightMode()) {
                lottieJson = "lottie/mini_player_play_to_pause_night.json";
            } else {
                lottieJson = "lottie/mini_player_play_to_pause.json";
            }
        } else if (MediaRuntime.getNightMode()) {
            lottieJson = "lottie/mini_player_pause_to_play_night.json";
        } else {
            lottieJson = "lottie/mini_player_pause_to_play.json";
        }
        this.mLongPlayButton.setAnimation(lottieJson);
    }

    public void setPlayButtonNoAnimation() {
        MusicPlayState playState = MiniPlayerView.getInstance().getPlayState();
        this.mLonglottieState = playState;
        if (this.mLongPlayButton != null) {
            this.mLongPlayButton.setImageDrawable(playState == MusicPlayState.PLAY ? ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.radio_mini_pause_normal) : ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.radio_mini_play_normal));
        }
    }

    private void showDefaultTitleStyle(boolean isDefault) {
        if (isDefault) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mTitleTextView.getLayoutParams();
            lp.gravity = 17;
            this.mTitleTextView.setLayoutParams(lp);
            this.mLongSubtitleContainer.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams lp2 = (LinearLayout.LayoutParams) this.mTitleTextView.getLayoutParams();
        lp2.gravity = 80;
        this.mTitleTextView.setLayoutParams(lp2);
        this.mLongSubtitleContainer.setVisibility(0);
    }

    private void findViewsInExt() {
        if (DEBUG) {
            Log.d(TAG, "findViewsInExt: ");
        }
        View view2 = this.mExtContainer;
        if (view2 != null) {
            this.mNormalPlayView = view2.findViewById(R.id.hover_ext_img_play);
            this.mNormalPauseView = this.mExtContainer.findViewById(R.id.hover_ext_img_pause);
            this.mNextView = this.mExtContainer.findViewById(R.id.hover_ext_next);
            this.mCloseView = this.mExtContainer.findViewById(R.id.hover_ext_close);
            this.mNextView.setEnabled(TTSRuntime.nextBtnEnabled);
            if (this.mIsPlaying) {
                this.mNormalPlayView.setVisibility(8);
                this.mNormalPauseView.setVisibility(0);
            } else {
                this.mNormalPlayView.setVisibility(0);
                this.mNormalPauseView.setVisibility(8);
            }
            updateExtImage(this.mNormalPlayView, R.drawable.media_hover_ext_play);
            updateExtImage(this.mNormalPauseView, R.drawable.media_hover_ext_pause);
            updateExtImage(this.mNextView, R.drawable.media_hover_ext_next);
            updateExtImage(this.mCloseView, R.drawable.media_hover_ext_close);
            updateUI();
            updateExtFontScaled();
            if (isNovel()) {
                this.mNextView.setVisibility(8);
            }
            deactivateDragger();
        }
    }

    private boolean isNovel() {
        return NovelHelper.isNovelSource() || MiniPlayerView.getInstance().getMode() == 9;
    }

    private int getTouchArea() {
        return this.mCustomTouchForNovel ? getScaledNovelExtSize() : getCardScaledNormalSize();
    }

    /* access modifiers changed from: private */
    public void activateExpansion() {
        if (DEBUG) {
            Log.d(TAG, "activateExpansion");
        }
        toActiveDragger();
        if (useNewHoverExt()) {
            activeLongExtClickEvent();
            sendPlayerVisibleEvent(true);
            return;
        }
        activeExtClickEvent();
    }

    private void sendPlayerVisibleEvent(boolean show) {
        int i2;
        TTSPlayerEvent ttsPlayerEvent = new TTSPlayerEvent();
        if (show) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        ttsPlayerEvent.ttsPlayerState = i2;
        Rect r = new Rect();
        this.mOutContainer.getGlobalVisibleRect(r);
        r.top += DeviceUtils.ScreenInfo.getStatusBarHeight();
        r.bottom += DeviceUtils.ScreenInfo.getStatusBarHeight();
        ttsPlayerEvent.playerRect = r;
        BdEventBus.Companion.getDefault().post(ttsPlayerEvent);
    }

    /* access modifiers changed from: private */
    public void toActiveDragger() {
        if (this.mOutContainer != null) {
            int w = getTouchArea();
            int h2 = getCardScaledNormalSize();
            Point dragCenterPosition = new Point();
            dragCenterPosition.x = (int) (this.mOutContainer.getX() + ((float) (w / 2)));
            dragCenterPosition.y = (int) (this.mOutContainer.getY() + ((float) (h2 / 2)));
            Dragger dragger2 = this.dragger;
            if (dragger2 != null) {
                dragger2.setDragDropping(false);
                this.dragger.activate(this.mDragListener, dragCenterPosition, true, getTouchArea());
            }
        }
    }

    private void activeLongExtClickEvent() {
        ImageButton imageButton = this.mLongNextButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = this.mLongCloseButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        View view2 = this.mLongPlayContainer;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        View view3 = this.mTitleContainer;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageButton imageButton3 = this.mBtnVoiceManagement;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this);
        }
        FrameLayout frameLayout = this.mFlytVoiceManagement;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
        FrameLayout frameLayout2 = this.mPureListenBtnLayout;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(this);
        }
        ImageButton imageButton4 = this.mBtnPureListen;
        if (imageButton4 != null) {
            imageButton4.setOnClickListener(this);
        }
    }

    private void activeExtClickEvent() {
        View view2 = this.mNormalPlayView;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    HoverPlayerView.this.clickExpansionPlay();
                }
            });
        }
        View view3 = this.mNormalPauseView;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    HoverPlayerView.this.clickExpansionPlay();
                }
            });
        }
        View view4 = this.mNextView;
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    HoverPlayerView.this.clickExpansionNext();
                }
            });
        }
        View view5 = this.mCloseView;
        if (view5 != null) {
            view5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    HoverPlayerView.this.clickExpansionClose();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void clickExpansionNext() {
        if (TTSRuntime.nextBtnEnabled && this.mHoverEventListener != null) {
            hoverViewUBC(this.mStatisticPageState, "next");
            this.mHoverEventListener.skipToNext();
        }
    }

    /* access modifiers changed from: private */
    public void clickExpansionPlay() {
        if (this.mHoverEventListener != null) {
            hoverViewUBC(this.mStatisticPageState, this.mIsPlaying ? "pause" : "play");
            this.mHoverEventListener.switchPlayPause();
        }
    }

    /* access modifiers changed from: private */
    public void clickExpansionClose() {
        this.mHoverPlayerClickGuide.hideGuideBubble();
        if (this.mHoverEventListener != null) {
            hoverViewUBC(this.mStatisticPageState, "close");
            this.mHoverEventListener.closePlayer();
        }
    }

    public void setNeedMultiViewState(boolean needMultiViewState2) {
        this.needMultiViewState = needMultiViewState2;
    }

    /* access modifiers changed from: private */
    public void showForNovel() {
        float anchorX = this.mOutContainer.getX();
        float anchorY = this.mOutContainer.getY();
        toActiveDragger();
        IHoverView.OnDockListener onDockListener2 = this.onDockListener;
        if (onDockListener2 != null) {
            onDockListener2.onDragToDock((int) anchorX, (int) anchorY);
        }
        IFeedTTSModel ttsModel = TTSRuntime.getInstance().getTTSContext().getSpeechingFeed();
        if (NovelHelper.isNovelSource() && ttsModel != null) {
            setImage(ttsModel.getTtsImageUrl());
        }
        updateUI();
        startWaveAnim();
        syncDragViewStatus();
    }

    public void showByAnimation(androidx.core.util.Pair<Integer, Integer> anchorPair2, Animation animation) {
        if (anchorPair2 != null) {
            if (!useNewHoverExt()) {
                this.mOutContainer.setX((float) ((Integer) anchorPair2.first).intValue());
            }
            this.mOutContainer.setY((float) ((Integer) anchorPair2.second).intValue());
        }
        Dragger dragger2 = this.dragger;
        if (dragger2 != null) {
            dragger2.setDragDropping(true);
        }
        deactivateDragger();
        setVisibility(0);
        this.mOutContainer.setVisibility(0);
        if (animation == null) {
            showForNovel();
            return;
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                HoverPlayerView.this.showForNovel();
                HoverPlayerView.this.mOutContainer.clearAnimation();
                animation.setAnimationListener((Animation.AnimationListener) null);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.mOutContainer.startAnimation(animation);
    }

    public void hideByAnimation(Animation animation) {
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                HoverPlayerView.this.mOutContainer.setVisibility(8);
                HoverPlayerView.this.mOutContainer.clearAnimation();
                HoverPlayerView.this.deactivateDragger();
                HoverPlayerView.this.stopWaveAnim();
                HoverPlayerView.this.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mOutContainer.startAnimation(animation);
    }

    /* access modifiers changed from: private */
    public void deactivateDragger() {
        Dragger dragger2 = this.dragger;
        if (dragger2 != null && dragger2.isActive()) {
            this.dragger.deactivate();
        }
    }

    /* access modifiers changed from: private */
    public void hoverViewUBC(String page, String value) {
        MusicUBCConstant.musicEvent(MusicUBCConstant.UBC_MUSIC_FLOATING_EVENT_ID, MusicUBCConstant.UBC_MUSIC_TYPE_FLOATING_PLA, "floating", page, value, getUBCExt());
    }

    private String getUBCExt() {
        if (!NovelHelper.isNovelSource()) {
            return null;
        }
        try {
            JSONObject ext = new JSONObject();
            IFeedTTSModel ttsModel = TTSRuntime.getInstance().getSpeechingFeed();
            if (ttsModel != null) {
                ext.put("category", ttsModel.getChannelId());
            }
            return ext.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public boolean isOnScreenRightSide() {
        FrameLayout frameLayout = this.mOutContainer;
        if (frameLayout != null && getXOnScreen(frameLayout) >= getScreenWidth() / 3) {
            return true;
        }
        return false;
    }

    private void registerMusicUICallback() {
        IMusic newMusic;
        if ((MediaRuntime.getContext().getMode() != 1 || TTSRuntime.getInstance().getSpeechingFeed() != null) && (newMusic = IMusicFactory.createMusicAdapter(MediaRuntime.getContext().getMode())) != null) {
            IMusic iMusic = this.mIMusic;
            if (!(iMusic == null || iMusic == newMusic)) {
                iMusic.release(false);
            }
            this.mIMusic = newMusic;
            HoverUICallback hoverUICallback = new HoverUICallback();
            this.mUICallback = hoverUICallback;
            this.mIMusic.addCallBack(hoverUICallback);
            this.mIMusic.notifyUI();
        }
    }

    private void unregisterMusicUICallback() {
        IMusicUI iMusicUI;
        IMusic iMusic = this.mIMusic;
        if (iMusic != null && (iMusicUI = this.mUICallback) != null) {
            iMusic.removeCallBack(iMusicUI);
        }
    }

    public void setMaxAndCurrentProgress(int maxProgress, int currentProgress, boolean reset) {
        setPosition(maxProgress, currentProgress);
    }

    /* access modifiers changed from: private */
    public int getScaledNormalSize() {
        return HoverUIUtils.getInnerCircleSize();
    }

    private int getCardScaledNormalSize() {
        return HoverUIUtils.getOutterCircleSize();
    }

    private int getWindowScaledNormalSize() {
        return getCardScaledNormalSize();
    }

    /* access modifiers changed from: private */
    public int getWindowScaledExtSize() {
        return getScaledExtSize();
    }

    public int getHoverLRMargin() {
        return AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.radio_mini_container_margin_left);
    }

    public int getCoverLRPadding() {
        return HoverUIUtils.getCoverLRPadding();
    }

    public boolean useNewHoverExt() {
        return MediaRuntime.getContext().isInAllHoverABTest() && !NovelHelper.isInNovelReaderActivity(BdBoxActivityManager.getRealTopActivity());
    }

    /* access modifiers changed from: private */
    public int getScaledExtSize() {
        if (useNewHoverExt()) {
            return getPadAdaptedWindowWidth() - (AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.radio_mini_container_margin_left) * 2);
        }
        int extSize = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.media_hover_ext_width);
        if (FontSizeHelper.isFontSizeBigger()) {
            extSize += dp2px(10.0f);
        }
        return (int) (((float) extSize) + (((float) (FontSizeHelper.getScaledSize(0, (float) dp2px(17.0f), 2) - dp2px(17.0f))) * 3.0f));
    }

    private int getScaledNovelExtSize() {
        if (useNewHoverExt()) {
            return getScaledExtSize();
        }
        int extSize = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.media_hover_ext_novel_width);
        if (FontSizeHelper.isFontSizeBigger()) {
            extSize += dp2px(10.0f);
        }
        return (int) (((float) extSize) + (((float) (FontSizeHelper.getScaledSize(0, (float) dp2px(17.0f), 2) - dp2px(17.0f))) * 2.0f));
    }

    class HoverUICallback extends MusicUIDefaultImpl {
        HoverUICallback() {
        }

        public void setPreNextEnabled(boolean pre, boolean next) {
            TTSRuntime.nextBtnEnabled = next;
            if (HoverPlayerView.this.mNextView != null) {
                HoverPlayerView.this.mNextView.setEnabled(next);
            }
            if (HoverPlayerView.this.mLongNextButton != null) {
                HoverPlayerView.this.mLongNextButton.setEnabled(next);
            }
        }

        public void setImage(String imgUrl) {
            HoverPlayerView.this.setImage(imgUrl);
        }

        public void setPlayState(MusicPlayState state) {
            MusicPlayState unused = HoverPlayerView.this.mPlayState = state;
            HoverPlayerView.this.startWaveAnim();
        }
    }
}
