package com.baidu.searchbox.feed.refreshex;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.ui.pullrefresh.LoadingAnimView;

public class FloatCapsulesView extends FrameLayout {
    private static final int ANIMATION_DURATION = 80;
    private static final int FAIL_SHOW_DURATION = 5000;
    public static final int STATE_FAIL = 2;
    public static final int STATE_INIT = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_SUCCESS = 3;
    private ObjectAnimator fadeInAnim;
    private ObjectAnimator fadeOutAnim;
    private OnCapsulesAction mCapsulesAction;
    /* access modifiers changed from: private */
    public OnCapsulesClick mCapsulesClick;
    private Context mContext;
    private Runnable mFailRunnable;
    private LinearLayout mFloatCapsules;
    private FrameLayout mFloatContainer;
    private ImageView mFloatIcon;
    private LoadingAnimView mFloatProgressbar;
    private TextView mFloatTips;
    private boolean mLocationBottom;
    /* access modifiers changed from: private */
    public FrameLayout mRoot;
    /* access modifiers changed from: private */
    public int mState;
    private Runnable mSuccessRunnable;

    public interface OnCapsulesAction {
        void onAppear(int i2);

        void onSubside(int i2);
    }

    public interface OnCapsulesClick {
        void onClick();
    }

    public @interface State {
    }

    public FloatCapsulesView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatCapsulesView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatCapsulesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mLocationBottom = false;
        this.mState = 0;
        this.mFailRunnable = new Runnable() {
            public void run() {
                if (FloatCapsulesView.this.mRoot.getVisibility() == 0 && FloatCapsulesView.this.mState == 2) {
                    FloatCapsulesView.this.hideFloatCapsules();
                    FloatCapsulesView.this.onSubside(2);
                }
            }
        };
        this.mSuccessRunnable = new Runnable() {
            public void run() {
                if (FloatCapsulesView.this.mRoot.getVisibility() == 0) {
                    FloatCapsulesView.this.hideFloatCapsules();
                    FloatCapsulesView.this.onSubside(3);
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.feed_float_refresh, this);
        this.mRoot = this;
        setVisibility(8);
        this.mFloatContainer = (FrameLayout) findViewById(R.id.float_container);
        this.mFloatCapsules = (LinearLayout) findViewById(R.id.float_capsules);
        LoadingAnimView loadingAnimView = (LoadingAnimView) findViewById(R.id.float_progressbar);
        this.mFloatProgressbar = loadingAnimView;
        loadingAnimView.setFontSizeChangeEnabled(true);
        if (FeedAbtestManager.isFluencyOptOpen()) {
            this.mFloatProgressbar.setAutoStart(false);
            this.mFloatProgressbar.stopAnim();
        }
        this.mFloatIcon = (ImageView) findViewById(R.id.float_icon);
        this.mFloatTips = (TextView) findViewById(R.id.float_tips);
        updateUI();
        initAnimator();
        this.mFloatCapsules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (FloatCapsulesView.this.mCapsulesClick != null && FloatCapsulesView.this.mState == 2 && FloatCapsulesView.this.mRoot.getVisibility() == 0) {
                    FloatCapsulesView.this.changeState(1);
                    FloatCapsulesView.this.mCapsulesClick.onClick();
                }
            }
        });
    }

    private void initAnimator() {
        if (this.fadeInAnim == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mFloatContainer, "alpha", new float[]{0.0f, 1.0f});
            this.fadeInAnim = ofFloat;
            ofFloat.setDuration(80);
            this.fadeInAnim.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animation) {
                    if (FloatCapsulesView.this.mRoot.getAlpha() != 1.0f) {
                        FloatCapsulesView.this.mRoot.setAlpha(1.0f);
                    }
                    FloatCapsulesView.this.mRoot.setVisibility(0);
                    FloatCapsulesView.this.addLayoutListenerIfNeed();
                }
            });
        }
        if (this.fadeOutAnim == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFloatContainer, "alpha", new float[]{1.0f, 0.0f});
            this.fadeOutAnim = ofFloat2;
            ofFloat2.setDuration(80);
            this.fadeOutAnim.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    FloatCapsulesView.this.mRoot.setVisibility(8);
                    int unused = FloatCapsulesView.this.mState = 0;
                }
            });
        }
    }

    public void showFloatCapsules() {
        ObjectAnimator objectAnimator = this.fadeInAnim;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public void addLayoutListenerIfNeed() {
        if (isLocationBottom()) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!FloatCapsulesView.this.getViewTreeObserver().isAlive() || FloatCapsulesView.this.getVisibility() != 0) {
                        FloatCapsulesView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        FloatCapsulesView.this.requestLayout();
                    }
                }
            });
        }
    }

    public void hideFloatCapsules() {
        ObjectAnimator objectAnimator = this.fadeOutAnim;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public void setLocation(boolean isBottom) {
        this.mLocationBottom = isBottom;
    }

    public boolean isLocationBottom() {
        return this.mLocationBottom;
    }

    public int getState() {
        FeedUtil.refreshLog("getState", "当前浮层状态:" + this.mState);
        return this.mState;
    }

    public void changeState(int state) {
        changeState(state, (String) null);
    }

    public void changeState(int state, String tips) {
        if (this.mState != state) {
            FeedUtil.refreshLog("changeState", "流转浮层状态:" + this.mState + "->" + state);
            this.mState = state;
            updateCapsules(tips);
            removeCallbacks();
            onAppear(this.mState);
            switch (this.mState) {
                case 2:
                    postDelayed(this.mFailRunnable, 5000);
                    return;
                case 3:
                    postDelayed(this.mSuccessRunnable, 0);
                    return;
                default:
                    showFloatCapsules();
                    return;
            }
        }
    }

    public void dismissFailCapsules() {
        removeCallbacks(this.mFailRunnable);
        post(this.mFailRunnable);
    }

    private void removeCallbacks() {
        removeCallbacks(this.mFailRunnable);
        removeCallbacks(this.mSuccessRunnable);
    }

    public void updateUI() {
        int scaleDp13 = (int) FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(R.dimen.dimens_13dp));
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius((float) (((getResources().getDimensionPixelSize(R.dimen.dimens_11dp) * 2) + scaleDp13) / 2));
        drawable.setColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC30));
        this.mFloatCapsules.setBackground(drawable);
        this.mFloatTips.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        this.mFloatProgressbar.setLoadingViewColor(this.mContext.getResources().getColor(R.color.feed_float_loading_color));
        this.mFloatTips.setTextSize(0, FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X055)));
        ImageView imageView = this.mFloatIcon;
        if (!(imageView == null || imageView.getLayoutParams() == null)) {
            this.mFloatIcon.getLayoutParams().width = scaleDp13;
            this.mFloatIcon.getLayoutParams().height = scaleDp13;
        }
        LoadingAnimView loadingAnimView = this.mFloatProgressbar;
        if (!(loadingAnimView == null || loadingAnimView.getLayoutParams() == null)) {
            this.mFloatProgressbar.getLayoutParams().width = scaleDp13;
            this.mFloatProgressbar.getLayoutParams().height = scaleDp13;
        }
        updateCapsules((String) null);
    }

    private void updateCapsules(String tips) {
        switch (this.mState) {
            case 1:
                this.mFloatProgressbar.setVisibility(0);
                this.mFloatProgressbar.startAnim();
                this.mFloatIcon.setVisibility(8);
                this.mFloatTips.setText(tips == null ? RefreshRevolutionary.getRefreshingTip() : tips);
                return;
            case 2:
                this.mFloatProgressbar.setVisibility(8);
                this.mFloatProgressbar.stopAnim();
                this.mFloatIcon.setVisibility(0);
                this.mFloatIcon.setBackground(this.mContext.getResources().getDrawable(R.drawable.feed_float_refresh_fail));
                this.mFloatTips.setText(tips == null ? this.mContext.getString(R.string.feed_refresh_float_error_text) : tips);
                return;
            case 3:
                this.mFloatProgressbar.setVisibility(8);
                this.mFloatProgressbar.stopAnim();
                this.mFloatIcon.setVisibility(0);
                return;
            default:
                this.mFloatProgressbar.setVisibility(0);
                this.mFloatProgressbar.stopAnim();
                this.mFloatIcon.setVisibility(8);
                this.mFloatTips.setText(RefreshRevolutionary.getRefreshingTip());
                return;
        }
    }

    public int getCapsulesMargin() {
        if (TTSRuntime.getInstance().isPlayerShown()) {
            return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.feed_float_bottom_margin_tts);
        }
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.feed_float_bottom_margin_normal);
    }

    public void setClick(OnCapsulesClick click) {
        this.mCapsulesClick = click;
    }

    public void setAction(OnCapsulesAction action) {
        this.mCapsulesAction = action;
    }

    private void onAppear(int state) {
        OnCapsulesAction onCapsulesAction = this.mCapsulesAction;
        if (onCapsulesAction != null) {
            onCapsulesAction.onAppear(state);
        }
    }

    /* access modifiers changed from: private */
    public void onSubside(int state) {
        OnCapsulesAction onCapsulesAction = this.mCapsulesAction;
        if (onCapsulesAction != null) {
            onCapsulesAction.onSubside(state);
        }
    }
}
